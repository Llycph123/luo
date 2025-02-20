package com.luo.study.base.mode.responsibility.handler;

/**
 * @author luolingyan
 * @description CEO，可以批准55%以内的折扣，折扣超出55%，就拒绝申请
 * @create 2025-02-18 14:38
 */
public class CEO extends PriceHandler{
    @Override
    public void processDiscount(float discount) {
        if(discount <= 0.55){
            System.out.format("%s批准了折扣：%.4f%n", this.getClass().getName(),discount);
        }else{
            System.out.format("%s拒绝了折扣：%.4f%n", this.getClass().getName(),discount);
        }
    }
}
