<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2017/8/9
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="S" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>订单页面</title>
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/cart.css" rel="stylesheet" type="text/css"/>

</head>
<body>

<div class="container header">
    <%@include file="header.jsp"%>
    <%@include file="menu.jsp"%>
</div>

<%--体--%>
<div class="container cart">
    <div class="span24">
        <div class="step step1">

        </div>
        <table>
            <tbody>
            <tr>
                <th>图片</th>
                <th>商品</th>
                <th>价格</th>
                <th>数量</th>
                <th>小计</th>
            </tr>
            <%--！！！！--%>
            <s:iterator value="model.orderItems" var="item">
                <tr>
                    <td width="60">
                        <input type="hidden" name="id" value="22"/>
                        <img src="${pageContext.request.contextPath}/<s:property value='#item.product.image'/>"/>
                    </td>
                    <td>
                        <a target="_blank"><s:property value='#item.product.pname'/></a>
                    </td>
                    <td>
                        <s:property value='#item.product.shop_price'/>
                    </td>
                    <td class="quantity" width="60">
                        <input type="text" name="count" readonly value="<s:property value='#item.count'/>" maxlength="4" onpaste="return false;"/>
                    </td>
                    <td width="140">
                        <span class="subtotal"><s:property value='#item.subtotal'/></span>
                    </td>
                </tr>
            </s:iterator>
            </tbody>
        </table>
        <dl id="giftItems" class="hidden" style="display: none;">
        </dl>
        <div class="total">
            <em id="promotion"></em>
            商品金额: <strong id="effectivePrice"><s:property value="model.total"/> </strong>
        </div>
        <%--============================================================================--%>
        <form id="orderForm" action="#" method="post">
            <input type="hidden" name="order.oid" value=""/>
            <div class="span24">
                <%--收货地址  收货人   联系方式--%>
                <p>
                    <font size="3" color="orange">收货地址：</font><input name="order.user.addr" type="text" value="" style="width:350px" />
                    <br />
                    <font size="3" color="orange">收货人:</font>&nbsp;&nbsp;&nbsp;<input name="order.user.username" type="text" value="" style="width:150px" />
                    <br />
                    <font size="3" color="orange">联系方式：</font><input name="order.user.phone" type="text"value="" style="width:150px" />
                </p>

            <%--支付--%>
                <hr />
                <p>
                    <font size="4"color="red">选择支付方式：</font><br/>
                    <input type="radio" name="pay" width="25px" value="zhifubao" checked="checked"/>支付宝
                    <img src="${pageContext.request.contextPath}/image/zfb.png" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="pay" value="weixin"/>微信
                    <img src="${pageContext.request.contextPath}/image/wx.jpg" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
                </p>
                <hr />
               <p style="text-align:right">
                    <button onclick="alert('尚未去通过第三方支付接口实现商品支付~')">
                        <font size="5" color="#dc143c">确认支付</font>
                    </button>
                </p>
            </div>
        </form>
    </div>
</div>
<%--底部--%>
<%@include file="footer.jsp"%>
</body>
</html>
