<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
	String contextPath = request.getContextPath();
%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="title" value="找丢丢" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>找丢丢 找到心爱的宝贝</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/zhuce.css" />
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.SuperSlide.js"></script>
<script type="text/javascript"
	src="${ctx }/js/validation/jquery.validate.min.js"></script>
<script type="text/javascript"
	src="${ctx }/js/validation/messages_cn.js"></script>
<script type="text/javascript">
	/* function check_form(){
		var username = $('#username').val();
		var password = $('#password').val();
		var repassword = $('#repassword').val();
		var checkCode = $('#checkCode').val();
		var check = $('#check').attr("checked");
		var msn = '';
		if(username=='')
			msn +='用户名不能为空!/n'
		if(password=='')
			msn +='密码不能为空!/n'
		if(repassword=='')
			msn +='重复密码不能为空!/n'
		if(checkCode=='')
			msn +='密码不能为空!/n'
		if(check!='checked')
			msn +='密码不能为空!/n'
		//if($('#password').val())
			return false;
	} */
	$(function() {
		var validate = $("#form1").validate({
			debug : true, //调试模式取消submit的默认提交功能   
			//errorClass: "label.error", //默认为错误的样式类为：error   
			focusCleanup: true,//表单提交时,焦点会指向第一个没有通过验证的域
			onkeyup : true,
			submitHandler : function(form) { //表单提交句柄,为一回调函数，带一个参数：form   
				form.submit(); //提交表单   
			},

			rules : {
				username : {
					required : true,
					rangelength : [ 3, 10 ],
					stringCheck:true,
					remote:{
						type: "POST",
						dataType:"xml",
						async: false,
						url: "WebService.asmx/CheckName",
						data: {userName:function(){return jQuery("#username").val();}},
						dataFilter : function(dataXML) {
							var result = new Object();
							result.Result = jQuery(dataXML).find("Result").text();
							result.Msg = jQuery(dataXML).find("Msg").text();
							if (result.Result == "-1") {
								result.Result = false;
								return result;
							} else {
								result.Result = result.Result == "1" ? true: false;
								return result;
							}
						}
							}
				},
				
				password : {
					required : true,
					rangelength : [ 3, 10 ]
				},
				repassword : {
					equalTo : "#password"
				},
				checkCode : {
					required : true
				},
				check : {
					required : true
				}
			},
			messages : {
				username : {
					required : "用户名必填<br>",
					rangelength : $.format("用户名长度:{0}-{1}<br>"),
					stringCheck:"用户名只能包括中文字、英文字母、数字和下划线"
				},
				
				password : {
					required : "密码不能为空<br>",
					rangelength : $.format("密码长度:{0}-{1}<br>")
				},
				repassword : {
					equalTo : "两次密码不一致<br>"
				},
				checkCode : {
					required : "验证码必填<br>"
				},
				check : {
					required : "您没有接受服务条款"
				}
			},
			errorPlacement : function(error, element) {
				/* if (element.is(":radio"))
				error.appendTo(element.parent());
				else if (element.is(":checkbox"))
				error.appendTo(element.parent().parent());
				else
				error.appendTo(element.parent().next()); */
				error.appendTo($('#la'))
			} 

		});

	});
<%-- 	function aaaa(){
		$('#cimg').src='<%=request.getContextPath()%>/GifCheckSerlet?k='+Math.random();
		alert('<%=request.getContextPath()%>/GifCheckSerlet?k='+Math.random());
	} --%>
</script>
</head>

<body bgcolor="#f1f1f1">
	<div class="header">
		<div class="header_menu">
			<ul class="header_nav">
				<li><a href="#">您好，欢迎来到找丢丢!</a></li>
			</ul>
			<ul class="header_mid">
				<li><a href="#">[登录]</a></li>
				<li><a href="#">[我的丢丢帮]</a></li>
			</ul>
			<ul class="header_right">
				<li><a href="#">客户服务</a></li>
				<li><a href="#">网站导航</a></li>
			</ul>
		</div>
		<div class="top_ad">
			<ul>
				<li class="top_ad1"><a href="#"></a></li>
			</ul>
		</div>
	</div>
	<div class="top">
		<ul class="logo">
			<li><img src="${ctx}/img/logo.gif" width="190px"
				alt="找丢丢 找到心爱的宝贝" />
				<li>
					<li><img src="${ctx}/img/geduan.jpg" /></li>
					<li><span>注册新用户</span></li>
		</ul>
	</div>
	<div class="border">
		<form id="form1" name="form1" action="${ctx }/register.do"
			onSubmit="return check_form();" method="post">
			<div class="left">
				<div class="border_left">
<label id="la" name="la">${fale_msn}</label>
					<table cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td>用户名:<span><input type="text" class="search_text1"
									id="username" name="username" value='${not empty user?user.username :"" }'/></span></td>
						</tr>
						<tr>
							<td>密&nbsp;&nbsp;&nbsp;&nbsp;码:<span><input
									type="text" class="search_text1" id="password" name="password" value='${not empty user?user.password:"" }'/></span></td>
						</tr>
					</table>
					<ul>
						<li><img src="${ctx}/img/mima.jpg" /></li>
						<li><img src="${ctx}/img/mima.jpg" /></li>
						<li><img src="${ctx}/img/mima.jpg" /></li>
					</ul>
					<ul>
						<li>危险</li>
						<li>一般</li>
						<li>安全</li>
					</ul>
					<table class="border_left_yz" cellpadding="0" cellspacing="0"
						border="0">
						<tr>
							<td>密&nbsp;&nbsp;&nbsp;&nbsp;码:<span><input
									type="text" class="search_text1" id="repassword"
									name="repassword"  value='${not empty user?user.password:"" }'/></span></td>
						</tr>
						<tr>
							<td>验证码: <img id="cimg"
								src="<%=request.getContextPath()%>/GifCheckSerlet"
								style="width: 100px; height: 40px; margin: 0px 0px 0px 0px;"
								onclick="this.src='<%=request.getContextPath()%>/GifCheckSerlet?k='+Math.random()"></img><span><input type="text" name="checkCode"
									id="checkCode" class="search_text2"  value='${not empty checkCode?checkCode:"" }'/></span>
								<!-- <a href="javascript:void(0);" onclick="aaaa();">看不清？换一个</a> -->

							</td>
						</tr>
					</table>

				</div>
				<div class="border_left_bottom">
					<ul>
						<li><input type="checkbox" id="check" name="check"
							checked="checked" /></li>
						<li>我已阅读并接受</li>
						<li><a href="#"><<找丢丢网服务条款>></a></li>
					</ul>
					<table cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td><input type="submit" class="search_submit2" value="" /></td>
						</tr>
					</table>
				</div>
			</div>
		</form>
		<div class="border_right">
			<h5>
				已有账号 点击<a href="#">登录</a>
			</h5>
			<ul>
				<li>加入<a href="#">*丢丢帮*</a></li>
				<li>争进<a href="#">好人榜</a></li>
				<li><a href="#">好礼等你拿</a></li>
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
		<ul>
			<li>Copyright 2014-2014 找丢丢ZODIU.com 版权所有</li>
		</ul>
	</div>
</body>
</html>
