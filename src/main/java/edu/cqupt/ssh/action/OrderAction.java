package edu.cqupt.ssh.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import edu.cqupt.ssh.domain.*;
import edu.cqupt.ssh.service.OrderService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by aa on 2017/8/9.
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order>{
    @Autowired
    private OrderService orderService;

    //模型驱动
    Order order = new Order();
    public Order getModel() {
        return order;
    }

    //属性封装
    private int page;
    public void setPage(int page) {
        this.page = page;
    }

    /*保存订单*/
    public String saveOrder(){
        //为订单对象设置好内容
        order.setState(1);// 1:未付款   2:订单已经付款   3:已经发货   4:订单结束
        order.setOrdertime(new Date());//下单时间
        //添加本订单所属的用户
        User user  = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
        if(user == null){
            return "login";
        }else{
            System.out.println("user:"+user);
            order.setUser(user);
        }
        //获取购物车中信息添加到订单中
        Car car = (Car) ServletActionContext.getRequest().getSession().getAttribute("car");
        order.setTotal(car.getTotal());//总计
        //!!!!!!!!!!!!
        System.out.println("总价格："+car.getTotal());

        for(CarItem carItem:car.getLinkedHashMap().values()){
            OrderItem orderItem = new OrderItem();//创建订单项
            //将购物项目信息添加给订单项
            orderItem.setCount(carItem.getQuantity());
            orderItem.setSubtotal(carItem.getTotal());

            Product product = new Product();
            product.setImage(carItem.getImage());
            product.setPid(carItem.getPid());
            product.setPname(carItem.getPname());
            product.setShop_price(carItem.getShop_price());
            orderItem.setProduct(product);

            order.getOrderItems().add(orderItem);

            //!!!!!!!!!!!
            System.out.println("count:"+orderItem.getCount());
            System.out.println("小计:"+orderItem.getSubtotal());
            System.out.println("count:"+orderItem.getProduct().getPname());
        }

        orderService.saveOrder(order);
        System.out.println("订单项个数："+order.getOrderItems().size());
        //生成订单后清空购物车
        car.clearCar();
        //将订单保存到值栈中
       /* ActionContext.getContext().getValueStack().set("model",order);*/
        return "saveOrder";
    }

    //查询用户的所有订单
    public String orderList(){
        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
        //根据用户id和当前页查找订单列表
        PageBean<Order> pageBean = orderService.getOrderList(user.getUid(),page);
        //保存到值栈中
        ActionContext.getContext().getValueStack().set("pageBean",pageBean);

        //!!!!!
        System.out.println("查询到的订单列表数量："+pageBean.getList().size());
        return "orderList";
    }

    //点击付款跳转到对应的订单
    public String findByOid(){
        order = orderService.findByOid(order.getOid());

        return "findByOid";
    }

}
