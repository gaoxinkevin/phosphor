const clientGroupUrl = 'http://localhost:1250';
const courseUrl = clientGroupUrl+ "/courseUi/courseInfoUi/";
const addCourseUrl = clientGroupUrl+ "/group/addCourse";
const delCourseUrl= clientGroupUrl+ "/group/delCourse";
const optionUrl =  clientGroupUrl+ "/group/delSession";
const addGroupUrl = clientGroupUrl+ "/group/addGroup";
const orderUrl =  clientGroupUrl+"/orderUi/orderGroupUi/";
const groupUrl = clientGroupUrl + '/groupUi/groupUi/';
const getGroupUrl = clientGroupUrl + '/group/group/';
const recommendGroupUrl = clientGroupUrl + '/group/groupRecommend';

let a = localStorage.getItem("userLoginPhone");
if (a === null) {
    localStorage.clear();
    window.location.href =clientGroupUrl+ "/indexUi/returnIndexPage"
}


function generateCourseDiv(course) {
    let divMedia = document.createElement("div");
    divMedia.classList.add("media");
    let div2 = document.createElement("div");
    div2.classList.add("col-md-2");
    let ablock =document.createElement("a");
    ablock.setAttribute("style","display:block;");
    ablock.setAttribute("href",courseUrl+course.courseId);
    let image =document.createElement("img");
    image.setAttribute("src",course.courseSf);
    image.classList.add("img-responsive", "alignleft", "img-rounded");
    ablock.appendChild(image);
    div2.appendChild(ablock);
    let div10 = document.createElement("div");
    div10.classList.add("col-md-10");
    let htt =document.createElement("h4");
    htt.classList.add("mt-0");
    let att =document.createElement("a");
    att.setAttribute("href",courseUrl+course.courseId);
    att.innerText = course.courseName+"   "+course.courseDesc;
    htt.appendChild(att);
    let divMeta = document.createElement("div");
    divMeta.classList.add("blog-meta");
    let ulcou = document.createElement("ul");
    ulcou.classList.add("media-list")
    let liStart =document.createElement("li");
    liStart.innerText="开课时间:"+course.courseStartDay;
    let licont =document.createElement("li");
    licont.innerText="持续时间:"+course.courseContinuedTime+"周";
    let liTime =document.createElement("li");
    liTime.innerText= "上课时间:"+course.courseStartTime+"-"+course.courseEndTime;
    let liPrice =document.createElement("li");
    let spanDesc = document.createElement("span");
    spanDesc.innerText="课程原价:"
    let spanPrice = document.createElement("span");
    spanPrice.setAttribute("style","color:red");
    spanPrice.innerText="￥"+course.coursePrice;
    liPrice.appendChild(spanDesc);
    liPrice.appendChild(spanPrice);
    let liAdrs =document.createElement("li");
    liAdrs.innerText="上课地点:"+course.courseAddress;
    ulcou.appendChild(liStart);
    ulcou.appendChild(licont);
    ulcou.appendChild(liTime);
    ulcou.appendChild(liPrice);
    ulcou.appendChild(liAdrs);
    divMeta.appendChild(ulcou);
    div10.appendChild(htt);
    div10.appendChild(divMeta);
    divMedia.appendChild(div2);
    divMedia.appendChild(div10);
    return divMedia;
}

generateGroupDiv = (group) => {
    let divGrid = document.createElement("div");
    divGrid.classList.add("col-md-4");
    let divBox = document.createElement("div");
    divBox.classList.add("course-box", "shop-wrapper");
    let divImage = document.createElement("div");
    divImage.classList.add("image-wrap", "entry");

    let imageGroup = document.createElement("img");
    imageGroup.setAttribute("src", group.groupPhoto);
    imageGroup.setAttribute("alt", "");
    imageGroup.classList.add("img-responsive");

    let divMagnifier = document.createElement("div");
    divMagnifier.classList.add("magnifier");
    let aHead  = document.createElement("a");
    aHead.setAttribute("href",groupUrl+group.groupId);
    let icon = document.createElement("i");
    icon.classList.add("flaticon-add");
    aHead.appendChild(icon);
    divMagnifier.appendChild(aHead);
    divImage.appendChild(imageGroup);
    divImage.appendChild(divMagnifier);
    divBox.appendChild(divImage);

    let divDetails = document.createElement("div");
    divDetails.classList.add("course-details", "shop-box", "text-center");
    let hFour = document.createElement("h4");
    let aMid = document.createElement("a");
    aMid.setAttribute("href",groupUrl+group.groupId);
    aMid.innerText = group.groupName;
    let groupNum = document.createElement("small");
    groupNum.innerText="课程 x"+group.groupCourseNumber;
    hFour.appendChild(aMid);
    hFour.appendChild(groupNum);
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
    aLeft.setAttribute("href",groupUrl+group.groupId);
    aLeft.innerText = "￥"+group.groupPrice;
    liLeft.appendChild(aLeft);
    ulLeft.appendChild(liLeft);
    divLeft.appendChild(ulLeft);

    let divRight = document.createElement("div");
    divRight.classList.add("pull-right");
    let ulRight = document.createElement("ul");
    ulRight.classList.add("list-inline");
    let liRight = document.createElement("li");
    let aRight = document.createElement("a");
    aRight.setAttribute("href",groupUrl+group.groupId);
    aRight.innerText = "立即购买";
    liRight.appendChild(aRight);
    ulRight.appendChild(liRight);
    divRight.appendChild(ulRight);

    divFooter.appendChild(divLeft);
    divFooter.appendChild(divRight);
    divBox.appendChild(divFooter);
    divGrid.appendChild(divBox);
    return divGrid;
};
/**
 * post 方法访问网站
 * @Param url 访问地址
 * @Param method 请求方法
 * @param data 上传数据
 */
const postJson = ({ url, method, data }) => {
    return new Promise((resolve, reject) => {
        const client = new XMLHttpRequest();
        client.open(method, url);
        client.responseType = 'json';
        client.setRequestHeader("Content-Type", "application/json; charset=utf-8");
        client.onreadystatechange = () => {
            if (client.readyState === 4) {
                if (client.status === 200) {
                    resolve(client.response);
                } else {
                    reject(client.status);
                }
            }
        };
        client.send(data);
    });
};
/**
 * get 方法访问网站
 * @Param url 访问地址
 */
const getJson = (url) => {
    return new Promise((resolve, reject) => {
        const client = new XMLHttpRequest();
        client.open("GET", url);
        client.responseType = 'json';
        client.setRequestHeader("Content-Type", "application/json; charset=utf-8");
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

setGroupDiy = (group) => {
    let divGroupPrice = document.getElementById("groupPrice");
    let divNumber = document.getElementById("groupCourseNumber");
    let divDiscount = document.getElementById("groupDiscount");
    let price = 0;
    divNumber.innerText =group.courseInfos.length;
    divDiscount.innerText ="￥"+ group.groupPrice;
    for (let i = 0; i <group.courseInfos.length; i++) {
        console.log(group.courseInfos[i]);
        price+=group.courseInfos[i].coursePrice;
    }
    divGroupPrice.innerText="￥"+price;

};
setGroupNull = () =>{
    let divGroupPrice = document.getElementById("groupPrice");
    let divNumber = document.getElementById("groupCourseNumber");
    let divDiscount = document.getElementById("groupDiscount");
    divNumber.innerText = 0;
    divDiscount.innerText ="￥"+ 0;
    divGroupPrice.innerText="￥"+0;
}
/**
 * 清空session和界面的选择课程
 */
optionError = () => {
    let delSession = () => getJson(optionUrl);
    delSession().then(res => {
        if(res.code<=30000){
            let divBody = document.getElementById("divBody");
            divBody.innerHTML="";
            setGroupNull();
            submit.disabled=true;
            closeImg();
        }else {
            console.log("删除失败!")
        }
    }).catch(res => {
        console.log(res);
    });

};
/**
 * 取消选择
 * @param courseId 课程编号
 */
cancelChoose = (courseId) => {
    let divBody = document.getElementById(courseId);
    let course = {
        courseId:courseId
    };
    let getCourseInfo = (data) => postJson(
        {
            url:delCourseUrl,
            method: "POST",
            data
        });
    getCourseInfo(JSON.stringify(course)).then((res) => {
        if (res.code<=30000) {
            divBody.parentNode.removeChild(divBody);
            setGroupDiy(res.data);
            if(res.data.courseInfos.length===0){
                closeImg();
            }
            if (res.data.courseInfos.length<= 1){
                submit.disabled=true;
            }

        }else {
            console.log(res);
        }
    }).catch(error => {
        console.log(error);
    });
};
/**
 * 添加课程
 * @param courseId 课程编号
 */
addCourse=(courseId)=>{

    let course = {
        courseId:courseId
    };
    let getCourseInfo = (data) => postJson(
        {
            url:addCourseUrl,
            method: "POST",
            data
        });
    console.log(JSON.stringify(course));
    getCourseInfo(JSON.stringify(course)).then((res) => {
        if (res.code<=30000) {
            let submit = document.getElementById("submit");
            if (res.data.courseInfos.length>1){
                submit.disabled=false;
            }
            let divBody = document.getElementById("divBody");
            divBody.innerHTML = "";
            showImg();
            for (let i = 0; i < res.data.courseInfos.length; i++) {
                let divGrid = getCourse(res.data.courseInfos[i]);
                divBody.appendChild(divGrid);
            }
            setGroupDiy(res.data);
        }else {
            if (res.code===50000) {
                overMax(res.message);
            }
            else if(res.code===40100){
                courseConflict(res.message);
            }
            else if(res.code===40200){
                courseConflict(res.message);
            }
        }
    }).catch(error => {
        console.log(error);
    });
};

showImg　= () =>{
    let cover = document.getElementById("cover");
    let content = document.getElementById("content");
    cover.style.display="none";
    cover.setAttribute("display","none");
    content.style.display="block";
    content.setAttribute("display","block");

};

closeImg　= () =>{
    let cover = document.getElementById("cover");
    let content = document.getElementById("content");
    cover.style.display="block";
    cover.setAttribute("display","block");
    content.style.display="none";
    content.setAttribute("display","none");
};
/**
 * 绘制选择课程
 * @param course 课程信息
 * @returns {HTMLElement} 绘制的table row
 */
getCourse = (course) => {

    let otr = document.createElement("tr");
    otr.setAttribute("id",course.courseId);
    otr.classList.add("sd_box");
    let td1 = document.createElement("td");
    let adetail1 = document.createElement("a");
    adetail1.setAttribute("href",courseUrl+course.courseId);
    let imageGroup = document.createElement("img");
    imageGroup.setAttribute("src", course.courseSf);
    imageGroup.setAttribute("width","80");
    imageGroup.setAttribute("height","80");
    adetail1.appendChild(imageGroup);
    td1.appendChild(adetail1);

    let td2 = document.createElement("td");
    let adetail2 = document.createElement("a");
    adetail2.setAttribute("href",courseUrl+course.courseId);
    let pname =document.createElement("p");
    pname.innerText= course.courseName;
    adetail2.appendChild(pname);
    td2.appendChild(adetail2);

    let td3 = document.createElement("td");
    td3.setAttribute("width","120");
    td3.innerText="￥"+course.coursePrice;
    td3.setAttribute("style","color:red;");
    let td4 = document.createElement("td");
    td4.setAttribute("width","80");

    let marktype = document.createElement("a");
    marktype.setAttribute("href","javascript:cancelChoose("+course.courseId+")");
    marktype.innerText="取消";
    td4.appendChild(marktype);
    otr.appendChild(td1);
    otr.appendChild(td2);
    otr.appendChild(td3);
    otr.appendChild(td4);
    return otr;
};

addGroup = () => {
    let delSession = () => getJson(addGroupUrl);
    delSession().then(res => {
        if(res.code<=30000){
            window.location.href = orderUrl+res.data;
        }else {
            console.log("创建套餐失败!")
        }
    }).catch(res => {
        console.log(res);
    });
};
overMax = (message) => {
    document.body.style.overflowX = "hidden";
    document.body.style.overflowY = "hidden";
    let dialog = document.getElementById("dialog");
    let vModal =document.getElementById("v-modal");
    let dialogPInnerHtml = document.getElementById("dialogPInnerHtml");
    let elButton = document.getElementById("el-button");

    elButton.innerText="继续添加";
    elButton.style.padding = "0.5em 1em";
    elButton.setAttribute("href","javascript:void(0)");
    elButton.setAttribute("onclick","cancelDialog()");

    vModal.style.display="block";
    dialog.style.display="block";
    dialogPInnerHtml.innerText=message;
}

courseConflict = (message) => {
    document.body.style.overflowX = "hidden";
    document.body.style.overflowY = "hidden";
    let dialog = document.getElementById("dialog");
    let vModal =document.getElementById("v-modal");
    let dialogPInnerHtml = document.getElementById("dialogPInnerHtml");
    let elButton = document.getElementById("el-button");

    elButton.innerText="重新添加";
    elButton.style.padding = "0.5em 1em";
    elButton.setAttribute("href","javascript:void(0)");
    elButton.setAttribute("onclick","cancelDialog()");

    vModal.style.display="block";
    dialog.style.display="block";
    dialogPInnerHtml.innerText=message;
}

cancelDialog =() =>{
    document.body.style.overflowX = "visible";
    document.body.style.overflowY = "visible";
    let dialog = document.getElementById("dialog");
    let vModal =document.getElementById("v-modal");
    vModal.style.display="none";
    dialog.style.display="none";
}