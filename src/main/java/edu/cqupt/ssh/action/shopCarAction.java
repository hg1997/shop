package edu.cqupt.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import edu.cqupt.ssh.domain.Car;
import edu.cqupt.ssh.domain.CarItem;
import org.apache.struts2.ServletActionContext;

/**
 * Created by aa on 2017/8/9.
 */
public class shopCarAction extends ActionSupport implements ModelDriven<CarItem> {
    //模型驱动
    private CarItem carItem = new CarItem();
    public CarItem getModel() {
        return carItem;
    }

    //添加到购物车
     public String saveProduct(){
        System.out.println("执行了saveProduct。。。。。。");
        //先判断一下购物车是否存在在session中
         Car car = (Car) ServletActionContext.getRequest().getSession().getAttribute("car");
         if(car == null){//如果是第一次，将购物车放进session域中
              car = new Car();
              car.addCarItem(carItem);
             ServletActionContext.getRequest().getSession().setAttribute("car",car);
         }else{
             car.addCarItem(carItem);
         }

         System.out.println("查看购物车的信息："+car.getLinkedHashMap().keySet());
        return "saveProduct";
    }

    //删除购物车里某件商品
    public String removeProduct(){
        Car car = (Car) ServletActionContext.getRequest().getSession().getAttribute("car");
        car.removeProduct(carItem.getPid());

        return "removeProduct";
    }

    //清空购物车
    public String clearCar(){
        Car car = (Car) ServletActionContext.getRequest().getSession().getAttribute("car");
        car.clearCar();

        return "clearCar";
    }

    //点击header的购物车跳转到购物车页面
    public String toCar(){
        return "toCar";
    }




}
