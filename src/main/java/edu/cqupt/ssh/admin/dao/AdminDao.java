package edu.cqupt.ssh.admin.dao;

import edu.cqupt.ssh.admin.domain.AdminUser;
import edu.cqupt.ssh.domain.Category;
import edu.cqupt.ssh.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by aa on 2017/8/11.
 */
public class AdminDao extends HibernateDaoSupport {
    //用户登录校验
    public AdminUser checkUser(AdminUser user) {
        String hql = "from AdminUser where username = ?  and password = ?";
        List<AdminUser> list = (List<AdminUser>) this.getHibernateTemplate().
                find(hql,user.getUsername(),user.getPassword());
        if(list.size()!=0)
            return list.get(0);
        else
            return null;
    }

    //添加一级分类名
    public void add(String cname){
        Category category = new Category();
        category.setCname(cname);

        this.getHibernateTemplate().save(category);
    }

    //后台删除一级分类
    public void delete(int cid){
        Category category = new Category();
        category.setCid(cid);
        this.getHibernateTemplate().delete(category);
    }

    //后台修改一级分类
    public void update(Category category){
        this.getHibernateTemplate().update(category);
    }
}
