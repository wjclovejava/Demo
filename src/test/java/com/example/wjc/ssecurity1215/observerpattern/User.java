package com.example.wjc.ssecurity1215.observerpattern;


import lombok.Data;

/**
 * @Author: wjc
 * @Description: 观察者模式----观察者(用户)
 * @Date: created in 2018/12/27 10:52
 */
@Data
public class User implements Observer {
    private String name;
    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        read();
    }

    public void read(){
        System.out.println(name+"收到消息:"+message);
    }
}
