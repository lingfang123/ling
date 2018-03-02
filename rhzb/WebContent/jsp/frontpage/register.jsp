<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
	String referrerm = request.getParameter("referrerm");//用request得到 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=path%>/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>金源宝——用户注册</title>
<link href="jsp/frontpage/css/common.css" rel="stylesheet" />
<link href="jsp/frontpage/css/register.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="jsp/frontpage/script/jquery.min.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/common.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/gVerify.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/register.js"></script>

</head>
<body>
	<%@ include file="/jsp/frontpage/include/head.jsp"%>
	<!--注册-->
	<div class="wrap">
	  <div class="tdbModule register">
	    <div class="registerTitle">注册账户</div>
	    <div class="registerLc1">
	      <p class="p1">填写账户信息</p>
	      <p class="p2">验证手机信息</p>
	      <p class="p3">注册成功</p>
	    </div>
	    <div class="registerCont">
		    <form id="myForm" action="register/userRegister" method="post">
		      <ul>
		        <li><span class="dis">用户名:</span>
		          <input type="text" name="username" id="userName" class="input _userName" maxlength="24" tabindex="1">
		          <span id="userNameAlt" data-info="6-24个字符，字母开头，字母、数字下划线组成">6-24个字符，字母开头，字母、数字下划线组成</span></li>
		        <li><span class="dis">密码:</span>
		          <input type="password" name="password" id="password" class="input _password" maxlength="24" tabindex="1">
		          <span id="passwordAlt" data-info="6-24个字符，英文、数字组成，区分大小写">6-24个字符，英文、数字组成，区分大小写</span></li>
		        <li><span class="dis">确认密码:</span>
		          <input type="password" name="repeatPassword" id="repeatPassword" class="input _repeatPassword" maxlength="24" tabindex="1">
		          <span id="repeatPasswordAlt" data-info="请再次输入密码">请再次输入密码</span></li>
		        <li style="position: relative;"><span class="dis">验证码:</span>
		          <input type="text" id="jpgVerify" class="input input1 _yanzhengma" name="yzm" maxlength="4" tabindex="1">
		          <div id="v_container" style="position:absolute; display:inline-block;width:121px;height: 44px;"></div>
		          <span class="info" id="jpgVerifys" style="padding-left: 125px" data-info="请输入图片验证码">请输入图片验证码</span></li>
		        <li class="telNumber"> <span class="dis">手机号码:</span>
		          <input type="text" class="input _phoneNum" id="phone" name="phone" tabindex="1" maxlength="11">
		          <input type="button" class="button radius1 _getkey" id="sendPhone" value="获取验证码" />
				  <span id="phoneJy" data-info="请输入您的常用电话">请输入您的常用电话</span></li>
		        <li class="telNumber"><span class="dis">短信验证码:</span>
		          <input id="phonVerify" type="text" class="input input1  _phonVerify" data-_id="phonVerify" tabindex="1">
		          <span class="info" id="phonVerifys" data-info="请输入手机验证码">请输入手机验证码</span></li>
		        <li class="agree">
		        <input type="hidden" name="referrer" value="${param.referrerm}">
		          <input name="protocol" id="protocol" type="checkbox" value="" checked="checked">
		                               我同意《<a href="#" target="_black">金源宝注册协议</a>》 <span id="protocolAlt" data-info="请查看协议">请查看协议，并勾选</span></li>
		        <li class="btn"><a id="submit1" href="javascript:void(0);" class="">下一步</a></li>
		      </ul>
		   </form>
	    </div>
	  </div>
	</div>
	<%@ include file="/jsp/frontpage/include/foot.jsp"%>
</body>
</html>