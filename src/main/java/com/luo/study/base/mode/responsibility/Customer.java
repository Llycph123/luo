package com.luo.study.base.mode.responsibility;

import com.luo.study.base.mode.responsibility.handler.PriceHandler;
import com.luo.study.base.mode.responsibility.handler.PriceHandlerFactory;

import java.util.Random;

/**
 * @author luolingyan
 * @description 客户，请求折扣
 * @create 2025-02-18 14:43
 */
public class Customer {
    private PriceHandler priceHandler;

    public void requestDiscount(float discount){
        priceHandler.processDiscount(discount);
    }

    public void setPriceHandler(PriceHandler priceHandler) {
        this.priceHandler = priceHandler;
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setPriceHandler(PriceHandlerFactory.createPriceHandler());
        Random rand = new Random();
        for(int i = 0; i <= 10; i++){
            System.out.print(i + ":");
            customer.requestDiscount(rand.nextFloat());
        }
    }
}
