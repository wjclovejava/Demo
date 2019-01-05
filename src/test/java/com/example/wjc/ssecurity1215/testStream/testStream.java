package com.example.wjc.ssecurity1215.testStream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2018/12/30 16:07
 */
public class testStream {

    public static void main(String[] args) {
        Product product1 = new Product();
        product1.setProductId(1);
        product1.setProductName("手机");
        product1.setProductFactories(Arrays.asList("魅族", "小米", "华为", "苹果"));
        product1.setCount(35432);

        Product product2 = new Product();
        product2.setProductId(2);
        product2.setProductName("电视机");
        product2.setProductFactories(Arrays.asList("乐视", "小米", "华为"));
        product1.setCount(62436);

        Product product3 = new Product();
        product3.setProductId(3);
        product3.setProductName("电脑");
        product3.setProductFactories(Arrays.asList("联想", "苹果", "戴尔"));
        product1.setCount(76574);

        List<Product> productList=new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        //查询有多少种产品
        List<String> nameList = productList.stream().map(Product::getProductName).collect(Collectors.toList());
        nameList.stream().forEach(name-> System.out.print(name));
        System.out.println("");
        //查询有多少种厂家
        Set<String> factories=new HashSet<>();
        productList.stream().map(Product::getProductFactories).collect(Collectors.toList()).forEach(factories::addAll);
        factories.stream().forEach(name-> System.out.print(name));
        System.out.println("");
        //查询 过滤 产品名称 字数大于2 的产品列表
        List<Product> newList = productList.stream().filter(new MyPredicate()).collect(Collectors.toList());
        newList.stream().forEach(product -> System.out.println(product.getProductId()+product.getProductName()));

        int sum = productList.stream().mapToInt(w -> w.getCount()).sum();
        System.out.println(sum);
    }
}
