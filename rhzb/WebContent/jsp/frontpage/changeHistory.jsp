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
<title>金源宝——兑换历史</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="jsp/frontpage/css/common.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="jsp/frontpage/css/user.css" />
<link rel="stylesheet" type="text/css" href="jsp/frontpage/css/jquery.datetimepicker.css"/>
<script type="text/javascript" src="jsp/frontpage/script/jquery.min.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/common.js"></script>
<script src="jsp/frontpage/script/user.js" type="text/javascript"></script>
</head>
<body>
<%@ include file="/jsp/frontpage/include/head.jsp"%>
<!--个人中心-->
<div class="wrapper wbgcolor">
  <div class="w1200 personal">
   <%@ include file="/jsp/frontpage/include/personalLeft.jsp"%>
    <label id="typeValue" style="display:none;"> </label>
    <div class="personal-main">
      <div class="personal-zqzr personal-xtxx" style="min-height: 500px;">
        <h3> <i>兑换历史</i> </h3>
        <div class="wdhb-title wdhb-dhls"> <span class="wdhb-yzm">兑换用途</span><span class="wdhb-con">兑换红包名称</span><span class="wdhb-deadline">兑换日期</span> </div>
        <form id="form" name="form" method="post" action="">
          <div class="zqzr-list">
            <ul>
            <c:forEach items="${listR}" var="r">
              <li><span class="wdhb-yzm">${r.markname}</span><span class="wdhb-con">${r.redname}</span><span class="wdhb-deadline"><fmt:formatDate value="${r.redtime}" pattern="yyyy-MM-dd hh:mm:ss"/></span></li>
            
           </c:forEach>
            </ul>
          </div>
          <!--<div style="float:left; width:760px;height:200px;padding-top:100px; text-align:center;color:#d4d4d4; font-size:16px;">
					 <img src="/site/themes/default/style/../images/nondata.png" width="60" height="60"><br><br>
					   暂无兑换记录</div>-->
        </form>
      </div>
    </div>
    <div class="clear"></div>
  </div>
</div>
<!--网站底部-->
<%@ include file="/jsp/frontpage/include/foot.jsp"%>
<script src="jsp/frontpage/script/jquery.datetimepicker.js" type="text/javascript"></script>
<script src="jsp/frontpage/script/datepicker.js" type="text/javascript"></script>
</body>
</html>
