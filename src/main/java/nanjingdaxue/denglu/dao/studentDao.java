package nanjingdaxue.denglu.dao;

import nanjingdaxue.denglu.bean.student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface studentDao {
     //学生登陆
    public student querystudent(@Param("IdCard") String IdCard,@Param("enroll") String enroll);
}
