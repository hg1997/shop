<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2017/8/5
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>商城主页</title>
    <%--<link href="${pageContext.request.contextPath}/css/slider.css" rel="stylesheet" type="text/css"/>--%>
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css"/>

</head>
<body bgcolor="red">
<div class="container header">
    <%@include file="header.jsp"%>
    <%@include file="menu.jsp"%>
</div>

<%--体--%>
<div class="container index">
    <%--新添商品--%>
    <div class="span24">
        <div id="newProduct" class="newProduct clearfix">
            <div class="title">
                <strong>新添商品</strong>
                <a  target="_blank"></a>
            </div>
            <%--<ul class="tab"></ul>--%>
            <%--新添商品 循环显示--%>
            <ul class="tabContent" style="display: block;">
                <s:iterator value="newList" var="n">
                    <li>
                        <a href="${pageContext.request.contextPath}/product_show.action?pid=<s:property value='#n.pid'/>" target="_blank"><img src="${pageContext.request.contextPath}/<s:property value="#n.image"/>" data-original="http://storage.shopxx.net/demo-image/3.0/201301/4a51167a-89d5-4710-aca2-7c76edc355b8-thumbnail.jpg" style="display: block;"></a>
                    </li>
                </s:iterator>
            </ul>
        </div>
    </div>

   <%--热门--%>
    <div class="span24">
        <div id="hotProduct" class="hotProduct clearfix">
            <div class="title">
                <center><strong>人气商品</strong></center>
            </div>
           <%-- <ul class="tab"></ul>--%>
            <%--热门商品  循环显示--%>
            <ul class="tabContent" style="display: block;">
                <s:iterator value="hotList" var="h">
                <li>
                    <a href="${pageContext.request.contextPath}/product_show.action?pid=<s:property value='#h.pid'/>" target="_blank"><img src="${pageContext.request.contextPath}/<s:property value='#h.image'/>" data-original="http://storage.shopxx.net/demo-image/3.0/201301/0ff130db-0a1b-4b8d-a918-ed9016317009-thumbnail.jpg" style="display: block;"></a>
                </li>
                </s:iterator>
            </ul>
        </div>
    </div>
</div>

<%--底部--%>
<%@include file="footer.jsp"%>
</body>
</html>