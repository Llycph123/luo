package com.luo.study.mode.proxy.staticp;

/**
 * @author luolingyan
 * @create 2025-02-19 11:05
 */
public class CarLogProxy implements MoveAble{
    private MoveAble m;

    public CarLogProxy(MoveAble m){
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("日志开始");
        m.move();
        System.out.println("日志结束");
    }
}
