package edu.cqupt.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import edu.cqupt.ssh.utils.VerifyCode;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/**
 * Created by aa on 2017/8/6.
 */
public class ImageAction extends ActionSupport{
    @Override
    public String execute() throws Exception {
        VerifyCode verifyCode = new VerifyCode();

        //获取验证码图片
        BufferedImage image = verifyCode.getImage();
        //获取验证码文字保存到session
        String text = verifyCode.getText();
        ServletActionContext.getRequest().getSession().setAttribute("captcha",text);

        //搞到页面
        HttpServletResponse response = ServletActionContext.getResponse();
        verifyCode.write(image,response.getOutputStream());
        return NONE;
    }
}
