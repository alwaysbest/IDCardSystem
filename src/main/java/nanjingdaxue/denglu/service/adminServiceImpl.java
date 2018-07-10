package nanjingdaxue.denglu.service;

import nanjingdaxue.denglu.bean.admin;
import nanjingdaxue.denglu.bean.student;
import nanjingdaxue.denglu.dao.adminDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class adminServiceImpl implements  adminService {
    @Autowired
    private adminDao adminDao;

    /**
     *
     * @param account
     * @param password
     * 管理员登陆
     * @return
     */
    @Override
    public admin queryadmin(String account, String password) {
         admin admin = new admin();
               admin=adminDao.queryadmin(account,password);
        return admin;
    }

    /**
     *
     * @param admin
     * @return
     * 新增管理员
     */

    @Override
    public boolean insertadmin(admin admin) {

        return  adminDao.insertadmin(admin);
    }

    /**
     *
     * @param student
     * 新增学生
     * @return
     */
    @Override
    public boolean insertStudent(student student) {
        return adminDao.insertStudent(student);
    }

    /**
     * 添加管理员的时候，不能有重复账户
     * @param name
     * @return
     */

    @Override
    public admin selectAdminName(String name) {
        return adminDao.selectAdminName( name);
    }

    @Override
    public List<admin> getAllAdmin() {
        return adminDao.getAllAdmin();
    }

    @Override
    public Integer updateAdmin(admin admin) {
        return adminDao.updateAdmin(admin);
    }
}
