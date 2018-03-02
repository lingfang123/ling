<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资金托管后台</title>
 <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/static/js/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.6.0/css/font-awesome.min.css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <![endif]-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/jquery.gritter/css/jquery.gritter.css" />

  	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/jquery.nanoscroller/nanoscroller.css" />
  	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/jquery.easypiechart/jquery.easy-pie-chart.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/bootstrap.switch/bootstrap-switch.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/bootstrap.datetimepicker/css/bootstrap-datetimepicker.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/jquery.select2/select2.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/bootstrap.slider/css/slider.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/intro.js/introjs.css" />
  	<!-- Custom styles for this template -->
  	<link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" />
</head>
<body>
  <!-- Fixed navbar -->
  <div id="head-nav" class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="fa fa-gear"></span>
        </button>
        <a class="navbar-brand" href="#"><span>易支付后台管理</span></a>
      </div>
      <div class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
          <li class="active"><a href="#">首页</a></li>
          <li><a href="#about">关于</a></li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">联系<b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="#">Action</a></li>
              <li><a href="#">Another action</a></li>
              <li><a href="#">Something else here</a></li>
      		</ul>
          </li>
        </ul>
	    <ul class="nav navbar-nav navbar-right user-nav">
	      <li class="dropdown profile_menu">
	        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><img alt="Avatar" src="${pageContext.request.contextPath}/static/images/avatar2.jpg" />
	        <span>admin</span> <b class="caret"></b></a>
	        <ul class="dropdown-menu">
	          <li><a href="#">我的资料</a></li>
	          <li><a href="#">修改资料</a></li>
	          <li class="divider">修改密码</li>
	          <li><a href="#">退出</a></li>
	        </ul>
	      </li>
	    </ul>			
    <ul class="nav navbar-nav navbar-right not-nav" >
      <li class="button dropdown">
        <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"><i class=" fa fa-comments"></i></a>
        <ul class="dropdown-menu messages">
          <li>
            <div class="nano nscroller">
              <div class="content">
                <ul>
                  <li>
                    <a href="#">
                      <img src="${pageContext.request.contextPath}/static/images/avatar2.jpg" alt="avatar" /><span class="date pull-right">13 Sept.</span> <span class="name">Daniel</span> I'm following you, and I want your money! 
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <img src="${pageContext.request.contextPath}/static/images/avatar_50.jpg" alt="avatar" /><span class="date pull-right">20 Oct.</span><span class="name">Adam</span> is now following you 
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <img src="${pageContext.request.contextPath}/static/images/avatar4_50.jpg" alt="avatar" /><span class="date pull-right">2 Nov.</span><span class="name">Michael</span> is now following you 
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <img src="${pageContext.request.contextPath}/static/images/avatar3_50.jpg" alt="avatar" /><span class="date pull-right">2 Nov.</span><span class="name">Lucy</span> is now following you 
                    </a>
                  </li>
                </ul>
              </div>
            </div>
            <ul class="foot"><li><a href="#">View all messages </a></li></ul>           
          </li>
        </ul>
      </li>
      <li class="button dropdown">
        <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-globe"></i><span class="bubble">2</span></a>
        <ul class="dropdown-menu">
          <li>
            <div class="nano nscroller">
              <div class="content">
                <ul>
                  <li><a href="#"><i class="fa fa-cloud-upload info"></i><b>Daniel</b> is now following you <span class="date">2 minutes ago.</span></a></li>
                  <li><a href="#"><i class="fa fa-male success"></i> <b>Michael</b> is now following you <span class="date">15 minutes ago.</span></a></li>
                  <li><a href="#"><i class="fa fa-bug warning"></i> <b>Mia</b> commented on post <span class="date">30 minutes ago.</span></a></li>
                  <li><a href="#"><i class="fa fa-credit-card danger"></i> <b>Andrew</b> killed someone <span class="date">1 hour ago.</span></a></li>
                </ul>
              </div>
            </div>
            <ul class="foot"><li><a href="#">View all activity </a></li></ul>           
          </li>
        </ul>
      </li>
      <li class="button"><a href="javascript:;" class="speech-button"><i class="fa fa-microphone"></i></a></li>				
    </ul>

      </div><!--/.nav-collapse animate-collapse -->
    </div>
  </div>

	<div id="cl-wrapper" class="fixed-menu">
		<div class="cl-sidebar" data-position="right" data-step="1" >
			<div class="cl-toggle"><i class="fa fa-bars"></i></div>
			<div class="cl-navblock">
        <div class="menu-space">
          <div class="content">
            <div class="side-user">
              <div class="avatar"><img src="${pageContext.request.contextPath}/static/images/avatar1_50.jpg" alt="Avatar" /></div>
              <div class="info">
                <a href="#">admin</a>
                <img src="${pageContext.request.contextPath}/static/images/state_online.png" alt="Status" /> <span>在线</span>
              </div>
            </div>
            <ul class="cl-vnavigation">
              <li><a href="#"><i class="fa fa-home"></i><span>站内管理</span></a>
                <ul class="sub-menu">
                  <li class="active"><a href="index-2.html">Version 1</a></li>
                  <li><a href="dashboard2.html"><span class="label label-primary pull-right">New</span> Version 2</a></li>
                </ul>
              </li>
              <li><a href="#"><i class="fa fa-smile-o"></i><span>基本管理</span></a>
                <ul class="sub-menu">
                  <li><a href="ui-elements.html">管理员管理</a></li>
                  <li><a href="ui-modals.html">
                  <span class="label label-primary pull-right">New</span>角色管理</a></li>
                </ul>
              </li>
              <li><a href="#"><i class="fa fa-smile-o"></i><span>合作公司管理</span></a>
                <ul class="sub-menu">
                  <li><a href="ui-elements.html">合作管理</a></li>
                </ul>
                <ul class="sub-menu">
                  <li><a href="ui-elements.html">资金管理</a></li>
                </ul>
                <ul class="sub-menu">
                  <li><a href="ui-elements.html">通知管理</a></li>
                </ul>
                <ul class="sub-menu">
                  <li><a href="ui-elements.html">资金明细管理</a></li>
                </ul>
              </li>
              <li>
              	<a href="#"><i class="fa fa-smile-o"></i><span>托管用户管理</span></a>
                <ul class="sub-menu">
                  <li><a href="ui-elements.html">用户管理</a></li>
                </ul>
                <ul class="sub-menu">
                  <li><a href="ui-elements.html">用户银行卡管理</a></li>
                </ul>
                <ul class="sub-menu">
                  <li><a href="ui-elements.html">提现管理</a></li>
                </ul>
                <ul class="sub-menu">
                  <li><a href="ui-elements.html">充值管理</a></li>
                </ul>
                <ul class="sub-menu">
                  <li><a href="ui-elements.html">冻结资金管理</a></li>
                </ul>
                <ul class="sub-menu">
                  <li><a href="ui-elements.html">订单管理</a></li>
                </ul>
                <ul class="sub-menu">
                  <li><a href="ui-elements.html">资金明细管理</a></li>
                </ul>
              </li>
              <li><a href="#"><i class="fa fa-smile-o"></i><span>模拟银行</span></a>
                <ul class="sub-menu">
                  <li><a href="ui-elements.html">合作商统计</a></li>
                  <li><a href="ui-modals.html">用户统计</a></li>
                  <li><a href="ui-modals.html">资金流动统计</a></li>
                </ul>
              </li>
              <li><a href="#"><i class="fa fa-smile-o"></i><span>统计管理</span></a>
                <ul class="sub-menu">
                  <li><a href="ui-elements.html">合作商统计</a></li>
                  <li><a href="ui-modals.html">用户统计</a></li>
                  <li><a href="ui-modals.html">资金流动统计</a></li>
                </ul>
              </li>
              <li><a href="#"><i class="fa fa-smile-o"></i><span>日志监控</span></a>
                <ul class="sub-menu">
                  <li><a href="ui-elements.html">合作商统计</a></li>
                  <li><a href="ui-modals.html">用户统计</a></li>
                  <li><a href="ui-modals.html">资金流动统计</a></li>
                </ul>
              </li>
            </ul>
          </div>
        </div>
        <div class="text-right collapse-button" style="padding:7px 9px;">
          <input type="text" class="form-control search" placeholder="Search..." />
          <button id="sidebar-collapse" class="btn btn-default" style=""><i style="color:#fff;" class="fa fa-angle-left"></i></button>
        </div>
			</div>
		</div>
	
		<div class="container-fluid" id="pcont">
		  <div class="cl-mcont">
		  
			<div class="stats_bar">
				<div class="butpro butstyle" data-step="2">
					<div class="sub"><h2>CLIENTS</h2><span id="total_clientes">170</span></div>
					<div class="stat"><span class="spk1"><canvas style="display: inline-block; width: 74px; height: 16px; vertical-align: top;" width="74" height="16"></canvas></span></div>
				</div>
				<div class="butpro butstyle">
					<div class="sub"><h2>Sales</h2><span>$951,611</span></div>
					<div class="stat"><span class="up"> 13,5%</span></div>
				</div>
				<div class="butpro butstyle">
					<div class="sub"><h2>VISITS</h2><span>125</span></div>
					<div class="stat"><span class="down"> 20,7%</span></div>
				</div>	
				<div class="butpro butstyle">
					<div class="sub"><h2>NEW USERS</h2><span>18</span></div>
					<div class="stat"><span class="equal"> 0%</span></div>
				</div>	
				<div class="butpro butstyle">
					<div class="sub"><h2>AVERAGE</h2><span>3%</span></div>
					<div class="stat"><span class="spk2"></span></div>
				</div>
				<div class="butpro butstyle">
					<div class="sub"><h2>Downloads</h2><span>184</span></div>
					<div class="stat"><span class="spk3"></span></div>
				</div>	

			</div>

			<div class="row dash-cols">
			
				<div class="col-sm-6 col-md-6">
					<div class="block">
						<div class="header no-border">
							<h2>Sales</h2>
						</div>
						<div class="content blue-chart"  data-step="3">
							<div id="site_statistics" style="height:180px;"></div>
						</div>
						<div class="content">
							<div class="stat-data">
								<div class="stat-blue">
									<h2>1,254</h2>
									<span>Total Sales</span>
								</div>
							</div>
							<div class="stat-data">
								<div class="stat-number">
									<div><h2>83</h2></div>
									<div>Total hits<br /><span>(Daily)</span></div>
								</div>
								<div class="stat-number">
									<div><h2>57</h2></div>
									<div>Views<br /><span>(Daily)</span></div>
								</div>
							</div>
							<div class="clear"></div>
						</div>
					</div>
				</div>	
				
				<div class="col-sm-6 col-md-6">
					<div class="block">
						<div class="header no-border">
							<h2>Monitor</h2>
						</div>
						<div class="content red-chart">
							<div id="site_statistics2" style="height:152px;"></div>
						</div>
						<div class="content no-padding">
							<table class="red">
								<thead>
									<tr>
										<th>Name</th>
										<th class="right"><span>25%</span>C.P.U</th>
										<th class="right"><span>29%</span>Memory</th>
										<th class="right"><span>16%</span>Disc</th>
									</tr>
								</thead>
								<tbody class="no-border-x">
									<tr>
										<td style="width:40%;"><i class="fa fa-sitemap"></i> Server load</td>
										<td class="text-right">0,2%</td>
										<td class="text-right">13,2 MB</td>
										<td class="text-right">0,1 MB/s</td>
									</tr>
									<tr>
										<td><i class="fa fa-tasks"></i> Apps</td>
										<td class="text-right">0,2%</td>
										<td class="text-right">13,2 MB</td>
										<td class="text-right">0,1 MB/s</td>
									</tr>
									<tr>
										<td><i class="fa fa-signal"></i> Process</td>
										<td class="text-right">0,2%</td>
										<td class="text-right">13,2 MB</td>
										<td class="text-right">0,1 MB/s</td>
									</tr>
									<tr>
										<td><i class="fa fa-bolt"></i> Wamp Server</td>
										<td class="text-right">0,2%</td>
										<td class="text-right">13,2 MB</td>
										<td class="text-right">0,1 MB/s</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row dash-cols">
				<div class="col-sm-6 col-md-6">
					<div class="block">
						<div class="header">
							<h2>Invoice <span class="pull-right">#45</span></h2>
							<h3>Your order has been delivered</h3>
						</div>
						<div class="content no-padding ">
							<ul class="items">
								<li>
									<i class="fa fa-file-text"></i>Filet Mignon <span class="pull-right value">$35</span>
									<small>Italian food</small>
								</li>
								<li>
									<i class="fa fa-file-text"></i>Blue beer<span class="pull-right value">$35</span>
									<small>Bar drinks</small>
								</li>
								<li>
									<i class="fa fa-file-text"></i>T-shirts<span class="pull-right value">$35</span>
									<small>Software development</small>
								</li>
								<li>
									<i class="fa fa-file-text"></i>Cloud App<span class="pull-right value">$35</span>
									<small>Game department</small>
								</li>
								<li>
									<i class="fa fa-file-text"></i>Black Metal Music<span class="pull-right value">$35</span>
									<small>Metal genre</small>
									
								</li>
							</ul>
						</div>
							<div class="total-data bg-blue" >
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">
									<h2>Total <b class="caret"></b> <span class="pull-right">$25.3</span></h2>
								</a>
								<ul class="dropdown-menu">
									<li><a href="#">Print receipt</a></li>
									<li><a href="#">Send invoice to...</a></li>
									<li><a href="#">Payment</a></li>
								</ul>
							</div>
					</div>
				</div>	
				<div class="col-sm-6 col-md-6">
						<ul class="nav nav-tabs">
						  <li class="active"><a href="#home" data-toggle="tab">Home</a></li>
						  <li><a href="#profile" data-toggle="tab">Profile</a></li>
						  <li><a href="#messages" data-toggle="tab">Messages</a></li>
						</ul>
						<div class="tab-content">
						  <div class="tab-pane active cont" id="home">
								<h2 class="text-center">Our Experience</h2>
								<div id="piec" style="height:300px;margin-top:25px;"></div>
						  </div>
						  <div class="tab-pane cont" id="profile">
						  		<h2>Typography</h2>
								<p>Pellentesque ac quam hendrerit, viverra leo eu, <b>dapibus mi</b>. In at luctus massa. Morbi semper nulla eu velit facilisis pellentesque. Mauris adipiscing turpis in bibendum tempus. <i>Donec viverra</i>, lacus ac mollis rhoncus, libero risus placerat nisi, et viverra justo eros eget dui. Mauris convallis et tellus non <a href="#">placerat</a>.</p>
                <p>Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Fusce gravida est eros, eget porta leo fringilla et. </p>
                <a href="#">Read more</a>
						  </div>
						  <div class="tab-pane" id="messages">
                <h2 class="hthin">A Lorem Ipsum Story</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent a metus pulvinar turpis porttitor imperdiet vel nec justo. Nam id orci purus. Mauris arcu velit, auctor et aliquam quis, rhoncus a velit. Sed laoreet ultrices dolor eget vehicula. Morbi adipiscing euismod nisi, eget tincidunt arcu laoreet at.</p>
                <p>Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Etiam et tortor ultricies, mollis nunc eget, gravida sapien.</p>
              </div>
						</div>
				</div>		
			</div>

			<div class="row dash-cols">
        <div class="col-sm-6 col-md-6">
          <div class="widget-block  white-box calendar-box">
            <div class="col-md-6 blue-box calendar no-padding">
              <div class="padding ui-datepicker"></div>
            </div>
            <div class="col-md-6">
              <div class="padding">
                <h2 class="text-center">Monday</h2>
                <h1 class="day">2</h1>
              </div>
            </div>
          </div>
          
          <div class="widget-block photo white-box weather-box">
            <div class="col-md-6 padding photo">
              <h2 class="text-center">Monday</h2>
              <h1 class="day">10/12/2013</h1>
            </div>
            <div class="col-md-6 red-box">
              <div class="padding text-center">
                <canvas id="sun-icon" width="130" height="215"></canvas>
              </div>
            </div>
          </div>
        </div>
        
				<div class="col-sm-6 col-md-6">
					<ul class="nav nav-tabs">
					  <li class="active"><a href="#chat-1" data-toggle="tab">Adam</a></li>
					  <li><a href="#chat-2" data-toggle="tab">Mike</a></li>
					  <li><a href="#chat-3" data-toggle="tab">Lucy</a></li>
					</ul>
					<div class="tab-content no-padding">
					  <div class="tab-pane active cont" id="chat-1">
						<div class="chat-wi">
							<div class="chat-space nano nscroller">
								<div class="chat-content content">
									<div class="chat-conv">
										<img alt="Avatar" class="c-avatar ttip" src="${pageContext.request.contextPath}/static/images/avatar1_50.jpg" data-toggle="tooltip" title="MiguelMich" />
										<div class="c-bubble">
											<div class="msg">Hello, what can i do for you?</div>
											<div><small>12:20 p.m.</small></div>
											<span></span>
										</div>
									</div>
									<div class="chat-conv sent">
										<img alt="Avatar" class="c-avatar ttip" src="${pageContext.request.contextPath}/static/images/avatar_50.jpg" data-toggle="tooltip" title="Adam" />
										<div class="c-bubble">
											<div class="msg">Hi, i need support with my iPhone?</div>
											<div><small>12:25 p.m.</small></div>
											<span></span>
										</div>
									</div>
									<div class="chat-conv">
										<img alt="Avatar" class="c-avatar ttip" src="${pageContext.request.contextPath}/static/images/avatar1_50.jpg" data-toggle="tooltip" title="MiguelMich" />
										<div class="c-bubble">
											<div class="msg">Hello, how are you? i just though you were here, i'll see you tomorrow.</div>
											<div><small>12:30 p.m.</small></div>
											<span></span>
										</div>
									</div>
									<div class="chat-conv sent">
										<img alt="Avatar" class="c-avatar ttip" src="${pageContext.request.contextPath}/static/images/avatar_50.jpg" data-toggle="tooltip" title="Adam" />
										<div class="c-bubble">
											<div class="msg">Hi, i need support with my iPhone?</div>
											<div><small>12:25 p.m.</small></div>
											<span></span>
										</div>
									</div>									
								</div>
							</div>
							<div class="chat-in">
								<form action="http://condorthemes.com/cleanzone/dfgdfg" method="post" name="sd">
									<input type="submit" value="SEND" class="btn btn-info pull-right" />
									<div class="input">
										<input type="text" placeholder="Send a message..." name="msg" />
									</div>
									<div class="chat-tools">
										<ul class="nav nav-pills">
										  <li class="active"><i class="fa fa-location-arrow"></i></li>
										  <li><i class="fa fa-camera"></i></li>
										  <li><i class="fa fa-microphone"></i></li>
										  <li><i class="fa fa-cloud"></i></li>
										</ul>
									</div>
								</form>
							</div>
						</div>						  
					  </div>
					  <div class="tab-pane cont" id="chat-2">
						<div class="chat-wi">
							<div class="chat-space nano nscroller">
								<div class="chat-content content">
									<div class="chat-conv sent">
										<img alt="Avatar" class="c-avatar ttip" src="${pageContext.request.contextPath}/static/images/avatar4_50.jpg" data-toggle="tooltip" title="Adam" />
										<div class="c-bubble">
											<div class="msg">Hey, are you there?</div>
											<div><small>12:25 p.m.</small></div>
											<span></span>
										</div>
									</div>
									<div class="chat-conv">
										<img alt="Avatar" class="c-avatar ttip" src="${pageContext.request.contextPath}/static/images/avatar1_50.jpg" data-toggle="tooltip" title="MiguelMich" />
										<div class="c-bubble">
											<div class="msg">I'm here, how was your day?</div>
											<div><small>12:20 p.m.</small></div>
											<span></span>
										</div>
									</div>										
									<div class="chat-conv sent">
										<img alt="Avatar" class="c-avatar ttip" src="${pageContext.request.contextPath}/static/images/avatar4_50.jpg" data-toggle="tooltip" title="Adam" />
										<div class="c-bubble">
											<div class="msg">It was fine, just making some designs...</div>
											<div><small>12:25 p.m.</small></div>
											<span></span>
										</div>
									</div>									
								</div>
							</div>
							<div class="chat-in">
								<form action="http://condorthemes.com/cleanzone/dfgdfg" method="post" name="sd">
									<input type="submit" value="SEND" class="btn btn-info pull-right" />
									<div class="input">
										<input type="text" placeholder="Send a message..." name="msg" />
									</div>
									<div class="chat-tools">
										<ul class="nav nav-pills">
										  <li class="active"><i class="fa fa-location-arrow"></i></li>
										  <li><i class="fa fa-camera"></i></li>
										  <li><i class="fa fa-microphone"></i></li>
										  <li><i class="fa fa-cloud"></i></li>
										</ul>
									</div>
								</form>
							</div>
						</div>						  
					  </div>
					  <div class="tab-pane" id="chat-3">
						<div class="chat-wi">
							<div class="chat-space nano nscroller">
								<div class="chat-content content">
									<div class="chat-conv">
										<img alt="Avatar" class="c-avatar ttip" src="${pageContext.request.contextPath}/static/images/avatar1_50.jpg" data-toggle="tooltip" title="MiguelMich" />
										<div class="c-bubble">
											<div class="msg">Hello, what can i do for you?</div>
											<div><small>12:20 p.m.</small></div>
											<span></span>
										</div>
									</div>
									<div class="chat-conv sent">
										<img alt="Avatar" class="c-avatar ttip" src="${pageContext.request.contextPath}/static/images/avatar3_50.jpg" data-toggle="tooltip" title="Lucy" />
										<div class="c-bubble">
											<div class="msg">Hi, i need support with my iPhone?</div>
											<div><small>12:25 p.m.</small></div>
											<span></span>
										</div>
									</div>
									<div class="chat-conv">
										<img alt="Avatar" class="c-avatar ttip" src="${pageContext.request.contextPath}/static/images/avatar1_50.jpg" data-toggle="tooltip" title="MiguelMich" />
										<div class="c-bubble">
											<div class="msg">Hello, how are you? i just though you were here, i'll see you tomorrow.</div>
											<div><small>12:30 p.m.</small></div>
											<span></span>
										</div>
									</div>
									<div class="chat-conv sent">
										<img alt="Avatar" class="c-avatar ttip" src="${pageContext.request.contextPath}/static/images/avatar3_50.jpg" data-toggle="tooltip" title="Lucy" />
										<div class="c-bubble">
											<div class="msg">Hi, i need support with my iPhone?</div>
											<div><small>12:25 p.m.</small></div>
											<span></span>
										</div>
									</div>									
								</div>
							</div>
							<div class="chat-in">
								<form action="http://condorthemes.com/cleanzone/dfgdfg" method="post" name="sd">
									<input type="submit" value="SEND" class="btn btn-info pull-right" />
									<div class="input">
										<input type="text" placeholder="Send a message..." name="msg" />
									</div>
									<div class="chat-tools">
										<ul class="nav nav-pills">
										  <li class="active"><i class="fa fa-location-arrow"></i></li>
										  <li><i class="fa fa-camera"></i></li>
										  <li><i class="fa fa-microphone"></i></li>
										  <li><i class="fa fa-cloud"></i></li>
										</ul>
									</div>
								</form>
							</div>
						</div>						  
					  </div>
					</div>
				</div>		
			
			</div>
			
			
			<div class="row dash-cols">
				<div class="col-sm-6 col-md-6 col-lg-4">
					<div class="widget-block">
						<div class="white-box padding">
							<div class="row info">
								<div>
									<h3>Your Goals</h3>
								</div>
								<div>
									<div id="com_stats" style="height:98px;"></div>
								</div>
							</div>
						</div>
					</div>
				</div>	
				<div class="col-sm-6 col-md-6 col-lg-4">
					<div class="widget-block">
						<div class="white-box padding">
							<div class="row info text-shadow">
								<div class="col-xs-12">
									<h3>Comments</h3>
								</div>
								<div class="col-xs-12">
									<div id="com2_stats" style="height:98px;"></div>
								</div>
							</div>
						</div>
					</div>
				</div>	
				<div class="col-sm-6 col-md-6 col-lg-4">
					<div class="widget-block">
						<div class="white-box">
							<div class="fact-data">
								<div class="epie-chart" data-percent="45"><span>0%</span></div>
							</div>
							<div class="fact-data no-padding text-shadow">
								<h3>Users sales</h3>
								<h2>4,522</h2>
								<p>Monthly sales from users.</p>
							</div>
						</div>
					</div>
				</div>	
			</div>

			<div class="row dash-cols">
				<div class="col-sm-6 col-md-6 col-lg-4">
					<div class="block">
						<div class="header">
							<h2><i class="fa fa-comment"></i>Comments</h2>
						</div>
						<div class="content no-padding">
							<div class="fact-data text-center">
								<h3>Positive</h3>
								<h2>60%</h2>
							</div>
							<div class="fact-data text-center">
								<h3>Negative</h3>							
								<h2>40%</h2>
							</div>
						</div>
					</div>
				</div>	
				<div class="col-sm-6 col-md-6 col-lg-4">
					<div class="block">
						<div class="header">
							<h2><i class="fa fa-bug"></i>Tickets</h2>
						</div>
						<div class="content no-padding">
							<div class="fact-data text-center">
								<h3>Frequency</h3>
								<h2>53%</h2>
							</div>
							<div class="fact-data text-center">
								<h3>Pending</h3>							
								<h2>13</h2>
							</div>
						</div>
					</div>
				</div>	
				<div class="col-sm-6 col-md-6 col-lg-4">
					<div class="block">
						<div class="header">
							<h2><i class="fa fa-comment"></i>Comments</h2>
						</div>
						<div class="content no-padding">
							<div class="fact-data text-center">
								<h3>Positive</h3>
								<h2>60%</h2>
							</div>
							<div class="fact-data text-center">
								<h3>Negative</h3>							
								<h2>40%</h2>
							</div>
						</div>
					</div>
				</div>					
			</div>
		
		  </div>
		</div> 
		
	</div>

	<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.gritter/js/jquery.gritter.js"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.nanoscroller/jquery.nanoscroller.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/behaviour/general.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/jquery.ui/jquery-ui.js" type="text/javascript"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.sparkline/jquery.sparkline.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.easypiechart/jquery.easy-pie-chart.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.nestable/jquery.nestable.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.switch/bootstrap-switch.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/jquery.select2/select2.min.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/static/js/skycons/skycons.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/static/js/bootstrap.slider/js/bootstrap-slider.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/static/js/intro.js/intro.js" type="text/javascript"></script>



  <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript">
      $(document).ready(function(){
        //initialize the javascript
        App.init();
        App.dashBoard();        
        
          introJs().setOption('showBullets', false).start();

      });
    </script>
	<script src="${pageContext.request.contextPath}/static/js/behaviour/voice-commands.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/bootstrap/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.flot/jquery.flot.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.flot/jquery.flot.pie.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.flot/jquery.flot.resize.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.flot/jquery.flot.labels.js"></script>
  </body>

<!-- Mirrored from condorthemes.com/cleanzone/ by HTTrack Website Copier/3.x [XR&CO'2013], Mon, 31 Mar 2014 14:32:27 GMT -->
</html>