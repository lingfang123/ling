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
</head>
<body>
<!-- 网站头部 -->
<%@ include file="/jsp/frontpage/include/head.jsp"%>
	<div class="item-detail wrap">
	  <div class="breadcrumbs"> <a href="index/frontpage">首页</a>&gt; <a href="markInfo/listmarkInfoByMarkid?markid=${mark.id}">${mark.markname}投资列表</a>&gt; <span class="cur">项目详情</span> </div>
	  <div class="item-detail-head clearfix" data-target="sideMenu">
	    <div class="hd"> <i class="icon icon-che" title="车易贷"></i>
	      <h2>${markInfo.headline}</h2>
	    </div>
	    <div class="bd clearfix">
	      <div class="data">
	        <ul>
	          <li> <span class="f16">借款金额</span><br>
	            <span class="f30 c-333" id="account">${markInfo.money}</span>元 </li>
	          <li class="relative"><span class="f16">年利率</span><br>
	            <span class="f30 c-orange">${markInfo.accrual}%</span> </li>
	          <li><span class="f16">借款期限</span><br>
	            <span class="f30 c-333">${markInfo.borrowtime}</span>个月 </li>
	          <li><span class="c-888">借款编号：</span></li>
	          <li><span class="c-888">发标日期：</span>
	          	<fmt:formatDate value="${markInfo.starttime}" pattern="yyyy-MM-dd HH:mm:ss"/>
	          </li>
	          <li><span class="c-888">保障方式：</span>100%本息垫付</li>
	          <li>
		          <span class="c-888">还款方式：</span>
		          <c:if test="${markInfo.paymentMode == 1}">等额本息</c:if>
				  <c:if test="${markInfo.paymentMode == 2}">先息后本</c:if>
			  </li>
	          <li><span class="c-888">需还本息：</span>
	          	${summoney}
	          	<%-- <fmt:formatNumber type="number" value="${markInfo.money+markInfo.money*(markInfo.accrual/100)*(markInfo.borrowtime/12)}" pattern="0.00" maxFractionDigits="2"/>元 --%>
	          </li>
	          <li><span class="c-888">借款用途：</span>${markInfo.purpose}</li>
	          <!-- <li class="colspan"> <span class="c-888 fl">投标进度：</span>
	            <div class="progress-bar fl"> <span style="width:100%"></span> </div>
	            <span class="c-green">100%</span> </li> -->
	          <li> <span class="c-888">投资范围：</span> <span id="account_range"> ${markInfo.investmin} ~ ${markInfo.investmax}</span> 元</li>
	        </ul>
	      </div>
	      <div class="mod-right mod-status">
	        <div class="inner">
	          <div class="text"> 待还本息：<span class="f24 c-333">${summoney}</span>元<br>
	           	 剩余期限：<span class="f24 c-333">${tnumber}天</span> <br>
	           	 下期还款日： <span class="f20 c-333">
	           	 <fmt:formatDate value="${xqtime}" pattern="yyyy-MM-dd"/></span></div>
	          <i class="icon icon-status icon-status1"></i></div>
	      </div>
	    </div>
	  </div>
	  <div class="item-detail-body clearfix mrt30 ui-tab">
	    <div class="ui-tab-nav hd"> <i class="icon-cur" style="left: 39px;"></i>
	      <ul>
	        <li class="nav_li active" id="nav_1"><a href="javascript:;">借款信息</a></li>
	        <li class="nav_li" id="nav_2"><a href="javascript:;">投资记录</a> <i class="icon icon-num1" style="margin-left: -15px;"> <span id="tender_times">23</span> <em></em> </i> </li>
	        <li class="nav_li" id="nav_3"><a href="javascript:;">还款列表</a></li>
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
	                <p class="MsoNormal" style="margin-left:0cm;text-indent:0cm;"> ${applyfor.purpose}。</p>
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
	              <div class="conclusion f16"> 结论：经风控部综合评估， <span class="c-orange">同意放款${markInfo.money}元；</span> <i class="icon icon-status icon-status1"></i> </div>
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
		        	<fmt:formatNumber type="number" value="${markInfo.money}" pattern="0.00" maxFractionDigits="2"/>
		        </span>&nbsp;&nbsp;剩余投标金额：
		        <span class="c-orange">
		        	<fmt:formatNumber type="number" value="${markInfo.money-markInfo.countmoney}" pattern="0.00" maxFractionDigits="2"/>
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
				                	<a href="markinfo/info?id=${markInfo.id}&markid=${mark.id}&curPage=${investList.currPage-1}" class="disabled">上一页 </a>
				                </c:if>
				                <c:forEach var="i" begin="1" end="${investList.totalPage}" step="1">
				                	<a href="markinfo/info?markid=${mark.id}&id=${markInfo.id}&curPage=${i}" <c:if test="${investList.currPage eq i}">class="curr"</c:if>>${i}</a>
				                </c:forEach>
				                <c:if test="${investList.currPage<investList.totalPage}">
				                	<a href="markinfo/info?id=${markInfo.id}&markid=${mark.id}&curPage=${investList.currPage+1}">下一页</a>
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
	      <div class="ui-tab-item" style="display: none;">
	        <div class="repayment-list"> 已还本息：
	        <span class="c-orange">
	        	<c:set value="0.00" var="yhsum"/>
	        	<c:forEach items="${refundRecordPage.lists}" var="refund">
	        		<c:if test="${refund.status eq 1}">
	        			<c:set value="${yhsum + refund.hkmoney}" var="yhsum" />
	        		</c:if>
	        	</c:forEach>
	        	<fmt:formatNumber type="number" value="${yhsum}" pattern="0.00" maxFractionDigits="2"/>
	        </span>&nbsp;&nbsp;
	          	待还本息：<span class="c-orange">
	          		<c:set value="0.00" var="dhsum"/>
	          		<c:forEach items="${refundRecordPage.lists}" var="refund">
	        		<c:if test="${refund.status!=1}">
	        			<c:set value="${dhsum + refund.hkmoney}" var="dhsum" />
	        		</c:if>
	        	</c:forEach>
	        	<fmt:formatNumber type="number" value="${dhsum}" pattern="0.00" maxFractionDigits="2"/>
	          	</span>&nbsp;&nbsp;(待还本息因算法不同可能会存误差，实际金额以到账金额为准！)
	          <table width="100%" border="0" cellspacing="0" cellpadding="0">
	            <tbody>
	              <tr>
	                <th>合约还款日期</th>
	                <th>期数</th>
	                <th>应还本金</th>
	                <th>应还利息</th>
	                <th>应还本息</th>
	                <th>还款状态</th>
	              </tr>
	              <c:forEach items="${refundRecordPage.lists}" var="refundRecord" begin="0" varStatus="count">
		              <%-- <c:if test="${refundRecord.status eq 1}"> --%>
			              <tr>
			                <td>
			                	<fmt:formatDate value="${refundRecord.refundtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
			                </td>
			                <td>${count.index+1}</td>
			                <td>${refundRecord.principal}元</td>
			                <td>${refundRecord.integererests}元</td>
			                <td>${refundRecord.hkmoney}元</td>
			                <td>
			                	<c:if test="${refundRecord.status eq 0}">待还款</c:if>
			                	<c:if test="${refundRecord.status eq 1}">已还款</c:if>
			                	<c:if test="${refundRecord.status eq 2}">已逾期</c:if>
			                </td>
			              </tr>
		              <%-- </c:if> --%>
	              </c:forEach>
	            </tbody>
	            <%-- <tfoot>
	              <tr class="page-outer">
	                <td colspan="4" align="center">
		                <div class="pagination clearfix">
			                <span class="page" id="repayment_content_pager">
				                <c:if test="${refundRecordPage.currPage>1}">
				                	<a href="markinfo/info?id=${markInfo.id}&markid=${mark.id}&currentPage=${refundRecordPage.currPage-1}" class="disabled">上一页 </a>
				                </c:if>
				                <c:forEach var="i" begin="1" end="${refundRecordPage.totalPage}" step="1">
				                	<a href="markinfo/info?markid=${mark.id}&id=${markInfo.id}&currentPage=${i}" <c:if test="${refundRecordPage.currPage eq i}">class="curr"</c:if>>${i}</a>
				                </c:forEach>
				                <c:if test="${refundRecordPage.currPage<refundRecordPage.totalPage}">
				                	<a href="markinfo/info?id=${markInfo.id}&markid=${mark.id}&currentPage=${refundRecordPage.currPage+1}">下一页</a>
				                </c:if>
				                <em>共${refundRecordPage.totalPage}页</em>
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