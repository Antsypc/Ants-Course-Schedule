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
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">

<link rel="stylesheet"
	href="/assets/vendor/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/assets/vendor/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="/assets/vendor/bootstrap-sweetalert/lib/sweet-alert.css">
<link rel="stylesheet"
	href="/assets/vendor/AdminLTE/plugins/select2/select2.min.css">
<link rel="stylesheet"
	href="/assets/vendor/AdminLTE/plugins/datatables/dataTables.bootstrap.css">
<link rel="stylesheet"
	href="/assets/vendor/AdminLTE/dist/css/AdminLTE.min.css">
<link rel="stylesheet"
	href="/assets/vendor/AdminLTE/dist/css/skins/skin-blue.min.css">
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
                    <%=username%> - 实验室管理员<small>登录时间: <%=now %>/small></p>
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
                <li class="active">
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
				<h1>
					设备管理 <small>Manage Equipments</small>
				</h1>

				<ol class="breadcrumb">
					<li><a href="/"><i class="fa fa-dashboard"></i>主页</a></li>
					<li>仪器设备及耗材管理</li>
					<li class="active">设备管理</li>
				</ol>

			</section>

			<!-- Main content -->
			<section class="content">

				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title"></h3>
						<div class="box-tools pull-right">
							<button class="btn btn-sm btn-success" id="btn-add-equipment">
								<i class="fa fa-plus"></i> 新增设备
							</button>
						</div>
					</div>
					<div class="box-body">
						<table class="table table-bordered table-striped table-hover">
							<thead>
								<tr>
									<th>设备名称</th>
									<th>设备分类</th>
									<th>设备总量</th>
									<th>闲置数量</th>
									<th>单位</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${requestScope.equip }" var="eqment">
									<tr data-id="${eqment.equipmentId }">
										<td>${eqment.equipmentId }</td>
										<td data-category="${eqment.categoryId }">${eqment.parentName } - ${eqment.categoryName }</td>
										<td>${eqment.total }</td>
										<td>${eqment.free }</td>
										<td>${eqment.unit }</td>
										<td>
											<button class="btn btn-xs btn-primary">
												<i class="fa fa-plus"></i> 添加
											</button>
											<button class="btn btn-xs btn-warning">
												<i class="fa fa-wrench"></i> 维修
											</button>
											<button class="btn btn-xs btn-danger">
												<i class="fa fa-remove"></i> 报废
											</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

				<div id="equipment-modal" class="modal fade in">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="关闭">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title">添加设备</h4>
							</div>
							<form action="#" method="post" class="form-horizontal"
								accept-charset="utf8">
								<input type="hidden" name="id"> <input type="hidden"
									name="action">
								<div class="modal-body">
									<div class="form-group new add repair scrap">
										<label class="col-sm-2 control-label required"
											for="input-equipment-name">设备名称</label>
										<div class="col-sm-10">
											<input type="text" class="form-control"
												id="input-equipment-name" name="name" required>
										</div>
									</div>
									<div class="form-group new add repair scrap">
										<label class="col-sm-2 control-label required"
											for="input-equipment-category">设备分类</label>
										<div class="col-sm-10">
											<select class="form-control select2"
												id="input-equipment-category" name="category"
												style="width: 100%" required>
												<select>
										</div>
									</div>
									<div class="form-group new add repair scrap">
										<label class="col-sm-2 control-label required"
											for="input-equipment-total">设备数量</label>
										<div class="col-sm-10">
											<div class="input-group">
												<input type="number" class="form-control"
													id="input-equipment-total" name="total" min="0" required>
												<span class="input-group-addon"></span>
											</div>
										</div>
									</div>
									<div class="form-group add repair scrap">
										<label class="col-sm-2 control-label"
											for="input-equipment-free">闲置数量</label>
										<div class="col-sm-10">
											<div class="input-group">
												<input type="number" class="form-control"
													id="input-equipment-free" name="free" min="0" required>
												<span class="input-group-addon"></span>
											</div>
										</div>
									</div>
									<div class="form-group new">
										<label class="col-sm-2 control-label"
											for="input-equipment-unit">设备单位</label>
										<div class="col-sm-10">
											<input type="text" class="form-control"
												id="input-equipment-unit" name="unit">
										</div>
									</div>
									<div class="form-group add repair scrap">
										<label class="col-sm-2 control-label required"
											for="input-equipment-number">操作数量</label>
										<div class="col-sm-10">
											<div class="input-group">
												<input type="number" class="form-control"
													id="input-equipment-number" name="number" min="0" required>
												<span class="input-group-addon"></span>
											</div>
										</div>
									</div>
									<div class="form-group repair scrap">
										<label class="col-sm-2 control-label"
											for="input-equipment-note">补充说明</label>
										<div class="col-sm-10">
											<textarea class="form-control" rows="4"
												id="input-equipment-note" name="note"
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
			<strong>Copyright &copy; 2015 理工四少.</strong> All rights reserved.
		</footer>
	</div>

	<script src="/assets/vendor/jquery/dist/jquery.min.js"></script>
	<script src="/assets/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
	<script
		src="/assets/vendor/AdminLTE/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script
		src="/assets/vendor/AdminLTE/plugins/fastclick/fastclick.min.js"></script>
	<script src="/assets/vendor/AdminLTE/dist/js/app.min.js"></script>
	<script
		src="/assets/vendor/bootstrap-sweetalert/lib/sweet-alert.min.js"></script>
	<script
		src="/assets/vendor/AdminLTE/plugins/select2/select2.full.min.js"></script>
	<script
		src="/assets/vendor/AdminLTE/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="/assets/vendor/AdminLTE/plugins/datatables/dataTables.bootstrap.min.js"></script>
	<script src="/assets/js/common.js"></script>
	<script>
    $(document).ready(function() {
      var table = $(".table").DataTable({
        "columnDefs": [{
          "orderable": false,
          "targets": [4, 5]
        }]
      });
      var categories = ${requestScope.category };
      $('#input-equipment-category').empty().append($.map(categories, function(v, k) {
        return '<optgroup label="' + k + '">' + $.map(v, function(v, k) {
          return '<option value="' + v.id + '">' + v.name + '</option>';
        }).join('') + '</optgroup>';
      }));
      $('.select2').select2();
      $('#btn-add-equipment').on('click', function() {
        var $modal = $('#equipment-modal');
        $modal.find('.modal-title').text('新增设备');
        $modal.find('input').prop('disabled', false).val('');
        $modal.find('.select2').prop('disabled', false).select2('val', '');
        $modal.find('[name=unit]').change();
        $modal.find('[name=number]').attr('min', '0').removeAttr('max');
        $modal.find('[name=free],[name=number]').val('0');
        $modal.find('[name=action]').val('new');
        $modal.find('.form-group').addClass('hidden').filter('.new').removeClass('hidden');
        $modal.modal('show');
      });

      function modal_assign($tr) {
        var $modal = $('#equipment-modal');
        $modal.find('[name=id]').val($tr.data('id'));
        $modal.find('[name=name]').val($tr.find('td:nth-child(1)').text());
        $modal.find('[name=category]').select2('val', $tr.find('td:nth-child(2)').data('category'));
        $modal.find('[name=total]').val($tr.find('td:nth-child(3)').text());
        $modal.find('[name=free]').val($tr.find('td:nth-child(4)').text());
        $modal.find('[name=unit]').val($tr.find('td:nth-child(5)').text()).change();
      }

      function modal_disable_inputs() {
        var $modal = $('#equipment-modal');
        $modal.find('[name=name],[name=category],[name=total],[name=free]').prop('disabled', true);
      }

      function get_category_name_by_id(id) {
        for (var first in categories) {
          for (var i = 0; i < categories[first].length; ++i) {
            if (id == categories[first][i].id) return [first, categories[first][i].name];
          }
        }
        return [];
      }
      $('.box-body .table').on('click', '.btn-primary', function() {
        var $tr = $(this).closest('tr');
        var $modal = $('#equipment-modal');
        modal_assign($tr);
        modal_disable_inputs();
        $modal.find('.modal-title').text('添加设备');
        $modal.find('[name=action]').val('add');
        $modal.find('[name=number],[name=note]').val('');
        $modal.find('[name=number]').attr('min', '1').removeAttr('max');
        $modal.find('.form-group').addClass('hidden').filter('.add').removeClass('hidden');
        $modal.find('[for=input-equipment-number]').text('添加数量');
        $modal.modal('show');
      });
      $('.box-body .table').on('click', '.btn-warning', function() {
        var $tr = $(this).closest('tr');
        var $modal = $('#equipment-modal');
        modal_assign($tr);
        modal_disable_inputs();
        $modal.find('.modal-title').text('维修设备');
        $modal.find('[name=action]').val('repair');
        $modal.find('[name=number],[name=note]').val('');
        $modal.find('[name=number]').attr('min', '1').attr('max', $modal.find('[name=free]').val());
        $modal.find('.form-group').addClass('hidden').filter('.repair').removeClass('hidden');
        $modal.find('[for=input-equipment-number]').text('维修数量');
        $modal.modal('show');
      });
      $('.box-body .table').on('click', '.btn-danger', function() {
        var $tr = $(this).closest('tr');
        var $modal = $('#equipment-modal');
        modal_assign($tr);
        modal_disable_inputs();
        $modal.find('.modal-title').text('设备报废');
        $modal.find('[name=action]').val('scrap');
        $modal.find('[name=number],[name=note]').val('');
        $modal.find('[name=number]').attr('min', '1').attr('max', $modal.find('[name=free]').val());
        $modal.find('.form-group').addClass('hidden').filter('.scrap').removeClass('hidden');
        $modal.find('[for=input-equipment-number]').text('报废数量');
        $modal.modal('show');
      });
      $('#equipment-modal [name=unit]').on('change keyup', function() {
        var unit = this.value;
        $('#equipment-modal .input-group-addon').text(unit);
      });
      $('#equipment-modal form').on('submit', function() {
        // TODO
        var $form = $(this);
        if ($form.find('[name=action]').val() != 'new' && ($form.find('[name=number]').val() | 0) <= 0) {
          sweetAlert('系统提示', '操作数量不能为空！', 'error');
          return false;
        } else if (['new', 'add'].indexOf($form.find('[name=action]').val()) < 0 && ($form.find('[name=number]').val() | 0) > ($form.find('[name=free]').val() | 0)) {
          sweetAlert('系统提示', '操作数量不能大于闲置数量！', 'error');
          return false;
        }
        $.ajax({
          url: '/equipment',
          type: 'POST',
          contentType: 'application/json',
          dataType: 'json',
          data: JSON.stringify({
            'action': $form.find('[name=action]').val(),
            'id': $form.find('[name=id]').val(),
            'name': $form.find('[name=name]').val(),
            'category': $form.find('[name=category]').val(),
            'total': $form.find('[name=total]').val(),
            'free': $form.find('[name=free]').val(),
            'unit': $form.find('[name=unit]').val(),
            'number': $form.find('[name=number]').val(),
            'note': $form.find('[name=note]').val()
          })
        }).done(function(data) {
          $('#equipment-modal').modal('hide');
          if (data.success == 'true') {
            var action = $form.find('[name=action]').val();
            var temp;
            if (['add', 'repair', 'scrap'].indexOf(action) > -1) {
              var $tr = $('.table tbody>tr[data-id="' + $form.find('[name=id]').val() + '"]');
              var row = table.row($tr);
              var num = $form.find('[name=number]').val() | 0;
              temp = row.data();
              switch (action) {
                case 'add':
                  temp[2] = (temp[2] | 0) + num;
                  temp[3] = (temp[3] | 0) + num;
                  break;
                case 'scrap':
                  temp[2] = (temp[2] | 0) - num;
                case 'repair':
                  temp[3] = (temp[3] | 0) - num;
                  break;
              }
              row.data(temp).draw();
            } else {
              temp = $('<tr></tr>').data('id', data.id);
              temp.append('<td>' + $form.find('[name=name]').val() + '</td>');
              temp.append('<td data-category="' + $form.find('[name=category]').val() + '">' + get_category_name_by_id($form.find('[name=category]').val()).join('/') + '</td>');
              temp.append('<td>' + $form.find('[name=total]').val() + '</td>');
              temp.append('<td>' + $form.find('[name=total]').val() + '</td>');
              temp.append('<td>' + $form.find('[name=unit]').val() + '</td>');
              temp.append('<td><button class="btn btn-xs btn-primary"><i class="fa fa-plus"></i> 添加</button> <button class="btn btn-xs btn-warning"><i class="fa fa-wrench"></i> 维修</button> <button class="btn btn-xs btn-danger"><i class="fa fa-remove"></i> 报废</button></td>');
              table.row.add(temp).draw();
            }
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
