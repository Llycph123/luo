package com.luo.study.base.mode.Observer.java;

import java.util.Observable;

/**
 * @author luolingyan
 * @description
 * @create 2025-02-17 17:56
 */
public class ConcreteWeatherSubject extends Observable {
    //天气情况的内容
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        //天气情况有了，就要通知所有的观察者
        //注意在通知之前，在用java的observer模式时候，下面这句话不可少
        this.setChanged();
        //然后主动通知，这里我们先用推的方式
        this.notifyObservers(content);

        //如果是拉方法，我们就调用无参数
        //this.notifyObservers();
    }
}
