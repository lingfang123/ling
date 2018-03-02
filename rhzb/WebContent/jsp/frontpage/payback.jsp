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
<title>金源宝——回款计划</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<script type="text/javascript" src="http://s.59pi.com/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="http://s.59pi.com/js/jquery/laydate/laydate.js"></script>
<link href="jsp/frontpage/css/common.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="jsp/frontpage/css/user.css" />
<link rel="stylesheet" type="text/css" href="jsp/frontpage/css/jquery.datetimepicker.css"/>
<script type="text/javascript" src="jsp/frontpage/script/jquery.min.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/common.js"></script>
<script src="jsp/frontpage/script/user.js" type="text/javascript"></script>
<script type="text/javascript" src="/rhzb/jsp/frontpage/lib/layer/2.4/layer.js"></script>


<!--  计算日历时间间隔 -->
<!-- <script type="text/javascript">
	var startdate='2013-08-01';
	var startdate='2013-09-10';
	var startD = new Date(Date.parse(startdate.replace(/-/g,"/")));
	var endD   = new Date(Date.parse(enddate.replace(/-/g,"/")));
	var days = parseInt((endD.getTime()-startD.getTime()) / (1000 * 60 * 60 * 24));
	if(days > 30){
	alert("日期范围应在一个月之内");
	return false;
	}
</script> -->


</head>
<body>
<%@ include file="/jsp/frontpage/include/head.jsp"%>
<!--个人中心-->
<div class="wrapper wbgcolor">
  <div class="w1200 personal">
   <%@ include file="/jsp/frontpage/include/personalLeft.jsp"%>
    <div class="personal-main">
      <div id="payback" class="personal-back">
        <h3><i>回款计划</i></h3>
            <c:set var="count" value="0"></c:set>
			<c:forEach items="${refundRecord }" var="item">
				<c:if test="${item.status eq '0'}">
   			 		<c:set var="count" value="${count+item.hkmoney }"></c:set>
   			 	</c:if>
			</c:forEach>
			<c:set var="counts" value="0"></c:set>
			<c:forEach items="${refundRecord }" var="item">
				<c:if test="${item.status eq '0'}">
   			 		<c:set var="counts" value="${counts=item.hkmoney }"></c:set>
   			 	</c:if>
			</c:forEach>
        <form id="form" name="form" method="post" action="">
          <input type="hidden" name="form" value="form">
          <div class="back-money"> <span class="back-own"><b class="fb">待还金额</b><br>
            <i>${count }</i> 元</span> <span class="back-profit"><b class="fb">每月应还</b><br>
            <i>${counts}</i> 元</span></div>
          <span id="form:dataTable">
          <div class="personal-backlist">      
            <div class="pmain-contitle"><span class="pmain-titledate fb">项目</span> <span class="pmain-titledate fb">还款时间</span> <span class="pmain-titledate fb">还款金额</span><span class="pmain-titledate fb">操作</span> </div>
            <ul style="float:left;">
            <c:forEach items="${refundRecord}" var="refundRecord">     
              <li>
	              <span class="pmain-titledate">${refundRecord.markname}</span>
	              <span class="pmain-titledate"><fmt:formatDate value="${refundRecord.refundtime}" pattern="yyyy-MM-dd"  /></span> 
	              <span class="pmain-titledate">${refundRecord.hkmoney}</span>
	              <span class="pmain-titledate">
	              	<c:if test="${refundRecord.status =='0'}">
	              		<a id="confirmButton">
	              		<input type="hidden" value="${refundRecord.backup1}" id="backup1" name="backup1">
	              		<input type="hidden" value="${refundRecord.id}" id="id" name="id">
              	  		<input type="hidden" value="${refundRecord.userid}" id="userid" name="userid">
              	  		<input type="hidden" value="${refundRecord.tmarkid}" id="tmarkid" name="tmarkid">
              	 		<input type="hidden" value="${refundRecord.hkmoney}" id="hkmoney" name="hkmoney">
	              		还款</a>
	              	</c:if>
	              		<c:if test="${refundRecord.status =='1'}">
	              		<a id="">已还款</a>
	              	</c:if>
	              </span>
              </li>
            </c:forEach>
            </ul>
          </div>
          </span>
        </form>
      </div>
    </div>
    <div class="clear"></div>
  </div>
</div>
 	<script type="text/javascript">
		$("#confirmButton").click(function(){
			var hkmoney = $("#hkmoney").val();
			var tmarkid = $("#tmarkid").val();
			var userid = $("#userid").val();
			var backup1 = $("#backup1").val();
			var id = $("#id").val();
			
			if(hkmoney.length!=0){
				layer.msg('还款中........',{icon:1,time:20000});
 					$.ajax({
						type: "post",
						url: "user/userhuankuan",
						data: {"hkmoney":hkmoney,"tmarkid":tmarkid,"userid":userid,"backup1":backup1,"id":id},
						datatype:"text",
						success: function(data){
							if(data=="800"){
								layer.msg('还款成功!',{icon:1,time:1000});
								setTimeout("parent.location.href='/rhzb/user/personal'",500);
							}
							if(data=="802"){
								layer.msg('还款失败!',{icon:1,time:1000});
								return false;
							}
							if(data=="000"){
								layer.msg('网络错误!',{icon:1,time:1000});
								return false;
							}

						},
					});
				}
			});
	</script>

<!--网站底部-->
<%@ include file="/jsp/frontpage/include/foot.jsp"%>
<script src="jsp/frontpage/script/jquery.datetimepicker.js" type="text/javascript"></script>
<script src="jsp/frontpage/script/datepicker.js" type="text/javascript"></script>
</body>

</html>
