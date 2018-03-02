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
<title>金源宝——我的红包</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="jsp/frontpage/css/common.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="jsp/frontpage/css/user.css" />
<link rel="stylesheet" type="text/css" href="jsp/frontpage/css/jquery.datetimepicker.css"/>
<script type="text/javascript" src="jsp/frontpage/script/jquery.min.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/common.js"></script>
<script src="jsp/frontpage/script/user.js" type="text/javascript"></script>
<style>
.zqzr-list{
	/*width: 900px;
	height: 300px;
	border: 1px solid palegoldenrod;
	margin-top:200px;
	position: absolute;
	float: left;
	overflow: auto;*/
	display: none;
}	
.zqzr-list-one{
	width: 400px;
	height: 120px;
	border: 1px solid palegoldenrod;
	margin-top:20px;
	position: relative;
	float: left;
	margin-left: 20px;
}

.zqzr-list-one a{
	display: block;
	width: 50px;
	height: 120px;
	background: #FF5722;
	color: white;
	right: 0px;
	line-height: 30px;
	font-size: 26px;
	text-align: center;
	position: absolute;
} 
.zqzr-list-one .left-one{
	color: #FF5722;
	font-size: 30px;
	float: left;
	left:30px ;
	top: 10px;
	position: absolute;
}	

.zqzr-list-one .left-tow{
	opacity: 0.5;
	font-size: 12px;
	left: 120px;
	top: 10px;
	position: absolute;
}

.zqzr-list-one .left-three{
	position: absolute;
	font-size: 13px;
	left: 120px;
	top: 30px;
}

.zqzr-list-one	.left-four{
	position: absolute;
	opacity: 0.5;
	font-size: 13px;
	left: 30px;
	top: 60px;
}

.zqzr-list-one .left-five{
	position: absolute;
	left: 30px;
	bottom:2px ;
	color: #FF5722;
}

.zqzr-list-one.yishiyong{
	opacity: 0.5;
}

.zqzr-list-one.guoqi{
	opacity: 0.5;
}


</style>
<script>
	window.onload = function(){
		
		function kaPian(){
			var tab = document.getElementById("wdhb-tab");
			var lis = tab.getElementsByTagName("li");
			var zqzrList = document.getElementsByClassName("zqzr-list");
			for (var i=0;i<lis.length;i++) {
				lis[i].xuhao = i;
				lis[i].onclick = function(){
					for (var i=0;i<lis.length;i++) {
						zqzrList[i].style.display = "none";
					}
					zqzrList[this.xuhao].style.display = "block";
				}
			}
		}
		kaPian();
		
		
	}
	
	$(function(){
		var c;
		$("#wdhb-tab ul li").click(function(){
			c = $(this).index();
			$("#wdhb-tab ul li").eq(c).css({"background":"#0CAFFE"}).siblings("li").css({"background":"#F8F8F8"});
		});
		
		
		
		$(".btn").click(function(){
			
			var i = $(this).index();
			
			var w = $("#zqzr-list div").children("span.left-lilv").length;
			
			var ww = $("span.left-lilv").eq(i);
			
			alert(ww);
		})
		
		
	})
	
	
</script>

</head>
<body>
<%@ include file="/jsp/frontpage/include/head.jsp"%>
<!--个人中心-->
<div class="wrapper wbgcolor">
  <div class="w1200 personal">
   <%@ include file="/jsp/frontpage/include/personalLeft.jsp"%>
    <label id="typeValue" style="display:none;"> </label>
    <style type="text/css">
			.wdhb-tab .on  a{color:#fff;}
		</style>
    <div class="personal-main">
      <div class="personal-zqzr personal-xtxx" style="min-height: 500px;">
        <h3><i>我的红包</i></h3>
        <div class="lx-wdhb"> <span class="pay-title">兑换红包</span> <span class="pay-number">
          <form id="codeForm" name="codeForm" method="post" action="">
            <input id="codeForm:code" type="text" name="codeForm:code" class="pay-money-txt">
            <input type="submit" name="codeForm:j_idt73" value="兑换" class="btn-dh">
            <span class="cz-error" style="display:none;"> <span class="error">红包兑换码不能为空！</span> </span>
          </form>
          <script>
	        //<![CDATA[  
	          	$(function(){
	          		if(true){
	          			$("#codeForm\\:code").val("输入验证码，兑换相应面值的红包");	
	          		}
	          		$("#codeForm\\:code").blur(function(){
	          			var code = $(this).val();
	          			if(undefined == code || null == code || "" == code || "输入验证码，兑换相应面值的红包" == code){
	          				$(this).val("输入验证码，兑换相应面值的红包");	     
	          				$(".cz-error").css({"display": "block"});
	          			}
	          		});
	          		$("#codeForm\\:code").focus(function(){
	          			$(".cz-error").css({"display": "none"});
	          			var code = $(this).val();
	          			if(undefined != code && null != code && "输入验证码，兑换相应面值的红包" == code){
	          				$(this).val("");	          				
	          			}
	          		});
	          	})
	          	
	          	function checkExchangeCode(){
	          		var code = $("#codeForm\\:code").val();
          			if(undefined == code || null == code || "" == code || "输入验证码，兑换相应面值的红包" == code){
          				$(this).val("输入验证码，兑换相应面值的红包");	     
          				$(".cz-error").css({"display": "block"});
          				return false;
          			}
          			return true;
	          	}
	          	//]]>
	          </script>
          </span> </div>
        <form id="form" name="form" method="post" action="">
          <script type="text/javascript">clearPage = function() {PrimeFaces.ab({source:'form:j_idt76',formId:'form',process:'form:j_idt76',params:arguments[0]});}</script>
          <span id="form:dataTable">
          <div id="wdhb-tab" class="wdhb-tab">
            <ul>
              <li style="background: #0CAFFE;"><a href="javascript:(0);" title="未使用">未使用 </a> </li>
              <li><a href="javascript:(0);" title="已使用" >已使用 </a> </li>
              <li><a href="javascript:(0);" title="已过期">已过期 </a> </li>
            </ul>
          </div>
          <!--<div class="wdhb-title"><span class="wdhb-name">红包名称</span><span class="wdhb-con">红包简介</span><span class="wdhb-deadline">截止日期</span> <span class="wdhb-status">状态</span> </div>-->
         
          <div class="zqzr-list" id="zqzr-list" style="display: block;">
           <c:forEach items="${listA}" var="a">
	            <div class="zqzr-list-one">																				
		            <span class="left-one left-lilv" id="left-lilv">${a.hbmoney}元</span><span class="left-tow">${a.remark}</span><span class="left-three">适用${a.minmoney}元-${a.tjmoney }元</span>
		            <!-- <span class="left-four">适用<span class="left-day-one">89</span>天-<span class="left-day-tow">95</span>天 (自动投标可用)<br /> -->
					<span class="left-four">
						<span><fmt:formatDate value="${a.harvesttime}" pattern="yyyy-MM-dd hh:mm:ss"/></span>
							至
						<span><fmt:formatDate value="${a.expiretime}" pattern="yyyy-MM-dd hh:mm:ss"/> </span>
					</span>
		            </span>
	         		<span class="left-five">
	         			剩余<span class="left-day-three">${a.daynumber}</span>天过期
	         		</span>
		            <a class="list-right btn" href="javascript:(0)">立即使用</a>
	            </div>
	        </c:forEach>
          </div>
          
          <div class="zqzr-list" id="zqzr-tow">
            	<div class="zqzr-list-one yishiyong" >
	            	<c:forEach items="${listB}" var="b">
			            <span class="left-one">${b.hbmoney}元</span><span class="left-tow">${b.remark}</span><span class="left-three">适用${b.minmoney}元-${b.tjmoney }元</span>
			            
			            <!-- <span class="left-four">适用<span>89</span>天-<span>95</span>天 (自动投标可用)<br /> -->
						<span class="left-four">
						<span><fmt:formatDate value="${b.harvesttime}" pattern="yyyy-MM-dd hh:mm:ss"/></span>
							至 
						<span><fmt:formatDate value="${b.expiretime}" pattern="yyyy-MM-dd hh:mm:ss"/> </span>
						</span> 
			            </span>
			         		<span class="left-five">
			         			剩余<span>${b.daynumber}</span>天过期
			         		</span>
			            <a class="list-right" href="javascript:(0)">已使用</a>
			       </c:forEach>
	           </div>
          </div>
          
          <div class="zqzr-list" id="zqzr-three">
          		<div class="zqzr-list-one guoqi" >
	          		<c:forEach items="${listC}" var="c">
			            <span class="left-one">${c.hbmoney}元</span><span class="left-tow">${c.remark}</span><span class="left-three">适用${c.minmoney}元-${c.tjmoney}元</span>
			            
			            <!-- <span class="left-four">适用<span>89</span>天-<span>95</span>天 (自动投标可用)<br /> -->
						<span class="left-four">
							<span><fmt:formatDate value="${c.harvesttime}" pattern="yyyy-MM-dd hh:mm:ss"/></span>
								至 
							<span><fmt:formatDate value="${c.expiretime}" pattern="yyyy-MM-dd hh:mm:ss"/> </span>
						</span> 
			            </span>
			         		<span class="left-five">
			         			剩余<span>${c.daynumber}</span>天过期
			         		</span>
			            <a class="list-right" href="javascript:(0)">已过期</a>
			        </c:forEach>
	            </div>
          </div>
          
          <!--<div style="float:left; width:760px;height:200px;padding-top:100px; text-align:center;color:#d4d4d4; font-size:16px;">
					 <img src="images/nondata.png" width="60" height="60"><br><br>
					   暂无红包记录</div>-->
          </span>
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
