package com.luo.study.base.mode.template;

/**
 * @author luolingyan
 * @create 2025-02-18 21:57
 * 具体子类，提供了制备茶的具体实现
 */
public class Tea extends RefreshBeverage{
    @Override
    protected void brew() {
        System.out.println("用80度的热水浸泡茶叶5分钟");
    }

    @Override
    protected void addCondiments() {
        System.out.println("加入柠檬");
    }

    /**
     * 子类通过覆盖的形式选择挂载钩子函数
     * @return
     */
    @Override
    protected boolean isCustomerWantsCondiments() {
        return false;
    }

    public static void main(String[] args) {
        System.out.println("制备茶");
        RefreshBeverage tea = new Tea();
        tea.prepareBeverageTemplate();
        System.out.println("茶好了");
    }
}
