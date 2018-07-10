package nanjingdaxue.denglu.controller;

import nanjingdaxue.denglu.bean.student;
import nanjingdaxue.denglu.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value ="/student")
public class studentController {
  @Autowired
   private studentService studentService;
    //用户登陆,from 表单提交返回到本方法中

    @RequestMapping("/stuLogin")
    public String stuLogin(){
        return "stuLogin";
    }


    @RequestMapping(value = "/queryStudent",method = RequestMethod.POST)
    public String queryStudent(HttpServletRequest request,Model model){
             // 获取前台用户输入的身份证号码
        String str="";
            String IdCard = request.getParameter("IdCard");
            // 获取录取号
            String enroll = request.getParameter("enroll");

        // HASH函数加密
             /* Integer idCard =IdCard.hashCode();
              Integer Enroll =enroll.hashCode();*/
        //调取service层登陆方法返回一个数据包
        student student=studentService.queryadmin(IdCard,enroll);
        List<student> list = new ArrayList<>();
        list.add(student);

        //判断是否存在学生

              if(student!=null){
                  //存在将学生放入session
                  request.getSession().setAttribute("student",student);
                  model.addAttribute("list",list);
                  str="stuIndex";
              }else{
                  str="stuLogin";
              }
        return str;
    }
      //

 }
