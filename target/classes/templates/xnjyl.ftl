<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录界面</title>
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/form-elements.css">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="shortcut icon" href="../img/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../img/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../img/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../img/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../img/ico/apple-touch-icon-57-precomposed.png">
</head>
<body >
<!--<h1>欢迎登录人脸识别系统</h1>-->
<!--<a href="/admin/login" name="管理员登陆">管理员登录</a>-->
<!--<a href="/student/stuLogin" name="学生登陆">学生登录</a>-->


<!-- Top content -->
<div class="top-content" style="background:url('../img/backgrounds/1.jpg')">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>Nanjing University</strong> IDCard System</h1>
                    <div class="description">
                        <p>
                            This is an IDCard System for Nanjing University , you can update your photos of the card on the website.
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-3  form-box"></div>
                <div class="col-sm-3  form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>Admin Login</h3>
                            <p>Enterence for Admin:</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-key"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" id="adminform"action="/admin/addqueryadmin" method="post" class="login-form">
                            <div class="form-group">
                                <label class="sr-only" for="admin">Username</label>
                                <input type="text" name="account" placeholder="Username..." class="form-username form-control" id="admin"/>
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="adminpassword">Password</label>
                                <input type="password" name="password" placeholder="Password..." class="form-password form-control" id="adminpassword">
                            </div>
                            <button type="submit" id="adminSubmit" class="btn">Login</button>
                        </form>
                    </div>
                </div>

                <div class="col-sm-3  form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>Student Login</h3>
                            <p>Enterence for Student:</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-key"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" action="/student/queryStudent" method="post" class="login-form">
                            <div class="form-group">
                                <label class="sr-only" for="student">Username</label>
                                <input type="text" name="IdCard" placeholder="Username..." class="form-username form-control" id="student">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="stupassword">Password</label>
                                <input type="password" name="enroll" placeholder="Password..." class="form-password form-control" id="stupassword">
                            </div>
                            <button type="submit" id="stuSubmit" class="btn">Login</button>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>

</div>


<!-- Javascript -->
<script src="../js/jquery-1.11.1.min.js"></script>
<script src="../js/jquery-2.1.1.js"></script>

<script src="../bootstrap/js/bootstrap.min.js"></script>
<script src="../js/jquery.backstretch.min.js"></script>
<script src="../js/scripts.js"></script>
<!--[if lt IE 10]>
<script src="../js/placeholder.js"></script>
<![endif]-->
<script>
    $('#adminSubmit').click(function(){
        if($('#admin').val()==''){
        alert('用户名或密码不得为空');
        }

    });

</script>


</body>
</html>