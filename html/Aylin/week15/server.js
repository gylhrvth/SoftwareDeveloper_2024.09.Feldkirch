const express = require('express')
const app = express()
const expressWs = require('express-ws')(app);
const port = 5040
let gameMaster = null;
let playerWS = [];

let gameState = {
    maxPlayers: 4,
    currentPlayers: 0,
}

app.use(express.static('public'))

app.ws('/game', function(ws, req) {
    if(gameMaster != null) {
        console.log('There is already a Game Master!');
        ws.close(1000, 'There is already a Game Master!');
    }else {
        console.log('New Game Master connected!');
        gameMaster = ws;
        gameMaster.send(JSON.stringify({
            messageType: 'gameState',
            gameState: gameState
        })
        );
    }

    ws.on('message', (message) => {
        console.log('Message from Game Master:', message);
        const data = JSON.parse(message);

        if (data.action === 'startGame') {
            if (playerWS.length >= 2 && playerWS.length <= 4) {
                broadcastToPlayers({
                    messageType: 'startGame',
                    message: 'The game has started!',
                });
            } else {
                gameMaster.send(
                    JSON.stringify({
                        messageType: 'error',
                        message: 'Not enough players to start the game.',
                    })
                );
            }
        }
    });

    ws.on('close', () => {
        if(gameMaster == ws) {
            console.log('Master has disconnected!');
            gameMaster = null;
        }
    })
})

//Player - Clients
app.ws('/player', function(ws, req) {
    console.log('Player connected');
    playerWS.push(ws);
    gameState.currentPlayers = playerWS.length;

    if(gameMaster){
        gameMaster.send(JSON.stringify({
            messageType: 'newPlayer',
            message: 'A new player has joined the game.',
            currentPlayers: gameState.currentPlayers,
            })
        );
    }

    ws.on('message', (message) => {
        console.log('Received:', String(message));
        let data = JSON.parse(String(message));
        playerWS.forEach((player) => {
            if(player !== ws) {
                player.send(JSON.stringify(
                    {
                        user: data.user,
                        message: data.message
                    }
                ));
            }
            
        });
    })

    ws.on('close', () => {
        console.log('Player disconnected');
        playerWS = playerWS.filter((el) => el !== ws);
    })


})

app.listen(port, () => {
    console.log(`Server listening on port ${port}`);
});