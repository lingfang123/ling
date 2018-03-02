<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=path%>/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>金源宝——帮助中心</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="jsp/frontpage/css/common.css" rel="stylesheet" />
<link href="jsp/frontpage/css/help.css" rel="stylesheet" />
<script type="text/javascript" src="jsp/frontpage/script/jquery.min.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/common.js"></script>
</head>
<body>
<%@ include file="/jsp/frontpage/include/head.jsp"%>
<!--帮助中心-->
<div class="banner"> <img src="jsp/frontpage/images/help-banner.png" alt=""> </div>
<div class="content help-content">
  <dl>
    <dt>
      <ul class="content-tab">
        <li class="sel">安全保障</li>
        <li class="">我要投资</li>
        <li class="">我要借款</li>
        <li class="">我的账户</li>
        <li class="">名词解释</li>
      </ul>
    </dt>
    
    <dd class="question-list-wrap" style="display: block;">
      <ul>
     	<c:forEach items="${listHelpCenters}" var="helpl">
     		<c:if test="${helpl.classify eq 1}">
		        <li class="question">
		          <dl>
		            <dt>${helpl.issue}</dt>
		            <dd>${helpl.answer}</dd>
		          </dl>
		        </li>
	        </c:if>
       </c:forEach>
      </ul>
    </dd>
    
    <dd class="question-list-wrap" style="display: none;">
      <ul>
        <c:forEach items="${listHelpCenters}" var="helpl">
     		<c:if test="${helpl.classify eq 2}">
		        <li class="question">
		          <dl>
		            <dt>${helpl.issue}</dt>
		            <dd>${helpl.answer}</dd>
		          </dl>
		        </li>
	        </c:if>
       </c:forEach>
      </ul>
    </dd>  
        
    <dd class="question-list-wrap" style="display: none;">
      <ul>
        <c:forEach items="${listHelpCenters}" var="helpl">
     		<c:if test="${helpl.classify eq 3}">
		        <li class="question">
		          <dl>
		            <dt>${helpl.issue}</dt>
		            <dd>${helpl.answer}</dd>
		          </dl>
		        </li>
	        </c:if>
       </c:forEach>
      </ul>
    </dd>
    
    <dd class="question-list-wrap" style="display: none;">
      <ul>
        <c:forEach items="${listHelpCenters}" var="helpl">
     		<c:if test="${helpl.classify eq 4}">
		        <li class="question">
		          <dl>
		            <dt>${helpl.issue}</dt>
		            <dd>${helpl.answer}</dd>
		          </dl>
		        </li>
	        </c:if>
       </c:forEach>
      </ul>
    </dd>
    <dd class="question-list-wrap" style="display: none;">
      <ul>
        <c:forEach items="${listHelpCenters}" var="helpl">
     		<c:if test="${helpl.classify eq 5}">
		        <li class="question">
		          <dl>
		            <dt>${helpl.issue}</dt>
		            <dd>${helpl.answer}</dd>
		          </dl>
		        </li>
	        </c:if>
       </c:forEach>
      </ul>
    </dd>
  </dl>
</div>
<script type="text/javascript">
  $(function() {
    $(".question").on("click", "dt", function() {
      $(this).siblings("dd").toggle().closest(".question").siblings().find("dd").hide();
    });

    $(".content-tab").on("click", "li", function() {
      var me = $(this);
      var index = me.index();
      
      me.addClass("sel").siblings().removeClass("sel");
      me.closest("dl").find("dd.question-list-wrap:eq("+index+")").show().siblings(".question-list-wrap").hide();
    }).find(".sel").trigger('click');
  });
</script>
<!--网站底部-->
<%@ include file="/jsp/frontpage/include/foot.jsp"%>
<script type="text/javascript">
	seajs.use(['$',''],function($,Accordion){
		$(document).ready(function(){
			var accordion = new Accordion({
			    element: '#faq',
			    triggers: '.accordion-trigger',
			    panels: '.accordion-panel',
			    activeIndex: -99,
			    multiple: true,
			}).render();
			accordion.on('switch',function(toIndex, fromIndex){
				var obj = $($(".accordion-trigger")[toIndex]).children("span");
				if(obj.hasClass('icon-arrow-down2')){
					obj.removeClass('icon-arrow-down2');
					obj.addClass('icon-arrow-up2');
				}else{
					obj.removeClass('icon-arrow-up2');
					obj.addClass('icon-arrow-down2');
				}
			})
		});
	});
</script>
</body>
</html>
