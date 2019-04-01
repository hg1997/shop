package edu.cqupt.ssh.admin.service;

import edu.cqupt.ssh.admin.dao.AdminProductDao;
import edu.cqupt.ssh.domain.PageBean;
import edu.cqupt.ssh.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by aa on 2017/8/15.
 */
@Transactional
public class AdminProductService {
    @Autowired
    private AdminProductDao productDao;

    // 根据商品ID查询商品
    public Product findByPid(Integer pid) {
        return productDao.findByPid(pid);
    }

    // 后台查询所有商品带分页
    public PageBean<Product> findByPage(Integer page) {
        PageBean<Product> pageBean = new PageBean<Product>();
        // 设置当前页数:
        pageBean.setPage(page);
        // 设置每页显示记录数:
        int limit = 10;
        pageBean.setLimit(limit);

        // 设置总记录数:
        int totalCount = 0;
        totalCount = productDao.findCount();
        pageBean.setTotalRecord(totalCount);

        // 每页显示的数据集合:
        // 从哪开始:
        int begin = (page - 1) * limit;
        List<Product> list = productDao.findByPage(begin, limit);
        pageBean.setList(list);
        return pageBean;
    }

    // 业务层保存商品方法:
    public void save(Product product) {
        productDao.save(product);
    }

    // 业务层删除商品
    public void delete(Product product) {
        productDao.delete(product);
    }

    // 业务层修改商品的方法
    public void update(Product product) {
        productDao.update(product);
    }
}
