package nanjingdaxue.denglu.controller;

import nanjingdaxue.denglu.bean.admin;
import nanjingdaxue.denglu.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin")
public class adminController {
    @Autowired
private adminService adminService;


    //登录页面
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/addqueryadmin")
    //用户登陆
    public String queryadmin(HttpServletRequest request)throws Exception{

                          String account = request.getParameter("account");
                          String password = request.getParameter("password");

           admin admin = adminService.queryadmin(account, password);
           String res ="";
           if(admin!=null){
                   request.getSession().setAttribute("admin",admin);
                   res="/index";

           }else {
               System.out.print("用户可能账户或者密码输入错误，也有可能不存在账户！！！");
                 res="/xnjyl";

           }
           System.out.print("res:"+res);
           return  res;

    }

    @RequestMapping("/adminsave1")
    public String saveadmin1(){
        return "adminsave1";
    }

     //添加管理员
    @RequestMapping(value = "/addAdmin",method = RequestMethod.POST)
    public Object saveAdmin(HttpServletRequest request,admin admin)throws Exception{
        admin  ad = new admin();
            String  name = request.getParameter("name");
            String  account =request.getParameter("account");
              ad = adminService.selectAdminName(account);
            if(ad!=null){
                    System.out.print("存在重复的账户");
            }else {

                String password = request.getParameter("password");
                String password1 = request.getParameter("password1");
                String Role = request.getParameter("role");

                if (password.equals(password1)) {
                    admin admin1 = new admin();
                    admin1.setAccount(account);
                    admin1.setName(name);
                    admin1.setPassword(password);
                    admin1.setRole(Role);
                    adminService.insertadmin(admin1);
                } else {
                    System.out.print("密码输入错误！····");
                }
            }
        return "index" ;
    }
    // 获取所有管理员
    @RequestMapping(value = "/allAdmin",method = RequestMethod.GET)
    public  Object getAllAdmin(){
        Map<String,Object> map = new HashMap<>();
        List<admin> admins = new ArrayList<>();
                 admins=adminService.getAllAdmin();
                 if(admins!=null) {
                     map.put("admins", admins);
                     map.put("success", true);
                 }else {
                     map.put("admins","暂无数据请添加信息");
                 }
        return map;
    }

    // 管理员修改账户或者密码
    @RequestMapping(value = "/updateAdmin/{id}",method = RequestMethod.POST)
    public void updateAdmin(HttpServletRequest request, @PathVariable("id") Integer Id, @RequestParam("account")
            String account,@RequestParam("password")String password) {
                      try {
                          admin admin = new admin();

                       admin.setId(Id);
                       admin.setAccount(account);
                       admin.setPassword(password);
                      admin ad = new admin();
                      ad =adminService.selectAdminName(account);
                      if(ad==null){
                          Integer ab = 0;
                          ab= adminService.updateAdmin(admin);
                          if (ab!=0){
                              System.out.print("修改管理员成功");
                          }
                      }else{
                          System.out.print("存在相同数据账户名数据，无法更改");
                      }

                      }catch (Exception e){

                      }
    }

}
