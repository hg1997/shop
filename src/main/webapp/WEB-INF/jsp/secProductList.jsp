<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2017/8/7
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>商品列表</title>
    <link href="./css/common.css" rel="stylesheet" type="text/css"/>
    <link href="./css/product.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container header">
    <%@include file="header.jsp" %>
    <%@include file="menu.jsp" %>
</div>
<%--体--%>
<div class="container productList">
    <%--left--%>
    <s:include value="left.jsp"/>
    <%--left--%>

    <div class="span18 last">
        <div id="result" class="result table clearfix">
            <ul>
                <%--图片--%>
                <s:iterator value="pageBean.list" var="p">
                    <li>
                        <a href="${pageContext.request.contextPath}/product_show.action?pid=<s:property value='#p.pid'/>">
                            <img src="${pageContext.request.contextPath}/<s:property value='#p.image'/>" width="170"
                                 height="170" style="display: inline-block;">
                            <span style='color:green'>
											 <s:property value='#p.pname'/>
											</span>
                            <span class="price">
												商城价:<s:property value='#p.market_price'/>
											</span>
                        </a>
                    </li>
                </s:iterator>
            </ul>
        </div>
        <%--分页跳转栏--%>
        <div class="pagination">
            <s:if test="pageBean.page != 1"><%--首页+向前--%>
                <span class="firstPage"><a
                        href="${pageContext.request.contextPath}/categoryAction.action?page=1&cid=<s:property value="myCid"/>">&nbsp;</a></span>
                <span class="previousPage"><a
                        href="${pageContext.request.contextPath}/categoryAction.action?page=<s:property value='pageBean.page-1'/>&cid=<s:property value="myCid"/>">&nbsp;</a></span>
            </s:if>
            <%--分页跳转页码--%>
            <c:choose>
                <%--底部显示5个,如总页面少于5个--%>
                <c:when test="${pageBean.totalPage<5}">
                    <c:set var="start" value="1"/>
                    <c:set var="end" value="${pageBean.totalPage}"/>
                </c:when>
                <%--总页面不少于5个--%>
                <c:otherwise>
                    <c:set var="start" value="${pageBean.page-2}"/>
                    <c:set var="end" value="${pageBean.page+2}"/>
                    <%--头溢出--%>
                    <c:if test="${start<1}">
                        <c:set var="start" value="1"/>
                        <c:set var="end" value="5"/>
                    </c:if>
                    <%--尾溢出--%>
                    <c:if test="${end>pageBean.totalPage}">
                        <c:set var="start" value="${pageBean.totalPage-4}"/>
                        <c:set var="end" value="${pageBean.totalPage}"/>
                    </c:if>
                </c:otherwise>
            </c:choose>

            <%--确定好首尾后开始循环--%>
            <c:forEach begin="${start}" end="${end}" var="i">
                <c:choose>
                    <c:when test="${pageBean.page == i}">
                        <span class="currentPage">${i}</span>
                    </c:when>
                    <c:otherwise>
                        <a href="${pageContext.request.contextPath}/categoryAction.action?page=${i}&cid=<s:property value="myCid"/>">${i}</a>
                    </c:otherwise>
                </c:choose>

            </c:forEach>
            <%--分页跳转页码--%>
            <s:if test="pageBean.page != pageBean.totalPage"><%--向后+尾页--%>
                <a class="nextPage"
                   href="${pageContext.request.contextPath}/categoryAction.action?page=<s:property value='pageBean.page+1'/>&cid=<s:property value="myCid"/>">
                    &nbsp;</a>
                <a class="lastPage"
                   href="${pageContext.request.contextPath}/categoryAction.action?page=<s:property value='pageBean.totalPage'/>&cid=<s:property value="myCid"/>">
                    &nbsp;</a>
            </s:if>
        </div>
        <%--分页跳转栏--%>
    </div>
</div>
<%--底部--%>
<%@include file="footer.jsp" %>

</body>
</html>