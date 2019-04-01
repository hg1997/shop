package edu.cqupt.ssh.utils;

import java.util.UUID;
/**
 * Created by aa on 2017/8/6.
 */
public class UUIDUtils {

    /*
    * 随机生成的uuid作为激活码
    * */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
