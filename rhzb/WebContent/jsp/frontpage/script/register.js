$(document).ready(function(){
		/**
		 * 验证手机号
		 * */
		$('#phone').bind('input propertychange',function(){
			var phone = $('#phone').val();
			var reg = /^1[3-8][0-9]{9}$/g;
			if(phone.trim().length!=0&&!reg.test(phone)){
				$('#phoneJy').html('手机号码格式错误').css('color','#ff7800');
			}else{
				$.ajax({
					url:'register/checkPhone',
					type:'post',
					data:{'phone':phone},
					dataType:'json',
					success:function(result){
						if(result){
							$('#phoneJy').html('该手机号码已注册').css('color','#ff7800');
						}else{
							$('#phoneJy').html('手机号码正确').css('color','#333');
						}
					}
				});
			}
		});
		
		/**
		 * 失去焦点验证用户名是否存在
		 * */
		$('#userName').blur(function(){
			var userName = $('#userName').val().trim();
			if(userName.length!=0){
				$.ajax({
					url:'register/checkUsername',
					type:'post',
					data:{'userName':userName},
					dataType:'json',
					success:function(result){
						if(result){
							$('#userNameAlt').html('该用户名已存在').css('color','#ff7800');
						}
					}
				});
			}
		});
		
		/**
		 * 失去焦点验证密码是否符合要求
		 * */
		$('#password').blur(function(){
			var password = $('#password').val().trim();
			if((password.length>0 && password.length<6) || password.length>24){
				$('#passwordAlt').css('color','#ff7800');
			}
		});
		
		/**
		 * 失去焦点验证密码是否一样
		 * */
		$('#repeatPassword').blur(function(){
			var password = $('#password').val().trim();
			var repeatPassword = $('#repeatPassword').val().trim();
			if(password.length>0 && password!=repeatPassword){
				$('#repeatPasswordAlt').html('密码确认错误').css('color','#ff7800');
			}
		});
		
		/**
		 * 单击获取手机号码按钮
		 * */
		var clock = '';
		var time = 60;
		var phoneYZM = null;
		$('#sendPhone').click(function(){
			var phone = $('#phone').val().trim();
			if(phone.length==0){
				$('#phoneJy').html('请输入您的常用电话').css('color','#ff7800');
			}
			if($('#phoneJy').css('color')!='rgb(255, 120, 0)'){
				$('#sendPhone').attr('disabled','disabled');//添加disabled属性
				$('#sendPhone').val(time+'秒后可重新获取');
				//发送手机验证码
				$.ajax({
					url:'register/sendCode',
					type:'post',
					data:{'phone':phone},
					dataType:'json',
					success:function(result){
						phoneYZM = result;
					}
				});
				clock = setInterval(doLoop, 1000); //一秒执行一次
			}
		});
		//时间倒计时
		function doLoop(){
			 time--;
			 if(time > 0){
			  	$('#sendPhone').val(time+'秒后可重新获取');
			 }else{
			  	clearInterval(clock); //清除js定时器
			  	$('#sendPhone').removeAttr('disabled'); //移除disabled属性
			   	//btn.setAttribute("class","btn-code");  
			  	$('#sendPhone').val('获取验证码');
			  	time = 60; //重置时间
				phoneYZM = null;
				$('#phonVerify').val('');
				$('#phonVerifys').html('验证码已超时').css('color','#ff7800');
			 }
	 	}
		/**
		 * 失去焦点验证手机验证码是否正确
		 * */
		$('#phonVerify').blur(function(){
			var phonVerify = $('#phonVerify').val().trim();
			if(phonVerify.length!=0){
				if(phonVerify!=phoneYZM){
					$('#phonVerifys').html('验证码错误').css('color','#ff7800');
				}
			}
		});
		
		/**
		 * 得到焦点修改<span></span>标签文本和颜色
		 * */
		$('#userName').focus(function(){
			$('#userNameAlt').html('6-24个字符，字母开头，字母、数字下划线组成').css('color','rgb(51, 51, 51)');
		});
		$('#password').focus(function(){
			$('#passwordAlt').css('color','rgb(51, 51, 51)');
		});
		$('#repeatPassword').focus(function(){
			$('#repeatPasswordAlt').html('请再次输入密码').css('color','rgb(51, 51, 51)');
		});
		$('#jpgVerify').focus(function(){
			$('#jpgVerifys').html('请输入图片验证码').css('color','rgb(51, 51, 51)');
		});
		$('#phone').focus(function(){
			$('#phoneJy').html('请输入您的常用电话').css('color','rgb(51, 51, 51)');
		});
		$('#phonVerify').focus(function(){
			$('#phonVerifys').html('请输入手机验证码').css('color','rgb(51, 51, 51)');
		});
		
		/**
		 * 失去焦点验证验证码
		 * */
		var verifyCode = new GVerify("v_container");
		$('#jpgVerify').blur(function(){
			var passcode = $("#jpgVerify").val().trim();
			var res = verifyCode.validate(passcode);
			if(passcode.length!=0&&!res){
				$('#jpgVerifys').html('验证码错误').css('color','#ff7800');
			}
		});
		
		/**
		 * 单击提交按钮验证表单数据
		 * */
		$('#submit1').click(function(){
			var username = $('#userName').val().trim();
			var password = $('#password').val().trim();
			var repeatPassword = $('#repeatPassword').val().trim();
			var jpgVerify = $('#jpgVerify').val().trim();
			var phone = $('#phone').val().trim();
			var phonVerify = $('#phonVerify').val().trim();
			if(username.length==0){
				$('#userNameAlt').css('color','#ff7800');
			}
			if(password.length<6 || password.length>24){
				$('#passwordAlt').css('color','#ff7800');
			}
			if(repeatPassword.length==0){
				$('#repeatPasswordAlt').css('color','#ff7800');
			}
			if(jpgVerify.length==0){
				$('#jpgVerifys').css('color','#ff7800');
			}
			if(phone.length==0){
				$('#phoneJy').css('color','#ff7800');
			}
			if(phonVerify.length==0){
				$('#phonVerifys').css('color','#ff7800');
			}
			
			/**
			 * 提交表单
			 * */
			var color = "rgb(255, 120, 0)";
			if($('#userNameAlt').css('color')!=color && $('#passwordAlt').css('color')!=color && $('#repeatPasswordAlt').css('color')!=color && $('#jpgVerifys').css('color')!=color && $('#phoneJy').css('color')!=color && $('#phonVerifys').css('color')!=color){
				$('#myForm').submit();
			}
		});
});