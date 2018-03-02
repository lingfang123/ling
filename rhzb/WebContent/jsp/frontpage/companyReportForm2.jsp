<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=path%>/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>金源宝——运营报告详情</title>
<script type="text/javascript" src="jsp/frontpage/script/jquery-1.8.3.min.js"></script>
<!-- 中国地图js -->
<!-- <script type="text/javascript" src="jsp/frontpage/script/china.js"></script> -->
<!-- 这是柱 ECharts -->
<script type="text/javascript" src="jsp/frontpage/script/echarts.js"></script>
<script type="text/javascript" src="jsp/frontpage/dist/esl.js"></script>
<style type="text/css">
.cont-num{
	width:1200px;
	margin: 50px auto;
}

.cont-num .header{
	width: 1200px;
	height: 150px;
	/* border: 1px solid red; */
}

.header .header-con{
	width: 400px;
	margin: 10px auto;
}
.header .header-con .header-text{
	font-size: 40px;
	color:#EE4549;
}
.header .header-con .header-time{
	font-size: 20px;
	color:#99D9EA;
}

.count-main{
	width:1200px;
	height: 320px;
	/* border: 1px solid #99D9EA; */
	margin: 20px 0px 20px 0px; 
}

.count-main .count-box{
	width:500px;
	height: 280px;
	/* border:1px solid #C3C3C3; */
	margin: 20px 50px;
	float: left;
}
.count-box .box{
	width: 80%;
	margin:20px auto; 	
}
.count-box .box .WrittenWords{
	font-size: 20px;
	
}
.count-box .box .num{
	font-size: 30px;
	color:#EE4549;	
}

.count-box img{
	display:block;
	margin: 10px auto;
}

</style>
</head>
<body>
  <div class="contain" id="tabs" style="margin:0px auto;width: 100%;">
   	<div class="cont-num">
   		<div class="header">
   			<div class="header-con">
   				<span class="header-text">${newLastDay.subSequence(5,7)}</span>
	   			<span class="header-text">月份运营报告</span>
   			</div>
   			<div class="header-con">
   				<span class="header-time">截至时间</span>
	   			<span class="header-time">${newLastDay}</span>
   			</div>
	   	</div>
	   	
	   	<div class="count-main">
	   		<div class="count-box">
	   			<img alt="" src="jsp/frontpage/images/reportFormImages/产业规模.png">
				<div class="box">
					<span class="WrittenWords">累计投资额（元）:</span>
			   		<span class="num">${sumMoney }</span>
				</div>
			   	<div class="box">
			   		<span class="WrittenWords">${newLastDay.subSequence(5,7)}月份投资额（元）:</span>
			   		<span class="num">${monthMoneyAll }</span>
			   	</div>
	   		</div>
	   		<div class="count-box">
				<img alt="" src="jsp/frontpage/images/reportFormImages/人才.png">
				<div class="box">
			   		<span class="WrittenWords">累计注册用户数量（人）:</span>
			   		<span class="num">${userCount}</span>
			   	</div>
			   	<div class="box">
			   		<span class="WrittenWords">${newLastDay.subSequence(5,7)}月份注册用户数量（人）:</span>
			   		<span class="num">${listMonthSize }</span>
			   	</div>
			   	
	   		</div>
	   	</div>
	   	
	   	<div class="count-main">
	   		<div class="count-box">
	   			<img alt="" src="jsp/frontpage/images/reportFormImages/上市信息.png">
				<div class="box">
					<span class="WrittenWords">累计投资人数（人）:</span>
			   		<span class="num">${numListAllSize}</span>
				</div>
			   	<div class="box">
			   		<span class="WrittenWords">${newLastDay.subSequence(5,7)}月份投资人数（人）:</span>
		   			<span class="num">${numListSize}</span>
			   	</div>
	   		</div>
	   		<div class="count-box">
				<img alt="" src="jsp/frontpage/images/reportFormImages/企业研发投入总金额.png">
				<div class="box">
					<span class="WrittenWords">${newLastDay.subSequence(5,7)}月人均累计投资金额（元）:</span>
			   		<span class="num"> ${MonthAverage} </span>
				</div>
			   	<div class="box">
			   		<span class="WrittenWords">${newLastDay.subSequence(5,7)}月笔均投资金额（元）:</span>
		   			<span class="num"> ${pen} </span>
			   	</div>	   		
	   		</div>
	   	</div>
	   	
	   	<div class="count-box">
	   		<!-- 为ECharts准备一个具备大小（宽高）的Dom  柱状图-->
	   		<div id="barEChartsId" style="width: 800px;height:400px;margin:100px auto;"></div>
	   	</div>
	   	
	   	<div class="count-box">
	   		 <!-- 饼状图 -->
    		<div id="pieEchartsId" style="width: 600px;height:500px;margin:50px auto;"></div>
	   	</div>
	   	<div class="count-box">
	   		 <!-- 中国地图 -->
    		<div id="main" style="width: 100%;height:600px;"></div>
	   	</div>
	   	
   	</div>
   
  </div>

</body>
 <script type="text/javascript">
 		/* 柱状图js部分开始 */
       // 基于准备好的dom，初始化echarts实例   月份注册人数柱状图
       var MyBarECharts = echarts.init(document.getElementById('barEChartsId'));
       
        // 去重复
       //$.unique(listMark); 
      // 指定图表的配置项和数据   柱状图
      var barECharts = {
            title: {
                text: '个类理财投资记录'
            },
            tooltip: {},
            legend: {
                data:['销量']
            },
            // 横坐标
            xAxis: {
            	data: ['${markName[0]}','${markName[1]}']
            },   
            yAxis: {},
            toolbox: {
                show : true,
                orient : 'vertical',
                x: 'right',
                y: 'center',
                feature : {
                    dataView : {show: true, readOnly: false},
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            // 纵坐标
            series: [{
                name: '金额(元)',
                type: 'bar',
                data: ${listMarkMoney}
            }]
            
        };
        // 使用刚指定的配置项和数据显示图表。  柱状图
        MyBarECharts.setOption(barECharts);
       
        /* 柱状图JS部分结束  */
        
        /* 饼状图JS部分开始 */ 
        var myPieChart = echarts.init(document.getElementById('pieEchartsId'));
        var man = ${man};
        var woman = ${woman};
		var pieEcharts = {
		    title : {
		        text: '投资人群性别占比',
		        x:'center',
		        textStyle:{
		        	color:'#FFB868',
		        	fontSize:'28',
		        }
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		        orient: 'vertical',
		        left: 'left',
		        data: ['直接访问','邮件营销']
		    },
		    toolbox: {
                show : true,
                orient : 'vertical',
                x: 'right',
                y: 'center',
                feature : {
                    dataView : {show: true, readOnly: false},
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
		    series : [
		        {
		            name: '访问来源',
		            type: 'pie',
		            radius : '55%',
		            center: ['50%', '60%'],
		            data:[
		                {value:man, name:'男'},
		                {value:woman, name:'女'},
		            ],
		            itemStyle: {
		                emphasis: {
		                    shadowBlur: 10,
		                    shadowOffsetX: 0,
		                    shadowColor: 'rgba(0, 0, 0, 0.7)',
		        
		                }
		            }
		        }
		    ],
		    color:['#FFC90E','#FFAEC9']
		};
		myPieChart.setOption(pieEcharts);
		/* 饼状图JS部分结束 */
		
		
		/* 中国地图JS开始 */
		require.config({
           paths:{
               "echarts":"/rhzb/jsp/frontpage/dist/echarts",
               "echarts/chart/map":"/rhzb/jsp/frontpage/dist/chart/map"
           }
       });

       //using
       require(
               [
                   "echarts",
                   "echarts/chart/map"
               ],
               function(ec){
                   var myChart=ec.init(document.getElementById("main"));
                   var option = {
                       title : {
                           text: '注册人数分布统计图',
                           subtext: '注册人数分布统计图',
                           x:'center'
                       },
                       tooltip : {
                           trigger: 'item'
                       },
                       legend: {
                           orient: 'vertical',
                           x:'left',
                           data:['注册人数分布统计图']
                       },
                       dataRange: {
                           min: 0,
                           max: 50000,
                           x: 'left',
                           y: 'bottom',
                           text:['高','低'],           // 文本，默认为数值文本
                           calculable : true
                       },
                       /* 这个方法是图有中各种小工具   如：把页面内容保存为图片 */
                       toolbox: {
                           show : true,
                           orient : 'vertical',
                           x: 'right',
                           y: 'center',
                           feature : {
                              /*  mark : {show: true}, */
                               dataView : {show: true, readOnly: false},
                               restore : {show: true},
                               saveAsImage : {show: true}
                           }
                       },
                       series : [
                           {
                               name: '注册人数分布统计图',
                               type: 'map',
                               mapType: 'china',
                               roam: false, 	// 是否支持地图缩放
                               itemStyle:{
                                   normal:{label:{show:true}},
                                   emphasis:{label:{show:true}}
                               },
                               data:${scatter}
                           }
                       ]
                   };
                   //loading data
                   myChart.setOption(option);
               }
       );
		/* 中国地图js部分结束 */
    </script>
</html>
