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
  <link rel="stylesheet" href="/assets/vendor/bootstrap-sweetalert/lib/sweet-alert.css">
  <link rel="stylesheet" href="/assets/vendor/AdminLTE/plugins/select2/select2.min.css">
  <link rel="stylesheet" href="/assets/vendor/AdminLTE/plugins/datepicker/datepicker3.css">
  <link rel="stylesheet" href="/assets/vendor/AdminLTE/plugins/datatables/dataTables.bootstrap.css">
  <link rel="stylesheet" href="/assets/vendor/AdminLTE/dist/css/AdminLTE.min.css">
  <link rel="stylesheet" href="/assets/vendor/AdminLTE/dist/css/skins/skin-blue.min.css">
  <link rel="stylesheet" href="/assets/css/common.css">
  <style type="text/css">
    .schedule-header {
      height: 100px;
      background: #00a7d0 !important;
    }
    
    .schedule-header.cardimg {
      position: absolute;
      margin-left: -18px;
      width: 100%;
    }
    
    .schedule-img {
      margin-top: -50px;
    }
    
    .modal-header {
      height: 90px;
      position: relative;
    }
    
    .modal-header .cardimg {
      position: absolute;
      margin-left: -15px;
      bottom: -50px;
      width: 100%;
    }
    
    .row {
      margin-top: 10px;
    }
    
    .schedule-label {
      font-family: "Segoe UI", "Open Sans", "Lucida Grande", FreeSans, Arimo, "Source Sans Pro", "Droid Sans", "Helvetica Neue", Helvetica, "Microsoft YaHei UI", "Microsoft YaHei", "Hiragino Sans GB", "Hiragino Sans GB W3", Arial, sans-serif;
      font-size: 15px;
      padding-top: 5px;
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
              <img src="/assets/img/teacher.png" class="user-image" alt="User Image">
              <!-- hidden-xs hides the username on small devices so only the image appears. -->
              <span class="hidden-xs"><%=username %></span>
            </a>
            <ul class="dropdown-menu">
              <!-- The user image in the menu -->
              <li class="user-header">
                <img src="/assets/img/teacher.png" class="img-circle" alt="User Image">
                <p><%=username %>- 教师<small>登录时间: <%=now %></small></p>
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
            <li class="header">课程管理</li>
            <li class="active">
              <a href="/course/schedule">
                <i class="fa fa-calendar-o"></i>
                <span>课程教学计划</span>
              </a>
            </li>
            <li>
              <a href="#">
                <i class="fa fa-link"></i>
                <span>课程资料</span>
              </a>
            </li>
            <li class="header">学生管理</li>
            <li>
              <a href="/student/students">
                <i class="fa fa-users"></i>
                <span>花名册管理</span>
              </a>
            </li>
            <li>
              <a href="/student/results">
                <i class="fa fa-link"></i>
                <span>成绩管理</span>
              </a>
            </li>
            <li class="header">实验室</li>
            <li>
              <a href="">
                <i class="fa fa-flask"></i>
                <span>实验室预约申请</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li>
                  <a href="/lab/search">
                    <i class="fa fa-circle-o"></i>
                    <span>实验室查询</span>
                  </a>
                </li>
                <li>
                  <a href="/lab/reservation">
                    <i class="fa fa-circle-o"></i>
                    <span>我的预约</span>
                  </a>
                </li>
              </ul>
            </li>
            <li>
              <a href="">
                <i class="fa fa-gears"></i>
                <span>实验器材</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li>
                  <a href="#">
                    <i class="fa fa-circle-o"></i>
                    <span>实验器材申请</span>
                  </a>
                </li>
                <li>
                  <a href="#">
                    <i class="fa fa-circle-o"></i>
                    <span>使用情况登记</span>
                  </a>
                </li>
              </ul>
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
        <h1>课程教学计划 <small>Teaching Schedule</small></h1>

        <ol class="breadcrumb">
          <li><a href="/"><i class="fa fa-dashboard"></i>主页</a></li>
          <li class="active">课程教学计划</li>
        </ol>

      </section>

      <!-- Main content -->
      <section class="content">
        <div class="row">
          <div class="col-md-9">
            <div class="nav-tabs-custom">
              <ul class="nav nav-tabs">
                <li class="active"><a href="#addSchedule" data-toggle="tab">添加教学计划</a></li>
                <li><a href="#mySchedule" data-toggle="tab">我的教学计划</a></li>
              </ul>
              <div class="tab-content">
                <div class="active tab-pane" id="addSchedule">
                  <div class="schedule-content">
                    <div class="schedule-header"></div>
                    <div class="cardimg">
                      <img class="schedule-img profile-user-img img-responsive img-circle" src="/assets/vendor/AdminLTE/dist/img/avatar.png">
                    </div>
                    <div class="schedule-body">
                      <h3 class="profile-username text-center" style="margin-top:6px;"><%=username %></h3>
                      <div class="row">
                        <label class="col-md-2 schedule-label" for="inputEmail">课程名称</label>
                        <div class="col-md-6">
                          <input class="form-control" type="text" id="inputCourseName" placeholder="课程名称">
                        </div>
                        <span class="col-md-4 schedule-label" id="nameError"></span>
                      </div>
                      <div class="row">
                        <label class="col-md-2 schedule-label">授课班级</label>
                        <div class="col-md-6">
                          <input class="form-control" type="text" id="inputClass" placeholder="多个班级之间以分号隔开">
                        </div>
                        <span class="col-md-4 schedule-label" id="classError"></span>
                      </div>
                      <div class="row">
                        <label class="col-md-2 schedule-label">开课时间</label>
                        <div class="col-md-6">
                          <input class="form-control datepicker" type="text" id="inputFromTime" placeholder="  开课时间">
                        </div>
                        <span class="col-md-4 schedule-label" id="fromTimeError"></span>
                      </div>
                      <div class="row">
                        <label class="col-md-2 schedule-label">结课时间</label>
                        <div class="col-md-6">
                          <input class="form-control datepicker" type="text" id="inputToTime" placeholder="  结课时间">
                        </div>
                        <span class="col-md-4 schedule-label" id="toTimeError"></span>
                      </div>
                      <div class="row">
                        <label class="col-md-2 schedule-label">课程描述</label>
                        <div class="col-md-6">
                          <textarea rows="3" class="form-control" id="inputDescription"></textarea>
                        </div>
                        <span class="col-md-4 schedule-label" id="descriptionError"></span>
                      </div>
                      <div class="row">
                        <div class="col-md-2"></div>
                        <div class="col-md-10">
                          <button class="btn btn-danger" id="submitSchedule">提交</button>
                          <button class="btn btn-default" id="cancelSchedule">取消</button>
                        </div>
                      </div>
                    </div>
                  </div>
                  <!-- /.schedule-content 结束 -->
                </div>
                <!-- /.tab-pane结束-->
                <div class="tab-pane" id="mySchedule">
                  <div class="box box-primary schedule-report">
                    <div class="box-body table-responsive">
                      <table class="table table-bordered table-striped">
                        <thead>
                          <tr class="info">
                            <th>课程ID</th>
                            <th>课程名称</th>
                            <th>授课班级</th>
                            <th>开课时间</th>
                            <th>结课时间</th>
                            <th>操作</th>
                          </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${schedules }" var="schedules">
                          <tr data-text="${schedules.description }">
                            <td>${schedules.courseId }</td>
                            <td>${schedules.courseName }</td>
                            <td>${schedules.courseClass }</td>
                            <td>${schedules.timeFrom }</td>
                            <td>${schedules.timeTo }</td>
                            <td>
                              <button class="btn btn-xs btn-success" data-toggle="modal" data-target="#detailInfoModal">查看详情
                              </button>
                            </td>
                          </tr>
                          </c:forEach>
                        </tbody>
                      </table>
                    </div>
                  </div>
                  <!-- 查看教学计划详情模态框 -->
                  <div class="modal fade" id="detailInfoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                      <div class="modal-content">
                        <div class="modal-header bg-aqua-active">
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
                          <h4 class="modal-title" id="myModalLabel"></h4>
                          <div class="modalCardimg">
                            <img class="profile-user-img img-responsive img-circle" src="/assets/vendor/AdminLTE/dist/img/avatar.png">
                          </div>
                        </div>
                        <div class="modal-body">
                          <h3 class="profile-username text-center" style="margin-top:36px;"><%=username %></h3>
                          <ul class="list-group list-group-unbordered">
                            <li class="list-group-item">
                              <b>课程ID</b>
                              <a class="pull-right" id="courseId"></a>
                            </li>
                            <li class="list-group-item">
                              <b>课程名称</b>
                              <a class="pull-right" id="courseName"></a>
                            </li>
                            <li class="list-group-item">
                              <b>授课班级</b>
                              <a class="pull-right" id="courseClass"></a>
                            </li>
                            <li class="list-group-item">
                              <b>开课时间</b>
                              <a class="pull-right" id="fromTime"></a>
                            </li>
                            <li class="list-group-item">
                              <b>结课时间</b>
                              <a class="pull-right" id="toTime"></a>
                            </li>
                            <div style="padding-top:10px;">
                              <b>课程描述</b>
                              <textarea rows="3" class="form-control" readonly="true" id="description"></textarea>
                            </div>
                          </ul>
                        </div>
                        <div class="modal-footer">
                          <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        </div>
                      </div>
                    </div>
                    <!-- /查看教学计划详情 -->
                  </div>
                </div>
              </div>
              <!-- /.tab-content 结束-->
            </div>
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
  <script src="/assets/vendor/AdminLTE/plugins/datepicker/bootstrap-datepicker.js"></script>
  <script src="/assets/vendor/AdminLTE/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
  <script src="/assets/vendor/AdminLTE/plugins/datatables/jquery.dataTables.min.js"></script>
  <script src="/assets/vendor/AdminLTE/plugins/datatables/dataTables.bootstrap.min.js"></script>
  <script src="/assets/js/common.js"></script>
  <script>
    $(function() {
      var now = new Date();
      /**	//调用datatable插件
      	$(".table").DataTable({
      		"aoColumnDefs": [ { "bSortable": false, "aTargets": [ 0,1,2,5] }]  
      	});*/
      //调用datepicker插件
      $('.datepicker').datepicker({
        format: "yyyy-mm-dd",
        startDate: now.getFullYear() + "-" + (now.getMonth() + 1) + "-" + now.getDate(),
        language: "zh-CN",
        autoclose: true,
        todayHighlight: true
      });
      //表单验证
      $("#inputCourseName").bind("blur", function() {
        if ($(this).val().trim() == '') {
          $("#nameError").html("课程名称不能为空！").css('color', '#ff0000');
        } else {
          $("#nameError").html("");
        };
      });
      $("#inputClass").bind("blur", function() {
        if ($(this).val().trim() == '') {
          $("#classError").html("授课班级不能为空！").css('color', '#ff0000');
        } else {
          $("#classError").html("");
        };
      });
      $("#inputFromTime").bind("blur change", function() {
        if ($(this).val().trim() == '') {
          $("#fromTimeError").html("开课时间不能为空！").css('color', '#ff0000');
        } else {
          $("#fromTimeError").html("");
        };
      });
      $("#inputToTime").bind("blur change", function() {
        if ($(this).val().trim() == '') {
          $("#toTimeError").html("开课时间不能为空！").css('color', '#ff0000');
        } else {
          $("#toTimeError").html("");
        };
      });
      $("#inputDescription").bind("blur", function() {
        if ($(this).val().trim() == '') {
          $("#descriptionError").html("描述不能为空！").css('color', '#ff0000');
        } else {
          $("#descriptionError").html("");
        };
      });
      //提交数据
      $("#submitSchedule").on("click", function() {
        var courseName = $("#inputCourseName").val();
        var courseClass = $("#inputClass").val();
        var fromTime = $("#inputFromTime").val()
        var toTime = $("#inputToTime").val();
        var description = $("#inputDescription").val();
        if (courseName != "" && courseClass != "" && fromTime != "" && toTime != "") {
          //创建一个json数组用来存储课程名称、授课班级、开课时间、结课时间
          var data = {
            courseName: courseName,
            courseClass: courseClass,
            fromTime: fromTime,
            toTime: toTime,
            description: description
          };
          data = JSON.stringify(data);
          $.ajax({
            type: "POST",
            contentType: "application/json",
            dataType: "json",
            url: "/course/schedule",
            data: data,
            success : function(data) {
            	sweetAlert({
            		title: '系统提示',
            		text: '课程计划提交成功！',
            		type: 'success'
            	}, function() {
            		window.location.reload();
            	});
            },
            error: function(data) {
            	console.log(data);
            	sweetAlert('系统提示', '课程计划提交失败，请重新操作！', 'error');
            }
          });
        } else {
          return false;
        };
      });
      $("#cancelSchedule").on("click", function() {
        $("#inputCourseName").val("");
        $("#inputClass").val("");
        $("#inputFromTime").val("");
        $("#inputToTime").val("");
        $("#inputDescription").text("");
      });
      //将要详细的教学计划显示在详情单上
      $(".schedule-report td > button").on("click", function() {
        var courseId = $(this).closest("tr").find("td:eq(0)").text();
        var couseNameInfo = $(this).closest("tr").find("td:eq(1)").text();
        var courseClassInfo = $(this).closest("tr").find("td:eq(2)").text();
        var fromTimeInfo = $(this).closest("tr").find("td:eq(3)").text();
        var toTimeInfo = $(this).closest("tr").find("td:eq(4)").text();
        var description = $(this).closest("tr").data('text');
        $("#myModalLabel").text(couseNameInfo + "课程教学计划");
        $("#courseId").text(courseId);
        $("#courseName").text(couseNameInfo);
        $("#courseClass").text(courseClassInfo);
        $("#fromTime").text(fromTimeInfo);
        $("#toTime").text(toTimeInfo);
        $("#description").text(description);
      });
    });

  </script>

</body>

</html>
