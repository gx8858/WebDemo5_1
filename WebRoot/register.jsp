<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>bookStore注册页面</title>
<%--导入css --%>
<link rel="stylesheet" href="css/main.css" type="text/css" />
<script type="text/javascript">
	function changeImage() {

		document.getElementById("img").src = "${pageContext.request.contextPath}/imageCode?time="
				+ new Date().getTime();
	}

	function checkForm() {

		//清空
		document.getElementById("email_msg").innerHTML = "";
		document.getElementById("username_msg").innerHTML = "";
		document.getElementById("password_msg").innerHTML = "";
		document.getElementById("repassword_msg").innerHTML = "";

		checkNull("email"); 
		checkNull("username");
		checkNull("password"); 
		checkNull("repassword");
		
		return checkNull("email") && checkNull("username")
				&& checkNull("password") && checkNull("repassword");

	}

	//抽取一个验证非空的方法
	function checkNull(fieldName) {
		//1.得到id=email的元素
		var fn = document.getElementById(fieldName);
		//2.得到email元素的value
		var fnValue = fn.value;

		//3.判断emailValue不为空
		var reg = /^\s*$/;
		if (reg.test(fnValue)) {
			document.getElementById(fieldName + "_msg").innerHTML = "<font color='red'>"
					+ fieldName + "不能为空</font>";
			return false;
		}
		return true;
	}
</script>
</head>


<body class="main">
	<%@include file="head.jsp"%>
	<%--导入头 --%>
	<%@include file="menu_search.jsp"%><%--导入导航条与搜索 --%>

	<div id="divcontent">
		<form action="${pageContext.request.contextPath}/register"
			method="post" onsubmit="return checkForm()">
			<table width="850px" border="0" cellspacing="0">
				<tr>
					<td style="padding:30px">
						<h1>新会员注册</h1> <br> 
						<font color="red">${ requestScope['regist.msg'] }</font>
						<table width="70%" border="0" cellspacing="2" class="upline">
							<tr>
								<td style="text-align:right; width:20%">会员邮箱：</td>
								<td style="width:40%"><input type="text" class="textinput"
									name="email" id="email" />
								</td>
								<td><span id="email_msg">${map['email.msg']}</span>
								</td>
							</tr>
							<tr>
								<td style="text-align:right">会员名：</td>
								<td><input type="text" class="textinput" name="username"
									id="username" /></td>
								<td><span id="username_msg">${map['username.msg']}</span>
								</td>
							</tr>
							<tr>
								<td style="text-align:right">密码：</td>
								<td><input type="password" class="textinput"
									name="password" id="password" />
								</td>
								<td><span id="password_msg">${map['password.msg']}</span>
								</td>
							</tr>
							<tr>
								<td style="text-align:right">重复密码：</td>
								<td><input type="password" class="textinput"
									name="repassword" id="repassword" />
								</td>
								<td><span id='repassword_msg'></span>
								</td>
							</tr>
							<tr>
								<td style="text-align:right">性别：</td>
								<td colspan="2">&nbsp;&nbsp;<input type="radio" name="sex"
									value="男" checked="checked" /> 男
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"
									name="sex" value="女" /> 女</td>
							</tr>
							<tr>
								<td style="text-align:right">联系电话：</td>
								<td colspan="2"><input type="text" class="textinput"
									style="width:350px" name="telephone" />
								</td>
							</tr>
							<tr>
								<td style="text-align:right">个人介绍：</td>
								<td colspan="2"><textarea class="textarea" name="introduce"></textarea>
								</td>
							</tr>

						</table>



						<h1>注册校验</h1>
						<table width="80%" border="0" cellspacing="2" class="upline">
							<tr>
								<td style="text-align:right; width:20%">输入校验码：</td>
								<td style="width:50%"><input type="text" class="textinput"
									name="imageCode" />&nbsp;&nbsp;
									<font color='red'>${requestScope['imageCode.msg']}</font>
								</td>
								<td></td>
							</tr>
							<tr>
								<td style="text-align:right;width:20%;">&nbsp;</td>
								<td colspan="2" style="width:50%"><img
									src="${pageContext.request.contextPath}/imageCode" width="180"
									height="30" class="textinput" style="height:30px;" id="img" />&nbsp;&nbsp;
									<a href="javascript:void(0);" onclick="changeImage()">看不清换一张</a>
								</td>
							</tr>
						</table>



				<table width="70%" border="0" cellspacing="0">
					<tr>
						<td style="padding-top:20px; text-align:center"><input
							type="image" src="images/signup.gif" name="submit" border="0">
						</td>
					</tr>
				</table>
				</td>
				</tr>
			</table>
		</form>
	</div>



	<div id="divfoot">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td rowspan="2" style="width:10%"><img
					src="images/bottomlogo.gif" width="195" height="50"
					style="margin-left:175px" />
				</td>
				<td style="padding-top:5px; padding-left:50px"><a href="#"><font
						color="#747556"><b>CONTACT US</b> </font> </a>
				</td>
			</tr>
			<tr>
				<td style="padding-left:50px"><font color="#CCCCCC"><b>COPYRIGHT
							2008 &copy; eShop All Rights RESERVED.</b> </font>
				</td>
			</tr>
		</table>
	</div>


</body>
</html>
