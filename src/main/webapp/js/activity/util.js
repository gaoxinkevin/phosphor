/**
 * 获取Xhr对象
 * @returns {any}
 */
function getXhr() {
    let request = null;
    if(window.XMLHttpRequest)
        request = new XMLHttpRequest();
    else
        request = new ActiveXObject("Microsoft.XMLHTTP");

    return request;
}


/**
 *
 * @param url   请求的url
 * @param method    请求方式{POST, GET...}
 * @param postData  如果为POST方式，发送的数据
 * @returns {null}  Json形式的请求结果
 */
function getResponseText(url, method, postData) {
    let request = getXhr();
    request.open(method, url, true);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request.send(postData);

    request.onreadystatechange = function () {
        if(request.readyState == 4){
            if(request.status >= 200 && request.status < 300 || request.status == 304){
                alert(request.responseText);
                return request.responseText;
            }
        }
    };
    return null;
}

/**
 * 将时间戳转换为日期时间类型
 * @param timestamp
 * @returns {string}
 */
function timestampToDate(timestamp) {
    let date = new Date(timestamp);
    let Y = date.getFullYear() + ' 年';
    let M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + ' 月';
    let D = date.getDate() + ' 日 ';
    let h = date.getHours() + ':';
    let m = date.getMinutes() + ':';
    let s = date.getSeconds();

    return Y+M+D+h+m+s;
}