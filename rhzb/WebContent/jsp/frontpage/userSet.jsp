<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=path%>/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>金源宝——账户设置</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="apple-mobile-web-app-status-bar-style" content="black"> 
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="format-detection" content="telephone=no">
<link href="jsp/frontpage/css/common.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="jsp/frontpage/css/user.css" />
<link rel="stylesheet" type="text/css" href="jsp/frontpage/css/jquery.datetimepicker.css"/>
<script type="text/javascript" src="jsp/frontpage/script/jquery.min.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/common.js"></script>
<script src="jsp/frontpage/script/user.js" type="text/javascript"></script>
<script src="jsp/frontpage/laydate/laydate.js" type="text/javascript"></script> 

  <link rel="stylesheet" type="text/css" href="jsp/frontpage/css/gz.css"/>
<script type="text/javascript" src="jsp/frontpage/script/gz.js"></script>
</head>
<body>
<%@ include file="/jsp/frontpage/include/head.jsp"%>
<!--个人中心-->
<div class="wrapper wbgcolor">
  <div class="w1200 personal">
  <%@ include file="/jsp/frontpage/include/personalLeft.jsp"%>
  	<!-- 输入框的css样式 -->
   	 <style type="text/css">.txt235{height:38px;border:1px solid #ccc;}</style>
	
	 <!-- 日历的css样式 -->
	  <style>
	  body{padding: 20px;}
	  .demo-input{padding-left: 10px; height: 38px; min-width: 262px; line-height: 38px; border: 1px solid #e6e6e6;  background-color: #fff;  border-radius: 2px;}
	  .demo-footer{padding: 50px 0; color: #999; font-size: 14px;}
	  .demo-footer a{padding: 0 5px; color: #01AAED;}
	  </style>
    
    <!------------------------------------ 验证码倒计时，手机邮箱通用,主要用于被调用---------------------------------------------------------- -->
		<script type="text/javascript">
			 var clock = '';
			 var nums = 60;
			 var btn;
			
			//主要用于被调用
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
					$("#newEmailyzm").val(""); 
					$("#xgEmailyzm").val(""); 
				 }
		 	}
	</script>
	<!-- ---------------------------------------------------------------- -->
    
    <script type="text/javascript">
		function showSpan(op){
			$("#updateMonbileForm\\:updateMonbileFormauthCode").val(""); 
			if(op=='alert-updateEmail'){
				var bool = $("#authenticationMobile").val();
				if(bool=='true'){
					$("#alert-main").css("display","none");
					$("#alert-main2").css("display","block");
				}
			}
			$("body").append("<div id='mask'></div>");
			$("#mask").addClass("mask").css("display","block");
			$("#"+op).css("display","block"); 
		}

		function displaySpan(op){
			clearInputValue(); 
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
		var flag = false;
		//验证码发送消息提示
		
		//清空验证码（输入框）
		function clearValue(element){
			$(element).val("");
		}
		
		/* */
		function clearInputValue(){
			$("#checkMonbileForm\\:mobileNumber").val(""); 
			$("#checkMonbileForm\\:authCode").val(""); 
			$("#checkMonbileForm\\:mobileNumber_message").remove();
			$("#checkMonbileForm\\:authCode_message").remove();
			
			//修改手机号-验证原手机号
			$("#checkOldMobileForm\\:checkOldMobileFormauthCode_message").remove();
			$("#checkOldMobileForm\\:checkOldMobileFormauthCode").val("");
			
			$("#updateMonbileForm\\:mobileNumber2").val(""); 
			$("#updateMonbileForm\\:updateMonbileFormauthCode").val(""); 
			$("#updateMonbileForm\\:mobileNumber2_message").remove();
			$("#updateMonbileForm\\:updateMonbileFormauthCode_message").remove();
			
			$("#changeEmailForm\\:newEmail").val(""); 
			$("#changeEmailForm\\:changeEmailFormauthCode").val(""); 
			$("#changeEmailForm\\:newEmail_message").remove();
			$("#changeEmailForm\\:changeEmailFormauthCode_message").remove();
			
			//修改密码提示消息
			$("#updatePassForm\\:oldPassword").val(""); 
			$("#updatePassForm\\:password").val(""); 
			$("#updatePassForm\\:repassword").val(""); 
			
			$("#updatePassForm\\:oldPassword_message").remove();
			$("#updatePassForm\\:password_message").remove();
			$("#repassword_message").remove();
			
			
			//修改交易密码提示消息
			$("#updatePassForm\\:oldPassword1").val(""); 
			$("#updatePassForm\\:password1").val(""); 
			$("#updatePassForm\\:repassword1").val(""); 
			
			$("#updatePassForm\\:oldPassword_message1").remove();
			$("#updatePassForm\\:password_message1").remove();
			$("#repassword_message1").remove();
			
			//更改保存联系人提示消息
			$("#exitgencyname").val(""); 
			$("#exitgencyphone").val(""); 
		}
		
		
		</script>
   <!-- ----------------------------------------------------------------------- --> 
     <div class="personal-main">  
     <div class="pmain-connent"> 
   		 <!-- 手动添加选项卡菜单 -->
		 <div id="pmain-contab" class="pmain-contab">
          <ul>
          	<li id="pmain-contab0" class="on">账户设置</li>
            <li id="pmain-contab1">基本资料</li>
            <!-- 灰色横线 -->
           <!-- <li class="li-other"></li>-->
          </ul>
        </div>
        <!-- class="pmain-conmain"  导致点击框右移 -->
      <div id="pmain-conmain">   
    	<div class="pmain-conmain0"> 
    		 <div class="personal-zhsz">
    		  <h3><i>信息认证</i></h3>
		        <ul>
		       <%--    <li>
			          <i class="grzxbg p-right"></i>
			          <span class="zhsz-span1">手机号</span><span class="zhsz-span2">${user.phoneYC}</span>
			          <span class="zhsz-span3"><a href="javascript:void(0)" onclick="showSpan('alert-checkOldMobile')">更改</a></span>
		          </li> --%>
		       <!--  <li><input type="hidden" value="false" id="authenticationMobile" /></li>  -->
		          <li>
		         	  <i class="grzxbg <c:if test="${userInfo.dealPassstatus eq 0}">p-danger</c:if><c:if test="${userInfo.dealPassstatus eq 1}">p-right</c:if>"></i>
		              <span class="zhsz-span1">交易密码</span><span class="zhsz-span2"></span>
		              <span class="zhsz-span3">
			            <c:if test="${userInfo.dealPassstatus eq 1}">
			            	 <a href="javascript:void(0)" onclick="showSpan('alert-updatedealPass')">更改</a>
			            </c:if>
	             	 <c:if test="${userInfo.dealPassstatus eq 0}">
	             	 	<a href="javascript:void(0)" onclick="showSpan('alert-savedealPass')"> 设置</a>
	             	 </c:if>
			          </span>
		          </li>
		          
		          <!-- openAccount -->
		         <li>
		        	 <i class="grzxbg 
		        		<c:if test="${userInfo.openAccount eq null || userInfo.openAccount eq ''}">p-danger</c:if><c:if test="${userInfo.openAccount ne null && userInfo.openAccount ne ''}">p-right</c:if>
		        	 "></i>
		        	 <span class="zhsz-span1">第三方支付</span>
		        	 <c:if test="${userInfo.openAccount eq null || userInfo.openAccount eq ''}">
		        	 	 <span class="zhsz-span2">未开通</span><span class="zhsz-span3"><a href="user/thirdParty">开通</a></span>
		        	 </c:if>
		        	 <c:if test="${userInfo.openAccount ne null && userInfo.openAccount ne ''}">
		        	 	  <span class="zhsz-span2"></span><span class="zhsz-span3"><a href="javascript:return false;">已开通</a></span>
		        	 </c:if>
		         </li>
		         
		         
		         <!-- 添加if判断，根据状态来获取css样式 -->
		          <li> 
			          <i class="grzxbg <c:if test="${userInfo.emailstatus eq 0}">p-danger</c:if><c:if test="${userInfo.emailstatus eq 1}">p-right</c:if>"></i> 
			           <span class="zhsz-span1">电子邮箱</span> <span class="zhsz-span2">${userInfo.emailYC }</span> 
			           <span class="zhsz-span3"> 
				           <a href="javascript:void(0)"  onclick="
				         	  <c:if test="${userInfo.emailstatus eq 1}">showSpan('alert-updateEmail');</c:if>
				         	  <c:if test="${userInfo.emailstatus eq 0}">showSpan('alert-bandingEmail');</c:if>
				           ">
				            	<c:if test="${userInfo.emailstatus eq 1}">更改</c:if>
				                <c:if test="${userInfo.emailstatus eq 0}">绑定</c:if>
				           </a>
			           </span> 
		         </li>
		           <li> 
			          <i class="grzxbg <c:if test="${userInfo.exitgencystatus eq 0}">p-danger</c:if><c:if test="${userInfo.exitgencystatus eq 1}">p-right</c:if>"></i> 
			           <span class="zhsz-span1">紧急联系人</span> <span class="zhsz-span2">${userInfo.exitgencyname}</span> 
			           <span class="zhsz-span3"> 
			           <a href="javascript:void(0)" onclick="showSpan('alert-contact')">
			           		<c:if test="${userInfo.exitgencystatus eq 1}">更改</c:if>
			             	<c:if test="${userInfo.exitgencystatus eq 0}">添加</c:if>
			           </a></span> 
		         </li>
		          <li><i class="grzxbg p-right"></i><span class="zhsz-span1">登录密码</span><span class="zhsz-span2"></span><span class="zhsz-span3"><a href="javascript:void(0)" onclick="showSpan('alert-updatePass')">更改</a></span></li>
		        </ul>
		  	</div>
		 </div>
  		
  		<div class="pmain-conmain1" style="display:none"> 
  		  <div class="personal-zhsz">
		     <h3><i>基本资料</i></h3>
		     <ul>
		       <li>
		           <i class="grzxbg p-right"></i>
			       <span class="zhsz-span1">昵称</span>
			       <span id="nickname" name="nickname" class="zhsz-span2" onclick="ShowElement(this)">${user.nickname}</span>
			       <span class="zhsz-span3"><a href="javascript:void(0)" onclick="nicknameOpen();">更改</a></span>
		      </li>
		       <li>
		       	 <i class="grzxbg p-right"></i>
		      	 <span class="zhsz-span1">性别</span>
		      	 <span id="sex" name="sex" class="zhsz-span2">
		       		<c:if test="${user.sex eq 0}">女</c:if>
		       		<c:if test="${user.sex eq 1}">男</c:if>
		       	</span>
		       	<span class="zhsz-span3"><a href="javascript:void(0)" onclick="showSpan('alert-sex')">更改</a></span>
		       </li>
		       <li>
			       <i class="grzxbg <c:if test="${user.age eq ''}">p-danger</c:if><c:if test="${user.age ne ''}">p-right</c:if>"></i>
			       <span class="zhsz-span1">年龄</span>
			       <span id="age" name="age" class="zhsz-span2" onclick="ShowElement(this)">${user.age }</span>
			      <span class="zhsz-span3"><a href="javascript:void(0)" onclick="ageOpen();">更改</a></span>
			   </li>
		       <li>
		        <i class="grzxbg <c:if test="${user.birthday eq null}">p-danger</c:if><c:if test="${user.birthday ne null}">p-right</c:if>"></i> 
		        <span class="zhsz-span1">生日</span> 
		        <span id="birthday" name="birthday" class="zhsz-span2">${user.birthday }</span> 
		     <span class="zhsz-span3"><a href="javascript:void(0)" onclick="showSpan('alert-birthday');">更改</a></span>
		       </li>
		       <li>
			       <i class="grzxbg p-right"></i>
			       <span class="zhsz-span1">地址</span>
			       <span id="address" name="address" class="zhsz-span2" >${user.address }</span>
		       	<span class="zhsz-span3"><a href="javascript:void(0)" onclick="showSpan('alert-address');">更改</a></span>
		       </li>
		     
		     </ul>
  	  		</div>
  	 	</div> 
  	 	
     </div>  
    </div> 
  </div>
  
  
<script type="text/javascript">
	
	function nicknameOpen(){
		 document.getElementById("nickname").click();
	}
	function sexOpen(){
		 document.getElementById("sex").click();
	}
	function ageOpen(){
		 document.getElementById("age").click();
	}
	function birthdayOpen(){
		 document.getElementById("birthday").click();
	}
	function addressOpen(){
		 document.getElementById("address").click();
	}
	/****************************************************/
	//生成文本框
	function ShowElement(element){
		var oldhtml = element.innerHTML;
		var newobj = document.createElement('input');
		//创建新的input元素
		newobj.type = 'text';
		newobj.id='inputAdd';
		//为新增元素添加类型
		newobj.onblur = function(){
			element.innerHTML = this.value ? this.value : oldhtml;
			//当触发时判断新增元素值是否为空，为空则不修改，并返回原有值 
		}
		element.innerHTML = '';
		element.appendChild(newobj);
		newobj.focus();
		
		//为input框添加class样式
		var obj = document.getElementById("inputAdd");
		$("#inputAdd").addClass('txt235');
		$("#inputAdd").css('line-height','100px'); 
	}
	//生日专用input框
	function ShowBirthday(element){
		var oldhtml = element.innerHTML;
		var newobj = document.createElement('input');
		//创建新的input元素
		newobj.type = 'text';
		newobj.id='day';
		//为新增元素添加类型
		newobj.onblur = function(){
			element.innerHTML = this.value ? this.value : oldhtml;
			//当触发时判断新增元素值是否为空，为空则不修改，并返回原有值 
		}
		element.innerHTML = '';
		element.appendChild(newobj);
		newobj.focus();
		
		var obj = document.getElementById("inputAdd");
		$("#inputAdd").addClass('txt235');
	}
	
	
	//基本资料修改都可调用的ajax
	function updateAjax(user){
		$.ajax({  
            type:'POST',  
            url: 'user/saveUser',  
            data: user,  
            async: false,  	//async 异步，false 同步
            dataType: 'text',  
            success: function(data){  
                if(data=='success'){  
                	//window.location.href="/rhzb/user/userSet";  
                	//$("#pmain-conmain1").html(data);//要刷新的div
                    alert('修改成功');  
                }else{  
                    alert('修改失败');  
                }  
            }, error: function(err){  
            	//alert(err);
                alert('网络故障');  
            }  
        });  
	}
	
		//修改昵称
	   document.getElementById("nickname").onchange=function(evt){
		   var zhi=$('#inputAdd').val();						//获取span的内容的值，作为data的值	
		   var name=$('#nickname').attr('name');		//获取span的name的值，作为data的键 	
			
		  /*  var map = zhi+":"+name;  */
		   var data = {};
		   key = name;
		   value = zhi;
		   data[key] = value; //相当于data['name'] = 'darry';
		
		  updateAjax(data);
		}
		
		//修改年龄
		 document.getElementById("age").onchange=function(evt){
		   var zhi=$('#inputAdd').val();						//获取span的内容的值，作为data的值	
		   var name=$('#age').attr('name');		//获取span的name的值，作为data的键 	
			
		  /*  var map = zhi+":"+name;  */
		   var data = {};
		   key = name;
		   value = zhi;
		   data[key] = value; //相当于data['name'] = 'darry';
		
		  updateAjax(data);
		}
		
		
</script>
	
	<!--------------------------------------------- 性别修改相关 ------------------------------------------------->
  	<div class="alert-450" id="alert-sex" style="display: none;">
  	 <div class="alert-title">
        <h3>性别修改</h3>
        <span class="alert-close" onclick="displaySpan('alert-sex')"></span></div>
         <div class="alert-main">
	  		 <form id="sexForm"  method="post" action="">
		  		<ul>
		           <li>
		           	<span>
		             <label class="txt-name">性别：</label>
				      <label style=" font-size: 20px;vertical-align: middle;">男</label><input style="vertical-align: middle;" type="radio" name="sex" value="1" <c:if test="${user.sex eq 1}">checked</c:if>/>
				      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				      <label style=" font-size: 20px;vertical-align: middle;">女</label><input style="vertical-align: middle;" type="radio" name="sex" value="0" <c:if test="${user.sex eq 0}">checked</c:if>/>
						</span>
					</li>
					<li>
		             <input  type="button" value="提交" name="updatePassForm:j_idt174" class="btn-ok btn-235 txt-right" onclick="updateSex();">
					</li>
		        </ul>
	        </form>
        </div>
	</div>
	
		
	<div class="alert-450" id="alert-birthday" style="display: none;">
  	 <div class="alert-title">
        <h3>修改</h3>
        <span class="alert-close" onclick="displaySpan('alert-birthday')"></span></div>
         <div class="alert-main">
				 <form id="birthdayForm"  method="post" action="user/saveUser">
		 		<ul>
		          <li>
		            <label class="txt-name">出生日期：</label>
		            <input id="bday" name="birthday" type="text" class="text235" placeholder="请选择日期" value="${user.birthday }">
				</li>
				<li>
		            <input  type="button" value="提交" name="updatePassForm:j_idt174" class="btn-ok btn-235 txt-right" onclick="updateBirthday();">
					</li>
		        </ul>
		       </form>
		       </div>
		</div> 
		
	<div class="alert-450" id="alert-address" style="display: none;">
  	 <div class="alert-title">
        <h3>修改</h3>
        <span class="alert-close" onclick="displaySpan('alert-address')"></span></div>
         <div class="alert-main">
				 <form id="addressForm"  method="post" action="">
		 		<ul>
		          <li>
		            <label class="txt-name">所在地址：</label>
			           <select id="provinceID" name="provinceID"> 
						<option value="${user.provinceID }">${user.pidName }</option>
						</select>
						<select id="cityID" name="cityID"> 
						<option value="${user.cityID }">${user.cidName }</option>
						</select>
						<select id="districtID" name="districtID"> 
						<option value="${user.districtID }">${user.didName }</option>
						</select>
				</li>
				<li>
					<input type="hidden" id="address" name="address">
		            <input  type="button" value="提 交" name="updatePassForm:j_idt174" class="btn-ok  txt-right" onclick="updateAddress();">
					
					</li>
		        </ul>
		       </form>
		      </div>
		</div>
	
	<script type="text/javascript">
		function updateSex(){
			$.ajax({
				cache: true,
				type: "POST",
				url: 'user/saveUser',  
				data: $('#sexForm').serialize(),// 你的formid
				async: false,
				success: function(data) {
					if(data=='success'){  
						window.location.href="/rhzb/user/userSet";
						//setTimeout("parent.location.href='/rhzb/user/userSet'",1000);
	                    displaySpan('alert-sex');
	                    alert('修改成功'); 
	                }else{  
	                    alert('修改失败');  
	                }  
				},error: function(request) {
					 alert('网络故障');  
				}
			});
		}
		
		function updateBirthday(){
			$.ajax({
				cache: true,
				type: "POST",
				url: 'user/saveUser',  
				data: $('#birthdayForm').serialize(),// 你的formid
				async: false,
				success: function(data) {
					if(data=='success'){  
						displaySpan('alert-birthday');
						//$("#pmain-conmain1").html(data);//要刷新的div
	                	window.location.href="/rhzb/user/userSet";  
	                    alert('修改成功');  
	                }else{  
	                    alert('修改失败');  
	                }  
				},error: function(request) {
					 alert('网络故障');  
				}
			});
		}
		
		function updateAddress(){
			
		 	var pid=$('#provinceID option:selected').text();
		 	var cid=$('#cityID option:selected').text();
		 	var did=$('#districtID option:selected').text();
			var pidnullFlag=(pid=='请选择');
			var cidnullFlag=(cid=='请选择');
			var didnullFlag=(did=='请选择');
			
			if(pidnullFlag||cidnullFlag||didnullFlag){
				alert("省市县不能为空");
			}else{   
				var address=pid+cid+did;
				document.getElementById("address").value=address;
				var a=$("#address").val();
				$.ajax({
					cache: true,
					type: "POST",
					url: 'user/saveUser',  
					data: $('#addressForm').serialize(),// 你的formid
					async: false,
					success: function(data) {
						if(data=='success'){ 
		                	window.location.href="/rhzb/user/userSet";  
							displaySpan('alert-address');
							//$("#pmain-conmain1").html(data);//要刷新的div
		                    alert('修改成功');  
		                }else{  
		                    alert('修改失败');  
		                }  
					},error: function(request) {
						 //alert('网络故障');  
					}
				}); 
			}
			
			
		}
	</script>
	
	<script>
	//执行一个laydate实例
		laydate.render({
	  	elem: '#bday' //指定元素
		});
	</script>
	<!-----------------地址-------------------------------- -->
	<script type="text/javascript">
		//获取省份
	$(function(){
		$.ajax( {
			type : "post",
			url : "pcon/queryProvice",
			data : {"233":"233"},
			cache : false,
			dataType : "json",
			success : function(data) {
				var str = "<option>请选择</option>";
				//$("#provinceID").html("");
				for ( var i = 0; i < data.length; i++) {
					str += "<option value='" + data[i].pid
							+ "'>" + data[i].provinceName
							+ "</option>";
				}
				$("#provinceID").append(str);
			},
			error : function() {
				//alert("请与管理员联系");
			}
		});
	});

$(document).ready(function(){
	//获取城市
	$("#provinceID").change(function(){
		$.ajax({
			type:"post",
			url:"pcon/queryCity",
			data:"pid="+$("#provinceID").val(),
			cache:false,
			dataType:"json",
			success:function(json){
				var attr="<option>请选择</option>";
				$("#cityID").html("");
				for(var i=0;i<json.length;i++){
					attr += "<option value='" + json[i].cid
					+ "'>" +json[i].cityName
					+ "</option>";

				}
				$("#cityID").append(attr);
				$("#districtID").html("");
				$("#districtID").append("<option>请选择</option>");
			},error:function(){
				//alert("请与管理员联系");
			}
		});
	});

	//获取地区
	$("#cityID").change(
			function() {
				var params = $("#cityID").val();
				$.ajax( {
					type : "post",
					url : "pcon/queryDistrict",
					data : "cid="+$("#cityID").val(),
					cache : false,
					dataType : "json",
					success : function(data) {
						var str = "<option>请选择</option>";
						$("#districtID").html("");
						for ( var i = 0; i < data.length; i++) {
							str += "<option value='" + data[i].did
									+ "'>" + data[i].districtName
									+ "</option>";
						}
						$("#districtID").append(str);
					},
					error : function() {
						//	alert("请与管理员联系");
					}
			});
		});
	
});


</script>
	
	
	
<!-- ----------------------------------------------密码和交易密码------------------------------------------------- -->
    <!-- 密码修改的验证                        -->
     <script type="text/javascript">
		/*     提交表单 */
    function checkupdatePassFormAll(){
 	   checkupdatePassFormOldPassword();
 	   checkPassword();
 	   checkRepassword();
 	   var oldPasswordFlag=$("#oldPasswordErrorDiv").text()=="";
 	   var passwordFlag=$("#passwordErrorDiv").text()=="";
 	   var repasswordFlag=$("#repasswordErrorDiv").text()=="";
 	   
 	  //如果三个框全部填写，进ajax
   	  	if(checkupdatePassFormOldPassword()&&checkPassword()&&checkRepassword()){
   	   	   var password=$("#updatePassForm\\:oldPassword").val();
   	 	   var newPwd=$("#updatePassForm\\:password").val();

	   	 	$.ajax({  
	            type:'POST',  
	            url: 'user/saveUser',  
	            data: {'password': password,'newPwd':newPwd},  
	            async: false,  
	            dataType: 'text',  
	            success: function(data){  
	                if(data=='success'){  
	                	window.location.href="/rhzb/user/userSet";  

	                	displaySpan('alert-updatePass');
	                	//$("#pmain-conmain0").html(data);//要刷新的div
	                    alert('修改成功');  
	                }else{  
	                    alert('修改失败，原密码错误');  
	                }  
	            }, error: function(err){  
	            	//alert(err);
	                alert('网络故障');  
	            }  
	        }); 
   	 	}else{
   	 	} 
   	 return oldPasswordFlag&&passwordFlag&&repasswordFlag;
    }
	/* 密码修改的验证	 */		
      //验证原密码
      function checkupdatePassFormOldPassword(){
   	   var oldPassword=$("#updatePassForm\\:oldPassword").val();
   	   var nullFlag=(oldPassword=="");
   	   if(nullFlag)
		{
			$("#updatePassForm\\:oldPassword_message").remove();
			var $span = $("<span id=updatePassForm\:oldPassword_message class=error>请输入密码</span>");
			$("#oldPasswordErrorDiv").append($span);
			return false;
		}
		else
		{
			var oldPasswordError=$("#oldPasswordErrorDiv").text();
			if(oldPasswordError=='请输入密码')
			{
				$("#updatePassForm\\:oldPassword_message").remove();
			}
		}
   	   return true;
      }
      //验证输入密码框
      function checkPassword(){
   	   var password=$("#updatePassForm\\:password").val();
   	   var nullFlag=(password=="");
   	   if(nullFlag){
			$("#updatePassForm\\:password_message").remove();
			var $span = $("<span id=updatePassForm\:password_message class=error>请输入新密码</span>");
			$("#passwordErrorDiv").append($span);
			return false;
		}else{
			var oldpassword=$("#updatePassForm\\:oldPassword").val();
			var errorMessage=$("#oldPasswordErrorDiv").text();
			
			var nullOldFlag=(oldpassword=="");
			var errorFlag=(errorMessage=="");
			 if(!nullOldFlag&&errorFlag&&(oldpassword==password)){
				$("#updatePassForm\\:password_message").remove();
				var $span = $("<span id=updatePassForm\:password_message class=error>输入密码不能与原密码相同</span>");
				$("#passwordErrorDiv").append($span);
				return false;
			}
			var nullerror=$("#passwordErrorDiv").text();
			if(nullerror=="请输入密码"){
				$("#updatePassForm\\:password_message").remove();
			} 
		}
   	   return true;
      }
      //验证重输密码框
      function checkRepassword(){
		var password=$("#updatePassForm\\:password").val();
		var repassword=$("#updatePassForm\\:repassword").val();
		var flag=(password==repassword);
		var nullFlag=(repassword=="");
		if(nullFlag){
			$("#repassword_message").remove();
			var $span = $("<span id=repassword_message class=error>请输入确认密码</span>");
			$("#repasswordErrorDiv").append($span);
			return false;
		}else{
			$("#repassword_message").remove();
		}if(flag==false){
			$("#repassword_message").remove();
			var $span = $("<span id=repassword_message class=error>两次密码不同</span>");
			$("#repasswordErrorDiv").append($span);
			return false;
		}
		else{
			$("#repassword_message").remove();
		}
		return true;
   }
	</script>
		
	 <!-- 交易密码修改的验证               -->
    <script type="text/javascript">
		/*     提交表单 */
    function checkupdatePassFormAll1(){
 	   checkupdatePassFormOldPassword1();
 	   checkPassword1();
 	   checkRepassword1();
 	   var oldPasswordFlag=$("#oldPasswordErrorDiv1").text()=="";
 	   var passwordFlag=$("#passwordErrorDiv1").text()=="";
 	   var repasswordFlag=$("#repasswordErrorDiv1").text()=="";
 	   
 	//如果三个框全部填写，进ajax
  	  	if(checkupdatePassFormOldPassword1()&&checkPassword1()&&checkRepassword1()){
  	   	   var password=$("#updatePassForm\\:oldPassword1").val();
  	 	   var newPwd=$("#updatePassForm\\:password1").val();

	   	 	$.ajax({  
	            type:'POST',  
	            url: 'userinfo/saveUserinfo',  
	            data: {'dealPassword': password,'newdealpwd':newPwd},  
	            async: false,  
	            dataType: 'text',  
	            success: function(data){  
	                if(data=='success'){ 
	                	window.location.href="/rhzb/user/userSet";  

	                	displaySpan('alert-updatedealPass');
	                	//$("#pmain-conmain0").html(data);//要刷新的div
	                    alert('修改成功');  
	                }else{  
	                    alert('修改失败，原密码错误');  
	                }  
	            }, error: function(err){  
	            	//alert(err);
	                alert('网络故障');  
	            }  
	        }); 
  	 	}else{
  	 	} 
 	   
 	   return oldPasswordFlag&&passwordFlag&&repasswordFlag;
    }
	/* 密码修改的验证	 */		
      //验证原密码
      function checkupdatePassFormOldPassword1(){
   	   var oldPassword=$("#updatePassForm\\:oldPassword1").val();
   	   var nullFlag=(oldPassword=="");
   	   if(nullFlag){
			$("#updatePassForm\\:oldPassword_message1").remove();
			var $span = $("<span id=updatePassForm\:oldPassword_message1 class=error>请输入密码</span>");
			$("#oldPasswordErrorDiv1").append($span);
			return false;
		}else{
			var oldPasswordError=$("#oldPasswordErrorDiv1").text();
			if(oldPasswordError=='请输入密码'){
				$("#updatePassForm\\:oldPassword_message1").remove();
			}
		}
   	   return true;
      }
      //验证输入密码框
      function checkPassword1(){
   	   var password=$("#updatePassForm\\:password1").val();
   	   var nullFlag=(password=="");
   	   if(nullFlag){
			$("#updatePassForm\\:password_message1").remove();
			var $span = $("<span id=updatePassForm\:password_message1 class=error>请输入新密码</span>");
			$("#passwordErrorDiv1").append($span);
			return false;
		}else{
			var oldpassword=$("#updatePassForm\\:oldPassword1").val();
			var errorMessage=$("#oldPasswordErrorDiv1").text();
			
			var nullOldFlag=(oldpassword=="");
			var errorFlag=(errorMessage=="");
			 if(!nullOldFlag&&errorFlag&&(oldpassword==password)){
				$("#updatePassForm\\:password_message1").remove();
				var $span = $("<span id=updatePassForm\:password_message1 class=error>输入密码不能与原密码相同</span>");
				$("#passwordErrorDiv1").append($span);
				return false;
			}
			var nullerror=$("#passwordErrorDiv1").text();
			if(nullerror=="请输入密码"){
				$("#updatePassForm\\:password_message1").remove();
			} 
		}
   	   return true;
      }
      //验证重输密码框
      function checkRepassword1(){
		var password=$("#updatePassForm\\:password1").val();
		var repassword=$("#updatePassForm\\:repassword1").val();
		var flag=(password==repassword);
		var nullFlag=(repassword=="");
		if(nullFlag){
			$("#repassword_message1").remove();
			var $span = $("<span id=repassword_message1 class=error>请输入确认密码</span>");
			$("#repasswordErrorDiv1").append($span);
			return false;
		}else{
			$("#repassword_message1").remove();
		}if(flag==false){
			$("#repassword_message1").remove();
			var $span = $("<span id=repassword_message1 class=error>两次密码不同</span>");
			$("#repasswordErrorDiv1").append($span);
			return false;
		}
		else{
			$("#repassword_message1").remove();
		}
		return true;
   }
	</script>	
	
	<!--  紧急联系人姓名和号码更改  -->
	<script type="text/javascript">
	/*     提交表单 */
	function checkupdatePassFormAll2(){
		egnameYz();
		egphoneYz();
	   
 	  	if(egnameYz()&&egphoneYz()){
 	   	   var password=$("#exitgencyname").val();
 	 	   var newPwd=$("#exitgencyphone").val();

	   	 	$.ajax({  
	            type:'POST',  
	            url: 'userinfo/saveUserinfo',  
	            data: {'exitgencyname': password,'exitgencyphone':newPwd},  
	            async: false,  
	            dataType: 'text',  
	            success: function(data){  
	                if(data=='success'){ 
	                	displaySpan('alert-contact');
	                	window.location.href="/rhzb/user/userSet";  

	                	//$("#pmain-conmain0").html(data);//要刷新的div
	                    alert('更改成功');  
	                }else{  
	                    alert('修改失败，原密码错误');  
	                }  
	            }, error: function(err){  
	            	//alert(err);
	                alert('网络故障');  
	            }  
	        }); 
 	 	}else{
 	 	} 
	   
	 // return egnameFlag&&egphoneFlag; 
	}
		
     function egnameYz(){
    	 var egname=$("#exitgencyname").val();
    	 if(egname==''){
    		 $("#egnameNullError").css("display","block");   
    		 return false;
    	 }else{
    		 $("#egnameNullError").css("display","none");
    		 return true;
    	 }
    	 
     }
     
     function egphoneYz(){
    	 var egphone=$("#exitgencyphone").val();
    	 var egphoneFlag=isMobilePhone(egphone);
    	 if(egphone==''){
    		 $("#egphoneNullError").css("display","block");   
    		 $("#egphoneError").css("display","none");
    		 return false;
    	 }else{
    		 $("#egphoneNullError").css("display","none");
    		 if(!egphoneFlag){
    			 $("#egphoneError").css("display","block"); 
    			 return false;
    		 }else{
    			 $("#egphoneError").css("display","none"); 
    			 return true;
    		 }
    	 }
     }
    
     //验证手机号码格式
     function isMobilePhone(source) {  
    	var regex = /^((\d3)|(\d{3}\-))?1\d{10}/;  
   	  return regex.test(source);  
} 
	</script>	   
	
	<div class="alert-450" id="alert-updatePass" style="display: none;">
      <div class="alert-title">
        <h3>修改密码</h3>
        <span class="alert-close" onclick="displaySpan('alert-updatePass')"></span></div>
      <div class="alert-main">
        <form id="updatePassForm" name="updatePassForm" method="post" action="user/saveUser" enctype="multipart/form-data"  target="rfFrame">
          <input type="hidden" name="updatePassForm" value="updatePassForm">
          <ul>
            <li>
              <label class="txt-name">请输入原密码</label>
              <input id="updatePassForm:oldPassword" type="password" name="password" value=""  maxlength="12"  onkeyup="value=value.replace(/[^\w\.\/]/ig,'')" class="txt235">
              <div id="oldPasswordErrorDiv" class="alert-error120"></div>
            </li>
             
            <li>
            <br>
              <label class="txt-name">请输入新密码</label>
              <input id="updatePassForm:password" type="password" name="newPwd" value="" maxlength="12"  onkeyup="value=value.replace(/[^\w\.\/]/ig,'')" class="txt235">
              <div id="passwordErrorDiv" class="alert-error120"></div>
            </li>
            
            <li>
             <br>
              <label class="txt-name">请确认新密码</label>
              <input id="updatePassForm:repassword" type="password" name="newPwd1" value="" maxlength="12"  onkeyup="value=value.replace(/[^\w\.\/]/ig,'')" class="txt235">
              <div id="repasswordErrorDiv" class="alert-error120"></div>
            </li>
            <li>
			<!-- <iframe id="rfFrame" name="rfFrame" src="about:blank" style="display:none;"/ > -->  
            <input id="pwdSubmit" type="button" name="updatePassForm:j_idt174" value="确 认" class="btn-ok btn-235 txt-right" onclick="return checkupdatePassFormAll()">
            </li>
          </ul>
        </form>
      </div>
	</div>
	
	<div class="alert-450" id="alert-updatedealPass" style="display: none;">
      <div class="alert-title">
        <h3>修改交易密码</h3>
        <span class="alert-close" onclick="displaySpan('alert-updatedealPass')"></span></div>
      <div class="alert-main">
        <form id="updatePassForm1" name="updatePassForm" method="post" action="userInfo/saveUserinfo" enctype="multipart/form-data"  target="rfFrame">
          <input type="hidden" name="updatePassForm" value="updatePassForm">
          <ul>
            <li>
              <label class="txt-name">请输入原交易密码</label>
              <input id="updatePassForm:oldPassword1" type="password" name="updatePassForm:oldPassword" value="" maxlength="6"  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" class="txt235" placeholder="请输入六位数的交易密码">
              <div id="oldPasswordErrorDiv1" class="alert-error120"></div>
            </li>
             
            <li>
            <br>
              <label class="txt-name">请输入新交易密码</label>
              <input id="updatePassForm:password1" type="password" name="updatePassForm:password" value="" maxlength="6" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" class="txt235" placeholder="请输入六位数的交易密码">
              <div id="passwordErrorDiv1" class="alert-error120"></div>
            </li>
             
            <li>
            <br>
              <label class="txt-name">请确认新交易密码</label>
              <input id="updatePassForm:repassword1" type="password" name="updatePassForm:repassword" value="" maxlength="6" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" class="txt235" placeholder="请输入六位数的交易密码">
              <div id="repasswordErrorDiv1" class="alert-error120"></div>
            </li>
            <li>
            <!-- <iframe id="rfFrame" name="rfFrame" src="about:blank" style="display:none;"/ > -->  
              <input type="button" id="dealpwdSubmit" name="updatePassForm:j_idt174" value="确 认" class="btn-ok btn-235 txt-right" onclick="return checkupdatePassFormAll1()">
            </li>
          </ul>
        </form>
      </div>
	</div>
	
	<div class="alert-450" id="alert-savedealPass" style="display: none;">
      <div class="alert-title">
        <h3>设置交易密码</h3>
        <span class="alert-close" onclick="displaySpan('alert-savedealPass')"></span></div>
      <div class="alert-main">
        <form id="setPassForm1" name="updatePassForm" method="post" action="userinfo/saveUserinfo" enctype="multipart/form-data"  target="rfFrame">
          <input type="hidden" name="updatePassForm" value="updatePassForm">
          <ul>
            <li>
             <!--  <input id="updatePassForm:oldPassword1" type="password" name="updatePassForm:oldPassword" value="" maxlength="20" onblur="jsf.util.chain(this,event,'return checkupdatePassFormOldPassword1()','mojarra.ab(this,event,\'blur\',0,0)')" class="txt235"> -->
            <div class="wrap">
			    <div class="inputBoxContainer" id="inputBoxContainer">
			        <input type="text" class="realInput"/>
			        <div class="bogusInput">
			            <input type="password" maxlength="6" disabled/>
			            <input type="password" maxlength="6" disabled/>
			            <input type="password" maxlength="6" disabled/>
			            <input type="password" maxlength="6" disabled/>
			            <input type="password" maxlength="6" disabled/>
			            <input type="password" maxlength="6" disabled/>
			        </div>
			    </div>
		   	  <p style="display:none;" class="showValue" id="showValue" ></p> 
		   	  <p  class="showValue" id="showValueflag" ></p> 
			</div>
             </li>
             <li>
              <input type="button" id="dealpwdSave" name="updatePassForm:j_idt174" value="确 认" class="btn-ok btn-235 txt-right" onclick="savedealPwd();">
			</li>          
          </ul>
        </form>
      </div>
	</div>
	
	
		
    <div class="alert-450" id="alert-contact" style="display: none;">
      <div class="alert-title">
       <h3>保存联系人</h3>
        <span class="alert-close" onclick="displaySpan('alert-contact')"></span></div>
     	 <div class="alert-main">
       	  <form id="updateEGForm" name="updatePassForm" method="post" action="userinfo/saveUserinfo" enctype="multipart/form-data"  target="rfFrame">
          <input type="hidden" name="updatePassForm" value="updatePassForm">
          <ul>
            <li>
              <label class="txt-name">请输入联系人姓名</label>
              <input id="exitgencyname" type="text" name="exitgencyname" value="" maxlength="20" onkeyup="value=value.replace(/[\d]/g,'') "onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[\d]/g,''))" maxlength=10 class="txt235">
              <div id="egnameErrorDiv" class="alert-error120">
              	 <span id="egnameNullError" class=error style="display:none;">联系人姓名不能为空</span>
              </div>
            </li>
             
            <li>
            <br>
              <label class="txt-name">请输入联系人号码</label>
              <input id="exitgencyphone" type="text" name="exitgencyphone" value="" maxlength="11" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" class="txt235">
              <div id="egphoneErrorDiv" class="alert-error120">
              	<span id="egphoneNullError" class=error style="display:none;">联系人号码不能为空</span>
              	<span id="egphoneError" class=error style="display:none;">手机号码格式不正确</span>
              </div>
            </li>
            <li>
              <input id="egSubmit" type="button" name="submit" value="确 认" class="btn-ok btn-235 txt-right" onclick="return checkupdatePassFormAll2()">
            </li>
          </ul>
        </form>
        </div>
      </div>
    </div>
    
    <!------------------- 设置交易密码 ----------------------------->
    <script type="text/javascript">
    	function savedealPwd(){
    		var zhi=boxInput.getBoxInputValue();
    		
    	   var nullFlag=(zhi=="");
    		/* if(zhi.length!=6 ||nullFlag){
    			$('#showValueflag').text('请输入六位数');
    		}else{ */
    			$.ajax({  
    	            type:'POST',  
    	            url: 'userinfo/saveUserinfo',  
    	            data: {'dealPassword': '123456'}, 
    	            async: false,  
    	            dataType: 'text',  
    	            success: function(data){  
    	                if(data=='success'){  
    	                	displaySpan('alert-savedealPass');
    	                	window.location.href="/rhzb/user/userSet";  
    	                	//$("#pmain-conmain0").html(data);//要刷新的div
    	                    alert('设置交易密码成功');  
    	                }else{  
    	                    alert('设置失败');  
    	                }  
    	            }, error: function(err){  
    	            	//alert(err);
    	                alert('网络故障');  
    	            }  
    	        });   
    		//}
    			
    	}
    
    </script>
    
  <!-- ------------------------------------邮箱------------------------------------------------------------ -->  
 
    <!-- 邮箱绑定 -->
    <script type="text/javascript">
    		//邮箱验证
		    function bdemailYz(){
		   	 var bdemail=$("#bdEmail").val();
		   	 var bdemailFlag=isEmail(bdemail);
		   	 if(bdemail==''){
		   		 $("#bdemailNullError").css("display","block"); 
		   		 $("#bdemailError").css("display","none");
		   		 return false;
		   	 }else{
		   		 $("#bdemailNullError").css("display","none");
		   		 if(!bdemailFlag){
		   			 $("#bdemailError").css("display","block");  
		   			return false;
		   		 }else{
		   			$("#bdemailError").css("display","none"); 
		   			return true;
		   		 }
		   	 }
		  }
    		
          //邮箱验证码验证
          function emailyzCodeYz(){
        	  var emailyzmCode=$("#emailyzCode").val();
        	  var yzCode=$("#newEmailyzm").val();
        	  var yzCodeFlag=(emailyzmCode==yzCode);
        	  if(emailyzmCode==''){
        		  $("#bdemailyzmNullError").css("display","block"); 
 		   		 $("#bdemailyzmError").css("display","none");
 		   		  return false;
        	  }else{
        		  $("#bdemailyzmNullError").css("display","none");   
        		  if(!yzCodeFlag){
        			  $("#bdemailyzmError").css("display","block");
        			  return false;
        		  }else{
        			  $("#bdemailyzmError").css("display","none");
        			  return true;
        		  }
        	  }
          } 
          
         //验证码发送提交
  		function bangdingEmail(thisBtn){
  			bdemailYz();	//验证邮箱是否为空	
  			var toAddress=$("#bdEmail").val();
  			
       	    if(bdemailYz()){
       	    	sendCode(thisBtn);				//点击发送验证倒计时
       	    	$.ajax({  
  		            type:'POST',  
  		            url: 'rzemail',  
  		            data: {'toAddress': toAddress},  
  		            async: true,  
  		            dataType: 'json',  
  		            success: function(data){
  		                if(data){  
  		                  alert('发送成功，请在60s内填写');  
   		                 document.getElementById("newEmailyzm").value=data.success; 
  		                
   		                 document.getElementById('jhemail').onclick = function(){
  		                	   bdEmailSubmit();
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
       	    	
       	    }
  		}
         
      //绑定邮箱提交   
      function bdEmailSubmit(){
    	  
    	  	bdemailYz();
    	  	emailyzCodeYz();
    	  	
  			var toAddress=$("#bdEmail").val();
  			if(bdemailYz()&&emailyzCodeYz()){
  				$.ajax({  
  		            type:'POST',  
  		            url: 'userinfo/saveUserinfo',  
  		            data: {'email': toAddress},  
  		            async: false,  
  		            dataType: 'text',  
  		            success: function(data){  
  		                if(data){  
  		                	window.location.href="/rhzb/user/userSet";  
    	                	displaySpan('alert-bandingEmail');
    	                	//$("#pmain-conmain0").html(data);//要刷新的div
  		                    alert('绑定并激活成功');  
  		                }else{  
  		                    alert('绑定失败');  
  		                }  
  		            },error: function(err){  
  		            	//alert(err);
  		                alert('网络故障');  
  		            }  
  		        }); 
  			}else{
  			}
  			
  		}   
     
      //验证邮箱格式
      function isEmail(source) {  
    	    var regex = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;  
    	    if(source.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) != -1){  
    	        return true;  
    	    }else{  
    	       // alert("电子邮箱格式不正确");  
    	        return false;  
    	    }  
    	}     
	</script>
    <div class="alert-450" id="alert-bandingEmail" style="display:none;">
      <div class="alert-title">
        <h3>绑定邮箱</h3>
        <span class="alert-close" onclick="displaySpan('alert-bandingEmail')"></span></div>
      <div class="alert-main">
        <form id="bandingEmail" name="bandingEmail" method="post" action="rzemail" enctype="multipart/form-data" target="rfFrame">
          <ul>
            <li>
              <label class="txt-name">绑定邮箱</label>
              <input id="bdEmail" type="text" name="toAddress" value="" class="txt235"  placeholder="请输入邮箱">
              <div id="bandingEmailrrorDiv" class="alert-error120">
              	 <span id="bdemailNullError" class=error style="display:none;" >请先输入邮箱</span> 
              	 <span id="bdemailError" class=error style="display:none;">邮箱格式有误</span>
              </div>
            </li>
            <li>
            <br>
              <label class="txt-name">验证码</label>
              <input id="emailyzCode" type="text" name="emailyzCode" class="txt110" maxlength="8" onblur="jsf.util.chain(this,event,'return checkOldMobileFormAuthCode()','mojarra.ab(this,event,\'blur\',0,\'@this\')')" onfocus="clearValue(this)" placeholder="请输入验证码">
                <input type="button" style="height:32px;width:120px;" class="btn-code" value="点击发送邮箱验证码" onclick="bangdingEmail(this);" />
            	<input type="hidden" id="newEmailyzm" name="yzm" value="">
             </li>
              <li>
	              <span id="bdemailyzmNullError" class="txt-right" style="display:none;">
	                 <i class="error-icon"></i><i class="error-tip">请输入验证码</i>
	              </span><br>
	              <span id="bdemailyzmError" class="txt-right" style="display:none;">
	                 <i class="error-icon"></i><i class="error-tip">验证码错误请重新输入</i>
	              </span><br>
           	   <input id="jhemail" type="button" name="jhemail" value="确认并激活邮箱" class="btn-ok txt-right" onclick="bdEmailSubmit();">
            </li>
          </ul>
          
        </form>
      </div>
    </div>
    
    <!-- 修改邮箱 -->

    <div class="alert-450" id="alert-updateEmail" style="display:none;">
      <div class="alert-title">
        <h3>更改邮箱</h3>
        <span class="alert-close" onclick="displaySpan('alert-updateEmail')"></span></div>
      <div class="alert-main" id="alert-main">
        <form id="changeEmailForm" name="changeEmailForm" method="post" action="userinfo/saveUserinfo" enctype="application/x-www-form-urlencoded">
          <input type="hidden" name="changeEmailForm" value="changeEmailForm">
          <ul>
            <li>
              <label class="txt-name">请输入新邮箱</label>
              <input type="hidden" value="${user.phone }" id="phone" name="phone">
              <input type="hidden" value="${userInfo.email }" id="email" name="email">
              <input id="changeEmailForm:newEmail" type="text" name="newEmail" class="txt235" onblur="jsf.util.chain(this,event,'return checkchangeEmailFormNewEmail()','mojarra.ab(this,event,\'blur\',0,0)')" placeholder="请输入邮箱">
              <div id="newEmailErrorDiv" class="alert-error120">
              	<span id="xgemailNullError" class=error style="display:none;" >请先输入邮箱</span> 
              	 <span id="xgemailError" class=error style="display:none;">邮箱格式有误</span>
              </div>
            </li>
              
            <li>
          <br>
              <label class="txt-name">手机验证码</label>
              <input id="phoneyzCode" type="text" name="changeEmailForm:changeEmailFormauthCode" class="txt110" maxlength="8" onblur="mojarra.ab(this,event,'blur',0,0)" placeholder="请输入手机验证码">
         	 <!-- 点击图标后变为灰色，class="btn-codeAfter"  -->
             	<input type="button" class="btn-code" onclick="changeEmail(this);"  style="cursor:default;" value="点击获取手机校验码" />
             	<input type="hidden" id="xgEmailyzm" name="yzm" value="">
             </li>
              <li><span id="NullchangeEmail" class="txt-right" style="display:none;"><i class="error-icon"></i><i class="error-tip">请输入验证码</i></span><br>
               <li><span id="changeEmailError" class="txt-right" style="display:none;"><i class="error-icon"></i><i class="error-tip">验证码错误请重新输入</i></span><br>
              <input type="button" name="changeEmailForm:j_idt150" value="确　认" class="btn-ok txt-right" onclick="changeEmailSubmit();">
          </ul>
         </form>
      </div>
    </div>
    
	 <!-- 邮箱修改 -->
    <script type="text/javascript">
          //验证邮箱是否为空
          function checkchangeEmailFormNewEmail(){
       	   var mobile=$("#changeEmailForm\\:newEmail").val();
      	 	var email=$("#email").val();		//获取原来的邮箱
       	   var nullFlag=(mobile=="");
       	   if(nullFlag){
   				$("#changeEmailForm\\:newEmail_message").remove();
   				var $span = $("<span id=changeEmailForm\:newEmail_message class=error>请先输入邮箱</span>");
   				$("#newEmailErrorDiv").append($span);
   				return false;
   			}else{
   				var error=$("#newEmailErrorDiv").text();
   				if(error=='请先输入邮箱'){
   					$("#changeEmailForm\\:newEmail_message").remove();
   					return false;
   				}
   				
   			 	if(email==mobile){
	   			 	$("#changeEmailForm\\:email_message").remove();
	   				var $span = $("<span id=changeEmailForm\:email_message class=error>新邮箱与原邮箱相同</span>");
	   				$("#newEmailErrorDiv").append($span);
	   				return false;
   			 	}else{
	   			 	var error=$("#newEmailErrorDiv").text();
	   				if(error=='请先输入邮箱'){
	   					$("#changeEmailForm\\:email_message").remove();
	   				}
	   				return true;
   			 	}
   				
   			}
          }
          //验证所有
          function changeEmailAll(){
        	  checkchangeEmailFormNewEmail();
       	   var emailErrorFlag=$("#newEmailErrorDiv").text()=="";
       	   return emailErrorFlag;
          }
          
         //验证码发送提交
  		function changeEmail(thisBtn){
  			checkchangeEmailFormNewEmail();		//验证邮箱是否为空
  			
  			var toAddress=$("#phone").val();
  			var nullFlag=(toAddress=="");
  			var emailFlag=checkchangeEmailFormNewEmail();
       	    if(!nullFlag&&emailFlag){
       	    	sendCode(thisBtn);				//点击发送验证倒计时
       	    	$.ajax({  
  		            type:'POST',  
  		            url: 'yzphone',  
  		            data: {'phone': toAddress},  
  		            async: true,  
  		            dataType: 'json',  
  		            success: function(data){
  		                if(data){  
  		                 alert('发送成功，请在60s内填写');  
  		                 document.getElementById("xgEmailyzm").value=data.success;
  		                 
  		                  document.getElementById('submit').onclick = function(){
  		                	 changeEmailSubmit();
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
       	    	
       	    }
  		}
         
      //修改邮箱提交   
      function changeEmailSubmit(yzCode){
			checkchangeEmailFormNewEmail();		//验证邮箱是否为空
			var yzCode=$("#xgEmailyzm").val();
			//alert(yzCode);
  			var toAddress=$("#changeEmailForm\\:newEmail").val();
  			var phoneyzCode=$("#phoneyzCode").val();
  			var nullFlag=(phoneyzCode=="");		//判断验证码是否为空
  			
  			var emailFlag=(phoneyzCode==yzCode);	//判断验证码是否正确
  			//alert(toAddress);
       	    if(nullFlag){
       	    	$("#NullchangeEmail").css({"display": "block"});
       	    }else{
       	    	$("#NullchangeEmail").css({"display": "none"});
       	    	if(!emailFlag){
       	    		$("#changeEmailError").css({"display": "block"});
       	    	}else{
       	    		$("#changeEmailError").css({"display": "none"});
           	    	$.ajax({  
      		            type:'POST',  
      		            url: 'userinfo/saveUserinfo',  
      		            data: {'email': toAddress},  
      		            async: false,  
      		            dataType: 'text',  
      		            success: function(data){  
      		                if(data){  
      		                	window.location.href="/rhzb/user/userSet";  

      		                	displaySpan('alert-updateEmail');
      		                	//$("#pmain-conmain0").html(data);//要刷新的div
      		                    alert('更改成功');  
      		                }else{  
      		                    alert('更改失败');  
      		                }  
      		            },error: function(err){  
      		            	//alert(err);
      		                alert('网络故障');  
      		            }  
      		        }); 
       	    	}
       	    }
  		}   
	</script>
   <!------------------------------------------------------------------------------------------------------>
    
    
    <div class="clear"></div>
  </div>
<!--网站底部-->
<%@ include file="/jsp/frontpage/include/foot.jsp"%>
</body>
</html>
