//countdown
let counter = 15;
const progressBar = document.getElementById("progress");
const countdownElement = document.getElementById("countdown");

let countdownInterval = setInterval(() => {
    countdownElement.innerHTML = counter;
    progressBar.style.width = ((counter - 1) / 15) * 100 + "%";
    if(counter === 0){
        progressBar.style.width = "0%";
        countdownElement.innerHTML = "Time is up!";
        clearInterval(countdownInterval);
    }
    counter--;
}, 1000);

