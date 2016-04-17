<%@page import="com.fasterxml.jackson.annotation.JsonTypeInfo.Id"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
  <title>实验室管理系统</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  
  <link rel="stylesheet" href="/assets/vendor/bootstrap/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="/assets/vendor/font-awesome/css/font-awesome.min.css">
    
  <link rel="stylesheet" href="/assets/vendor/bootstrap-sweetalert/lib/sweet-alert.css">
  <link rel="stylesheet" href="/assets/vendor/AdminLTE/plugins/select2/select2.min.css">
  <link rel="stylesheet" href="/assets/vendor/AdminLTE/plugins/datatables/dataTables.bootstrap.css">
  <link rel="stylesheet" href="/assets/vendor/AdminLTE/plugins/datepicker/datepicker3.css">
  
  <link rel="stylesheet" href="/assets/vendor/AdminLTE/dist/css/AdminLTE.min.css">
  <link rel="stylesheet" href="/assets/vendor/AdminLTE/dist/css/skins/skin-blue.min.css">

  <link rel="stylesheet" href="/assets/css/common.css">

    
  <style type="text/css">
    .search-area {
      margin-top: 6px;
      padding-left: 3px;
    }
    .lab-report {
      margin-top: 15px;
    }
    .row > label {
      font-size: 15px;
      padding-top: 5px;
    }
  </style>
  
</head>
<body class="hold-transition skin-blue sidebar-mini fixed ">
  
<div class="wrapper">
  <header class="main-header">
    <a href="/" class="logo">
      <span class="logo-mini">Lab</span>
      <span class="logo-lg">实验室管理系统</span>
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
              <img src="/assets/img/teacher.png" class="user-image" alt="User Image">
              <!-- hidden-xs hides the username on small devices so only the image appears. -->
              <span class="hidden-xs">${requestScope.user.name }</span>
            </a>
            <ul class="dropdown-menu">
              <!-- The user image in the menu -->
              <li class="user-header">
                <img src="/assets/img/teacher.png" class="img-circle" alt="User Image">
                <p>${requestScope.user.name } - 教师<small>登录时间: <%=now %></small></p>
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="/profile" class="btn btn-default btn-flat">个人信息</a>
                </div>
                <div class="pull-right">
                  <a href="/logout" class="btn btn-default btn-flat">退出</a>
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
          <img src="/assets/img/teacher.png" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p><%=username %></p>
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
            <a href="/">
              <i class="fa fa-home"></i><span>主页</span>
            </a>
          </li>
          
          <!-- 教师课程管理模块 -->
          <li class="header">课程管理</li>
          <li class="">
            <a href="/course/schedule">
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
            <a href="/student/students">
              <i class="fa fa-link"></i><span>花名册管理</span>
            </a>
          </li>
          <li class="">
            <a href="/student/results">
              <i class="fa fa-link"></i><span>成绩管理</span>
            </a>
          </li>
          
          
          <!-- 教师实验室管理模块  -->
          <li class="header">实验室</li>
          <li class="">
            <a href="">
              <i class="fa fa-link"></i>
              <span>实验室预约申请</span>
              <i class="fa fa-angle-left pull-right"></i>
            </a>
            <ul class="treeview-menu">
              <li class="">
                <a href="/lab/search">
                  <i class="fa fa-circle-o"></i><span>实验室查询</span>
                </a>
              </li>
              <li class="">
                <a href="/lab/reservation">
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
            <a href="/profile">
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
      <h1>花名册管理 <small>Students Management</small></h1>
      <ol class="breadcrumb">
        <li><a href="/"><i class="fa fa-dashboard"></i>主页</a></li>
        <li class="active">花名册管理</li>
      </ol>
    </section>

  <!-- Main content -->
  <section class="content">
      
  <div class="container-fluid search-area">
    <form action="/student/students" class="row" method="post">
      <label class="col-md-1">授课课程</label>
      <div class="col-md-4">
        <select class="form-control select2" name="course" id="course-option">
          <option></option>
        </select>
      </div>
      <label class="col-md-1">学生班级</label>
      <div class="col-md-4">
        <select class="form-control select2" name="courseClass" id="class-option">
        </select>
      </div>
      <div class="col-md-2">
         <input class="btn btn-primary" type="submit" id="search" value="查看">
      </div>
    </form>
  </div>
  <div class="box box-primary lab-report">
    <div class="box-body">
      <table class="table table-bordered table-striped">
        <thead>
          <tr class="info">
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>学院</th>
            <th>专业</th>
            <th>班级</th>
            <th>电话</th>
            <th>邮箱</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach items="${students }" var="students">
          <tr>
            <td>${students.studentId }</td>
            <td>${students.name }</td>
            <td>${students.gender }</td>
            <td>${students.department }</td>
            <td>${students.major }</td>
            <td>${students._class }</td>
            <td>${students.phone }</td>
            <td>${students.email }</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
    </section>
  </div>

  <!-- Main Footer -->
  <footer class="main-footer">
    <strong>Copyright &copy; 2015 理工四少.</strong> All rights reserved.
  </footer>
</div>

  <script src="/assets/vendor/jquery/dist/jquery.min.js"></script>
  <script src="/assets/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
    
  <script src="/assets/vendor/AdminLTE/plugins/slimScroll/jquery.slimscroll.min.js"></script>
  <script src="/assets/vendor/AdminLTE/plugins/fastclick/fastclick.min.js"></script>
  <script src="/assets/vendor/AdminLTE/dist/js/app.min.js"></script>

  <script src="/assets/vendor/AdminLTE/plugins/select2/select2.full.min.js"></script>
  <script src="/assets/vendor/AdminLTE/plugins/select2/i18n/zh-CN.js"></script>
  <script src="/assets/vendor/AdminLTE/plugins/datepicker/bootstrap-datepicker.js"></script>
  <script src="/assets/vendor/AdminLTE/plugins/datatables/jquery.dataTables.min.js"></script>
  <script src="/assets/vendor/AdminLTE/plugins/datatables/dataTables.bootstrap.min.js"></script>

  <script src="/assets/js/common.js"></script>

  <script>
    $(function () {

      //调用datatable插件
      $(".table").DataTable();

      $.fn.select2.defaults.set("language", "zh-CN");
      //调用select2插件
      $(".select2").select2({
        //placeholder: "请选择班级",
        dropdownAutoWidth: true,
        maximumSelectionLength: 4   //限制最多选择四个选项
      });
      
      var storage = JSON.parse('${json }');
      $("#course-option").empty().append($.map(storage, function(v, k) {
        return '<option value="' + k + '">' + k + '</option>';
      })).select2("val", "");
      
      $("#course-option").on("change", function() {
        var target = $("#class-option");
        //$(this).closest("form").find("select").prop("disabled", true);
        target.empty().append($.map(storage[$(this).val()], function(v, k) {
          return '<option value="' + v + '">' + v + '</option>';
        })).select2("val", ""); 
      });
      
    });
  </script>

  
</body>
</html>

