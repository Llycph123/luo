package com.luo.study.base.mode.decorator;

/**
 * @author luolingyan
 * @description 红包抵扣
 * @create 2025-02-17 10:23
 */
public class RedPaperDiscount extends OrderDecorator {

    public RedPaperDiscount(Order order){
        super(order);
    }

    /**
     * 抵扣10元
     * @return
     */
    @Override
    double getPrice() {
        return order.getPrice() - 10;
    }
}
