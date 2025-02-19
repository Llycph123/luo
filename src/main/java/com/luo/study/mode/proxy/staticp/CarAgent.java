package com.luo.study.mode.proxy.staticp;

/**
 * @author luolingyan
 * @create 2025-02-19 10:52
 * 继承方式
 */
public class CarAgent extends Car{
    @Override
    public void move() {
        long starttime = System.currentTimeMillis();
        System.out.println("汽车开始行驶");
        super.move();
        long endtime = System.currentTimeMillis();
        System.out.println("汽车结束行驶……，汽车行驶时间："+(endtime-starttime)+"毫秒");
    }
}
