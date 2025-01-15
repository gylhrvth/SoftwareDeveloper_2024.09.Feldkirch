
const express = require('express')
const app = express()
const expressWs = require('express-ws')(app);
const port = 3000
allWS = [];

app.use(express.static('public'))

app.ws('/chat', function(ws, req) {
    console.log('Client connected');
    allWS.push(ws);
    // Send data to client

    ws.on('message', (message) => {
        console.log('Received:', String(message));
        let data = JSON.parse(String(message));
        allWS.forEach((client) => {
            if (client !== ws) {
                client.send(JSON.stringify(
                    {
                        user: data.user,
                        message: data.message 
                    }));
            }
        });
    });

    ws.on('close', () => {
        console.log('Client disconnected');
        allWS = allWS.filter((el) => el !== ws);
    });

  });

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})