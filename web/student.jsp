<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
    String username = (String) session.getAttribute("name");
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String now = df.format(new Date());
%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="chrome=1,IE=edge">
  <title>Ants 选课系统</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

  <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/vendor/bootstrap/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/vendor/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/vendor/AdminLTE/dist/css/AdminLTE.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/vendor/AdminLTE/dist/css/skins/skin-blue.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/common.css">
  <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body class="hold-transition skin-blue sidebar-mini fixed">

  <div class="wrapper">
    <header class="main-header">
      <a href="<%=request.getContextPath()%>" class="logo">
        <span class="logo-mini">Course</span>
        <span class="logo-lg">Ants 选课系统</span>
      </a>

      <nav class="navbar navbar-static-top" role="navigation">
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
          <span class="sr-only">切换导航</span>
        </a>
        <!-- Navbar Right Menu -->
        <div class="navbar-custom-menu">
          <ul class="nav navbar-nav">
            <!-- Notifications Menu -->
            <li class="dropdown notifications-menu">
              <!-- Menu toggle button -->
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                <i class="fa fa-bell-o"></i>
              </a>
              <ul class="dropdown-menu">
                <li class="header">您有 0 条未读消息</li>
                <li>
                  <ul class="menu">
                    <li>
                      <a href="#">暂无消息</a>
                    </li>
                  </ul>
                </li>
                <li class="footer"><a href="#">查看全部消息</a></li>
              </ul>
            </li>

            <!-- User Account Menu -->
            <li class="dropdown user user-menu">
              <!-- Menu Toggle Button -->
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                <!-- The user image in the navbar-->
                <img src="<%=request.getContextPath()%>/assets/img/student.png" class="user-image" alt="User Image">
                <!-- hidden-xs hides the username on small devices so only the image appears. -->
                <span class="hidden-xs"><%=username%></span>
              </a>
              <ul class="dropdown-menu">
                <!-- The user image in the menu -->
                <li class="user-header">
                  <img src="<%=request.getContextPath()%>/assets/img/student.png" class="img-circle" alt="User Image">
                  <p>
                    <%=username%> - 学生<small>登录时间: <%=now %></small></p>
                </li>
                <!-- Menu Footer-->
                <li class="user-footer">
                  <div class="pull-left">
                    <a href="<%=request.getContextPath()%>/profile" class="btn btn-default btn-flat">个人信息</a>
                  </div>
                  <div class="pull-right">
                    <a href="<%=request.getContextPath()%>/logout" class="btn btn-default btn-flat">退出</a>
                  </div>
                </li>
              </ul>
            </li>
          </ul>
        </div>
      </nav>
    </header>

    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
      <section class="sidebar">
        <!-- Sidebar user panel (optional) -->
        <div class="user-panel">
          <div class="pull-left image">
            <img src="<%=request.getContextPath()%>/assets/img/student.png" class="img-circle" alt="User Image">
          </div>
          <div class="pull-left info">
            <p>
              <%=username%>
            </p>
            <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
          </div>
        </div>

        <!-- search form (Optional) -->
        <form action="#" method="get" class="sidebar-form">
          <div class="input-group">
            <input type="text" name="q" class="form-control" placeholder="搜索...">
            <span class="input-group-btn">
            <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i></button>
          </span>
          </div>
        </form>

        <!-- Sidebar Menu -->
        <ul class="sidebar-menu">
          <ul class="sidebar-menu">
            <li class="header"></li>
            <li class="active">
              <a href="<%=request.getContextPath()%>">
                <i class="fa fa-dashboard"></i>
                <span>主页</span>
              </a>
            </li>
            <li>
              <a href="<%=request.getContextPath()%>/student/course/choose">
                <i class="fa fa-graduation-cap"></i>
                <span>选课</span>
              </a>
            </li>
            <li>
              <a href="<%=request.getContextPath()%>/student/course">
                <i class="fa fa-calendar-o"></i>
                <span>我的课表</span>
              </a>
            </li>
            <li>
              <a href="<%=request.getContextPath()%>/student/scores">
                <i class="fa fa-tags"></i>
                <span>我的成绩</span>
              </a>
            </li>
            <li>
              <a href="#">
                <i class="fa fa-download"></i>
                <span>资料下载</span>
              </a>
            </li>
            <li class="header"></li>
            <li>
              <a href="<%=request.getContextPath()%>/profile">
                <i class="fa fa-user"></i>
                <span>个人资料</span>
              </a>
            </li>
          </ul>
        </ul>
      </section>
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <h1>Page Header <small>Optional description</small></h1>

        <ol class="breadcrumb">
          <li><a href="<%=request.getContextPath()%>"><i class="fa fa-dashboard"></i>主页</a></li>
          <li class="active">Here</li>
        </ol>

      </section>

      <!-- Main content -->
      <section class="content">
        <ul class="timeline">
          <li class="time-label">
            <span class="bg-red">2016 年 01 月 03 日</span>
          </li>
          <li>
            <i class="fa fa-envelope bg-blue"></i>
            <div class="timeline-item">
              <span class="time"><i class="fa fa-clock-o"></i> 22:45</span>
              <h3 class="timeline-header"><a href="#">理工四少</a> 发布了一个公告</h3>
              <div class="timeline-body">
                “我们的实验室管理系统终于完成了！”
                <br> 经过了为期一个月的艰苦奋斗，宵衣旰食、乐此不疲的Coding，我们的成果终于和大家见面了！欢迎大家使用！
              </div>
              <div class="timeline-footer">
                <a class="btn btn-primary btn-xs">阅读详情</a>
              </div>
            </div>
          </li>
          <li class="time-label">
            <span class="bg-red">2016 年 01 月 02 日</span>
          </li>
          <li>
            <i class="fa fa-envelope bg-blue"></i>
            <div class="timeline-item">
              <span class="time"><i class="fa fa-clock-o"></i> 10:45</span>
              <h3 class="timeline-header"><a href="#">高文昌</a> 发布了一个公告</h3>
              <div class="timeline-body">
                “新进浓硫酸”
                <br> 东院302实验室新进了一批浓硫酸，欢迎大家来品尝~~~^_^
              </div>
              <div class="timeline-footer">
                <a class="btn btn-primary btn-xs">阅读详情</a>
              </div>
            </div>
          </li>
          <li class="time-label">
            <span class="bg-red">2015 年 12 月 27 日</span>
          </li>
          <li>
            <i class="fa fa-envelope bg-blue"></i>
            <div class="timeline-item">
              <span class="time"><i class="fa fa-clock-o"></i> 08:00</span>
              <h3 class="timeline-header"><a href="#">邓飞</a> 发布了一个公告</h3>
              <div class="timeline-body">
                “走上人生巅峰第一步———>>>”
                <br> 鉴主12楼的实验室全部换成了苹果电脑，小伙伴们快来体验吧~
              </div>
              <div class="timeline-footer">
                <a class="btn btn-primary btn-xs">阅读详情</a>
              </div>
            </div>
          </li>
          <li class="time-label">
            <span class="bg-red">2016 年 01 月 01 日</span>
          </li>
          <li>
            <i class="fa fa-envelope bg-blue"></i>
            <div class="timeline-item">
              <span class="time"><i class="fa fa-clock-o"></i> 12:45</span>
              <h3 class="timeline-header"><a href="#">李进锋</a> 发布了一个公告</h3>
              <div class="timeline-body">
                “天上掉馅饼”
                <br> 鉴主的实验室器材全部报废了，哈哈哈哈，大家可以好好休息几天不用做实验了。。。
              </div>
              <div class="timeline-footer">
                <a class="btn btn-primary btn-xs">阅读详情</a>
              </div>
            </div>
          </li>
          <li class="time-label">
            <span class="bg-red">2015 年 12 月 10 日</span>
          </li>
          <li>
            <i class="fa fa-envelope bg-blue"></i>
            <div class="timeline-item">
              <span class="time"><i class="fa fa-clock-o"></i> 12:45</span>
              <h3 class="timeline-header"><a href="#">杨鹏程</a> 发布了一个公告</h3>
              <div class="timeline-body">
                “开始撸代码了”
                <br> 小伙伴们，理工四少又要开始发功了，实验室管理系统，走着~
              </div>
              <div class="timeline-footer">
                <a class="btn btn-primary btn-xs">阅读详情</a>
              </div>
            </div>
          </li>


          <li>
            <i class="fa fa-clock-o bg-gray"></i>
          </li>
      </section>
    </div>

    <!-- Main Footer -->
    <footer class="main-footer">
      <strong>Copyright &copy; 2016 Ants Young.</strong> All rights reserved.
    </footer>
  </div>

  <script src="<%=request.getContextPath()%>/assets/vendor/jquery/dist/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/assets/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
  <script src="<%=request.getContextPath()%>/assets/vendor/AdminLTE/plugins/slimScroll/jquery.slimscroll.min.js"></script>
  <script src="<%=request.getContextPath()%>/assets/vendor/AdminLTE/plugins/fastclick/fastclick.min.js"></script>
  <script src="<%=request.getContextPath()%>/assets/vendor/AdminLTE/dist/js/app.min.js"></script>
  <script src="<%=request.getContextPath()%>/assets/js/common.js"></script>
</body>

</html>
