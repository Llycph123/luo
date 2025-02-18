package com.luo.study.mode.responsibility.handler;

/**
 * @author luolingyan
 * @description
 * @create 2025-02-18 14:39
 */
public class Manager extends PriceHandler{
    @Override
    public void processDiscount(float discount) {
        if(discount <= 0.3){
            System.out.format("%s批准了折扣：%.4f%n", this.getClass().getName(),discount);
        }else{
            successor.processDiscount(discount);
        }
    }
}
