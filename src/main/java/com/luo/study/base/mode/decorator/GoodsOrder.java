package com.luo.study.base.mode.decorator;

/**
 * @author luolingyan
 * @description 具体组件：商品订单类
 * @create 2025-02-17 10:13
 */
public class GoodsOrder extends Order {

    @Override
    double getPrice() {
        return 100;
    }
}
