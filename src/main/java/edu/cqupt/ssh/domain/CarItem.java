package edu.cqupt.ssh.domain;

/**
 * Created by aa on 2017/8/8.
 */
public class CarItem {
    private int pid;
    private String image;
    private String pname;
    private double shop_price;
    private int quantity;
    private double total;

    //============================


    @Override
    public String toString() {
        return "CarItem{" +
                "pid=" + pid +
                ", image='" + image + '\'' +
                ", pname='" + pname + '\'' +
                ", shop_price=" + shop_price +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {

        this.pid = pid;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setShop_price(double shop_price) {
        this.shop_price = shop_price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getImage() {

        return image;
    }

    public String getPname() {
        return pname;
    }

    public double getShop_price() {
        return shop_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return quantity*shop_price;
    }
}
