<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  <link rel="stylesheet" href="/assets/vendor/AdminLTE/dist/css/AdminLTE.min.css">
  <link rel="stylesheet" href="/assets/vendor/AdminLTE/dist/css/skins/skin-blue.min.css">
  <link rel="stylesheet" href="/assets/css/common.css">
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
                <img src="/assets/img/student.png" class="user-image" alt="User Image">
                <!-- hidden-xs hides the username on small devices so only the image appears. -->
                <span class="hidden-xs"><%=username%></span>
              </a>
              <ul class="dropdown-menu">
                <!-- The user image in the menu -->
                <li class="user-header">
                  <img src="/assets/img/student.png" class="img-circle" alt="User Image">
                  <p>
                    <%=username%> - 学生<small>登录时间: <%=now %></small></p>
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
            <img src="/assets/img/student.png" class="img-circle" alt="User Image">
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
            <li>
              <a href="/">
                <i class="fa fa-dashboard"></i>
                <span>主页</span>
              </a>
            </li>
            <li class="active">
              <a href="/student/course/choose">
                <i class="fa fa-graduation-cap"></i>
                <span>选课</span>
              </a>
            </li>
            <li>
              <a href="/student/course">
                <i class="fa fa-calendar-o"></i>
                <span>我的课表</span>
              </a>
            </li>
            <li>
              <a href="/student/scores">
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
        <h1>选课 <small>Course Select</small></h1>

        <ol class="breadcrumb">
          <li><a href="/"><i class="fa fa-dashboard"></i>主页</a></li>
          <li class="active">选课系统</li>
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
                  <th>任课教师</th>
                  <th>上课时间</th>
                  <th>上课地点</th>
                  <th>课程容量</th>
                  <th>当前已选</th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${requestScope.sclist }" var="item">
                  <tr data-id="1" data-lab-room-usage-id="${item.labRoomUsageId }" data-time-from="${item.timeFrom }" data-threhold="0" data-campus="${item.campus }" data-building="${item.building }" data-room-type="" data-lab-room-id="${item.labRoomId }" data-teacher-id="">
                  <td>${item.courseName }</td>
                  <td>${item.teacherName }</td>
                  <td>${item.timeFrom }</td>
                  <td>${item.campus } ${item.building } ${item.roomName }</td>
                  <td>${item.maxNum }</td>
                  <td>${item.nowNum }</td>
                  <td>
                    ${item.roomType }
                  </td>
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
  <script src="/assets/vendor/bootstrap-sweetalert/lib/sweet-alert.min.js"></script>
  <script src="/assets/vendor/AdminLTE/plugins/select2/select2.full.min.js"></script>
  <script src="/assets/vendor/AdminLTE/plugins/datatables/jquery.dataTables.min.js"></script>
  <script src="/assets/vendor/AdminLTE/plugins/datatables/dataTables.bootstrap.min.js"></script>
  <script src="/assets/js/common.js"></script>
  <script type="text/template" id="template-course-select">
    <button data-priority="1" class="btn btn-xs btn-primary"><i class="fa fa-plus"></i> 选课</button>
  </script>

  <script type="text/template" id="template-course-cancle">
    <button data-priority="2" class="btn btn-xs btn-danger"><i class="fa fa-remove"></i> 退选</button>
  </script>

  <script type="text/template" id="template-course-selected">
    <span data-priority="3" class="label label-info">已选</span>
  </script>

  <script>
    $(document).ready(function() {
      $.extend($.fn.dataTableExt.oSort, {
        "status-pre": function(element) {
          return $(element).data('priority') | 0;
        },
        "status-asc": function(a, b) {
          return ((a < b) ? -1 : ((a > b) ? 1 : 0));
        },
        "status-desc": function(a, b) {
          return ((a < b) ? 1 : ((a > b) ? -1 : 0));
        }
      });
      var timestamp = ((new Date()).getTime() / 1000) | 0;
      $('.table tbody>tr').each(function() {
        var row = $(this);
        var threhold = row.data('threhold') | 0;
        var time = ((new Date(row.data('time-from'))).getTime() / 1000) | 0;
        var capacity = row.find('td:nth-child(5)').text() | 0;
        var count = row.find('td:nth-child(6)').text() | 0;
        if (timestamp + threhold >= time || row.find('td:last > button').hasClass('btn-primary') && count >= capacity) {
          row.find('td:last > button').prop('disabled', true);
        }
      });
      var table = $('.table').DataTable({
        order: [
          [6, 'desc'],
          [0, 'asc']
        ],
        columnDefs: [{
          type: 'status',
          targets: 6
        }]
      });
      $('.select2').select2();
      $('.box-body .table').on('click', 'button', function() {
        if ($(this).prop('disabled')) return false;
        var action = $(this).hasClass('btn-danger') ? 'drop' : 'choose';
        var $tr = $(this).closest('tr');
        var threhold = $tr.data('threhold') | 0;
        var time = ((new Date($tr.data('time-from'))).getTime() / 1000) | 0;
        var now = ((new Date()).getTime() / 1000) | 0;
        if (now + threhold >= time) {
          return sweetAlert('系统提示', '上课前 ' + threhold + ' 秒内不允许选课或退选', 'error');
        }
        $.ajax({
          url: '/student/course/choose',
          type: 'POST',
          contentType: 'application/json',
          dataType: 'json',
          data: JSON.stringify($.extend({}, $tr.data(), {
            action: action
          }))
        }).done(function(data) {
          if (data.success == 'true') {
            if (action == 'choose') {
              $tr.find('>td:last').html($('#template-course-cancle').html().trim());
            } else if (action == 'drop') {
              $tr.find('>td:last').html($('#template-course-select').html().trim());
            }
            table.row($tr).invalidate().draw();
            sweetAlert('系统提示', data.message || '操作成功！', 'success');
          } else {
            sweetAlert('系统提示', data.message || '操作失败！', 'error');
          }
        }).fail(function() {
          sweetAlert('系统提示', '操作失败！网络错误', 'error');
        });
      });
    });

  </script>

</body>

</html>
