package edu.cqupt.ssh.utils;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * Created by aa on 2017/8/5.
 */
public class Test {
    public static void main(String[] args) throws IOException, MessagingException {
       String str = "*用户名已经存在！";
       System.out.println(new String(str.getBytes(),"utf-8"));
    }
}
