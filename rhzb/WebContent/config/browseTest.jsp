<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<jsp:include page="/config/init.jsp"></jsp:include>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>查询页面</title>
	
	<script type="text/javascript">
   /*  $(function() {
    	academyDataGrid = $('#dg').datagrid({
            url : 'getTestForPage',
            fit : true,
            striped : true,
            rownumbers : true,
            pagination : true,
            singleSelect : true,
            idField : 'id',
	        sortOrder : 'asc',
            pageSize : 20,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [ {
                width : '200',
                title : '学校',
                field : 'username',
                sortable : true
            },
            {
                width : '200',
                title : '学校',
                field : 'password',
                sortable : true
            },
            {
                width : '200',
                title : '学校',
                field : 'name',
                sortable : true
            },
            {
                width : '200',
                title : '学校',
                field : 'sex',
                sortable : true
            },
            {
                width : '200',
                title : '生日',
                field : 'birthday',
                sortable : true
            },{
                width : '200',
                title : 'birthday',
                field : 'remark',
                sortable : true
            }
            ] ],
            onLoadSuccess:function(data){
                $('.user-easyui-linkbutton-edit').linkbutton({text:'编辑'});
                $('.user-easyui-linkbutton-del').linkbutton({text:'删除'});
            },
            toolbar : '#AcademyToolbar'
        });
    });
     */
	
	
	</script>
</head>

<body>
	<div class="easyui-layout" data-options="fit:true" title="aaa">
 		<div data-options="region:'north'">
 			<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'"  onclick="beforeAdd()">新增</a>
			<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'" onclick="beforeMod()">修改</a>
			<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-no'"  onclick="delTest()">删除</a>
		</div>
	   <div data-options="region:'center'">
			<table id="dg" class="easyui-datagrid" style="width:100%;height:100%"  title="用户管理"
					data-options="toolbar:'#tb',url:'user',method:'get',pageSize:20,pageList:[20,50,100]"
					singleSelect="false" collapsible="false" rownumbers="true" pagination="true">
				<thead>
					<tr>
						<th data-options="field:'ck',checkbox:true"></th>
						<th width="16%" data-options="field:'username',width:500">用户名</th>
						<th width="16%"  data-options="field:'password',width:200">密码</th>
						<th width="16%"  data-options="field:'name',width:200">姓名</th>
						<th width="13%"  data-options="field:'sex',width:200">性别</th>
						<th width="16%"  data-options="field:'birthday',width:200,formatter:dataFormat" >出生年月</th>
						<th width="15%"  data-options="field:'remark',width:200">备注</th>
					</tr>
				</thead>
			</table>
	    </div> 
	     <div data-options="region:'center',border:true,title:'用户管理'" >
        <table id="dg" data-options="border:false"></table>
    </div>
	</div>
	<div id="tb"  class="easyui-layout">
		<table width="100%">
			<tr>
			<form id="qForm">
				<td width="10%" align="right">用户名:</td>
				<td width="15%" align="left"><input id="q_username" class="easyui-textbox" style="width:100%"></td>
				<td width="10%" align="right">姓名:</td>
				<td width="15%" align="left"><input id="q_name" class="easyui-textbox" style="width:100%"></td>
				<td width="10%" align="right">出生年月:</td>
				<td width="15%" align="left"><input id="q_birthday" class="easyui-datebox" style="width:100%"></td>
				<td width="10%" align="right">性别:</td>
				<td width="15%" align="left">
					<select class="easyui-combobox" id="q_sex" style="width:100%;">
						<option value="1">男</option>
						<option value="2">女</option>
					</select>
				</td>
			</tr>
			</form>
			<tr>
				<td colspan="8" align="center">
					<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="queryForPage()">查询</a>
					<a href="#" class="easyui-linkbutton" iconCls="icon-page_excel" onclick="">导出</a>
					<a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="reset()">重置</a>
				</td>
			</tr>
		</table>
	</div>
 	<div id="add" class="easyui-window" closed="true" title="用户信息新增" data-options="iconCls:'icon-save'" style="width:600px;height:300px;padding:10px;">
		<div >
	    <form id="ff" method="post">
	    	<table>
	    		<tr>
	    			<td width="100" align="right">用户名:</td>
	    			<td ><input style="display:none" name="user.id"/><input class="easyui-textbox" type="text" name="user.username" data-options="required:false"></input></td>
	    			<td width="100"  align="right">密码:</td>
	    			<td><input class="easyui-textbox" type="text" name="user.password" data-options="required:false"></input></td>
	    		</tr>
	    		<tr>
 			<td width="100" align="right">姓名:</td>
	    			<td><input class="easyui-textbox" type="text" name="user.name" data-options="required:false" value="${user.name }"></input></td>
	    			<td width="100" align="right">性别:</td>
	    			<td><input class="easyui-textbox" type="text" name="user.sex" data-options="required:false"></input></td>
	    		</tr>
	            
	    		<tr>
	    			<td width="100" align="right">出生年月:</td>
	    			<td><input class="easyui-datebox"  name="user.birthday"  data-options="required:false"></input></td>
	    		</tr>
	    		<tr>
	    			<td width="100" align="right">备注:</td>
	    			<td colspan="3"><input class="easyui-textbox" name="user.remark" data-options="multiline:true" style="height:60px;width:100%"></input></td>
	    		</tr>
	    	</table>
	    </form>
	    </div>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="submitForm()">保存</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"  onclick="$('#add').window('close')">关闭</a>
	    </div>
	</div>
</body>
</html>
<script>
/*  操作标识，添加是为add，修改时为mod */
	var operType="";
	/* 提交表单 */
	function submitForm(){
	    $('#ff').form('submit', {  
	        url : "saveTest",  
	        onSubmit : function() { 
	            var isValid = $(this).form('validate');  
	            return isValid; // 返回false终止表单提交
	        },  
	        success : function(data) {  
	            if (data == "success") {  
	            	if(operType=="add"){
	                	$.messager.alert('提示', '添加成功！');
	                	$('#add').window('close');
	            	}else{
	            		$.messager.alert('提示', '修改成功！');
	            		$('#add').window('close');
	            	}
	                $('#dg').datagrid('reload'); // 重新载入当前页面数据
	            } else {  
	                $.messager.alert('提示信息', '添加失败，请联系管理员！', 'warning');  
	            }  
	        }  
	    });  
	}
	/* 修改时读取表单数据 */
	function beforeMod(){
		operType="mod";
		var row = $('#dg').datagrid('getSelected');
		if(row==null){
			$.messager.alert('提示信息', '请选择要修改的数据！', 'warning');  
			return;
		}
		var uuid=row.id;
			$('#ff').form('load', 'loadBody?id='+uuid);
			
			$('#add').window('open');
	}
	/* 修改时读取表单数据 */
	function beforeAdd(){
		operType="add";
		$('#ff').form('clear');
		$('#add').window('open');
	}
	/* 删除数据 */
	function delTest(){
			var row = $('#dg').datagrid('getSelections');
			if(row==0){
				$.messager.alert("温馨提示","请至少勾选一项删除");
				return;
			}else{
				$.messager.confirm("温馨提示","您确定要删除吗？",function(data){
					if(data){
						var rows = $("#dg").datagrid("getSelections");
						var ids = "";
						for(var i = 0 ; i  <rows.length ; i++){
							ids+=rows[i]["id"]+",";
						}
						$.post("delTest",{"ids":ids},function(data){
							if(data == "success"){
								$.messager.alert("温馨提示","删除成功");
								$('#dg').datagrid('reload'); // 重新载入当前页面数据
							}else{
								$.messager.alert("温馨提示","删除失败");
							}
						});
						
					}
				});
			}
	}
	//查询数据
	function queryForPage(){
		$('#dg').datagrid({
			queryParams:{
				username:$("#q_username").val(),
				name:$("#q_name").val(),
				birthday:$("#q_birthday").val(),
				sex:$("#q_sex").combobox('getValue')
			}
		});
	}
	//重置
	function reset(){
		$("#qForm").form("clear");
	}
	
	/* 表格日期格式化 */
	function dataFormat(value,row,index){
		var date = new Date(value);
    	return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
	}
</script>