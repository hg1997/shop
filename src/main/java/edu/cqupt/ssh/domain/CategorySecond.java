package edu.cqupt.ssh.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aa on 2017/8/7.
 */
public class CategorySecond {
    //二级分类的内容 （自身）
    private Integer csid;
    private String csname;

    // 所属一级分类.存的是一级分类的对象.（前）
    private Category category;

    //该二级分类对应的该类产品
    private Set<Product> productSet = new HashSet<Product>();

    @Override
    public String toString() {
        return "CategorySecond{" +
                "csid=" + csid +
                ", csname='" + csname + '\'' +
                ", category=" + category +
                ", productSet=" + productSet +
                '}';
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    public void setCsname(String csname) {
        this.csname = csname;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }

    public Integer getCsid() {

        return csid;
    }

    public String getCsname() {
        return csname;
    }

    public Category getCategory() {
        return category;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }
}
