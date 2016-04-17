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
            <li>
              <a href="">
                <i class="fa fa-flask"></i>
                <span>实验室管理</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li>
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
            <li class="active">
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
                <li class="active">
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
        <h1>设备维修管理 <small>Manage Equipment Repairs</small></h1>

        <ol class="breadcrumb">
          <li><a href="/"><i class="fa fa-dashboard"></i>主页</a></li>
          <li>仪器设备及耗材管理</li>
          <li class="active">设备维修管理</li>
        </ol>

      </section>

      <!-- Main content -->
      <section class="content">

        <div class="box box-primary">
          <div class="box-body">
            <table class="table table-bordered table-hover">
              <thead>
                <tr>
                  <th>登记时间</th>
                  <th>设备名称</th>
                  <th>设备分类</th>
                  <th>维修数量/单位</th>
                  <th>登记描述</th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
              <c:forEach items="${requestScope.repairlist }" var="repair">
                <tr data-id="${repair.equipmentMaintenanceId }">
                  <td>${repair.checkInTime }</td>
                  <td data-equipment-id="${repair.equipmentId }">${repair.equipmentId }</td>
                  <td data-category="${repair.categoryId }">${repair.parentName } - ${repair.categoryName }</td>
                  <td data-amount="${repair.amount }" data-unit="${repair.unit }">${repair.amount }</td>
                  <td>${repair.checkInDescription }</td>
                  <td>
                    <button class="btn btn-xs btn-primary"><i class="fa fa-plus"></i> 回库</button>
                  </td>
                </tr>
              </c:forEach>
              </tbody>
            </table>
          </div>
        </div>

        <div id="repair-modal" class="modal fade in">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="关闭">
                  <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">设备回库</h4>
              </div>
              <form action="#" method="post" class="form-horizontal" accept-charset="utf8">
                <input type="hidden" name="id">
                <input type="hidden" name="action">
                <input type="hidden" name="amount">
                <div class="modal-body">
                  <div class="form-group">
                    <label class="col-sm-2 control-label">设备名称</label>
                    <div class="col-sm-10">
                      <p class="form-control-static display-name"></p>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">设备分类</label>
                    <div class="col-sm-10">
                      <p class="form-control-static display-category"></p>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">维修数量</label>
                    <div class="col-sm-10">
                      <p class="form-control-static display-amount"></p>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">登记时间</label>
                    <div class="col-sm-10">
                      <p class="form-control-static display-recordtime"></p>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">登记描述</label>
                    <div class="col-sm-10">
                      <p class="form-control-static display-recordnote"></p>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label" for="input-note">操作描述</label>
                    <div class="col-sm-10">
                      <textarea class="form-control" rows="4" id="input-note" name="note" style="resize:vertical"></textarea>
                    </div>
                  </div>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
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
  <script>
    $(document).ready(function() {
      var table = $(".table").DataTable({
        "order": [
          [0, 'desc']
        ],
        "columnDefs": [{
          "orderable": false,
          "targets": [4, 5]
        }]
      });
      $('.select2').select2();

      function modal_assign($tr) {
        var $modal = $('#repair-modal');
        $modal.find('[name=id]').val($tr.data('id'));
        $modal.find('.display-recordtime').text($tr.find('td:nth-child(1)').text());
        $modal.find('.display-name').text($tr.find('td:nth-child(2)').text());
        $modal.find('.display-category').text($tr.find('td:nth-child(3)').text());
        $modal.find('[name=category]').val($tr.find('td:nth-child(3)').data('category'));
        $modal.find('.display-amount').text($tr.find('td:nth-child(4)').data('amount') + ' ' + $tr.find('td:nth-child(4)').data('unit'));
        $modal.find('[name=amount]').val($tr.find('td:nth-child(4)').data('amount'));
        $modal.find('.input-group-addon').text($tr.find('td:nth-child(4)').data('unit'));
        $modal.find('.display-recordnote').text($tr.find('td:nth-child(5)').text());
      }
      $('.box-body .table').on('click', '.btn-primary', function() {
        var $tr = $(this).closest('tr');
        var $modal = $('#repair-modal');
        modal_assign($tr);
        $modal.find('.modal-title').text('设备回库');
        $modal.find('[name=action]').val('return');
        $modal.find('[name=note]').val('');
        $modal.modal('show');
      });
      $('#repair-modal form').on('submit', function() {
        // TODO
        var $form = $(this);
        $.ajax({
          url: '/equipment',
          type: 'POST',
          contentType: 'application/json',
          dataType: 'json',
          data: JSON.stringify({
            'action': $form.find('[name=action]').val(),
            'id': $form.find('[name=id]').val(),
            'amount': $form.find('[name=amount]').val(),
            'note': $form.find('[name=note]').val()
          })
        }).done(function(data) {
          // TODO
          $('#repair-modal').modal('hide');
          if (data.success == 'true') {
            var $tr = $('.table tbody>tr[data-id="' + $form.find('[name=id]').val() + '"]');
            table.row($tr).remove().draw();
            sweetAlert('系统提示', data.message || '操作成功！', 'success');
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
