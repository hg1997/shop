package edu.cqupt.ssh.admin.dao;

import edu.cqupt.ssh.domain.Product;
import edu.cqupt.ssh.utils.PageHibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by aa on 2017/8/15.
 */
public class AdminProductDao extends HibernateDaoSupport{
    // 后台统计商品个数的方法
    public int findCount() {
        String hql = "select count(*) from Product";
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
        if(list != null && list.size() > 0){
            return list.get(0).intValue();
        }
        return 0;
    }

    // 根据商品ID查询商品
    public Product findByPid(Integer pid) {
        return this.getHibernateTemplate().get(Product.class, pid);
    }

    // 后台查询所有商品的方法
    public List<Product> findByPage(int begin, int limit) {
        String hql = "from Product order by pdate desc";
        List<Product> list =  this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, null, begin, limit));
        if(list != null && list.size() > 0){
            return list;
        }
        return null;
    }

    // DAO中的保存商品的方法
    public void save(Product product) {
        this.getHibernateTemplate().save(product);
    }

    // DAO中的删除商品的方法
    public void delete(Product product) {
        this.getHibernateTemplate().delete(product);
    }

    public void update(Product product) {
        this.getHibernateTemplate().update(product);
    }
}
