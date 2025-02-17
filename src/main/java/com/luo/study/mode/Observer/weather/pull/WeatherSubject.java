package com.luo.study.mode.Observer.weather.pull;

import com.luo.study.mode.Observer.weather.pull.Observer;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luolingyan
 * @description 目标对象，它知道观察它的观察者，并提供注册（添加）和删除观察者的接口
 * @create 2025-02-17 14:48
 */
@Data
public class WeatherSubject {
    //用来保存注册的观察者对象
    private List<Observer> observers = new ArrayList<>();

    //把订阅天气的人添加到订阅者列表中
    public void attach(Observer observer){
        observers.add(observer);
    }

    //删除集合中的指定订阅天气的人
    public void detach(Observer observer){
        observers.remove(observer);
    }

    /**
     * 这个方法只有子类可以调用，所以我们定义方法的修饰符为protected
     * 通知所有已经订阅了天气的人
     */
    protected void notifyObservers(){
        for(Observer observer:observers){
            observer.update(this);
        }
    }
}
