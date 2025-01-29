const questionM1 = [
    "Wer ist die Sängerin von 'Hello' und 'Someone Like You'?", 
    "Welches Musikinstrument hat Saiten und wird oft mit einem Bogen gespielt?", 
    "Welcher Popstar sang das Lied 'Thriller'?", 
    "Wie nennt man die Sängerin, die 'Bad Romance' und 'Poker Face' gesungen hat?",
    "Wie nennt man eine Gruppe von Musikern, die zusammen spielen?"
];

//URL
function selectCategory(category, points) {
    let randomIndexM1 = Math.floor(Math.random() * questionM1.length);
    let randomQuestionM1 = questionM1[randomIndexM1];
    
    const url = `question.html?category=${encodeURIComponent(category)}&points=${points}&question=${encodeURIComponent(randomQuestionM1)}`;
    window.location.href = url;  // Navigate to question.html with the parameters
}