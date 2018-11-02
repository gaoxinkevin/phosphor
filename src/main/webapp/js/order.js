
const clientOrderUrl = 'http://localhost:1250';
const courseUrl =  clientOrderUrl+ "/courseUi/courseInfoUi/";
const activityUrl =  clientOrderUrl+ "/activityUi/activityInfoUi/";
const chooseChildUrl = clientOrderUrl + '/order/orderChild?childId=';
const currentOrderUrl = clientOrderUrl + '/order/currentOrder';
const orderPayUrl = clientOrderUrl + '/order/orderPay';
const letPayUrl = clientOrderUrl + '/orderUi/confirmOrder';
const orderUrl = clientOrderUrl + '/orderUi/orderUi/';



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

/**
 * 绘制课程的表格
 * @param detail 订单详情
 * @return {HTMLElement}
 */
function getDetail (detail){
    console.log(detail);
    let detailUrl="";
    if (detail.type==="课程") {
        detailUrl=courseUrl+detail.id;
    } else {
        detailUrl=activityUrl+detail.id;
    }
    let otr = document.createElement("tr");
    let td1 = document.createElement("td");
    let adetail1 = document.createElement("a");
    adetail1.setAttribute("href",detailUrl);
    let imageGroup = document.createElement("img");
    imageGroup.setAttribute("src", detail.photo);
    imageGroup.setAttribute("width","80");
    imageGroup.setAttribute("height","80");
    adetail1.appendChild(imageGroup);
    td1.appendChild(adetail1);

    let td2 = document.createElement("td");
    let adetail2 = document.createElement("a");
    adetail2.setAttribute("href",detailUrl);
    let smalltype = document.createElement("mark");
    smalltype.innerText=detail.type;
    let pname =document.createElement("p");
    pname.innerText= detail.name;
    adetail2.appendChild(smalltype);
    adetail2.appendChild(pname);
    td2.appendChild(adetail2);

    let td3 = document.createElement("td");
    td3.setAttribute("width","120");
    td3.innerText="￥"+detail.price;
    let td4 = document.createElement("td");
    td4.setAttribute("width","80");
    let marktype = document.createElement("mark");
    marktype.innerText=detail.type;
    if (0===detail.state) {
        marktype.innerText="未开始";
    } else if (1===detail.state) {
        marktype.innerText="正在进行";
    } else if (2===detail.state) {
        marktype.innerText="去评价";
    }else {
        marktype.innerText="完成";
    }
    td4.appendChild(marktype);
    otr.appendChild(td1);
    otr.appendChild(td2);
    otr.appendChild(td3);
    otr.appendChild(td4);
    return otr;
}

/**
 * 绘制订单的表头
 * @param order 订单数据
 * @return {HTMLElement}
 */
function generateOrderDiv (order){

    let divGrid = document.createElement("div");
    divGrid.classList.add("mn","row");
    let divBox = document.createElement("div");
    divBox.classList.add("col-md-12");
    let tableOrder = document.createElement("table");
    tableOrder.classList.add("dt", "mtm");
    tableOrder.setAttribute("cellPadding","0");
    tableOrder.setAttribute("cellSpacing","0");

    let captionName =document.createElement("caption");
    let hmbm = document.createElement("h2");
    hmbm.classList.add("mbm","xs2");
    let astate = document.createElement("a");
    astate.classList.add("xi2","xs1","xw0","y");
    if (order.orderState===0) {
        astate.innerText = "交易失败";
        astate.setAttribute("style","color:red;");
    } else {
        astate.innerText = "交易成功";
    }
    hmbm.appendChild(astate);
    hmbm.innerHTML += order.orderEndTime+"    订单号:"+order.orderNumber;
    captionName.appendChild(hmbm);
    tableOrder.appendChild(captionName);
    let otbody = document.createElement("tbody");
    let otr = document.createElement("tr");
    let th1 = document.createElement("th");
    th1.setAttribute("width","80");
    th1.innerText = "孩子:"+order.childId;
    let th2 = document.createElement("th");
    th2.innerText = "订单总金额:"+order.orderPrice;
    let th3 = document.createElement("th");
    th3.setAttribute("width","120");
    let th4 = document.createElement("th");
    th4.setAttribute("width","80");
    let ay =document.createElement("a");
    ay.setAttribute("href",orderUrl+order.orderId);
    ay.classList.add("xi2","xs1","xw0","y");
    ay.innerText = "查看更多»";
    th4.appendChild(ay);
    otr.appendChild(th1);
    otr.appendChild(th2);
    otr.appendChild(th3);
    otr.appendChild(th4);
    otbody.appendChild(otr);
    for(let i = 0; i < order.details.length ; i++) {
        let detail=getDetail(order.details[i]);
        otbody.appendChild(detail);
    }
    tableOrder.appendChild(otbody);
    divBox.appendChild(tableOrder);
    divGrid.appendChild(divBox);
    return divGrid;
}

/**
 * 选择孩子的表单提交
 */
childInfo = () => {

    let child = document.getElementById("selectPicker");
    let index = child.selectedIndex;

    let childId = child.options[index].value;
    const getChildInfo = () => getJson(chooseChildUrl+childId);

    getChildInfo().then(res => {
        if(res.code<=30000){

        }else{
            console.log(res.data);
        }
    }).catch(res => {
        console.log(res);
    });
};

/**
 * 弹出
 * @param message
 */
selectChild = (message) => {
    document.body.style.overflowX = "hidden";
    document.body.style.overflowY = "hidden";
    let dialog = document.getElementById("dialog");
    let vModal =document.getElementById("v-modal");
    let dialogPInnerHtml = document.getElementById("dialogPInnerHtml");
    let elButton = document.getElementById("el-button");
    const cancelBtn = document.getElementById("cancel-button");
    elButton.innerText="新增孩子";
    cancelBtn.innerText = "返回选择";
    elButton.style.padding = "0.8em 2em";
    elButton.setAttribute("href","/childrenUi/infoUi");
    cancelBtn.setAttribute("href","javascript:void(0)");
    cancelBtn.setAttribute("onclick","cancelDialog()");
    vModal.style.display="block";
    dialog.style.display="block";
    dialogPInnerHtml.innerText=message;
};

cancelDialog =() =>{
    document.body.style.overflowX = "visible";
    document.body.style.overflowY = "visible";
    let dialog = document.getElementById("dialog");
    let vModal =document.getElementById("v-modal");
    vModal.style.display="none";
    dialog.style.display="none";
};

function str_encrypt(str) {
    console.log(str);
    console.log(str.charCodeAt(0));
    var c = String.fromCharCode(str.charCodeAt(0) + str.length);

    for (var i = 1; i < str.length; i++) {
        c += String.fromCharCode(str.charCodeAt(i) + str.charCodeAt(i - 1));
    }

    return encodeURIComponent(c);
}

btnOrder = () => {
    let getOrder = () => getJson(currentOrderUrl);
    getOrder().then(res => {
        console.log(res);
        if(res.code<=30000){
            if(res.data.childId!=null){
                let getOrderPay = () => getJson(orderPayUrl);
                getOrderPay().then(res => {
                    if(res.code<=30000){
                        let a="http://localhost:8888/pay?id="+JSON.parse(localStorage.getItem("userLoginPhone")).val
                            +"&money="+localStorage.getItem("money")+"&orderId="+str_encrypt(res.data.toString());
                        window.location.href=a;
                    }else{
                        console.log(res.data);
                    }
                }).catch(res => {
                    console.log(res);
                });
            }else{
                selectChild();
            }
        }else{
            console.log(res.data);
        }
    }).catch(res => {
        console.log(res);
    });
};

getValidateDetail = (detail) => {

    let detailUrl="";
    if (detail.type==="课程") {
        detailUrl=courseUrl+detail.id;
    } else {
        detailUrl=activityUrl+detail.id;
    }
    let otr = document.createElement("tr");
    otr.classList.add("sd_box");
    let td1 = document.createElement("td");
    let adetail1 = document.createElement("a");
    adetail1.setAttribute("href",detailUrl);
    let imageGroup = document.createElement("img");
    imageGroup.setAttribute("src", detail.photo);
    imageGroup.setAttribute("width","100");
    imageGroup.setAttribute("height","100");
    adetail1.appendChild(imageGroup);
    td1.appendChild(adetail1);

    let td2 = document.createElement("td");
    let adetail2 = document.createElement("a");
    adetail2.setAttribute("href",detailUrl);
    let smalltype = document.createElement("mark");
    smalltype.innerText=detail.type;
    let pname =document.createElement("p");
    pname.innerText= detail.name;
    adetail2.appendChild(smalltype);
    adetail2.appendChild(pname);
    td2.appendChild(adetail2);
    let td3 = document.createElement("td");
    td3.setAttribute("width","150");
    td3.innerText=detail.companyName;

    let td4 = document.createElement("td");
    td4.setAttribute("width","150");
    td4.innerText="￥"+detail.price;

    let td5 = document.createElement("td");
    td5.setAttribute("width","100");
    let marktype = document.createElement("mark");
    marktype.innerText=detail.type;
    if (0===detail.state) {
        marktype.innerText="未开始";
    } else if (1===detail.state) {
        marktype.innerText="正在进行";
    } else if (2===detail.state) {
        marktype.innerText="去评价";
    }else {
        marktype.innerText="完成";
    }
    td5.appendChild(marktype);
    otr.appendChild(td1);
    otr.appendChild(td2);
    otr.appendChild(td3);
    otr.appendChild(td4);
    otr.appendChild(td5);
    return otr;
};
