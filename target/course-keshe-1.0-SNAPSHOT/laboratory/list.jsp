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

  <link rel="stylesheet" href="/assets/vendor/AdminLTE/plugins/datatables/dataTables.bootstrap.css">
  <link rel="stylesheet" href="/assets/vendor/bootstrap/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="/assets/vendor/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="/assets/vendor/bootstrap-sweetalert/lib/sweet-alert.css">  
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
    .modal-header {
      height: 90px;
    }
    .modal-header {
      position: relative;
    }
    .modal-header .cardimg {
      position: absolute;
      margin-left: -15px;
      bottom: -50px;
      width: 100%;
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
      <h1>实验室查询 <small>Search laboratory</small></h1>
      <ol class="breadcrumb">
        <li><a href="/"><i class="fa fa-dashboard"></i>主页</a></li>
        <li class="active">实验室查询</li>
      </ol>
    </section>

  <!-- Main content -->
  <section class="content">
      
  <div class="container-fluid search-area">
    <form action="/lab/search" class="row" method="post">
      <div class="col-md-3">
        <label>校区</label>
        <select name="campus" class="form-control select2" data-placeholder="请选择校区">
          <option value="所有">所有</option>
          <option value="东院">东院</option>
          <option value="西院">西院</option>
          <option value="鉴湖">鉴湖</option>
          <option value="南湖">南湖</option>
          <option value="余家头">余家头</option>
        </select>
      </div>
      <div class="col-md-3">
        <label>时间</label>
        <input class="form-control datepicker" type="text" name="datetime">
      </div>
      <div class="col-md-3">
        <label>条件</label>
        <select tabindex="-1" class="form-control select2">
          <option value="全部">全部</option>
          <option value="空闲">空闲</option>
        </select>
      </div>
      <label>&nbsp;</label>
      <div class="col-md-3">
         <input class="btn btn-primary" type="submit" name="" value="查询">
      </div>
    </form>
  </div>
  <div class="box box-primary lab-report">
    <div class="box-body">
      <table class="table table-bordered table-striped">
        <thead>
          <tr class="info">
            <th>ID</th>
            <th>校区</th>
            <th>楼栋</th>
            <th>实验室</th>
            <th>实验室类型</th>
            <th>容量（人）</th>
            <th>可用时段</th>
            <th>操作</th>
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
            <td><button class="btn btn-xs btn-success" data-toggle="modal" data-target="#reserveModal">预约</button>
            </td>
          </tr>
         </c:forEach>
        </tbody>
      </table>
    </div>
  </div>

  <!-- 实验室预约模态框 -->
  <div class="modal fade" id="reserveModal" tabindex="-1" role="dialog" 
       aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header bg-aqua-active">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
          <h4 class="modal-title" id="myModalLabel">实验室预约</h4>
          <div class="cardimg">
            <img class="profile-user-img img-responsive img-circle" src="/assets/vendor/AdminLTE/dist/img/avatar.png">
          </div>
        </div>
        <div class="modal-body">
          <h3 class="profile-username text-center" style="margin-top:36px;">
            <%=username %>
          </h3>
          <ul class="list-group list-group-unbordered">
              <li class="list-group-item">
                <b>实验室ID</b> <a class="pull-right" id="roomId"></a>
              </li>
              <li class="list-group-item">
                <b>校区</b> <a class="pull-right" id="campus"></a>
              </li>
              <li class="list-group-item">
                <b>实验室</b> <a class="pull-right" id="room"></a>
              </li>
              <li class="list-group-item">
                <b>实验室类型</b> <a class="pull-right" id="roomType"></a>
              </li>
              <li class="list-group-item">
                <b>实验室容量</b> <a class="pull-right" id="roomCapacity">80人</a>
              </li>
              <li class="list-group-item">
                <b>课程名称</b> 
                <a class="pull-right">
                  <input id="courseName" type="text" class="form-control input-sm">
                </a>
              </li>
              <li class="list-group-item">
                <b>预约时段</b> 
                <a class="pull-right">
                  <span id="date"></span>
                  <select class="form-control select2" id="fromTime">
                    <option>8:00</option>
                    <option>10:00</option>
                    <option>14:00</option>
                    <option>16:00</option>
                    <option>19:00</option>
                  </select>
                  <span>至</span><span id="toTime"></span>
                </a>
              </li>
            </ul>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
          <button type="button" class="btn btn-primary" id="submitReservation">提交申请</button>
        </div>
      </div>
    </div>
  </div>
  <!-- /实验室预约模态框 -->

    </section>
  </div>

  <!-- Main Footer -->
  <footer class="main-footer">
    <strong>Copyright &copy; 2015 理工四少.</strong> All rights reserved.
  </footer>
</div>

  <script src="/assets/vendor/bootstrap-sweetalert/lib/sweet-alert.min.js"></script>
  <script src="/assets/vendor/jquery/dist/jquery.min.js"></script>
  <script src="/assets/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
  <script src="/assets/vendor/AdminLTE/plugins/datatables/jquery.dataTables.min.js"></script>
  <script src="/assets/vendor/AdminLTE/plugins/datatables/dataTables.bootstrap.min.js"></script>
  
  <script src="/assets/vendor/AdminLTE/plugins/slimScroll/jquery.slimscroll.min.js"></script>
  <script src="/assets/vendor/AdminLTE/plugins/fastclick/fastclick.min.js"></script>
  <script src="/assets/vendor/AdminLTE/dist/js/app.min.js"></script>

  <script src="/assets/vendor/AdminLTE/plugins/select2/select2.full.min.js"></script>
  <script src="/assets/vendor/AdminLTE/plugins/datepicker/bootstrap-datepicker.js"></script>
  <script src="/assets/vendor/AdminLTE/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
  <script src="/assets/js/common.js"></script>
  
  <script>
    $(function () {
        var now = new Date();
        
        //调用datatable插件
        $(".table").DataTable();

        //调用select2插件
        $(".select2").select2();

        //调用datepicker插件
        $('.datepicker').datepicker({
            format: "yyyy-mm-dd",
            startDate: now.getFullYear() + "-" + (now.getMonth() + 1) + "-" + now.getDate(),
            language: "zh-CN",
            autoclose: true,
            todayHighlight: true
        });

        //根据开始时间获取截止时间
        $("#fromTime").on("change", function() {
          var fromTime = $(this).val().substring(0,2);
          var toTime = parseInt(fromTime)+2;
          $('#toTime').text(toTime+":00"); 
        });

        //将要预约的教室的相关信息显示在预约单上
        $(".lab-report td > button").on("click", function() {
          var roomId = $(this).closest("tr").find("td:eq(0)").text();
          var campus = $(this).closest("tr").find("td:eq(1)").text();
          var building = $(this).closest("tr").find("td:eq(2)").text();
          var room = $(this).closest("tr").find("td:eq(3)").text();
          var roomType = $(this).closest("tr").find("td:eq(4)").text();
          var roomCapacity = $(this).closest("tr").find("td:eq(5)").text();
          var date = $(this).closest("tr").find("td:eq(6)").text().substring(0,10);
          $("#roomId").text(roomId);
          $("#campus").text(campus);
          $("#room").text(building+"-"+room);
          $("#roomType").text(roomType);
          $("#roomCapacity").text(roomCapacity);
          $("#date").text(date);
        });
        
        //提交预约申请
        $("#submitReservation").on("click",function(){
          var labRoomId = $("#roomId").text();
          var courseName = $("#courseName").val();
          var reserveTime =  $("#date").text()+" "+$("#fromTime").val();
          //创建一个json数组用来存储实验室ID、课程名称、预约时间
          var data = {
                labRoomId : labRoomId,
                courseName : courseName,
                reserveTime :reserveTime
            };
            data = JSON.stringify(data);
            $.ajax({
                type:"POST",
                contentType:"application/json;charset=UTF-8",
                dataType:"json",
                url:"/lab/reserve",
                data: data,
                success : function(data) {
                  sweetAlert({
                      title: '系统提示',
                      text: '预约申请提交成功，请关注后续处理！',
                      type: 'success'
                    }, function() {
                      $('#reserveModal').modal('hide');
                    });
                },
                error:function(data){
                  sweetAlert('系统提示', '预约申请提交失败，请重新操作！', 'error');
                }
            });
            return false;
        });

      });
  </script>
</body>
</html>

