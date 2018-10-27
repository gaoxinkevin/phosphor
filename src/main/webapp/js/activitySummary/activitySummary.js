document.write("<script type='text/javascript' language='JavaScript' src='/js/activity/util.js'></script>");

/**
 * 加载活动总结
 */
function getActivitySummary() {
    let request = getXhr();
    let url = window.location.search;
    let activityId = url.substring(url.lastIndexOf("=") + 1, url.length);
    getActivity(activityId);

    request.open("GET", "/activitySummary/getActivitySummaryByActId?activityId="+activityId);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request.send(null);

    request.onreadystatechange = function () {
        if(request.readyState == 4){
            if(request.status >= 200 && request.status < 300 || request.status == 304){
                loadActivitySummaryToView(request.responseText);
            }
        }
    }
}

/**
 * 将活动信息和相关的活动总结加载到页面
 * @param responseText
 */
function loadActivitySummaryToView(responseText) {
    let activitySummaryList = JSON.parse(responseText).data;
    if(activitySummaryList != null && activitySummaryList.length >=0){
        let length = activitySummaryList.length;
        let menuList = document.getElementsByClassName("menu");
        for(let i = 0; i < length; i++){
            let menu = menuList[i];
            menu.style.visibility= "visible";

            let divContainer = document.getElementById("sum"+(i+1));
            let activitySummary = activitySummaryList[i];

            let pSum = divContainer.getElementsByTagName("p")[0];
            pSum.innerText = activitySummary.activitySummaryContent;
        }
    }
}

/**
 * 获取活动信息
 * @param activityId    活动ID
 */
function getActivity(activityId) {
    let request = getXhr();
    request.open("GET", "/activity/getActivityDetail?activityId="+activityId, true);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request.send(null);

    request.onreadystatechange = function () {
        if(request.readyState == 4){
            if(request.status >= 200 && request.status < 300 || request.status == 304){
                loadActivityToView(request.responseText);
            }
        }
    }
}


/**
 * 将活动基本信息加载到页面
 * @param responseText
 */
function loadActivityToView(responseText) {
    let activityDetail = JSON.parse(responseText).data;
    let activityImg = document.getElementById("activity-img");
    activityImg.setAttribute("src", activityDetail.activitySf);
    activityImg.addEventListener('error', function (event) {
        activityImg.setAttribute("src", "images/loader.gif");
        activityImg.setAttribute("alt", "获取图片失败");
    });
    let activityTitle = document.getElementById("activity-title");
    activityTitle.innerText = activityDetail.activityTitle;

    let activityDesc = document.getElementById("activity-desc");
    activityDesc.innerText =  activityDetail.activityDesc;

    let activityPrice = document.getElementById("activity-price");
    activityPrice.innerText = activityDetail.activityPrice;
}