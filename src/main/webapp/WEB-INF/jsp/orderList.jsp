<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2017/8/11
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>订单页面</title>
    <link href="${pageContext.request.contextPath}/css/common.css"
          rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/css/cart.css"
          rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/css/product.css"
          rel="stylesheet" type="text/css" />
</head>
<body>
<div class="container header">
    <%@include file="header.jsp"%>
    <%@ include file="menu.jsp"%>
    <%--体--%>
</div>
<div class="container cart">
    <div class="span24">
        <div class="step step1">
            <ul>
                <li class="current"></li>
                <li>我的订单</li>
            </ul>
        </div>
        <table>
            <tbody>
            <s:iterator var="order" value="pageBean.list">
                <tr>
                    <th colspan="5">订单编号:<s:property value="#order.oid" />&nbsp;&nbsp;&nbsp;&nbsp;订单金额:<font
                            color="red"><s:property value="#order.total" />
                    </font>
                        &nbsp;&nbsp;&nbsp;&nbsp;<font color="red">
                            <s:if test="#order.state == 1">
                                <a href="${ pageContext.request.contextPath }/findByOid.action?oid=<s:property value="#order.oid" />">付款</a>
                            </s:if>
                            <s:if test="#order.state == 2">
                                已付款
                            </s:if>
                            <s:if test="#order.state == 3">
                                <a href="${ pageContext.request.contextPath }/order_updateState.action?oid=<s:property value="#order.oid" />">确认收货</a>
                            </s:if>
                            <s:if test="#order.state == 4">
                                交易成功
                            </s:if>
                        </font>
                    </th>
                </tr>
                <tr>
                    <th>图片</th>
                    <th>商品</th>
                    <th>价格</th>
                    <th>数量</th>
                    <th>小计</th>
                </tr>
                <s:iterator var="orderItem" value="#order.orderItems">
                    <tr>
                        <td width="60"><img
                                src="${ pageContext.request.contextPath }/<s:property value="#orderItem.product.image"/>" />
                        </td>
                        <td><s:property value="#orderItem.product.pname" /></td>
                        <td><s:property value="#orderItem.product.shop_price" /></td>
                        <td class="quantity" width="60"><s:property
                                value="#orderItem.count" /></td>
                        <td width="140"><span class="subtotal">￥<s:property
                                value="#orderItem.subtotal" />
								</span></td>
                    </tr>
                </s:iterator>
            </s:iterator>
            <%--================页标==================--%>
            <tr>
                <th colspan="5">
                    <div class="pagination">
							<span>第<s:property value="pageBean.page" />/<s:property
                                    value="pageBean.totalPage" />页 </span>
                        <s:if test="pageBean.page != 1">
                            <a
                                    href="${ pageContext.request.contextPath }/orderList.action?page=1"
                                    class="firstPage">&nbsp;</a>
                            <a
                                    href="${ pageContext.request.contextPath }/orderList.action?page=<s:property value="pageBean.page-1"/>"
                                    class="previousPage">&nbsp;</a>
                        </s:if> <s:iterator var="i" begin="1" end="pageBean.totalPage">
                        <s:if test="pageBean.page != #i">
                            <a
                                    href="${ pageContext.request.contextPath }/orderList.action?page=<s:property value="#i"/>"><s:property
                                    value="#i" />
                            </a>
                        </s:if>
                        <s:else>
									<span class="currentPage"><s:property value="#i" />
									</span>
                        </s:else>
                    </s:iterator> <s:if test="pageBean.page != pageBean.totalPage">
                        <a class="nextPage"
                           href="${ pageContext.request.contextPath }/orderList.action?page=<s:property value="pageBean.page+1"/>">&nbsp;</a>
                        <a class="lastPage"
                           href="${ pageContext.request.contextPath }/orderList.action?page=<s:property value="pageBean.totalPage"/>">&nbsp;</a>
                    </s:if>
                    </div>
                </th>
            </tr>
            <%--================页标==================--%>
            </tbody>
        </table>
    </div>
</div>
<%--底部--%>
<%@include file="footer.jsp" %>
</body>
</html>
