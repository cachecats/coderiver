package com.solo.coderiver.project.utils;

import java.util.Random;

public class KeyUtils {

    /**
     * 产生独一无二的key
     *
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        int number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
