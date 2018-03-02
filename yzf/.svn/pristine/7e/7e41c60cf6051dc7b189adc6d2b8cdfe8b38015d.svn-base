<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/list/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/list/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/list/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/list/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/list/static/h-ui.admin/css/style.css" />
<link href="${pageContext.request.contextPath}/static/list/css/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;
	</i> 首页 <span class="c-gray en">&gt;</span> 
	用户中心 <span class="c-gray en">&gt;</span> 
	用户管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
	<i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
  <div class="text-c"> 日期范围：
    <input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" class="input-text Wdate" style="width:120px;">
    -
    <input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})" id="datemax" class="input-text Wdate" style="width:120px;">
    <input type="text" class="input-text" style="width:250px" placeholder="输入会员名称、电话、邮箱" id="" name=""><button type="submit" class="btn btn-success" id="" name=""><i class="icon-search"></i> 搜用户</button>

  </div>
  <div class="cl pd-5 bg-1 bk-gray mt-20">
    <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="icon-trash"></i> 批量删除</a>
    <a href="javascript:;" onclick="user_add('550','','添加用户','user-add.html')" class="btn btn-primary radius"><i class="icon-plus"></i> 添加用户</a></span>
    <span class="r">共有数据：<strong>56</strong> 条</span>
  </div>
  	<table class="table table-border table-bordered table-hover table-bg table-sort">
    <thead>
      <tr class="text-c">
        <th width="25"><input type="checkbox" name="" value=""></th>
        <th width="80">编号</th>
        <th width="100">类型</th>
        <th width="40">银行卡号</th>
        <th width="90">真实姓名</th>
        <th width="150">手机号码</th>
        <th width="">申请时间</th>
        <th width="130">银行卡金额</th>
        <th width="130">操作</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${list.content}" var="bank">
    	<td><input type="checkbox" value="1" name=""></td>
    	<td>${bank.id}</td>
    	<td>${bank.type}</td>
    	<td>${bank.bankcardno}</td>
    	<td>${bank.name}</td>
    	<td>${bank.phone}</td>
    	<td>${bank.createtime}</td>
    	<td>${bank.money}</td>
    	<td class="f-14 user-manage">
    		<a style="text-decoration:none" onClick="user_stop(this,'10001')" href="javascript:;" title="停用">
    			<i class="icon-hand-down"></i>
    		</a> 
    		<a title="编辑" href="javascript:;" onclick="user_edit('4','550','','编辑','user-add.html')" class="ml-5" style="text-decoration:none">
    			<i class="icon-edit"></i>
    		</a> 
    		<a style="text-decoration:none" class="ml-5" onClick="user_password_edit('10001','370','228','修改密码','user-password-edit.html')" href="javascript:;" title="修改密码">
    			<i class="icon-key"></i>
    		</a>
    		<a title="删除" href="javascript:;" onclick="user_del(this,'1')" class="ml-5" style="text-decoration:none">
    			<i class="icon-trash"></i>
    		</a>
    	</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <div id="pageNav" class="pageNav"></div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/list/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/list/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/list/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/list/static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/list/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/list/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/list/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
	window.onload = (function(){
	    // optional set
	    pageNav.pre="&lt;上一页";
	    pageNav.next="下一页&gt;";
	    // p,当前页码,pn,总页面
	    pageNav.fn = function(p,pn){$("#pageinfo").text("当前页:"+p+" 总页: "+pn);};
	    //重写分页状态,跳到第三页,总页33页
	    pageNav.go(1,13);
	});
	$('.table-sort').dataTable({
		"lengthMenu":false,//显示数量选择 
		"bFilter": false,//过滤功能
		"bPaginate": false,//翻页信息
		"bInfo": false,//数量信息
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,8,9]}// 制定列不参与排序
		]
	});
</script>
</body>
</html>