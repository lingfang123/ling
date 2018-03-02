<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String path = request.getContextPath();%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=path%>/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>金源宝——资金记录</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="jsp/frontpage/css/paging.css" rel="stylesheet">
<link href="jsp/frontpage/css/index.css" rel="stylesheet" type="text/css">
<link href="jsp/frontpage/css/detail.css" rel="stylesheet" type="text/css">
<link href="jsp/frontpage/css/common.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="jsp/frontpage/css/user.css" />
<script type="text/javascript" src="jsp/frontpage/script/common.js"></script>
<script src="jsp/frontpage/script/user.js" type="text/javascript"></script>
<script type="jsp/frontpage/text/javascript" src="script/jquery.min.js"></script>
<script type="jsp/frontpage/text/javascript"
		src="jsp/frontpage/script/My97DatePicker/4.8/WdatePicker.js"></script>
 <script type="text/javascript" src="http://s.59pi.com/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="http://s.59pi.com/js/jquery/laydate/laydate.js"></script>
</head>

<body>
<%@ include file="/jsp/frontpage/include/head.jsp"%>
<!--个人中心-->
<div class="wrapper wbgcolor">
  <div class="w1200 personal">
    <%@ include file="/jsp/frontpage/include/personalLeft.jsp"%>
    <div class="personal-main">
      <div class="personal-money">
        <h3><i>资金记录</i></h3>
        <form id="form" name="form" method="post" action="userRecharge/selectDetail">
           <div style="display:inline-block;height:75px;width:970px;line-height:70px;">
          		<span><font color="	#778899",size="45px">操作类型</font></span><span style="width:20px;">&nbsp;&nbsp;</span>
          		<select id="struts" name="struts" style="height:30px;width:150px;line-height:80px;color:#778899;">
          			<option value="" name="">  全  部  </option>
          			<option value="0" name=""> 充  值</option>
          			<option value="1" name=""> 提  现 </option>
          			<option value="2" name=""> 手 续 费 </option>
          			<option value="3" name=""> 利 息 返 还 </option>
          			<option value="4" name=""> 理  财 </option>
          			<option value="5" name="">返 还 本 金 </option>
          		</select>
            	<span><font color="	#778899",size="45px">日期范围</font></span><span style="width:20px;">&nbsp;&nbsp;</span>
		 	<input type="text" id="start" name="startTime" class="laydate-icon" placeholder="请输入日期" style="width: 120px;height:30px">
				<font color="#778899",size="45px">-</font><span style="width:10px">&nbsp;</span>
				<input type="text" id="end" name="endTime" class="laydate-icon" placeholder="请输入日期" style="width: 120px;height:30px">
		
			<!-- <input type="text"
				onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })"
				id="datemax" name="endTime" class="" style="width: 120px;"> -->
				<span style="width:40px">&nbsp;</span>
       		 <button type="submit" style="border:0;width:70px ;height:30px ;background:#1E90FF;display:inline;"><span class="">筛选</span></button>&nbsp;&nbsp;&nbsp;
       		 <a href="/rhzb/detailPoi/ExportExcel"><button type="button" style="border:0;width:70px ;height:30px ;background:#8CD3F2;display:inline;"><span class="">导出数据</span></button></a>
           </div>
      	
       
          <span id="form:dataTable">
          <div class="personal-moneylist">
          
            <div class="pmain-contitle"> <span class="pmain-title1 fb">交易时间</span> <span class="pmain-title2 fb"><span style="width:25px">&nbsp &nbsp</span>交易类型</span> <span class="pmain-title3 fb">交易金额</span> <span class="pmain-title4 fb">余额</span> <span class="pmain-title5 fb">备注</span> </div>
            <ul>
           	 <c:forEach items="${pageBean.lists}" var="p">
             	 <li>
		              <span class="pmain-title1 pmain-height">
		              	<fmt:formatDate value="${p.dateiltime}" pattern="yyyy-MM-dd hh:mm:ss"/>
		              </span>
		             &nbsp
		              <span class="pmain-title2 pmain-height">
		              	<c:if test="${p.struts==0}">
		            		<span style="width:40px">&nbsp&nbsp&nbsp</span>充  值
		            	</c:if>
			            <c:if test="${p.struts==1}">
			            	<span style="width:40px">&nbsp&nbsp&nbsp</span>提  现
			            </c:if>
			            <c:if test="${p.struts==2 }">
			            	<span style="width:40px">&nbsp&nbsp&nbsp</span>手 续 费
			            </c:if>
			             <c:if test="${p.struts==3 }">
			            	<span style="width:40px">&nbsp&nbsp&nbsp</span>利 息 返 还
			            </c:if>
			             <c:if test="${p.struts==4 }">
			            	<span style="width:40px">&nbsp&nbsp&nbsp</span>理  财
			            </c:if>
			             <c:if test="${p.struts==5 }">
			            	<span style="width:40px">&nbsp&nbsp&nbsp</span>返 还 本 金
			            </c:if>
		            </span>
		            <span class="pmain-title3 pmain-height">${p.money }</span>
		            <span class="pmain-title4 pmain-height">${p.bychar }</span>
		            <span class="pmain-title5 pmain-height">备注</span>
           		 </li>	
       		  </c:forEach>
       		
       		 <li> 
       			<span class="pmain-title2 pmain-height" style="width: 940px">
       		 	
       			</span>
       			<div class="pagination clearfix mrt30" style="position: relative;width: 940px;height: 50px;left:20px">
       				<span class="page">
       				当前为第${pageBean.currPage}页
       					<a href="userRecharge/selectDetail?rows=1">首页</a>
       					<c:set var="pagej" value="${pageBean.currPage }"></c:set>
       					 <c:if test="${pagej-1 > 0}">
       				    	   <%-- <a href="userRecharge/selectDetail?rows=${pagei=pageBean.getCurrPage()+1}">下一页</a> --%>
       				  			<a href="userRecharge/selectDetail?rows=${pageBean.getCurrPage()-1}">上一页</a>
       				    </c:if>
       				    <c:if test="${pagej <= 0}">
       				        <a href="userRecharge/selectDetail?rows=${pageBean.getCurrPage()-1}">上一页</a>
       				    </c:if>
       					
       					<c:forEach begin="1" var="i" step="1" end="${pageBean.totalPage }">
       						
       							<a <c:if test="${pageBean.currPage==i}"> class="curr"</c:if> href="userRecharge/selectDetail?rows=${i}">${i}</a> 
       						
	       				   <%--  <a class="curr" href="userRecharge/selectDetail?rows=${a}">${a}</a>  --%>
       				    </c:forEach>
       				    <c:set var="pagei" value="${pageBean.currPage }"></c:set>
       				    <c:if test="${pagei > pageBean.totalPage}">
       				  			 <%-- <a href="userRecharge/selectDetail?rows=${pageBean.getCurrPage()+1}">下一页</a> --%>
       				  			 <a href="#" onclick="nexrPage()">下一页</a>
       				    </c:if>
       				    <c:if test="${pagei+1 <= pageBean.totalPage}">
       				    	<a href="userRecharge/selectDetail?rows=${pageBean.getCurrPage()+1}">下一页</a>
       				    </c:if>
       				    <a href="userRecharge/selectDetail?rows=${pageBean.totalPage}">尾页</a>&nbsp;
       				   <em>共${pageBean.totalPage}页&nbsp;</em>
       				 </span>
				       <dl class="">
				        </dl>
				   </div>
       		 </li>
       		</ul>	 
            </div>
            
          </span>
          
          </form>
      </div>
    </div>
   
  </div>
  
</div>

 

<!--网站底部-->
<%@ include file="/jsp/frontpage/include/foot.jsp"%>
</body>

 <!-- <script type="text/javascript">
	function firstPage(){
		var rows=${pageBean.currPage};
		if(${pageBean.currPage==1}){
			$.ajax({
				url:'userRecharge/selectDetail',
				type:'post',
				data:{'rows':rows},
				dataType:'json',
				success:function(data){
				}	
			});
		}
	}
	function nextPage(){
		var rows=${pageBean.currPage},
		if(rows<${pageBean.totalPage}){
			rows+1;
			$.ajax({
				url:'userRecharge/selectDetail',
				type:'post',
				data:{'rows':rows},
				dataType:'json',
				success:function(data){
				}	
			});
		}
		if(rows==${pageBean.totalPage}){
			$.ajax({
				url:'userRecharge/selectDetail',
				type:'post',
				data:{'rows':rows},
				dataType:'json',
				success:function(data){
				}	
			});
		}
	}
</script>
 -->
 <script type="text/javascript">
    var start = {
       elem: '#start', //id为star的输入框
       format: 'YYYY-MM-DD', 
       max: laydate.now(), //最大日期
       istime: true,
       istoday: false,
       choose: function(datas){
        var now = new Date(laydate.now().replace("-", "/")); //当前日期的date格式
        var add=new Date(datas.replace("-", "/")); //选择的日期
        add= new Date(add.getTime() + 30*24*60*60*1000); //在选择的日期+30天
        if((now.getMonth() + 1)<(add.getMonth() + 1)){ //如果当前月份小于选择月份
            end.max = laydate.now();  //结束日的最大日期为当前日期
        }else if ((now.getMonth() + 1)==(add.getMonth() + 1) &&  now.getDate()<add.getDate()) {
            end.max = laydate.now();//月份相同且当前日小于选择日
        }
        else {
            add=add.getFullYear() + "/" + (add.getMonth() + 1) + "/"+ add.getDate();//转换日期格式
            end.max = add;//结束日的最大日期为选择的日期+30天
        }  
        end.min = datas;//开始日选好后，重置结束日的最小日期
      }
    };
    var end = {
      elem: '#end',
      format: 'YYYY-MM-DD',
      max: laydate.now(),
      istime: true,
      istoday: false,
      choose: function(datas){
        var min=new Date(datas.replace("-", "/")); 
        min= new Date(min.getTime() - 30*24*60*60*1000); //在日期-30天。
        min=min.getFullYear() + "/" + (min.getMonth() + 1) + "/"+ min.getDate(); 
        start.max = datas; //结束日选好后，重置开始日的最大日期
        start.min = min;
      }
    };
    laydate(start);
    laydate(end);
</script>
</html>
