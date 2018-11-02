document.write("<script type='text/javascript' language='JavaScript' src='/js/activity/util.js'></script>");

/**
 * 获取订单信息
 */
function getOrderInfo(orderId) {
    let request = getXhr();
    request.open("GET", "/order/downloadOrderPDF?orderId="+orderId, true);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request.send(null);
}


/**
 * 发送请求下载PDF文件
 */
function download() {
    let request = getXhr();
    request.open("GET", "/order/downloadOrderPDF", true);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request.send(null);
}