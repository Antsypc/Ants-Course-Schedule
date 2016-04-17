<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.Date"%>
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
  <link rel="stylesheet" href="/assets/vendor/AdminLTE/plugins/select2/select2.min.css">
  <link rel="stylesheet" href="/assets/vendor/AdminLTE/plugins/datepicker/datepicker3.css">
  <link rel="stylesheet" href="/assets/vendor/AdminLTE/dist/css/AdminLTE.min.css">
  <link rel="stylesheet" href="/assets/vendor/AdminLTE/dist/css/skins/skin-blue.min.css">
  <link rel="stylesheet" href="/assets/css/common.css">
  <style type="text/css">
    .search-area {
      margin-top: 6px;
    }
    
    .lab-report {
      margin-top: 15px;
    }

  </style>

  <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

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
                <img src="/assets/img/manager.png"" class="user-image" alt="User Image">
                <!-- hidden-xs hides the username on small devices so only the image appears. -->
                <span class="hidden-xs"><%=username%></span>
              </a>
              <ul class="dropdown-menu">
                <!-- The user image in the menu -->
                <li class="user-header">
                  <img src="/assets/img/manager.png"" class="img-circle" alt="User Image">
                  <p>
                    <%=username%> - 实验室管理员<small>登录时间: <%=now %></small></p>
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
            <img src="/assets/img/manager.png"" class="img-circle" alt="User Image">
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
              <a href="">
                <i class="fa fa-flask"></i>
                <span>实验室管理</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li class="active">
                  <a href="/lab/manage/search">
                    <i class="fa fa-circle-o"></i>
                    <span>实验室查询</span>
                  </a>
                </li>
                <li>
                  <a href="/lab/review">
                    <i class="fa fa-circle-o"></i>
                    <span>实验室预约申请审核</span>
                  </a>
                </li>
              </ul>
            </li>
            <li>
              <a href="">
                <i class="fa fa-gears"></i>
                <span>仪器设备及耗材管理</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li>
                  <a href="/equipment/equipment">
                    <i class="fa fa-circle-o"></i>
                    <span>设备管理</span>
                  </a>
                </li>
                <li>
                  <a href="/equipment/repair">
                    <i class="fa fa-circle-o"></i>
                    <span>设备维修管理</span>
                  </a>
                </li>
                <li>
                  <a href="/equipment/consumables">
                    <i class="fa fa-circle-o"></i>
                    <span>耗材管理</span>
                  </a>
                </li>
              </ul>
            </li>
            <li>
              <a href="#">
                <i class="fa fa-users"></i>
                <span>用户管理</span>
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
      <h1>实验室查询 <small>Manage Laboratory</small></h1>
      
  <ol class="breadcrumb">
    <li><a href="/"><i class="fa fa-dashboard"></i>主页</a></li>
    <li class="active">实验室管理</li>
  </ol>

    </section>

    <!-- Main content -->
    <section class="content">
      
  <div class="container-fluid search-area">
    <form action="#" class="row">
      <div class="col-md-3">
        <label>校区</label>
        <select name="campus" class="form-control select2" data-placeholder="请选择校区">
          <option value="all">全部</option>
          <option value="dongyuan">东院</option>
          <option value="xiyuan">西院</option>
          <option value="jianhu">鉴湖</option>
          <option value="nanhu">南湖</option>
          <option value="yuqu">余家头</option>
        </select>
      </div>
      <div class="col-md-3">
        <label>日期</label>
        <input class="form-control datepicker" type="text" name="date" value="${requestScope.date }">
      </div>
      <div class="col-md-3">
        <label>条件</label>
        <select tabindex="-1" class="form-control select2" name="status">
          <option value="all">全部</option>
          <!-- <option value="reserved">占用</option> -->
          <option value="ready">空闲</option>
        </select>
      </div>
      <label>&nbsp;</label>
      <div class="col-md-3">
        <button type="submit" class="btn btn-primary">查询</button>
      </div>
    </form>
  </div>
  <div class="box box-primary lab-report">
    <div class="box-body table-responsive">
      <table class="table table-bordered table-striped">
        <thead>
          <tr>
            <th>ID</th>
            <th>校区</th>
            <th>楼栋</th>
            <th>实验室</th>
            <th>实验室类型</th>
            <th>容量/人</th>
            <th>可用时段</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach items="${room }" var="room">
          <tr>
            <td>${room.value.labRoomId }</td>
            <td>${room.value.campus }</td>
            <td>${room.value.building }</td>
            <td>${room.value.roomName }</td>
            <td>${room.value.roomType }</td>
            <td>${room.value.capacity }</td>
            <td>${room.value.freePeriod }</td>
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
  <script src="/assets/vendor/AdminLTE/plugins/datepicker/bootstrap-datepicker.js"></script>
  <script src="/assets/vendor/AdminLTE/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>


    <script src="/assets/js/common.js"></script>

    
  <script>
    $(document).ready(function() {
      $('.select2').select2();
      $('.select2[name=campus]').select2('val', '${requestScope.campus}');
      $('.select2[name=status]').select2('val', '${requestScope.status}');
      $('.datepicker').datepicker({
        format: 'yyyy-mm-dd',
        language: 'zh-CN',
        autoclose: true,
        todayHighlight: true
      });

      $('search-area > form').on('submit', function(e) {
        e.preventDefault();
        var $this = $(this);
        var campas = $this.find('[name=campus]').val();
        var date = $this.find('[name=date]').val();
        var status = $this.find('[name=status]').val();
        window.location.assign('/lab/manage/search?campus=' + campas + '&date=' + date + '&status=' + status);
        return false;
      });
    });
  </script>

  
</body>
</html>

