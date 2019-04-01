package edu.cqupt.ssh.admin.service;

import edu.cqupt.ssh.admin.dao.AdminDao;
import edu.cqupt.ssh.admin.domain.AdminUser;
import edu.cqupt.ssh.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

/**
 * Created by aa on 2017/8/11.
 */
@Transactional
public class AdminService {
    @Autowired
    AdminDao adminDao;

    //登录用户校验
    public AdminUser checkUser(AdminUser user){
        user = adminDao.checkUser(user);
        return user;
    }

    //添加一级分类名
    public void add(String cname){
        adminDao.add(cname);
    }

    //后台删除一级分类
    public void delete(int cid){
        adminDao.delete(cid);
    }

    //后台修改一级分类
    public void update(Category category){
        adminDao.update(category);
    }
}
