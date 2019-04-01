package edu.cqupt.ssh.service;

import edu.cqupt.ssh.dao.ProductDao;
import edu.cqupt.ssh.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by aa on 2017/8/5.
 */
@Transactional
public class ProductService {
    @Autowired
    private ProductDao productDao;

    //查找最火商品
    public List<Product> findHot(){
       return productDao.findHot();
    }

    //查找最新商品
    public List<Product> findNew(){
        return productDao.findNew();
    }

    //按商品id查找商品
    public Product findByPid(int pid){
        return productDao.findByPid(pid);
    }

}
