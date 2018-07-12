<head>
    <meta charset="UTF-8" />
    <title>管理员主界面</title>
    <!--<link rel="stylesheet" href="../css/bootstrap.css"/>-->
    <!--<script src="../js/jquery-2.1.1.js"></script>-->
    <!--<script src="../js/bootstrap.js"></script>-->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css"/>
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body  style="background:url('../img/backgrounds/1.jpg')">

<div class="row">
    <div class="col-sm-3" style="background:#e8e5e5">
        <div style="text-align:center;height:150px;border-bottom:1px solid #dbd3d3">
            <p style="color:#6b6868;font-size:50px;padding-top:40px">管理员</p>
        </div>
        <br>
        <div style="height:100%;">
            <ul class="nav nav-pills nav-stacked">
                <li style="background:#2ab974;border-radius:5px"><a href="#" style="font-size:20px;color:#666666">添加管理</a></li>
                <li><a href="/admin/checkAdmin" style="font-size:20px;color:#666666">查看管理</a></li>
                <li><a href="#" style="font-size:20px;color:#666666">添加学生</a></li>
                <li><a href="#" style="font-size:20px;color:#666666">审核照片</a></li>
                <li><a href="#" style="font-size:20px;color:#666666">没有卵用</a></li>
                <li><a href="#" style="font-size:20px;color:#666666">啥也没有</a></li>
                <li><a href="#" style="font-size:20px;color:#666666">千万别点</a></li>
            </ul>
        </div>

    </div>


    <div class="col-sm-9"style="background:#ffffff;height:100%;display:flex;justify-content:center;align-items:center">
        <div class="ibox-content" style="width:500px;height:400px;border:1px solid #dbd3d3; border-radius:5px;display:flex;justify-content:center;align-items:center">
            <div>
                <form name="form2" accept-charset="utf-8"  action="/admin/addAdmin" method="post">
                    <div class="row form-group">
                        <label class="col-sm-3 control-label">姓名：</label>
                        <div class="col-sm-8" >
                            <input type="text" id="name" name="name" maxlength="16" class="form-control required"/>
                        </div>

                    </div>
                    <div class="row form-group">

                        <label class="col-sm-3 control-label">账号：</label>
                        <div class="col-sm-8" >
                            <input type="text" id="account" name="account" maxlength="16" class="form-control required"/>
                        </div>

                    </div>
                    <div class="row form-group">
                        <label class="col-sm-3 control-label">密码：</label>
                        <div class="col-sm-8" >
                            <input type="password" id="password"  name="password" maxlength="16" class="form-control required"/>
                        </div>

                    </div>

                    <div class="row form-group">
                        <label class="col-sm-3 control-label">确认：</label>
                        <div class="col-sm-8" >
                            <input type="password" id="password1" name="password1" maxlength="16" class="form-control required" />
                        </div>

                    </div>



                    <input type="radio" name="role" value="2"
                           checked="checked" />&nbsp;管理员&nbsp;&nbsp; <input type="radio" name="role"
                                                                      value="3" />&nbsp;超级管理员

                    <div class="inputArea">
                        <button type="submit" id="reg"  style="margin-top:10px;margin-left:85px;" class="button" value="同意协议并注册"/>
                    </div>
                    <div class="cl"></div>

                </form>
            </div>

        </div>



    </div>
</div>

</body>