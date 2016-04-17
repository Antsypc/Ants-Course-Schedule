<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
    String username = (String) session.getAttribute("name");
    String identity = (String) session.getAttribute("identity");
    
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String now = df.format(new Date());
    if("student".equals(identity)) {
        identity = "学生";
    } else if("teacher".equals(identity)) {
        identity = "教师";
    } else if("manager".equals(identity)) {
        identity = "管理员";
    }
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>实验室管理系统|首页</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/supersized.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/supersized.shutter.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/vendor/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/vendor/font-awesome/css/font-awesome.min.css">
	<script src="<%=request.getContextPath()%>/assets/vendor/jquery/dist/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/jquery.easing.min.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/assets/js/supersized.3.2.7.min.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/assets/js/supersized.shutter.min.js"></script>
	<script type="text/javascript">
			
			jQuery(function($){
				
				$.supersized({
				
					slideshow : 1,			// 轮播显示
					autoplay :	1,			// 自动播放
					start_slide : 1,			// 顺序播放
					stop_loop	:	0,			// 循环轮播
					random : 	0,			// 禁止随机播放
					slide_interval : 3000,		//设置转场时间
					transition : 6, 			// 向右轮播
					transition_speed : 1000,		//播放速度
					new_window : 1,			// 禁止点击图片打开新的窗口
					pause_hover : 0,			// 禁用鼠标悬停时停止播放事件
					keyboard_nav : 0,			// 键盘响应（开/关）
					performance	:	1,			
					image_protect	:	1,		// 禁用图片拖动
															   
					// 大小和位置					   
					min_width : 0,			
					min_height : 0,	
					vertical_center : 1,			// 设置垂直居中
					horizontal_center : 1,		// 设置水平居中
					fit_always	:	0,	    	// 图片永远不能超过浏览器的高度和宽度
					fit_portrait : 1,			// 图片不能超过浏览器高度
					fit_landscape	: 0,		
															   
					// 组件						
					slide_links	:	'blank',
					thumb_links	:	1,	
					thumbnail_navigation : 0,	//不显示缩略图
					slides :[	// 轮播图片
										{image : '/assets/img/slide/img1.jpg', url : '/assets/img/slide/img1.jpg'},
										{image : '/assets/img/slide/img2.jpg', url : '/assets/img/slide/img2.jpg'},
										{image : '/assets/img/slide/3.jpg', url : '/assets/img/slide/3.jpg'},
										{image : '/assets/img/slide/4.jpg', url : '/assets/img/slide/4.jpg'}
									],		   
					progress_bar :	1,				
					mouse_scrub	:	0
					
				});
		   });
		    
		</script>
		<style type="text/css">
			.topbar {
				width: 100%;
				height: 64px;
 				border-bottom: 1px solid #888;
    		background-color:rgba(03,03,03,.6);
    		z-index: 100;
			}
			.navbar-text {
				font-size: 24px;
				font-family: inherit;
				color: #FFF;
			}
			.login-btn {
				height: 2em;
				border-radius: 2em;
				border: 1px solid #DDD;
				text-decoration: none;
				background-color: #FFF;
				display: inline-block;
				padding: 0 2em;
				line-height: 2em;
				margin-top: 19px;
				cursor: pointer;
				color: #323a45;
			}
			a:hover {
				text-decoration: none;
				background-color: #FFE;
				color: #323a45;
			}

		</style>
	</head>
<body>
	<div class="container topbar">
		<p class="navbar-text">Ants 选课系统</p>
		<div style="float:right;"><a class="login-btn" href="<%=request.getContextPath()%>/login">登录</a></div>
	</div>
	<!--轮播前进、后退样式-->
	<div id="prevthumb"></div>
	<div id="nextthumb"></div>
	<a id="prevslide" class="load-item"></a>
	<a id="nextslide" class="load-item"></a>
	<div id="thumb-tray" class="load-item">
		<div id="thumb-back"></div>
		<div id="thumb-forward"></div>
	</div>
	
	<!--底部进度条显示-->
	<div id="progress-back" class="load-item">
		<div id="progress-bar"></div>
	</div>
	
	<!--底部控制模块-->
	<div id="controls-wrapper" class="load-item">
		<div id="controls">
			<!--底部计数器-->
			<div id="slidecounter">
				<span class="slidenumber"></span> / <span class="totalslides"></span>&nbsp;
				<span><strong>Copyright &copy; 2016 Ants Young.</strong> All rights reserved.</span>
			</div>
			<!--底部导航-->
			<ul id="slide-list"></ul>
		</div>
	</div>

</body>
</html>