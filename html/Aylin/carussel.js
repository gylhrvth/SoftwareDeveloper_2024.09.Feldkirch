let currentIndex = 0; // Başlangıçta ilk resim

const images = document.querySelectorAll('.carousel001 .img'); // Tüm resimleri seç
const totalImages = images.length;
const pictureBlock = document.querySelector('.carousel001');
const imgWidth = 320; // Her bir resmin genişliği + boşluk (300px + 20px)


function plusSlides(value){
    currentIndex = (currentIndex + totalImages + value) % (totalImages -1)
    console.log('current ındex', currentIndex)
    const offset = -(currentIndex * imgWidth); // Resimleri kaydırma mesafesi
    pictureBlock.style.transform = `translateX(${offset}px)`; // Resimleri kaydır
}

