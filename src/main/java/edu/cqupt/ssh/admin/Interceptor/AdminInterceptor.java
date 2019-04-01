package edu.cqupt.ssh.admin.Interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import edu.cqupt.ssh.admin.domain.AdminUser;
import org.apache.struts2.ServletActionContext;

/**
 * Created by aa on 2017/8/16.
 */
public class AdminInterceptor extends MethodFilterInterceptor {
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        //获取session中的后台管理员用户
        AdminUser adminUser = (AdminUser) ServletActionContext.getRequest().getSession().getAttribute("adminUser");
        if(adminUser == null){   //如果没有登录
            ActionSupport actionSupport = (ActionSupport) actionInvocation.getAction();
            actionSupport.addActionError("您还没有登录，没有权限访问！");
           return "loginFail";
        }else{                  //登录了放行
            return actionInvocation.invoke();
        }
    }
}
