<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2017/8/8
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>left</title>
</head>
<body>
<div class="span6">
    <div class="hotProductCategory">
        <%----%>
        <s:iterator var="c" value="#session.clist">
            <dl>
                    <%--一级分类--%>
                <dt>
                    <a href="${pageContext.request.contextPath}/category.action?page=1&cid=<s:property value='#c.cid'/>"><s:property value="#c.cname"/></a>
                </dt>

                    <%--二级分类--%>
                <s:iterator var="cs" value="#c.categorySeconds">
                    <dd>
                        <a href="${ pageContext.request.contextPath }/secCategory.action?page=1&csid=<s:property value='#cs.csid'/>"><s:property value="#cs.csname"/></a>
                    </dd>
                </s:iterator>
            </dl>
        </s:iterator>
        <%----%>
    </div>
</div>
</body>
</html>
