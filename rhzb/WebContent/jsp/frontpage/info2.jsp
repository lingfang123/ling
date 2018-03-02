<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=path%>/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>详细信息</title>
<link href="jsp/frontpage/css/common.css" rel="stylesheet" />
<link href="jsp/frontpage/css/index.css" rel="stylesheet" type="text/css">
<link href="jsp/frontpage/css/detail.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="jsp/frontpage/script/jquery.min.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/common.js"></script>

<style type="text/css">
	
</style>
<script type="text/javascript">
	window.onload = function myFunction(){
		
		$('#all').click(function(){
			if(${userMoney.usableMoney} >= ${markInfo2.money-markInfo2.countmoney}){
				$('#money').val($('#needMoney').html().trim());
			}else{
				$('#money').val(${userMoney.usableMoney});
			}
			var money = $('#money').val().trim();
			if(${markInfo2.paymentMode==2}){
				var willMoney = (money*${markInfo2.accrual/100}*${markInfo2.borrowtime/12}).toFixed(2);
			}else{
				//总利息=〔(总贷款额÷还款月数+总贷款额×月利率)+总贷款额÷还款月数×(1+月利率)〕÷2×还款月数-总贷款额
				var willMoney = (((money/${markInfo2.borrowtime}+money*${markInfo2.accrual/100}/12)+money/${markInfo2.borrowtime}*(1+${markInfo2.accrual/100}/12))/2*${markInfo2.borrowtime}-money).toFixed(2);
			}
			$('#willMoney').html(willMoney);
			
			if(${redeList!=null}){
				if(money>0){	
					$.ajax({
						url:'redenvelope/endMoney',
						type:'post',
						data:{'moneym':money},
						dataType:'json',
						success:function(result){
							var m = money-Number(result);
							$('#endMoney').html(m);
						}
					});
				}
			}
		});
		$('#money').bind('input propertychange', function() {  
			var money = $('#money').val().trim();
			
			if(${userMoney.usableMoney}>=money){
				if(money<=${markInfo2.money-markInfo2.countmoney}){
					if(${markInfo2.paymentMode==2}){
						var willMoney = (money*${markInfo2.accrual/100}*${markInfo2.borrowtime/12}).toFixed(2);
					}else{
						//总利息=〔(总贷款额÷还款月数+总贷款额×月利率)+总贷款额÷还款月数×(1+月利率)〕÷2×还款月数-总贷款额
						var willMoney = (((money/${markInfo2.borrowtime}+money*${markInfo2.accrual/100}/12)+money/${markInfo2.borrowtime}*(1+${markInfo2.accrual/100}/12))/2*${markInfo2.borrowtime}-money).toFixed(2);
					}
					$('#willMoney').html(willMoney);
				}else{
					$('#money').val(${markInfo2.money-markInfo2.countmoney});
					var money2 = $('#money').val().trim();
					if(${markInfo2.paymentMode==2}){
						var willMoney = (money2*${markInfo2.accrual/100}*${markInfo2.borrowtime/12}).toFixed(2);
					}else{
						//总利息=〔(总贷款额÷还款月数+总贷款额×月利率)+总贷款额÷还款月数×(1+月利率)〕÷2×还款月数-总贷款额
						var willMoney = (((money2/${markInfo2.borrowtime}+money2*${markInfo2.accrual/100}/12)+money2/${markInfo2.borrowtime}*(1+${markInfo2.accrual/100}/12))/2*${markInfo2.borrowtime}-money2).toFixed(2);
					}
					$('#willMoney').html(willMoney);
				}
			}else{
				$('#money').val(${userMoney.usableMoney});
				var money1 = $('#money').val().trim();
				if(${markInfo2.paymentMode==2}){
					var willMoney = (money1*${markInfo2.accrual/100}*${markInfo2.borrowtime/12}).toFixed(2);
				}else{
					//总利息=〔(总贷款额÷还款月数+总贷款额×月利率)+总贷款额÷还款月数×(1+月利率)〕÷2×还款月数-总贷款额
					var willMoney = (((money1/${markInfo2.borrowtime}+money1*${markInfo2.accrual/100}/12)+money1/${markInfo2.borrowtime}*(1+${markInfo2.accrual/100}/12))/2*${markInfo2.borrowtime}-money1).toFixed(2);
				}
				$('#willMoney').html(willMoney);
			}
			if(${redeList!=null}){
				var moneym = $('#money').val().trim();
				if(moneym>0){
					$.ajax({
						url:'redenvelope/endMoney',
						type:'post',
						data:{'moneym':moneym},
						dataType:'json',
						success:function(result){
							var m = moneym-Number(result);
							$('#endMoney').html(m);
						}
					});
				}
			}
		});
		/* 点击投标 */
		$('#submit').click(function(){
			var money = $('#money').val().trim();
			if(${user!=null} && ${markInfo2.money!=markInfo2.countmoney}){
				if(${user.id!=markInfo2.userid}){
					if(money>0){
						if(money<=${userMoney.usableMoney}){
							if(money >= ${markInfo2.investmin}){
								$.ajax({
									url:'userInvest',
									type:'post',
									data:{'money':money,'markinfoId':${markInfo2.id},'overduemoney':$('#willMoney').html()},
									dataType:'json',
									success:function(result){
										alert("投资成功！");
										location.href = "http://localhost:8080/rhzb/markinfo/markInfoes";
									}
								});
							}else{
								alert(${markInfo2.investmin}+"起投！");
							}
						}else{
							alert("余额不足！");
						}
					}else{
						alert("请输入您的投资金额！");
					}
				}else{
					alert("本人不能投自己的标！");
				}
			}
		});
	}
	
</script>

</head>
<body>
<!-- 网站头部 -->
<%@ include file="/jsp/frontpage/include/head.jsp"%>
	<div class="item-detail wrap">
	  <div class="breadcrumbs"> <a href="index/frontpage">首页</a>&gt; <a href="markinfo/listMarkInfoByMarkid?markid=${mark.id}">${mark.markname}投资列表</a>&gt; <span class="cur">项目详情</span> </div>
	  <div class="item-detail-head clearfix" data-target="sideMenu">
	    <div class="hd"> <i class="icon icon-che" title="车易贷"></i>
	      <h2><span style="opacity:0.5;font-size: 0.7em">(编号：${markInfo2.backup1})</span></h2>
	    </div>
	    <div class="bd clearfix">
	      <div class="data">
	        <ul>
	          <li> <span class="f16">年化率 </span></span><br>
	            <span class="f30 c-333" id="account">${markInfo2.accrual}%</span></li>
	          <li class="relative"><span class="f16">借款期限</span><br>
	            <span class="f30 c-orange">${markInfo2.borrowtime}</span>个月</li>
	          <li><span class="f16">借款额度</span><br>
	            <span class="f30 c-333">
	            	<fmt:formatNumber type="number" value="${markInfo2.money}" pattern="0.00" maxFractionDigits="2"/>
	            </span>元 
	          </li>
	           
	          <li class="colspan" style="width: 750px"> 
	          	<span class="c-888 fl">投标进度：</span>
	            	<meter id="myMeter" min="0" max="100" low="30" high="80" value='<fmt:formatNumber type="number" value="${markInfo2.countmoney/markInfo2.money*100}" pattern="0.00" maxFractionDigits="2"/>'  style="width:80%;"></meter>
	            <span class="c-green" id="demo">
	            	<fmt:formatNumber type="number" value="${markInfo2.countmoney/markInfo2.money*100}" pattern="0.00" maxFractionDigits="2"/>
	            </span>%
	          </li>
	          
	          <li><span class="c-888">借款标题：</span>${markInfo2.headline}</li>
	          <li><span class="c-888">起投时间：</span><fmt:formatDate value="${markInfo2.starttime}" pattern="yyyy-MM-dd"/></li>
	          <li><span class="c-888">截止时间：</span> <span id="account_range"><fmt:formatDate value="${markInfo2.deadline}" pattern="yyyy-MM-dd"/></span></li>
	          <li><span class="c-888">还款方式：</span>
	          	<c:if test="${markInfo2.paymentMode == 1}">等额本息</c:if>
			    <c:if test="${markInfo2.paymentMode == 2}">先息后本</c:if>
	          </li>
	           <li><span class="c-888">项目评级：</span>${markInfo2.projectrating}</li>
	           <li><span class="c-888">风投意见：</span>${markInfo2.vcopinion}</li>
	        </ul>
	      </div>
	      
	      <div class="mod-right mod-status" style="padding-top:0;background-color: #F4F5F4;width: 400px;height: 290px;border-radius: 8px">
	        <div class="inner">
	          <div class="text"><span style="font-size:20px;font-weight: bold">还需金额：</span><span id="needMoney" style="font-size:20px;font-weight: bold">
	          	<fmt:formatNumber type="number" value="${markInfo2.money-markInfo2.countmoney}" pattern="0.00" maxFractionDigits="2"/>
	          </span>元<br>
	           您当前可用：<c:if test="${user!=null}"><fmt:formatNumber type="number" value="${userMoney.usableMoney}" pattern="0.00" maxFractionDigits="2"/></c:if>
	           <c:if test="${user==null}"><a href="login/userLogin" style="color:#00B389">登录</a> 后可见</c:if>
	           <span style="color:#ccc;margin: 5px">|</span><span class="" style="color:#00B389">起投金额：${markInfo2.investmin}</span> 元 <br>
	          	<input type="number" id="money" placeholder="${markInfo2.investmin}元起投" style="border:1px solid #514E4E;height: 40px;width: 220px;border-radius: 4px;line-height: 40px;font-size:20px;font-weight: bold" onkeyup="var p2 = parseFloat(value).toFixed(2);value = p2>=0?(/\.0?$/.test(value)?value:p2.replace(/0$/,'').replace(/\.0$/,'')):''" onblur="value = value.replace(/\.0*$/,'')" />
	         	<a id="all" style="border: 1px solid #514E4E;display: inline-block;width: 80px;margin-left: 12px;background: #514E4E;color: #FFF;text-align: center;border-radius: 4px;height: 40px;line-height: 40px;">全额</a><br>
         		<span style="color: #ff5900;font-size: 0.6em;">预计收益：</span>
         		<span id="willMoney" style="color: #ff5900;font-size: 0.8em;"></span>&nbsp;&nbsp;&nbsp;
	         	<c:if test="${user!=null}">	
	         		<select id="rede" style="background-color:red;border:1px solid #514E4E;height: 20px;width: 80px;border-radius: 4px;line-height: 20px;font-size:10px;font-weight: bold">
		         		<c:if test="${redeList==null}">
		         			<option>无可用红包</option>
		         		</c:if>
		         		<c:if test="${redeList!=null}">
		         			<option>我的红包</option>
		         		</c:if>
		         		<c:forEach items="${redeList}" var="rede">
		         			<option value="${rede.id}">投${rede.minmoney}——${rede.tjmoney}减${rede.hbmoney}</option>
		         		</c:forEach>
	         		</select><br>
	         		<span style="color: blue;font-size: 1px;">账户实减:</span>
	         		<span id="endMoney" style="color:#ff5900;font-size: 1px;"></span>
	         		<span style="color:red;font-size: 1px;height: 10;">注意：红包自动抵扣，不可叠加</span>
	         	</c:if>
	         	<br>
	         	<a id="submit" href="javascript:(0);" style="display: inline-block;line-height: 45px;font-size: 16px;text-align: center;width: 320px;height: 45px; background: #00B389;border-radius: 4px;color: #FFF">确认投资</a><br>
	         	<c:if test="${user==null}">
	         		<a href="login/userLogin"><span style="color:red;font-size:4px;height: 5px;">想理财，请先登录！</span></a><br/>
	         	</c:if>
	         	<input type="checkbox" checked="checked">
	         	<span style="font-size: 4px;line-height: 10px;">我已经查看并同意<span style="color:#00B389">《众易贷用户投标须知》《风险告知书》 《借款协议》</span></span>
	         </div>
	      </div>
	      
	      
	    </div>
	  </div>
	  <div class="item-detail-body clearfix mrt30 ui-tab">
	    <div class="ui-tab-nav hd"> <i class="icon-cur" style="left: 39px;"></i>
	      <ul>
	        <li class="nav_li active" id="nav_1"><a href="javascript:;">借款信息</a></li>
	        <li class="nav_li" id="nav_2"><a href="javascript:;">投资记录</a> <i class="icon icon-num1" style="margin-left: -15px;"> <span id="tender_times">23</span> <em></em> </i> </li>
	      </ul>
	    </div>
	    <div class="bd">
	      <div class="ui-tab-item active" style="display: block;">
	        <div class="borrow-info">
	          <dl class="item">
	            <dt>
	              <h3>借款人介绍</h3>
	            </dt>
	            <dd>
	              <div class="text">
	                <p class="MsoNormal" style="margin-left:0cm;text-indent:0cm;"> 借款人信息介绍：</p>
	                <p class="MsoNormal" style="margin-left:0cm;text-indent:0cm;"> 借款人${applyfor.bystr}，大专学历，未婚，户籍地址为四川省古蔺县，现居住于成都市成华区。</p>
	                <p class="MsoNormal" style="margin-left:0cm;text-indent:0cm;"> 借款人工作情况：</p>
	                <p class="MsoNormal" style="margin-left:0cm;text-indent:0cm;"> ${applyfor.bystr}为成都某服装店老板，月收入<span>2</span>万元，收入居住稳定。</p>
	                <p class="MsoNormal" style="margin-left:0cm;text-indent:0cm;"> 借款人资产介绍：</p>
	                <p class="MsoNormal" style="margin-left:0cm;text-indent:0cm;"> ${applyfor.bystr}有<span>1</span>辆全款长安福特福克斯汽车。</p>
	                <p class="MsoNormal" style="margin-left:0cm;text-indent:0cm;"> 详细资金用途：</p>
	                <p class="MsoNormal" style="margin-left:0cm;text-indent:0cm;"> 借款人申请汽车质押贷款，贷款用于资金周转。</p>
	              </div>
	            </dd>
	          </dl>
	          <dl class="item">
	            <dt>
	              <h3>审核信息</h3>
	            </dt>
	            <dd>
	              <div class="verify clearfix">
	                <ul>
	                  <li><i class="icon icon-4"></i><br>
	                    身份证</li>
	                  <li><i class="icon icon-5"></i><br>
	                    户口本</li>
	                  <li><i class="icon icon-6"></i><br>
	                    结婚证</li>
	                  <li><i class="icon icon-7"></i><br>
	                    工作证明</li>
	                  <li><i class="icon icon-8"></i><br>
	                    工资卡流水</li>
	                  <li><i class="icon icon-9"></i><br>
	                    收入证明</li>
	                  <li><i class="icon icon-10"></i><br>
	                    征信报告</li>
	                  <li><i class="icon icon-11"></i><br>
	                    亲属调查</li>
	                  <li><i class="icon icon-19"></i><br>
	                    行驶证</li>
	                  <li><i class="icon icon-20"></i><br>
	                    车辆登记证</li>
	                  <li><i class="icon icon-21"></i><br>
	                    车辆登记发票</li>
	                  <li><i class="icon icon-22"></i><br>
	                    车辆交强险</li>
	                  <li><i class="icon icon-23"></i><br>
	                    车辆商业保险</li>
	                  <li><i class="icon icon-24"></i><br>
	                    车辆评估认证</li>
	                </ul>
	              </div>
	            </dd>
	          </dl>
	          <dl class="item">
	            <dt>
	              <h3>风控步骤</h3>
	            </dt>
	            <dd>
	              <div class="text">
	                <p class="MsoNormal" style="margin-left:0cm;text-indent:0cm;"> 调查：风控部对借款人各项信息进行了全面的电话征信，一切资料真实可靠。<span></span> </p>
	                <p class="MsoNormal" style="margin-left:0cm;text-indent:0cm;"> 抵押物：全款长安福特福克斯汽车，车牌号：川<span>AYY***</span>，新车购买于<span>2013</span>年，裸车价<span>14</span>万，评估价<span>5</span>万。 </p>
	                <p class="MsoNormal" style="margin-left:0cm;text-indent:0cm;"> 权证：汽车已入库、已办理相关手续等。 </p>
	                <p class="MsoNormal" style="margin-left:0cm;text-indent:0cm;"> 担保：质押物担保。 </p>
	                <p class="MsoNormal" style="margin-left:0cm;text-indent:0cm;"> 结论：此客户为老客户，上笔贷款<span>4</span>万元，标的号为<span>20150745682</span>，已结清，现因资金周转，再次申请贷款。借款人居住稳定，收入来源可靠，经风控综合评估，同意放款<span>4</span>万。 </p>
	                <p class="MsoNormal" style="margin-left:0cm;text-indent:0cm;"> 保障：借款逾期<span>48</span>小时内，易贷风险准备金先行垫付。 </p>
	              </div>
	              <div class="step clearfix">
	                <ul>
	                  <li><i class="icon icon-1"></i>资料审核</li>
	                  <li><i class="icon icon-2"></i>实地调查</li>
	                  <li><i class="icon icon-3"></i>资产评估</li>
	                  <li class="no"><i class="icon icon-4"></i>发布借款</li>
	                </ul>
	              </div>
	              <div class="conclusion f16"> 结论：经风控部综合评估， <span class="c-orange">同意借款<fmt:formatNumber type="number" value="${markInfo2.money}" pattern="0.00" maxFractionDigits="2"/>元。</span>
	              <!-- <i class="icon icon-status icon-status1"></i> --> </div>
	            </dd>
	          </dl>
	          <dl class="item">
	            <dt>
	              <h3>权证信息</h3>
	            </dt>
	            <dd>
	              <div class="warrant"> <span class="f14 c-888">（注：为保护借款人的个人隐私信息，实物材料对部分信息进行了隐藏处理）</span>
	                <div class="album" id="album">
	                  <div class="album-show">
	                    <div class="loading" style="display: none;"></div>
	                    <img src="images/news.jpg"> </div>
	                  <div class="album-thumb"> <a href="javascript:;" class="btn btn-prev"></a> <a href="javascript:;" class="btn btn-next"></a>
	                    <div style="visibility: visible; overflow: hidden; position: relative; z-index: 2; left: 0px; width: 1070px;" class="container" id="albumThumb">
	                      <ul style="margin: 0px; padding: 0px; position: relative; list-style-type: none; z-index: 1; width: 1926px; left: 0px;">
	                        <li style="overflow: hidden; float: left; width: 164px; height: 108px;"><a class="small_img" id="images/news.jpg"><img src="images/news.jpg"></a></li>
	                        <li style="overflow: hidden; float: left; width: 164px; height: 108px;"><a class="small_img" id="images/news.jpg"><img src="images/news.jpg"></a></li>
	                        <li style="overflow: hidden; float: left; width: 164px; height: 108px;"><a class="small_img" id="images/news.jpg"><img src="images/news.jpg"></a></li>
	                        <li style="overflow: hidden; float: left; width: 164px; height: 108px;"><a class="small_img" id="images/news.jpg"><img src="images/news.jpg"></a></li>
	                        <li style="overflow: hidden; float: left; width: 164px; height: 108px;"><a class="small_img" id="images/news.jpg"><img src="images/news.jpg"></a></li>
	                        <li style="overflow: hidden; float: left; width: 164px; height: 108px;"><a class="small_img" id="images/news.jpg"><img src="images/news.jpg"></a></li>
	                        <li style="overflow: hidden; float: left; width: 164px; height: 108px;"><a class="small_img" id="images/news.jpg"><img src="images/news.jpg"></a></li>
	                        <li style="overflow: hidden; float: left; width: 164px; height: 108px;"><a class="small_img" id="images/news.jpg"><img src="images/news.jpg"></a></li>
	                        <li style="overflow: hidden; float: left; width: 164px; height: 108px;"><a class="small_img" id="images/news.jpg"><img src="images/news.jpg"></a></li>
	                      </ul>
	                    </div>
	                  </div>
	                </div>
	              </div>
	            </dd>
	          </dl>
	        </div>
	      </div>
	      
	      <div class="ui-tab-item" style="display: none;">
	        <div class="repayment-list"> 目前投标总额：
		        <span class="c-orange">
					<fmt:formatNumber type="number" value="${markInfo2.money}" pattern="0.00" maxFractionDigits="2"/>
				</span>&nbsp;&nbsp;剩余投标金额：
	            <span class="c-orange">
	            	<fmt:formatNumber type="number" value="${markInfo2.money-markInfo2.countmoney}" pattern="0.00" maxFractionDigits="2"/>
	            </span>
	          <table border="0" cellpadding="0" cellspacing="0" width="100%">
	            <tbody>
	              <tr>
	                <th>投标人</th>
	                <th>投标金额</th>
	                <th>投标时间</th>
	                <th>投标方式</th>
	              </tr>
	            </tbody>
	            <tbody id="repayment_content">
	              <c:forEach items="${investList.lists}" var="invest">
		              <tr>
		                <td>${(invest.username).subSequence(0,1)}**</td>
		                <td><span class="c-orange">￥${invest.markmoney}</span></td>
		                <td>
		                	<fmt:formatDate value="${invest.bidtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
		                </td>
		                <td>手动</td>
		              </tr>
	              </c:forEach>
	            </tbody>
	            <%-- <tfoot>
	              <tr class="page-outer">
	                <td colspan="4" align="center">
		                <div class="pagination clearfix">
			                <span class="page" id="repayment_content_pager">
			                	<c:if test="${investList.currPage>1}">
				                	<a href="markinfo/info2?id=${markInfo2.id}&markid=${mark.id}&curPage=${investList.currPage-1}" class="disabled">上一页 </a>
				                </c:if>
				                <c:forEach var="i" begin="1" end="${investList.totalPage}" step="1">
				                	<a href="markinfo/info2?markid=${mark.id}&id=${markInfo2.id}&curPage=${i}" <c:if test="${investList.currPage eq i}">class="curr"</c:if>>${i}</a>
				                </c:forEach>
				                <c:if test="${investList.currPage<investList.totalPage}">
				                	<a href="markinfo/info2?id=${markInfo2.id}&markid=${mark.id}&curPage=${investList.currPage+1}">下一页</a>
				                </c:if>
				                <em>共${investList.totalPage}页</em>
		                    </span>
	                    </div>
	                </td>
	              </tr>
	            </tfoot> --%>
	          </table>
	        </div>
	      </div>
	      
	    </div>
	  </div>
	</div>
<!--网站底部-->
<%@ include file="/jsp/frontpage/include/foot.jsp"%>
</body>
</html>