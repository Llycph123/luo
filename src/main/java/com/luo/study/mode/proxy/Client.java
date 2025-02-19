package com.luo.study.mode.proxy;

import com.luo.study.mode.proxy.jdk.TimeHandler;
import com.luo.study.mode.proxy.staticp.Car;
import com.luo.study.mode.proxy.staticp.MoveAble;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author luolingyan
 * @create 2025-02-19 11:30
 */
public class Client {
    public static void main(String[] args) {
        Car car = new Car();
        InvocationHandler h = new TimeHandler(car);
        Class clazz = car.getClass();
        /**
         * loader 类加载器
         * interfaces 实现接口
         * h InvocationHandler
         */
        MoveAble m = (MoveAble)Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), h);
        m.move();
    }
}
