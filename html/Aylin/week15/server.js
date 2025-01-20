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

app.use(express.static('public'));

app.ws('/game', function (ws, req) {
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
    }

    ws.on('message', (message) => {
        const data = JSON.parse(message);

        if (data.action === 'startGame') {
            if (playerWS.length >= 2 && playerWS.length <= 4) {
                gameState.gameStarted = true;

                broadcastToPlayers({
                    type: 'gameStarted',
                    message: 'The game has started!',
                });

                updateActivePlayer();
            } else {
                gameMaster.send(
                    JSON.stringify({
                        messageType: 'error',
                        message: 'Too many players to start the game.',
                    })
                );
            }
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
            type: isActivePlayer ? 'yourTurn' : 'otherPlayerTurn',
            message: isActivePlayer
                ? "Your turn"
                : `${playerWS[activePlayerIndex]?.name || 'Unknown'}'s turn`,
        };
        player.ws.send(JSON.stringify(playerMessage));
    });
}

// Player - Clients
app.ws('/player', function(ws, req) {
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

function updateActivePlayer() {
    if (playerWS.length === 0) return;

    activePlayerIndex = (activePlayerIndex + 1) % playerWS.length;
    const activePlayer = playerWS[activePlayerIndex];

    broadcastToPlayers({
        activePlayerName: activePlayer.name,
    });

    if (activeTriviaSocket) {
        activeTriviaSocket.send(
            JSON.stringify({
                type: 'activePlayer',
                playerName: activePlayer.name,
            })
        );
    }

    if (gameMaster) {
        gameMaster.send(
            JSON.stringify({
                messageType: 'activePlayer',
                playerName: activePlayer.name,
            })
        );
    }
    console.log(`Active Player: ${activePlayer.name}`);
}

setInterval(updateActivePlayer, 10000);

// Trivia 
let activeTriviaSocket = null;

app.ws('/trivia', function(ws, req) {
    console.log('Trivia WebSocket connection established');
    activeTriviaSocket = ws;

    ws.on('message', (message) => {
        const data = JSON.parse(message);

        if (data.action === 'getGameState') {
            const gameState = {
                players: playerWS.map((player) => player.name),
                currentPlayers: activePlayerIndex
            };
            ws.send(JSON.stringify({
                type: 'gameState',
                gameState: gameState
            }));
        }
    });

    ws.on('close', () => {
        console.log('Trivia WebSocket connection closed');
    });

    ws.on('error', (err) => {
        console.error('WebSocket error:', err);
    });
});