package com.luo.study.base.mode.responsibility.handler;

/**
 * @author luolingyan
 * @description
 * @create 2025-02-18 15:06
 */
public class PriceHandlerFactory {
    /**
     * 创建PriceHandler的工厂方法
     * @return
     */
    public static PriceHandler createPriceHandler() {
        PriceHandler sales = new Sales();
        PriceHandler lead = new Lead();
        PriceHandler manager = new Manager();
        PriceHandler director = new Director();
        PriceHandler vicePresident = new VicePresident();
        PriceHandler ceo = new CEO();

        sales.setSuccessor(lead);
        lead.setSuccessor(manager);
        manager.setSuccessor(director);
        director.setSuccessor(vicePresident);
        vicePresident.setSuccessor(ceo);

        return sales;
    }
}
