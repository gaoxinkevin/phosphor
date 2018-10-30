<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <title></title>
    <style type="text/css">
        body {
            font-family: pingfang sc light;
        }
        .center{
            text-align: center;
            width: 100%;
        }
    </style>
</head>
    <body>
    <div class="page">
        <div class="page-header">
            <img src="/images/logo.png" alt="phosphor教育">
        </div>
        <!--用户信息-->
        <div class="cr_userinfo">
            <table>
                <tbody>
                    <tr>
                        <td>订单编号：${orderId}</td>
                    </tr>
                    <tr>
                        <td>
                           用户姓名：${parent}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            孩子姓名：${child}
                        </td>
                    </tr>
                </tbody>
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
                        <th>商品类型</th>
                    </tr>
                   <#list details as detail>
                    <tr>
                        <td>${detail.id}</td>
                        <td><span>${detail.name}</span></td>
                        <td><span>${detail.price}</span></td>
                        <td><span>${detail.type}</span></td>
                    </tr>
                    </#list>
                </tbody>
            </table>
            <div>
                <ul>
                    <li>商品总额：<span>${orderPrice}</span></li>
                    <li>应付总额：<span>${orderPrice}</span></li>
                </ul>
            </div>
        </div>
        <hr class="separator">
        <h3>给孩子最好的成长，尽在phosphor教育</h3>
    </div>
    <span style="page-break-after:always;"></span>
    </body>
</html>