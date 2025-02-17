package com.luo.study.mode.Strategy;

/**
 * @author luolingyan
 * @description QQ登录
 * @create 2025-02-17 10:48
 */
public class QQLogin implements LoginStrategy {

    /**
     * 描述QQ登录的算法
     * @return
     */
    @Override
    public boolean verify() {
        System.out.println("qq登录成功");
        return true;
    }
}
