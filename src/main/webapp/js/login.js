function isQuotaExceeded(e) {
    let quotaExceeded = false;
    if (e) {
        if (e.code) {
            switch (e.code) {
                case 22:
                    quotaExceeded = true;
                    break;
                case 1014: // Firefox
                    if (e.name === 'NS_ERROR_DOM_QUOTA_REACHED') {
                        quotaExceeded = true;
                    }
                    break;
            }
        } else if (e.number === -2147024882) { // IE8
            quotaExceeded = true;
        }
    }
    return quotaExceeded;
}

function getLocalStorage(key) {
    let exp = 1000 * 60 * 30; // 一天的秒数
    if (localStorage.getItem(key)) {
        let vals = localStorage.getItem(key); // 获取本地存储的值
        let dataObj = JSON.parse(vals); // 将字符串转换成JSON对象
        // 如果(当前时间 - 存储的元素在创建时候设置的时间) > 过期时间
        let isTimed = (new Date().getTime() - dataObj.timer) > exp;
        if (isTimed) {
            console.log("存储已过期");
            window.location.href = "http://localStroage:1250/loginUi/returnIndexPage";
            localStorage.removeItem(key);
            return null;
        } else {
            let newValue = dataObj.val;
        }
        return newValue;
    } else {
        return null;
    }
}

window.onunload = function () {
    localStorage.clear();
};