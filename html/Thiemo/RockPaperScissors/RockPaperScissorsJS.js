

let randomNum = 0;
let aiMove = '';
let result = '';

// const score = {
//     Wins: 0,
//     Looses: 0,
//     Ties: 0,
// }
let score = JSON.parse(localStorage.getItem('Score'));

if (score === null) {
    score = {
        Wins: 0,
        Looses: 0,
        Ties: 0,
    };
}

updateScoreDisplay();

function playGame(playerMove) {



    aiMove = computerMove();
    result = '';

    if (playerMove === 'Rock') {
        if (aiMove === 'Rock') {
            result = 'Tie'
        } else if (aiMove === 'Paper') {
            result = 'Loose'
        } else {
            result = 'Win'
        }
    }
    else if (playerMove === 'Paper') {
        if (aiMove === 'Paper') {
            result = 'Tie'
        } else if (aiMove === 'Scissors') {
            result = 'Loose'
        } else {
            result = 'Win'
        }
    }
    else {
        if (aiMove === 'Scissors') {
            result = 'Tie'
        } else if (aiMove === 'Paper') {
            result = 'Loose'
        } else {
            result = 'Win'
        }
    }
    if (result === 'Win') {
        score.Wins += 1;
    } else if (result === 'Loose') {
        score.Looses += 1;
    } else { score.Ties += 1; }

    localStorage.setItem('Score', JSON.stringify(score));

    updateScoreDisplay();
console.log('result'+ result);
    displayMoves(playerMove, aiMove);
    displayResult(result);



    // alertMessage(aiMove, playerMove, result)
}

function computerMove() {
    randomNum = Math.floor(Math.random() * 3);

    if (randomNum === 0) {
        aiMove = 'Rock';
    }

    else if (randomNum === 1) {
        aiMove = 'Paper';
    }

    else { aiMove = 'Scissors'; }

    console.log('AI ' + aiMove + ' RandomNum ' + randomNum)


    return aiMove;
}

// function alertMessage(aiMove, playerMove, result) {
//     alert(`the AI picked ${aiMove}.
//  u picked ${playerMove}.
//  the result is ${result}

//  Wins: ${score.Wins}
//  Looses: ${score.Looses}
//  Ties: ${score.Ties}
//  `);
// }

function resetScore() {
    score.Wins = 0;
    score.Looses = 0;
    score.Ties = 0;
    localStorage.removeItem('Score')

    updateScoreDisplay();

    document.querySelector('js-move').innerHTML = '';
    document.querySelector('js-result').innerHTML = '';
}

function updateScoreDisplay() {
    document.querySelector('.js-score').innerHTML =
        `Wins: ${score.Wins}
    Looses: ${score.Looses}
    Ties: ${score.Ties}`;
}

function displayMoves(playerMove, aiMove) {
    document.querySelector('.js-move').innerHTML = `You Choose${playerMove} < > ${aiMove} is what pc picked.`;
}

function displayResult(result) {
    document.querySelector('.js-result').innerHTML = `${result}`;

}



