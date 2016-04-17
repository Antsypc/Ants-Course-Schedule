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
  
</head>
<body class="hold-transition skin-blue sidebar-mini fixed ">
  
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
              <span class="label label-warning">1</span>
            </a>
            <ul class="dropdown-menu">
              <li class="header">您有 1 条未读消息</li>
              <li>
                <ul class="menu">
                  <li>
                    <a href="#">
                      <i class="fa fa-users text-aqua"></i> 5 new members joined today
                    </a>
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
              <img src="<%=request.getContextPath()%>/assets/img/teacher.png" class="user-image" alt="User Image">
              <!-- hidden-xs hides the username on small devices so only the image appears. -->
              <span class="hidden-xs">${requestScope.user.name }</span>
            </a>
            <ul class="dropdown-menu">
              <!-- The user image in the menu -->
              <li class="user-header">
                <img src="<%=request.getContextPath()%>/assets/img/teacher.png" class="img-circle" alt="User Image">
                <p>${requestScope.user.name } - 教师<small>登录时间: <%=now %></small></p>
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
          <img src="<%=request.getContextPath()%>/assets/img/teacher.png" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>${requestScope.user.name } </p>
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
          
          <!-- 主页-->
          <li class="header"></li>
          <li class="">
            <a href="<%=request.getContextPath()%>">
              <i class="fa fa-home"></i><span>主页</span>
            </a>
          </li>
          
          <!-- 教师课程管理模块 -->
          <li class="header">课程管理</li>
          <li class="">
            <a href="<%=request.getContextPath()%>/course/schedule">
              <i class="fa fa-link"></i><span>课程教学计划</span>
            </a>
          </li>
          <li class="">
            <a href="#">
              <i class="fa fa-link"></i><span>课程资料</span>
            </a>
          </li>
          
          <!-- 教师学生管理模块 -->
          <li class="header">学生管理</li>
          <li class="">
            <a href="<%=request.getContextPath()%>/student/students">
              <i class="fa fa-link"></i><span>花名册管理</span>
            </a>
          </li>
          <li class="">
            <a href="<%=request.getContextPath()%>/student/results">
              <i class="fa fa-link"></i><span>成绩管理</span>
            </a>
          </li>
          
          <!-- 教师管理模块  -->
          <li class="header">实验室</li>
          <li class="">
            <a href="">
              <i class="fa fa-link"></i>
              <span>实验室预约申请</span>
              <i class="fa fa-angle-left pull-right"></i>
            </a>
            <ul class="treeview-menu">
              <li class="">
                <a href="<%=request.getContextPath()%>/lab/search">
                  <i class="fa fa-circle-o"></i><span>实验室查询</span>
                </a>
              </li>
              <li class="">
                <a href="<%=request.getContextPath()%>/lab/reservation">
                  <i class="fa fa-circle-o"></i><span>我的预约</span>
                </a>
              </li>
            </ul>
          </li>
          
          <!-- 教师器材管理模块 -->
          <li class="">
            <a href="">
              <i class="fa fa-link"></i><span>实验器材</span>
              <i class="fa fa-angle-left pull-right"></i>
            </a>
            <ul class="treeview-menu">
              <li class="">
                <a href="#">
                  <i class="fa fa-circle-o"></i><span>实验器材申请</span>
                </a>
              </li>
              <li class="">
                <a href="#">
                  <i class="fa fa-circle-o"></i><span>使用情况登记</span>
                </a>
              </li>
            </ul>
          </li>
      
          <!-- 个人资料模块-->
          <li class="header"></li>
          <li class="">
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
            <img class="profile-user-img img-responsive img-circle" src="<%=request.getContextPath()%>/assets/img/teacher.png" alt="User profile picture">
            <h3 class="profile-username text-center">${requestScope.user.name }</h3>
            <p class="text-muted text-center">${requestScope.user.title }</p>
            <ul class="list-group list-group-unbordered">
              <li class="list-group-item">
                <b>教师号</b> <a class="pull-right">${requestScope.user.id }</a>
              </li>
              <li class="list-group-item">
                <b>学院</b> <a class="pull-right">${requestScope.user.department }</a>
              </li>
              <li class="list-group-item">
                <b>入职年份</b> <a class="pull-right">${requestScope.user.inYear }</a>
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
                console.log(data);
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


    