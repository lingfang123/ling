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
<title>忘记密码2</title>
<link href="jsp/frontpage/css/common.css" rel="stylesheet" />
<link href="jsp/frontpage/css/register.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="jsp/frontpage/script/jquery.min.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/common.js"></script>

<script type="text/javascript">
</script>
</head>
<body>
	<%@ include file="/jsp/frontpage/include/head.jsp"%>
	<div class="wrap">
		<form id="forgetForm" name="forgetForm" action="forget/forgetPassword3" method="post">
			<div class="tdbModule register">
				<div class="registerTitle">用户找回密码2</div>
				<div class="registerCont">
			      <ul>
					<li class="error">
					    <span id="prrintInfo" data-info=""><span style="font-size: 1.5em">请正确填写手机验证码</span></span>
				    </li>
					<li id="Ph" style="display: none">
						<span class="dis">手机号：</span>
						<input type="hidden" name="phone" id="phone" value="${phone}">
						<span id="phones">${phone.subSequence(0,3)}****${phone.subSequence(7,11)}</span>
					    <span id="phoneAlt"></span>
					</li>
					<li id="Em" style="display: none">
						<span class="dis">邮箱：</span>
						<span id="email">${phone}</span>
					    <span id="emailAlt"></span>
					</li>
					<li style="position: relative;">
					  	<span class="dis">验证码：</span>
					  	<input type="text" id="phoneText" style="width:130px;" class="input" name="yzm" data-msg="验证码" maxlength=6" tabindex="1" placeholder="" />
					  	<input type="hidden" id="phoneHidden" name="" value="" />
					  	<div id="" style="display:inline-block;width:115px;height: 44px;margin-left: 15px;">
					  		<input type="button" style="width:115px;height:37px;border-radius:3px;display: none;" class="btn-code" value="点击获取验证码" id="bdPhone" onclick="btnPhone(this);" />
					  		<input type="button" style="width:115px;height:37px;border-radius:3px;display: none;" class="btn-code" value="点击获取验证码" id="bdEmail" onclick="btnEmail(this);" />
					  	</div>
					  	<span id="phoneSpan" style="width:115px;height: 44px;margin-left: 25px;"></span>
					</li>
					<li class="btn">
						<input type="button" class="radius1" value="下一步" id="submitBtn" />
					</li>
				</ul>
			   </div>
			</div>
		 </form>	
	</div>
	<%@ include file="/jsp/frontpage/include/foot.jsp"%>
</body>
<script type="text/javascript">
 var clock = '';
 var nums = 60;
 var btn;

//主要用于被调用    验证码倒计时
 function sendCode(thisBtn){ 
	 btn = thisBtn;
	 btn.disabled = true; //将按钮置为不可点击
	//document.getElementById("p2").style.class="btn-codeAfter";
	btn.setAttribute("class","btn-codeAfter");  
	 btn.value = nums+'秒后可重新获取';
	 clock = setInterval(doLoop, 1000); //一秒执行一次
 }
 function doLoop(){
	 nums--;
	 if(nums > 0){
	  	btn.value = nums+'秒后可重新获取';
	 }else{
	  	clearInterval(clock); //清除js定时器
	  	btn.disabled = false;
	   	btn.setAttribute("class","btn-code");  
	  	btn.value = '点击发送验证码'; 
	  	nums = 60; //重置时间
		$("#phoneSpan").val("");
		$("#phoneHidden").val("");
	 }
 }

//手机格式
var reg = /^1[3-8][0-9]{9}$/g;
// 邮箱格式
var email = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;

// 判断是什么格式的
if(reg.test($("#phone").val())){
	// 手机格式就显示出来   手机号码和手机验证码按钮
	$("#Ph").show();
	$("#bdPhone").show();
}else{
	// 不是手机格式就显示出来   邮箱号 和 邮箱验证码按钮
	$("#Em").show();
	$("#bdEmail").show();
}


// 手机验证码
function btnPhone(thisBtn){
	var phone = $("#phone").val();
	var nullFlag = (phone=="");
    if(!nullFlag){
    	$.ajax({  
           type:'POST',  
           url: 'forget/checkPhoneCode',  
           data: {'phone': phone},  
           async: true,  
           dataType: 'json',  
           success: function(data){
               if(data){  
            	    sendCode(thisBtn); //点击发送验证倒计时	
                	alert('发送成功，请在60s内填写');
                	document.getElementById("phoneHidden").value=data.success;
                	 document.getElementById('submitBtn').onclick = function(){
                		 var ph = $("#phoneHidden").val();
                		 var pt = $("#phoneText").val().trim();
                		 if(pt.length!=0){
                			 if(ph==pt){
                    			 document.getElementById("forgetForm").submit();
                    		 }else{
                    			 $("#phoneSpan").html("验证码有误或已过期").css({"color":"red"});
                    		 }
                		 }else{
                			 alert("请正确填写验证码。");
                		 }
		              }
	             }else{  
                   alert('发送失败');  
               }
           },error: function(err){  
           	//alert(err);
               alert('网络故障');  
           }  
       }); 
    }else{
    	alert(2333);
    }
}

// 邮箱验证码
function btnEmail(thisBtn){
	var phone = $("#phone").val();
	var nullFlag = (phone=="");
    if(!nullFlag){
    	sendCode(thisBtn); //点击发送验证倒计时
    	alert('发送成功，请在60s内填写');
    	$.ajax({  
           type:'POST',  
           url: 'forget/checkEmailCode',  
           data: {'toAddress': phone},  
           async: true,  
           dataType: 'json',  
           success: function(data){
               if(data){  
            	   
                	document.getElementById("phoneHidden").value=data.success;
                	 document.getElementById('submitBtn').onclick = function(){
                		 var ph = $("#phoneHidden").val();
                		 var pt = $("#phoneText").val().trim();
                		 if(pt.length!=0){
                			 if(ph==pt){
                    			 document.getElementById("forgetForm").submit();
                    		 }else{
                    			 $("#phoneSpan").html("验证码有误或已过期").css({"color":"red"});
                    		 }
                		 }else{
                			 alert("请正确填写验证码。");
                		 }
		              }
	             }else{  
                   alert('发送失败');  
               }
           },error: function(err){  
           	//alert(err);
               alert('网络故障');  
           }  
       }); 
    }else{
    	alert(2333);
    }
}

// 得到焦点
$("#phoneText").focus(function(){
	$("#phoneSpan").html("");
})







</script>

</html>