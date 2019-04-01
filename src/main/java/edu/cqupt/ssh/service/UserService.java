package edu.cqupt.ssh.service;

import edu.cqupt.ssh.dao.UserDao;
import edu.cqupt.ssh.domain.User;
import edu.cqupt.ssh.utils.Mail;
import edu.cqupt.ssh.utils.MailUtils;
import edu.cqupt.ssh.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.Session;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by aa on 2017/8/5.
 */
@Transactional
public class UserService {
    @Autowired
    private UserDao userDao;

    //查询用户是否存在
    public boolean isExist(String name){
       return userDao.isExist(name);
    }

    //添加注册的用户
    public boolean add(User user){
        //注册的用户一开始处于未激活，指定有激活码的状态
        user.setState(0);
        user.setCode(UUIDUtils.getUUID());
        try {
            //发邮件
            Session session =
                    MailUtils.getSession("smtp.163.com","18883731560@163.com","asd720818");

            //修改超链接
            String content = "<a href='http://118.24.113.168/active.action?code="+user.getCode()+"'>恭喜成功注册成为商城用户，点击此链接进行激活。</a>";
            Mail mail = new Mail("18883731560@163.com","商城的激活邮件",content);
            mail.addToAddress(user.getEmail());
            MailUtils.send(session,mail);
            //一切OK 存入数据库
            userDao.add(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("邮件发送失败。。。。");
            return false;
        }
    }
    //激活码查询激活
    public void findByCode(String code){
       List<User> list  = userDao.findByCode(code);

       if(!list.isEmpty()){
           User user  = list.get(0);
           user.setState(1);
           user.setCode(null);
           userDao.update(user);
       }
    }

    //登录验证
   public String login(User user){
        List<User> list = userDao.login(user);
        if (list.isEmpty())
            return "用户名或密码错误!";
        else if (list.get(0).getState() == 0)
            return "账号未激活";
        else {
            user.setUid(list.get(0).getUid());
            return "";
        }
   }
}
