package com.luo.study.base.mode.Observer.custom;

/**
 * @author luolingyan
 * @description
 * @create 2025-02-17 22:52
 */
public class Client {
    public static void main(String[] args) {
        ConcreteWeatherSubject weatherSubject = new ConcreteWeatherSubject();
        ConcreteObserver girl = ConcreteObserver.builder()
                .observerName("黄明的女朋友")
                .remindThing("下雨了，安静的呆在家里吧")
                .build();
        ConcreteObserver mum = ConcreteObserver.builder()
                .observerName("黄明的老妈")
                .remindThing("不管下雨还是下雪，我都不出门了")
                .build();
        weatherSubject.attach(girl);
        weatherSubject.attach(mum);
        //weatherSubject.setWeatherContent("下雨");
        weatherSubject.setWeatherContent("下雪");
    }
}
