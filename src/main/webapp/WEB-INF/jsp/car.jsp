<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2017/8/8
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>购物车</title>

    <link href=" ${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css">
    <link href=" ${pageContext.request.contextPath}/css/cart.css" rel="stylesheet" type="text/css">

    ${pageContext.request.contextPath}
</head>
<body>
<div class="container header">
    <%@include file="header.jsp"%>
    <%@include file="menu.jsp"%>

</div>
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
                <th>操作</th>
            </tr>
        <%--循环输出购物车里面的商品--%>
      <c:forEach items="${car.linkedHashMap}" var="entry">
            <tr>
                <td width="60">
                    <input type="hidden" name="id" value="22">
                   <%-- <img src="${pageContext.request.contextPath}/<s:property value="model.image"/>">--%>
                    <img src="${entry.value.image}">
                </td>
                <td>
                    <%--<a target="_blank"><s:property value="model.pname"/></a>--%>
                        ${entry.value.pname}
                </td>
                <td>
                   <%-- <s:property value="model.shop_price"/>--%>
                           ${entry.value.shop_price}
                </td>
                <td class="quantity" width="60">
                    <%--<s:property value="model.quantity"/>--%>
                            ${entry.value.quantity}
                </td>
                <td width="140">
                   <%-- <span class="subtotal"><s:property value="model.total"/></span>--%>
                           ${entry.value.total}
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/removeProduct.action?pid=${entry.value.pid}">删除</a>
                </td>
            </tr>
      </c:forEach>

            </tbody>
        </table>
        <dl id="giftItems" class="hidden" style="display: none;">
        </dl>
        <c:choose>
            <c:when test="${empty car.linkedHashMap}">
               <center> <font color="#dc143c" size="5">亲！购物车空空如也，快去购物吧 ^_^ </font></center>
            </c:when>

            <c:otherwise>
                <div class="bottom">
                    <a href="${pageContext.request.contextPath}/clearCar.action" id="clear" class="clear">清空购物车</a>
                    <a href="${pageContext.request.contextPath}/saveOrder.action" id="submit" class="submit">提交订单</a>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</div>

<%--底部--%>
<%@include file="footer.jsp"%>
</body>
</html>