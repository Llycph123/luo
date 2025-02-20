package com.luo.study.base.mode.proxy.staticp;

/**
 * @author luolingyan
 * @create 2025-02-19 11:10
 * 只实现了对car对象的代理，我如果想代理火车、自行车呢
 */
public class Client {
    public static void main(String[] args) {
        Car car = new Car();
        //先记录日志再记录时间
        /*CarTimeProxy ctp = new CarTimeProxy(car);
        CarLogProxy clp = new CarLogProxy(ctp);*/

        //先记录时间再记录日志
        CarLogProxy clp = new CarLogProxy(car);
        CarTimeProxy ctp = new CarTimeProxy(clp);
        ctp.move();

        String filename = System.getProperty("user.dir");
        System.out.println(filename);
    }
}
