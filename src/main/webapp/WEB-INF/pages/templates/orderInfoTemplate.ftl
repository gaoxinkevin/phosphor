<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <title></title>
    <style type="text/css">
        body{
            font-family: SimSun;
            padding: auto;
        }

        @page  {
            size: A4;
        }
        div.div-common{
            width: 100%;
            margin-left: 15px;
            margin-right: 15px;
            margin-bottom: 25px;
            text-align: center;
        }
        table{
            width: 100%;
        }
        table.table-condensed{
            width: 100%;
        }
        tr.row-title{
            background-color: #aaaaaa;
        }
        tr{
            border-bottom: #aaaaaa solid 1px;
        }
    </style>
</head>
<body>
    <div class="div-common" style="margin-top: 40px">
        <img src="logo.png" alt=""/>
        <table class="table-condensed" style="border-top: #aaaaaa 2px solid; border-bottom: #aaaaaa 1px solid; margin-top: 25px">
            <tbody style="text-align: left">
            <tr>
                <td>订单编号：${orderNumber}</td>
            </tr>
            <tr>
                <td>订购时间：</td>
            </tr>
            <tr>
                <td>监护人姓名：${parent}</td>
            </tr>
            <tr>
                <td>孩子姓名：${child}</td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="div-common">
        <table style="margin-bottom: 50px">
            <tbody>
                <tr class="row row-title">
                    <th>商品名</th>
                    <th>商品类型</th>
                    <th>价格</th>
                </tr>
                <#list details as detail>
                <tr style="border-bottom: #aaaaaa solid 1px">
                    <td>
                        ${detail.name}
                    </td>
                    <td>
                        ${detail.type}
                    </td>
                    <td>
                        ￥ ${detail.price}
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
        <table class="table-condensed" style="text-align: left">
            <tr>
                <td>
                    总价：￥ ${orderPrice}
                </td>
            </tr>
            <tr>
                <td>
                    折扣：0
                </td>
            </tr>
            <tr>
                <td>
                    其他：
                </td>
            </tr>
            <tr>
                <td>
                    应付总额：￥ ${orderPrice}
                </td>
            </tr>
        </table>
    </div>
    <div style="text-align: center;">
        <h4 style="margin: auto; width: 100%">给孩子最好的未来 尽在启明星教育</h4>
    </div>
</body>
</html>