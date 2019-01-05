package com.example.wjc.ssecurity1215.util;

/**
 * @author ZhangZhiHao 2018/9/30 15:35
 */
public class NumberUtils {

    public static void main(String[] args) {
        Integer integer1 = FunctionUtils.functionApply(100, 2, (integer, integer2) -> integer + integer2);
        System.out.println("integer1 = " + integer1);
    }
}
