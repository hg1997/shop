<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2017/8/5
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container header">
    <%@include file="header.jsp" %>
    <%@include file="menu.jsp" %>
</div>
<%--体--%>

<div class="container login">
    <%--<div class="span12 last">--%>
      <%--  <div class="wrap">--%>
            <div class="main">
                <div class="title">
                    <strong>用户登录</strong>USER LOGIN
                    <font color="red" size="5">${msg}</font>
                </div>
                <form id="loginForm" action=" ${pageContext.request.contextPath}/login.action" method="post"
                      novalidate="novalidate">
                    <table align="center">
                        <tr>
                            <th>
                                用户名:
                            </th>
                            <td>
                                <input type="text" id="username" value="${user.username}" name="username" class="text"
                                       maxlength="20">
                            </td>
                        </tr>

                        <tr>
                            <th>
                                密&nbsp;&nbsp;码:
                            </th>
                            <td>
                                <input type="password" id="password" name="password" value="${user.password}"
                                       class="text" maxlength="20" autocomplete="off">
                            </td>
                        </tr>
                        <tr>
                            <th>&nbsp;</th>
                            <td>
                                <input type="submit" class="submit" value="登 录">
                            </td>
                        </tr>

                        <tr>
                            <th>&nbsp;
                            </th>
                            <td>
                                还没有注册账号？<a href="${pageContext.request.contextPath}/registPage.action"><font color="#f08080">立即注册</font></a>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
       <%-- </div>--%>
    <%--</div>--%>
</div>

<%--底部--%>
<%@include file="footer.jsp" %>
</body>
</html>

