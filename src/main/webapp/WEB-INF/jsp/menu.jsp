<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2017/8/5
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>menu</title>
</head>
<body>
<div class="span24">
    <ul class="mainNav">
        <li>
            <a href="${pageContext.request.contextPath}/index.action">首页</a>
            |
        </li>
        <%--循环：显示一级目录，从数据库读取一次，存入session--%>
  <s:iterator value="#session.clist" var="c">
        <li>
            <a href="${pageContext.request.contextPath}/category.action?page=1&cid=<s:property value='#c.cid'/>"><s:property value="#c.cname"/></a>
            |
        </li>
  </s:iterator>
    </ul>
</div>
</body>
</html>
