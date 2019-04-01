<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2017/8/5
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>header</title>
</head>
<body>

<div class="span5">
    <div class="logo">
        <a href="${pageContext.request.contextPath}/index.action">
            <img src="${pageContext.request.contextPath}/image/LOGO.jpg" alt="乐购"/>
        </a>
    </div>
</div>

<div class="span9">
    <div class="headerAd">
        <%----%>
        <img src="${pageContext.request.contextPath}/image/header2.jpg" width="320px" height="50px" alt="顾客就是上帝" />
    </div>
</div>

<div class="span10 last">
    <div class="topNav clearfix">
        <ul>
            <c:choose>
                <c:when test="${empty sessionScope.user}"> <%--没登录--%>
                    <li id="headerLogin" class="headerLogin" style="display: list-item;">
                        <a href="${pageContext.request.contextPath}/loginPage.action"><font color="#00a1e9"  size="3">登录</font></a>|
                    </li>
                    <li id="headerRegister" class="headerRegister" style="display: list-item;">
                        <a href="${pageContext.request.contextPath}/registPage.action"><font color="#00a1e9" size="3">注册</font></a>
                    </li>
                </c:when>
                <c:otherwise><%--登陆了--%>
                    <li id="headerLogin" class="headerLogin" style="display: list-item;">
                        <a href="${pageContext.request.contextPath}/loginPage.action">${sessionScope.user.username}</a>|
                    </li><%--我的订单--%>
                    <li id="headerOrder" class="headerOrder" style="display: list-item;">
                        <a href="${ pageContext.request.contextPath }/orderList.action?page=1">我的订单</a>|
                    </li>
                    <li id="headerLogout" class="headerLogout" style="display: list-item;">
                        <a href="${pageContext.request.contextPath}/invalidate.action">退出</a>|
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>

        <span class="cart">
                <a href="${pageContext.request.contextPath}/toCar.action">购物车</a>
        </span>
    </div>
</div>

</body>
</html>
