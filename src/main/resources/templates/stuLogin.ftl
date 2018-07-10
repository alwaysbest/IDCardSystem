<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>学生登陆界面</title>
</head>
<body>
<form action="/student/queryStudent" name="loginfrom" accept-charset="utf-8" method="post">
    <label class="label-tips" for="u">身份证号码:</label>
    <input type="text" id="u" name="IdCard" class="inputstyle"/>
    <div>
        <label class="lable-tips" for="password">录取号:</label>
        <input type="password" id="password" name="enroll" class="inputstyle" />
    </div>
    <input type="submit" name="登录"/>
</body>
</html>