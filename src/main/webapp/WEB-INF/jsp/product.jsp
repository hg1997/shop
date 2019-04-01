<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2017/8/7
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>商品分页面</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container header">
    <%@ include file="header.jsp"%>
    <%@ include file="menu.jsp"%>
</div>

</div><div class="container productContent">
      <%--left--%>
       <s:include value="left.jsp"/>
       <%--left--%>
    <div class="span18 last">
        <%--图片--%>
        <div class="productImage">
            <a title="" style="outline-style: none; text-decoration: none;" id="zoom" href="http://image/pic/bigPic1ea8f1c9-8b8e-4262-8ca9-690912434692.jpg" rel="gallery">
                <div class="zoomPad"><img style="opacity: 1;" title="" class="medium" src="${pageContext.request.contextPath}/<s:property value='model.image'/>"><div style="display: block; top: 0px; left: 162px; width: 0px; height: 0px; position: absolute; border-width: 1px;" class="zoomPup"></div><div style="position: absolute; z-index: 5001; left: 312px; top: 0px; display: block;" class="zoomWindow"><div style="width: 368px;" class="zoomWrapper"><div style="width: 100%; position: absolute; display: none;" class="zoomWrapperTitle"></div><div style="width: 0%; height: 0px;" class="zoomWrapperImage"><img src="%E5%B0%9A%E9%83%BD%E6%AF%94%E6%8B%89%E5%A5%B3%E8%A3%852013%E5%A4%8F%E8%A3%85%E6%96%B0%E6%AC%BE%E8%95%BE%E4%B8%9D%E8%BF%9E%E8%A1%A3%E8%A3%99%20%E9%9F%A9%E7%89%88%E4%BF%AE%E8%BA%AB%E9%9B%AA%E7%BA%BA%E6%89%93%E5%BA%95%E8%A3%99%E5%AD%90%20%E6%98%A5%E6%AC%BE%20-%20Powered%20By%20Mango%20Team_files/6d53c211-2325-41ed-8696-d8fbceb1c199-large.jpg" style="position: absolute; border: 0px none; display: block; left: -432px; top: 0px;"></div></div></div><div style="visibility: hidden; top: 129.5px; left: 106px; position: absolute;" class="zoomPreload">Loading zoom</div></div>
            </a>
        </div>

        <%----%>
        <div class="name">
            <s:property value="model.pname"/>
        </div>

            <div>&nbsp;</div>

        <%----%>
        <div class="sn">
            <div>商品编号：<s:property value="pid"/></div>
        </div>
            <div>&nbsp;</div>
            <div>&nbsp;</div>

        <%----%>
        <div class="info">
            <dl>
                <dt>超市价格:</dt>
                <dd>
                    <strong><s:property value="model.market_price"/></strong>
                    <b style="color:green">参 考 价：</b><strong><s:property value="model.shop_price"/></strong>
                    <del><s:property value="shop.pname"/></del>
                </dd>
            </dl>

            <div>&nbsp;</div>

            <dl>
                <dt>促销</dt>
                <dd>
                    <a target="_blank">限时抢购</a>
                </dd>
            </dl>
        </div>

            <div>&nbsp;</div>
            <div>&nbsp;</div>

        <%--添加到购物车--%>
        <form action="${pageContext.request.contextPath}/saveProduct.action" method="post" id="carForm">

             <%----%>
            <div class="action">
                <dl class="quantity">
                    <dt>购买数量:</dt>
                    <dd>
                        <%--商品的pid--%>
                        <input type="hidden" name="pid" value="<s:property value='model.pid'/>"/>
                         <%--图片位置--%>
                        <input type="hidden" name="image" value="<s:property value='model.image'/>"/>
                         <%--商品名称--%>
                            <input type="hidden" name="pname" value="<s:property value='model.pname'/>"/>
                        <%--商品shop_price--%>
                            <input type="hidden" name="shop_price" value="<s:property value='model.shop_price'/>"/>
                            <%--获取数量--%>
                        <input id="quantity" name="quantity" value="1" maxlength="4" onpaste="return false;" type="text">
                    </dd>
                    <dd>
                        件
                    </dd>
                </dl>
                <div class="buy">
                    <input id="addCart" onclick="saveCar()" class="addCart" value="加入购物车" type="button">
                </div>
            </div>
         </form>
        <%----%>
            <div>&nbsp;</div>
            <div>&nbsp;</div>

        <div id="bar" class="bar">
            <ul>
                <li id="introductionTab">
                    <a href="#introduction"><font color="orange" size="4">商品介绍</font></a>
                </li>
            </ul>
        </div>

            <div>&nbsp;</div>
            <div>&nbsp;</div>

        <div id="introduction" name="introduction" class="introduction">
            <div class="title">
                <strong><s:property value="model.pdesc"/>xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                </strong>
            </div>
            <%--<div>
                <img align="center" src="${pageContext.request.contextPath}/<s:property value='model.image'/>">
            </div>--%>
        </div>

    </div>
</div>
<%--底部--%>
<%@include file="footer.jsp"%>

<script type="application/javascript">

    function saveCar(){
        //form表单
        var form = document.getElementById("carForm");
        form.submit();
    }
</script>
</body>
</html>