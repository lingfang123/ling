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
<title>金源宝——个人中心</title>

<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" type="text/css" href="jsp/frontpage/css/user.css" />
<link rel="stylesheet" type="text/css" href="jsp/frontpage/css/common.css" ></link>
<link rel="stylesheet" type="text/css" href="jsp/frontpage/css/fileupload.less.css"></link>

<script type="text/javascript" src="jsp/frontpage/script/jquery.min.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/common.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/user.js" ></script>

<!-- 日历 css和js -->
<link rel="stylesheet" type="text/css" href="jsp/frontpage/rl/simple-calendar.css"></link>
<script type="text/javascript" src="jsp/frontpage/rl/simple-calendar.js"></script>


<style>
	.pmain-connent .pmain-conmain .pmain-conmain0 .pmain-conmain0-left{
		width: 230px;
		height: 501px;
		border: 1px solid palegoldenrod;
		float: left;
		padding-left: 20px;
	}
	.invest-tab ul li a{
		text-decoration:none;
	}
	.invest-tab .on a{
		color:#A08492;
	}
	
	.invest-tab ul li a:hover{
		text-decoration:none;
	}
	.invest-tab ul li:hover{
		width:70px;
	}
	
</style>


<script>
	window.onload = function(){
		// 时间 yyyy-mm-dd
		function getNowFormatDate() {
		    var date = new Date();
		    var seperator1 = "-";
		    var year = date.getFullYear();
		    var month = date.getMonth() + 1;
		    var strDate = date.getDate();
		    if (month >= 1 && month <= 9) {
		        month = "0" + month;
		    }
		    if (strDate >= 0 && strDate <= 9) {
		        strDate = "0" + strDate;
		    }
		    var currentdate = year + seperator1 + month + seperator1 + strDate;
		    var dates = document.getElementById("dates");        
		            
		    dates.innerHTML =  currentdate;
		}
		// 调用时间
		getNowFormatDate();
		
		/* 切换表单 */
		$(".invest-tab ul li").click(function(){
			var c = $(this).index();
			$(this).css({"background":"#0CAFFE"}).siblings("li").css({"background":"#F2F2F2"});
			$(this).children("a").css({"color":"#D8FFFF"});
			$(this).siblings("li").children("a").css({"color":"#A08492"});
			$("div .investnote-list").eq(c).css({"display":"block"}).siblings("div .investnote-list").css({"display":"none"});
		});
	}
</script>
</head>
<body>
<%@ include file="/jsp/frontpage/include/head.jsp"%>
<!--个人中心-->
<div class="wrapper wbgcolor">
  <div class="w1200 personal">
    <%@ include file="/jsp/frontpage/include/personalLeft.jsp"%>
    <div class="personal-main">
      <style type="text/css">
		.ui-fileupload-choose{
			background:none;
			width: 90px; height: 90px;
			border:0px none;
		}
		.ui-fileupload-choose input{
			width:100%;height:100%;
		}
		.ui-icon{
			background:none;
			width:0px;height:0px;
		} 
	</style>
	  <!-------单击头像触发的js,以及时间验证------- -->
      <script type="text/javascript">
	       $(function(){
	    	   $("#clickHeadImage").click(function(){
	    		   $(this).find('span').removeClass('ui-state-hover');
	    		  //file绑定click，onchange事件，单击事件打开file，选择后触发onchange，再调用单击事件触发sumit
	    		   document.getElementById("userImg").click();
	    		    document.getElementById("userImg").onchange=function(evt){
	    		    	// document.getElementById("submit").click();
	    		    	 var image = '';  
	    		    	 var files = evt.target.files;
	    		    	 var file=files[0];
	    		        //function selImage(file){  
	    		           
	    		            var reader = new FileReader();  
	    		            reader.onload = function(evt){  
	    		                document.getElementById('img').src = evt.target.result;  
	    		                image = evt.target.result; 
	    		                
	    		                  var value = $('#userImg').val();
	    		                  value = value.split("\\")[2];
	    		                
	    		                image = JSON.stringify(image);
	    		               // alert(image);
	    		                
	    		                $.ajax({  
		    		                type:'POST',  
		    		                url: 'user/uploadImg',  
		    		                data: {base64: image,fileName:value},  
		    		                async: true,  
		    		                dataType: 'text',  
		    		                success: function(data){  
		    		                    if(data==success){  
		    		                        alert('上传成功');  
		    		                    }else{  
		    		                        alert('上传失败');  
		    		                    }  
		    		                }, error: function(err){  
		    		                	//alert(err);
		    		                    alert('网络故障');  
		    		                }  
		    		            });   
	    		                
	    		            };  
	    		            reader.readAsDataURL(file);  
	    		      //  }  
	    		   } 
	    	   });
	    	   
	    	   $("#clickHeadImage").hover(function(){
	    		   $(this).removeClass('ui-state-hover');
	    	   });
	    	   
	    	   var safeLevel = "低";
	    	   if(safeLevel=="高"){
	    		   $(".pmain-user .user-info li .safe-level .onlevel").css("background-color","#f1483c");
	    	   }
	    	   
	    	   
	    	   
	    	   var myDate = new Date();
	    	   var h = myDate.getHours();
	    	   if(h>11 && h<19){
	    	   	 $("#outLogin").html("下午好，");
	    	   }else if(h>18){
	    	   	 $("#outLogin").html("晚上好，");
	    	   }else{
	    	   	 $("#outLogin").html("上午好，");
	    	   }
	    	   
	       });
	       
		</script>
	
      <div class="pmain-profile">
        <div class="pmain-welcome">
        	<span class="fl">
        	<span id="outLogin">上午好，</span>${user.username}</span> 
	        <span class="fr">上次登录时间：
	        	<fmt:formatDate value="${user.lastTime}" pattern="yyyy-MM-dd hh:mm:ss"/>
	        </span>
        </div>
        <div class="pmain-user">
          <div class="user-head">
          <div id="clickHeadImage" class="head-img" title="点击更换头像">
            <form  id="form" name="form" method="post" action="user/" enctype="multipart/from-data" >
              	<img id="img" src="${user.userimg }" alt="" style="width:88px;height:88px;z-index:0;"/> 
           		<!-- 让头像框为圆形，注释为方形         class="ui-fileupload" 隐藏文件框-->
           		<i class="headframe" style="z-index:0;"></i>
           		<input type="file" class="ui-fileupload" id="userImg" name="userimg" style="z-index:0;display:none;"/>
            </form>
            </div> 
            <span class="head-icon"> 
            	<a href="#"><i title="第三方资金账户未认证" class="headiconbg headicon01"></i></a> 
	            <a href="#"><i title="修改手机号" class="headiconbg headicon2"></i></a> 
	            <a href="#"><i title="修改邮箱" class="headiconbg headicon03"></i></a> 
            </span> 
          </div>
          
          <div class="user-info user-info1">
            <ul>
              <li>用户名<span>${user.username}</span></li>
              <li>VIP等级 <a href="#">${userVip.vipdj }</a></li>
              <li>积分：<span id="jifen">${userCredit.integral }</span></li>
              <li>
              		<c:if test="${userInfo.openAccount eq ''}">您还未开通第三方支付账户，请 
              		<a class="pmain-log" href="user/thirdParty">立即开通</a>以确保您的正常使用和资金安全。</c:if>
               </li>
            </ul>
          </div>
        </div>
        <div class="pmain-money">
          <ul>
            <li class="none"><span><em>账户总额</em><i id="zhze" class="markicon"></i><span class="arrow-show1" style="display:none;">可用余额+待收本息</span><span class="icon-show1" style="display:none;"></span></span> <span class="truemoney"><i class="f26 fb"><fmt:formatNumber type="number" value="${userMoney.usableMoney}" pattern="0.00" maxFractionDigits="2"/> </i> 元</span> </li>
            <li><span><em>待收本息</em><i id="dsbx" class="markicon"></i><span class="arrow-show2" style="display:none;">未到账的投资项目的本金、利息总额</span><span class="icon-show2" style="display:none;"></span></span> <span class="truemoney"><i class="f26 fb"><fmt:formatNumber type="number" value="${userMoney.collectionMoney}" pattern="0.00" maxFractionDigits="2"/> </i>元</span> </li>
            <li><span><em>累计收益</em><i id="ljsy" class="markicon"></i><span class="arrow-show3" style="display: none;">已到账的投资收益+未到账的投资收益</span><span class="icon-show3" style="display: none;"></span></span> <span class="truemoney"><i class="f26 fb c-pink"><fmt:formatNumber type="number" value="${userMoney.zqMoney}" pattern="0.00" maxFractionDigits="2"/> </i> 元</span> </li>
          </ul>
        </div>
      </div>
      
    <!-- 日历本月已收未收 -->
<script>
 $(function(){
	 $.ajax({  
         type:'POST',  
         url: 'user/selMoneys',  
         async: false,  	//async 异步，false 同步
         dataType: 'json',  
         success: function(data){  
        	 document.getElementById("haveIncome").innerHTML = data.haveIncome;
        	 document.getElementById("noIncome").innerHTML =data.noIncome;
        	 if(data.haveIncome==0){
        		 $("#haveIncomeSwitch").css("display","block");
        	 }
        	
         }, error: function(err){  
             alert('网络故障');  
         }  
     });  
 });
</script>
      <div class="pmain-connent">
       
        <div id="pmain-contab" class="pmain-contab">
          <ul>
          	<li id="pmain-contab0"  class="on">时间 </li>
            <li id="pmain-contab1"  >回款计划</li>
            <li id="pmain-contab2" >资金记录</li>
            <li id="pmain-contab3"  >投资记录</li>
            <!-- 灰色横线 -->
           <!-- <li class="li-other"></li>-->
          </ul>
        </div>
        <div class="pmain-conmain" id="pmain-conmain">
        	<!-- 日历  -->
        	<div class="pmain-conmain0">
        		<div class="pmain-conmain0-left" style="">
        			<br /><br />
        			<span id="dates"></span>
        			
        			<br /><br />
        			<span class="left1" style="opacity: 0.5;">本月已收金额(元) : </span><span id="haveIncome">0.00</span>
        			<br /><br />
        			<span class="left2" style="opacity: 0.5;">本月未收金额(元) : </span><span id="noIncome">0.00</span>
        			<br /><br /><br />
        			<a href="user/recordMoney" style="color: deepskyblue;"> 查看月度账单>> </a>
        			<br /><br /><br />
        			<img src="jsp/frontpage/images/empty.png" style="padding-left: 40px;"/>
        			<br />
        			<div id="haveIncomeSwitch" style="display:none;">
        				<span class="left3" style="opacity: 0.5;padding-left: 20px;">当前没有项目回款</span><br/>
        				<a href="index/addInvest" style="padding-left:45px;color:deepskyblue">快去投资</a>
        				<span style="opacity: 0.5;">吧...</span> 
        			</div>
        		</div>
						<div id='container' style="width: 600px;float: right;" ></div>
        	</div>
        	<!-- 日历结束-->
        	
        	
        	<!-- 表一开始-->
        	    
         <div id="p1" class="pmain-conmain1" style=" display:none;">
            <div class="pmain-contitle">
             <span class="pmain-titledate">计划回款时间</span><span class="pmain-titleproject">项目</span><span class="pmain-titletype">类型</span><span class="pmain-titlemoney">回款金额</span> 
            </div>
            <ul style="float:left;">
              <li><span class="pmain-titledate">2015-10-20</span><span class="pmain-titleproject">宝马汽车借贷业务</span><span class="pmain-titletype">债权转让</span><span class="pmain-titlemoney">10.00</span></li>
              <li><span class="pmain-titledate">2015-10-20</span><span class="pmain-titleproject">宝马汽车借贷业务</span><span class="pmain-titletype">债权转让</span><span class="pmain-titlemoney">10.00</span></li>
              <li><span class="pmain-titledate">2015-10-20</span><span class="pmain-titleproject">宝马汽车借贷业务</span><span class="pmain-titletype">债权转让</span><span class="pmain-titlemoney">10.00</span></li>
              <li><span class="pmain-titledate">2015-10-20</span><span class="pmain-titleproject">宝马汽车借贷业务</span><span class="pmain-titletype">债权转让</span><span class="pmain-titlemoney">10.00</span></li>
              <li><span class="pmain-titledate">2015-10-20</span><span class="pmain-titleproject">宝马汽车借贷业务</span><span class="pmain-titletype">债权转让</span><span class="pmain-titlemoney">10.00</span></li>
              <li><span class="pmain-titledate">2015-10-20</span><span class="pmain-titleproject">宝马汽车借贷业务</span><span class="pmain-titletype">债权转让</span><span class="pmain-titlemoney">10.00</span></li>
              <!--<div style=" width:
				760px;height:200px;padding-top:100px; text-align:center;color:#d4d4d4; font-size:16px;">
				 <img src="images/nondata.png" width="60" height="60"><br><br>
				   暂无回款计划</div>-->
            </ul>
            <div class="pmain-morebtn" style="border-top:0;margin-top:0"></div>
          </div>
          
          <!------------------------------------- 表一结束 --------------------------------->
          
          <script type="text/javascript">
          
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
    		
    		
	          document.getElementById("pmain-contab2").onclick = function() { 
	          } 
      	}
          </script>
          
          <!-- 表二开始-->
          <div id="p2" class="pmain-conmain2" style="display:none;">
           <span id="form:dataTable" >
          <div class="personal-moneylist" >
          
            <div class="pmain-contitle" > 
	            <span class="pmain-title1 fb">交易时间</span> 
	            <span class="pmain-title2 fb">
	            <span style="width:25px">&nbsp &nbsp</span>交易类型</span> 
	            <span class="pmain-title3 fb">交易金额</span> 
	            <span class="pmain-title4 fb">余额</span> 
	            <span class="pmain-title5 fb">备注</span> 
            </div>
            <ul style="float:left;">
           	 <c:forEach items="${pageBean.lists}" var="p">
             	 <li>
		              <span class="pmain-title1 pmain-height">
		              	<fmt:formatDate value="${p.dateiltime}" pattern="yyyy-MM-dd hh:mm:ss"/>
		              </span>
		             &nbsp
		              <span class="pmain-title2 pmain-height">
		              	<c:if test="${p.struts==0}">
		            		<span style="width:40px">&nbsp&nbsp&nbsp</span>充  值
		            	</c:if>
			            <c:if test="${p.struts==1}">
			            	<span style="width:40px">&nbsp&nbsp&nbsp</span>提  现
			            </c:if>
			            <c:if test="${p.struts==2 }">
			            	<span style="width:40px">&nbsp&nbsp&nbsp</span>手 续 费
			            </c:if>
			             <c:if test="${p.struts==3 }">
			            	<span style="width:40px">&nbsp&nbsp&nbsp</span>利 息 返 还
			            </c:if>
			             <c:if test="${p.struts==4 }">
			            	<span style="width:40px">&nbsp&nbsp&nbsp</span>理  财
			            </c:if>
			             <c:if test="${p.struts==5 }">
			            	<span style="width:40px">&nbsp&nbsp&nbsp</span>返 还 本 金
			            </c:if>
		            </span>
		            <span class="pmain-title3 pmain-height">${p.money }</span>
		            <span class="pmain-title4 pmain-height">${p.bychar }</span>
		            <span class="pmain-title5 pmain-height">备注</span>
           		 </li>	
       		  </c:forEach>
       		
       		 <li> 
       			<span class="pmain-title2 pmain-height" style="width: 940px">
       			</span>
       			   <div style="width:200px;margin:0 auto 0 auto;">
      				 <a href="user/recordMoney">查看更多...</a>
   				   </div>
       			
       			
       		 </li>
       		</ul>	 
            </div>
          </span>
            <div class="pmain-morebtn" style="border-top:0;margin-top:0"></div>
          </div>
         	<!--表二结束 -->
         	
         	
         	<!--表三开始 -->
          <div class="pmain-conmain3" style=" display:none;">
                <span id="form:dataTable">
          <div class="invest-tab">
            <ul>
              <li class="on"><span><a href="javascript:0" title="投标中">投标中 </a> </span> </li>
              <li><a id="status4" href="javascript:0" title="回款中">回款中 </a> </li>
              <li><a id="status5" href="javascript:0" title="已结束">已结束 </a> </li>
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
            </ul>
          </div>
          
          <!--回款中的表  -->
          <div class="investnote-list" style="display: none;">
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
	           	
            </ul>
          </div>
          
          <!--已结束的表  -->
          <div class="investnote-list" style="display: none;">
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
            </ul>
          </div>
          </span>
            <div class="pmain-morebtn" style="border-top:0;margin-top:0"></div>
          </div>
          <!-- 表四结束 -->
          
        </div>
      </div>
    </div>
    <div class="clear"></div>
  </div>
</div>
<!--网站底部-->
<%@ include file="/jsp/frontpage/include/foot.jsp"%>

<script type="text/javascript">
	var myCalendar = new SimpleCalendar('#container');
</script>
</body>
</html>
