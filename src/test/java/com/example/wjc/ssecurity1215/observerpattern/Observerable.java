package com.example.wjc.ssecurity1215.observerpattern;

/**
 * @Author: wjc
 * @Description:  观察者模式----抽象 被观察者接口
 *   声明了添加、删除、通知观察者方法
 * @Date: created in 2018/12/27 10:46
 */
public interface Observerable {
    /**
     * 订阅(关注)
     * @param o
     */
    public void registerObserver(Observer o);
    /**
     * 取消订阅(关注)
     * @param o
     */
    public void removeObserver(Observer o);
    /**
     * 群发消息
     * @param o
     */
    public void notifyObserver();
}
