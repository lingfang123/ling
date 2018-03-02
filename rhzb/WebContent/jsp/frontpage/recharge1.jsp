<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String path=request.getContextPath(); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<%@ include file="/jsp/frontpage/include/head.jsp"%><!--个人中心-->
<div class="wrapper wbgcolor">
  <div class="w1200 personal">
   <%@ include file="/jsp/frontpage/include/personalLeft.jsp"%>
    <label id="typeValue" style="display:none;"> </label>

    <div class="personal-main">
      <div class="personal-pay">
        <h3><i>充值</i></h3>
        <div class="quick-pay-wrap">
          <h4> <span class="quick-tit pay-cur"><em>快捷支付</em></span> <!-- <span class="online-tit"><em>网银充值</em> --></span> </h4>
          <form id="form" name="form" method="post" action="" >
            <div class="quick-main">
              <div class="fl quick-info">
                <div class="info-1"> <span class="info-tit">充值金额</span> <span class="info1-input">
                  <input id="money" type="type" name="rechargeMoney" class="pay-money-txt" maxlength="10" ><span id="spmoney"></span>
                  <em>元</em></div>
                <div class="info-tips">亿人宝提醒您：充值前，请核实您的可用支付额度！</div>
                <div class="info-2"> <span class="info-tit">银行卡号</span> <span class="info2-input">
                  <div class="pay-bank" id="pay-bank">
                  <span id="showpay" style="display:none;">icbc</span>
		               <ul id="paysSpan" style="height:60px;">
		                <c:forEach items="${listCard}" var ="c">
		                  <li><img src="${c.images}" property1="icbc"class="on" id=""><em></em>
		                  <input type="hidden" name="bankcardno" value="${c.bankcardno}" class="bankCard" id="bankCard"/></li>
		                </c:forEach>
		                <input type="hidden" value="bankno" name="bankno" id="bankno">
		               </ul>
	               </div>
                <div class="bank-check" id="bank-check2"> <b class="selected" id="bankProtocol1"></b><span class="bank-agree">我同意并接受<a href="#" target="_blank">《亿人宝投资咨询与管理服务电子协议》</a></span> <span class="error" id="bankProtocol_message" style="display:none;margin-top:-3px;">请同意协议内容！</span> </div>
               <input id="" type="button" name="button" value="充值" class="btn-paycz" onclick="showSpan('apply-jk');">
              </div>
            </div>  
            </div>
          </form>
          <div class="online-main" style="display:none;">
          </div>
          <div class="pay-tipcon" style="display:none;"> <b>充值提示：</b><br>
            1．亿人宝充值过程免费，不向用户收取任何手续费。<br>
            2．为了您的账户安全，请在充值前进行身份认证、手机绑定以及交易密码设置。<br>
            3．您的账户资金将通过丰付支付第三方平台进行充值。<br>
            4．请注意您的银行卡充值限制，以免造成不便。<br>
            5．如果充值金额没有及时到账，请联系客服—400-999-8850 </div>
          <div class="pay-tipcon2"> <b>温馨提示：</b><br>
            1. 投资人充值过程全程免费，不收取任何手续费。<br>
            2. 为防止套现，所充资金必须经投标回款后才能提现。<br>
            3. 使用快捷支付进行充值，可能会受到不同银行的限制，如需大额充值请使用网银充值进行操作。<br>
            4. 充值/提现必须为银行借记卡，不支持存折、信用卡充值。<br>
            5. 严禁利用充值功能进行信用卡套现、转账、洗钱等行为，一经发现，将封停账号30天。<br>
            6. 充值期间，请勿关闭浏览器，待充值成功并返回首页后，所充资金才能入账，如有疑问，请联系客服。<br>
            7. 充值需开通银行卡网上支付功能，如有疑问请咨询开户行客服。<br>
          </div>
        </div>
      </div>
      <div class="alert-450" id="alert-tyht" style="display:none;">
        <div class="alert-title">
          <h3>提示信息</h3>
          <span class="alert-close" onclick="displaySpan('alert-tyht')"></span></div>
        <div class="alert-main" style="margin-bottom: 35px;margin-left: 25px;">
          <p class="msg4"> 你需要阅读并同意《亿人宝金融投资咨询与管理服务电子协议》 </p>
        </div>
      </div>
    </div>
    <div class="clear"></div>
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
		$("#confirmButton").click(function(){
			var money = $("#money").val();
			var bankCard = $("#bankCard").val();
			if(money.length==0){
				layer.msg('请输入充值!!!!',{icon:1,time:1500});
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
								layer.msg('密码正确!',{icon:1,time:1000});
									layer.msg('充值中..............',{icon:1,time:20000});
										$.ajax({
											type: "post",
											url: "userRecharge/addRecharge",
											data: {"money":money,"bankCard":bankCard},
											datatype:"text",
											success: function(data){
												if(data=="401"){
													layer.msg('充值成功!',{icon:1,time:1000});
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

												if(data=="400"){
													layer.msg('银行卡没有这么多钱!',{icon:1,time:1000});
													return false;
												}

												if(data=="105"){
													layer.msg('没有开通第三方!',{icon:1,time:1000});
													return false;
												}
												if(data=="403"){
													layer.msg('充值异常!',{icon:1,time:1000});
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

   <script type="text/javascript"> 
   					$('#money').focus(function(){
	        		$('#spmoney').html('');
	        	});
				$('#money').blur(function(){
					var moneys=$('#money').val();
					var moneyreg="^(([1-9]+[0-9]*)|((([1-9]+[0-9]*)|0)\\.[0-9]{1,2}))$";<!--判断输入的是否为数字-->
					var numberFlag=isNaN(moneys);<!--判断输入的是不是数字-->
					//如果输入的不是数字
					if(moneys.trim()==0){
						$('#spmoney').html("*请输入金额").css('color','red');
					}else{
						$('#spmoney').html("");
					}
					if(numberFlag){
						/* html("*请输入金额").css('color','red');	 */
						/* var $span = "<em></em>请输入数字</span>"; */
						$("#spmoney").html("*请输入数字").css('color','red');
						//return false;
					}
					else
					{
						$("#spmoney").html("");
					}
					//输入金额是否合法
					var moneyPattern = new RegExp(moneyreg);
			    	var legalFlag=moneyPattern.test(moneys);
					if(!legalFlag)
					{
						$("#spmoney").html("*请输入合法数字").css('color','red');
						return false;		
					}
					else
					{
						$("#spmoney").html("");
					}
					return true;
					
					
				});
				$("ul#paysSpan li").click(function(){
					var bankcard=$(this).children('input').val();
					
					$('#bankno').val(bankcard);
					$(this).append("<i></i>").siblings("li").children("i").remove();
					
				});
				$("ul#paysSpan li").eq(0).append("<i></i>");
				
	</script>
 	<script type="text/javascript">
 	$(document).ready(function(){
		$("#button").click(function(){
			var money = $("#money").val();
			var bankCard = $("#bankCard").val();
			if(money.length==0){
				layer.msg('请输入充值!!!!',{icon:1,time:1500});
                return false;  

			}
			if(bankCard.length==0){
				layer.msg('请选择银行卡!!!!',{icon:1,time:1500});
                return false;  

			}
			if(money.length!=0){
				layer.msg('充值中..............',{icon:1,time:10000});
					$.ajax({
						type: "post",
						url: "userRecharge/addRecharge",
						data: {"money":money,"bankCard":bankCard},
						datatype:"text",
						success: function(data){
							if(data=="401"){
								layer.msg('充值成功!',{icon:1,time:1000});
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

							if(data=="400"){
								layer.msg('银行卡没有这么多钱!',{icon:1,time:1000});
								return false;
							}

							if(data=="105"){
								layer.msg('没有开通第三方!',{icon:1,time:1000});
								return false;
							}
							if(data=="403"){
								layer.msg('充值异常!',{icon:1,time:1000});
								return false;
							}
							if(data=="000"){
								layer.msg('网络错误!',{icon:1,time:1000});
								return false;
							}

						},
					});
				}
			});
	});
	</script>
<!--网站底部-->
<%@ include file="/jsp/frontpage/include/foot.jsp"%>
</body>
</html>
