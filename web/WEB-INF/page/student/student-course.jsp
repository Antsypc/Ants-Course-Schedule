<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
    <title>Ants 选课系统</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/vendor/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/vendor/AdminLTE/plugins/select2/select2.min.css">
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/assets/vendor/AdminLTE/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/vendor/AdminLTE/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/vendor/AdminLTE/dist/css/skins/skin-blue.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/common.css">
    <style type="text/css">
        .box-body .table td {
            vertical-align: middle;
        }

    </style>

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
            <h1>我的课表
                <small>My Courses</small>
            </h1>

            <ol class="breadcrumb">
                <li><a href="<%=request.getContextPath()%>"><i class="fa fa-dashboard"></i>主页</a></li>
                <li class="active">我的课表</li>
            </ol>

        </section>

        <!-- Main content -->
        <section class="content">

            <div class="box box-primary">
                <div class="box-body">
                    <table class="table table-bordered table-striped table-hover">
                        <thead>
                        <tr>
                            <th>课程名称</th>
                            <th>授课班级</th>
                            <th>上课时间</th>
                            <th>上课地点</th>
                            <th>任课教师</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${requestScope.courseList }" var="item">
                            <tr>
                                <td>${item.name }</td>
                                <td>${item.classes }</td>
                                <td>
                                    第${courses.weekFrom }-${item.weekTo}周,星期${item.weekday },${item.timeFrom }-${item.timeTo }</td>
                                <td>${item.classroomId}</td>
                                <td>${item.teacherName}</td>
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
        <strong>Copyright &copy; 2016 Ants Young.</strong> All rights reserved.
    </footer>
</div>

<script src="<%=request.getContextPath()%>/assets/vendor/jquery/dist/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/vendor/AdminLTE/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/vendor/AdminLTE/plugins/fastclick/fastclick.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/vendor/AdminLTE/dist/js/app.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/vendor/AdminLTE/plugins/select2/select2.full.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/vendor/AdminLTE/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/vendor/AdminLTE/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/common.js"></script>
<script>
    $(document).ready(function () {
        var table = $('.table').DataTable({
            order: [
                [2, 'desc'],
                [0, 'asc']
            ]
        });
        $('.select2').select2();
    });

</script>

</body>

</html>
