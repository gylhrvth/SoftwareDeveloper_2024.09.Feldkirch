let randomNum = 0;
let aiMove = '';
let result = '';

let score = JSON.parse(localStorage.getItem('Score'))

if (score === null) {
    score = {
        wins: 0,
        losses: 0,
        ties: 0,
    }
}

updateScoreDisplay();

function playGame(playerMove) {
    aiMove = computerMove();
    result = '';

    if (playerMove === 'rock') {
        if (aiMove === 'rock') {
            result = 'Tie';
        } else if (aiMove === 'paper') {
            result = 'You lose.';
        } else if (aiMove === 'scissors') {
            result = 'You win.';
        }
    } else if (playerMove === 'paper') {
        if (aiMove === 'rock') {
            result = 'You win.';
        } else if (aiMove === 'paper') {
            result = 'Tie.';
        } else if (aiMove === 'scissors') {
            result = 'You lose.';
        }
    } else if (playerMove === 'scissors') {
        if (aiMove === 'rock') {
            result = 'You lose.';
        } else if (aiMove === 'paper') {
            result = 'You win.';
        } else if (aiMove === 'scissors') {
            result = 'Tie.';
        }
    }

    if (result === 'You win.') {
        score.wins += 1;
    } else if (result === 'You lose.') {
        score.losses += 1;
    } else if (result === 'Tie.') {
        score.ties += 1;
    }

    localStorage.setItem('Score', JSON.stringify(score));

    updateScoreDisplay();
    displayMoves(playerMove, aiMove);
    displayResult(result);
}

function computerMove() {
    randomNum = Math.floor(Math.random() * 3);
    if (randomNum === 0) {
        aiMove = 'rock';
    } else if (randomNum === 1) {
        aiMove = 'paper';
    } else if (randomNum === 2) {
        aiMove = 'scissors';
    }

    console.log(aiMove + randomNum);
    return aiMove;
}

function resetScore() {
    score.wins = 0;
    score.losses = 0;
    score.ties = 0;

    localStorage.removeItem('Score');
    updateScoreDisplay();
    document.querySelector('.js-move').innerHTML = '';
    document.querySelector('.js-result').innerHTML = '';
}

function updateScoreDisplay() {
    document.querySelector('.js-score').innerHTML =
        `Wins: ${score.wins}
Losses: ${score.losses}
Ties: ${score.ties}`;
}

function displayMoves(playerMove, aiMove) {
    document.querySelector('.js-move').innerHTML = `You picked ${playerMove} < > The computer picked ${aiMove}.`
}

function displayResult(result) {
    document.querySelector('.js-result').innerHTML = `${result}`
}