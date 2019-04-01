package edu.cqupt.ssh.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;

import java.util.List;

/**
 * Created by aa on 2017/8/8.
 */
public class PageHibernateCallback<T> implements HibernateCallback<List<T>>{
    //select p from Product p where p.categorySecond.category.cid = ?

    //hql语句 + 参数
    private String hql;
    private Object[] parms;
    //分页【起始数据】和【每页数据】
    private int start;
    private int limit;

    //构造方法
    public PageHibernateCallback(String hql, Object[] parms, int start, int limit) {
        this.hql = hql;
        this.parms = parms;
        this.start = start;
        this.limit = limit;
    }

    //复写接口里面的方法
    public List<T> doInHibernate(Session session) throws HibernateException {
        //创建query
        Query query = session.createQuery(hql);

        //添加参数
        if(parms!=null){
            for(int x=0;x<parms.length;x++) {
                query.setParameter(x,parms[x]);
            }
        }

        //添加分页的限制
        query.setFirstResult(start);
        query.setMaxResults(limit);

        //查询结果
        return query.list();
    }
}
