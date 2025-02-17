package com.luo.study.mode.decorator;

/**
 * @author luolingyan
 * @description 抽象装饰类：订单优惠
 * @create 2025-02-17 10:20
 */
public abstract class OrderDecorator extends Order{
    protected Order order;

    public OrderDecorator(Order order){
        this.order = order;
    }

}
