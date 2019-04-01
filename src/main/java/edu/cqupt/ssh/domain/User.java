package edu.cqupt.ssh.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aa on 2017/8/5.
 */
public class User {

  private Integer uid;
  private String username;
  private String password;
  private String name;
  private String email;
  private String phone;
  private String addr;
  private int state;
  private String code;

  //一个用户对应多个订单
    private Set<Order> orders = new HashSet<Order>();

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Order> getOrders() {

        return orders;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", addr='" + addr + '\'' +
                ", state=" + state +
                ", code='" + code + '\'' +
                '}';
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getUid() {

        return uid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddr() {
        return addr;
    }

    public int getState() {
        return state;
    }

    public String getCode() {
        return code;
    }
}
