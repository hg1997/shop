package edu.cqupt.ssh.dao;

import edu.cqupt.ssh.domain.Order;
import edu.cqupt.ssh.domain.PageBean;
import edu.cqupt.ssh.domain.Product;
import edu.cqupt.ssh.utils.PageHibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by aa on 2017/8/9.
 */
public class OrderDao extends HibernateDaoSupport{

    //保存订单
    public void saveOrder(Order order){
        System.out.println("执行了保存订单。。。。。");
        this.getHibernateTemplate().save(order);
    }

    //查询用户的所有订单
    public PageBean<Order> getOrderList(int uid, int page){
        //创建PageBean
        PageBean<Order> pageBean =  new PageBean<Order>();
        pageBean.setPage(page);
        pageBean.setLimit(4);

         //获取列表的总记录数
        String hql = "select count(*) from Order o where o.user.uid = ?";
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql,uid);
        if(list.size()!=0){
            pageBean.setTotalRecord(list.get(0).intValue());
        }

        //分页查询一个pageBean里面的订单列表
        int limit = pageBean.getLimit();
         hql = "select o from Order o where o.user.uid = ?";
        List<Order> orderList = this.getHibernateTemplate().
                execute(new PageHibernateCallback<Order>(hql,new Object[]{uid},(pageBean.getPage()-1)*limit,limit));

        //将当前页查询到的订单列表添加到pageBean中
        pageBean.setList(orderList);

        //返回当前分页的pageBean
        return pageBean;
    }

    //点击付款跳转到对应的订单
    public Order findByOid(int oid){
        Order order = this.getHibernateTemplate().get(Order.class,oid);

        return order;
    }

}
