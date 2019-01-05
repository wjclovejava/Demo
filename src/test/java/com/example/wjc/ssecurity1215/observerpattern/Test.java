package com.example.wjc.ssecurity1215.observerpattern;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2018/12/27 11:00
 */
public class Test {
    public static void main(String[] args) {

        WechatServer wechatServer=new WechatServer();
        System.out.println("微信公众号创建");

        Observer userZhang = new User("ZhangSan");
        Observer userLi = new User("LiSi");
        Observer userWang = new User("WangWu");

        wechatServer.registerObserver(userZhang);
        wechatServer.registerObserver(userLi);
        wechatServer.registerObserver(userWang);

        wechatServer.setInfomation("姓王的最丑");
        System.out.println("--------------------------------");
        wechatServer.removeObserver(userWang);
        wechatServer.setInfomation("姓王的最帅");
    }
}
