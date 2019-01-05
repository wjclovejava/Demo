package com.example.wjc.ssecurity1215.testfunction;

import lombok.Data;

import java.time.LocalDate;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2018/12/25 16:40
 */
@Data
class testFunction {

    public enum Sex {
        MALE, FEMALE
    }
    private String name;
    private LocalDate birthday;
    private Sex gender;
    private String emailAddress;

    public static int compareByAge(testFunction a, testFunction b){
        return a.birthday.compareTo(b.birthday);
    }



    public static void main(String[] args) {
        //对象引用::实例方法名
        //Consumer<String> consumer = x -> System.out.println(x);
        Consumer<String> consumer= System.out::print;
        consumer.accept("mamamam");
        //类名::静态方法名
        //Function<Long, Long> f = x -> Math.abs(x);
        Function<Long, Long> f = Math::abs;
        Long result = f.apply(-3L);
        System.out.println("result="+result);
        //类名::实例方法名
        //BiPredicate<String,String> b=(x,y)->(x.equals(y));
        BiPredicate<String,String> biPredicate=String::equals;
        boolean b = biPredicate.test("abc", "abcd");
        System.out.println("b="+b);
        //引用构造器
        Function<Integer,StringBuffer> fun = n -> new StringBuffer(n);
        StringBuffer apply = fun.apply(1);
        System.out.println(apply.append("123"));
    }

}


