<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心-左边</title>
</head>
<body>
	 <!-- <div class="credit-ad"><img src="jsp/frontpage/images/clist1.jpg" width="1200" height="96"></div>-->
	 <div id="personal-left" class="personal-left">
      <ul>
        <li class="pleft-cur"><span><a href="user/personal"><i class="dot dot1"></i>账户总览</a></span></li>
        <li><span><a style="font-size:14px;text-align:center;width:115px;padding-right:35px;" href="user/recordMoney">资金记录</a></span></li>
        <li><span><a style="font-size:14px;text-align:center;width:115px;padding-right:35px;" href="invest/openInvestPage">投资记录</a></span></li>
        <li><span><a style="font-size:14px;text-align:center;width:115px;padding-right:35px;" href="user/payback?userid=${user.id}">我的借款</a></span></li>
       
        <li class=""><span>
       	 <a href="<c:if test="${userInfo.openAccount eq null || userInfo.openAccount eq ''}">user/thirdParty</c:if><c:if test="${userInfo.openAccount ne null && userInfo.openAccount ne ''}">javascript:return false;</c:if>">
        	<i class="dot dot02"></i>开通第三方
         </a> </span>
       </li>
        
        <li><span><a href="user/recharge"><i class="dot dot03"></i>充值</a></span></li>
        <li class=""><span><a href="user/withdrawal"><i class="dot dot04"></i>提现</a></span></li>
        <li style="position:relative;" class=""> <span> <a href="user/envelope"> <i class="dot dot06"></i> 我的红包 </a> </span> </li>
        <li class=""><span><a style="font-size:14px;text-align:center;width:115px;padding-right:35px;" href="user/changeHistory">兑换历史</a></span></li>
       <!-- <li><span><a href="#"><i class="dot dot07"></i>自动投标</a></span></li> -->
        <li style="position:relative;"> <span> <a href="user/systemInfo"><i class="dot dot08"></i>系统信息 </a> </span> </li>
        <li><span><a href="user/userSet"><i class="dot dot09"></i>账户设置</a></span></li>
        <li><span><a style="font-size:14px;text-align:center;width:115px;padding-right:20px;" href="bankCard/selectMyBankCard?userid=${user.id}">我的银行卡</a></span></li>
        <li><span><a style="font-size:14px;text-align:center;width:115px;padding-right:35px;" href="InvitingFriends/UserInvitingFriends?userid=${user.id}">邀请好友</a></span></li>
      </ul>
    </div>
</body>
</html>