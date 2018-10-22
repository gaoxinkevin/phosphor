/**
 * 查询所有Activity数据，并且返回DOM
 */
function getActivityAll() {
    let request = getXhr();
    request.open("GET", "/activity/getActivityInfoAll", true);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
    request.send(null);
    
    request.onreadystatechange = function () {
        if(request.readyState == 4){
            if(request.status >= 200 && request.status<300 || request.status == 304)
                loadActivityList(request.responseText);
        }
    }
}

/**
 *  分页查询Activity
 * @param pageIndex 页码
 * @param pageSize  每页长度
 */
function getActivityByPage(pageIndex, pageSize) {
    let request = getXhr();
    request.open("GET", "/activity/getActivityInfoByPage?pageIndex="+pageIndex+"&pageSize="+pageSize, true);
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    request.send(null);
    
    request.onreadystatechange = function () {
        if(request.readyState == 4){
            if(request.status >= 200 && request.status < 300 || request.status == 304){
                loadActivityListByPage(request.responseText);
            }
        }
    }
}

/**
 * 解析JSON生成div
 * @param pageJson
 * @returns 装载新页面的DOM
 */
function loadActivityListByPage(pageJson) {
    let page = JSON.parse(pageJson);
    let activityInfoListData = page.data;

    let totalPages =activityInfoListData.totalPages;
    let hidTotalPages = document.getElementById("totalPages");
    hidTotalPages.setAttribute("value", totalPages);

    let currentPageCode = activityInfoListData.currentPageCode;
    let hidCurrentPageIndex = document.getElementById("currentPageCode");
    hidCurrentPageIndex.value = currentPageCode;
    let pageSize = activityInfoListData.pageSize;

    if(currentPageCode > (totalPages - 1)){
        getActivityByPage(0, pageSize);
        return void(0);
    }
    let currentPage = document.getElementById("currentPageCode");
    currentPage.setAttribute("value", currentPageCode);

    let activityInfoList = activityInfoListData.modelList;
    if (activityInfoList.length <= 0 && currentPageCode == 0){
        alert("暂无数据");
        return void(0);
    }
    else if(activityInfoList.length <= 0 && currentPageCode != 0)
    {
        getActivityByPage(0, pageSize);
    }
    else{
        refreshGrid(activityInfoList, pageSize);
    }
    refreshUlPagination(currentPageCode, totalPages);
}


function refreshGrid(activityInfoList, pageSize) {
    let div = document.getElementById("activityGrid");
    let length = activityInfoList.length;
    for(let i = 0; i < length; i ++){
        let activityInfo = activityInfoList[i];
        let activityTitle = activityInfo.activityTitle;
        let spTitle = document.getElementsByClassName("spTitle")[i];
        spTitle.innerText = activityTitle;

        let activityId = activityInfo.activityId;
        let aSign = document.getElementsByClassName("aDetail")[i];
        aSign.setAttribute("href", "/activity/activityDetail?activityId="+activityId);

        let activityDesc = activityInfo.activityDesc;
        let spDesc = document.getElementsByClassName("spDesc")[i];
        spDesc.innerText = activityDesc;

    }
    for(let i = 0; i < (pageSize - length); i ++){
        let gridUseless = div.getElementsByClassName("activityGrid")[(pageSize - 1) - i];
        gridUseless.style.visibility = "hidden";
    }
}
/**
 * 生成页码列表
 * @param totalPages
 * @returns {Node}  页码列表
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
 * @param activityInfoListJson
 */
function loadActivityList(activityInfoListJson) {
    let activityInfoList = JSON.parse(activityInfoListJson);
    let div = document.getElementById("activityGrid");
    let activityInfoListData = activityInfoList.data;

    for(let i = 0; i < activityInfoListData.length ; i++){

        let divGrid = generateDiv(activityInfoListData[i]);
        div.appendChild(divGrid);
    }
}

/**
 * 生成DOM
 * @param activityInfo
 * @returns {HTMLElement}
 */
function generateDiv(activityInfo) {
    let divGrid = document.createElement("div");
    divGrid.classList.add("authorbox");

    let divSitePublisher = document.createElement("div");
    divSitePublisher.classList.add("site-publisher", "clearfix");
    let imgResponsive = document.createElement("img");
    imgResponsive.setAttribute("src", "/upload/people_10.jpeg");
    imgResponsive.setAttribute("alt", "");
    imgResponsive.classList.add("img-responsive", "img-circle");

    let aTitle = document.createElement("a");
    aTitle.setAttribute("href", "/activity/activityDetail?activityID="+activityInfo.activityID);

    let h4 = document.createElement("h4");

    let small = document.createElement("small");
    small.innerText = "about";
    h4.appendChild(small);

    let span = document.createElement("span");
    span.innerText = activityInfo.activityTitle;

    h4.appendChild(span);
    aTitle.appendChild(h4);

    let pDesc = document.createElement("p");
    pDesc.innerText = activityInfo.activityDesc;

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

function newPage() {
    let pageIndex = parseInt(this.innerText) - 1;
    getActivityByPage(pageIndex, 4);
}

/**
 * 加载上一页数据，并刷新页面
 */

function perPage() {
    let currentPageCode = document.getElementById("currentPageCode").getAttribute("value");
    if(currentPageCode <= 0)
        return false;
    else{
        getActivityByPage(currentPageCode - 1, 4);
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
    getActivityByPage((currentPageCode + 1), 4);
}