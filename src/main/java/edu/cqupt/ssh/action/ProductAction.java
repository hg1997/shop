package edu.cqupt.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import edu.cqupt.ssh.domain.Product;
import edu.cqupt.ssh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by aa on 2017/8/7.
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
    @Autowired
    private ProductService productService;

    //模型驱动
    private Product product = new Product();
    public Product getModel() {
        return product;
    }

    public String show(){
        product = productService.findByPid(product.getPid());
        return "show";
    }
}
