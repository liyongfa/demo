package com.gudt.common.utils;

import java.util.Random;

/**
 * @Auther: lyf
 * @Date: 2019-06-21 19:15
 * @Description:
 */
public class StringUtils {

    /**
     * 判断参数是否为空字符串
     *
     * @param str
     * @return
     */
    public static boolean notBlank(String str) {
        if (str != null && str.trim().length() > 0)
            return true;
        return false;
    }

    /**
     * 生成唯一key
     * 规则:7位随机数+17当前时间戳
     *
     * @return
     */
    public synchronized static String uniqueKey() {
        Random rand = new Random();
        int sub = rand.nextInt(1000000) + 9000000;
        return sub + "" + System.currentTimeMillis();
    }
}
