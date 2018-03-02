<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=path%>/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>金源宝——开通第三方</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="jsp/frontpage/css/common.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="jsp/frontpage/css/user.css" />
<link rel="stylesheet" type="text/css" href="jsp/frontpage/css/jquery.datetimepicker.css"/>
<script type="text/javascript" src="jsp/frontpage/script/jquery.min.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/common.js"></script>
<script src="jsp/frontpage/script/user.js" type="text/javascript"></script>
</head>
<body>
<%@ include file="/jsp/frontpage/include/head.jsp"%>
<!--个人中心-->
<div class="wrapper wbgcolor">
  <div class="w1200 personal">
    <%@ include file="/jsp/frontpage/include/personalLeft.jsp"%>
		
	<style>
	   body { margin:0px;padding:0px;text-align: center;}
	   #hidebg { position:absolute;left:0px;top:0px;
	      background-color:#000;
	      width:100%;  /*宽度设置为100%，这样才能使隐藏背景层覆盖原页面*/
	      filter:alpha(opacity=60);  /*设置透明度为60%*/
	      opacity:0.6;  /*非IE浏览器下设置透明度为60%*/
	      display:none; /* http://www.jb51.net */
	      z-Index:2;}
	   #hidebox { position:absolute;width:400px;height:300px;top:200px;left:30%;background-color:#fff;display:none;cursor:pointer;z-Index:3;}
	   #content { text-align:center;cursor:pointer;z-Index:1;}
	</style>

	<script>
		function show()  //显示隐藏层和弹出层
		{
		   var hideobj=document.getElementById("hidebg");
		   hidebg.style.display="block";  //显示隐藏层
		   hidebg.style.height=document.body.clientHeight+"px";  //设置隐藏层的高度为当前页面高度
		   document.getElementById("hidebox").style.display="block";  //显示弹出层
		}
		function hide()  //去除隐藏层和弹出层
		{
		   document.getElementById("hidebg").style.display="none";
		   document.getElementById("hidebox").style.display="none";
		}
		
	</script>
	
    <script type="text/javascript">
	    $(function(){
			　　document.getElementById("test").click();
			});
	    
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
			
				
		</script>

    <div class="personal-main">
      <div class="personal-pay">
        <h3><i>开通第三方账户</i></h3>
        <form id="form" name="form" method="post" action="">
          <div class="pay-notice">
            <p>开通第三方资金托管账户的信息将提交至<a href="http://www.sumapay.com/" target="_blank">丰付支付</a>网站执行，</p>
            <p><a href="http://www.sumapay.com/" target="_blank">丰付支付</a>系统将为您分配唯一用户ID（格式为：TG_用户名），并与您亿人宝金融账户自动绑定，您无需修改和记忆。 </p>
          </div>
          <div class="pay-form">
            <h6>请输入您的身份证信息</h6>
            <ul>
              <li>
                <label for="realname">真实姓名</label>
                <input type="text" name="" class="pay-txt" maxlength="16"  placeholder="您的真实姓名">
                <div id="realnameErrorDiv"></div>
              </li>
              <li>
                <label for="idCard">身份证号</label>
                <input type="text" name="" class="pay-txt" maxlength="18" placeholder="您的身份证号">
                <div id="idCardErrorDiv">
                  <p style="margin-top:10px;">身份证信息认证后将不可修改，请您仔细填写</p>
                </div>
              </li>
            </ul>
            <h6>手机号已绑定</h6>
            <ul>
              <li>
                <label for="phone">手机号</label>
                <input type="hidden" name="form:j_idt98" value="15055100139">
                <label>  ${user.phoneYC }</label>
              </li>
              <li>
                <input type="submit" name="" value="开户" style="border:none;" class="btn-paykh">
              </li>
            </ul>
          </div>
        </form>
        
        <div class="pay-tipcon"> 1、为切实保障投资人的利益，亿人宝金融将理财资金托管在<a href="http://www.sumapay.com/" target="_blank">丰付第三方支付</a>平台。平台是2012年6月获批中国人民银行支付许可证和中国证监会基金支付许可的第三方支付公司，在金融支付领域业界领先地位。详情请登录<a href="http://www.sumapay.com/" target="_blank">丰付支付</a>官方网站查看。<br>
          2、根据相关法律规定，亿人宝金融在开通资金托管账户时，需要验证您的身份信息。该信息一经设置，无法修改，请慎重选择。为了确保您可以顺利提现，请确认您拥有一张使用该身份证开户的有效储蓄卡。<br>
          3、亿人宝金融将最大限度的尊重和保护您的个人隐私，详情请阅读<a href="/node/Candyprivacypolicy/RegistrationAgreement0001test" target="_blank">《亿人宝金融隐私条款》</a>。<br>
          4、您在开通第三方账号过程中，如有遇到问题，可以查看理财帮助，也可以联系我们的客服进行咨询，咨询电话：400-999-8850。 </div>
      </div>
      
       <div class="alert-450" id="Remind" style="display: none;">
        <div class="alert-title">
          <h3>设置交易密码</h3>
          <span class="alert-close" onclick="displaySpan('Remind')"></span>
        </div>
        <div class="alert-main">
          <form id="activeEmail" name="activeEmail" method="post" action="rzemail" enctype="multipart/form-data" target="_blank">
            <input type="hidden" name="activeEmail" value="activeEmail">
            <ul>
              <li>
              	<input type="hidden" id="test" onclick="showSpan('Remind');">
                <label class="txt" >您还没有设置交易密码，立即去<a href="user/userSet" style="color:red;">设置</a></label>
              </li>
            </ul>
          </form>
        </div>
      </div>
     
    </div>
    <div class="clear"></div>
  </div>
</div>
<!--网站底部-->
<%@ include file="/jsp/frontpage/include/foot.jsp"%>
</body>
</html>
