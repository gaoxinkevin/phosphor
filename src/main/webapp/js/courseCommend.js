function getCommendCourseList() {
    let request = null;
    if(window.XMLHttpRequest)
        request = new XMLHttpRequest();
    else
        request = new ActiveXObject('Microsoft.XMLHTTP');

    request.open("GET", "/course/getCommendCourseList", true);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
    request.send(null);

    request.onreadystatechange = function () {
        if(request.readyState == 4){
            if(request.status >= 200 && request.status<300 || request.status == 304)
                loadCourseList(request.responseText);
        }
    }
}

/**
 * 解析JSON，并且装入到DOM中返回
 * @param courseInfoListJson
 */
function generateDiv(courseInfo) {
    let divGrid = document.createElement("div");
    divGrid.classList.add("col-md-3");
    let divBox = document.createElement("div");
    divBox.classList.add("course-box", "shop-wrapper");
    let divImage = document.createElement("div");
    divImage.classList.add("image-wrap", "entry");

    let imageGroup = document.createElement("img");
    imageGroup.setAttribute("src", "/upload/kidcoding.jpg");
    imageGroup.setAttribute("alt", "");
    imageGroup.classList.add("img-responsive");

    divImage.appendChild(imageGroup);
    divBox.appendChild(divImage);

    let divDetails = document.createElement("div");
    divDetails.classList.add("course-details", "shop-box", "text-center");
    let hFour = document.createElement("h4");
    let aMid = document.createElement("a");
    aMid.setAttribute("href","http://localhost:1250/courseUi/courseInfoUi/" + courseInfo.courseId);
    aMid.innerText = courseInfo.courseName;
    let company = document.createElement("small");
    company.innerText=courseInfo.companyName;
    hFour.appendChild(aMid);
    hFour.appendChild(company);
    divDetails.appendChild(hFour);
    divBox.appendChild(divDetails);
    let divFooter = document.createElement("div");
    divFooter.classList.add("course-footer", "clearfix");

    let divLeft = document.createElement("div");
    divLeft.classList.add("pull-left");
    let ulLeft = document.createElement("ul");
    ulLeft.classList.add("list-inline");
    let liLeft = document.createElement("li");
    let aLeft = document.createElement("a");
    aLeft.setAttribute("href","#");
    aLeft.innerText = "立即购买";

    liLeft.appendChild(aLeft);
    ulLeft.appendChild(liLeft);
    divLeft.appendChild(ulLeft);

    let divRight = document.createElement("div");
    divRight.classList.add("pull-right");
    let ulRight = document.createElement("ul");
    ulRight.classList.add("list-inline");
    let liRight = document.createElement("li");
    let aRight = document.createElement("a");
    aRight.setAttribute("href","#");
    aRight.innerText = "￥"+courseInfo.coursePrice;
    liRight.appendChild(aRight);
    ulRight.appendChild(liRight);
    divRight.appendChild(ulRight);

    divFooter.appendChild(divLeft);
    divFooter.appendChild(divRight);
    divBox.appendChild(divFooter);
    divGrid.appendChild(divBox);
    return divGrid;
}

function loadCourseList(courseInfoListJson) {
    let courseInfoList = JSON.parse(courseInfoListJson);
    let div = document.getElementById("courseGrid");
    let courseInfoListData = courseInfoList.data;

    for(let i = 0; i < courseInfoListData.length ; i++){
        let divGrid = generateDiv(courseInfoListData[i]);
        div.appendChild(divGrid);
    }
}

function refreshGrid(courseInfoList) {
    let div = document.getElementById("courseGrid");
    let length = courseInfoList.length;
    for(let i = 0; i < length; i ++){
        let courseInfo = courseInfoList[i];
        let courseName = courseInfo.courseName;
        let couName = document.getElementsByClassName("couName")[i];
        couName.innerText = courseName;

        let courseId = courseInfo.courseId;
        let courseSign = document.getElementsByClassName("courseDetail")[i];
        courseSign.setAttribute("href","http://localhost:1250/courseUi/courseInfoUi/" + courseInfo.courseId);

        let courseCompany = courseInfo.companyName;
        let couCompany = document.getElementsByClassName("couCompany")[i];
        couCompany.innerText = courseCompany;

        let coursePrice = courseInfo.coursePrice;
        let couPrice = document.getElementsByClassName("couPrice")[i];
        couPrice.innerText = coursePrice;
    }
}

