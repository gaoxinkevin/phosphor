<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <title></title>
    <style type="text/css">

    </style>
</head>
<body>
    <div class="page">
        <div class="page-header">
            <img src="${logoUrl}" alt="phosphor教育">
        </div>
        <!--用户信息-->
        <div class="cr_userinfo">
            <table>
                <tr>
                    <td>订单编号：${orderCode}</td>
                    <td>订购时间：${orderTime}</td>
                </tr>
                <tr>
                    <td colspan="2">
                       用户姓名：${userName}
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        联系方式：${phoneOrEmail}
                    </td>
                </tr>
                <tr>
                    <td>
                        孩子姓名：${childName}
                    </td>
                </tr>
            </table>
        </div>
        <!--订单信息-->
        <div class="order-info">
            <table>
                <tbody>
                    <tr>
                        <th>商品编号</th>
                        <th>商品名称</th>
                        <th>商品金额</th>
                    </tr>
                    <#list commodityList as commodity>
                    <tr>
                        <td>${commodity.commodityCode}</td>
                        <td><span>${commodity.commodityName}</span></td>
                        <td><span>${commodity.commodityPrice}</span></td>
                    </tr>
                    </#list>
                </tbody>
            </table>
            <div>
                <ul>
                    <li>商品总额：<span>${totalPrice}</span></li>
                    <li>折&nbsp;&nbsp;&nbsp;&nbsp;扣<span>${discount}</span></li>
                    <li>应付总额：<span>${taotalPay}</span></li>
                </ul>
            </div>
        </div>
        <hr class="separator">
        <h3>给孩子最好的成长，尽在phosphor教育</h3>
    </div>
</body>