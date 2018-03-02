<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
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
<title>个人中心-添加我的银行卡</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" type="text/css" href="jsp/frontpage/css/user.css" />
<link rel="stylesheet" type="text/css" href="jsp/frontpage/css/common.css" ></link>
<link rel="stylesheet" type="text/css" href="jsp/frontpage/css/fileupload.less.css"></link>

<link href="jsp/frontpage/css/admin.css" rel="stylesheet" type="text/css"  />
<link href="jsp/frontpage/css/amazeui.css" rel="stylesheet" type="text/css" />
<link href="jsp/frontpage/css/personal.css" rel="stylesheet" type="text/css" />
<link href="jsp/frontpage/css/stepstyle.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="jsp/frontpage/script/amazeui.js"></script>

<script type="text/javascript" src="jsp/frontpage/script/jquery.min.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/common.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/user.js" ></script>

<!-- 改变 tomcat 小图标 -->
<link  rel="Shortcut  Icon"  href="jsp/frontpage/statics/home/images/minilogo.png">
<!--绝对路径  ${pageContext.request.contextPath} -->
<style type="text/css">
	
</style>

<script type="text/javascript">
	$(function(){
		
	/* 	$("#bankButton").click(function(){
			var reserved1 = $("#reserved1").val();
			var reserved2 = $("#reserved2").val();
			var bankcardno = $("#bankcardno").val();
			
			//$("#bankFrom").submit();
			if(reserved1!="" && reserved2!="" && bankcardno!="" && 
					$('#red1').html()=="" && $('#red2').html()=="" && $('#bankNo').html()==""){ 
				$("#bankFrom").submit();
			}else{
				alert("请填写完资料");
			}
			
		}); */
		
		/* 校验用户姓名格式 */
		$("#reserved1").blur(function(){
			 var  reserved1 = $("#reserved1").val().trim();
			 var pattern = /^[a-zA-Z\u4e00-\u9fa5]+$/;
			 if(!pattern.test(reserved1) && reserved1!=""){
				 $('#red1').html("姓名只能是中文或英文").css('color','#ff7800');
			 }else if(reserved1==""){
				 $('#red1').html("姓名不能为空").css('color','#ff7800');
			 }else{
				 $('#red1').html("")
			 }
		});
		
		/* 校验身份证格式 */
		$('#reserved2').blur(function(){
			var reserved2 = $('#reserved2').val().trim();
			if(reserved2.length!=0){
				$.ajax({
					url:'bankCard/checkUserIDCard',
					type:'post',
					data:{'reserved2':reserved2},
					dataType:'json',
					success:function(result){
						if(result){
							$('#red2').html('身份证格式有误').css('color','#ff7800');
						}else{
							$('#red2').html("")
						}
					}
				});
			}
		});
		
		/* 校验银行卡格式  和 该银行卡是否已经绑定过了 */
		$('#bankcardno').blur(function(){
			var bankcardno = $('#bankcardno').val().trim();
			if(bankcardno.length!=0){
				// 校验银行卡格式是否正确
				$.ajax({
					url:'bankCard/checkUserBankCard',
					type:'post',
					data:{'bankcardno':bankcardno},
					dataType:'json',
					success:function(result){
						if(result){
							$('#bankNo').html('银行卡有误').css('color','#ff7800');
						}else{
							$('#bankNo').html("");
							// 检查银行卡是否被绑定过
							$.ajax({
								url:'bankCard/checkBankCard',
								type:'post',
								data:{'bankcardno':bankcardno},
								dataType:'json',
								success:function(result){
									if(result){
										$('#bankNo').html('银行卡有已经绑定过了').css('color','#ff7800');
									}else{
										$('#bankNo').html("")
									}
								}
							});
							
						}
					}
				});
			}
		});
		
		/* 检查手机格式是否正确    format格式的意思 */
		/* $("#user-phone").blur(function(){
			var phone = $("#user-phone").val().trim();
			var phoneFormat = /^1[3-8][0-9]{9}$/g;
			if(phone.length != 0 && !phoneFormat.test(phone)){
				$('#phoneTel').html('手机号码格式错误').css('color','#ff7800');
			}else{
				// 判断是否有该号码存在
				$.ajax({
					url:'',
					type:'post',
					data:{'phone':phone},
					dataType:'json',
					success:function(result){
						if(result){
							$('#phoneTel').html('写提示语').css('color','#ff7800');
						}
					}
				});
			}
		});
		$("#user-phone").focus(function(){
			$('#phoneTel').html('');
		}) */
		
		/* 检验 银行卡 是否 已经绑定过 */
		/* $('#bankcardno').blur(function(){
			var bankcardno = $('#bankcardno').val().trim();
			if(bankcardno.length!=0){
				$.ajax({
					url:'bankCard/checkBankCard',
					type:'post',
					data:{'bankcardno':bankcardno},
					dataType:'json',
					success:function(result){
						if(result){
							$('#bankNo').html('银行卡有已经绑定过了').css('color','#ff7800');
						}else{
							$('#bankNo').html("")
						}
					}
				});
			}
		});  */
		
		
	})
</script>

</head>
<body>
	<%@ include file="/jsp/frontpage/include/head.jsp"%>
<!-- 主体部分开始 -->
<div class="wrapper wbgcolor">
  <div class="w1200 personal">
	<%@ include file="/jsp/frontpage/include/personalLeft.jsp"%>
	
		<div class="main-wrap" style="margin-top: 10px">
			<div class="am-cf am-padding">
				<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">银行卡绑定</strong> / <small>Bind&nbsp;Card</small></div>
			</div>
			<hr/>
			<!--进度条-->
			<div class="m-progress">
				<div class="m-progress-list">
					<span class="step-1 step">
                              <em class="u-progress-stage-bg"></em>
                              <i class="u-stage-icon-inner">1<em class="bg"></em></i>
                              <p class="stage-name">实名认证</p>
                          </span>
					<span class="step-2 step">
                              <em class="u-progress-stage-bg"></em>
                              <i class="u-stage-icon-inner">2<em class="bg"></em></i>
                              <p class="stage-name">完成</p>
                          </span>
					<span class="u-progress-placeholder"></span>
				</div>
				<div class="u-progress-bar total-steps-2">
					<div class="u-progress-bar-inner"></div>
				</div>
			</div>
			<form class="am-form am-form-horizontal" id="bankFrom" action="bankCard/addBankCard?userid=${user.id}" method="post">
				<div class="am-form-group">
					<label for="user-name" class="am-form-label">真实姓名</label>
					<div class="am-form-content">
						<input type="text"  name="reserved1" id="reserved1" placeholder="请输入您的真实姓名" autofocus>
						<span id="red1"></span>
					</div>
				</div>
				<div class="am-form-group">
					<label for="user-IDcard" class="am-form-label">身份证号</label>
					<div class="am-form-content">
						<input type="text"  name="reserved2" id="reserved2" placeholder="请输入您的身份证信息">
						<span id="red2"></span>
					</div>
				</div>
				<div class="am-form-group">
					<label for="user-BankID" class="am-form-label" >银行卡号</label>
					<div class="am-form-content">
						<input type="text"  name="bankcardno" id="bankcardno" placeholder="请输入要绑定的银行卡卡号">
						<span id="bankNo"></span>
					</div>
				</div>
				<div class="am-form-group">
					<label for="user-phone" class="am-form-label" name="phone" id="phone">手机号码</label>
					<div class="am-form-content">
						<input type="tel" id="user-phone" name="user-phone" value="" maxlength="11" placeholder="请输入此卡的预留手机号">
						<span id="phoneTel"></span>
					</div>
				</div>	
				<div class="am-form-group code">
					<label for="user-new-code" class="am-form-label">验证码</label>
					<div class="am-form-content">
						<input type="tel" id="user-new-code" value="" placeholder="短信验证码">
						<input type="hidden" id="phoneHidden" name="" value="" />
					</div>
					<a class="btn"   id="sendMobileCode">
						<input type="button" style="width:80px;height:28px;border-radius:3px;background-color:#DD514C;border-color:#DD514C;color:#fff;" value="验证码" id="bdPhone" onclick="btnPhone(this);" />
					</a>
					
				</div>		
				<span id="phoneSpan"></span>				
				<div class="info-btn">
					<input type="button" id="bankButton" class="am-btn am-btn-danger" value="开通协议并确定">
				</div>
			</form>

		</div>
	</div>
</div>
	
<!-- 主体部分结束 -->		

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
	btn.value = nums+'秒';
	clock = setInterval(doLoop, 1000); //一秒执行一次
 }
 function doLoop(){
	 nums--;
	 if(nums > 0){
	  	//btn.html(nums+'秒后可重新获取');
		btn.value = nums+'秒';
	 }else{
	  	clearInterval(clock); //清除js定时器
	  	btn.disabled = false;
	   	btn.setAttribute("class","btn-code");  
	  	btn.value = "验证码";
	  	nums = 60; //重置时间
		$("#phoneHidden").val(""); 
	 }
 }

// 点击获取验证码  btnPhone(thisBtn)
function btnPhone(thisBtn){
	var reserved1 = $("#reserved1").val();
	var reserved2 = $("#reserved2").val();
	var bankcardno = $("#bankcardno").val();
	
	var userPhone = $("#user-phone").val();
	var nullFlag = (userPhone=="");
    if(!nullFlag){
    	$.ajax({  
           type:'POST',  
           url: 'bankCard/checkUserBankCode',  
           data: {'phone': userPhone},  
           async: true,  
           dataType: 'json',  
           success: function(data){
               if(data){  
            	   	sendCode(thisBtn); //点击发送验证倒计时
                	alert('发送成功，请在60s内填写');
                	document.getElementById("phoneHidden").value=data.success;
                	 document.getElementById('bankButton').onclick = function(){
                		 var ph = $("#phoneHidden").val();
                		 var pt = $("#user-new-code").val().trim();
                		 if(pt.length!=0){
                			 if(ph==pt){
                				 if(reserved1!="" && reserved2!="" && bankcardno!="" && 
                 						$('#red1').html()=="" && $('#red2').html()=="" && $('#bankNo').html()==""){
                					 //document.getElementById("bankFrom").submit();
                					 $("#bankFrom").submit();
                				 }else{
                					 alert("请填写完资料");
                				 }
                    			
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
$("#user-new-code").focus(function(){
	$("#phoneSpan").html("");
})

/* 
$("#forgetForm").click(function(){
	 var pt = $("#phoneText").val().trim();
	 if(pt=="" && pt.length==0){
		 alert("请获取验证码,并正确填写验证码。");
	 }
}) */

</script>

</html>