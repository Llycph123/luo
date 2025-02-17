package com.luo.study.mode.decorator;

/**
 * @author luolingyan
 * @description 代金券抵扣
 * @create 2025-02-17 10:25
 */
public class SecuritiesDiscount extends OrderDecorator{
    public SecuritiesDiscount(Order order) {
        super(order);
    }

    /**
     * 抵扣金额
     * @return
     */
    @Override
    double getPrice() {
        return order.getPrice() - 5;
    }
}
