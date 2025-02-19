package com.luo.study.mode.proxy.staticp;

/**
 * @author luolingyan
 * @create 2025-02-19 10:54
 * 聚合方式
 * 聚合就是一个类当中调用另一个对象
 */
public class CarAgentBetter implements MoveAble{
    private Car car;

    public CarAgentBetter(Car car){
        this.car = car;
    }

    @Override
    public void move() {
        long starttime = System.currentTimeMillis();
        System.out.println("汽车开始行驶");
        car.move();
        long endtime = System.currentTimeMillis();
        System.out.println("汽车结束行驶……，汽车行驶时间："+(endtime-starttime)+"毫秒");
    }

    public static void main(String[] args) {
        Car car = new Car();
        MoveAble c = new CarAgentBetter(car);
        c.move();
    }
}
