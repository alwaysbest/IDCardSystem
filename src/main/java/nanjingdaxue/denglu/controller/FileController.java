package nanjingdaxue.denglu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

//测试多图片上传，及图片上传
@Controller
public class FileController {
    private  static  final Logger loggin =LoggerFactory.getLogger(FileController.class);
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name",required = false,defaultValue = "world")String name,Model model){
                 model.addAttribute("name",name);
        return "greeting";
    }
    //文件上传相关代码<!--两个注解一个是地址，一个是转Json
    @RequestMapping(value = "upload")
    @ResponseBody
    public String upload(@RequestParam("test")MultipartFile file){
        //判断是否为空
              if(file.isEmpty()){
                  return "文件为空";
              }
              //获取文件名称 不建议用 file.getName
            String filename  =file.getOriginalFilename();
              loggin.info("获取上传文件名"+filename);
        // 获取文件的后缀名
             String  type =filename.substring(filename.lastIndexOf("."));

             loggin.info("目前格式为==============>"+type.toString().trim());
             if(type.equals(".JPG")||type.equals("PNG")){
                 //图片上传成功后路径
                 String filePath = "E://test//";
                 // 解决中文问题，liunx下中文路径，图片显示问题 暂时未接触liunx 写上ing
                 // fileName = UUID.randomUUID() + suffixName;
                 File dest= new File(filePath+filename);
                 //检查是否存在目录先获取文件目录。在查询是否存在
                 if (!dest.getParentFile().exists()){
                     //创建目录
                      dest.getParentFile().mkdirs();
                 }
                  try {
                         //上传图片
                        file.transferTo(dest);

                  }catch (IllegalStateException e){
                      e.printStackTrace();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
             }else {
                 return "上传格式不为JPG或者PNG因此无法上传";
             }
              return "index";
    }

    //多文件上传
    @RequestMapping(value = "/batch/upload", method = RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        String filePath = "E://test//";
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(
                            new File(filePath+file.getOriginalFilename())));
                   String F =file.getOriginalFilename();
                     loggin.info("传入的位置"+F);
                    stream.write(bytes);

                    stream.close();

                } catch (Exception e) {
                    stream = null;
                    return "You failed to upload " + i + " => "
                            + e.getMessage();
                }
            } else {
                return "You failed to upload " + i
                        + " because the file was empty.";
            }
        }
        return "upload successful";
    }
    // 文件下载
    //文件下载相关代码
    @RequestMapping(value = "/downloadImage",method = RequestMethod.GET)
    public String downloadImage(String imageName,HttpServletRequest request, HttpServletResponse response) {
        //String fileName = "123.JPG";
        String filePath = "/Users/liuyin/Downloads/image";
        loggin.debug("the imageName is : "+imageName);
        String fileUrl = filePath+imageName;
        if (fileUrl != null) {
            //当前是从该工程的WEB-INF//File//下获取文件(该目录可以在下面一行代码配置)然后下载到C:\\users\\downloads即本机的默认下载的目录
           /* String realPath = request.getServletContext().getRealPath(
                    "//WEB-INF//");*/
            /*File file = new File(realPath, fileName);*/
            File file = new File(fileUrl);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition",
                        "attachment;fileName=" + imageName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }





}
