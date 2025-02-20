package com.luo.study.base.reflect;

/**
 * @author luolingyan
 * @create 2025-02-18 22:36
 */
public class Clazz {
    public static void main(String[] args) {
        //Foo的实例对象如何表示
        Foo foo1 = new Foo();
        /**
         * Foo这个类也是一个实例对象，Class类的实例对象如何表示呢
         * 任何一个类都是Class的实例对象，这个实例对象有三种表示方式
         */
        //第一种表示方式--->实际在告诉我们任何一个类都有一个隐含的静态成员变量
        Class c1 = Foo.class;

        //第二种表达方式 已经知道该类的对象通过getClass方法
        Class c2 = foo1.getClass();

        /**
         * 官网c1,c2表示了Foo类的类类型（class type）
         * 万事万物皆对象，是Class类的实例对象
         * 这个对象我们称为该类的类类型
         */

        //不管c1还是c2都代表了Foo类的类类型，一个类只可能是Class类的一个实例对象
        System.out.println(c1 == c2);

        //第三种表达方式
        Class c3 = null;
        try {
            c3 = Class.forName("com.luo.study.base.reflect.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(c2 == c3);

        //我们完全可以通过类的类类型创建该类的对象实例-->通过c1或c2或c3创建Foo的实例
        try {
            //强制类型转换，前提是要有无参的构造方法，且构造方法为public
            Foo foo = (Foo) c1.newInstance();
            foo.print();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}

class Foo{
    void print(){
        System.out.println("hello class");
    }
}
