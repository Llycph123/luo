package com.luo.study.mode.Strategy;

/**
 * @author luolingyan
 * @description
 * @create 2025-02-17 10:53
 */
public class Client {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        LoginStrategyManager loginStategyManager = LoginStrategyManager.getInstance();
        System.out.println(LoginEnum.QQ.name());
        LoginStrategy loginStrategy = loginStategyManager.getLoginStrategy(LoginEnum.QQ.name());
        loginStrategy.verify();
        loginStrategy = loginStategyManager.getLoginStrategy(LoginEnum.Dingding.name());
        loginStrategy.verify();
    }
}
