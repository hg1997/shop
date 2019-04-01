package edu.cqupt.ssh.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by aa on 2017/8/7.
 */
public class Product {
    private Integer pid;
    private String pname;
    private Double market_price;
    private Double shop_price;
    private String image;
    private String pdesc;
    private Integer is_hot;
    private Date pdate;

    // 二级分类的外键:使用二级分类的对象.
    private CategorySecond categorySecond;

    //一个商品对应多个订单项
    private Set<OrderItem>  orderItems = new HashSet<OrderItem>();

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Set<OrderItem> getOrderItems() {

        return orderItems;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", market_price=" + market_price +
                ", shop_price=" + shop_price +
                ", image='" + image + '\'' +
                ", pdesc='" + pdesc + '\'' +
                ", is_hot=" + is_hot +
                ", pdate=" + pdate +
                ", categorySecond=" + categorySecond +
                '}';
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setMarket_price(Double market_price) {
        this.market_price = market_price;
    }

    public void setShop_price(Double shop_price) {
        this.shop_price = shop_price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public void setIs_hot(Integer is_hot) {
        this.is_hot = is_hot;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public void setCategorySecond(CategorySecond categorySecond) {
        this.categorySecond = categorySecond;
    }

    public Integer getPid() {

        return pid;
    }

    public String getPname() {
        return pname;
    }

    public Double getMarket_price() {
        return market_price;
    }

    public Double getShop_price() {
        return shop_price;
    }

    public String getImage() {
        return image;
    }

    public String getPdesc() {
        return pdesc;
    }

    public Integer getIs_hot() {
        return is_hot;
    }

    public Date getPdate() {
        return pdate;
    }

    public CategorySecond getCategorySecond() {
        return categorySecond;
    }
}
