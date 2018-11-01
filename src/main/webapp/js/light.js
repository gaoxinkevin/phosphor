lightPoint = () => {
    document.body.style.overflowX = "hidden";
    document.body.style.overflowY = "hidden";
    let div1 = document.getElementById("dialog");
    let div2 = document.getElementById("v-modal");
    div1.style.display = "block";
    div2.style.display = "block";
    let img = document.getElementById("image");
    img.setAttribute("src", "/images/light1.png");
};
turnOnOrOff = () => {
    let img = document.getElementById("image");
    if (img.getAttribute("src") === "/images/light1.png") {
        img.setAttribute("src", "/images/light0.png");
    } else if (img.getAttribute("src") === "/images/light0.png") {
        img.setAttribute("src", "/images/light1.png");
    }
};
closeLight = () => {
    document.body.style.overflowX = "auto";
    document.body.style.overflowY = "auto";
    let div1 = document.getElementById("dialog");
    let div2 = document.getElementById("v-modal");
    div1.style.display = "none";
    div2.style.display = "none";
}