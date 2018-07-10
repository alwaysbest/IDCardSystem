<head>
    <meta charset="UTF-8" />
    <title>Title</title>
</head>
<body>
<div class="web_login">
    <form name="form2" accept-charset="utf-8"  action="/admin/addAdmin" method="post">
        <ul class="reg_form" id="reg-ul">
            <div id="userCue" class="cue">快速注册请注意格式</div>
            <li>
                <label   class="input-tips2">姓名：</label>
                <div class="inputOuter2">
                    <input type="text" id="name" name="name" maxlength="16" class="inputstyle2"/>
                </div>
            </li>
            <li>
                <label for="account"  class="input-tips2">账号：</label>
                <div class="inputOuter2">
                    <input type="text" id="account" name="account" maxlength="16" class="inputstyle2"/>
                </div>
            </li>
            <li>
                <label for="password" class="input-tips2">密码：</label>
                <div class="inputOuter2">
                    <input type="password" id="password"  name="password" maxlength="16" class="inputstyle2"/>
                </div>
            </li>
            <li>
                <label for="password2" class="input-tips2">确认密码：</label>
                <div class="inputOuter2">
                    <input type="password" id="password1" name="password1" maxlength="16" class="inputstyle2" />
                </div>
            </li>
        </ul>
        <input type="radio" name="role" value="2"
               checked="checked" />管理员&nbsp;&nbsp; <input type="radio" name="role"
                                                          value="3" />超级管理员

                <div class="inputArea">
                    <input type="submit" id="reg"  style="margin-top:10px;margin-left:85px;" class="button_blue" value="同意协议并注册"/> <a href="#" class="zcxy" target="_blank">注册协议</a>
                </div>
            <div class="cl"></div>

    </form>
</div>
</body>