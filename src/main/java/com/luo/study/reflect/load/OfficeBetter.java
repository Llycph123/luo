package com.luo.study.reflect.load;

/**
 * @author luolingyan
 * @create 2025-02-18 23:03
 * 动态加载类
 */
public class OfficeBetter {
    /**
     * javac OfficeBetter.java
     * java OfficeBetter Word 创建Word对象并执行start方法
     * java OfficeBetter Excel 创建Excel对象并执行start方法
     * @param args
     */
    public static void main(String[] args) {
        try {
            //动态加载类，在运行时刻加载
            Class c = Class.forName(args[0]);
            //通过类类型，创建该类对象
            OfficeAble oa = (OfficeAble)c.newInstance();
            oa.start();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
