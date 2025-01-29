const express = require('express');
const app = express();
const expressWs = require('express-ws')(app);
const port = 5400;

let gameMaster = null;
let playerWS = [];

let gameState = {
    maxPlayers: 4,
    currentPlayers: 0,
};
// Trivia
let activeTriviaSocket = null;

app.use(express.static('public'));

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
        }

        else if (data.action === 'selectCategory') {
            console.log('send questions to MASTER....')
            ws.send(JSON.stringify({
                messageType: 'question',
                questionText: 'Who are you?'
            }));
            console.log('send possible answers to', playerWS[activePlayerIndex].name)
            playerWS[activePlayerIndex].ws.send(JSON.stringify({
                messageType: 'possibleAnswers',
                answers: ['A', 'B', 'C', 'D']
            }));
        }

        else {
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
        }

        else {
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
let activePlayerCycle = null;

/*
function startActivePlayerCycle() {
    if (activePlayerCycle) {
        clearInterval(activePlayerCycle);
    }
    changeActivePlayer();
    activePlayerCycle = setInterval(changeActivePlayer, 10000);
}
*/

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


const magicData = [
    {
        categoryName: 'Musik',
        openQuestions: [
            {
                id: 'm100',
                label: '100'
            },
            {
                id: 'm200',
                label: '200'
            },
        ]
    },
    {
        categoryName: 'Geschichte',
        openQuestions: [
            {
                id: 'g100',
                label: '100'
            },
            {
                id: 'g200',
                label: '200'
            },
        ]
    },
    {
        categoryName: 'Serie',
        openQuestions: [
            {
                id: 's100',
                label: '100'
            },
            {
                id: 's200',
                label: '200'
            },
            {
                id: 's300',
                label: '300'
            },
        ]
    }
]
