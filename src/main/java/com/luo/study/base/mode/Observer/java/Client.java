package com.luo.study.base.mode.Observer.java;

/**
 * @author luolingyan
 * @description
 * @create 2025-02-17 22:08
 */
public class Client {
    public static void main(String[] args) {
        //创建一个天气做为一个目标
        ConcreteWeatherSubject subject = new ConcreteWeatherSubject();

        //创建黄明的女朋友做为观察者
        ConcreteObserver girl = ConcreteObserver.builder().observerName("黄明的女朋友").build();

        //创建黄明的老妈做为观察者
        ConcreteObserver mum = ConcreteObserver.builder().observerName("黄明的老妈").build();

        //注册观察者
        subject.addObserver(girl);
        subject.addObserver(mum);

        //目标更新天气情况
        subject.setContent("天气晴，气温28度");
    }
}
