document.write("<script type='text/javascript' language='JavaScript' src='/js/activity/activity.js'></script>");

/**
 * 加载详情页面
 */
function getActivityDetail() {
    let request = getXhr();
    let url = window.location.search;
    let activityId = url.substring(url.lastIndexOf("=")+1, url.length);
    request.open("POST", "/activity/getActivityDetail");
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request.send("activityId="+activityId);

    request.onreadystatechange = function () {
        if(request.readyState == 4){
            if(request.status >= 200 && request.status < 300 || request.status == 304){
                loadActivityDetail(request.responseText);
            }
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
    let hActivityTitle = document.getElementsByClassName("hActivityTitle");
    hActivityTitle[0].innerText = activityDetail.activityTitle;
    hActivityTitle[1].innerText = activityDetail.activityTitle;
    document.title = "详情：" + activityDetail.activityTitle;

    let activityBeginTime = document.getElementById("beginTime");

    //时间戳转换为时间
    let timestamp = activityDetail.activityStartTime;
    let date = new Date(timestamp);

    let Y = date.getFullYear() + '-';
    let M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + -'';
    let D = date.getDate() + ' ';
    let h = date.getHours() + ':';
    let m = date.getMinutes() + ':';
    let s = date.getSeconds();

    let dateFull = Y+M+D+h+m+s;
    activityBeginTime.innerText += dateFull;

    let company = document.getElementById("aCompany");
    company.innerText = activityDetail.companyName;
    company.setAttribute("href", "company/company?companyId="+activityDetail.companyId);

    let activityContent = document.getElementById("activityContent");
    activityContent.innerText = activityDetail.activityContent;


    let teacherId = activityDetail.teacherId;
    getTeacherInfo(teacherId);
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

function getRemainTime(stopApplyTime) {
    let timestampNow = (new Date()).valueOf();
    if(timestampNow >= stop())
        return -1;
    else {
        let timestampRemain = parseInt(stopApplyTime) -parseInt(timestampNow);
        //剩余的天数
        let days = timestampRemain/ 86400000;

        //let minus = ((timestampRemain/ % 3600000) / 60000;
    }
}


/**
 *报名
 */
function signInForActivity() {

}