const express = require('express')
const mysql = require('mysql2/promise')
require('dotenv').config()

const app = express()
const port = 5400
let connection = null

app.use(express.static('public'));

app.get('/api/test', async function(req, res) {
    let results = null
    try {
        if (connection === null) {
            await connectToDatabase()
        }
        [results] = await connection.query(
          'SELECT * FROM `country` WHERE `name` like "A%"'
        );
    } catch (err) {
        console.log(err);
    }


    res.json({message: 'Hello World!',
        data: results
    });
});

app.post('/api/message', (req, res) =>{
    const { message } = req.body;
    res.json({message:`You sent: ${message}`});
});

app.listen(port, function () {
    console.log(`Example app listening on port ${port}!`);
  });

async function connectToDatabase() {
    connection = await mysql.createConnection({
        host: process.env.SQL_SERVER,
        user: process.env.SQL_USER,
        password: process.env.SQL_PASSWORD,
        database: process.env.SQL_DATABASE,
      })
}
