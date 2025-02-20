package com.luo.study.base.mode.proxy.staticp;

/**
 * @author luolingyan
 * @create 2025-02-19 11:05
 */
public class CarTimeProxy implements MoveAble{
    private MoveAble m;

    public CarTimeProxy(MoveAble m){
        this.m = m;
    }

    @Override
    public void move() {
        long starttime = System.currentTimeMillis();
        System.out.println("汽车开始行驶");
        m.move();
        long endtime = System.currentTimeMillis();
        System.out.println("汽车结束行驶……，汽车行驶时间："+(endtime-starttime)+"毫秒");
    }
}
