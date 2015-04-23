<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$().ready(function() {
// validate signup form on keyup and submit
$("#loginForm").validate({
focusCleanup: true,//表单提交时,焦点会指向第一个没有通过验证的域
debug: false,
rules: {
username: {
required: true,
stringCheck:true,
minlength:4,
maxlength: 20,
remote:{
type: "POST",
dataType:"xml",
async: false,
url: "WebService.asmx/CheckName",
data: {userName:function(){ return jQuery("#<%=username.ClientID%>
	")
																		.val();
															}
														},
														dataFilter : function(
																dataXML) {
															var result = new Object();
															result.Result = jQuery(
																	dataXML)
																	.find(
																			"Result")
																	.text();
															result.Msg = jQuery(
																	dataXML)
																	.find("Msg")
																	.text();
															if (result.Result == "-1") {
																result.Result = false;
																return result;
															} else {
																result.Result = result.Result == "1" ? true
																		: false;
																return result;
															}
														}
													}
												}

											},
											messages : {
												username: {
													required : "请输入用户名",
													stringCheck : "用户名只能包括中文字、英文字母、数字和下划线",
													minlength : "用户名不能少于4个字符",
													maxlength : "用户名不能超过20个字符",
													remote : "此用户名已经有人注册过"

												}
											}
										});
					});
</script>
</head>
<body>

</body>
</html>