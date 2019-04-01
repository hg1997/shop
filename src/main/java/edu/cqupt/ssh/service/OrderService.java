package edu.cqupt.ssh.service;

import edu.cqupt.ssh.dao.OrderDao;
import edu.cqupt.ssh.domain.Order;
import edu.cqupt.ssh.domain.PageBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

/**
 * Created by aa on 2017/8/9.
 */
@Transactional
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    //保存订单
    public void saveOrder(Order order){
        orderDao.saveOrder(order);
    }

    //查询用户的所有订单
    public PageBean<Order> getOrderList(int uid, int page){
        return orderDao.getOrderList( uid, page);
    }

    //点击付款跳转到对应的订单
    public Order findByOid(int oid){
       Order order =  orderDao.findByOid(oid);

        return order;
    }

}
