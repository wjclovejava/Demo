package com.example.wjc.ssecurity1215.testStream;

import java.util.function.Predicate;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2018/12/30 16:45
 */
class MyPredicate implements Predicate<Product> {

    @Override
    public boolean test(Product product) {
        int length = product.getProductName().trim().length();
        if(length>2) return  true;
        return false;
    }
}
