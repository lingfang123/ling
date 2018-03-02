<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String path=request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=path %>/">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>p2p网贷平台</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="jsp/frontpage/css/common.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="jsp/frontpage/css/user.css" />
<link rel="stylesheet" type="text/css" href="jsp/frontpage/css/jquery.datetimepicker.css"/>
<script type="text/javascript" src="jsp/frontpage/script/jquery.min.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/common.js"></script>
<script src="jsp/frontpage/script/user.js" type="text/javascript"></script>
<script type="text/javascript" src="/rhzb/jsp/frontpage/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="/rhzb/jsp/frontpage/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="/rhzb/jsp/frontpage/lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript" src="/rhzb/jsp/frontpage/lib/layer/2.4/layer.js"></script>
<link rel="stylesheet" type="text/css" href="/rhzb/jsp/frontpage/css/gz.css"/>
<script type="text/javascript" src="/rhzb/jsp/frontpage/script/gz.js"></script>
<script>
function showSpan(op){
	$("body").append("<div id='mask'></div>");
	$("#mask").addClass("mask").css("display","block");
	$("#"+op).css("display","block"); 
	
}
</script>
</head>
<body>
<%@ include file="/jsp/frontpage/include/head.jsp"%>
<!--个人中心-->
<div class="wrapper wbgcolor">
  <div class="w1200 personal">
    <div class="credit-ad"></div>
    <div id="personal-left" class="personal-left">
      <ul>
        <li class="pleft-cur"><span><a href="user/personal"><i class="dot dot1"></i>账户总览</a></span></li>
        <li><span><a style="font-size:14px;text-align:center;width:115px;padding-right:35px;" href="user/recordMoney">资金记录</a></span></li>
        <li><span><a style="font-size:14px;text-align:center;width:115px;padding-right:35px;" href="invest/openInvestPage?userid=${user.id}">投资记录</a></span></li>
        <li><span><a style="font-size:14px;text-align:center;width:115px;padding-right:35px;" href="user/payback">回款计划</a></span></li>
        <li class=""><span><a href="user/thirdParty"><i class="dot dot02"></i>开通第三方</a> </span> </li>
        <li><span><a href="user/recharge"><i class="dot dot03"></i>充值</a></span></li>
        <li class=""><span><a href="user/withdrawal"><i class="dot dot04"></i>提现</a></span></li>
        <li style="position:relative;" class=""> <span> <a href="user/envelope"> <i class="dot dot06"></i> 我的红包 </a> </span> </li>
        <li class=""><span><a style="font-size:14px;text-align:center;width:115px;padding-right:35px;" href="user/changeHistory">兑换历史</a></span></li>
        <li style="position:relative;"> <span> <a href="user/systemInfo"><i class="dot dot08"></i>系统信息 </a> </span> </li>
        <li><span><a href="user/userSet"><i class="dot dot09"></i>账户设置</a></span></li>
        <li><span><a style="font-size:14px;text-align:center;width:115px;padding-right:20px;" href="bankCard/selectMyBankCard?userid=${user.id}">我的银行卡</a></span></li>
        <li><span><a style="font-size:14px;text-align:center;width:115px;padding-right:35px;" href="InvitingFriends/UserInvitingFriends">邀请好友</a></span></li>
      </ul>
    </div>
    <label id="typeValue" style="display:none;"> </label>
    <script>
		//<![CDATA[
			function showSpan(op){
				$("body").append("<div id='mask'></div>");
				$("#mask").addClass("mask").css("display","block");
	
				$("#"+op).css("display","block");
			}
	
			function displaySpan(op){
				$("#mask").css("display","none");
				$("#"+op).css("display","none");
			}
		//]]>
	</script>
		<div class="personal-main">
      <div class="personal-pay">
   <!--  <div class="personal-main">
      <div class="personal-deposit"> -->
        <h3><i>提现</i></h3>
        <form id="form" name="form" method="post"><!-- enctype="application/x-www-form-urlencoded" target="_blank" -->
          <input type="hidden" name="form" value="form">
          <div class="deposit-form" style="margin-top:0px;border-top:0px none;">
            <h6>填写提现金额</h6>
            <ul>
              <li> 	
              	 <span class="deposit-formleft">可用金额</span> 
              	 <span class="deposit-formright"> 
	               <i>
		             <label id="form:blance">${money.accountMoney}</label>
		             <input type="hidden" id="accountMoney" value="${money.accountMoney}">
		            </i>元 
	             </span> 
               </li>
               <li> 
               	  <span class="deposit-formleft">提现金额</span> 
               	  <span class="deposit-formright">
                	<input id="money" type="text" name="withdrawMoney" class="deposite-txt" maxlength="10">元<span id="message"></span>
                  </span><!--  <span id="actualMoneyErrorDiv"> -->
                <!-- <div class="info-tips"><span id="message"></span> </div> -->
               <!--  <span id="message" style="width:110px height:20px"></span> --><!-- </span> -->
               </li>
               <li>
               	  <span class="deposit-formleft">提现费用</span> 
               	  <em id="txfy" class="markicon fl"></em> 
               	  <span class="deposit-formright deposit-formright1"> 
	               	  <i>
	                	<span id="fee" name="poundage">0.00</span>
	                	<input type="hidden" id="fe" value="" name="poundage"/>
	                  </i>元
                  </span>
                 <span class="txarrow-show">提现金额的0.1%，最低不低于0元，最高100元封顶</span>
                 <span class="txicon-show"></span> 
                </li>
             <!--  <li><span class="deposit-formleft">实际到账金额</span> <em id="dzje" class="markicon fl"></em> <span class="deposit-formright deposit-formright1"> <i>
                <label id="form:cashFine"> 0.00</label>
                </i> 元</span> <span class="dzarrow-show">提现金额 - 提现费用</span><span class="dzicon-show"></span> </li> -->
               <li>
               <span class="info-tit">银行卡号</span>
                  <div class="info-2"><span class="info2-input">
                  <div class="pay-bank" id="pay-bank">
                  	<span id="showpay" style="display:none;">icbc</span>
		               <ul id="paysSpan" style="height:60px;">
		                <c:forEach items="${listCard}" var ="c">
		                  <li style="width:162px;border-color:white;"><img src="${c.images}" property1="icbc" ><input type="hidden" name="bankcardno" value="${c.bankcardno}" class="bankCard" id="bankCard"/></li>
		                </c:forEach>
		                <input type="hidden" name="bankno" value="bankno" id="bankno">
		               </ul>
	               </div>
                <div class="bank-check" id="bank-check2" style="margin-top: 20px"> <b class="selected" id="bankProtocol1"></b><span class="bank-agree">我同意并接受<a href="#" target="_blank">《亿人宝投资咨询与管理服务电子协议》</a></span> <span class="error" id="bankProtocol_message" style="display:none;margin-top:-3px;">请同意协议内容！</span> </div>
               <!--  <input type="submit" name="" value="充值" class="btn-paycz" onclick="return getShowPayVal1()"> -->
               <input id="button" type="button" value="提现" class="btn-paycz"  onclick="showSpan('apply-jk');">
              </div>
              
<!--                 <input type="submit" name="form:j_idt78" value="提现" class="btn-depositok" onclick="return checkActualMoney()">
 -->             </li>
            </ul>
          </div>
        </form>
        <br>
        <div class="deposit-tip"> 温馨提示：<br>
          1、用户需在完成身份认证、开通丰付托管账户并绑定银行卡后，方可申请提现；<br>
          2、请务必在提现时使用持卡人与身份认证一致的银行卡号，且确保填写信息准确无误；<br>
          3、工作日当天16:00前提交的提现申请将在当天处理，默认为T+1到账；<br>
          4、提现金额单笔上限为50万元，单日累计总额不可超过100万元；<br>
          5、提现手续费为提现金额的0.1%，最低每笔2元，100元封顶，手续费由第三方托管账户收取，用户自行承担。<br>
        </div>
      </div>
    </div>
   <div class="alert-450" id="apply-jk" style="display: none;">
    <div class="inputBoxContainer" id="inputBoxContainer">
        <input type="text" class="realInput" value="交易密码"/>
        <div class="bogusInput">
            <input type="password" maxlength="6" disabled/>
            <input type="password" maxlength="6" disabled/>
            <input type="password" maxlength="6" disabled/>
            <input type="password" maxlength="6" disabled/>
            <input type="password" maxlength="6" disabled/>
            <input type="password" maxlength="6" disabled/>

        </div>
    </div>
    <button id="confirmButton" class="confirmButton">确定</button>
    <p class="showValue" id="showValue" style="display: none;"></p>
</div>
    <script type="text/javascript">
			$("#form\\:actualMoney").focus(
					   function(){
						   	$(this).css({"font-size":"24px","font-weight":"bold","font-family":"Arial","border":"1px solid #0caffe"});
						   if($("#form\\:actualMoney").val() == value) { 
							   	$("#form\\:actualMoney").val("")
								$(this).css({"font-size":"24px","font-weight":"bold","font-family":"Arial"});
						   }
						}).blur(
						function(){
						   $(this).css("border","1px solid #D0D0D0");
						   if($("#form\\:actualMoney").val() == "") {
							  	$(this).css({"color":"#D0D0D0","font-size":"14px","font-weight":"normal"});
					}
				})
				
				function keyUpcheck()
				{
					$(this).css({"font-size":"24px","font-weight":"bold","font-family":"Arial"});
				}
			</script>
    <div class="clear"></div>
  </div>
</div>
<%@ include file="/jsp/frontpage/include/foot.jsp"%>
<script type="text/javascript">
	
	$("#money").keyup(function(){
		var actualMoney = $("#money").val();
		
		var num = actualMoney*0.001;
		
		//document.getElementById('fee').innerHTML =  num.toFixed(2);
		$("#fee").html(num.toFixed(2));
		//$("#fe").html(num.toFixed(2));
		$("#fe").val(num.toFixed(2));
	
	});
	
	
	$('#money').blur(function(){
			var moneys = $("#money").val();
			var numberFlag=isNaN(moneys);
			var nullFlag=moneys=="";
			if(nullFlag==true)
			{
				$('#message').html('*请输入您要提现的金额').css('color','red');
			
				return false;
			}
			else
			{
				$('#message').html('');
			}
			if(numberFlag)
			{
				$('#message').html('*请输入正确的数字').css('color','red');
				return false;
			}
			else
			{
				$('#message').html('');
			}
			var legalFlag1=moneys>2;
			var legalFlag2=moneys<=500000;
			if(!legalFlag1||!legalFlag2)
			{
				$('#message').html('*提现金额必须大于2.00 元，单笔不超过50 万').css('color','red');
				
				return false;
			}
			else
			{
				$('#message').html('');
			}
			//提现金额小数位
		
			var legalRegex="^(([1-9]+[0-9]*)|((([1-9]+[0-9]*)|0)\\.[0-9]{1,2}))$";
			var legalPattern=new RegExp(legalRegex);
			var legalFlag3=legalPattern.test(moneys);
			if(!legalFlag3)
			{
				$('#message').html('*小数位最多两位!').css('color','red');
				return false;
			}
			else
			{
				$('#message').html('');
			}
			var balance=Number("${money.accountMoney}");
			//提现金额小于余额 
			var legalFlag=(moneys -balance).toFixed(2)<=0;
			if(!legalFlag)
			{
				$('#message').html("*余额不足").css('color','red');
				return false;
			}
			else
			{
				$('#message').html('');
			}
			return true;
	});
/* 	$('#button').click(function(){
		var moneys=$('#money').val();
		if(moneys.trim()==0){
			$('#message').html('*请输入金额').css('color','red');
		}else{
			$('#message').html('');
		}
		if($('#message').html()==''){
			$('#form').submit();
		}
	});
 */	$('#money').focus(function(){
		$('#message').html('');
	});
	
	$("ul#paysSpan li").click(function(){
		// li 的序号
		var index =  $(this).index;
		// img 里src的内容
		var img = $(this).children("img").attr("src");
		
		var bankCard = $(this).children("input").val();
		//alert(bankCard); 
		$('#bankno').val(bankCard);
		$(this).append("<i></i>").siblings("li").children("i").remove();
	})
	
	$("ul#paysSpan li").eq(0).append("<i></i>");
	
	
</script>
 	<script type="text/javascript">
 	$(document).ready(function(){
		$("#button").click(function(){
			var money = $("#money").val();
			var bankCard = $("#bankCard").val();
			var accountMoney = $("#accountMoney").val();
			var y = parseInt(money);
			var a = y*0.001;
			
			var z = a+y;
			if(z>accountMoney){
				layer.msg('提现余额不足!!!!',{icon:1,time:1500});
                return false;  
			}
			if(money.length==0){
				layer.msg('请输入提现金额!!!!',{icon:1,time:1500});
                return false;  
			}
			if(bankCard.length==0){
				layer.msg('请选择银行卡!!!!',{icon:1,time:1500});
                return false;  
			}
			if(money.length!=0){
				}
			});
	});
	</script>
 	<script type="text/javascript">
		$("#confirmButton").click(function(){
			var money = $("#money").val();
			var bankCard = $("#bankCard").val();
			var accountMoney = $("#accountMoney").val();
			var y = parseInt(money);
			var a = y*0.001;
			
			var z = a+y;
			if(z>accountMoney){
				layer.msg('提现余额不足!!!!',{icon:1,time:1500});
                return false;  
			}
			if(money.length==0){
				layer.msg('请输入提现金额!!!!',{icon:1,time:1500});
                return false;  
			}
			if(bankCard.length==0){
				layer.msg('请选择银行卡!!!!',{icon:1,time:1500});
                return false;  
			}

/* 			var pass = $("#showValue").text();
			if(pass.length==0){
				layer.msg('请输入密码!!!!',{icon:1,time:1500});
                return false;  
			} */
			if(money.length!=0){
 					$.ajax({
						type: "post",
						url: "userRecharge/yzpassword",
						data: {"pass":"123456"},
						datatype:"text",
						success: function(data){
							if(data=="true"){
								layer.msg('提现中..............',{icon:1,time:20000});
								$.ajax({
									type: "post",
									url: "userRecharge/updateMoney",
									data: {"money":money,"bankCard":bankCard},
									datatype:"text",
									success: function(data){
										if(data=="500"){
											layer.msg('提现成功!',{icon:1,time:1000});
											setTimeout("parent.location.href='/rhzb/user/personal'",500);
										}
										if(data=="101"){
											layer.msg('没有找到合作公司!',{icon:1,time:1000});
											return false;
										}
										if(data=="201"){
											layer.msg('银行卡不存在!',{icon:1,time:1000});
											return false;
										}

										if(data=="503"){
											layer.msg('用户提现出现异常!',{icon:1,time:1000});
											return false;
										}

										if(data=="105"){
											layer.msg('没有开通第三方!',{icon:1,time:1000});
											return false;
										}

										if(data=="000"){
											layer.msg('网络错误!',{icon:1,time:1000});
											return false;
										}

									},
								});
							}
							if(data=="false"){
								layer.msg('密码错误!',{icon:1,time:1000});
								return false;
							}

						},
					});
				}
			});
	</script>


</body>
</html>
