package nanjingdaxue.denglu.service;

import nanjingdaxue.denglu.bean.admin;
import nanjingdaxue.denglu.bean.student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface adminService {
               //管理员登陆
             public admin queryadmin( String account,String password);
             //新建管理员
             public boolean insertadmin(admin admin);
             //创建学生
              public boolean insertStudent(student student);
              //预防重号
              public admin selectAdminName(String name);
              //获取所有管理员
              public List<admin> getAllAdmin();
              //更改管理员账户密码
              public Integer updateAdmin(admin admin);

}
