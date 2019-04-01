package edu.cqupt.ssh.domain;

/**
 * Created by aa on 2017/8/9.
 */
public class OrderItem {
    private Integer itemid;
    private Integer count;
    private Double subtotal;
    // 商品外键:对象
    private Product product;
    // 订单外键:对象
    private Order order;

    /*============================*/

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getItemid() {

        return itemid;
    }

    public Integer getCount() {
        return count;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public Product getProduct() {
        return product;
    }

    public Order getOrder() {
        return order;
    }
}
