require('dotenv').config();
const express = require('express');
const mysql = require('mysql2/promise');
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

// Master
app.ws('/game', function (ws, req) {
    // ... existing code ...
});

// Player - Clients
app.ws('/player', function(ws, req) {
    // ... existing code ...
});

app.listen(port, () => {
    console.log(`Server listening on port ${port}`);
});

// Active Player
let activePlayerIndex = 0;

function changeActivePlayer(){
    // ... existing code ...
}

function updateActivePlayer(activePlayer) {
    // ... existing code ...
}

function getQuestionByCategoryValue(cat, val) {
    // ... existing code ...
}

let magicData = [];

// MySQL Connection
async function readDataFromSQL() {
    console.log('Trying to connect to SQL server');
    try {
        const connection = await mysql.createConnection({
            host: process.env.SQL_SERVER,
            user: process.env.SQL_USER,
            password: process.env.SQL_PASSWORD,
            database: process.env.SQL_DATABASE,
        });

        const [results] = await connection.execute('SELECT * FROM trivia');
        copySQLResultToMagicData(results);
        console.log('Data fetched from SQL and loaded into magicData');
    } catch (err) {
        console.error('Error connecting to SQL server or executing query:', err);
    }
}

function copySQLResultToMagicData(results) {
    magicData = results.map(row => ({
        categoryName: row.category,
        openQuestions: [
            {
                id: row.id,
                label: row.label,
                questionText: row.questionText,
                answers: row.answers.split(','),
            }
        ]
    }));
    console.log('magicData populated:', magicData);
}

async function startServer() {
    try {
        await readDataFromSQL(); // Fetch data from SQL before starting the server
        app.listen(port, () => {
            console.log(`Server listening on port ${port}`);
        });
    } catch (err) {
        console.error('Failed to start server:', err);
        process.exit(1); // Exit the process if the server cannot start
    }
}

startServer();
