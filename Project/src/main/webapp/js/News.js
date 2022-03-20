const mainImage = document.getElementsByClassName("main_img");
const subImage = document.getElementsByClassName("sub_img");
const imgSum = document.getElementsByClassName("text_over")
const main_article = document.getElementById("main_article");
const article = document.getElementsByClassName("article");

function imageChanging(num) {
    subImage[num].setAttribute("style",`border: 3px solid black;`);
    let imageSrc = subImage[num].getAttribute("src");
    mainImage[0].setAttribute("src", `${imageSrc}`);
    let summaryText = imgSum[num+1].innerHTML;
    imgSum[0].innerHTML = `${summaryText}`;
    let aHref = article[num].getAttribute("href");
    main_article.setAttribute("href", `${aHref}`);
}

function imageUnbordering(num) {
    subImage[num].setAttribute("style",`border: 0;`);
}