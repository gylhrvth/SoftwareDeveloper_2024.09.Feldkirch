require('dotenv').config()
const express = require('express')
const mysql = require('mysql2/promise')

const app = express()

if (process.env.PORT === undefined) {
    console.error('!!! ATTENTION !!!')
    console.error('.env file is missing or incomplete. Please controll the .env file')
    console.error('PORT=3000')
    console.error('SQL_SEVER=loclahost')
    console.error('...')
    process.exit(1)
}

app.use(express.static('public'))

async function readDataFromSQL() {
    console.log('trying to connect to SQL server')
    const connection = await mysql.createConnection({
        host: process.env.SQL_SERVER,
        user: process.env.SQL_USER,
        password: process.env.SQL_PASSWORD,
        database: process.env.SQL_DATABASE,
    });
    
    try {
        const statement = await connection.prepare(' \
            SELECT city.* \
            FROM city \
            JOIN country on city.country = country.code \
            WHERE country.name = ? \
        ');
        const [results, fields] = await statement.execute(['Austria']);
        copySQLResultinMagicData(results)
        //console.log(results); // results contains rows returned by server
        //console.log(fields); // fields contains extra meta data about results, if available
      } catch (err) {
        console.log(err);
      }
}

function copySQLResultinMagicData(results){
    console.log('copySQLResultinMagicData', results)
}

app.listen(process.env.PORT, () => {    
    console.log(`Example app listening on port ${process.env.PORT}`)
})

readDataFromSQL()