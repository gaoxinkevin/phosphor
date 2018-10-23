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

/**
 * 分页查询
 * @param pageIndex 页码
 * @param pageSize 每页展示数量
 */
function getCourseListByPage(pageIndex, pageSize) {
    let request = getXhr();
    request.open("GET", "/course/getCourseListByPage?pageIndex="+pageIndex+"&pageSize="+pageSize, true);
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    request.send(null);

    request.onreadystatechange = function () {
        if(request.readyState == 4){
            if(request.status >= 200 && request.status < 300 || request.status == 304){
                loadCourseListByPage(request.responseText);
            }
        }
    }
}

function loadCourseListByPage(pageJson) {
    let page = JSON.parse(pageJson);
    let courseInfoListData = page.data;

    let totalPages =courseInfoListData.totalPages;
    let hidTotalPages = document.getElementById("totalPages");
    hidTotalPages.setAttribute("value", totalPages);

    let currentPageCode = courseInfoListData.currentPageCode;
    let hidCurrentPageIndex = document.getElementById("currentPageCode");
    hidCurrentPageIndex.value = currentPageCode;
    let pageSize = courseInfoListData.pageSize;

    if(currentPageCode > (totalPages - 1)){
        getActivityByPage(0, pageSize);
        return void(0);
    }
    let currentPage = document.getElementById("currentPageCode");
    currentPage.setAttribute("value", currentPageCode);

    let courseInfoList = courseInfoListData.modelList;
    if (courseInfoList.length <= 0 && currentPageCode == 0){
        alert("暂无数据");
        return void(0);
    }
    else if(courseInfoList.length <= 0 && currentPageCode != 0)
    {
        getActivityByPage(0, pageSize);
    }
    else{
        refreshGrid(courseInfoList, pageSize);
    }
    refreshUlPagination(currentPageCode, totalPages);
}

function refreshGrid(courseInfoList, pageSize) {
    let div = document.getElementById("courseGrid");
    let length = courseInfoList.length;
    for(let i = 0; i < length; i ++){
        let courseInfo = courseInfoList[i];
        let courseName = courseInfo.courseName;
        let couName = document.getElementsByClassName("courseName")[i];
        couName.innerText = courseName;

        let courseId = courseInfo.courseId;
        let courseSign = document.getElementsByClassName("courseDetail")[i];
        courseSign.setAttribute("href", "/course/findCourseInfo?courseId="+courseId);

        let courseType = courseInfo.typeName;
        let couType = document.getElementsByClassName("courseType")[i];
        couType.innerText = courseType;

        let coursePrice = courseInfo.coursePrice;
        let couPrice = document.getElementsByClassName("couPrice")[i];
        couPrice.innerText = coursePrice;
    }
    for(let i = 0; i < (pageSize - length); i ++){
        let gridUseless = div.getElementsByClassName("courseGrid")[(pageSize - 1) - i];
        gridUseless.style.visibility = "hidden";
    }
}


/**
 * 生成页码
 * @param currentPageCode
 * @param totalPages
 */

function refreshUlPagination(currentPageCode, totalPages) {

    let uPagination = document.getElementById("uPagination");

    let liPrePage = document.getElementById("perPage");
    let aPrePage = liPrePage.getElementsByTagName("a")[0];

    let liNextPage = document.getElementById("nextPage");
    let aNextPage = liNextPage.getElementsByTagName("a")[0];

    if(currentPageCode == 0){
        liPrePage.classList.add("disable");
        aPrePage.classList.add("disable");
        aPrePage.setAttribute("disable", true);
    }

    if(currentPageCode == totalPages){
        liNextPage.classList.add("disable");
        aNextPage.classList.add("disable");
        aNextPage.setAttribute("disable", true);
    }

    clearPageIndex(uPagination);
    for(let i = 0; i < totalPages; i++){
        let liPageIndex = document.createElement("li");
        let aPageIndex= document.createElement("a");
        aPageIndex.innerText = (i + 1) + "";
        liPageIndex.classList.add("pageIndex");
        aPageIndex.onclick = newPage;
        liPageIndex.appendChild(aPageIndex);
        if(i == currentPageCode){
            liPageIndex.classList.add("active");
        }
        uPagination.insertBefore(liPageIndex, liNextPage);
    }
}

/**
 * 清除页码li，重新刷新
 * @param pageUl
 */
function clearPageIndex(pageUl) {
    let pageIndexList = pageUl.getElementsByClassName("pageIndex");
    if(pageIndexList.length == 0)
        return void(0);
    for(let i =pageIndexList.length -1; i>=0; i--)
        pageUl.removeChild(pageIndexList[i]);
}

/**
 * 获取Xhr对象
 * @returns {any}
 */
function getXhr() {
    let request = null;
    if(window.XMLHttpRequest)
        request = new XMLHttpRequest();
    else
        request = new ActiveXObject("Microsoft.XMLHTTP");

    return request;
}

/**
 * 解析JSON，并且装入到DOM中返回
 * @param courseInfoListJson
 */
function loadCourseList(courseInfoListJson) {
    let courseInfoList = JSON.parse(courseInfoListJson);
    let div = document.getElementById("courseGrid");
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
    aTitle.setAttribute("href", "/course/findCourseInfo?courseId="+courseInfo.courseId);

    let h4 = document.createElement("h4");

    let small = document.createElement("small");
    small.innerText = "about";
    h4.appendChild(small);

    let span = document.createElement("span");
    span.innerText = courseInfo.courseName;

    h4.appendChild(span);
    aTitle.appendChild(h4);

    let tName = document.createElement("p");
    tName.innerText = courseInfo.typeName;


    divSitePublisher.appendChild(imgResponsive);
    divSitePublisher.appendChild(aTitle);
    divSitePublisher.appendChild(tName);

    divGrid.appendChild(divSitePublisher);
    return divGrid;
}

function newPage() {
    let pageIndex = parseInt(this.innerText) - 1;
    getCourseListByPage(pageIndex, 12);
}

/**
 * 加载上一页数据，并刷新页面
 */

function perPage() {
    let currentPageCode = document.getElementById("currentPageCode").getAttribute("value");
    if(currentPageCode <= 0)
        return false;
    else{
        getCourseListByPage(currentPageCode - 1, 12);
    }
}

/**
 * 加载下一页数据并刷新页面
 * @param currentPageCode
 */
function nextPage() {
    let currentPageCode = parseInt(document.getElementById("currentPageCode").getAttribute("value"));
    let totalPages = parseInt(document.getElementById("totalPages").getAttribute("value"));
    if(currentPageCode >= (totalPages - 1))
        return void(0);
    getCourseListByPage((currentPageCode + 1), 12);
}