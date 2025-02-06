const express = require('express');
const app = express();
const expressWs = require('express-ws')(app);
const port = 5400;

let gameMaster = null;
let playerWS = [];
let magicData = [];

let gameState = {
    maxPlayers: 4,
    currentPlayers: 0,
};

// Trivia
let activeTriviaSocket = null;

app.use(express.static('public'));

const mysql = require('mysql2/promise');
require('dotenv').config();

async function readDataFromSQL() {
    try {
        console.log('Trying to connect to SQL server...');
        const connection = await mysql.createConnection({
            host: process.env.SQL_SERVER,
            user: process.env.SQL_USER,
            password: process.env.SQL_PASSWORD,
            database: process.env.SQL_DATABASE,
        });
        console.log('Connected to SQL server.');
        const [rows] = await connection.query(`
            SELECT Questions.category, Questions.value, Questions.question, Questions.answerA, Questions.answerB, Questions.answerC, Questions.answerD
            FROM
            (
                SELECT *, RANK() OVER (PARTITION BY category, value ORDER BY RAND()) QuestionRank FROM Trivia
            ) Questions
            JOIN
            (
                SELECT *, RANK() OVER (ORDER BY category='Musik' DESC, RAND() ASC) CategoryRank
                FROM (select distinct category from Trivia) CategoryList
            ) Category ON Category.category = Questions.category
            WHERE CategoryRank <= 2 AND QuestionRank = 1`);
        console.log('Test-Query Result:', rows);
        await connection.end();
        console.log('Connection closed.');

        // Transform the query result into the required format
        magicData = transformData(rows);

    } catch (error) {
        console.error('Error connecting to SQL server:', error);
    }
}

function transformData(rows) {
    const data = {};
    rows.forEach(row => {
        if (!data[row.category]) {
            data[row.category] = [];
        }
        const answerLabels = [row.answerA, row.answerB, row.answerC, row.answerD].map((answer, index) => `Answer ${String.fromCharCode(65 + index)}: ${answer}`);
        data[row.category].push({
            id: `${row.category[0].toLowerCase()}${row.value}`,
            label: `${row.value}`,
            questionText: row.question,
            answers: answerLabels,
        });
    });

    return Object.keys(data).map(categoryName => ({
        categoryName,
        openQuestions: data[categoryName],
    }));
}

readDataFromSQL(); // Populate magicData with data from SQL

//Master
app.ws('/game', function (ws, req) {
    activeTriviaSocket = ws;

    if (gameMaster != null) {
        console.log('There is already a Game Master!');
        ws.close(1000, 'There is already a Game Master!');
    } else {
        console.log('New Game Master connected!');
        gameMaster = ws;
        gameMaster.send(JSON.stringify({
            messageType: 'gameState',
            gameState: gameState
        }));

        // Send categories to the game master
        gameMaster.send(
            JSON.stringify({
                messageType: 'showCategories',
                categories: magicData,
            })
        );
        
        if (gameState.gameStarted){
            updateActivePlayer()
        }
    }

    ws.on('message', (message) => {
        const data = JSON.parse(message);
        console.log('Server received ACTION', data.action)

        if (data.action === 'startGame') {
            if (playerWS.length >= 2 && playerWS.length <= 4) {
                gameState.gameStarted = true;
                gameState.currentPlayers = playerWS.length;

                //startActivePlayerCycle();
                updateActivePlayer(playerWS[activePlayerIndex]);

                broadcastToPlayers({
                    messageType: 'gameStarted',
                    message: 'The game has started!',
                });
            } else {
                gameMaster.send(
                    JSON.stringify({
                        messageType: 'error',
                        message: 'Too many players to start the game.',
                    })
                );
            }
        }
        else if (data.action === 'getGameState') {
            const gameState = {
                players: playerWS.map((player) => player.name),
                currentPlayer: activePlayerIndex
            };
            ws.send(JSON.stringify({
                messageType: 'gameState',
                gameState: gameState
            }));
        } else if (data.action === 'selectCategory') {
            console.log('send questions to MASTER....', data)
            let q = getQuestionByCategoryValue(data.category, data.value)
    
            q.then(questionData => {
                ws.send(JSON.stringify({
                    messageType: 'question',
                    questionText: questionData.questionText,
                    questionCategory: data.category,
                    questionValue: data.value
                }));
                console.log('send possible answers to', playerWS[activePlayerIndex].name)
                playerWS[activePlayerIndex].ws.send(JSON.stringify({
                    messageType: 'possibleAnswers',
                    answers: questionData.answers
                }));
            });
        } else {
            console.log('Unknown action from MASTER:', data.action, data);
        }
    });
    ws.on('close', () => {
        console.log('Game Master disconnected.');
        gameMaster = null;
    });
});

function broadcastToPlayers(message) {
    playerWS.forEach((player, index) => {
        const isActivePlayer = index === activePlayerIndex;

        const playerMessage = {
            ...message,
            messageType: isActivePlayer ? 'yourTurn' : 'otherPlayerTurn',
            message: isActivePlayer
                ? "Your turn"
                : `${playerWS[activePlayerIndex]?.name || 'Unknown'}'s turn`,
        };
        player.ws.send(JSON.stringify(playerMessage));
    });
}

// Player - Clients
app.ws('/player', function(ws, req) {
    if (gameState.gameStarted) {
        console.log('Game already started! Cannot join.');
        ws.send(JSON.stringify({
            messageType: 'error',
            message: 'The game has already started. Cannot join the game.',
        }));
        ws.close(1000, 'Game already started');
        return;
    }
    
    if(playerWS.length > 4) {
        console.log('Maximum player limit reached!');
        ws.send(JSON.stringify({
            messageType: 'error',
            message: 'Maximum player limit reached. Cannot join the game.',
        }));
        ws.close(1000, 'Maximum player limit reached');
        return;
    }
    console.log('Player connected');
    playerWS.push({ ws: ws, name: null });

    ws.on('message', (message) => {
        const data = JSON.parse(message);

        if (data.action === 'registerPlayer') {
            const playerName = data.playerName;

            if (playerName) {
                const existingPlayer = playerWS.find(player => player.ws === ws && player.name === playerName);
                if (!existingPlayer) {
                    const player = { ws: ws, name: playerName };
                    playerWS = playerWS.filter(p => p.ws !== ws);
                    playerWS.push(player);
                }
            
                console.log('Player registered:', playerName);

                if (gameMaster) {
                    gameMaster.send(
                        JSON.stringify({
                            messageType: 'newPlayer',
                            message: `${playerName} has joined.`,
                            currentPlayers: playerWS.filter(p => p.name).length,
                            playerNames: playerWS.map((player) => player.name).filter(Boolean),
                        })
                    );
                }
            }
        }

        else if (data.action === 'answer') {
            console.log(`${playerWS[activePlayerIndex].name} answered the question. Returning back to the Categories.`);

            setTimeout(() => {
                changeActivePlayer();
            }, 5000);
        }else {
            console.log('Unknown action from PLAYER:', data.action, data);
        }
    });


    ws.on('close', () => {
        const disconnectedPlayer = playerWS.find((player) => player.ws === ws);

        if (disconnectedPlayer) {
            console.log(`Player disconnected: ${disconnectedPlayer.name}`);
            playerWS = playerWS.filter((player) => player.ws !== ws);

            if (gameMaster) {
                gameMaster.send(
                    JSON.stringify({
                        messageType: 'playerDisconnected',
                        message: `${disconnectedPlayer.name} has left the game.`,
                        currentPlayers: playerWS.length,
                        playerNames: playerWS.map((player) => player.name),
                    })
                );
            }  
        }
    });
});

app.listen(port, () => {
    console.log(`Server listening on port ${port}`);
});

// Active Player
let activePlayerIndex = 0;

function changeActivePlayer(){
    if (playerWS.length === 0) return;

    activePlayerIndex = (activePlayerIndex + 1) % playerWS.length;
    const activePlayer = playerWS[activePlayerIndex];

    updateActivePlayer(activePlayer)
}

function updateActivePlayer(activePlayer) {

    broadcastToPlayers({
        activePlayerName: activePlayer.name,
    });

    if (gameMaster) {
        gameMaster.send(
            JSON.stringify({
                messageType: 'activePlayer',
                playerName: activePlayer.name,
            })
        );

        gameMaster.send(
            JSON.stringify({
                messageType: 'showCategories',
                categories: magicData,
            })
        );
    }
    console.log(`Active Player: ${activePlayer.name}`);
}

async function getQuestionByCategoryValue(cat, val) {
    try {
        const connection = await mysql.createConnection({
            host: process.env.SQL_SERVER,
            user: process.env.SQL_USER,
            password: process.env.SQL_PASSWORD,
            database: process.env.SQL_DATABASE,
        });
        const [rows] = await connection.query(`
            SELECT question, answerA, answerB, answerC, answerD
            FROM Trivia
            WHERE category = ? AND value = ?
        `, [cat, val]);
        
        await connection.end();

        if (rows.length > 0) {
            return {
                questionText: rows[0].question,
                answers: [rows[0].answerA, rows[0].answerB, rows[0].answerC, rows[0].answerD].map((answer, index) => `${answer}`), 
            };
        }
    } catch (error) {
        console.error('Error querying the database:', error);
        return {
            questionText: 'Error retrieving question.',
            answers: []
        };
    }
}
readDataFromSQL();