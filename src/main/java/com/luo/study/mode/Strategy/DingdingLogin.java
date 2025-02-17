package com.luo.study.mode.Strategy;

/**
 * @author luolingyan
 * @description 钉钉登录
 * @create 2025-02-17 10:49
 */
public class DingdingLogin implements LoginStrategy{
    /**
     * 描述钉钉登录的算法
     * @return
     */
    @Override
    public boolean verify() {
        System.out.println("钉钉登录成功");
        return true;
    }
}
