package com.luo.study.base.mode.Observer.custom;

import lombok.Builder;

/**
 * @author luolingyan
 * @description
 * @create 2025-02-17 22:46
 */
@Builder
public class ConcreteObserver implements Observer{
    private String observerName;
    private String weatherContent;
    private String remindThing;

    @Override
    public void update(WeatherSubject subject) {
        weatherContent = ((ConcreteWeatherSubject)subject).getWeatherContent();
        System.out.println(observerName + "收到了" + weatherContent + "，" + remindThing);
    }

    @Override
    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }

    @Override
    public String getObserverName() {
        return observerName;
    }

    public String getWeatherContent() {
        return weatherContent;
    }

    public void setWeatherContent(String weatherContent) {
        this.weatherContent = weatherContent;
    }

    public String getRemindThing() {
        return remindThing;
    }

    public void setRemindThing(String remindThing) {
        this.remindThing = remindThing;
    }
}
