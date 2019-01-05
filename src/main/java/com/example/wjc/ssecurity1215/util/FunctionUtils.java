package com.example.wjc.ssecurity1215.util;

import java.util.function.*;

/**
 * @author ZhangZhiHao 2018/9/28 18:00
 */
public class FunctionUtils {

    public static <T> void consumerAccept(T t, Consumer<T> consumer) {
        consumer.accept(t);
    }

    public static <T, U> void consumerAccept(T t, U u, BiConsumer<T, U> consumer) {
        consumer.accept(t, u);
    }

    public static <T, R> R functionApply(T t, Function<T, R> function) {
        return function.apply(t);
    }

    public static <T, U, R> R functionApply(T t, U u, BiFunction<T, U, R> function) {
        return function.apply(t, u);
    }

    public static <T> boolean predicateTest(T t, Predicate<T> predicate) {
        return predicate.test(t);
    }

    public static <T, U> boolean predicateTest(T t, U u, BiPredicate<T, U> predicate) {
        return predicate.test(t, u);
    }

    public static <T> T supplierGet(Supplier<T> supplier) {
        return supplier.get();
    }
}