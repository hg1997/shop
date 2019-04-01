<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2017/8/5
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册</title>
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/register.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container header">
    <%@include file="header.jsp" %>
    <%@include file="menu.jsp" %>
</div>

<%--体--%>
</div>
<div class="container register">
            <div class="main clearfix">
                <div class="title">
                    <strong>会员注册</strong>USER REGISTER
                </div>
                <form action="${pageContext.request.contextPath}/regist.action" id="registerForm" method="post"
                      novalidate="novalidate" onsubmit="return checkForm()">
                    <table align="center">
                        <tr>
                            <th>
                                <span class="requiredField">*</span>用户名:
                            </th>
                            <td>
                                <input type="text" id="username" value="${requestScope.user.username}" name="username"
                                       class="text" maxlength="20" onblur="checkUsername()">
                                <span id="userspan"></span>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <span class="requiredField">*</span>密&nbsp;&nbsp;码:
                            </th>
                            <td>
                                <input type="password" id="password" value="${requestScope.user.password}"
                                       name="password" class="text" maxlength="20" autocomplete="off"
                                       onblur="checkPassword()">
                                <span id="pswspan"></span>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <span class="requiredField">*</span>确认密码:
                            </th>
                            <td>
                                <input type="password" id="repassword" value="${requestScope.user.password}"
                                       name="rePassword" class="text" maxlength="20" autocomplete="off"
                                       onblur="recheckPassword()">
                                <span id="repswspan"></span>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <span class="requiredField">*</span>E-mail:
                            </th>
                            <td>
                                <input type="text" id="email" value="${requestScope.user.email}" name="email"
                                       class="text" maxlength="200">
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <span class="requiredField">*</span>验证码:
                            </th>
                            <td>
                                <span class="fieldSet">
                                    <input type="text" id="captcha" name="captcha" class="text captcha"
                                                   maxlength="4" autocomplete="off">
                                    <img id="captchaImage" class="captchaImage"
                                         src="${pageContext.request.contextPath}/imageAction.action"
                                         onclick="change()"
                                         title="点击更换验证码">
										</span>
                                <font color="red">${requestScope.msg}</font>
                            </td>
                        </tr>
                        <tr>
                            <th>&nbsp;
                            </th>
                            <td>
                                <input type="submit" class="submit" value="完成注册">
                            </td>
                            <td>已经拥有账号了？<a href="${pageContext.request.contextPath}/loginPage.action"><font color="#f08080">立即登录</font></a></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
<%--底部--%>
<%@include file="footer.jsp" %>
<%--前端注册校验--%>
<script type="application/javascript">
    /*input框*/
    var username = document.getElementById("username");
    var password = document.getElementById("password");
    var repassword = document.getElementById("repassword");

    /*提示span*/
    var userspan = document.getElementById("userspan");
    var pswspan = document.getElementById("pswspan");
    var repswspan = document.getElementById("repswspan");

    /*校验密码是否一致*/
    function checkPassword() {
        var pswtext = password.value;
        var repswtext = repassword.value;
        /*alert(repswtext);*/
        if (repswtext != "" && pswtext != repswtext) {
            repswspan.innerHTML = "<font color='red'>&nbsp;*两次输入的密码不一致！</font>"
        } else {
            repswspan.innerHTML = ""
        }

        if (pswtext == "" || pswtext == null) {
            pswspan.innerHTML = "<font color='red'>&nbsp;*密码不能为空！</font>"
        } else {
            pswspan.innerHTML = ""
        }
    }

    function recheckPassword() {
        var pswtext = password.value;
        var repswtext = repassword.value;
        if (pswtext == repswtext) {
            repswspan.innerHTML = "";
        }
        else {
            repswspan.innerHTML = "<font color='red'>&nbsp;*两次输入的密码不一致！</font>";
        }
    }

    /*校验用户名*/
    function checkUsername() {
        var usertext = username.value;
        if (usertext == "" || usertext == null) {
            userspan.innerHTML = "<font color='red'>&nbsp;*用户名不能为空！</font>";
            flag = false;
        }
        else {
            //userspan.innerHTML = ""
            var request = createXMLHttpRequest();
            request.open("get",
                "${pageContext.request.contextPath}/checkUsername.action?username=" + usertext + "&date=" + new Date().getTime(), true);
            request.send(null);
            request.onreadystatechange = function () {
                if (request.readyState == 4 && request.status == 200) {
                    var text = request.responseText;
                    userspan.innerHTML = text;
                    if (text == "")
                        flag = true;
                    else
                        flag = false;
                }
            }
        }
    }

    /*ajax连接*/
    function createXMLHttpRequest() {
        try {
            return new XMLHttpRequest();
        } catch (e) {
            try {
                return new ActiveXObject("Msxml2.XMLHTTP");
            } catch (e) {
                try {
                    return new ActiveXObject("Microsoft.XMLHTTP");
                } catch (e) {
                    alert("请更换兼容此页面的浏览器进行访问~");
                    throw e;
                }
            }
        }
    }

    /*提交时校验*/
    function checkForm() {
        var text1 = username.value;
        var text2 = password.value;
        var text3 = repassword.value;
        if (text1 == "" || text2 == "" || text3 == "") {
            alert("请完善注册信息！");
            return false;
        }

        else
            return true;
    }


    //更换验证码
    function change() {
        var captchaImage = document.getElementById("captchaImage");
        captchaImage.src = "${pageContext.request.contextPath}/imageAction.action?date=" + new Date().getTime();
    }
</script>
</body>
</html>