package com.luo.study.mode.proxy.custom;

import com.luo.study.mode.proxy.staticp.CarAgent;
import com.luo.study.mode.proxy.staticp.MoveAble;

import java.util.Random;

/**
 * @author luolingyan
 * @create 2025-02-19 10:41
 */
public class Car implements com.luo.study.mode.proxy.custom.MoveAble {
    @Override
    public void move() {
        //实现开车
        try {
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("汽车行驶中");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MoveAble car = new CarAgent();
        car.move();
    }
}
