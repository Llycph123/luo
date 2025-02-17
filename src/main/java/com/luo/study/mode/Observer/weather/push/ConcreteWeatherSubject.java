package com.luo.study.mode.Observer.weather.push;

/**
 * @author luolingyan
 * @description 具体的目标对象，负责把有关状态存入到相应的观察者对象中
 * @create 2025-02-17 14:49
 */

public class ConcreteWeatherSubject extends WeatherSubject {
    //获取天气的内容信息
    private String weatherContent;

    public String getWeatherContent() {
        return weatherContent;
    }

    public void setWeatherContent(String weatherContent) {
        this.weatherContent = weatherContent;
        //内容有了，说明天气更新了，通知所有订阅的人
        this.notifyObservers(weatherContent);
    }
}
