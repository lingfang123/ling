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
<title>金源宝——注册成功</title>
<link href="jsp/frontpage/css/common.css" rel="stylesheet" />
<link href="jsp/frontpage/css/register.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="jsp/frontpage/script/jquery.min.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/common.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/login.js"></script>
</head>
<body>
	<%@ include file="/jsp/frontpage/include/head.jsp"%>
	<!--注册成功-->
	<div class="wrap">
	  <div class="tdbModule register">
	    <div class="registerTitle">注册成功</div>
	    <div class="registerLc3">
	      <p class="p1">填写账户信息</p>
	      <p class="p2">验证手机信息</p>
	      <p class="p3">注册成功</p>
	    </div>
	    <div class="registerCont">
	      <ul>
	        <li class="scses"> ${user.username}， 恭喜您注册成功！<a class="blue" href="#" target="_blank">请立即开通--双乾支付账户,即可投资！</a></li>
	        <li class="rz"><a href="#" class="btn">立即开通</a><a href="user/personal" class="blue">进入我的账户</a></li>
	      </ul>
	    </div>
	  </div>
	</div>
	<%@ include file="/jsp/frontpage/include/foot.jsp"%>
</body>
</html>