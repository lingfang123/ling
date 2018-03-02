<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%String path=request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=path %>/">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>金元宝网贷平台</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="jsp/frontpage/css/common.css" rel="stylesheet" />
<link href="jsp/frontpage/css/index.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="jsp/frontpage/script/jquery.min.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/common.js"></script>

<link rel="stylesheet" href="jsp/frontpage/css/style.css" />
<script src="jsp/frontpage/script/javasrcipt.js" type="text/javascript"></script>

<style>
/*上下滚动*/
#scrollDiv {
	width: 400px;
	height: 30px;
	line-height: 30px;
	overflow: hidden;
}
#scrollDiv li {
	height: 30px;
	padding-left: 10px;
}

    .userimg{width:80px;height:80px;border-radius:80px}
</style>
<script type="text/javascript">
// 上下滚动
function AutoScroll(obj) {
    $(obj).find("ul:first").animate({
        marginTop: "-25px"
    },
    500,
    function() {
        $(this).css({
            marginTop: "0px"
        }).find("li:first").appendTo(this);
    });
}
$(document).ready(function() {
    var myar = setInterval('AutoScroll("#scrollDiv")', 3000);
    $("#scrollDiv").hover(function() {
        clearInterval(myar);
    },
    function() {
        myar = setInterval('AutoScroll("#scrollDiv")', 3000)
    }); //当鼠标放上去的时候，滚动停止，鼠标离开的时候滚动开始
});


//页面加载之后,设置.样式.  
jQuery(function(){  
	 $("aside h2").each(function(i){  
        //获取td当前对象的文本,如果长度大于25;  
        if($(this).text().length>20){  
	      //给td设置title属性,并且设置td的完整值.给title属性.  
	       $(this).attr("title",$(this).text());  
              //获取td的值,进行截取。赋值给text变量保存.  
               var text=$(this).text().substring(0,20)+"...";  
              //重新为td赋值;  
              $(this).text(text);  
	        }  
	     });
	
    $("aside p").each(function(i){  
       if($(this).text().length>25){  
		//$(this).attr("title",$(this).text());  
	     var text=$(this).text().substring(0,25)+"...";  
          $(this).text(text);  
         }  
      });  
   
});  



</script>
</head>
<body>
<%@ include file="/jsp/frontpage/include/head.jsp"%>
<!--banner------------------------------------------------------------------------------------------------------------>
	<div class="banner" id="banner">
    	<a href="javascript:(0)" class="focus">
       	<div class="left" id="left" onclick="left()"></div>
       	<ul>
            	<li><em id="em1" onclick="Focus1()" style="background-color:#888"></em></li>
                <li><em id="em2" onclick="Focus2()"></em></li>
                <li><em id="em3" onclick="Focus3()"></em></li>
                <li style="margin-right:0px;"><em id="em4" onclick="Focus4()"></em></li>
            </ul>
            <div class="right" id="right" onclick="right()"></div>
        </a>
    </div>
<!--announcement------------------------------------------------------------------------------------------------------>
	<!--<div class="announcement">
    	<p>最新公告</p>
        <a href="javascript:(0)"><span>关于中国民生银行P2P网络资金存管系统部分时间段无法使用的重要通知</span></a>
        <a href="javascript:(0)" style="float:right;">更多</a>
    </div>-->
    <!--  最新公告 -->
    <div class="new-announcement" style="width: 1000px;border-radius:0">
	  <div class="new-announcement-title">最新公告</div>
	  <div class="new-announcement-content">
	    <div id="scrollDiv">
	      <ul style="margin-top: 0px;">
	      	<c:forEach items="${listN}" var="listN">
	        	<li><a class="black-link" href="noticeCompany/noticeById?id=${listN.nid}">${listN.newsname}</a></li>
	        </c:forEach>
	      </ul>
	    </div>
	  </div>
	  <a class="more" href="noticeCompany/openNotice">更多</a> 
    </div>

	<!---->
    <div class="ipubs">
    	<span class="o1">累计投资金额:<strong>
    		<fmt:formatNumber type="number" value="${sumMoney}" pattern="0.00" maxFractionDigits="2"/>
    	</strong>万元</span>
    	<span class="o2">已还本息:<strong>${sumPrincipal}</strong>万元</span>
    	<span class="o2">平台为用户赚取:<strong>${sumZqmoney}</strong>万元</span>
    	<span class="o4">注册人数:<strong>${userCount}</strong>人</span>
    </div>
<!--main-------------------------------------------------------------------------------------------------------------->
<div class="main">
  	<div class="title">
      	<h1>${listMark[0].markname}</h1>
          <p>盒子正在努力审核项目，预计项目发布时间 <span>10:00</span> , <span>13:00</span> , <span>16:00</span> , <span>20:00</span>，其余时间与周末随机发标。</p>
          <a href="markinfo/listMarkInfoByMarkid?markid=${listMark[0].id}">更多</a>
      </div>
  	<div class="regular">
     		<a class="regular-thear" href="markinfo/listMarkInfoByMarkid?markid=${listMark[0].id}">
        		<ol>
              	<li>产品丰富</li>
                  <li>期限多样</li>
                  <li>尽职风控</li>
                  <li style="font-size:12px;">更多${listMark[0].markname}> </li>
              </ol>
      	</a>
          <ul>
	          <c:forEach items="${listMarkInfo0}" var="markinfo0" begin="0" end="3">
	          	<li>
	          		<c:if test="${markinfo0.countmoney==markinfo0.money}">
	            		<a href="markinfo/info?markid=${listMark[0].id}&id=${markinfo0.id}">${markinfo0.headline}</a>
	            	</c:if>
	            	<c:if test="${markinfo0.countmoney<markinfo0.money}">
	            		<a href="markinfo/info2?markid=${listMark[0].id}&id=${markinfo0.id}">${markinfo0.headline}</a>
	            	</c:if>
	              	<br/>
	                  <p>
	                  	<c:if test="${markinfo0.paymentMode eq 1}">等额本息</c:if>
				  		<c:if test="${markinfo0.paymentMode eq 2}">先息后本</c:if>
	                  </p>
	                  <meter max="100" min="0" value='<fmt:formatNumber type="number" value="${markinfo0.countmoney/markinfo0.money*100}" pattern="0.00" maxFractionDigits="2"/>' high="66" low="33" optimum="1"></meter>
	                  <figcaption>${markinfo0.countmoney} / ${markinfo0.money/10000}万</figcaption>
	                  <div class="earnings">
	                  	<h2>${markinfo0.accrual}</h2>
	                      <h2>${markinfo0.borrowtime}</h2>
	                      <h3>年化利率(%)</h3>
	                      <h3>项目期限(月)</h3>
	                  </div>
	                  <c:if test="${markinfo0.countmoney==markinfo0.money}">
	            		<a class="tender" href="markinfo/info?markid=${listMark[0].id}&id=${markinfo0.id}">还款中</a>
	            	  </c:if>
	            	  <c:if test="${markinfo0.countmoney<markinfo0.money}">
	            		<a class="tender" href="markinfo/info2?markid=${listMark[0].id}&id=${markinfo0.id}">立即投标</a>
	            	  </c:if>
	              </li>
	          </c:forEach>
          </ul>
      </div>
        
        <div class="title">
            <h1>${listMark[1].markname}</h1>
            <a href="markinfo/listMarkInfoByMarkid?markid=${listMark[1].id}">更多</a>
        </div>
      	<div class="regular">
        	<a class="regular-thear" href="markinfo/listMarkInfoByMarkid?markid=${listMark[1].id}">
            	<ol>
                	<li>紧随市场</li>
                    <li>海量牛基</li>
                    <li>热点聚集</li>
                    <li style="font-size:12px;">更多${listMark[1].markname}> </li>
                </ol>
            </a>
            <ul>
            	<c:forEach items="${listMarkInfo1}" var="markinfo1" begin="0" end="3">
	          	<li>
	          		<c:if test="${markinfo1.countmoney==markinfo1.money}">
	            		<a href="markinfo/info?markid=${listMark[1].id}&id=${markinfo1.id}">${markinfo1.headline}</a>
	            	</c:if>
	            	<c:if test="${markinfo1.countmoney<markinfo1.money}">
	            		<a href="markinfo/info2?markid=${listMark[1].id}&id=${markinfo1.id}">${markinfo1.headline}</a>
	            	</c:if>
	            	<br/>
	                  <p>
	                  	<c:if test="${markinfo1.paymentMode eq 1}">等额本息</c:if>
				  		<c:if test="${markinfo1.paymentMode eq 2}">先息后本</c:if>
	                  </p>
	                  <meter max="100" min="0" value='<fmt:formatNumber type="number" value="${markinfo1.countmoney/markinfo1.money*100}" pattern="0.00" maxFractionDigits="2"/>' high="66" low="33" optimum="1"></meter>
	                  <figcaption>${markinfo1.countmoney} / ${markinfo1.money/10000}万</figcaption>
	                  <div class="earnings">
	                  	<h2>${markinfo1.accrual}</h2>
	                      <h2>${markinfo1.borrowtime}</h2>
	                      <h3>年化利率(%)</h3>
	                      <h3>项目期限(月)</h3>
	                  </div>
	                  <c:if test="${markinfo1.countmoney==markinfo1.money}">
	            		<a class="tender" href="markinfo/info?markid=${listMark[1].id}&id=${markinfo1.id}">还款中</a>
	            	  </c:if>
	            	  <c:if test="${markinfo1.countmoney<markinfo1.money}">
	            		<a class="tender" href="markinfo/info2?markid=${listMark[1].id}&id=${markinfo1.id}">立即投标</a>
	            	  </c:if>
	              </li>
	          </c:forEach>
          </ul>
        </div>
   <!---------------------新闻公告------------------------------------------->
  		<div class="title">
        	<h1>新闻</h1>
			<a href="javascript:(0)">更多</a>
        </div>
        <div id="newcompany" class="pocket">
        	<a class="pocket-thear" href="javascript:(0)">
            	<ol>
                	<li>大咖云集</li>
                    <li>见微知著</li>
                    <li>智慧投资</li>
                    <li style="font-size:12px;">更多新闻> </li>
                </ol>
            </a>
            <ul>
            
            <c:forEach items="${listNew}" var="l" begin="0" end="3" varStatus="i">
	               <a href="javascript:(0)" 
		               style="
		               <c:if test="${i.index==1 }">border-right:solid 1px #E5E5E5;border-bottom:solid 1px #E5E5E5;</c:if> 
		               <c:if test="${i.index==2 }">border-bottom:solid 1px #E5E5E5;</c:if> 
		               <c:if test="${i.index==3 }">border-right:solid 1px #E5E5E5;</c:if> 
	               ">
	               		
	                	<article >
							<img class="userimg" src="${l.employeeCompany.employeeImg }"/>
	                        <figcaption>${l.employeeCompany.nickname }</figcaption>
	                    </article>
	                    <aside>
	                    	<h2 >${l.newtitle }</h2>
	                        <p>${l.content }</p>
	                        <h3>阅读1005&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;赞82&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;评论7</h3>
	                    </aside>
	                </a>
	            </c:forEach>
            
            </ul>
    	</div>
    </div>
<!--row--------------------------------------------------------------------------------------------------------------->
	<div class="row">
    	<ul>
        	<li>
            	<h1>极速开户</h1>
              <p>超低佣金，实时风投行情</p>
              <img src="jsp/frontpage/images/stock.png" />
              <figcaption>开户</figcaption>
              <!--  !empty userInfo -->
              <c:if test="${not empty userInfo}">  
              	  <a href="<c:if test="${userInfo.openAccount eq null || userInfo.openAccount eq ''}">user/thirdParty</c:if><c:if test="${userInfo.openAccount ne null && userInfo.openAccount ne ''}">javascript:return false;</c:if>">查看详情</a>
              </c:if>
              <c:if test="${empty userInfo}">  
              	   <a href="user/thirdParty">查看详情</a>
              </c:if>
              	
       	  </li>
            <li>
           	  <h1>长期趋势</h1>
                <p>价值投资</p>
              <img src="jsp/frontpage/images/invest.png" />
              <figcaption>前沿投资</figcaption>
              <a href="markinfo/markInfoes?currentPage=1">查看详情</a>
          </li>
            <li style="border-right:none;">
           	  <h1>在线贷款</h1>
                <p>无抵押、10分钟放款</p>
              <img src="jsp/frontpage/images/second.png" />
              <figcaption>读秒</figcaption>
              <a href="user/userLoan">查看详情</a>
          </li>
        </ul>
    </div>
<!--content-wrap------------------------------------------------------------------------------------------------------>
	<div class="content-wrap">
  		<div class="c-wrap">
   			<h1>合作机构</h1>
        	<div class="scroll">
          		<a href="javascript:(0)" class="left2" onclick="left2()"></a>
              	<div>
              		<img id="roll1" src="jsp/frontpage/images/wrap-广发基金.gif" />
                    <img id="roll2" src="jsp/frontpage/images/wrap-华夏基金.gif" />
                    <img id="roll3" src="jsp/frontpage/images/wrap-建信基金.gif" />
                    <img id="roll4" src="jsp/frontpage/images/wrap-汇添富基金.gif" />
                    <img id="roll5" src="jsp/frontpage/images/wrap-鹏华基金.gif" />
                    <img id="roll6" src="jsp/frontpage/images/wrap-工银瑞信.gif" />
              	</div>
              	<a href="javascript:(0)" class="right2" onclick="right2()"></a>
       		</div>
      	</div>
    </div>
<!--网站底部-->
<%@ include file="/jsp/frontpage/include/foot.jsp"%>
</body>
</html>