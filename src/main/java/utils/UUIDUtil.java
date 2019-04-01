package utils;

import java.util.UUID;

/**
 * Created by aa on 2017/11/1.
 */
public class UUIDUtil {
    /**
     *  32位uuid:
     *  > 16进制数
     *  > 去除了中间的“-”符号
     * @return
     */
    public static String getString(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
