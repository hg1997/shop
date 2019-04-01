package edu.cqupt.ssh.admin.service;

import edu.cqupt.ssh.admin.dao.AdminCategorySecondDao;
import edu.cqupt.ssh.domain.CategorySecond;
import edu.cqupt.ssh.domain.PageBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by aa on 2017/8/15.
 */
@Transactional
public class AdminCategorySecondService {
    @Autowired
    private AdminCategorySecondDao secondDao;

    // 二级分类带有分页的查询操作:
    public PageBean<CategorySecond> findByPage(Integer page) {
        PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>();
        // 设置参数:
        pageBean.setPage(page);
        // 设置每页显示记录数:
        int limit = 10;
        pageBean.setLimit(limit);
        // 设置总记录数:
        int totalCount = secondDao.findCount();
        pageBean.setTotalRecord(totalCount);

        // 设置页面显示数据的集合:
        int begin = (page - 1) * limit;
        List<CategorySecond> list = secondDao.findByPage(begin,limit);
        pageBean.setList(list);
        return pageBean;
    }

    // 业务层的保存二级分类的操作
    public void save(CategorySecond categorySecond) {
        secondDao.save(categorySecond);
    }

    //.=========================

    // 业务层的删除二级分类的操作
    public void delete(CategorySecond categorySecond) {
        secondDao.delete(categorySecond);
    }

    // 业务层根据id查询二级分类
    public CategorySecond findByCsid(Integer csid) {
        return secondDao.findByCsid(csid);
    }

    // 业务层修改二级分类的方法
    public void update(CategorySecond categorySecond) {
        secondDao.update(categorySecond);
    }

    // 业务层查询所有二级分类(不带分页)
    public List<CategorySecond> findAll() {
        return secondDao.findAll();
    }

}
