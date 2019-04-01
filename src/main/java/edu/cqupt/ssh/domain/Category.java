package edu.cqupt.ssh.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aa on 2017/8/7.
 */
public class Category {
    //一级目录的两个字段
    private Integer cid;  //主键
    private String cname;  //一级目录名

    //一个一级分类对应多个二级分类
    private Set<CategorySecond> categorySeconds = new HashSet<CategorySecond>();


    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", categorySeconds=" + categorySeconds +
                '}';
    }

    public Set<CategorySecond> getCategorySeconds() {
        return categorySeconds;
    }

    public void setCategorySeconds(Set<CategorySecond> categorySeconds) {

        this.categorySeconds = categorySeconds;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getCid() {

        return cid;
    }

    public String getCname() {
        return cname;
    }
}
