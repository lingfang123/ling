<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=path%>/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>金源宝——法律声明</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="jsp/frontpage/css/common.css" rel="stylesheet" />
<link href="jsp/frontpage/css/about.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="jsp/frontpage/script/jquery.min.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/common.js"></script>
</head>
<body>
<%@ include file="/jsp/frontpage/include/head.jsp"%>
<!--关于我们-->
<div class="bg">
  <div class="contain" id="tabs" style="margin:0 auto;">
    <div class="text-nav">
      <ul class="clearfix">
        <li> <a class="text-link" href="noticeCompany/openNotice">网站公告</a> </li>
        <li> <a class="text-link" href="newCompany/openNew">媒体报道</a> </li>
        <li> <a class="text-link" href="companyReportForm/selectCompanyReportForm">运营报告</a> </li>
        <li> <a class="text-link" href="index/companyInfo">公司简介</a> </li>
        <li> <a class="text-link" href="law/openlawPage?style=1">法律政策</a> </li>
        <li class="selected"> <a class="text-link" href="law/openlawPage?style=2">法律声明</a> </li>
        <li> <a class="text-link" href="law/openlawPage?style=3">资费说明</a> </li>
        <li> <a class="text-link" href="recruit/openrecruit">招贤纳士</a> </li>
        <li> <a class="text-link" href="relationUs/openRelation">联系我们</a> </li>
      </ul>
    </div>
    <div class="text-box">
      <div class="text-content" id="text-content">
        <h1 class="title">法律声明</h1>
        <c:forEach items="${listlaws}" var="laws">
        	${laws.name}
        	${laws.rejoin}
        </c:forEach>
      </div>
    </div>
  </div>
</div>
<!--网站底部-->
<%@ include file="/jsp/frontpage/include/foot.jsp"%>
</body>
</html>
