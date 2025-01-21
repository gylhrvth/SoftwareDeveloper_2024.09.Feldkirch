//categorie and points
const urlParams = new URLSearchParams(window.location.search);
const category = urlParams.get('category');
const points = urlParams.get('points');
const question = urlParams.get('question');

document.getElementById('category').innerText = category;
document.getElementById('question-value').innerText =points;
document.getElementById('question').innerText = question;
