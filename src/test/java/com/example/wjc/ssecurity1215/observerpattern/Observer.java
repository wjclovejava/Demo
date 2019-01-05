package com.example.wjc.ssecurity1215.observerpattern;

/**
 * @Author: wjc
 * @Description: 观察者模式---- 抽象 观察者接口
 *         定义了一个update()方法，当被观察者调用notifyObservers()方法时，观察者的update()方法会被回调。
 * @Date: created in 2018/12/27 10:47
 */
public interface Observer {

    public void update(String message);
}
