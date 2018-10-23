function getAllCouse() {
    let request = null;
    if(window.XMLHttpRequest)
        request = new XMLHttpRequest();
    else
        request = new ActiveXObject('Microsoft.XMLHTTP');

    request.open("GET", "/course/getCourseList", true);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
    request.send(null);

    request.onreadystatechange = function () {
        if(request.readyState == 4){
            if(request.status >= 200 && request.status<300 || request.status == 304)
                loadActivityList(request.responseText);
        }
    }
}

function loadCourseList(CourseInfoListJson) {
    let courseInfoList = JSON.parse(CourseInfoListJson);
    let div = document.getElementById("activityGrid");
    let courseInfoListData = courseInfoList.data;
    for(let i = 0; i < courseInfoListData.length ; i++){

        let divGrid = generateDiv(courseInfoListData[i]);
        div.appendChild(divGrid);
    }
}

function generateDiv(courseInfo) {
    let divGrid = document.createElement("div");
    divGrid.classList.add("authorbox");

    let divSitePublisher = document.createElement("div");
    divSitePublisher.classList.add("site-publisher", "clearfix");
    let imgResponsive = document.createElement("img");
    imgResponsive.setAttribute("src", "/upload/people_10.jpeg");
    imgResponsive.setAttribute("alt", "");
    imgResponsive.classList.add("img-responsive", "img-circle");

    let aTitle = document.createElement("a");
    aTitle.setAttribute("href", "/course/activityDetail?activityID="+courseInfo.courseName);

    let h4 = document.createElement("h4");

    let small = document.createElement("small");
    small.innerText = "about";
    h4.appendChild(small);

    let span = document.createElement("span");
    span.innerText = courseInfo.typeName;

    h4.appendChild(span);
    aTitle.appendChild(h4);

    let pDesc = document.createElement("p");
    pDesc.innerText = courseInfo.activityDesc;

    let bSubmit = document.createElement("button");
    bSubmit.setAttribute("type", "submit");
    bSubmit.classList.add("btn", "btn-primary");
    bSubmit.style.cssFloat="right";

    let iFa = document.createElement("i");
    iFa.classList.add("fa", "fa-paper-plane-o");
    iFa.innerText = "立即报名";

    bSubmit.appendChild(iFa);
    pDesc.appendChild(bSubmit);

    divSitePublisher.appendChild(imgResponsive);
    divSitePublisher.appendChild(aTitle);
    divSitePublisher.appendChild(pDesc);

    divGrid.appendChild(divSitePublisher);
    return divGrid;
}