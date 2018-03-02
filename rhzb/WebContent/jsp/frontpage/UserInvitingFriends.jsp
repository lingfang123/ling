<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% 
	String path = request.getContextPath();
 %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=path%>/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户中心-邀请好友</title>
<link  rel="stylesheet" href="jsp/frontpage/css/common.css"/>
<link rel="stylesheet" type="text/css" href="jsp/frontpage/css/user.css" />
<script type="text/javascript" src="jsp/frontpage/script/jquery.min.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/common.js"></script>
<script  type="text/javascript" src="jsp/frontpage/script/user.js"></script>

<meta name="keywords" content="网贷平台,网络借贷，网络赚钱项目,理财产品">
<meta name="description" content="众易贷网贷平台为您提供网络赚钱项目；为此相继推出了许多新的理财产品，在为您创造高收益的同时也优化了理财产品模式。网络借贷，就选众易贷。">
<meta charset="UTF-8">
<link  rel="Shortcut  Icon"  href="jsp/frontpage/statics/home/images/minilogo.png">
<link rel="stylesheet" href="jsp/frontpage/statics/newcommon/css/m2-commonNew.css?20160520">
<link rel="stylesheet" href="jsp/frontpage/statics/newcommon/css/m2-common.css?20160520">
<link rel="Shortcut  Icon" href="jsp/frontpage/statics/newcommon/images/minilogo.png?20160520">
<link rel="stylesheet" href="jsp/frontpage/statics/usercenter/css/userCenter.css?20160520">
<script type="text/javascript" src="jsp/frontpage/statics/newcommon/js/jquery.min.js?20160520"></script>
<script type="text/javascript" src="jsp/frontpage/statics/newcommon/js/common.js?20160520"></script>
<script type="text/javascript" src="jsp/frontpage/statics/usercenter/js/esl.js?20160520"></script>
<link rel="stylesheet" href="jsp/frontpage/statics/usercenter/css/jquery.datetimepicker.css?20160520" />
<script type="text/javascript" src="jsp/frontpage/statics/usercenter/js/jquery.datetimepicker.js?20160520"></script>

</head>
<body>
<!-- 网站头部 -->
<%@ include file="/jsp/frontpage/include/head.jsp" %>

<div class="wrapper wbgcolor">
	<div class="w1200 personal">
   	 <%@ include file="/jsp/frontpage/include/personalLeft.jsp"%>
		<!-- 左边-->
		<div class="m2-userCentermain" style="width: 800px;float: left;padding-left: 10px;padding-top: 10px;">
		    <script>
		        // 		$(document).ready(function(){
		        var href = window.location.href;
		        var search = window.location.search;
		        $('.m2-asideListitem ul a').each(function () {
		            if ($(this).prop('href') + search == href) {
		                if ($(this).prop('href') == "/usercenter-wangbaoqiang" || $(this).prop('href') == "/usercenter-sirendingqi") {
		                } else {
		                    $(this).parent().parent('ul').show();
		                    $(this).parent().parent('ul').prev('a').removeClass('m2-aside-item');
		                    $(this).parent().parent('ul').prev('a').addClass('m2-aside-cur');
		                    $(this).css('text-decoration', 'underline');
		                    $(this).css('color', '#0996CC');
		                }
		            }
		        });
		        $('.m2-asideListitem a:not(.m2-asideListitem ul a)').each(function () {
		            if ($(this).prop('href') + search == href) {
		                if ($(this).prop('href').search("usercenter-wangbaoqiang") > -1) {
		                    $(this).removeClass('m2-aside-wbq');
		                    $(this).addClass('m2-aside-cur');
		                } else if ($(this).prop('href').search("usercenter-sirendingqi") > -1) {
		                    $(this).removeClass('m2-aside-wbq');
		                    $(this).addClass('m2-aside-cur');
		                } else {
		                    $(this).removeClass('m2-aside-item');
		                    $(this).addClass('m2-aside-cur');
		                }
		            }
		        });
		        $('.m2-asideListitem a:not(.m2-asideListitem ul a)').click(function () {
		            if ($(this).prop('href') == '') {
		                $(this).siblings('ul').slideToggle();
		                $(this).parent().siblings('.m2-asideListitem').children('.m2-aside-secItem').slideUp();
		            }
		        });
		        // 		});
		    </script>
		
	    	<body>
		    <div class="m2-userCentermanage-con" style="margin: 0;padding: 0;"> 
		        <div class="m2-userInvit-head">
		            <h3><img src="jsp/frontpage/statics/usercenter/images/invite_friends1.png">邀请好友</h3>
		        </div>
		        <a href="#">
		            <img src="jsp/frontpage/statics/usercenter/images/invitBanner.jpg" alt="" class="m2-userInvbanner">
		        </a>
		        <div class="m2-userInvcop">
		            <div class="m2-userInv-wx">
		                <h4><div class="solid"></div>&ensp;微信邀请&ensp;<div class="solid"></div></h4>
		               <!--  <img src="jsp/frontpage/statics/market/201604/sharepicture/305497/test7138a179234e8f9529e83521edcfe217.png" alt="" width="120px;"> -->
		                <img src="/update/${users.id}.png" alt="">
		                <p>用户扫描手机二维码分享给好友</p>
		            </div>
		            <div class="m2-userInv-url">
		                <h4><div class="solid"></div>&ensp;发送邀请链接&ensp;<div class="solid"></div></h4>
		                <!-- <input class="shareCode" type="text" value="home-activity-getnewers?userfrom=yaoqinghaoyou&ukey=xrejfr" readonly> -->
		                <input class="shareCode" type="text" value="http://${ipa}:8080/rhzb/register/openRegisterPage?referrerm=${users.referrerm}" readonly>
		                <button class="weiboShare"><img src="jsp/frontpage/statics/usercenter/images/invite_friends2.png" style="vertical-align:-1px;margin-right:6px;">微博分享</button>
		                <button class="copyLink">复制邀请链接</button>
		            </div>
		        </div>
		        <div class="inviteFriendTable">
		            <div class="topclick">
		                <ul>
		                    <li index="0" class="selected" data="showcontent1">邀请记录</li>
		                    <li index="1" data="showcontent2">奖励规则</li>
		                    <li index="2" data="showcontent3">活动说明</li>
		                </ul>
		                <div class="clickanimate">
		                    <div class="sanjiao"></div>
		                </div>
		            </div>
		            <div class="showcontent1 showcontent">
		                <table>
		                    <tr style="background-color:#0996cc;color:white;height:40px;font-size:14px;">
		                        <th>好友手机号</th>
		                        <th>好友注册时间</th>
		                        <th>奖励原因</th>
		                        <th>奖励详情</th>
		                    </tr>
		                    <c:forEach items="${usera}" var="usera">
		                    	<tr>
		                    		<td>${usera.phone}</td>
		                    		<td>
		                    			<fmt:formatDate value="${usera.createTime}" pattern="yyyy-MM-dd"/>
		                    		</td>
		                    		<td>邀请好友</td>
		                    		<td>邀请红包</td>
		                    	</tr>
		                    </c:forEach>
		                </table>
		            </div>
		            <div class="showcontent2 showcontent">
		                <h5 style="margin-top:0;">奖励规则：</h5>
		                <p>1.被邀请人通过邀请人的专属链接或二维码注册爱钱帮理财平台，即为推荐人和被邀请人关系；</p>
		                <p>2.每邀请一人注册并完成首笔投资，即获得100个成长值；</p>
		                <p>3.每邀请一人注册送10元红包（投资本金满100元可用），被邀请人投资满1000元，红包即可激活使用；</p>
		                <p>4.被邀请人注册后30天内累计投资额（红包将会在第31天24点前发放到账户）。</p>
		                <h5>奖励详情：</h5>
		                <p>被邀请人投资1万-5万元（不含），邀请人获得50元红包</p>
		                <p>被邀请人投资5万-10万元（不含），邀请人获得200元红包</p>
		                <p>被邀请人投资10万-50万元（不含），邀请人获得300元红包</p>
		                <p>被邀请人投资50万元及以上，邀请人获得500元红包</p>
		            </div>
		            <div class="showcontent3 showcontent">
		                <h5 style="margin-top:0;">红包说明：</h5>
		                <p>1.红包在满足条件后24小时内发放至账户，可进行投资（红包拆分为10元-200元不等金额，使用比例1:300）;</p>
		                <p>2.发起债权转让，不计入投资总额若被邀请人对已投项目发起债权转让，该项目投资金额将不计入累计投资总额。</p>
		                <h5>活动时间：</h5>
		                <p>2018年1月1日-2018年6月30日</p>
		            </div>
		        </div>
		    </div>
		</div>  	

   	 
	</div>
</div>
<script type="text/javascript">
    //复制邀请链接
    $('.copyLink').click(function(){
        $('.shareCode').select();
        document.execCommand("Copy");
    });
    //微博分享
    $('.weiboShare').click(function(){
        var top = window.screen.height / 2 - 250;
        var left = window.screen.width / 2 - 300;
        title = "【20000元体验金】和【88元红包】免费获得地址home-activity-getnewers?userfrom=yaoqinghaoyou&ukey=xrejfr 爱钱帮平台上线两月获得盛大资本投资，并且首家实现银行存管和余额理财的平台。";
        rLink = "home-activity-getnewers?userfrom=yaoqinghaoyou&ukey=xrejfr";
        window.open("http://service.weibo.com/share/share.php?title=" +
                encodeURIComponent(title.replace(/&nbsp;/g, " ").replace(/<br \/>/g, " "))+ "&url=" + encodeURIComponent(rLink),
                "分享至新浪微博");
    });
    // 点击内容切换的方法
    $(".inviteFriendTable .topclick li").click(function(){
        var index=parseInt($(this).attr("index"))*140+"px";
        var data=".inviteFriendTable ."+$(this).attr("data");
        $(".inviteFriendTable .topclick li").removeClass("selected");
        $(this).addClass("selected");
        $(".inviteFriendTable .clickanimate").animate({left:index},400);
        $(".inviteFriendTable .showcontent").hide();
        $(data).show();
    });
    //展示红包拆分详细
    $(".showcontent1").on("mouseover",".inviteExplain",function(){
        $(this).css("z-index","2");
        $(this).css("color","#5e98ff").find(".explainContent").show();
    });
    $(".showcontent1").on("mouseout",".inviteExplain",function(){
        $(this).css("z-index","0")
        $(this).css("color","#646464").find(".explainContent").hide();
    });

    var start = 2;
    //加载更多按钮
    $(".loadMore").click(function(){
        getInviteRecord();
    });
    //获取邀请记录流水
    function getInviteRecord(){
        console.log(start);
        $.ajax({
            url:"/usercenter-Invitefriends-getInviteLogAjax",
            type:"POST",
            data:{
                start:start
            },
            success:function(data){
                processData(data);
            }
        });
    }

    function processData(data){
        obj = eval('('+data+')');
        start++;
        var pages = obj['pages'];
        checkBtn(pages);
        showData(obj['data']);
    }

    function showData(obj){
        var tr='';
        if(obj){
            for(var i in obj){
                tr += '<tr>';
                tr += '<td>'+obj[i]['user_phone']+'</td>';
                tr += '<td>'+obj[i]['reg_time']+'</td>';
                tr += '<td>';
                tr += '<span>好友注册</span>';
                if(obj[i]['flag']=='1'){
                    tr += '<span>&nbsp;好友投资</span>';
                }
                tr += '</td>';
//					tr += '<td>好友注册&nbsp;短信邀请&nbsp;好友投资</td>';
                tr += '<td class="right">';
                tr += '<span>10元红包&nbsp;'+obj[i]['getReward3']+'&nbsp;</span>';
//				    tr += '<span>10元红包&nbsp;'+obj[i]['getReward2']+'&nbsp;'+obj[i]['getReward3']+'&nbsp;</span>';
                if(obj[i]['getReward4']!=''){
                    tr +=  '<div class="inviteExplain">';
                    tr +=  '<span>'+obj[i]['getReward4']+'</span>';
                    tr +=  '<div class="explainContent">';
//			    		   tr +=  '<img src="'+obj[i]['image']+'/images/invite_friends4.png">';
                    tr +=  '<img src="http://www.iqianbang.com/statics/usercenter/images/invite_friends4.png">';
                    if(obj[i]['getReward4']=='500元红包'){
                        tr +=   '<span>10元红包X3&nbsp;20元红包&nbsp;50元红包&nbsp;100元红包X2&nbsp;200元红包</span>';
                    }else if(obj[i]['getReward4']=='300元红包'){
                        tr +=   '<span>10元红包X3&nbsp;20元红包&nbsp;50元红包&nbsp;100元红包X2</span>';
                    }else if(obj[i]['getReward4']=='200元红包'){
                        tr +=   '<span>10元红包X3&nbsp;20元红包&nbsp;50元红包</span>';
                    }else{
                        tr +=   '<span>10元红包X3&nbsp;20元红包</span>';
                    }
                    tr +=  '</div>';
                    tr +=  '</div>';
                    tr +=   '<div class="inviteCircle">?</div>';
                }
                tr += '</td>';
                tr += '</tr>';
            }
            $(".showcontent1 table").append(tr);
        }
    }

    function checkBtn(pages){
        if(start > pages){
            $('.loadMore').hide();
        }
    }
</script>

<!--网站底部-->
<%@ include file="/jsp/frontpage/include/foot.jsp"%>
</body>
</html>