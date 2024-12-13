let randomNum = 0;
let aiMove = '';
let result = '';

let score = JSON.parse(localStorage.getItem('Score'));

if (score === null){
    score = {
        wins: 0,
        looses: 0,
        ties: 0,
    
    };
}

updateScoreDisplay();



/*const score = {
    wins: 0,
    looses: 0,
    ties: 0,

}*/

function playGame(playerMove){
    aiMove = computerMove();

    if (playerMove === 'rock'){
    if(aiMove ==='Rock'){
        result = 'Tie'
       }else if(aiMove === 'paper'){
        result ='You Win'
       }else{
        result ='You Lose'
       }
    } 
     else if (playerMove === 'paper'){
        if(aiMove ==='Rock'){
            result = 'You Win'
           }else if(aiMove === 'paper'){
            result ='Tie'
           }else{
            result ='You Lose'
           }
       } 
        else if (playerMove === 'scissor'){
        if(aiMove ==='Rock'){
            result = 'You Lose'
           }else if(aiMove === 'paper'){
            result ='You Win'
           }else{
            result ='Tie'
           }
       }

       if (result === 'You Win'){
        score.wins +=1;
       }else if (result === 'You Lose'){
        score.looses +=1;
       }else if (result === 'Tie'){
        score.ties +=1;
       }

       localStorage.setItem('Score', JSON.stringify(score));

       updateScoreDisplay();
       displayMoves(playerMove,aiMove);
       displayResult(result);


      // alertMessage(aiMove,playerMove,result)

}

function computerMove(){
    randomNum = Math.random();
    if(randomNum >=0 && randomNum <1/3){
        aiMove ='Rock'
       }else if(randomNum >= 1/3 && randomNum <2/3){
        aiMove ='Paper'
       }else if(randomNum >=2/3 && randomNum <1){
        aiMove ='Scissors'
       }
       //console.log(aiMove+randomNum);
       return aiMove;
}

function alertMessage(aiMove, playerMove, result){
    alert(`
        The Computer picked ${aiMove}.
        
        You picked ${playerMove}.

        The result is ${result}
        Wins: ${score.wins}
        Losses: ${score.looses}
        Ties: ${score.ties}
        `);

}

function resetScore(){
    score.wins = 0;
    score.looses = 0;
    score.ties = 0;

    localStorage.removeItem('Score');

    updateScoreDisplay();

    document.querySelector('.js-move'.innerHTML = '');
    document.querySelector('.js-result'.innerHTML = '');
}

function updateScoreDisplay() {
    document.querySelector('.js-score').innerHTML =
    `Wins: ${score.wins}
    Losses: ${score.looses}
    Ties: ${score.ties}
    `
}

function displayMoves(playerMove, aiMove){
    document.querySelector('.js-move').innerHTML = `You choosse ${playerMove} < > ${aiMove} is what the computer pick. `
}

function displayResult(result){
    document.querySelector('.js-result').innerHTML = `${result}`
}

