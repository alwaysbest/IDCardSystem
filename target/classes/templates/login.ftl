<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理员登陆页面</title>
</head>
<body>
<h1>管理员登陆页面</h1>
<form action="/admin/addqueryadmin" name="loginfrom" accept-charset="utf-8" method="post">
    <label class="label-tips" for="u">账号:</label>
    <input type="text" id="u" name="account" class="inputstyle"/>
    <div>
        <label class="lable-tips" for="password">密码:</label>
        <input type="password" id="password" name="password" class="inputstyle" />
    </div>
    <input type="submit" name="登录"/>
    <!--<a href="register.html" class="zcxy" target="_blank">注册</a>-->
</form>

</body>
</html>