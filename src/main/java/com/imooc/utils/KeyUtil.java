package com.imooc.utils;

import java.util.Random;

/**
 * @Author: wuguozhu.
 * @Desc:
 * @Date: 2017/12/9 13:28.
 */
public class KeyUtil {
    public static synchronized  String genUniqueKey(){
        Random random = new Random();
        System.currentTimeMillis();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
