
let a = localStorage.getItem("userLoginPhone");
if (a === null) {
    localStorage.clear();
    window.location.href = "http://localhost:1250/indexUi/returnIndexPage"
}


const clientUrl = 'http://localhost:1250/parent/parentImgUrl';
const clientMethod = 'POST';
const getParentImg = (url) => {
    return new Promise((resolve, reject) => {
        const client = new XMLHttpRequest();
        client.open(clientMethod, url);
        client.responseType = 'json';
        client.onreadystatechange = () => {
            if (client.readyState === 4) {
                if (client.status === 200) {
                    resolve(client.response);
                } else {
                    reject(client.status);
                }
            }
        };
        client.send();
    });
};
const JsonResponseList = () => getParentImg(clientUrl);

JsonResponseList().then((res) => {
    const imgSrc = document.getElementById("avatarImg");
    imgSrc.src = res.data;
    document.getElementById("preloader").style.display="none";
    document.getElementById("imgLoading").style.display="none";
}).catch(error => {
    console.log(error);
});

loginOut = () => {
    window.localStorage.clear();
    window.location.href = "http://localhost:1250/indexUi/returnIndexPage";
};
