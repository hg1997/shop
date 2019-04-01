package edu.cqupt.ssh.admin.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import edu.cqupt.ssh.admin.service.AdminCategorySecondService;
import edu.cqupt.ssh.domain.Category;
import edu.cqupt.ssh.domain.CategorySecond;
import edu.cqupt.ssh.domain.PageBean;
import edu.cqupt.ssh.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by aa on 2017/8/15.
 */
public class AdminCategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond>{
    //模型驱动
    private CategorySecond  categorySecond = new CategorySecond();
    public CategorySecond getModel() {
        return categorySecond;
    }

    //属性封装page
    private Integer page;
    public void setPage(Integer page) {
        this.page = page;
    }

    //业务层
    @Autowired  //二级分类的Service
    private AdminCategorySecondService secondService;
    @Autowired //一级分类的Service
    private CategoryService categoryService;


    // 带有分页的查询所有二级分类的操作:
    public String findAll() {
        PageBean<CategorySecond> pageBean = secondService.findByPage(page);
        ActionContext.getContext().getValueStack().set("pageBean", pageBean);
        return "findAll";
    }

    // 跳转到添加页面的方法:
    public String addPage() {
        List<Category> cList = categoryService.findAll();
        ActionContext.getContext().getValueStack().set("cList", cList);
        return "addPage";
    }

    // 添加二级分类的方法:
    public String save() {
        secondService.save(categorySecond);
        return "saveSuccess";
    }

    //===============================================

    // 删除二级分类的方法:
    public String delete() {
        secondService.delete(categorySecond);
        return "deleteSuccess";
    }

    // 编辑二级分类的方法:
    public String edit() {
        // 根据id查询二级分类:
        categorySecond = secondService.findByCsid(categorySecond
                .getCsid());
        // 查询所有一级分类:
        List<Category> cList = categoryService.findAll();
        // 将集合存入到值栈中.
        ActionContext.getContext().getValueStack().set("cList", cList);
        // 页面跳转:
        return "editSuccess";
    }

    // 修改二级分类的方法:
    public String update(){
        secondService.update(categorySecond);
        return "updateSuccess";
    }

}
