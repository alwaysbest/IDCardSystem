package nanjingdaxue.denglu.FileUPload;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.UUID;

public class FileNameUtils {
    //获取文件名后缀
    public static String getSuffix(String filename){

        return filename.substring(filename.lastIndexOf("."));
    }

}
