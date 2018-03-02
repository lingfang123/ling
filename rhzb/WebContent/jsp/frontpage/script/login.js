$(document).ready(function(){
		$('#submitBtn').click(function(){
			var username = $('#username').val().trim();
			var password = $('#password').val().trim();
			var jpgVerify = $('#jpgVerify').val().trim();
			if(username.length==0){
				$('#usernameAlt').html('请输入用户名').css('color','red');
			}
			if(password.length==0){
				$('#passwordAlt').html('请输入密码').css('color','red');
			}
			if(jpgVerify.length==0){
				$('#jpgVerifyAlt').html('请输入图形验证码').css('color','red');
			}
			
			$('#username').focus(function(){
				$('#usernameAlt').html('');
				$('#submitAut').html('');
			});
			$('#password').focus(function(){
				$('#passwordAlt').html('');
				$('#submitAut').html('');
			});
			$('#jpgVerify').focus(function(){
				$('#jpgVerifyAlt').html('');
				$('#submitAut').html('');
			});
			
			if($('#usernameAlt').html()==''&& $('#passwordAlt').html()=='' && $('#jpgVerifyAlt').html()==''){
				$('#loginForm').submit();
			}
		});
		
		$('#username').focus(function(){
			$('#submitAut').html('');
		});
		$('#password').focus(function(){
			$('#submitAut').html('');
		});
		$('#jpgVerify').focus(function(){
			$('#submitAut').html('');
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
	});