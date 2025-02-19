package com.luo.study.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author luolingyan
 * @create 2025-02-19 10:03
 * 泛型 通过Class,Method认识泛型的本质
 */
public class Generic {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList();
        ArrayList<String> list2 = new ArrayList();
        list2.add("hello");
        list2.add("world");
        Class c1 = list1.getClass();
        Class c2 = list2.getClass();
        System.out.println(c1 == c2);
        //反射的操作都是编译之后的操作
        /**
         * c1 == c2结果返回true，说明编译之后集合的泛型是去泛型化的
         * java中集合的泛型，是防止错误输入的，只在编译阶段有效
         * 绕过编译就无效了
         * 验证：我们可以通过方法的反射来操作，绕过编译
         */
        try {
            Method m = c2.getMethod("add", Object.class);
            m.invoke(list2, 100);//绕过编译操作就绕过了泛型
            System.out.println(list2.size());
            System.out.println(list2);
            /*for(String s:list2){
                System.out.println(s);
            }*///现在不能这样遍历了，会有类型转换错误
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
