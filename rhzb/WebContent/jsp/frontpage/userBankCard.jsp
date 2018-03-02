<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=path %>/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心-我的银行卡</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" type="text/css" href="jsp/frontpage/css/user.css" />
<link rel="stylesheet" type="text/css" href="jsp/frontpage/css/common.css" ></link>
<link rel="stylesheet" type="text/css" href="jsp/frontpage/css/fileupload.less.css"></link>

<script type="text/javascript" src="jsp/frontpage/script/jquery.min.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/common.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/user.js" ></script>


<link rel="stylesheet" type="text/css" href="jsp/frontpage/css/admin.css" />
<link href="jsp/frontpage/css/amazeui.css" rel="stylesheet" type="text/css" />
<link href="jsp/frontpage/css/personal.css" rel="stylesheet" type="text/css" />

<!-- 改变tomcat小图标 -->
<link  rel="Shortcut  Icon"  href="jsp/frontpage/statics/home/images/minilogo.png">
</head>
<body>
	<%@ include file="/jsp/frontpage/include/head.jsp"%>
<!-- 主体部分开始 -->
<div class="wrapper wbgcolor">
  <div class="w1200 personal">
	<%@ include file="/jsp/frontpage/include/personalLeft.jsp"%>
	
			<div class="col-main" style="width: 900px;float: left;">
				<div class="main-wrap" style="margin-left: 0px">
					<div class="am-cf am-padding">
						<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">我的银行卡</strong> / <small>My&nbsp;Credit&nbsp;Card</small></div>
					</div>
					<hr/>
					<div class="card-box-list">
						<ul>
							<c:forEach items="${listBank}" var="listBank">
								<li style="float:left;width:33.33%">
									<div class="card-box">
										<div class="card-box-name">
											<span class="bank-logo"><a href="#"><img src="jsp/frontpage/images/bankns.png"></a></span>
											<span class="bank-name">${listBank.placebank}</span>
											<span class="bank-num4">尾号 ${(listBank.bankcardno).subSequence(15,19)}</span>
											<span class="card-type card-type-DC"></span>
										</div>
										<div class="card-box-express">
											<div class="express-status">
												<span class="asset-icon asset-icon-express-s"></span><span>已开通</span>
											</div>
											<div class="express-else"><a onclick="javascript:if (confirm('确定删除此银行卡吗？')) { return true;}else{return false;};" href="bankCard/deleteUserBankCard?id=${listBank.id}&userid=${user.id}">删除该卡</a></div>
										</div>
										<div class="card-detail">
											<div class="card-detail-value" title="账单"><a href="javaScript:(0)"><strong>账单</strong><span></span></a></div>
										</div>
									</div>
								</li>
								</c:forEach>
							<li style="float:left;width:33.33%">
								<div class="add-card" style="border-radius: 4px;">
									<a href="bankCard/openAbankCard" target="_blank"><i class="">+</i>添加银行卡</a>
								</div>	
							</li>
						</ul>
					</div>
				</div>
			
	 </div>
	 
  </div>
</div>
<!-- 主体部分结束 -->		

				
	
	<%@ include file="/jsp/frontpage/include/foot.jsp"%>
</body>
</html>