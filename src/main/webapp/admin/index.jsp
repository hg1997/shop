<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>商城管理中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%--<link href="${pageContext.request.contextPath }/css/general.css" rel="stylesheet" type="text/css" />--%>
<%--<link href="${pageContext.request.contextPath }/css/main.css" rel="stylesheet" type="text/css" />--%>

<style type="text/css">
body {
  color: white;
}
</style>

<body style="background-image:url(/image/bg.jpg)">
<center><font size="4"color="red"><s:actionerror /></font></center>


<form method="post" action="${pageContext.request.contextPath }/adminUser_login.action" target="_parent" name='theForm' onsubmit="return validate()">
  <table width="50%" cellspacing="0" cellpadding="0" style="margin-top: 100px" align="center">
    <tr height="40px">
      <th colspan="2"><h1>后台登录</h1></th>
    </tr>

      <tr height="50px">
        <th align="right">管理员姓名：</th>
        <td align="left"><input type="text" name="username" /></td>
      </tr>
      <tr height="50px">
        <th align="right">管理员密码：</th>
        <td align="left"><input type="password" name="password" /></td>
      </tr>

        <tr height="50px">
          <td align="right">&nbsp;</td>
          <td align="left"><input type="submit" value="进入管理中心" class="button" /></td>
        </tr>
      </table>
    </td>
  </tr>
  </table>
  <input type="hidden" name="act" value="signin" />
</form>

</body>