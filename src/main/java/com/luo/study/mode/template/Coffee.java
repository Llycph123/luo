package com.luo.study.mode.template;

/**
 * @author luolingyan
 * @create 2025-02-18 21:54
 * 具体子类，提供了咖啡制备的具体实现
 */
public class Coffee extends RefreshBeverage{
    @Override
    protected void brew() {
        System.out.println("用沸水冲泡咖啡");
    }

    @Override
    protected void addCondiments() {
        System.out.println("加入糖和牛奶");
    }

    public static void main(String[] args) {
        System.out.println("制备咖啡");
        RefreshBeverage coffee = new Coffee();
        coffee.prepareBeverageTemplate();
        System.out.println("咖啡好了");
    }
}
