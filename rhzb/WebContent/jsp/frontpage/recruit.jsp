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
<title>金源宝——招贤纳士</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="jsp/frontpage/css/common.css" rel="stylesheet" />
<link href="jsp/frontpage/css/about.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="jsp/frontpage/script/jquery.min.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/common.js"></script>
</head>
<body>
<%@ include file="/jsp/frontpage/include/head.jsp"%>
<!--招贤纳士-->
<div class="bg">
  <div class="contain" id="tabs" style="margin:0 auto;">
    <div class="text-nav">
      <ul class="clearfix">
        <li> <a class="text-link" href="noticeCompany/openNotice">网站公告</a> </li>
        <li> <a class="text-link" href="newCompany/openNew">媒体报道</a> </li>
        <li> <a class="text-link" href="companyReportForm/selectCompanyReportForm">运营报告</a> </li>
        <li> <a class="text-link" href="index/companyInfo">公司简介</a> </li>
        <li> <a class="text-link" href="law/openlawPage?style=1">法律政策</a> </li>
        <li> <a class="text-link" href="law/openlawPage?style=2">法律声明</a> </li>
        <li> <a class="text-link" href="law/openlawPage?style=3">资费说明</a> </li>
        <li class="selected"> <a class="text-link" href="recruit/openrecruit">招贤纳士</a> </li>
        <li> <a class="text-link" href="relationUs/openRelation">联系我们</a> </li>
      </ul>
    </div>
    <div class="text-box">
      <div class="text-content" id="text-content">
	  		<h1 class="title" >招贤纳士</h1>
			<p class="mt10 cn_line">
				找对平台，跟对团队！你实现了吗？亿人宝由实力雄厚的股东联合金融、技术与法律领域的专业团队共同组建，资源条件充足，支援力量强大，现为福建地区首批专业从事“金融服务”的公司。目前因业务发展需要，面向社会寻觅有思想、有魄力，乐于从事互联网金融事业的有志青年，我们倡导“以人为本的家园文化”，您的加入，将和我们一起见证公司未来广阔的发展前景。公司工作环境优雅，薪水待遇优于同行业水平，未来发展及晋升空间广阔。欢迎金融界、法律界和网络技术人才的加盟！
			</p>
			<ul class="clearfix join">
		        <c:forEach items="${listrecruits}" var="rec">
		        	<li>${rec.headline}
		        		${rec.rejoin}
		        	</li>
		        </c:forEach>
		    </ul>  
		    <script type="text/javascript">
		    $(document).ready(function() {
	    		var aa = $(".join li");
	    		aa.hide();
	    		var cc=   $(".join li").eq(0);
	    		cc.show();
	    		var bb = '<a id="showall" style="color: red;">显示全部</a>';
	    		$('#abcd').append(bb);
    			$("#showall").click(function(){
    				aa.show();
    				$('#showall').remove();
    			});
		    });
		    </script>
		    <div class="join_end">
				<p class="cn_line" id="abcd" style="text-indent:0;">
					<span style="line-height:2;font-family:Microsoft YaHei;color:#0aaae1;font-size:24px;">热诚欢迎有志青年加盟！共创互联网金融宏伟蓝图。</span>
					<br>
					<span style="line-height:2;">如果您对我们的事业感兴趣，请将您的个人简历发送到人力资源部邮箱</span><span style="line-height:2;color:#0aaae1;">hr@yirendai.com</span><span style="line-height:2;">，我们将尽快与您联系。</span>
				</p>
			</div>  
      </div>
    </div>
  </div>
</div>
<!--网站底部-->
<%@ include file="/jsp/frontpage/include/foot.jsp"%>
</body>
</html>
