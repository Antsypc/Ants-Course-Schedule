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
    .box {
      margin-top: 12px;
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
                <p><%=username %> - 教师<small>登录时间: <%=now %></small></p>
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
          <p><%=username%></p>
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
            <li>
              <a href="/course/schedule">
                <i class="fa fa-calendar-o"></i>
                <span>课程教学计划</span>
              </a>
            </li>
            <li>
              <a href="/course/material">
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
        <h1>成绩管理 <small>Performance management </small></h1>

        <ol class="breadcrumb">
          <li><a href="/"><i class="fa fa-dashboard"></i>主页</a></li>
          <li class="active">成绩管理</li>
        </ol>

      </section>

      <!-- Main content -->
      <section class="content">
        <div class="row">
          <div class="col-md-11">
            <div class="nav-tabs-custom">
              <ul class="nav nav-tabs">
                <li class="active"><a href="#markingPoints" data-toggle="tab">实验评分</a></li>
                <li><a href="#searchResults" data-toggle="tab">查看实验成绩</a></li>
              </ul>
              <div class="tab-content">
                <div class="active tab-pane" id="markingPoints">
                  <div class="container-fluid search-area">
                    <form action="/student/results" method="post" class="row">
                      <label class="col-md-2">课程名称</label>
                      <div class="col-md-3">
                        <select class="form-control select2 course-option" name="marking-course">
                          <option></option>
                        </select>
                      </div>
                      <label class="col-md-2">学生班级</label>
                      <div class="col-md-3">
                        <select class="form-control select2 class-option" name="marking-class">
                        </select>
                      </div>
                      <div class="col-md-2">
                        <input class="btn btn-primary" type="submit" value="查看">
                      </div>
                    </form>
                  </div>
                  <div class="box box-primary reports">
                    <div class="box-header with-border">
                      <h3 class="box-title"></h3>
                      <div class="box-tools pull-right">
                        <button class="btn btn-sm btn-success" id="btn-marking">
                          <i class="fa fa-sign-in"></i> 一键评分
                        </button>
                      </div>
                    </div>
                    <div class="box-body">
                      <table class="table table-bordered table-striped marking-table">
                        <thead>
                          <tr class="info">
                            <th>
                              <input type="checkbox" id="selectAll">
                            </th>
                            <th>学号</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>学院</th>
                            <th>专业</th>
                            <th>班级</th>
                            <th>课程名称</th>
                            <th class="col-xs-1">评分</th>
                          </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${studentReport }" var="sr">
                          <tr data-text="${sr.courseId }">
                            <td>
                              <input type="checkbox" class="checkItem">
                            </td>
                            <td>${sr.studentId }</td>
                            <td>${sr.name }</td>
                            <td>${sr.gender }</td>
                            <td>${sr.department }</td>
                            <td>${sr.major }</td>
                            <td>${sr.stuClass }</td>
                            <td>${sr.courseName }</td>
                            <td class="form-group">
                              <input class="form-control input-sm" type="number" min="0" max="100">
                            </td>
                          </tr>
                         </c:forEach>
                        </tbody>
                      </table>
                    </div>
                  </div>
                </div>
                <!-- /.tab-pane结束-->

                <div class="tab-pane" id="searchResults">
                  <div class="container-fluid search-area">
                    <form action="/student/mark/search" method="post" class="row" >
                      <label class="col-md-2">课程名称</label>
                      <div class="col-md-3">
                        <select class="form-control select2 course-option2" style="width:100%" name="course">
                        </select>
                      </div>
                      <label class="col-md-2">学生班级</label>
                      <div class="col-md-3">
                        <select class="form-control select2 class-option2" style="width:100%" name="class">
                        </select>
                      </div>
                      <div class="col-md-2">
                        <input class="btn btn-primary" type="submit" value="查看">
                      </div>
                    </form>
                  </div>
                  <div class="box box-primary score-reports">
                    <div class="box-body">
                      <table class="table table-bordered table-striped results-table score-table">
                        <thead>
                          <tr class="info">
                            <th>学号</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>学院</th>
                            <th>专业</th>
                            <th>班级</th>
                            <th>课程名称</th>
                            <th>评分</th>
                            <th>操作</th>
                          </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${stuScoreReport }" var="ssr">
                          <tr data-text="${ssr.courseId }">
                            <td>${ssr.studentId }</td>
                            <td>${ssr.name }</td>
                            <td>${ssr.gender }</td>
                            <td>${ssr.department }</td>
                            <td>${ssr.major }</td>
                            <td>${ssr.stuClass }</td>
                            <td>${ssr.courseName }</td>
                            <td>${ssr.score }</td>
                            <td>
                              <button class="btn btn-xs btn-primary" data-toggle="modal" data-target="#resetMarkModal">
                                <i class="fa fa-edit"></i> 更改
                              </button>
                            </td>
                          </tr>
                        </c:forEach>
                        </tbody>
                      </table>
                    </div>
                  </div>
                </div>
                <!-- /.tab-pane结束-->
              </div>
              <!-- /.tab-content 结束-->
            </div>
          </div>
        </div>

        <div class="modal fade" id="resetMarkModal">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="关闭">
                  <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">更改成绩</h4>
              </div>
              <form class="form-horizontal" accept-charset="utf8">
                <input type="hidden" id="courseId">
                <div class="modal-body">
                  <div class="form-group">
                    <label class="col-sm-2 control-label">
                      	学生姓名
                    </label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="studentName" readonly="true">
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">
                     	 学生学号
                    </label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="studentNumber" readonly="true">
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">所在学院
                    </label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="studentDepartment" readonly="true">
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">专业名称</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="studentMajor" readonly="true">
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">所在班级</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="studentClass" readonly="true">
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">课程名称</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="studentCourse" readonly="true">
                    </div>
                  </div>
                  <div class="form-group repair scrap">
                    <label class="col-sm-2 control-label required">实验成绩</label>
                    <div class="col-sm-10">
                      <input type="number" class="form-control" id="studentScore" required>
                    </div>
                  </div>
                </div>
                </form>
                <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                  <button type="button" class="btn btn-primary" id="btnResetMark">保存</button>
                </div>
            </div>
            <!-- /.modal-content -->
          </div>
          <!-- /.modal-dialog -->
        </div>
        <!-- /.modal -->

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
  <script src="/assets/vendor/AdminLTE/plugins/select2/i18n/zh-CN.js"></script>
  <script src="/assets/vendor/AdminLTE/plugins/datepicker/bootstrap-datepicker.js"></script>
  <script src="/assets/vendor/AdminLTE/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
  <script src="/assets/vendor/AdminLTE/plugins/datatables/jquery.dataTables.min.js"></script>
  <script src="/assets/vendor/AdminLTE/plugins/datatables/dataTables.bootstrap.min.js"></script>
  <script src="/assets/js/common.js"></script>
  <script>
    $(function() {
      var now = new Date();
      //调用datatable插件
      $(".marking-table").DataTable({
        "order": [
          [1, 'asc']
        ],
        //设置以下列不使用排序
        "aoColumnDefs": [{
          "bSortable": false,
          "aTargets": [0, 2, 3, 4, 5, 6, 7, 8]
        }]
      });
      //调用datatable插件
      $(".score-table").DataTable({
        //设置以下列不使用排序
        "aoColumnDefs": [{
          "bSortable": false,
          "aTargets": [1, 2, 3, 4, 5, 6, 8]
        }]
      });
      //调用select2插件
      $(".select2").select2({
        dropdownAutoWidth: true
      });
      //调用datepicker插件
      $('.datepicker').datepicker({
        format: "yyyy-mm-dd",
        startDate: now.getFullYear() + "-" + (now.getMonth() + 1) + "-" + now.getDate(),
        language: "zh-CN",
        autoclose: true,
        todayHighlight: true
      });
      
      //动态扩充评分tab处菜单项
      var storage = JSON.parse('${json }');
      $(".course-option").empty().append($.map(storage, function(v, k) {
        return '<option value="' + k + '">' + k + '</option>';
      })).select2("val", "");
      $(".course-option").on("change", function() {
        var target = $(".class-option");
        //$(this).closest("form").find("select").prop("disabled", true);
        target.empty().append($.map(storage[$(this).val()], function(v, k) {
          return '<option value="' + v + '">' + v + '</option>';
        })).select2("val", "");
      });
      
      //动态扩充查询成绩处菜单项
      var content = JSON.parse('${json }');
      $(".course-option2").empty().append($.map(content, function(v, k) {
        return '<option value="' + k + '">' + k + '</option>';
      })).select2("val", "");
      $(".course-option2").on("change", function() {
        var target = $(".class-option2");
        //$(this).closest("form").find("select").prop("disabled", true);
        target.empty().append($.map(content[$(this).val()], function(v, k) {
          return '<option value="' + v + '">' + v + '</option>';
        })).select2("val", "");
      });
      
      $("#selectAll").on("change", function() {
        var flag = $(this).prop("checked");
        $(".checkItem").prop("checked", flag); //选中或者取消选中 
      });
      $('.checkItem').on('change', function() {
        var checked = $('.checkItem:checked').length;
        if (checked == 0) {
          $('#selectAll').prop('indeterminate', false);
          $('#selectAll').prop('checked', false);
        } else if (checked < $('.checkItem').length) {
          $('#selectAll').prop('indeterminate', true);
        } else {
          $('#selectAll').prop('indeterminate', false);
          $('#selectAll').prop('checked', true);
        }
      });
      
      
      $("#btn-marking").on("click", function() {
        var data = [];
        var flag = true;
        //获取选中行的数据
        $('.checkItem:checked').closest('tr').each(function() {
          var row = $(this);
          var studentId = row.find("td:eq(1)").text();
          var score = row.find("td:eq(8)").find('input').val();
          var courseId = row.data("text");
          if (score == '') {
            row.find("td:eq(8)").addClass("has-error");
            flag = false;
          } else {
            row.find("td:eq(8)").removeClass("has-error");
          };
          
          data.push({
            courseId: courseId,
            studentId: studentId,
            score: score
          });
        });
        if (flag) {
          data = JSON.stringify(data);
          $.ajax({
            type: "POST",
            contentType: "application/json",
            dataType: "json",
            url: "/student/mark",
            data: data,
            success : function(data) {
          	  sweetAlert('系统提示', '评分成功！', 'success');
            },
            error: function(data) {
            	console.log(data);
            	sweetAlert('系统提示', '评分失败 ，请重新操作！', 'error');
            }
          });
        } else {
          alert("提交成绩不能为空");
        }
      });
      
      var thisTd;
      //将学生的基本信息显示在resetMarkModal上
      $(".score-reports td > button").on("click", function() {
    	thisTd = $(this).closest("tr").find("td:eq(7)");
        var courseId = $(this).closest("tr").data("text");
        var studentNumber = $(this).closest("tr").find("td:eq(0)").text();
        var studentName = $(this).closest("tr").find("td:eq(1)").text();
        var studentDepartment = $(this).closest("tr").find("td:eq(3)").text();
        var studentMajor = $(this).closest("tr").find("td:eq(4)").text();
        var studentClass = $(this).closest("tr").find("td:eq(5)").text();
        var studentCourse = $(this).closest("tr").find("td:eq(6)").text();
        var studentScore = $(this).closest("tr").find("td:eq(7)").text();
        $("#studentName").val(studentName);
        $("#studentNumber").val(studentNumber);
        $("#studentDepartment").val(studentDepartment);
        $("#studentMajor").val(studentMajor);
        $("#studentClass").val(studentClass);
        $("#studentCourse").val(studentCourse);
        $("#courseId").val(courseId);
        $("#studentScore").val(studentScore);
      });
      
      //更改学生成绩
      $("#btnResetMark").on("click", function() {
        var courseId = $("#courseId").val();
        var studentId = $("#studentNumber").val();
        var studentScore = $("#studentScore").val();
        var data = {
          courseId: courseId,
          studentId: studentId,
          studentScore: studentScore
        };
        data = JSON.stringify(data);
        $.ajax({
          type: "POST",
          contentType: "application/json",
          dataType: "json",
          url: "/student/mark/search",
          data: data,
          success : function(data) {
        	 sweetAlert({
          		title: '系统提示',
          		text: '成绩更改成功！',
          		type: 'success'
          	}, function() {
          		thisTd.text(studentScore);
          		$('#resetMarkModal').modal('hide');
          	});
          },
          error: function(data) {
          	console.log(data);
          	sweetAlert('系统提示', '成绩修改失败，请重新操作！', 'error');
          }
        });
      });
    });
  </script>

</body>

</html>
