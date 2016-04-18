<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="chrome=1,IE=edge">
<title>登录</title>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/vendor/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/vendor/font-awesome/css/font-awesome.min.css">

<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/common.css">

<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/login.css">


<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body class="login-page">

	<div class="background"></div>
	<div class="wrapper">
		<div class="container">
			<form action="<%=request.getContextPath()%>/login" method="post">
				<h3>登录</h3>
				<div class="errorbox"></div>
				<div class="field">
					<input type="text" class="form-control" name="username"
						placeholder="用户名"> <i class="fa fa-user icon"></i>
				</div>
				<div class="field">
					<input type="password" class="form-control" name="password"
						placeholder="密码"> <i class="fa fa-lock icon"></i>
				</div>
				<div class="field identity">
					<label>身份：</label>
					<ul class="list-inline">
						<li><label><input type="radio" name="identity"
								value="student" checked> 学生</label></li>
						<li><label><input type="radio" name="identity"
								value="teacher"> 教师</label></li>
						<li><label><input type="radio" name="identity"
								value="manager"> 管理员</label></li>
					</ul>
				</div>
				<div class="field">
					<button type="submit">登录</button>
				</div>
			</form>
            <div align="center">
                测试账号,账号与密码一致<br/>
                <button type="button" class="btn btn-success" style="font-size: 12px">学生: 0121310880433</button>
                <button type="button" class="btn btn-success" style="font-size: 12px">教师: 67539863</button>
                <button type="button" class="btn btn-success" style="font-size: 12px">管理员: 28266345</button>
            </div>
		</div>
	</div>




	<script src="<%=request.getContextPath()%>/assets/vendor/jquery/dist/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/vendor/bootstrap/dist/js/bootstrap.min.js"></script>




	<script src="<%=request.getContextPath()%>/assets/js/common.js"></script>


	<script type="text/template" id="errormsg-template">
    <div class="alert alert-danger alert-dismissible" role="alert">
      <button type="button" class="close" data-dismiss="alert" aria-label="关闭"><span aria-hidden="true">&times;</span></button>
      <h4>登录失败</h4>
      <p class="errormsg">{errormsg}</p>
    </div>
  </script>
	<script
		src="<%=request.getContextPath()%>/assets/vendor/jquery-backstretch/jquery.backstretch.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/login.js"></script>


</body>
</html>

