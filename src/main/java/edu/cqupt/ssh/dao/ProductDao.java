package edu.cqupt.ssh.dao;


import edu.cqupt.ssh.domain.Product;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by aa on 2017/8/5.
 */

public class ProductDao extends HibernateDaoSupport {

    //查找最火的商品
    public List<Product> findHot(){
      //离线查询
        DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
        //添加查询条件
        criteria.add(Restrictions.eq("is_hot",1));
        criteria.addOrder(Order.asc("shop_price"));
        List<Product> productList = (List<Product>) this.getHibernateTemplate().findByCriteria(criteria,0,10);
        //返回查询结果
        return productList;
    }


    //查找最新的商品
    public List<Product> findNew(){
        //离线查询
        DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
        //添加查询条件
        criteria.addOrder(Order.desc("pdate"));
        List<Product> productList = (List<Product>) this.getHibernateTemplate().findByCriteria(criteria,0,10);
        //返回查询结果
        return productList;
    }

    //按照商品id查找商品
    public Product findByPid(int pid){
        Product product = this.getHibernateTemplate().get(Product.class,pid);
        return product;
    }

}
