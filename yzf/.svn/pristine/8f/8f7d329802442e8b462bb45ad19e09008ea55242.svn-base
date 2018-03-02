<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <!-- <span class="r">共有数据：<strong>88</strong> 条</span> -->
  </div>
  	<table class="table table-border table-bordered table-bg" id="bankmn"></table>
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
<!-- Bootstrap table -->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/list/bootstrap-table.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/list/bootstrap-table-mobile.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/list/locale/bootstrap-table-zh-CN.min.js"></script>
<!-- Peity -->
<script src="${pageContext.request.contextPath}/static/list/bootstrap-table-demo.js"></script>
<script type="text/javascript">
	/* window.onload = (function(){
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
	}); */
	$(function () {
		/* //激活弹框提示
		$("[data-toggle='tooltip']").tooltip(); */
		$('#bankmn').bootstrapTable({
			url : '${pageContext.request.contextPath}/bankmnlist.do', //请求后台的URL（*）
			method : 'post', //请求方式（*）
			contentType: "application/x-www-form-urlencoded",
			toolbar : '#toolbar', //工具按钮用哪个容器
			striped : true, //是否显示行间隔色
			showExport: true, //是否显示导出
			cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination : true, //是否显示分页（*）
			sortable : false, //是否启用排序
			sortOrder : "asc", //排序方式
			queryParams : queryParams,//传递参数(*)
			sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）
			pageNumber : 1, //初始化加载第一页，默认第一页
			pageSize : 10, //每页的记录行数（*）
			pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*）
			/* search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 */
			strictSearch : false,
			searchOnEnterKey :true, //按回车搜索
			showColumns : true, //是否显示所有的列
			showRefresh : true, //是否显示刷新按钮
			minimumCountColumns : 2, //最少允许的列数
			/* clickToSelect : true, //是否启用点击选中行 */
			//height : 300, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			uniqueId : "id", //每一行的唯一标识，一般为主键列
			showToggle : true, //是否显示详细视图和列表视图的切换按钮
			cardView : false, //是否显示详细视图
			detailView : false, //是否显示父子表
			singleSelect: false,  //设置为单选
			columns : [ {
				checkbox : true,
			}, {
				field : 'id',
				title : '编号'
			}, {
				field : 'type',
				title : '类型'
			}, {
				field : 'bankcardno',
				title : '银行卡号'
			}, {
				field : 'name',
				title : '真实姓名',
			
			},{
				field : 'phone',
				title : '手机号码',
			
			},{
				field : 'createtime',
				title : '申请时间',
			
			},{
				field : 'money',
				title : '银行卡金额',
			
			},]
		});
	});
	function queryParams(params) {
		var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			//***这里的参数传到后台，用来进行分页处理*************************
			rows: params.limit, //页面大小
			page: params.offset, //页码
		};
		return temp;
	};
</script>
</body>
</html>