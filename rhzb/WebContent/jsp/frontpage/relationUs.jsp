<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=path%>/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>金源宝——联系我们</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="jsp/frontpage/css/common.css" rel="stylesheet" />
<link href="jsp/frontpage/css/about.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="jsp/frontpage/script/jquery.min.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/common.js"></script>
</head>
<body>
<%@ include file="/jsp/frontpage/include/head.jsp"%>
<!--联系我们-->
<div class="bg">
  <div class="contain" id="tabs" style="margin:0 auto;">
    <div class="text-nav">
      <ul class="clearfix">
        <li> <a class="text-link" href="noticeCompany/openNotice">网站公告</a> </li>
        <li> <a class="text-link" href="newCompany/openNew">媒体报道</a> </li>
        <li> <a class="text-link" href="companyReportForm/selectCompanyReportForm">运营报告</a> </li>
        <li> <a class="text-link" href="index/companyInfo">公司简介</a> </li>
        <li> <a class="text-link" href="law/openlawPage?style=1">法律政策</a> </li>
        <li> <a class="text-link" href="law/openlawPage?style=2">法律声明</a> </li>
        <li> <a class="text-link" href="law/openlawPage?style=3">资费说明</a> </li>
        <li> <a class="text-link" href="recruit/openrecruit">招贤纳士</a> </li>
        <li class="selected"> <a class="text-link" href="relationUs/openRelation">联系我们</a> </li>
      </ul>
    </div>
    <div class="text-box">
      <div class="text-content" id="text-content">
        <h1 class="title">联系我们</h1>
        <p class="mt20 cn_line"> 如果您有任何意见或建议，欢迎通过邮件或电话联系我们。同时，欢迎您到我们公司参观或走访，来访前请先与我们的客服人员联系，我们将安排工作人员接见您的到来，感谢您对乐投贷的信任和支持！ </p>
        <div class="mt20 cn_line fl" style="width:50%;height:150px;"> 
	        <span style="line-height:34px;font-family:Microsoft YaHei;color:#0aaae1;font-size:24px;">
	        	工作时间
	        </span><br>
	        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客服热线: ${listRelationUss[0].servicenumber}<br>
	        
	        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见、建议反馈邮箱:${listRelationUss[0].email}<br>
	        <span style="padding-left:20px;font-size:12px;color:#888;">
	        	&nbsp;&nbsp;客服时间:${listRelationUss[0].servetime}
	        </span>
        </div>
        <div class="mt20 cn_line fl" style="width:50%;height:150px;"> 
        	<span style="line-height:34px;font-family:Microsoft YaHei;color:#0aaae1;font-size:24px;">
        		商务合作部
        	</span><br>
          	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;负责人:${listRelationUss[0].hzname}<br>
          	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电子邮箱:${listRelationUss[0].hzemail}
        </div>
        <div class="mt20 cn_line fl" style="width:50%;height:150px;"> 
        	<span style="line-height:34px;font-family:Microsoft YaHei;color:#0aaae1;font-size:24px;">
        		招聘服务部
        	</span><br>
          	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;负责人:${listRelationUss[0].recruitname} <br>
          	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系邮箱:${listRelationUss[0].recruitemail} <br>
        </div>
        <div class="mt20 cn_line fl" style="width:50%;height:150px;"> 
        	<span style="line-height:34px;font-family:Microsoft YaHei;color:#0aaae1;font-size:24px;">
        		外联事务部
        	</span><br>
         	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;负责人:${listRelationUss[0].mtname}<br>
          	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电子邮箱：${listRelationUss[0].mtemail}
        </div>
        <div class="mt20 cn_line fl" style="width:50%;height:150px;"> 
        	<span style="line-height:34px;font-family:Microsoft YaHei;color:#0aaae1;font-size:24px;">
        		关于公司
        	</span><br>
         	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;公司地址:${listRelationUss[0].gssite}<br>
          	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;公司电话：${listRelationUss[0].gsnumber}<br>
          	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;邮政编码：${listRelationUss[0].dawknumber}
        </div>
        	<iframe src="jsp/frontpage/baiduMap.jsp" width="100%" height="300px"></iframe>
      </div>
    </div>
  </div>
</div>
<!--网站底部-->
<%@ include file="/jsp/frontpage/include/foot.jsp"%>
</body>
</html>
