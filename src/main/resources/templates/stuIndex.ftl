<h1>学生登陆成功页面</h1>
<table>
    <thead><tr>
        <td>用户名</td>
        <td>录取号码</td>
        <td>院系</td>
        <td>照片</td>
    </tr></thead>
     <#list list as student>
         <tr><td>${student.name}</td></tr>
      <tr><td>${student.enroll}</td></tr>
      <tr><td>${student.department}</td></tr>

<tr><td>
<img src="/studentshow?fileName=${student.image}" style="width: 200px"/></td></tr>
<tr><td>
<img src="/studentshow?fileName=${student.image}" style="width: 100px"/></td></tr>


     </#list>
</table>