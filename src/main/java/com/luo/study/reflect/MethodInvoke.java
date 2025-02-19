package com.luo.study.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author luolingyan
 * @create 2025-02-19 9:49
 * 1)如何获取某个方法
 * 方法的名称和方法的参数列表才能唯一决定某个方法
 * 2)方法反射的操作
 * method.invoke(对象,参数列表)
 */
public class MethodInvoke {
    public static void main(String[] args) {
        A a = new A();
        Class c = a.getClass();
        /**
         * getMethod获取的是public的方法
         * getDeclaredMethod获取的是自己声明的方法
         */
        try {
            Method m1 = c.getMethod("print", new Class[]{int.class, int.class});
            m1.invoke(a,new Object[]{10,20});

            Method m2 = c.getMethod("print", new Class[]{String.class, String.class});
            m2.invoke(a,new Object[]{"a","b"});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
class A{
    public void print(int a, int b){
        System.out.println(a+b);
    }

    public void print(String a, String b){
        System.out.println(a.toUpperCase() + "," +b.toUpperCase());
    }
}