<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
 String contextPath = request.getContextPath();
%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="title" value="找丢丢"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>登录找丢丢</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/denglu.css" />
</head>

<body>

<div  class="top">
       <ul class="logo">
	      <li><img src="${ctx}/img/logo.gif" width="210px"alt="找丢丢 找到心爱的宝贝" /><li>
		  <li><img src="${ctx}/img/geduan.jpg" /></li>
		  <li><span>欢迎登录</span></li>
	  </ul>
   </div>
<div class="middle">
   <div class="middle_left"></div>
   <div class="middle_right">
	  <form action="${ctx}/login.do" method="post">
	  <table cellpadding="0" cellspacing="0" border="0">
				<tr>
					<td>用户名/邮箱/手机号</td>
				</tr>
				<tr>
					<td><span><input type="text" id="username" name="username" class="search_text1"/></span></td>
				</tr>
				<tr>
					<td>密码</td>
				</tr>
				<tr>
					<td><span><input type="password" id="password" name="password" class="search_text2"/></span></td>
				</tr>
	  </table>
	  
	  <ul>    
		  <li><input type="checkbox" /></li>
		  <li>自动登录</li>
		  <li><a href="#">忘记密码？</a></li>
	  </ul>
	  <table cellpadding="0" cellspacing="0" border="0">
				<tr>
				  <td><input type="submit" class="search_submit2" value=""/></td>
				</tr>
	  </table>
	  </form>
	  <ul>
		  <li style="background:url(img/line.jpg) no-repeat; width:250px;margin-top:40px;"></li>
	  </ul>
	  <ul style="margin-top:-20px;">
		  <li style="padding-left:85px;">还没有找丢丢账号，</li>
		  <li style="margin-left:-15px;"><a href="#">免费注册</a></li>
	  </ul>
   </div>
</div>
<div class="bottom">
   <ul> 
	<li><a href="#">关于我们</a><font>|</font></li>
	<li><a href="#">联系我们</a><font>|</font></li>
	<li><a href="#">人才招聘</a><font>|</font></li>
	<li><a href="#">广告服务</a><font>|</font></li>
	<li><a href="#">手机丢丢</a><font>|</font></li>
	<li><a href="#">友情链接</a><font>|</font></li>
	<li><a href="#">合作联盟</a><font>|</font></li>
	<li><a href="#">丢丢帮</a><font>|</font></li>
	<li><a href="#">丢丢公益</a></li>
   </ul>
   <ul><li>Copyright 2014-2014  找丢丢ZODIU.com 版权所有</li></ul>
</div>
</body>
</html>
