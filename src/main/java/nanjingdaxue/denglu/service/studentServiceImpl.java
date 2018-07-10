package nanjingdaxue.denglu.service;

import nanjingdaxue.denglu.bean.student;
import nanjingdaxue.denglu.dao.studentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class studentServiceImpl implements studentService {
    @Autowired
    private studentDao studentDao;
    @Override
     public student queryadmin(String IdCard, String enroll) {
           student student   = studentDao.querystudent(IdCard, enroll);
        return student;
    }
}
