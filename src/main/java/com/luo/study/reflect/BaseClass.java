package com.luo.study.reflect;

/**
 * @author luolingyan
 * @create 2025-02-19 8:42
 * 基本数据类型
 */
public class BaseClass {
    public static void main(String[] args) {
        Class c1 = int.class;
        Class c2 = String.class;//String类的类类型，String类字节码（自己发明的，不是官方说法）
        Class c3 = double.class;
        Class c4 = Double.class;
        System.out.println(c3 == c4);
        Class c5 = void.class;
       System.out.println(c1.getName());
        System.out.println(c2.getName());
        System.out.println(c2.getSimpleName());//不包含包名的类的名称
    }
}
