package com.soft1851.springboot.jpa.util;

/**
 * @Author: YangJinG
 * @Date: 2020/5/13 20:12
 * @Description:
 */
public class StringUtils {
    public static boolean isNullOrEmpty(String content){
        if (content != null && content.length() != 0){
            return false;
        }
        return true;
    }
}
