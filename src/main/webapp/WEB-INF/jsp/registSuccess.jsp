<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2017/8/6
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="refresh" content="3;url=${ pageContext.request.contextPath }/index.jsp"/>
    <title>注册成功</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="divcontent">
    <table width="60%" border="0" cellspacing="0" style="margin:200px auto">
        <tr>
            <td style="width:98px"><img src="${pageContext.request.contextPath}/images/IconTexto_WebDev_009.jpg" width="128" height="128" /></td>
            <td>&nbsp;</td>&nbsp;<td>&nbsp;</td><td>&nbsp;</td>
            <td style="padding-top:30px">
                <font color="red" size="5">注册成功！</font><br/><br/>
                <a style="text-decoration: none;color: blue"href="${ pageContext.request.contextPath }/index.jsp">三秒后将自动跳转到首页，若浏览器未响应请点击这里......</a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>