package edu.cqupt.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import edu.cqupt.ssh.domain.User;
import edu.cqupt.ssh.service.UserService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by aa on 2017/8/5.
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
    @Autowired
    private UserService userService;

    //属性封装验证码
    private String captcha;
    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    //模型驱动
    private User user = new User();
    public User getModel() {
        return user;
    }

    //注册页面跳转
    public String regist() throws Exception {
        return "regist";
    }
    //登录页面跳转
    public String login() throws Exception {
        return "login";
    }

    //登录页面跳转
    public String doLogin() throws Exception {
        String  msg = userService.login(user);
        System.out.println("登陆的action确认后的user:"+user);
        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest request = ServletActionContext.getRequest();
        if(msg.equals("")) {//不带任何错误信息‘
            request.getSession().setAttribute("user",user);
            return "index";
        }
        else{
            request.setAttribute("msg",msg);
            request.setAttribute("user",user);
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
            return NONE;
        }
    }

    //退出登录的用户
    public String invalidate(){
        ServletActionContext.getRequest().getSession().invalidate();
        return "invalidate";
    }

    //校验用户是否存在
    public void isExist() throws IOException {
        //两头
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        //编码问题
        response.setContentType("text/html;charset=utf-8");

        //校验是否存在
        String name = request.getParameter("username");
        //get请求编码处理
        name = new String(name.getBytes("iso8859-1"),"utf-8");
        /*!!!!!!!!!!!!!!!!!!!!!!*/
        System.out.println("ajax获取的name:"+name);
        /*!!!!!!!!!!!!!!!!!!!!!!*/
        boolean flag = userService.isExist(name);
        String msg = "";
        if(flag)
            msg = "<font color='red'>*用户名已经存在！</fonts>";
        response.getWriter().print(msg);
    }

   //注册记录信息到数据库
    public String registAdd(){

         String code = (String) ServletActionContext.getRequest().getSession().getAttribute("captcha");
        System.out.println("生成的code："+code);
        System.out.println("获取的code:"+captcha);

        if(code.equalsIgnoreCase(captcha)){
            System.out.println("验证码匹配正确。。。。");
            boolean flag = userService.add(user);
            if(flag){
                return SUCCESS;
            }else{
                ServletActionContext.getRequest().setAttribute("user",user);
                ServletActionContext.getRequest().setAttribute("msg","注册失败，请检查您的邮箱是否正确！");
                return "regist";
            }
        }else{
            if(captcha!=null){
                ServletActionContext.getRequest().setAttribute("user",user);
                ServletActionContext.getRequest().setAttribute("msg","验证码错误了！");
            }
            return "regist";
        }
    }

    //激活用户
    public String active(){
        HttpServletRequest request = ServletActionContext.getRequest();
        String code = request.getParameter("code");
        userService.findByCode(code);
        return "active";
    }
}
