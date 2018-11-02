document.write("<script type='text/javascript' language='JavaScript' src='/js/activity/util.js'></script>");


/**
 * 查询所有Activity数据，并且返回DOM
 * 暂时未使用
 */
function getActivityAll() {
    let request = getXhr();
    request.open("GET", "/activity/getActivityInfoAll", true);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
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
 * @param key 排序字段
 * @param ascOrDesc 升序或者降序
 * @param title 模糊查询关键字
 */
function getActivityByPage(pageIndex, pageSize, key, ascOrDesc, title) {
    let request = getXhr();
    if(typeof (key) == undefined)
        key = null;
    if(typeof (ascOrDesc) == undefined || ascOrDesc == "null")
        key = null;
    if(typeof (title) == undefined || title == "")
        title = null;
    let postData = "pageIndex="+pageIndex +"&pageSize="+ pageSize +"&key="+ key + "&ascOrDesc=" + ascOrDesc +"&title="+ title;
    request.open("POST", "/activity/getActivityInfoByPage", true);
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    request.send(postData);
    
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
    getRecentActivity();
}

/**
 * 刷新活动
 * @param activityInfoList
 * @param pageSize
 */
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
        aSign.setAttribute("href", "/activityUi/returnActivityDetail?activityId="+activityId);

        let activityDesc = activityInfo.activityDesc;
        let spDesc = document.getElementsByClassName("spDesc")[i];
        spDesc.innerText = activityDesc;

        let activityPrice = activityInfo.activityPrice;
        let spPrice = document.getElementsByClassName("spPrice")[i];
        spPrice.innerText = "￥"+activityPrice;

        let activityImg = activityInfo.activitySf;
        let imgActivity = document.getElementsByClassName("img-activity")[i];
        imgActivity.setAttribute("src", activityImg);

        imgActivity.onclick = showBigActivityImg;

        imgActivity.addEventListener('error', function (event) {
            imgActivity.setAttribute("src", '/images/loader.gif');
            imgActivity.setAttribute("alt", "活动图片暂缺");
        });

    }
    for(let i = 0; i < pageSize; i ++){
        if(i < (pageSize - length)){
            let gridUseless = div.getElementsByClassName("activityGrid")[(pageSize - 1) - i];
            gridUseless.style.visibility = "hidden";
        }
        else{
            let gridUseless = div.getElementsByClassName("activityGrid")[(pageSize - 1) - i];
            gridUseless.style.visibility = "visible";
        }
    }
}


/**
 * 点击活动时，显示大图
 */
function showBigActivityImg() {
    let bigActivityImg = document.getElementById("bigActivityImg");
    let imgPath = this.src;
    if(imgPath != bigActivityImg.src)
        bigActivityImg.setAttribute("src", imgPath);
    else
        return void(0);
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
        aPageIndex.classList.add("page-code");
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
    aTitle.setAttribute("href", "/activityUi/returnActivityDetail?activityId="+activityInfo.activityID);

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


/**
 *刷新左侧最近热门活动
 */
function getRecentActivity() {
    let request = getXhr();
    request.open("GET", "/activity/getRecentActivity", true);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request.send(null);
    request.onreadystatechange = function () {
        if(request.readyState == 4){
            if(request.status >= 200 && request.status < 300 || request.status == 304){
                loadRecentActivityToView(request.responseText);
            }
        }
    };
}

/**
 * 将获取到的近期活动加载到页面
 * @param recentActivity
 */
function loadRecentActivityToView(recentActivity) {
    let recentActivityList = JSON.parse(recentActivity).data;
    let length = recentActivityList.length;
    let divRecentActivity = document.getElementById("divRecentActivity");
    let containerList  = divRecentActivity.getElementsByClassName("media");
    for(let i = 0; i < length; i++){
        let container = containerList[i];
        let recentActivity = recentActivityList[i];
        container.style.display = "block";

        //加载图片
        let activityImg = container.getElementsByTagName("img")[0];
        activityImg.setAttribute("src", recentActivity.activitySf);
        activityImg.addEventListener("error", function (event) {
            activityImg.setAttribute("src", "/images/loader.gif");
            activityImg.setAttribute("alt", "暂无图片");
        });

        let aToActivity = container.getElementsByTagName("a")[0];
        aToActivity.setAttribute("href", "/activityUi/returnActivityDetail?activityId="+recentActivity.activityId);
        aToActivity.innerText = recentActivity.activityTitle;

        let liStartTime = container.getElementsByTagName("li")[0];
        let startTimeFull = timestampToDate(recentActivity.activityStartTime);
        let timeShow = startTimeFull.substring(startTimeFull.indexOf("年") + 1, startTimeFull.lastIndexOf(":"));
        liStartTime.innerText = timeShow;

        let liActivityPrice = container.getElementsByTagName("li")[1];
        liActivityPrice.innerText = "￥ "+recentActivity.activityPrice;

    }

}

/**
 * 按照标题查询
 * @returns {*}
 */
function searchByActivityTitle(){
    let activityTitle = document.getElementById("activity-title");
    if(activityTitle.value != null && activityTitle.value != ""){
        getActivityByPage(0, 4, null, null, activityTitle.value);
    }
    else
        return void(0);
}


/**
 * 按照报名开始时间排序
 */
function orderByApplyTime() {
    let title = document.getElementById("activity-title").value;
    let applyTimeOrder = document.getElementById("applyTimeOrder");
    let iptApplyTimeOrder = applyTimeOrder.getElementsByTagName("input")[0];
    if(iptApplyTimeOrder.value == "null"){
        changeSortView("activity_apply_start_time", "ASC");
    }
    else if(iptApplyTimeOrder.value == "ASC"){
        changeSortView("activity_apply_start_time", "desc");
    }
    else{
        changeSortView("activity_apply_start_time", "null");
    }

    let ascOrDesc = iptApplyTimeOrder.value;

    let key = "activity_apply_start_time";

    getActivityByPage(0, 4, key, ascOrDesc, title);

}

/**
 * 按照活动开始时间排序
 */
function orderByBeginTime() {
    let title = document.getElementById("activity-title").value;
    let startTimeOrder = document.getElementById("startTimeOrder");
    let iptStartTimeOrder = startTimeOrder.getElementsByTagName("input")[0];
    if(iptStartTimeOrder.value == "null"){
        changeSortView("activity_start_time", "ASC");
    }
    else if(iptStartTimeOrder.value == "ASC"){
        changeSortView("activity_start_time", "desc");
    }
    else {
        changeSortView("activity_start_time", "null");
    }

    let ascOrDesc = iptStartTimeOrder.value;

    let key = "activity_start_time";

    getActivityByPage(0, 4, key, ascOrDesc, title);
}

/**
 * 在切换排序方式时，更改页面中的状态
 */
function changeSortView(orderKey, ascOrDesc) {
    let applyTimeOrder = document.getElementById("applyTimeOrder");
    let startTimeOrder = document.getElementById("startTimeOrder");
    if(orderKey == "activity_apply_start_time"){
        let iptApplyTimeOrder = applyTimeOrder.getElementsByTagName("input")[0];
        if(ascOrDesc == "ASC"){
            applyTimeOrder.getElementsByTagName("img")[0].style.visibility = "visible";
            applyTimeOrder.getElementsByTagName("img")[1].style.visibility = "hidden";

            startTimeOrder.getElementsByTagName("img")[0].style.visibility = "visible";
            startTimeOrder.getElementsByTagName("img")[1].style.visibility = "visible";
            startTimeOrder.getElementsByTagName("input")[0].value = "null";
        }
        else if(ascOrDesc == "desc"){
            applyTimeOrder.getElementsByTagName("img")[0].style.visibility = "hidden";
            applyTimeOrder.getElementsByTagName("img")[1].style.visibility = "visible";

            startTimeOrder.getElementsByTagName("img")[0].style.visibility = "visible";
            startTimeOrder.getElementsByTagName("img")[1].style.visibility = "visible";
            startTimeOrder.getElementsByTagName("input")[0].value = "null";
        }
        else {
            applyTimeOrder.getElementsByTagName("img")[0].style.visibility = "visible";
            applyTimeOrder.getElementsByTagName("img")[1].style.visibility = "visible";

            startTimeOrder.getElementsByTagName("img")[0].style.visibility = "visible";
            startTimeOrder.getElementsByTagName("img")[1].style.visibility = "visible";
            startTimeOrder.getElementsByTagName("input")[0].value = "null";
        }
        iptApplyTimeOrder.value = ascOrDesc;
    }
    else {
        let iptStartTimeOrder = startTimeOrder.getElementsByTagName("input")[0];
        if(ascOrDesc == "ASC"){
            startTimeOrder.getElementsByTagName("img")[0].style.visibility = "visible";
            startTimeOrder.getElementsByTagName("img")[1].style.visibility = "hidden";

            applyTimeOrder.getElementsByTagName("img")[0].style.visibility = "visible";
            applyTimeOrder.getElementsByTagName("img")[1].style.visibility = "visible";
            applyTimeOrder.getElementsByTagName("input")[0].value = "null";
        }
        else if(ascOrDesc == "desc"){
            startTimeOrder.getElementsByTagName("img")[0].style.visibility = "hidden";
            startTimeOrder.getElementsByTagName("img")[1].style.visibility = "visible";

            applyTimeOrder.getElementsByTagName("img")[0].style.visibility = "visible";
            applyTimeOrder.getElementsByTagName("img")[1].style.visibility = "visible";
            applyTimeOrder.getElementsByTagName("input")[0].value = "null";
        }
        else {
            startTimeOrder.getElementsByTagName("img")[0].style.visibility = "visible";
            startTimeOrder.getElementsByTagName("img")[1].style.visibility = "visible";

            applyTimeOrder.getElementsByTagName("img")[0].style.visibility = "visible";
            applyTimeOrder.getElementsByTagName("img")[1].style.visibility = "visible";
            applyTimeOrder.getElementsByTagName("input")[0].value = "null";
        }
        iptStartTimeOrder.value = ascOrDesc;
    }
}


/**
 * 跳转到指定页面
 */
function newPage() {
    let title = document.getElementById("activity-title").value;
    let applyTimeOrder = document.getElementById("applyTimeOrder");
    let startTimeOrder = document.getElementById("startTimeOrder");
    let pageIndex = parseInt(this.innerText) - 1;

    if((applyTimeOrder.getElementsByTagName("input")[0].value == "null") && (startTimeOrder.getElementsByTagName("input")[0].value == "null")){
        getActivityByPage(pageIndex, 4, "activity_apply_start_time", "null", title);
    }
    else if(applyTimeOrder.getElementsByTagName("input")[0].value != "null"){
        getActivityByPage(pageIndex, 4, "activity_apply_start_time", applyTimeOrder.getElementsByTagName("input")[0].value, title);
    }
    else {
        getActivityByPage(pageIndex, 4, "activity_start_time", startTimeOrder.getElementsByTagName("input")[0].value, title);
    }
    document.getElementById("activityListTop").scrollIntoView(true);
}



/**
 * 加载上一页数据，并刷新页面
 */

function perPage() {
    let title = document.getElementById("activity-title").value;
    let applyTimeOrder = document.getElementById("applyTimeOrder");
    let startTimeOrder = document.getElementById("startTimeOrder");
    let currentPageCode = document.getElementById("currentPageCode").getAttribute("value");
    if(currentPageCode <= 0)
        return false;
    else{
        if((applyTimeOrder.getElementsByTagName("input")[0].value == "null") && (startTimeOrder.getElementsByTagName("input")[0].value == "null")){
            getActivityByPage(currentPageCode -1 , 4, "activity_apply_start_time", "null", title);
        }
        else if(applyTimeOrder.getElementsByTagName("input")[0].value != "null"){
            getActivityByPage(currentPageCode -1, 4, "activity_apply_start_time", applyTimeOrder.getElementsByTagName("input")[0].value, title);
        }
        else {
            getActivityByPage(currentPageCode -1, 4, "activity_start_time", startTimeOrder.getElementsByTagName("input")[0].value, title);
        }
    }
    document.getElementById("activityListTop").scrollIntoView(true);
}

/**
 * 加载下一页数据并刷新页面
 * @param currentPageCode
 */
function nextPage() {
    let title = document.getElementById("activity-title").value;
    let applyTimeOrder = document.getElementById("applyTimeOrder");
    let startTimeOrder = document.getElementById("startTimeOrder");
    let currentPageCode = parseInt(document.getElementById("currentPageCode").getAttribute("value"));
    let totalPages = parseInt(document.getElementById("totalPages").getAttribute("value"));
    if(currentPageCode >= (totalPages - 1))
        return void(0);
    else {
        if((applyTimeOrder.getElementsByTagName("input")[0].value == "null") && (startTimeOrder.getElementsByTagName("input")[0].value == "null")){
            getActivityByPage(currentPageCode + 1 , 4, "activity_apply_start_time", "null", title);
        }
        else if(applyTimeOrder.getElementsByTagName("input")[0].value != "null"){
            getActivityByPage(currentPageCode + 1, 4, "activity_apply_start_time", applyTimeOrder.getElementsByTagName("input")[0].value, title);
        }
        else {
            getActivityByPage(currentPageCode + 1, 4, "activity_start_time", startTimeOrder.getElementsByTagName("input")[0].value, title);
        }
    }
    document.getElementById("activityListTop").scrollIntoView(true);
}
