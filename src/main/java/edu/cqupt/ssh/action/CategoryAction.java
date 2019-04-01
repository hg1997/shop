package edu.cqupt.ssh.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import edu.cqupt.ssh.domain.PageBean;
import edu.cqupt.ssh.domain.Product;
import edu.cqupt.ssh.service.CategoryService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by aa on 2017/8/7.
 */
public class CategoryAction extends ActionSupport implements ModelDriven<PageBean>{
   @Autowired
   private CategoryService categoryService;

   //属性封装 一级分类编号
    private Integer cid;
    //属性封装 二级分类编号
    private Integer csid;

    public void setCid(Integer cid) {
        this.cid = cid;
    }
    public void setCsid(Integer csid) {
        this.csid = csid;
    }
    public Integer getCsid() {
        return csid;
    }

    //mycid
    private int myCid;
    public int getMyCid() {
        return myCid;
    }

    //模型驱动封装  当前页号
    private PageBean<Product> pageBean = new PageBean<Product>();
    public PageBean getModel() {
        return pageBean;
    }

    //显示一级分类的笼统的ProductList页面
    @Override
    public String execute() throws Exception {
        System.out.println("cid:"+cid);
        myCid = cid;
       pageBean = categoryService.findProductByCid(cid,pageBean);

        //将根据一级分类和当前page的分页查询结果保存到值栈
        ActionContext.getContext().getValueStack().set("pageBean",pageBean);
        ServletActionContext.getRequest().setAttribute("pageBean",pageBean);
        return "findByCid";
    }

    //显示一级分类下二级分类的ProductList页面
    public String findBycsid(){
        System.out.println("csid:"+csid);
        pageBean = categoryService.findProductByCsid(csid,pageBean);
        ActionContext.getContext().getValueStack().set("pageBean",pageBean);
        ServletActionContext.getRequest().setAttribute("pageBean",pageBean);
        return "findBycsid";
    }
}
