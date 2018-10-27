document.write("<script type='text/javascript' language='JavaScript' src='/js/activity/util.js'></script>");

/**
 * 加载详情页面
 * 页面的入口函数
 */
function getActivityDetail() {
    let request = getXhr();
    let url = window.location.search;
    let activityId = url.substring(url.lastIndexOf("=")+1, url.length);
    request.open("POST", "/activity/getActivityDetail", true);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request.send("activityId="+activityId);

    request.onreadystatechange = function () {
        if(request.readyState == 4){
            if(request.status >= 200 && request.status < 300 || request.status == 304){
                loadActivityDetail(request.responseText);
            }
        }
    };
}

/**
 * 解析JSON中的div
 * @param responseText
 */
function loadActivityDetail(responseText) {
    let responseData = JSON.parse(responseText);
    activityDetail = responseData.data;
    loadView(activityDetail);
}

/**
 * 将数据加载到页面
 * @param activityDetail
 */
function loadView(activityDetail) {


    let activityId = activityDetail.activityId;


    //显示标题和价格
    let hActivityTitle = document.getElementsByClassName("hActivityTitle");
    hActivityTitle[0].innerText = activityDetail.activityTitle;
    hActivityTitle[1].innerText = "￥"+activityDetail.activityPrice;
    document.title = "详情：" + activityDetail.activityTitle;

    let activityBeginTime = document.getElementById("beginTime");

    let timestamp = activityDetail.activityStartTime;
    let dateFull = timestampToDate(timestamp);
    activityBeginTime.innerText += dateFull;

    let company = document.getElementById("aCompany");
    let companyId = activityDetail.companyId
    let companyName = activityDetail.companyName;
    company.innerText = companyName;
    company.setAttribute("href", "/company/company?companyId="+companyId);
    getCompanyInfo(companyId);

    let activityImg = document.getElementById("activityImg");
    activityImg.setAttribute("src", activityDetail.activitySf);
    activityImg.setAttribute("alt", "活动现场");

    let activityContent = document.getElementById("activityContent");
    activityContent.innerText = activityDetail.activityContent;

    //刷新报名按钮
    btnSignIn = document.getElementById("btnSignIn");
    refreshBtnSignIn();


    let teacherId = activityDetail.teacherId;
    getTeacherInfo(teacherId);

    //刷新右侧推荐活动栏
    loadOtherActivity(companyName, companyId, activityId);

}


/**
 * 请求companyController获取company信息
 * @param companyId
 */
function getCompanyInfo(companyId){
    let request = getXhr();
    request.open("GET", "/company/company?companyId="+companyId);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request.send(null);
    request.onreadystatechange = function () {
        if(request.readyState == 4){
            if(request.status >= 200 && request.status < 300 || request.status == 304){
                loadCompanyToView(request.responseText);
            }
        }
    }
}

/**
 * 将公司信息加载到页面
 * @param responseText
 */
function loadCompanyToView(responseText) {
    let companyInfo = JSON.parse(responseText).data;
    let companyImg = document.getElementById("companyImg");
    companyImg.setAttribute("src", companyInfo.companyPhoto);
    companyImg.addEventListener('error',function (event) {
        companyImg.src = "/upload/banner.jpeg";
    });

}


/**
 * 定时刷新报名按钮
 */
function refreshBtnSignIn() {
    let retainTime = getRemainTime(parseInt(activityDetail.activityApplyEndTime));

    if(parseInt(activityDetail.activityApplyEndTime) > (new Date()).valueOf()){
        btnSignIn.innerText = "立即报名 (剩余时间 "+retainTime+")";
        btnSignIn.onclick = signInForActivity;
    }
    else if(parseInt(activityDetail.activityEndTime) > (new Date()).valueOf() ){
        btnSignIn.innerText = "报名截止";
        btnSignIn.classList.add("disable");
        btnSignIn.onclick = stopApply;
    }
    else {
        btnSignIn.innerText = "查看总结";
        btnSignIn.onclick = toActivitySummary;                                                                                  ;
    }

}
/**
 * 请求获取teacher信息
 * @param teacherID teacherID
 */
function getTeacherInfo(teacherID) {
    let request = getXhr();
    request.open("GET", "/teacher/getTeacherById/"+teacherID);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request.send(null);
    request.onreadystatechange = function (){
        if(request.readyState == 4){
            if(request.status >= 200 && request.status < 300 || request.status == 304){
                let teacherInfo = JSON.parse(request.responseText);
                loadTeacherInfo2View(teacherInfo.data);
            }
        }
    }
}

/**
 * 将teache信息加载到页面中
 * @param teacherInfo
 */
function loadTeacherInfo2View(teacherInfo) {
    let teacherId = teacherInfo.teacherId;

    let aToTeacherDetail = document.getElementById("aToTeacherDetail");
    aToTeacherDetail.setAttribute("href", "/teacherUi/getTeacherInformation/"+teacherId);

    let pTeacherDesc = document.getElementById("pTeacherDesc");
    pTeacherDesc.innerText = teacherInfo.teacherDesc;

    let imgTeacher = document.getElementById("imgTeacher");
    imgTeacher.setAttribute("src", teacherInfo.teacherPhoto);

    imgTeacher.addEventListener('error', function (event) {
       imgTeacher.src = "/upload/people_10.jpeg";
    });

    let spTeacherName = document.getElementById("spTeacherName");
    spTeacherName.innerText = " "+teacherInfo.teacherName;

    let teacherPhone = document.getElementById("iTeacherPhone");
    teacherPhone.innerText = " "+teacherInfo.teachePhone;

    let teacherMail = document.getElementById("iTeacherMail");
    teacherMail.parentNode.setAttribute("href", "mailto:"+teacherInfo.teacherMail);
    teacherMail.innerText = " "+teacherInfo.teacherMail;

    let teacherStatus = document.getElementById("iTeacherStatus");
    if(teacherInfo.teacherStatus == "0")
        teacherStatus.innerText = "当前状态：空闲";
    else if(teacherInfo.teacherStatus == "1")
        teacherStatus.innerText = "当前状态：外派";
    else if(teacherInfo.teacherStatus == "2")
        teacherStatus.innerText = "当前状态：外出学习";
    else
        teacherStatus.innerText = "当前状态：其他";

    getTeacherCourseInfo(teacherId);
    
}

/**
 * 根据教师信息获取其教授课程的信息
 * @param teacherId 教师ID
 */
function getTeacherCourseInfo(teacherId) {
    let request = getXhr();
    request.open("GET", "/teacherCourse/getCoursesByTeacherId?teacherId="+teacherId);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request.send(null);

    request.onreadystatechange = function () {
        if(request.readyState == 4){
            if(request.status >= 200 && request.status < 300 || request.status == 304){
                loadTeacherCourse2View(request.responseText);
            }
        }
    }
}

/**
 * 渲染视图：教师教授的课程
 * @param responseText  返回的JSON信息
 */
function loadTeacherCourse2View(responseText) {
    let courseList = JSON.parse(responseText).data;
    let ulCourse = document.getElementById("teacher-courses");
    ulCourse.innerText = "参与课程 ";
    for(let i = 0; i < courseList.length; i++){
        let course = courseList[i];
        let aToCourse = document.createElement("a");

        //TODO(添加跳到course详情页的url，这里暂时先设置为当前页)
        aToCourse.setAttribute("href", "#");
        aToCourse.innerText = course.courseName;

        let liCourse = document.createElement("li");
        liCourse.appendChild(aToCourse);

        ulCourse.appendChild(liCourse);
    }
}

/**
 * 加载机构其他活动
 * 按照时间排序，取前五个
 */
function loadOtherActivity(companyName, companyId, activityId) {
    let comTitleOtherActivity = document.getElementById("comTitleOtherActivity");
    comTitleOtherActivity.innerText = companyName+"的热门活动";
    let request = getXhr();
    request.open("GET","/activity/getActivityByCompanyId?companyId="+companyId+"&activityId="+activityId);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request.send(null);
    
    request.onreadystatechange = function () {
        if (request.readyState == 4){
            if(request.status >= 200 && request.status < 300 || request.status == 304){
                loadOtherActivityToView(request.responseText);
            }
        }
    }

}

/**
 * 将获取到的其他活动加载到页面中
 * @param responseText
 */
function loadOtherActivityToView(responseText) {
    let otherActivityList = JSON.parse(responseText).data;
    let divOtherActivity = document.getElementById("divOtherActivity");
    let divContainerList = divOtherActivity.getElementsByClassName("media");
    let length = otherActivityList.length;
    for(let i = 0; i < length; i++){
        let otherActivity = otherActivityList[i];
        let divContainer = divContainerList[i];
        divContainer.style.display = "block";
        let imgActivity = divContainer.getElementsByTagName("img")[0];
        imgActivity.setAttribute("src", otherActivity.activitySf);
        imgActivity.addEventListener('error', function (event) {
            imgActivity.setAttribute("src", "/images/loader.gif");
            imgActivity.setAttribute("alt", "图片加载失败");
        });

        let aTitle = divContainer.getElementsByTagName("a")[0];
        aTitle.innerText = otherActivity.activityTitle;
        aTitle.setAttribute("href", "/activityUi/returnActivityDetail?activityId="+otherActivity.activityId);


        let liBeginTime = divContainer.getElementsByTagName("li")[0];
        let timeFull = timestampToDate(otherActivity.activityStartTime);
        let timeShow = timeFull.substring(timeFull.indexOf("年") + 1, timeFull.lastIndexOf(":"));
        liBeginTime.innerText = "开始时间 "+timeShow;


        let liPrice = divContainer.getElementsByTagName("li")[1];
        liPrice.innerText = "￥ "+otherActivity.activityPrice;

    }

    /*for(let i = 0; i < (divContainerList.length - length); i++){
        let divUseless = divContainerList[divContainerList.length - i];
        divUseless.style.visibility = "hidden";
    }*/
}


/**
 * 获取报名剩余时间
 * @param stopApplyTime 截止报名时间
 * @returns {string}    处理后的剩余时间
 */
function getRemainTime(stopApplyTime) {
    let timestampNow = (new Date()).valueOf();
    if(timestampNow >= stopApplyTime)
        return "0";
    else {
        let timestampRemain = parseInt(stopApplyTime) -parseInt(timestampNow);
        //剩余的天数
        let days = parseInt(timestampRemain/ 86400000);

        //剩余小时数
        let hours = parseInt((timestampRemain% 86400000) / 3600000);

        //剩余分钟数
        let minutes = parseInt((timestampRemain % 3600000) / 60000);

        return days + "天 " + hours +" 时 " + minutes + " 分 ";
    }
}


/**
 *报名参加活动
 */
function signInForActivity() {
    //TODO 暂时先不设置路径
    alert("报名成功");
}

/**
 * 活动停止报名
 */
function stopApply() {
    window.alert("报名时间已过");
    return void(0);
}

/**
 * 查看总结
 */
function toActivitySummary() {
    window.location.href = "/activitySummaryUi/returnActivitySummaryUi?activityId="+activityDetail.activityId;
}