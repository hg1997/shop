package edu.cqupt.ssh.domain;

import java.util.LinkedHashMap;

/**
 * Created by aa on 2017/8/9.
 */
public class Car {
    private LinkedHashMap<Integer,CarItem> linkedHashMap = new LinkedHashMap<Integer, CarItem>();
    private double total;


    public LinkedHashMap<Integer, CarItem> getLinkedHashMap() {
        return linkedHashMap;
    }

    public double getTotal() {
        return total;
    }

    public void setLinkedHashMap(LinkedHashMap<Integer, CarItem> linkedHashMap) {

        this.linkedHashMap = linkedHashMap;
    }

    /*public void setTotal(double total) {
        this.total = total;
    }
*/
    //===============================
    //添加商品到购物车
    public void addCarItem(CarItem carItem){
        boolean flag = linkedHashMap.containsKey(carItem.getPid());
        total += carItem.getTotal();
        if(flag){//如果商品存在在购物车里，数量增加
            CarItem existItem = linkedHashMap.get(carItem.getPid());
            int totalCount = existItem.getQuantity()+carItem.getQuantity();
            existItem.setQuantity(totalCount);
        }else{//如果不存在在购物车里
            linkedHashMap.put(carItem.getPid(),carItem);
        }
    }
    //移除购物车里的某件商品
    public void removeProduct(int pid){
        CarItem carItem = linkedHashMap.remove(pid);
        total -= carItem.getTotal();
    }

    //清空购物车
    public void clearCar(){
        linkedHashMap.clear();
        total = 0;
    }
}
