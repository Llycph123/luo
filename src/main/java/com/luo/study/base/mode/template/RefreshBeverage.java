package com.luo.study.base.mode.template;

/**
 * @author luolingyan
 * @description 提神饮料，抽象基类，为所有子类提供一个算法框架
 * @create 2025-02-18 21:34
 */
public abstract class RefreshBeverage {
    /**
     * 这里一定要使用final，禁止子类对算法框架做任何改变
     * 制备饮料的模板方法
     * 封装了所有子类共同遵循的算法框架
     */
    public final void prepareBeverageTemplate(){
        //步骤1 将水煮费
        boilWater();
        //步骤2 泡制饮料
        brew();
        //步骤3 倒入杯中
        pourInCup();
        if(isCustomerWantsCondiments()){
            //步骤4 加入调味料
            addCondiments();
        }

    }

    /**
     * Hook，钩子函数，提供一个默认或空的实现
     * 具体的子类可以自行决定是否挂钩以及如何挂钩
     * 询问用户是否加入调料
     * @return
     */
    protected boolean isCustomerWantsCondiments() {
        return true;
    }

    private void boilWater() {
        System.out.println("将水煮沸");
    }

    protected abstract void brew();

    private void pourInCup() {
        System.out.println("将饮料倒入杯中");
    }

    protected abstract void addCondiments();
}
