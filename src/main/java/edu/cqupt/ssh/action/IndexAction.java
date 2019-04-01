package edu.cqupt.ssh.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import edu.cqupt.ssh.domain.Category;
import edu.cqupt.ssh.domain.Product;
import edu.cqupt.ssh.service.CategoryService;
import edu.cqupt.ssh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by aa on 2017/8/7.
 */
public class IndexAction extends ActionSupport{
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;


    //主页跳转
    @Override
    public String execute() throws Exception {
        //访问主页时就显示所有的一级分类
        List<Category> clist  = categoryService.findAll();
        ActionContext.getContext().getSession().put("clist",clist);

        //访问主页时就显示热门商品
        List<Product> hotList = productService.findHot();
        for(Product p:hotList)
            System.out.println(p.getImage());
        //>>>>保存到值栈中
        ActionContext.getContext().getValueStack().set("hotList",hotList);

        //访问主页时就显示最新商品
        List<Product> newList = productService.findNew();
        //>>>>保存到值栈中
        ActionContext.getContext().getValueStack().set("newList",newList);
        return "index";
    }


}
