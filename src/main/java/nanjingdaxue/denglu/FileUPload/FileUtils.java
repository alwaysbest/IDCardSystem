package nanjingdaxue.denglu.FileUPload;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

//文件上传类
public class FileUtils {

    public  static boolean upload(MultipartFile file,String path,String fileName){
        //使用原文件名
        String realPath = path + "/" + fileName;
        //先建文件路径
        File dest = new File(realPath);
        //判断文件父目录是否存在
        if(dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest);
            return true;
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }
}
