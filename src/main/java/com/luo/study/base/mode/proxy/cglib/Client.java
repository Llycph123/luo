package com.luo.study.base.mode.proxy.cglib;

/**
 * @author luolingyan
 * @create 2025-02-19 14:14
 */
public class Client {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        Train train = (Train) cglibProxy.getProxy(Train.class);
        train.move();
    }
}
