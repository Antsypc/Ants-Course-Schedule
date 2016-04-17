<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1,IE=edge">
    <title></title>
    <link rel="stylesheet" href="">
       <script type="text/javascript" src="assets/vendor/jquery/dist/jquery.min.js"></script>
</head>
<body>
    <div>
        <form action="" class="signin"  method="post" >
            用户名：<input type="text" id="username" name="username" value="" placeholder=""><br>
            密码：<input type="password" id="password" name="password" value="" placeholder=""><br>
            <label>身份：</label>
            <label><input type="radio" name="status" value="student" checked> 学生</label>
            <label><input type="radio" name="status" value="teacher"> 教师</label>
            <label><input type="radio" name="status" value="manager"> 管理员</label><br>
            <input type="submit" name="" value="登录">
        </form>
        <button id="getuserinfo">获取当前用户信息</button>
        <button id="updateinfo">更新用户信息</button>
        <button id="studentgetcourses">学生获取尚未结束的课程信息</button>
        <button id="studentgetchoosingcourse">学生获取可选实验课的实验室</button>
        <button id="studentpostcourse">学生提交实验室选择结果</button>
        
    </div>
    <script type="text/javascript">

        $('.signin').on('submit', function() {

        console.log(1);
        var username = $('#username').val(),
                password = $('#password').val(),
                status = $('input:radio:checked').val();
        console.log(username);
        var data = {
            username : username,
            password : password,
            status : status,
        };
        data = JSON.stringify(data);
        console.log(data);
        console.log(3);
        $.ajax({
            type:"POST",
            contentType:"application/json",
            dataType:"json",
            url:"logincheck",
            data: data,
            success : function(data) {
                console.log(data);
            },
            error: function(data) {
                console.log(data);
            }
        });
        console.log(4);
        return false;
    });
    
    $("#getuserinfo").on('click', function() {
        $.ajax({
            type:"GET",
            url:"profile",
            success : function(data) {
                console.log(data);
            },
            error: function(data) {
                console.log(data);
            }
        });
        console.log(4);
        return false;
    });
    $("#updateinfo").on('click', function() {
        var data ={
            oldpassword : "0121310880410",
            newpassword : "mys",  // 如果不修改密码则不写这一条
            phone : "15527353198",
            email : "99@qq.com"
        };
        data = JSON.stringify(data);
        console.log(data);
        $.ajax({
            type:"POST",
            contentType:"application/json",
            dataType:"json",
            data: data,
            url:"profile",
            success : function(data) {
                console.log(data);
            },
            error: function(data) {
                console.log(data);
            }
        });
        console.log(4);
        return false;
    });
    
    $("#studentgetcourses").on('click', function() {
        $.ajax({
            type:"GET",
            url:"studentcourse?action=getCourses",
            success : function(data) {
                console.log(data);
                // 结果示例
            },
            error: function(data) {
                console.log(data);
            }
        });
        console.log(4);
        return false;
    });
    
    $("#studentgetchoosingcourse").on('click', function() {
        $.ajax({
            type:"GET",
            url:"studentcourse?action=getChoosingCourse",
            success : function(data) {
                console.log(data);
                // 结果示例
                //[{"courseId":1,"courseName":"操作系统","teacherName":"刘德华","labRoomId":"2010901","campus":"鉴湖","building":"鉴主","roomName":"901","roomType":"计算机","capacity":80,"nowNum":0,"labRoomUsageId":1},{"courseId":2,"courseName":"计算机组成原理","teacherName":"刘德华","labRoomId":"2010901","campus":"鉴湖","building":"鉴主","roomName":"901","roomType":"计算机","capacity":80,"nowNum":0,"labRoomUsageId":2},{"courseId":3,"courseName":"数据库","teacherName":"刘德华","labRoomId":"2010901","campus":"鉴湖","building":"鉴主","roomName":"901","roomType":"计算机","capacity":80,"nowNum":0,"labRoomUsageId":3}]
                },
            error: function(data) {
                console.log(data);
            }
        });
        console.log(4);
        return false;
    });
    
    $("#studentpostcourse").on('click', function() {
        var data ={
            labRoomUsageId : "1"
        };
        data = JSON.stringify(data);
        console.log(data);
        $.ajax({
            type:"POST",
            contentType:"application/json",
            dataType:"json",
            data: data,
            url:"studentcourse",
            success : function(data) {
                console.log(data);
            },
            error: function(data) {
                console.log(data);
            }
        });
        console.log(4);
        return false;
    });
        
    </script>

</body>
</html>