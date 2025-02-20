package com.luo.study.base.mode.Observer.general;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luolingyan
 * @description 目标对象，它知道观察它的观察者，并提供注册（添加）和删除观察者的接口
 * @create 2025-02-17 14:48
 */
public class Subject {
    //用来保存注册的观察者对象
    private List<Observer> observers = new ArrayList<>();

    //添加观察者
    public void attach(Observer observer){
        observers.add(observer);
    }

    //删除观察者
    public void detach(Observer observer){
        observers.remove(observer);
    }

    /**
     * 这个方法只有子类可以调用，所以我们定义方法的修饰符为protected
     * 通知所有注册的观察者
     */
    protected void notifyObservers(){
        for(Observer observer:observers){
            //observer.update(this);
        }
    }
}
