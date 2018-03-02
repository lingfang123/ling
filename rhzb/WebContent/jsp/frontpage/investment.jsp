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
<title>金源宝——投资记录</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="jsp/frontpage/css/common.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="jsp/frontpage/css/user.css" />
<script type="text/javascript" src="jsp/frontpage/script/jquery.min.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/common.js"></script>
<script src="jsp/frontpage/script/user.js" type="text/javascript"></script>
<style type="text/css">
	.investnote-list{
		display: none;
	}
	a{
		text-decoration:none;
	}
	a:hover{
		text-decoration:none;
	}
	#page{
		display:block;
		margin: 10px auto;
		width: 80%;
	}
	.tbody-a{
		float:left;
		display:block;
		width: 45px;
		height:25px;
		line-height:25px;
		text-align:center;
		font-size:10px;
		border: 1px solid #edcce6;
		margin-right: 5px;
		font-style: "微软雅黑";
		border-radius: 4px;
	}
	.tbody-a:hover {
		background-color: #AFEDF6;
		color: white;
		border-radius: 4px;
	}
</style>
<script>
	$(function(){
		<%--格式化时间（yyyy-MM-dd HH:mm:ss）--%>
		function getNowFormatDate(dateid,dateTime) {
		    var date = new Date(dateTime);
		    var seperator1 = "-";
		    var seperator2 = ":";
		    var year = date.getFullYear();
		    var month = date.getMonth() + 1;
		    var strDate = date.getDate();
		    if (month >= 1 && month <= 9) {
		        month = "0" + month;
		    }
		    if (strDate >= 0 && strDate <= 9) {
		        strDate = "0" + strDate;
		    }
		    var currentdate = year + seperator1 + month + seperator1 + strDate
		            + " " + date.getHours() + seperator2 + date.getMinutes()
		            + seperator2 + date.getSeconds();
		    $(dateid).html(currentdate);
		}
		
		$(".invest-tab ul li").click(function(){
			var c = $(this).index();
			$(this).css({"background":"#0CAFFE"}).siblings("li").css({"background":"#F2F2F2"});
			$(this).children("a").css({"color":"#D8FFFF"});
			$(this).siblings("li").children("a").css({"color":"#A08492"});
			$("div .investnote-list").eq(c).css({"display":"block"}).siblings("div .investnote-list").css({"display":"none"});
		});
		/* $('#status4').click(function(){
			$.ajax({
				url:'invest/listByUseridWithStatus',
				type:'post',
				data:{'userid':${user.id},'status':4},
				dataType:'json',
				success:function(result){
					for(var i=1;i<=result.length;i++){
						var w = document.getElementById("uls").getElementsByTagName("li");
						var time = getNowFormatDate('#bidtime1',result[i].bidtime);
						w[i].innerHTML ="<span id='bidtime1' class='investnote-w1'>"+time+"</span>"+
										 "<span class='investnote-w2'>"+result[i].markid+"</span>"+
										 "<span class='investnote-w3'>"+result[i].status+"</span>"+
										 "<span class='investnote-w4'>"+result[i].markmoney+"</span>"+
										 "<span class='investnote-w5'>"+result[i].overduemoney+"</span>"+
										 "<span class='investnote-hbw6'><a href='invest/deleteInvest?id="+result[i].id+"'>删除</a></span>";
						
						$('#markid1').html(result[i].markid);
						$('#status1').html(result[i].status);
						$('#markmoney1').html(result[i].markmoney);
						$('#overduemoney1').html(result[i].overduemoney);
						$('#delete1').html('<a href="invest/deleteInvest?id='+result[i].id+'">删除</a>');
					}
				}
			});
		}); */
		/* $('#status5').click(function(){
			$.ajax({
				url:'invest/listByUseridWithStatus',
				type:'post',
				data:{'userid':${user.id},'status':5},
				dataType:'json',
				success:function(result){
					for(var i=0;i<result.length;i++){
						
						getNowFormatDate('#bidtime2',result[i].bidtime);
						$('#markid2').html(result[i].markid);
						$('#status2').html(result[i].status);
						$('#markmoney2').html(result[i].markmoney);
						$('#overduemoney2').html(result[i].overduemoney);
						$('#delete2').html('<a href="invest/deleteInvest?id='+result[i].id+'">删除</a>');
					}
				}
			});
		}); */
		
	})
</script>	
</head>
<body>
<%@ include file="/jsp/frontpage/include/head.jsp"%>
<!--个人中心-->
<div class="wrapper wbgcolor">
  <div class="w1200 personal">
    <%@ include file="/jsp/frontpage/include/personalLeft.jsp"%>
    <style type="text/css">
		.invest-tab .on  a{color:#fff;}
	</style>
    <div class="personal-main">
      <div class="personal-investnote">
        <h3><i>投资记录</i></h3>
        <div class="investnote-money"> 
        	<span><b class="fb">累计投资</b><br><i>${allCorpus}</i> 元 </span> 
          	<span><b class="fb">累计收益</b><br><i class="c-pink">${allLucre}</i> 元 </span> 
          	<span><b class="fb">待收本金</b><br><i>${waitCorpus}</i> 元 </span> 
          	<span class="none"><b class="fb">待收收益</b><br><i>${waitLucre}</i> 元 </span> 
        </div>
        <form id="form" name="form" method="post" action="">
          <script type="text/javascript">clearPage = function() {PrimeFaces.ab({source:'form:j_idt82',formId:'form',process:'form:j_idt82',params:arguments[0]});}</script>
          <span id="form:dataTable">
          <div class="invest-tab">
            <ul>
              <li class="on"><span><a href="javascript:0" title="投标中">投标中 </a> </span> </li>
              <li><a id="status4" href="javascript:0" title="回款中">回款中 </a> </li>
              <li><a id="status5" href="javascript:0" title="已结束">已结束 </a> </li>
              <li><a href="investPoi/ExportExcel"><button type="button" style="border:0;width:70px ;height:30px ;background:#8CD3F2;display:inline;"><span class="">导出数据</span></button></a> </li>
            </ul>
          </div>
          <div class="investnote-list" style="display: block;">
            <div class="investnote-contitle"> <span class="investnote-w1 fb">交易时间</span> <span class="investnote-w2 fb">项目</span> <span class="investnote-w3 fb">状态</span> <span class="investnote-hbw4 fb">我的投资</span> <span class="investnote-hbw5 fb">我的收益</span> <span class="investnote-hbw6 fb">操作</span> </div>
            <ul>
            	<c:forEach items="${investList1.lists}" var="invest1">
            		<li>
	            		<span class="investnote-w1">
	            			<fmt:formatDate value="${invest1.bidtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
	            		</span>
	            		<span class="investnote-w2">${invest1.title}</span>
	            		<span class="investnote-w3">
	            			<c:if test="${invest1.status eq 1}">竞标中</c:if>
	            			<c:if test="${invest1.status eq 2}">流标</c:if>
	            			<c:if test="${invest1.status eq 3}">竞标成功</c:if>
	            			<c:if test="${invest1.status eq 4}">还款中</c:if>
	            			<c:if test="${invest1.status eq 5}">已完成</c:if>
	            		</span>
	            		<span class="investnote-hbw4">${invest1.markmoney}</span> 
	            		<span class="investnote-hbw5">${invest1.overduemoney}</span> 
	            		<span class="investnote-hbw6">
	            			<a onclick="javascript:if (confirm('确定删除吗？')) { return true;}else{return false;};" href='invest/deleteInvest?id=${invest1.id}'>删除</a> 
	            		</span>
            		</li>
            	</c:forEach>
              <!--<div style=" width:760px;height:200px;padding-top:100px; text-align:center;color:#d4d4d4; font-size:16px;">
								 <img src="images/nondata.png" width="60" height="60"><br><br>
								   暂无投资记录</div>-->
	            <!--分页 -->
	            <c:if test="${investList1!=null}">
		            <li>
				      	<span>
					      	<c:if test="${investList1.currPage>1}">
						      	<a style="text-decoration:none;" class="tbody-a" href="invest/openInvestPage?curPage1=1">首页</a>
						    </c:if>
						    <c:if test="${investList1.currPage>1}">
						      	<a style="text-decoration:none;" class="tbody-a" href="invest/openInvestPage?curPage1=${investList1.currPage-1}">上一页</a>&nbsp;
						    </c:if>
						    <c:forEach var="i" begin="1" step="1" end="${investList1.totalPage}">
						      <a class="tbody-a" <c:if test="${investList1.currPage==i}">style="background: #AFEDF6"</c:if> href="invest/openInvestPage?curPage1=${i}">${i}</a>
						    </c:forEach>  
						    <c:if test="${investList1.currPage<investList1.totalPage}">
						      <a style="text-decoration:none;" class="tbody-a" href="invest/openInvestPage?curPage1=${investList1.currPage+1}">下一页</a>
						    </c:if>
						    <c:if test="${investList1.currPage<investList1.totalPage}">
						      <a style="text-decoration:none;" class="tbody-a" href="invest/openInvestPage?curPage1=${investList1.totalPage}">尾页</a>&nbsp;
						    </c:if>
						    <em>共${investList1.totalPage}页&nbsp;</em>
					    </span>
				     </li>
			     </c:if>
            </ul>
          </div>
          
          <!--回款中的表  -->
          <div class="investnote-list">
            <div class="investnote-contitle"> <span class="investnote-w1 fb">交易时间</span> <span class="investnote-w2 fb">项目</span> <span class="investnote-w3 fb">状态</span> <span class="investnote-hbw4 fb">我的投资</span> <span class="investnote-hbw5 fb">我的收益</span> <span class="investnote-hbw6 fb">操作</span> </div>
            <ul id="uls">
            	<c:forEach items="${investList2.lists}" var="invest2">
	            	<li>
	            		<span class="investnote-w1">
	            			<fmt:formatDate value="${invest2.bidtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
	            		</span>
	            		<span id="markid1" class="investnote-w2">${invest2.title}</span>
	            		<span id="status1" class="investnote-w3">
	            			<c:if test="${invest2.status eq 1}">竞标中</c:if>
	            			<c:if test="${invest2.status eq 2}">流标</c:if>
	            			<c:if test="${invest2.status eq 3}">竞标成功</c:if>
	            			<c:if test="${invest2.status eq 4}">还款中</c:if>
	            			<c:if test="${invest2.status eq 5}">已完成</c:if>
	            		</span>
	            		<span id="markmoney1" class="investnote-hbw4">${invest2.markmoney}</span> 
	            		<span id="overduemoney1" class="investnote-hbw5">${invest2.overduemoney}</span> 
	            		<span id="delete1" class="investnote-hbw6">
	            			<a onclick="javascript:if (confirm('确定删除吗？')) { return true;}else{return false;};" href='invest/deleteInvest?id=${invest2.id}'>删除</a> 
	            		</span>
	           		</li>
	           	</c:forEach>
	           	
              <!--<div style=" width:760px;height:200px;padding-top:100px; text-align:center;color:#d4d4d4; font-size:16px;">
								 <img src="images/nondata.png" width="60" height="60"><br><br>
								   暂无投资记录</div>-->
            	<!--分页 -->
	            <c:if test="${investList2!=null}">
		            <li>
				      	<span>
					      	<c:if test="${investList2.currPage>1}">
						      	<a style="text-decoration:none;" class="tbody-a" href="invest/openInvestPage?curPage2=1">首页</a>
						    </c:if>
						    <c:if test="${investList2.currPage>1}">
						      	<a style="text-decoration:none;" class="tbody-a" href="invest/openInvestPage?curPage2=${investList2.currPage-1}">上一页</a>&nbsp;
						    </c:if>
						    <c:forEach var="i" begin="1" step="1" end="${investList2.totalPage}">
						      <a class="tbody-a" <c:if test="${investList2.currPage==i}">style="background: #AFEDF6"</c:if> href="invest/openInvestPage?curPage2=${i}">${i}</a>
						    </c:forEach>  
						    <c:if test="${investList2.currPage<investList2.totalPage}">
						      <a style="text-decoration:none;" class="tbody-a" href="invest/openInvestPage?curPage2=${investList2.currPage+1}">下一页</a>
						    </c:if>
						    <c:if test="${investList2.currPage<investList2.totalPage}">
						      <a style="text-decoration:none;" class="tbody-a" href="invest/openInvestPage?curPage2=${investList2.totalPage}">尾页</a>&nbsp;
						    </c:if>
						    <em>共${investList2.totalPage}页&nbsp;</em>
					    </span>
				     </li>
			     </c:if>
            </ul>
          </div>
          
          <!--已结束的表  -->
          <div class="investnote-list">
            <div class="investnote-contitle"> <span class="investnote-w1 fb">交易时间</span> <span class="investnote-w2 fb">项目</span> <span class="investnote-w3 fb">状态</span> <span class="investnote-hbw4 fb">我的投资</span> <span class="investnote-hbw5 fb">我的收益</span> <span class="investnote-hbw6 fb">操作</span> </div>
            <ul>
           		<c:forEach items="${investList3.lists}" var="invest3">
	            	<li>
	            		<span class="investnote-w1">
	            			<fmt:formatDate value="${invest3.bidtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
	            		</span>
	            		<span id="markid1" class="investnote-w2">${invest3.title}</span>
	            		<span id="status1" class="investnote-w3">
	            			<c:if test="${invest3.status eq 1}">竞标中</c:if>
	            			<c:if test="${invest3.status eq 2}">流标</c:if>
	            			<c:if test="${invest3.status eq 3}">竞标成功</c:if>
	            			<c:if test="${invest3.status eq 4}">还款中</c:if>
	            			<c:if test="${invest3.status eq 5}">已完成</c:if>
	            		</span>
	            		<span id="markmoney1" class="investnote-hbw4">${invest3.markmoney}</span> 
	            		<span id="overduemoney1" class="investnote-hbw5">${invest3.overduemoney}</span> 
	            		<span id="delete1" class="investnote-hbw6">
	            			<a onclick="javascript:if (confirm('确定删除吗？')) { return true;}else{return false;};" href='invest/deleteInvest?id=${invest3.id}'>删除</a> 
	            		</span>
	           		</li>
	           	</c:forEach>
              <!--<div style=" width:760px;height:200px;padding-top:100px; text-align:center;color:#d4d4d4; font-size:16px;">
								 <img src="images/nondata.png" width="60" height="60"><br><br>
								   暂无投资记录</div>-->
            	<!--分页 -->
	            <c:if test="${investList3!=null}">
		            <li>
				      	<span>
					      	<c:if test="${investList3.currPage>1}">
						      	<a style="text-decoration:none;" class="tbody-a" href="invest/openInvestPage?curPage3=1">首页</a>
						    </c:if>
						    <c:if test="${investList3.currPage>1}">
						      	<a style="text-decoration:none;" class="tbody-a" href="invest/openInvestPage?curPage3=${investList3.currPage-1}">上一页</a>&nbsp;
						    </c:if>
						    <c:forEach var="i" begin="1" step="1" end="${investList3.totalPage}">
						      <a class="tbody-a" <c:if test="${investList3.currPage==i}">style="background: #AFEDF6"</c:if> href="invest/openInvestPage?curPage3=${i}">${i}</a>
						    </c:forEach>  
						    <c:if test="${investList3.currPage<investList3.totalPage}">
						      <a style="text-decoration:none;" class="tbody-a" href="invest/openInvestPage?curPage3=${investList3.currPage+1}">下一页</a>
						    </c:if>
						    <c:if test="${investList3.currPage<investList3.totalPage}">
						      <a style="text-decoration:none;" class="tbody-a" href="invest/openInvestPage?curPage3=${investList3.totalPage}">尾页</a>&nbsp;
						    </c:if>
						    <em>共${investList3.totalPage}页&nbsp;</em>
					    </span>
				     </li>
			     </c:if>
            </ul>
          </div>
          
          </span>
        </form>
      </div>
    </div>
    <div class="clear"></div>
  </div>
</div>
<!--网站底部-->
<%@ include file="/jsp/frontpage/include/foot.jsp"%>
</body>
</html>
