package com.luo.study.mode.Observer.weather;

/**
 * @author luolingyan
 * @description
 * @create 2025-02-17 16:39
 */
public class Client {
    public static void main(String[] args) {
        //1创建目标
        ConcreteWeatherSubject weather = new ConcreteWeatherSubject();

        //2创建观察者
        ConcreteObserver observerGirl = ConcreteObserver.builder()
                .observerName("黃明的女朋友")
                .remindThing("是我们的第一次约会，地点街心公园，不见不散哦")
                .build();

        ConcreteObserver observerMum = ConcreteObserver.builder()
                .observerName("老妈")
                .remindThing("是一个购物的好日子，明天去天虹扫货")
                .build();

        //3注册观察者
        weather.attach(observerGirl);
        weather.attach(observerMum);

        //4目标处发布天气
        weather.setWeatherContent("明天天气晴朗，蓝天白云，气温28度");
    }
}
