package com.example.wjc.ssecurity1215.util;

import org.apache.commons.collections.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author ZhangZhiHao 2018/7/18 14:50
 */
public class DataUtils {

    /**
     * 将源数据转换为指定类型的数据,并用Optional包装
     *
     * @param source 源对象
     * @param target 目标对象Class
     * @param <S>    源类型
     * @param <T>    目标类型
     */
    public static <S, T> Optional<T> transformObject(S source, Class<T> target) {
        if (source != null) {
            return Optional.of(DozerUtils.convert(source, target));
        }
        return Optional.empty();
    }

    /**
     * 将源数据转换为指定类型的数据,并用Optional包装
     *
     * @param source 源对象
     * @param target 目标对象Class
     * @param <S> 源类型
     * @param <T> 目标类型
     * @param consumer 要执行的函数
     */
    public static <S, T> Optional<T> transformObject(S source, Class<T> target, Consumer<T> consumer) {
        if (source != null) {
            T list = DozerUtils.convert(source, target);
            consumer.accept(list);
            return Optional.of(list);
        }
        return Optional.empty();
    }

    /**
     * 将源数据转换为指定类型的数据,并用Optional包装
     *
     * @param source 源对象
     * @param target 目标对象Class
     * @param <S> 源类型
     * @param <T> 目标类型
     * @param consumer  要执行的函数
     * @param u 执行函数所需要的参数
     */
    public static <S, T, U> Optional<T> transformObject(S source, Class<T> target, BiConsumer<T, U> consumer, U u) {
        if (source != null) {
            T list = DozerUtils.convert(source, target);
            consumer.accept(list, u);
            return Optional.of(list);
        }
        return Optional.empty();
    }

    /**
     * 将源数据集合转换为指定类型的数据集合
     *
     * @param sources 源集合
     * @param target  目标对象Class
     * @param <S>     源类型
     * @param <T>     目标类型
     */
    public static <S, T> List<T> transformList(List<S> sources, Class<T> target) {
        if (CollectionUtils.isNotEmpty(sources)) {
            return DozerUtils.convertList(sources, target);
        }
        return Collections.emptyList();
    }

    /**
     * 将源数据集合转换为指定类型的数据集合
     *
     * @param sources 源集合
     * @param target 目标对象Class
     * @param <S> 源类型
     * @param <T> 目标类型
     * @param consumer 要执行的函数
     */
    public static <S, T> List<T> transformList(List<S> sources, Class<T> target, Consumer<T> consumer) {
        if (CollectionUtils.isNotEmpty(sources)) {
            List<T> list = DozerUtils.convertList(sources, target);
            list.forEach(consumer);
            return list;
        }
        return Collections.emptyList();
    }

    /**
     * 将源数据集合转换为指定类型的数据集合
     *
     * @param sources 源集合
     * @param target 目标对象Class
     * @param <S> 源类型
     * @param <T> 目标类型
     * @param consumer 要执行的函数
     * @param u 执行函数所需的参数
     */
    public static <S, T, U> List<T> transformList(List<S> sources, Class<T> target, BiConsumer<T, U> consumer, U u) {
        if (CollectionUtils.isNotEmpty(sources)) {
            List<T> list = DozerUtils.convertList(sources, target);
            list.forEach(t -> consumer.accept(t, u));
            return list;
        }
        return Collections.emptyList();
    }


}
