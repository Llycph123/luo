package com.luo.study.base.mode.responsibility.handler;

/**
 * @author luolingyan
 * @description 价格处理人，负责处理客户折扣申请
 * @create 2025-02-18 14:30
 */
public abstract class PriceHandler {
    //successor:后继，直接后继，用于传递请求
    protected PriceHandler successor;

    public void setSuccessor(PriceHandler successor) {
        this.successor = successor;
    }

    /**
     * 处理折扣申请
     */
    public abstract void processDiscount(float discount);
}
