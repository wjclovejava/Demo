package com.example.wjc.ssecurity1215.util;

/**
 * @author ZhangZhiHao 2018/9/18 18:27
 */

public abstract class IntegerUtils {

    public static Integer sum(Integer i1, Integer i2) {
        if (i1 == null) {
            i1 = 0;
        }
        if (i2 == null) {
            i2 = 0;
        }
        return Integer.sum(i1, i2);
    }

}
