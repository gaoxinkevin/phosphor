document.write("<script language='JavaScript' src='activity.js'></script>");

function getActivityDetail() {
    let request = getXhr();
    let url = window.location.search;
    let activityId = url.substring(url.lastIndexOf("=")+1, url.length);
    request.open("POST", "activity/getActivityDetail");
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request.send("activityId="+activityId);

    request.onreadystatechange = function () {
        if(request.status >= 200 && request.status < 300 || request.status == 304){
            loadActivityDetail(request.responseText);
        }
    }
}

/**
 * 解析JSON中的div
 * @param responseText
 */
function loadActivityDetail(responseText) {
    let responseData = JSON.parse(responseText);
    let activityDetail = responseData.data;
    loadView(activityDetail);
}

/**
 * 将数据加载到页面
 * @param activityDetail
 */
function loadView(activityDetail) {
    let hActivityTitle = document.getElementById("hActivityTitle");
    hActivityTitle.innerText = activityDetail.activityTitle;
    document.title = "详情：" + activityDetail.activityTitle;

    let activityBeginTime = document.getElementById("beginTime");
    activityBeginTime.innerText = activityDetail.activityStartTime;

    let company = document.getElementById("aCompany");
    company.innerText = activityDetail.companyName;
    company.setAttribute("href", "company/company?companyId="+activityDetail.companyId);



}

/**
 *报名
 */
function signInForActivity() {

}