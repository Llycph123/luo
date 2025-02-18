package com.luo.study.mode.responsibility.handler;

/**
 * @author luolingyan
 * @description 销售小组长，可以批准15%以内的折扣
 * @create 2025-02-18 15:01
 */
public class Lead extends PriceHandler{
    @Override
    public void processDiscount(float discount) {
        if(discount <= 0.15){
            System.out.format("%s批准了折扣：%.4f%n", this.getClass().getName(),discount);
        }else{
            successor.processDiscount(discount);
        }
    }
}
