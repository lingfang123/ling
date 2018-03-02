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
<title>忘记密码3</title>
<link href="jsp/frontpage/css/common.css" rel="stylesheet" />
<link href="jsp/frontpage/css/register.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="jsp/frontpage/script/jquery.min.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/common.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/gVerify.js"></script>

<script type="text/javascript">
$(function(){
	$("#submitBtn").click(function() {
		var password = $("#password").val().trim();
		var password2 = $("#password2").val().trim();
		if(password.length==0 && password ==""){
			$("#passwordAlt").html("请输入新密码").css("color","red");
		}
		if(password2.length==0 && password2 ==""){
			$("#password2Alt").html("请确认密码").css("color","red");
		}
		
		if(password.length!=0 && (password.length<6 || password.length>18)){
			$("#passwordAlt").html("密码应为6-18位数").css("color","red");
		}
		
		if(password != password2){
			$("#password2Alt").html("密码确认错误").css("color","red");
		}
		
		if($('#passwordAlt').html()=='' && $('#password2Alt').html()==''){
			$('#forgetForm').submit();
		}
	});
	
		$("#password").focus(function(){
			$("#passwordAlt").html("");
		});
		
		$("#password2").focus(function(){
			$("#password2Alt").html("");
		});

})
</script>
</head>
<body>
	<%@ include file="/jsp/frontpage/include/head.jsp"%>
	<div class="wrap">
		<form id="forgetForm" name="forgetForm" action="forget/forgetPassword4" method="post">
			<div class="tdbModule register">
				<div class="registerTitle">用户找回密码3</div>
				<div class="registerCont">
			      <ul>
					<li class="error">
					    <span id="prrintInfo" data-info=""><span style="font-size: 1.5em">为了您的账号安全,请注意填写</span></span>
				    </li>
					<li>
					   <input type="hidden" name="phone" value="${phone}"/>
					   <span class="dis">新密码：</span>
					   <input class="input" type="password" name="password" id="password" maxlength="24" tabindex="1" placeholder="新密码">  
					   <span id="passwordAlt"></span>
					</li>
					<li>
					   <span class="dis">确认密码：</span>
					   <input class="input" type="password" name="password2" id="password2" maxlength="24" tabindex="1" placeholder="确认密码">  
					   <span id="password2Alt"></span>
					</li>
					<li class="btn">
						<input type="button" class="radius1" value="确认" id="submitBtn">
					</li>
				</ul>
			   </div>
			</div>
		 </form>	
	</div>
	<%@ include file="/jsp/frontpage/include/foot.jsp"%>
</body>
</html>