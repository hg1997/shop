package edu.cqupt.ssh.dao;

import edu.cqupt.ssh.domain.Category;
import edu.cqupt.ssh.domain.CategorySecond;
import edu.cqupt.ssh.domain.PageBean;
import edu.cqupt.ssh.domain.Product;
import edu.cqupt.ssh.utils.PageHibernateCallback;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by aa on 2017/8/7.
 */
public class CategoryDao extends HibernateDaoSupport{

    //查询所有一级目录
    public List<Category> findAll(){
        String hql = "from Category";
        List<Category> list = (List<Category>) this.getHibernateTemplate().find(hql);
        return list;
    }

    //根据一级分类的cid查询一级分类
    public Category findByCid(int cid){
        return this.getHibernateTemplate().get(Category.class,cid);
    }

    //根据一级目录id查找一级目录对应的商品
    public PageBean<Product> findProductByCid(int cid,PageBean<Product> pageBean){

        pageBean.setLimit(12); //设置每页显示12个商品

        //根据一级分类查询所有一级分类的商品的总数
        String hql = "select count(*) from Product p where p.categorySecond.category.cid = ?";
        //返回的是list，因为可能存在多个聚合函数，聚合函数的返回值是long
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql,cid);
        if(list.size()!=0){
            pageBean.setTotalRecord(list.get(0).intValue()); //使用了一个聚合函数，使用get(0)，并转换为int值
            System.out.println("查询到的总的记录数："+pageBean.getTotalRecord());
        }

        //根据一级分类和起始页分页查询显示数据
        hql = "select p from Product p where p.categorySecond.category.cid = ?";
        int limit = pageBean.getLimit();
        List<Product> productList = this.getHibernateTemplate().
                execute(new PageHibernateCallback<Product>(hql,new Object[]{cid},(pageBean.getPage()-1)*limit,limit));

        //返回
        System.out.println("根据一级分类查总的页数："+pageBean.getTotalPage());
        pageBean.setList(productList);
        return pageBean;
    }

    //根据二级目录id查找一级目录对应的商品
    public PageBean<Product> findProductByCsid(int csid,PageBean<Product> pageBean){

        pageBean.setLimit(12); //设置每页显示12个商品

        //根据二级分类查询商品的总数
        String hql = "select count(*) from Product p where p.categorySecond.csid = ?";
        //返回的是list，因为可能存在多个聚合函数，，聚合函数的返回值是long
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql,csid);
        if(list.size()!=0){
            pageBean.setTotalRecord(list.get(0).intValue()); //使用了一个聚合函数，使用get(0)，并转换为int值
        }

        //根据二级分类和起始页分页查询显示数据
        hql = "select p from Product p where p.categorySecond.csid = ?";
        int limit = pageBean.getLimit();
        List<Product> productList = this.getHibernateTemplate().
                execute(new PageHibernateCallback<Product>(hql,new Object[]{csid},(pageBean.getPage()-1)*limit,limit));

        //返回
        System.out.println("根据二级分类查总的页数："+pageBean.getTotalPage());
        pageBean.setList(productList);
        return pageBean;
    }
}
