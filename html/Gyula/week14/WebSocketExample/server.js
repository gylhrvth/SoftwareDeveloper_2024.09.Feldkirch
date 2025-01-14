// filepath: /path/to/server.js
const WebSocket = require('ws');

const wss = new WebSocket.Server({ port: 8080 });
allWS = [];

wss.on('connection', (ws) => {
    console.log('Client connected');
    allWS.push(ws);
    // Send data to client

    ws.on('message', (message) => {
        console.log('Received:', String(message));
        let data = JSON.parse(String(message));
        allWS.forEach((client) => {
            if (client !== ws) {
                client.send(JSON.stringify({ message: data.message }));
            }
        });
    });

    ws.on('close', () => {
        console.log('Client disconnected');
        allWS = allWS.filter((el) => el !== ws);
    });
});

console.log('WebSocket server is running on ws://localhost:8080');