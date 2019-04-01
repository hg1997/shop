package edu.cqupt.ssh.dao;


import edu.cqupt.ssh.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by aa on 2017/8/5.
 */

public class UserDao extends HibernateDaoSupport{


    //查询用户名是否存在
    public boolean isExist(String name){
        String hql = "from User where username = ?";
        List<User> list = (List<User>) this.getHibernateTemplate().find(hql,name);
        if(list.size()!=0)
            return true;
        else
            return false;
    }

    //添加注册的用户
    public void add(User user){
        this.getHibernateTemplate().save(user);
    }

    //修改用户信息
    public void update(User user){
        this.getHibernateTemplate().update(user);
    }

    //根据激活码查询激活
    public List<User> findByCode(String code){
        String hql = "from User where code = ?";
        List<User> list = (List<User>) this.getHibernateTemplate().find(hql,code);
        return list;
    }

    //登录
    public List<User> login(User user){
        String username = user.getUsername();
        String password = user.getPassword();
        String hql = "from User where username = ? and password = ?";
        List<User> list = (List<User>) this.getHibernateTemplate().find(hql,username,password);

        //查看登录的用户
        System.out.println("登录的用户："+list);
        return list;
    }
}
