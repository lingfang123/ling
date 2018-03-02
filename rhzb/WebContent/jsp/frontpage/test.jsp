<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/config/init.jsp"></jsp:include>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jsp/frontpage/script/jquery.min.js"></script>

<script type="text/javascript">
//获取省份
	$(function(){
		$.ajax( {
			type : "post",
			url : "pcon/queryProvice",
			data : {"233":"233"},
			cache : false,
			dataType : "json",
			success : function(data) {
				var str = "<option>请选择</option>";
				$("#provices").html("");
				for ( var i = 0; i < data.length; i++) {
					str += "<option value='" + data[i].pid
							+ "'>" + data[i].provinceName
							+ "</option>";
				}
				$("#provices").append(str);
			},
			error : function() {
				alert("请与管理员联系");
			}
	});
		
	});

$(document).ready(function(){
	//获取城市
	$("#provices").change(function(){
		$.ajax({
			type:"post",
			url:"pcon/queryCity",
			data:"pid="+$("#provices").val(),
			cache:false,
			dataType:"json",
			success:function(json){
				var attr="<option>请选择</option>";
				$("#city").html("");
				for(var i=0;i<json.length;i++){
					attr += "<option value='" + json[i].cid
					+ "'>" +json[i].cityName
					+ "</option>";

				}
				$("#city").append(attr);
				$("#country").html("");
				$("#country").append("<option>请选择</option>");
			},error:function(){
				alert("请与管理员联系");
			}
		});
	});

	//获取地区
	$("#city").change(
			function() {
				var params = $("#city").val();
				$.ajax( {
					type : "post",
					url : "pcon/queryDistrict",
					data : "cid="+$("#city").val(),
					cache : false,
					dataType : "json",
					success : function(data) {
						var str = "<option>请选择</option>";
						$("#country").html("");
						for ( var i = 0; i < data.length; i++) {
							str += "<option value='" + data[i].did
									+ "'>" + data[i].districtName
									+ "</option>";
						}
						$("#country").append(str);
					},
					error : function() {
						alert("请与管理员联系");
					}
			});
		});
	
});


</script>
</head>
<body>


<select id="provices"> 
<option>请选择</option>
</select>

<select id="city"> 
<option>请选择</option>
</select>
<select id="country"> 
<option>请选择</option>
</select>
</body>
</html>