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
    <title>Ants 选课系统</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/vendor/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/vendor/bootstrap-sweetalert/lib/sweet-alert.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/vendor/AdminLTE/plugins/select2/select2.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/vendor/AdminLTE/plugins/datatables/dataTables.bootstrap.css">
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
                            <img src="<%=request.getContextPath()%>/assets/img/manager.png" class="user-image" alt="User Image">
                            <!-- hidden-xs hides the username on small devices so only the image appears. -->
                            <span class="hidden-xs"><%=username%></span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- The user image in the menu -->
                            <li class="user-header">
                                <img src="<%=request.getContextPath()%>/assets/img/manager.png" class="img-circle" alt="User Image">
                                <p>
                                    <%=username%> - 管理员<small>登录时间: <%=now %></small></p>
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
                    <img src="<%=request.getContextPath()%>/assets/img/manager.png" class="img-circle" alt="User Image">
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
                        <a href="<%=request.getContextPath()%>/manager/classroom">
                            <i class="fa fa-flask"></i>
                            <span>查看教室</span>
                            <i class="fa fa-angle-left pull-right"></i>
                        </a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/manager/course">
                            <i class="fa fa-gears"></i>
                            <span>查看课表</span>
                            <i class="fa fa-angle-left pull-right"></i>
                        </a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/manager/course/schedule">
                            <i class="fa fa-gears"></i>
                            <span>排课</span>
                            <i class="fa fa-angle-left pull-right"></i>
                        </a>
                    </li>

                    <li>
                        <a href="#">
                            <i class="fa fa-users"></i>
                            <span>用户管理</span>
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
            <h1>排课<small>Course Schedule</small></h1>

            <ol class="breadcrumb">
                <li><a href="<%=request.getContextPath()%>"><i class="fa fa-dashboard"></i>主页</a></li>
                <li class="active">排课</li>
            </ol>

        </section>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid search-area">
                <form action="#" class="row">
                    <div class="col-md-4">
                        <label>专业</label>
                        <input type="text" class="form-control" name="major" placeholder="专业名称" value="${requestScope.major}">
                    </div>
                    <div class="col-md-4">
                        <label>已排课</label>
                        <select tabindex="-1" class="form-control select2" name="isSchedule">
                            <option value="all">所有</option>
                            <option value="true">是</option>
                            <option value="false">否</option>
                        </select>
                    </div>
                    <label>&nbsp;</label>
                    <div class="col-md-4">
                        <button type="submit" class="btn btn-primary">查询</button>
                    </div>
                </form>
            </div>

            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title"></h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-sm btn-success" id="btn-add-course">
                            <i class="fa fa-plus"></i> 新增课程
                        </button>
                    </div>
                </div>
                <div class="box-body">
                    <table class="table table-bordered table-striped table-hover">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>名称</th>
                            <th>班级</th>
                            <th>时间</th>
                            <th>地点</th>
                            <th>已选</th>
                            <th>容量</th>
                            <th>教师</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${requestScope.courseList }" var="item">
                            <tr data-note="${item.description}"
                                data-weekFrom="${item.weekFrom }"
                                data-weekTo="${item.weekTo}"
                                data-weekday="${item.weekday }"
                                data-timeFrom="${item.timeFrom }"
                                data-timeTo="${item.timeTo }">

                                <td>${item.id }</td>
                                <td>${item.name }</td>
                                <td>${item.classes }</td>
                                <c:if test="${item.timeFrom != null}">
                                    <td>第${item.weekFrom }-${item.weekTo}周,星期${item.weekday },${item.timeFrom }-${item.timeTo }</td>
                                </c:if>
                                <c:if test="${item.timeFrom == null}">
                                    <td></td>
                                </c:if>
                                <td>${item.classroomId}</td>
                                <td>${item.now}</td>
                                <td>${item.capacity}</td>
                                <td>${item.teacherName}</td>
                                <td>
                                    <button class="btn btn-xs btn-warning">
                                        <i class="fa fa-edit"></i> 编辑
                                    </button>
                                    <button class="btn btn-xs btn-danger">
                                        <i class="fa fa-remove"></i> 删除
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <div id="course-modal" class="modal fade in">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"
                                    aria-label="关闭">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title">添加课程</h4>
                        </div>
                        <form action="#" method="post" class="form-horizontal" accept-charset="utf8">
                            <input type="hidden" name="id">
                            <input type="hidden" name="action">
                            <div class="modal-body">
                                <div class="form-group new edit scrap">
                                    <label class="col-sm-2 control-label required" for="input-course-name">课程名称</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="input-course-name" name="name" required>
                                    </div>
                                </div>
                                <div class="form-group new edit scrap">
                                    <label class="col-sm-2 control-label required" for="input-course-teacher">教师工号</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="input-course-teacher" name="teacher" required>
                                    </div>
                                </div>
                                <div class="form-group new edit scrap">
                                    <label class="col-sm-2 control-label required" for="input-course-classes">授课班级</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="input-course-classes" name="classes" required>
                                    </div>
                                </div>
                                <div class="form-group new edit scrap">
                                    <label class="col-sm-2 control-label required"
                                           for="input-course-weekFrom">起始结束周</label>
                                    <div class="col-sm-2">
                                        <div class="input-group">
                                            <input type="number" class="form-control"
                                                   id="input-course-weekFrom" name="weekFrom" min="1" required>
                                        </div>
                                    </div>
                                    <label class="col-sm-2 control-label required"
                                           for="input-course-weekTo">至</label>
                                    <div class="col-sm-2">
                                        <div class="input-group">
                                            <input type="number" class="form-control"
                                                   id="input-course-weekTo" name="weekTo" min="1" required>
                                        </div>
                                    </div>
                                    <label class="col-sm-2 control-label required"
                                           for="input-course-weekday">星期</label>
                                    <div class="col-sm-2">
                                        <div class="input-group">
                                            <input type="number" class="form-control"
                                                   id="input-course-weekday" name="weekday" min="1" required>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group new edit scrap">
                                    <label class="col-sm-2 control-label required" for="input-course-classroom">教室编号</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="input-course-classroom" name="classroom" required>
                                    </div>
                                </div>
                                <div class="form-group new edit scrap">
                                    <label class="col-sm-2 control-label required"
                                           for="input-course-time">上课时间</label>
                                    <div class="col-sm-10">
                                        <div class="input-group">
                                            <a class="pull-right" id="input-course-time">
                                                <span id="date"></span>
                                                <select class="form-control select2" id="timeFrom">
                                                    <option value="08:00:00">8:00</option>
                                                    <option value="10:00:00">10:00</option>
                                                    <option value="14:00:00">14:00</option>
                                                    <option value="16:00:00">16:00</option>
                                                    <option value="19:00:00">19:00</option>
                                                </select>
                                                <span>至</span><span id="timeTo">10:00:00</span>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group new edit scrap">
                                    <label class="col-sm-2 control-label required"
                                           for="input-course-now">已选人数</label>
                                    <div class="col-sm-2">
                                        <div class="input-group">
                                            <input type="number" class="form-control"
                                                   id="input-course-now" name="now" readonly>
                                        </div>
                                    </div>
                                    <label class="col-sm-2 control-label required"
                                           for="input-course-capacity">课程容量</label>
                                    <div class="col-sm-2">
                                        <div class="input-group">
                                            <input type="number" class="form-control"
                                                   id="input-course-capacity" name="capacity" min="1">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group new edit scrap">
                                    <label class="col-sm-2 control-label"
                                           for="input-course-note">补充说明</label>
                                    <div class="col-sm-10">
											<textarea class="form-control" rows="4"
                                                      id="input-course-note" name="note"
                                                      style="resize: vertical"></textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default pull-left"
                                        data-dismiss="modal">关闭</button>
                                <button type="submit" class="btn btn-primary">保存</button>
                            </div>
                        </form>
                    </div>
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
<script src="<%=request.getContextPath()%>/assets/vendor/bootstrap-sweetalert/lib/sweet-alert.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/vendor/AdminLTE/plugins/select2/select2.full.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/vendor/AdminLTE/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/vendor/AdminLTE/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/common.js"></script>
<script>
    $(document).ready(function() {
        var table = $(".table").DataTable({
            "columnDefs": [{
                "orderable": false,
                "targets": [4, 5]
            }]
        });

        //根据开始时间获取截止时间
        $("#timeFrom").on("change", function() {
            var timeFrom = $(this).val();
            if(!timeFrom) return;
            var timeTo = parseInt(timeFrom) + 2;
            $('#timeTo').text(timeTo + ":00:00");
        });

        $('.select2').select2();
        $('.select2[name=isSchedule]').select2('val', '${requestScope.isSchedule}');

        function modal_assign($tr) {
            var $modal = $('#course-modal');

            $modal.find('[name=id]').val($tr.find('td:nth-child(1)').text());
            $modal.find('[name=name]').val($tr.find('td:nth-child(2)').text());
            $modal.find('[name=classes]').val($tr.find('td:nth-child(3)').text());

            $modal.find('[name=weekFrom]').val($tr.data('weekfrom'));
            $modal.find('[name=weekTo]').val($tr.data('weekto'));
            $modal.find('[name=weekday]').val($tr.data('weekday'));
            $modal.find('#timeFrom').select2('val', $tr.data('timefrom'));
            $modal.find('#timeTo').text($tr.data('timeto'));

            $modal.find('[name=classroom]').val($tr.find('td:nth-child(5)').text());
            $modal.find('[name=now]').val($tr.find('td:nth-child(6)').text());
            $modal.find('[name=capacity]').val($tr.find('td:nth-child(7)').text());
            $modal.find('[name=teacher]').val($tr.find('td:nth-child(8)').text());
            $modal.find('[name=note]').val($tr.data('note'));
        }

        function modal_disable_inputs(flag) {
            var $modal = $('#course-modal');
            $modal.find('input').prop('disabled', flag);
        }

        // 新建课程
        $('#btn-add-course').on('click', function() {
            var $modal = $('#course-modal');
            $modal.find('[name=action]').val('new');
            $modal.find('[name=name]').val('');
            $modal.find('[name=teacher]').val('');
            $modal.find('#input-course-capacity').val('');
            $modal.find('#input-course-now').val('');
            $modal.find('[name=classes]').val('');
            $modal.find('[name=weekFrom]').val('');
            $modal.find('[name=weekTo]').val('');
            $modal.find('[name=weekday]').val('');
            $modal.find('[name=classroom]').val('');
            $modal.find('[name=note]').val('');
            $modal.modal('show');
        });
        // 修改课程
        $('.box-body .table').on('click', '.btn-warning', function() {
            var $tr = $(this).closest('tr');
            var $modal = $('#course-modal');
            $modal.find('.modal-title').text('编辑课程');
            modal_assign($tr);
            modal_disable_inputs(false);
            $modal.find('#input-course-now').prop('disabled', true);
            $modal.find('[name=action]').val('edit');
            $modal.modal('show');
        });
        // 删除课程
        $('.box-body .table').on('click', '.btn-danger', function() {
            var $tr = $(this).closest('tr');
            var $modal = $('#course-modal');
            $modal.find('.modal-title').text('删除课程');
            modal_assign($tr);
            modal_disable_inputs(true);
            $modal.find('#input-course-note').prop('disabled', true);
            $modal.find('#timeFrom').prop('disabled', true);
            $modal.find('[name=action]').val('scrap');
            $modal.modal('show');
        });

        // 提交新增,修改,删除操作
        $('#course-modal form').on('submit', function() {
            var $form = $(this);
            $.ajax({
                url: '<%=request.getContextPath()%>/manager/course/schedule',
                type: 'POST',
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify({
                    'action': $form.find('[name=action]').val(),
                    'id': $form.find('[name=id]').val(),
                    'name': $form.find('[name=name]').val(),
                    'capacity': $form.find('#input-course-capacity').val(),
                    'now': $form.find('#input-course-now').val(),
                    'teacherId': $form.find('[name=teacher]').val(),
                    'classes': $form.find('[name=classes]').val(),
                    'weekFrom': $form.find('[name=weekFrom]').val(),
                    'weekTo': $form.find('[name=weekTo]').val(),
                    'weekday': $form.find('[name=weekday]').val(),
                    'timeFrom': $form.find('#timeFrom').val(),
                    'timeTo': $form.find('#timeTo').text(),
                    'classroom': $form.find('[name=classroom]').val(),
                    'note': $form.find('[name=note]').val()
                })
            }).done(function(data) {
                $('#course-modal').modal('hide');
                if (data.success == 'true') {
                    sweetAlert('系统提示', data.message || '操作成功！', 'success');
                    window.location.reload();
                } else {
                    sweetAlert('系统提示', data.message || '操作失败！', 'error');
                }
            }).fail(function() {
                sweetAlert('系统提示', '操作失败！网络错误', 'error');
            });
            return false;
        });
    });

</script>

</body>

</html>
