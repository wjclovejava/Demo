package com.example.wjc.ssecurity1215.util;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author ZhangZhiHao 2018/7/21 10:14
 */
public class ObjectUtils {

    /**
     * 对所有参数进行校验 不能为空
     *
     * @param objects 可变的参数列表
     * @throws NullPointerException
     */
    public static void requireNonNull(Object... objects) {
        Stream.of(objects).forEach(Objects::requireNonNull);
    }
}
