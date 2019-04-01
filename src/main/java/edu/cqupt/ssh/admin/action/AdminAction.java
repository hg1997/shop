package edu.cqupt.ssh.admin.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import edu.cqupt.ssh.admin.domain.AdminUser;
import edu.cqupt.ssh.admin.service.AdminService;
import edu.cqupt.ssh.domain.Category;
import edu.cqupt.ssh.service.CategoryService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by aa on 2017/8/11.
 */
public class AdminAction extends ActionSupport implements ModelDriven<AdminUser>{
    @Autowired
    private AdminService  adminService;

    @Autowired
    private CategoryService categoryService;

    //属性封装获取传递的添加的一级分类名
    private String cname;
    public void setCname(String cname) {
        this.cname = cname;
    }

    //属性封装获取传递的添加的一级分类名id
    private int cid;
    public void setCid(int cid) {
        this.cid = cid;
    }

    //模型驱动获取登录的后台用户
    private AdminUser adminUser = new AdminUser();
    public AdminUser getModel() {
        return adminUser;
    }

    //后台登陆验证
    public String login(){
        adminUser = adminService.checkUser(adminUser);
        if(adminUser == null){
            this.addActionError("账号或密码错误！");
            return "loginFail";
        } else{
            ServletActionContext.getRequest().getSession().setAttribute("adminUser",adminUser);
            return "loginSuccess";
        }
    }

    //后台显示所有的一级分类
    public String findAll(){
        List<Category> categoryList =  categoryService.findAll();
        ActionContext.getContext().getValueStack().set("categoryList",categoryList);

        return "showCategory";
    }

    //后台添加一级分类
    public String add(){
        adminService.add(cname);
        return "add";
    }

    //后台删除一级分类
    public String delete(){
        adminService.delete(cid);
        return "delete";
    }

    //后台修改一级分类
    public String edit(){
        Category category = categoryService.findByCid(cid);
        ActionContext.getContext().getValueStack().set("category",category);
        return  "edit";
    }
    public String update(){
        Category category = new Category();
        category.setCname(cname);
        category.setCid(cid);

        adminService.update(category);
        return "update";
    }


}
