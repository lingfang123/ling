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
<title>金源宝——开通第三方1</title>
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
        /*获取验证码*/
		a.hqyzm{ float:left; background:#ea524a; width:125px; height:35px; line-height:35px; font-size:14px; margin-left:6px; text-align:center; color:#fff; border-radius:2px;}
		a.hqyzm:hover{color:#fff;background:#ff8882;}
		/*获取验证码后在倒计时中的样式*/
		a.hqyzmAfter{float:left; background:#c0c0c0; width:125px; height:35px; line-height:35px; font-size:14px; margin-left:6px; text-align:center; color:#fff; border-radius:2px;}
	  </style>
   
    
    <script type="text/javascript">
	    	  //焦点离开事件
 		   function idcardYZ(){
	    	   var idcard= $('#identityCard').val();
	    		var cardFlag= isCardNo(idcard);
				if(idcard==''){
					$("#idCardNullErrorDiv").css("display","block");   
					$("#idCardErrorDiv").css("display","none");
					return false;
				}else{
					$("#idCardNullErrorDiv").css("display","none"); 
					if(!cardFlag){
		    			//身份验证失败，请确认格式
		    			$("#idCardErrorDiv").css("display","block");
		    			return false;
		    		}else{
		    			$("#idCardErrorDiv").css("display","none");
		    			return true;
		    		}
				  }
  		    } 
 		  function realnameYZ(){
	    		 var name= $('#name').val();
	    		 var nameFlag=isNaN(name);
				if(name==''){
					$("#realnameNullErrorDiv").css("display","block");   
					$("#realnameErrorDiv").css("display","none");
					return false;
				}else{
					$("#realnameNullErrorDiv").css("display","none"); 
					if(!isNaN(name)){
		    			//身份验证失败，请确认格式
		    			$("#realnameErrorDiv").css("display","block");
		    			return false;
		    		}else{
		    			$("#realnameErrorDiv").css("display","none");
		    			return true;
		    		}
				 }
  		 }  
	    	  
     
	/** 
	 验证身份证号是否正确 
	 **/  
	function isCardNo(num){  
	    if(isNaN(num)){  
	        //alert("输入的身份证号不是数字！");  
	        return false;  
	    }  
	    var len = num.length;  
	    if(len<15 || len>18){  
	       // alert("输入的身份证号码长度不正确定！应为15位或18位");  
	        return false;  
	    }  
	    var re15 = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/;  
	    var re18 = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$/;  
	    var res = (re15.test(num) || re18.test(num));  
	    if(res==false){  
	       // alert("输入的身份证号格式不正确！");  
	        return false;  
	    }  
	    return res;  
	}
     
		function openAcount(){
			idcardYZ();
			realnameYZ();
			if(idcardYZ()&&realnameYZ()){
				$.ajax({
					cache: true,
					type: "POST",
					url: 'userinfo/payThree',  
					data: $('#form').serialize(),// 你的formid
					async: false,
					success: function(data) {
						if(data=='success'){  
		                	window.location.href="/rhzb/user/personal";  
		                    alert('开户成功');  
		                }else if(data=='nosuccess'){  
		                    alert('服务器繁忙，请稍后再试');  
		                }else{
		                	alert('网络故障');
		                }  
					},error: function(request) {
						 alert('网络故障');  
					}
				});
			}else{
			}
		}
		
		</script>
    
    <div class="personal-main">
      <div class="personal-pay">
        <h3><i>开通第三方账户</i></h3>
        <form id="form" name="form" method="post" action="userinfo/payThree" enctype="application/x-www-form-urlencoded">
          <div class="pay-notice">
            <p>开通第三方资金托管账户的信息将提交至<a href="http://www.sumapay.com/" target="_blank">丰付支付</a>网站执行，</p>
            <p><a href="http://www.sumapay.com/" target="_blank">丰付支付</a>系统将为您分配唯一用户ID（格式为：TG_用户名），并与您亿人宝账户自动绑定，您无需修改和记忆。 </p>
          </div>
          <div class="pay-form">
            <h6>请输入您的身份证信息</h6>
            <ul>
              <li>
                <label for="realname">真实姓名</label>
               
                <input id="name" name="name" type="text"  class="pay-txt" maxlength="16"  placeholder="您的真实姓名,不能输入数字"  onkeyup="value=value.replace(/[\d]/g,'') "onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[\d]/g,''))" maxlength=10>
                <div id="realnameNullErrorDiv" style="display:none;">
                	<p style="margin-top:10px;color:red;">*真实姓名不能为空</p>
                </div>
                <div id="realnameErrorDiv" style="display:none;">
                	<p style="margin-top:10px;color:red;">*真实姓名不能含数字</p>
                </div>
              </li>
              <li>
                <label for="idCard">身份证号</label>
                <input id="identityCard" name="identityCard" type="text" class="pay-txt" maxlength="18" placeholder="您的身份证号">
                
                 <div id="idCardNullErrorDiv" style="display:none;">
                  <p style="margin-top:10px;color:red;">*身份证号不能为空</p>
                </div>
                 <div id="idCardErrorDiv" style="display:none;">
                  <p style="margin-top:10px;color:red;">*你输入的身份证格式不正确</p>
                </div>
              </li>
            </ul>
            <h6>手机号已绑定</h6>
            <ul>
              <li>
               <input id="dealPassword" type="hidden" name="dealPassword" value="${userInfo.dealPassword }">
                <label for="phone">手机号</label>
                <input id="phone" type="hidden" name="phone" value="${user.phone }">
                <label> ${user.phoneYC }</label>
              </li>
              <li>
            <!-- <input type="submit" name="" value="开户" style="border:none;" class="btn-paykh"> -->
           <input type="button" id="submits" name="submits" value="开户" style="border:none;" class="btn-paykh" onclick="openAcount();" />
              </li>
            </ul>
          </div>
        </form>
        <div class="pay-tipcon"> 1、为切实保障投资人的利益，亿人宝将理财资金托管在<a href="http://www.sumapay.com/" target="_blank">丰付第三方支付</a>平台。平台是2012年6月获批中国人民银行支付许可证和中国证监会基金支付许可的第三方支付公司，在金融支付领域业界领先地位。详情请登录<a href="http://www.sumapay.com/" target="_blank">丰付支付</a>官方网站查看。<br>
          2、根据相关法律规定，亿人宝在开通资金托管账户时，需要验证您的身份信息。该信息一经设置，无法修改，请慎重选择。为了确保您可以顺利提现，请确认您拥有一张使用该身份证开户的有效储蓄卡。<br>
          3、亿人宝将最大限度的尊重和保护您的个人隐私，详情请阅读<a href="#" target="_blank">《亿人宝隐私条款》</a>。<br>
          4、您在开通第三方账号过程中，如有遇到问题，可以查看理财帮助，也可以联系我们的客服进行咨询，咨询电话：400-999-8850。 </div>
      </div>
    </div>
    <div class="clear"></div>
  </div>
</div>
<!--网站底部-->
<%@ include file="/jsp/frontpage/include/foot.jsp"%>
<script src="jsp/frontpage/script/jquery.datetimepicker.js" type="text/javascript"></script>
<script src="jsp/frontpage/script/datepicker.js" type="text/javascript"></script>
</body>
</html>
