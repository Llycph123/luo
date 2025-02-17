package com.luo.study.mode.Strategy;

/**
 * @author luolingyan
 * @description 登录策略接口
 * @create 2025-02-17 10:46
 */
public interface LoginStrategy {
    /**
     * 登录的公共方法
     * @param code
     * @return
     */
    boolean verify();
}
