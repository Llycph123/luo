package com.luo.study.base.mode.responsibility.handler;

/**
 * @author luolingyan
 * @description
 * @create 2025-02-18 14:40
 */
public class VicePresident extends PriceHandler{
    @Override
    public void processDiscount(float discount) {
        if(discount <= 0.5){
            System.out.format("%s批准了折扣：%.4f%n", this.getClass().getName(),discount);
        }else{
            successor.processDiscount(discount);
        }
    }
}
