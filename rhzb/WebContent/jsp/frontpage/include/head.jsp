<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>金源宝——头部</title>

<style>
	a{text-decoration:none}
	a {font-size:16px}   
	a:link {color: blue; text-decoration:none;} //未访问：蓝色、无下划线   
	a:active:{color: red; } //激活：红色   
	a:visited {color:purple;text-decoration:none;} //已访问：紫色、无下划线   
	a:hover {color: red; text-decoration:underline;} //鼠标移近：红色、下划线   
</style>

</head>
<body>
	<%-- 头部 --%>
	<header>
	  <div class="header-top min-width">
	    <div class="container fn-clear"> <strong class="fn-left">咨询热线：400-668-6698<span class="s-time">服务时间：9:00 - 18:00</span></strong>
	      <ul class="header_contact">
	        <li class="c_1"> <a class="ico_head_weixin" id="wx"></a>
	          <div class="ceng" id="weixin_xlgz" style="display: none;">
	            <div class="cnr"> <img src="/rhzb/jsp/frontpage/images/code.png"> </div>
	            <b class="ar_up ar_top"></b> <b class="ar_up_in ar_top_in"></b> </div>
	        </li>
	        <li class="c_2"><a href="#" target="_blank" title="官方QQ" alt="官方QQ"><b class="ico_head_QQ"></b></a></li>
	        <li class="c_4"><a href="#" target="_blank" title="新浪微博" alt="新浪微博"><b class="ico_head_sina"></b></a></li>
	      </ul>
	      <ul class="fn-right header-top-ul">
	        <li> <a href="index/frontpage" class="app">返回首页</a> </li>
	        <li>
	          <div class=""><a href="register/openRegisterPage" class="c-orange" title="免费注册">免费注册</a></div>
	        </li>
	        <li>
	          <div class="">
		          <c:if test="${user==null}">
		          	<a href="login/userLogin" class="js-login" title="登录">登录</a>
		          </c:if>
		          <c:if test="${user!=null}">
		          	<a href="login/loginOut" class="js-login" title="安全退出">安全退出</a>
		          </c:if>
	          </div>
	        </li>
	      </ul>
	    </div>
	  </div>
	  
	  
	  <div class="header min-width">
	    <div class="container">
	      <div class="fn-left logo"><img src="/rhzb/jsp/frontpage/images/logo.png"  title=""></div>
	      <ul class="top-nav fn-clear">
	        <li class="on"> <a href="index/frontpage">首页</a> </li>
	        <li> <a href="markinfo/markInfoes?currentPage=1" class="">我要投资</a> </li>
	         <li> <a href="openapply" class="">我要借款</a> </li>
	        <li> <a href="helpCenter/openHelpPage">安全保障</a> </li>
	        <li class="top-nav-safe"> <a href="user/personal">我的账户</a> </li>
	        <li> <a href="index/companyInfo">关于我们</a> </li>
	      </ul>
	    </div>
	  </div>
	</header>
</body>
</html>