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
<title>忘记密码1</title>
<link href="jsp/frontpage/css/common.css" rel="stylesheet" />
<link href="jsp/frontpage/css/register.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="jsp/frontpage/script/jquery.min.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/common.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/gVerify.js"></script>

<script type="text/javascript">
$(function(){
	$("#submitBtn").click(function() {
		var phone = $('#phone').val().trim();
		var passcode = $("#jpgVerify").val().trim();
		if(phone.length == 0){
			$('#phoneAlt').html('手机号或邮箱不能为空').css('color','red');
		}
		
		if(passcode.length==0){
			$('#jpgVerifyAlt').html('验证码不能为空').css('color','red');
		}
		
		if($('#phoneAlt').html()=='' && $('#jpgVerifyAlt').html()==''){
			$('#forgetForm').submit();
		}
		
	});
	
	/* 失去焦点验证手机号  */
	$('#phone').blur(function(){
		var phone = $('#phone').val().trim();
		/*  if (typeof(mycode) == "undefined"){ return;} */
		
		if(phone==""){
			$('#phoneAlt').html('请填写手机号/邮箱').css('color','red');
		}
		
		// 手机格式
		var reg = /^1[3-8][0-9]{9}$/g;
		// 邮箱格式
		var email = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
		
		if(reg.test(phone)){
			//alert("我是正确的手机号");
			$.ajax({
				url:'register/checkPhone',
				type:'post',
				data:{'phone':phone},
				dataType:'json',
				success:function(result){
					if(!result){
						$('#phoneAlt').html('该手机号码不存在').css('color','red');
					}
				}
			});
		}else{
			/* $('#phoneAlt').html('手机号码格式错误').css('color','red'); */
			if(email.test(phone)){
				//alert("我是正确的邮箱");
				$.ajax({
					url:'forget/checkUserEmailStatus',
					type:'post',
					data:{'email':phone},
					dataType:'json',
					success:function(result){
						if(!result){
							//alert(result);
							$('#phoneAlt').html('未绑定该邮箱').css('color','red');
						}
					}
				});
			}else{
				$('#phoneAlt').html('格式有误').css('color','red')
			}
		}
		
		
		
		
		
		
		/* if(phone.trim().length!=0&&!reg.test(phone)){
			$('#phoneAlt').html('手机号码格式错误').css('color','red');
		}else{
			$.ajax({
				url:'register/checkPhone',
				type:'post',
				data:{'phone':phone},
				dataType:'json',
				success:function(result){
					if(!result){
						$('#phoneAlt').html('该手机号码不存在').css('color','red');
					}
				}
			});
		} */
		
		
		
		
	});
	
	$('#phone').focus(function(){
		$('#phoneAlt').html('');
	});
	
	$('#jpgVerify').focus(function(){
		$('#jpgVerifyAlt').html('');
	});

	/**
	 * 失去焦点验证验证码
	 * */
	var verifyCode = new GVerify("v_container");
	$('#jpgVerify').blur(function(){
		var passcode = $("#jpgVerify").val().trim();
		var res = verifyCode.validate(passcode);
		if(passcode.length!=0&&!res){
			$('#jpgVerifyAlt').html('验证码错误').css('color','red');
		}
	});
	
})
</script>
</head>
<body>
	<%@ include file="/jsp/frontpage/include/head.jsp"%>
	<div class="wrap">
		<form id="forgetForm" name="forgetForm" action="forget/forgetPassword2" method="post">
			<div class="tdbModule register">
				<div class="registerTitle">找回密码 步骤1</div>
				<div class="registerCont">
			      <ul>
					<li class="error">
					    <span id="prrintInfo" data-info=""><span style="font-size: 1.5em">为了您的账号安全,请注意填写</span></span>
				    </li>
					<li>
						<span class="dis">绑定的手机号或邮箱：</span>
						<input class="input" type="text" name="phone" id="phone" maxlength="24" tabindex="1" placeholder="手机号/邮箱" onfocus>
					    <span id="phoneAlt"></span>
					</li>
		                
					<!-- <li>
					   <span class="dis">新密码：</span>
					   <input class="input" type="password" name="password" id="password" maxlength="24" tabindex="1" placeholder="账户密码">  
					   <span id="passwordAlt"></span>
					</li> -->
					
					 <li style="position: relative;">
					  	<span class="dis">验证码：</span>
					  	<input type="text" id="jpgVerify" style="width:130px;" class="input" name="yzm" data-msg="验证码" maxlength="4" tabindex="1" placeholder="右方验证码">
					  	<div id="v_container" style="position:absolute; display:inline-block;width:115px;height: 44px;"></div>
					  	<span id="jpgVerifyAlt" style="padding-left: 125px"></span>
					</li>
					<li class="btn">
						<input type="button" class="radius1" value="下一步" id="submitBtn">
					</li>
				</ul>
			   </div>
			</div>
		 </form>	
	</div>
	<%@ include file="/jsp/frontpage/include/foot.jsp"%>
</body>
</html>