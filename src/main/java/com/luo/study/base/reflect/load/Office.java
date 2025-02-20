package com.luo.study.base.reflect.load;

/**
 * @author luolingyan
 * @create 2025-02-18 22:58
 */
public class Office {
    public String hello;

    public static void main(String[] args) {
        //new创建对象 是静态加载类，在编译时刻就需要加载所有的可能使用到的类
        //通过动态加载类可以解决这个问题
        if("word".equals(args[0])){
            Word w = new Word();
            w.start();
        }
    }
}
