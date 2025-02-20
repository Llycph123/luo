package com.luo.study.base.mode.Observer.custom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luolingyan
 * @description
 * @create 2025-02-17 22:30
 */
public abstract class WeatherSubject {

    public List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void detach(Observer observer){
        observers.remove(observer);
    }

    protected abstract void notifyObservers();
}
