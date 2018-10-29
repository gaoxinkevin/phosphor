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
        getCourseListByPage(0, pageSize);
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
        getCourseListByPage(0, pageSize);
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
 * @returns any
 */
function getXhr() {
    let request = null;
    if(window.XMLHttpRequest)
        request = new XMLHttpRequest();
    else
        request = new ActiveXObject("Microsoft.XMLHTTP");

    return request;
}

function generateDiv(courseInfo) {
    let divGrid = document.createElement("div");
    divGrid.classList.add("col-md-3");
    let divBox = document.createElement("div");
    divBox.classList.add("course-box", "shop-wrapper");
    let divImage = document.createElement("div");
    divImage.classList.add("image-wrap", "entry");

    let imageGroup = document.createElement("img");
    imageGroup.setAttribute("src", "/upload/kidcoding.jpeg");
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
    window.location.reload();
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
<<<<<<< HEAD

=======
}

function getAllCoureForGroup(){
    let request = null;
    if(window.XMLHttpRequest)
        request = new XMLHttpRequest();
    else
        request = new ActiveXObject('Microsoft.XMLHTTP');

    request.open("GET", "/course/getAllCourse", true);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
    request.send(null);

    request.onreadystatechange = function () {
        if(request.readyState == 4){
            if(request.status >= 200 && request.status<300 || request.status == 304)
                loadCourseForGroup(request.responseText);
        }
    }
}

function loadCourseForGroup(courseInfoListJson){
    let courseInfoList = JSON.parse(courseInfoListJson);
    let div = document.getElementById("courseGrid");
    let courseInfoListData = courseInfoList.data;

    for(let i = 0; i < courseInfoListData.length ; i++){

        let divGrid = generateSelect(courseInfoListData[i]);
        div.appendChild(divGrid);
    }
}

function generateSelect(courseInfo){
    let divGrid = document.createElement("div");
    divGrid.classList.add("col-md-3");
    let divBox = document.createElement("div");
    divBox.classList.add("course-box", "shop-wrapper");
    let divImage = document.createElement("div");
    divImage.classList.add("image-wrap", "entry");

    let imageGroup = document.createElement("img");
    imageGroup.setAttribute("src", "/upload/people.jpg");
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
    aLeft.setAttribute("href","javascript:addCourse("+courseInfo.courseId+")");
    aLeft.innerText = "加入套餐";

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
>>>>>>> devMaster
}