<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=path %>/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我要借款</title>
<!-- <link href="jsp/frontpage/css/common.css" rel="stylesheet" />
<link href="jsp/frontpage/css/register.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="jsp/frontpage/script/common.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/gVerify.js"></script> -->
<!-- <script type="text/javascript" src="jsp/frontpage/script/jquery.min.js"></script> -->
<link href="jsp/frontpage/css/common.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="jsp/frontpage/css/user.css" />
<link rel="stylesheet" type="text/css" href="jsp/frontpage/css/jquery.datetimepicker.css"/>
<script type="text/javascript" src="jsp/frontpage/script/jquery.min.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/common.js"></script>
<script src="jsp/frontpage/script/user.js" type="text/javascript"></script>
<style type="text/css">
/* 网站主体css开始 */
.count{
	width: 1200px;
	height: 700px;
	margin: 20px auto;
	position: relative;
	background-color: white;
}
.count .myLoan{
	width: 200px;
	font-size: 30px;
	line-height: 40px;
	font-family: "微软雅黑";
	opacity: 0.7;	
	margin-left: 20px;
}

hr{
	opacity:0.5;;
}
.count .main{
	width: 1120px;
	height: 600px;
	margin: 20px auto;
}

.count .main .main-count{
	width: 33.3%;
	height: 600px;
	float: left;
	position: relative;
	
}
.count .main .main-count:hover{
	background-color: #FFFBE2;
	border-radius: 5px;
}

.count .main .main-count h2{
	font-size: 30px;
	margin: 20px 0;
	text-align: center;
}

.count .main .main-count h4{
	font-size: 20px;
	margin: 20px 0;
	text-align: center;
}
.count .main .main-count .imgs{
	margin: 50px 0 40px 0;
	
}
.count .main .main-count .imgs img{
	display: block;
	margin:0 auto;
}
.count .main .main-count .txt{
    color: #666;
    line-height: 26px;
    height: 160px;
    font-size: 16px;
}

.count .main .main-count .count-button{
	font-size: 20px;
	line-height: 40px;
	height: 40px;
	margin: 50px 80px 20px 80px;
	text-align: center;
	border-radius: 20px;
	background: #2ea7e0;
	border: 1px solid #2ea7e0;
	color: #fff;
	display: block;
}
.count .main .main-count .count-button:hover{
	background-color: #FFFBE2;
	color: #000000;
}

.container-imgs{
	width: 1200px;
	height: 300px;
	background-color: white;
	margin:0 auto;
}
.container-imgs img{
	display: block;
	margin:0 auto;
}
/* 网站主体css结束 */
</style>

<script>
function showSpan(op){
	var mid =document.getElementById('markid');
	$.ajax({
			url:'${pageContext.request.contextPath}/mark/marklsit',	//请求地址
			type:'post',	//请求方式
			dataType:"json",
			success:function(result){
			mid.options.length=0;
			var applies1 =  result.markList;
			for(var i=0;i<applies1.length;i++){
				//后面是id的值
				mid.options.add(new Option(applies1[i].markname,applies1[i].id));
			}
		}
	});
	$("body").append("<div id='mask'></div>");
	$("#mask").addClass("mask").css("display","block");
	$("#"+op).css("display","block"); 
	
}

function displaySpan(op){
	//clearInputValue(); 
	$("#mask").css("display","none");
	$("#"+op).css("display","none");
}

function displaySpan2(){
	$("#mask").css("display","none");
	$("#alert-updateEmail").css("display","none");
	$("body").append("<div id='mask'></div>");
	$("#mask").addClass("mask").css("display","block");
	$("#alert-checkMobile").css("display","block");
}
function applyfor(){
	var money = document.getElementById('applyformoney');
	$.ajax({
		cache: true,
		type: "POST",
		url: '${pageContext.request.contextPath}/userapplyfor',  
		data: $('#birthdayForm').serialize(),// 你的formid
		async: false,
		success: function(data) {
			if(data=='success'){  
            	window.location.href="openapply";  
                alert('管理员将在两小时内联系您');  
            }else{  
                alert('修改失败');  
            }  
		},error: function(request) {
			 alert('网络故障');  
		}
	});
}
</script>
</head>
<body>
	<!-- 网站头部  -->
	<%@ include file="/jsp/frontpage/include/head.jsp"%>
	<!--主体部分开始-->
		<div class="count">
			<div class="myLoan">我要借款</div>
			<div class="main">
				<hr />
				<div class="main-count">
					<h2>抵押标</h2>
					<h4>小微企业现场审核抵押发布借款</h4>
					<div class="imgs">
						<img src="jsp/frontpage/images/tenders1.png" />
					</div>
					<div class="txt">
						抵押（质押）借款标 抵押借款标显示标记“押”，是有资金需求的借款人， 
						在办理好资产抵押、质押等手续后发布的借款标。平台对抵押物进行有效监管，
						抵押标逾期后， 将由合作企业进行回购并处理后续事宜。
					</div>
					<a href="javascript:(0);"  onclick="showSpan('apply-jk');" class="count-button">去申请</a>
				</div>
				<div class="main-count">
					<h2>抵押标</h2>
					<h4>小微企业现场审核抵押发布借款</h4>
					<div class="imgs">
						<img src="jsp/frontpage/images/tenders2.png" />
					</div>
					<div class="txt">
						担保借款标显示 “担”，是有资金需求的借款人， 
						在保证人或担保单位签订好保证合同或者担保合同后发布的借款标，
						平台对担保人的担保条件进行有效评估和监管，担保标逾期后， 将由担保人进行回购并处理后续事宜。
					</div>
					<a href="javascript:(0);" class="count-button">去申请</a>
				</div>
				<div class="main-count">
					<h2>抵押标</h2>
					<h4>小微企业现场审核抵押发布借款</h4>
					<div class="imgs">
						<img src="jsp/frontpage/images/tenders3.png" />
					</div>
					<div class="txt">
						质押借款用\"质\"标记，是招商贷经过线下严格审查借款人资产负债，
						并对其进行严格审核及评估，办理好资产抵押、质押等手续， 双方商定借款利率后，
						再由借款人在招商贷平台发布借款信息。
					</div>
					<a href="javascript:(0);" class="count-button">去申请</a>
				</div>
			</div>
		</div>
		<div class="container-imgs">
			<img src="jsp/frontpage/images/tenders.jpg" />
		</div>
		
		
	<div class="alert-450" id="apply-jk" style="display: none;">
  	  <div class="alert-title">
        <h3>快速申请</h3>
        <span class="alert-close" onclick="displaySpan('apply-jk')"></span></div>
         <div class="alert-main">
				 <form id="birthdayForm"  method="post" action="user/saveUser">
		 		<ul>
		         	<li>
		            	<label class="txt-name">真实姓名：</label>
		            	<input id="bday" name="uname" type="text" class="text235">
				 	</li>
				 	<li><br>
		            	<label class="txt-name">借款标题：</label>
		            	<select class="txt-name" id="markid" name="markid"></select>
				 	</li>
				 	<li><br>
		            	<label class="txt-name">借款金额：</label>
		            	<input id="bday" name="applyformoney" id="applyformoney" type="text" class="text235">
				 	</li>
				 	<li><br>
		            	<label class="txt-name">手机号码：</label>
		            	<input id="bday" name="bystr" type="text" class="text235">
				 	</li>
				 	<li><br>
		            	<label class="txt-name">贷款用途：</label>
		            	<textarea rows="3" cols="20" name="purpose"></textarea>
				 	</li>
				 	<li>
		             	<input  type="button" value="提交申请" name="updatePassForm:j_idt174" class="btn-ok btn-235 txt-right" onclick="applyfor();">
					</li>
		        </ul>
		       </form>
		      </div>
		</div>
		<!-- 主体部分结束-->
	<!--网站底部  -->
	<%@ include file="/jsp/frontpage/include/foot.jsp"%>
</body>
</html>