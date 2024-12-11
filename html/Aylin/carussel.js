let currentIndex = 0; // Başlangıçta ilk resim

const images = document.querySelectorAll('.carousel001 .img'); // Tüm resimleri seç
const totalImages = images.length;
const pictureBlock = document.querySelector('.carousel001');
const imgWidth = 320; // Her bir resmin genişliği + boşluk (300px + 20px)


function plusSlides(value){
    // indexi güncelle
    currentIndex = (currentIndex + value + totalImages) % totalImages;
    console.log('current index:', currentIndex); // Debug için indexi kontrol et

    // Resimleri kaydırmak için gerekli mesafeyi hesapla
    const offset = -(currentIndex * imgWidth); // Resim kaydırma mesafesi (negatif yapıyoruz)
    
    // Kaydırmayı uygula
    pictureBlock.style.transition = 'transform 0.5s ease'; // Kaydırma geçişini animasyonlu yap
    pictureBlock.style.transform = `translateX(${offset}px)`;
}

/*für den Serien-Karussell*/
let currentIndexS = 0;

const imagesS = document.querySelectorAll('.carousel002 .img');
const totalImagesS = images.length - 1;
const pictureBlockS = document.querySelector('.carousel002');


function plusSlidesSerie(value){
    currentIndexS = (currentIndexS + value + totalImagesS) % totalImagesS;
    console.log('current index:', currentIndexS);

    const offsetS = -(currentIndexS * imgWidth);

    pictureBlockS.style.transition = 'transform 0.5s ease';
    pictureBlockS.style.transform = `translateX(${offsetS}px)`;
}

/*für den Netflix Orginal-Karussell*/
let currentIndexOrigin = 0;

const imagesOrigin = document.querySelectorAll('.carousel003 .img');
const totalImagesOrigin = images.length - 1;
const pictureBlockOrigin = document.querySelector('.carousel003');

function plusSlidesOrigin(value){
    currentIndexOrigin = (currentIndexOrigin + value + totalImagesOrigin) % totalImagesOrigin;
    console.log('current index:', currentIndexOrigin);

    const offsetOrigin = -(currentIndexOrigin * imgWidth);

    pictureBlockOrigin.style.transition = 'transform 0.5s ease';
    pictureBlockOrigin.style.transform = `translateX(${offsetOrigin}px)`;
}

/*für den Horror Movies-Karussell*/
let currentIndexHorror = 0;

const imagesHorror = document.querySelectorAll('.carousel004 .img');
const totalImagesHorror = images.length - 1;
const pictureBlockHorror = document.querySelector('.carousel004');

function plusSlidesHorror(value){
    currentIndexHorror = (currentIndexHorror + value + totalImagesHorror) % totalImagesHorror;
    console.log('current index:', currentIndexHorror);

    const offsetHorror = -(currentIndexHorror * imgWidth);

    pictureBlockHorror.style.transition = 'transform 0.5s ease';
    pictureBlockHorror.style.transform = `translateX(${offsetHorror}px)`;
}

