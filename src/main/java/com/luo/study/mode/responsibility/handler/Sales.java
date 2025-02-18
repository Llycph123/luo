package com.luo.study.mode.responsibility.handler;

/**
 * @author luolingyan
 * @description 销售，可以批准5%以内的折扣
 * @create 2025-02-18 14:34
 */
public class Sales extends PriceHandler{
    @Override
    public void processDiscount(float discount) {
        if(discount <= 0.05){
            System.out.format("%s批准了折扣：%.4f%n", this.getClass().getName(),discount);
        }else{
            successor.processDiscount(discount);
        }
    }
}
