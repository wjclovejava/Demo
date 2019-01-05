package com.example.wjc.ssecurity1215.util;

/**
 * @author ZhangZhiHao 2018/9/30 15:30
 */
public class LongUtils {

    public static Long sum(Long i1, Long i2) {
        if (i1 == null) {
            i1 = 0L;
        }
        if (i2 == null) {
            i2 = 0L;
        }
        return Long.sum(i1, i2);
    }
}
