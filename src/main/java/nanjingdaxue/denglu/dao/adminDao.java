package nanjingdaxue.denglu.dao;

import nanjingdaxue.denglu.bean.admin;
import nanjingdaxue.denglu.bean.student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//管理员类
@Mapper
public interface adminDao {
    //1,管理员登陆方法，主要比较用户账户及密码是否正确
    public admin queryadmin(@Param("Account")String Account,@Param("Password") String Password);
    //2,管理员注册账户
    public boolean insertadmin(admin admin);
    //3.管理员添加学生信息
    public boolean insertStudent(student student);
    // 获取管理员账户名称，防止创建重复管理员账户
          admin selectAdminName(String account);
          //获取所有管理员。
          public  List<admin> getAllAdmin();
          //更改管理员的账户和密码
         public Integer updateAdmin(admin admin);
}
