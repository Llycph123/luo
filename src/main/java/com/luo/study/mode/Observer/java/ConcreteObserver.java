package com.luo.study.mode.Observer.java;

import lombok.Builder;
import lombok.Data;

import java.util.Observable;
import java.util.Observer;

/**
 * @author luolingyan
 * @description
 * @create 2025-02-17 18:00
 */
@Data
@Builder
public class ConcreteObserver implements Observer {
    //观察者名称的变量
    private String observerName;

    @Override
    public void update(Observable o, Object arg) {
        //第一种是推的方式
        System.out.println(observerName + "收到了消息，目标推送过来的是" + arg);

        //第二种是拉的方式
        System.out.println(observerName + "收到了消息，主动到目标对象中去拉，拉的内容是" + ((ConcreteWeatherSubject)o).getContent());
    }



}
