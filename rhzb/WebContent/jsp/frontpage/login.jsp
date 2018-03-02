<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=path%>/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>金源宝——用户登录</title>
<link href="jsp/frontpage/css/common.css" rel="stylesheet" />
<link href="jsp/frontpage/css/register.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="jsp/frontpage/script/jquery.min.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/common.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/gVerify.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/login.js"></script>

</head>
<body>
	<%@ include file="/jsp/frontpage/include/head.jsp"%>
	<!-- 登陆 -->	
	<div class="wrap">
	 <form id="loginForm" name="LonginForm" action="login/loginVerify" method="post">
		<div class="tdbModule register">
			<div class="registerTitle">用户登录</div>
			<div class="registerCont">
		      <ul>
				<li class="error">
				    <span id="prrintInfo" data-info=""><span>欢迎登陆，用心服务</span></span>
			    </li>
				<li>
					<span class="dis">帐号：</span>
					<input class="input" type="text" name="phone" id="username" maxlength="24" tabindex="1" placeholder="手机号" autofocus>
				    <a id="sssdfasdfas" href="register/openRegisterPage" class="blue">注册用户</a>
				    <span id="usernameAlt"></span>
				</li>
	                
				<li>
				   <span class="dis">密码：</span>
				   <input class="input" type="password" name="password" id="password" maxlength="24" tabindex="1" placeholder="账户密码">  
				   <a href="forget/forgetPassword1" id="pawHide" class="blue">忘记密码</a>
				   <span id="passwordAlt"></span>
				</li>
				 <li style="position: relative;">
				  	<span class="dis">验证码：</span>
				  	<input type="text" id="jpgVerify" style="width:130px;" class="input" name="yzm" data-msg="验证码" maxlength="4" tabindex="1" placeholder="右方验证码">
				  	<div id="v_container" style="position:absolute; display:inline-block;width:115px;height: 44px;"></div>
				  	<span id="jpgVerifyAlt" style="padding-left: 125px"></span>
				</li>
				<li class="btn">
					<span id="submitAut" style="color:red;">${loginFail}</span>
					<input type="button" class="radius1" value="立即登录" id="submitBtn">
				</li>
			</ul>
		   </div>
		</div>
	 </form>
	</div>
	<%@ include file="/jsp/frontpage/include/foot.jsp"%>
</body>
</html>