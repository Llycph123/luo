package com.luo.study.mode.Observer.custom;

/**
 * @author luolingyan
 * @description
 * @create 2025-02-17 22:39
 */
public class ConcreteWeatherSubject extends WeatherSubject{
    private String weatherContent;

    public String getWeatherContent() {
        return weatherContent;
    }

    public void setWeatherContent(String weatherContent) {
        this.weatherContent = weatherContent;
        this.notifyObservers();
    }

    @Override
    protected void notifyObservers() {
        for(Observer observer:observers){
            if("下雨".equals(this.getWeatherContent())){
                if("黄明的女朋友".equals(observer.getObserverName())
                    || "黄明的老妈".equals(observer.getObserverName())){
                    observer.update(this);
                }
            }else if("下雪".equals(this.getWeatherContent())){
                if("黄明的老妈".equals(observer.getObserverName())) {
                    observer.update(this);
                }
            }
        }
    }
}
