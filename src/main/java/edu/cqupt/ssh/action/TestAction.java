package edu.cqupt.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import edu.cqupt.ssh.domain.Category;

/**
 * Created by aa on 2017/8/8.
 */
public class TestAction extends ActionSupport implements ModelDriven{
    //属性封装
    private String name;
    public void setName(String name) {
        this.name = name;
    }

    //模型驱动
    private Category category = new Category();
    public Object getModel() {
        return category;
    }

    @Override
    public String execute() throws Exception {

        return "test";
    }


}
