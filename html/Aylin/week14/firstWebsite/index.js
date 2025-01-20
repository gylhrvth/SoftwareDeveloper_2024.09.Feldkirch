const express = require('express')
const app = express()
const port = 3000

app.use(express.static('public'))

let aylinAge = 25

app.get('/api/test', function (req, res) {
    ++aylinAge
    const result = {
        name: 'Aylin',
        age: aylinAge
    }

  res.json(result)
})


app.listen(port, () => {
    console.log(`Example app listening on port ${port}`)
  })