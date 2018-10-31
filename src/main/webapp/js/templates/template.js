document.write("<script type='text/javascript' language='JavaScript' src='/js/activity/util.js'></script>");

/**
 * 获取订单信息
 */
function getOrderInfo(orderId) {
    let request = getXhr();
    request.open("GET", "/order/order?orderId="+orderId, true);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request.send(null);

    request.onreadystatechange = function () {
        if(request.readyState == 4){
            if(request.status >= 200 && request.status < 300 || request.status == 304){
                loadOrderInfoToTemplate(request.responseText);
            }
        }
    };

    downloadPDF();
}

/**
 * 将信息渲染到模板页
 * @param responseText
 */
function loadOrderInfoToTemplate(responseText) {
    let orderInfo = JSON.parse(responseText).data;

    let orderCode = document.getElementById("order-code");
    orderCode.innerText += orderInfo.orderNumber;

    let orderCreateTime = document.getElementById("create-time");
    orderCreateTime.innerText += timestampToDate(orderInfo.orderCreateTime);

    let parentName = document.getElementById("parent-name");
    parentName.innerText += orderInfo.parent;

    let details = document.getElementById("details");
    let detailList = orderInfo.details;
    for (let i = 0; i < detailList.length; i++){
        let innerText = "<tr><td>"+detailList[i].id+"</td><td>"+detailList[i].name+"</td><td>"+detailList[i].type+"</td><td>"+detailList[i].price+"</td></tr>";
        details.innerText += innerText;
    }

    let totalPrice = document.getElementById("total-price");
    totalPrice.innerText += orderInfo.orderPrice;

    let discount = document.getElementById("discount");
    discount.innerText += "0";

    let totalPay = document.getElementById("total-pay");
    totalPay.innerText += orderInfo.orderPrice;
}

/**
 * 发送请求下载PDF文件
 */
function downloadPDF() {
    let request = getXhr();
    request.open("GET", "/order/downloadOrderPDF", true);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request.send(null);
}