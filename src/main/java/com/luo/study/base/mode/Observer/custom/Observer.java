package com.luo.study.base.mode.Observer.custom;

/**
 * @author luolingyan
 * @description
 * @create 2025-02-17 22:36
 */
public interface Observer {
    void update(WeatherSubject subject);

    public void setObserverName(String observerName);

    public String getObserverName();
}
