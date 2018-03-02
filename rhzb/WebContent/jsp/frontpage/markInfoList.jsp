<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=path%>/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>金源宝——我要投资</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="jsp/frontpage/css/common.css" rel="stylesheet" />
<link href="jsp/frontpage/css/index.css" rel="stylesheet" type="text/css">
<link href="jsp/frontpage/css/detail.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="jsp/frontpage/script/jquery.min.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/common.js"></script>
</head>
<body>
<%@ include file="/jsp/frontpage/include/head.jsp"%>
<!--列表-->
<div class="page-filter wrap">
  <div class="breadcrumbs"><a href="index/frontpage">首页</a>&gt;<span class="cur">${mark.markname}投资列表</span></div>
  <div class="invest-filter" data-target="sideMenu">
    <div class="filter-inner clearfix">
      <div class="filter-item">
        <div class="hd">
          <h3>筛选投资项目</h3>
          <label>
          <input id="filterMulti" name="multiple_choice" type="checkbox">
          多选</label>
        </div>
        <div class="bd">
          <dl>
            <dt>年利率</dt>
            <dd>
              <ul>
                <li class="n1"><a href="javascript:url('borrow_interestrate','');" id="borrow_interestrate_" class="active">不限</a></li>
                <li class="n2"><a id="borrow_interestrate_1" href="javascript:url('borrow_interestrate','1');">12%以下</a> </li>
                <li class="n3"><a id="borrow_interestrate_2" href="javascript:url('borrow_interestrate','2');">12%-14%</a> </li>
                <li class="n4"><a id="borrow_interestrate_3" href="javascript:url('borrow_interestrate','3');">14%-16%</a> </li>
                <li class="n5"><a id="borrow_interestrate_4" href="javascript:url('borrow_interestrate','4');">16%及以上</a> </li>
              </ul>
            </dd>
          </dl>
          <dl>
            <dt>期限</dt>
            <dd>
              <ul>
                <li class="n1"><a href="javascript:url('spread_month','');" id="spread_month_" class="active">不限</a> </li>
                <li class="n2"><a id="spread_month_1" href="javascript:url('spread_month','1');">1月以下</a> </li>
                <li class="n3"><a id="spread_month_2" href="javascript:url('spread_month','2');">1-3月</a> </li>
                <li class="n4"><a id="spread_month_3" href="javascript:url('spread_month','3');">3-6月</a> </li>
                <li class="n5"><a id="spread_month_4" href="javascript:url('spread_month','4');">6-12月</a> </li>
                <li class="n6"><a id="spread_month_5" href="javascript:url('spread_month','5');">12月及以上</a> </li>
              </ul>
            </dd>
          </dl>
          <dl class="repayment">
            <dt>还款方式</dt>
            <dd>
              <ul>
                <li class="n1"><a href="javascript:url('repay_style','');" id="repay_style_" class="active">不限</a></li>
                <li class="n2"><a id="repay_style_end" href="javascript:url('repay_style','end');">到期还本付息</a> </li>
                <li class="n2"><a id="repay_style_endmonth" href="javascript:url('repay_style','endmonth');">按月付息,到期还本</a> </li>
                <li class="n2"><a id="repay_style_month" href="javascript:url('repay_style','month');">等额本息</a> </li>
              </ul>
            </dd>
          </dl>
        </div>
      </div>
      <div class="common-problem">
        <h3>常见问题</h3>
        <ul>
          <li><a href="#">什么是债权贷？</a></li>
          <li><a href="#">关于"债权贷"产品的说明</a></li>
          <li><a href="#">易贷网P2P理财收费标准</a></li>
          <li><a href="#">债权贷和房易贷、车易贷有什么区别？</a></li>
        </ul>
      </div>
    </div>
  </div>
  <div class="invest-list mrt30 clearfix">
    <div class="hd">
      <h3>${mark.markname}投资列表</h3>
      <div class="count">
        <ul>
          <li class="line">平台累计投资交易金额&nbsp;&nbsp;<span class="f20 bold">${sumMoney}万元</span></li>
          <li>用户累计赚取收益&nbsp;&nbsp;<span class="f20 bold">${sumZqmoney}万元</span></li>
        </ul>
      </div>
    </div>
    <div class="bd">
      <div class="invest-table clearfix">
        <div class="title clearfix">
          <ul>
            <li class="col-330">借款标题</li>
            <li class="col-180"><a href="javascript:url('order','account_up');" class="">借款金额</a> </li>
            <li class="col-110"><a href="javascript:url('order','apr_up');" class="">年利率</a> </li>
            <li class="col-150"><a href="javascript:url('order','period_up');" class="">借款期限</a> </li>
            <li class="col-150">还款方式</li>
            <li class="col-120"><a href="javascript:url('order','scale_up');" class="">借款进度</a></li>
            <li class="col-120-t">操作</li>
          </ul>
        </div>
        <!------------投资列表-------------->
        <c:forEach items="${listMarkInfo.lists}" var="markinfo">
	        <div class="item">
	          <ul>
	            <li class="col-330 col-t"><a href='<c:if test="${markinfo.countmoney==markinfo.money}">markinfo/info?id=${markinfo.id}</c:if><c:if test="${markinfo.countmoney<markinfo.money}">markinfo/info2?id=${markinfo.id}</c:if>' target="_blank"><i class="icon icon-che" title="${mark.markname}"></i></a><a class="f18" href='<c:if test="${markinfo.countmoney==markinfo.money}">markinfo/info?id=${markinfo.id}</c:if><c:if test="${markinfo.countmoney<markinfo.money}">markinfo/info2?id=${markinfo.id}</c:if>' title="${markinfo.headline}" target="_blank"> ${markinfo.headline} </a></li>
	            <li class="col-180"><span class="f20 c-333">${markinfo.money}</span>元</li>
	            <li class="col-110 relative"><span class="f20 c-orange">${markinfo.accrual}% </span></li>
	            <li class="col-150"> <span class="f20 c-333">${markinfo.borrowtime}</span>个月 </li>
	            <li class="col-150">
	            	<c:if test="${markinfo.paymentMode eq 1}">等额本息</c:if>
			        <c:if test="${markinfo.paymentMode eq 2}">先息后本</c:if>
	            </li>
	            <li class="col-120">
	              <div class="circle">
	                <div class="left progress-bar">
	                  <div class="progress-bgPic progress-bfb10">
	                    <div class="show-bar">
	                    	<fmt:formatNumber type="number" value="${markinfo.countmoney/markinfo.money*100}" pattern="0.00" maxFractionDigits="2"/>% 
	                    </div>
	                  </div>
	                </div>
	              </div>
	            </li>
	            <li class="col-120-2"> 
		            <c:if test="${markinfo.countmoney==markinfo.money}">
               			<a class="ui-btn btn-gray" href="markinfo/info?id=${markinfo.id}&markid=${markinfo.markid}">还款中</a>
               		</c:if>
               		<c:if test="${markinfo.countmoney<markinfo.money}">
               			<a class="ui-btn btn-gray" href="markinfo/info2?id=${markinfo.id}&markid=${markinfo.markid}">投标</a>
               		</c:if>
	            </li>
	          </ul>
	        </div>
        </c:forEach>
        <!------------投资列表-------------->
      </div>
      <div class="pagination clearfix mrt30"> 
	      <span class="page">
		    <c:if test="${listMarkInfo.currPage>1}">
		      <a href="markinfo/listMarkInfoByMarkid?markid=${mark.id}&currPage=1">首页</a>
		    </c:if>
		    <c:if test="${listMarkInfo.currPage>1}">
		      <a href="markinfo/listMarkInfoByMarkid?markid=${mark.id}&currPage=${listMarkInfo.currPage-1}">上一页</a>&nbsp;
		    </c:if>
		    <c:forEach var="i" begin="1" step="1" end="${listMarkInfo.totalPage}">
		      <a <c:if test="${listMarkInfo.currPage==i}">class="curr"</c:if> href="markinfo/listMarkInfoByMarkid?markid=${mark.id}&currPage=${i}">${i}</a>
		    </c:forEach>  
		    <c:if test="${listMarkInfo.currPage<listMarkInfo.totalPage}">
		      <a href="markinfo/listMarkInfoByMarkid?markid=${mark.id}&currPage=${listMarkInfo.currPage+1}">下一页</a>
		    </c:if>
		    <c:if test="${listMarkInfo.currPage<listMarkInfo.totalPage}">
		      <a href="markinfo/listMarkInfoByMarkid?markid=${mark.id}&currPage=${listMarkInfo.totalPage}">尾页</a>&nbsp;
		    </c:if>
		    <em>共${listMarkInfo.totalPage}页&nbsp;</em>
	      </span>
        <!-- <dl class="page-select">
          <dt><span>1</span><i class="icon icon-down"></i></dt>
          <dd style="display: none;">
            <ul name="nump" id="jsnump">
              <li><a href="##" onclick="page_jump(&quot;this&quot;,1)">1</a></li>
              <li><a href="##" onclick="page_jump(&quot;this&quot;,2)">2</a></li>
              <li><a href="##" onclick="page_jump(&quot;this&quot;,3)">3</a></li>
            </ul>
          </dd>
        </dl> -->
      </div>
    </div>
  </div>
</div>
<!--网站底部-->
<%@ include file="/jsp/frontpage/include/foot.jsp"%>
</body>
</html>
