package edu.cqupt.ssh.service;

import edu.cqupt.ssh.dao.CategoryDao;
import edu.cqupt.ssh.domain.Category;
import edu.cqupt.ssh.domain.PageBean;
import edu.cqupt.ssh.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by aa on 2017/8/7.
 */
@Transactional
public class CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    //查询所有一级目录
    public List<Category> findAll(){
         return categoryDao.findAll();
    }

    //根据一级分类cid分页显示商品
    public PageBean<Product> findProductByCid(int cid,PageBean<Product> pageBean){
        return categoryDao.findProductByCid(cid,pageBean);
    }
    //根据二级分类csid分页显示商品
    public PageBean<Product> findProductByCsid(int csid,PageBean<Product> pageBean){
        return categoryDao.findProductByCsid(csid,pageBean);
    }

    //根据一级分类的id查询一级分类
    public Category findByCid(int cid){
        return categoryDao.findByCid(cid);
    }

}
