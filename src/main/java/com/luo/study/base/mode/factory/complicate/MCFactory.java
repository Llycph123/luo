package com.luo.study.base.mode.factory.complicate;

/**
 * @author luolingyan
 * @description 圣诞系列加工厂
 * @create 2025-02-18 10:18
 */
public class MCFactory implements PersonFactory{
    @Override
    public Boy getBoy() {
        return new MCBoy();
    }

    @Override
    public Girl getGirl() {
        return new MCGirl();
    }
}
