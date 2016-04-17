<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
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
                <img src="" class="user-image" alt="User Image">
                <!-- hidden-xs hides the username on small devices so only the image appears. -->
                <span class="hidden-xs">${requestScope.user.name }</span>
              </a>
              <ul class="dropdown-menu">
                <!-- The user image in the menu -->
                <li class="user-header">
                  <img src="<%=request.getContextPath()%>/assets/img/student.png" class="img-circle" alt="User Image">
                  <p>${requestScope.user.name } - 学生<small>登录时间: <%=now %></small></p>
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
              ${requestScope.user.name }
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
            <li>
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
            <li class="active">
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
        <h1>个人信息 <small>User Profile</small></h1>

        <ol class="breadcrumb">
          <li><a href="<%=request.getContextPath()%>"><i class="fa fa-dashboard"></i>主页</a></li>
          <li class="active">个人信息</li>
        </ol>

      </section>

      <!-- Main content -->
      <section class="content">

        <div class="row">
          <div class="col-md-9">
            <div class="nav-tabs-custom">
              <ul class="nav nav-tabs">
                <li class="active"><a href="#essentialInfo" data-toggle="tab">基本信息</a></li>
                <li><a href="#settings" data-toggle="tab">更改信息</a></li>
              </ul>
              <div class="tab-content">
                <div class="active tab-pane" id="essentialInfo">
                  <div class="box-body box-profile">
                    <img class="profile-user-img img-responsive img-circle" src="<%=request.getContextPath()%>/assets/img/student.png" alt="User profile picture">
                    <h3 class="profile-username text-center">${requestScope.user.name }</h3>
                    <p class="text-muted text-center">${requestScope.user.studentClass }</p>
                    <ul class="list-group list-group-unbordered">
                      <li class="list-group-item">
                        <b>学号</b> <a class="pull-right">${requestScope.user.id }</a>
                      </li>
                      <li class="list-group-item">
                        <b>学院</b> <a class="pull-right">${requestScope.user.department }</a>
                      </li>
                      <li class="list-group-item">
                        <b>专业</b> <a class="pull-right">${requestScope.user.major }</a>
                      </li>
                      <li class="list-group-item">
                        <b>籍贯</b> <a class="pull-right">${requestScope.user.nativePlace }</a>
                      </li>
                      <li class="list-group-item">
                        <b>电话</b> <a class="pull-right">${requestScope.user.phone }</a>
                      </li>
                      <li class="list-group-item">
                        <b>邮箱</b> <a class="pull-right">${requestScope.user.email }</a>
                      </li>
                    </ul>
                  </div>
                  <!-- /.box-body -->
                </div>
                <!-- /.tab-pane -->

                <div class="tab-pane" id="settings">
                  <form class="form-horizontal">
                    <div class="form-group">
                      <label for="inputTel" class="col-sm-2 control-label">电&nbsp;&nbsp;&nbsp;&nbsp;话</label>
                      <div class="col-sm-10">
                        <input type="tel" class="form-control" id="inputTel" placeholder="请输入电话">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="inputEmail" class="col-sm-2 control-label">邮&nbsp;&nbsp;&nbsp;&nbsp;箱</label>
                      <div class="col-sm-10">
                        <input type="email" class="form-control" id="inputEmail" placeholder="请输入邮箱">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="inputOldPassword" class="col-sm-2 control-label">旧密码</label>
                      <div class="col-sm-10">
                        <input type="password" class="form-control" id="inputOldPassword" placeholder="请输入原始密码">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="inputNewPassword" class="col-sm-2 control-label">新密码</label>
                      <div class="col-sm-10">
                        <input type="password" class="form-control" id="inputNewPassword" placeholder="请输入新密码">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="inputNewPassword2" class="col-sm-2 control-label">新密码</label>
                      <div class="col-sm-10">
                        <input type="password" class="form-control" id="inputNewPassword2" placeholder="请再次输入新密码">
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-danger change-confirm">确认修改</button>
                        <button type="submit" class="btn btn-default">取消修改</button>
                      </div>
                    </div>
                  </form>
                </div>
                <!-- /.tab-pane -->
              </div>
              <!-- /.tab-content -->
            </div>
            <!-- /.nav-tabs-custom -->
          </div>
          <!-- /.col -->
        </div>

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
  <script type="text/javascript">
  $(".change-confirm").on('click',function() {
      var phone = $("#inputTel").val();
      var email = $("#inputEmail").val();
      var oldpassword = $("#inputOldPassword").val();
      var newpassword = $("#inputNewPassword").val();
      var newpassword2 = $("#inputNewPassword2").val();
      if (newpassword != newpassword2) {
          alert("两次新密碼不一致");
          return false;
      }
      
      var data = {
          phone : phone,
          email : email,
          oldpassword : oldpassword,
          newpassword : newpassword
      };
      data = JSON.stringify(data);
      $.ajax({
          type:"POST",
          contentType:"application/json",
          dataType:"json",
          data: data,
          url:"<%=request.getContextPath()%>/profile",
          success : function(data) {
              window.location.reload();
          },
          error: function(data) {
              console.log(data);
          }
      });
      return false;
  });
  </script>
</body>

</html>
