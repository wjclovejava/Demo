package com.example.wjc.ssecurity1215.observerpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wjc
 * @Description: 观察者模式----被观察者(此处为微信公众号)
 * @Date: created in 2018/12/27 10:50
 */
public class WechatServer implements Observerable {
    private List<Observer> list;
    private String message;

    public WechatServer() {
        list=new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        list.add(o);
        if(o instanceof User) {
            System.out.println(((User) o).getName()+"关注公众号");
        }
    }

    @Override
    public void removeObserver(Observer o) {
        if(!list.isEmpty()){
            list.remove(o);
            if(o instanceof User) {
                System.out.println(((User) o).getName()+"取消关注公众号");
            }
        }
    }

    @Override
    public void notifyObserver() {
        for(int i = 0; i < list.size(); i++) {
            Observer observer = list.get(i);
            observer.update(message);
        }
    }

    public void setInfomation(String s){
        this.message=s;
        System.out.println("微信公众号更新消息:"+s);
        notifyObserver();
    }
}
