package com.luo.study.base.mode.decorator;

/**
 * @author luolingyan
 * @description
 * @create 2025-02-17 10:27
 */
public class Client {
    public static void main(String[] args) {
        Order goodsOrder = new GoodsOrder();
        goodsOrder = new RedPaperDiscount(goodsOrder);
        goodsOrder = new SecuritiesDiscount(goodsOrder);
        System.out.println(goodsOrder.getPrice());
    }
}
