package nanjingdaxue.denglu.controller;

import nanjingdaxue.denglu.FileUPload.FileNameUtils;
import nanjingdaxue.denglu.FileUPload.FileUtils;
import nanjingdaxue.denglu.bean.student;
import nanjingdaxue.denglu.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
@Controller
public class TestController {
    private final ResourceLoader resourceLoader;
    @Autowired
    private adminService adminService;
    @Autowired
    public TestController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
   //获取上传路径
 @Value("${web.upload-path}")
  private String path;
//跳转到文件上传页面
    @RequestMapping("test")
    public String toUpload(){
        return "test";
    }
    //file 要上传的文件//管理员上传学生资料ing。
    @RequestMapping(value = "fileUpload")
    public String upload(@RequestParam("fileName")MultipartFile file, Map<String,Object> map, HttpServletRequest request){
        // 要上传的目标文件存放路径
        //获取学生姓名
        String names   =file.getOriginalFilename();
        String type=FileNameUtils.getSuffix(names);
        if(type=="JPG"||type=="PNG"){
       String studentName  =request.getParameter("studentName");
       //获取学生身份证
            String idCard  =request.getParameter("studentIdCard");
            //获取学生录取号码
            String enroll =request.getParameter("studentEnroll");
            //身份证及录取号码都需要hashCode 加密
               String studentIdCard    =Integer.toString(idCard.hashCode());
               String studentEnroll= Integer.toString(enroll.hashCode());
               //学生所属院系
               String department=request.getParameter("studentDepartment");
        String localPath = "E:/intellij/nanjingdaxue/src/main/resources/image/";
        // 上传成功或者失败的提示
        String msg = "";
        if (FileUtils.upload(file, localPath, file.getOriginalFilename())){
            // 上传成功，给出页面提示
            msg = "上传成功！";
        }else {
            msg = "上传失败！";

        }
          // 显示图片
          map.put("msg", msg);
        map.put("fileName", file.getOriginalFilename());
        //图片名称



             String image  =localPath+names;
             //创建 学生类添加学生
             student student = new student();
             //获取前端数据放入姓名，录取号，身份证，院系，照片。
             student.setName(studentName);
             student.setEnroll(studentEnroll);
             student.setIdCard(studentIdCard);
             student.setDepartment(department);
             student.setImage(image);
             adminService.insertStudent(student);
         }else {
             return "上传的图片并非JPG或PNG格式，请更换后重新尝试！";
         }

        return "forward:/test";
    }
    @RequestMapping("show")
    public ResponseEntity showPhotos(String fileName){

        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            return ResponseEntity.ok(resourceLoader.getResource("file:" + path + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
         // 学生更换头像
    @RequestMapping(value = "updateStudentImage",method = RequestMethod.POST)
    public String updateStudentImage(@RequestParam("fileNames")MultipartFile file, Map<String,Object> map, HttpServletRequest request){
        String names   =file.getOriginalFilename();
        String msg="";
        String msg1="";
        String type=FileNameUtils.getSuffix(names);
            if(type.equals(".JPG")||type.equals("PNG")){
                String localPath = "E:/intellij/nanjingdaxue/src/main/resources/image/";
                // 上传成功或者失败的提示

                if (FileUtils.upload(file, localPath, file.getOriginalFilename())){
                    // 上传成功，给出页面提示
                    msg = "上传成功！";
                }else {
                    msg = "上传失败！";

                }
                // 显示图片
                map.put("msg", msg);
                map.put("fileName", file.getOriginalFilename());
                //图片名称


            }else{
                      msg1="上传格式非JPG或者PNG格式，请修改个时候再次上传";
            }
        return "StudentImage";
    }


               // 学生登陆可以看到自己的图片信息
    @RequestMapping("studentshow")
    public ResponseEntity showStudentPhotos(String fileName){

        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            return ResponseEntity.ok(resourceLoader.getResource("file:"+ fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
