package com.luo.study.base.mode.factory.complicate;

/**
 * @author luolingyan
 * @description 元旦系列加工厂
 * @create 2025-02-18 10:18
 */
public class HNFactory implements PersonFactory{
    @Override
    public Boy getBoy() {
        return new HNBoy();
    }

    @Override
    public Girl getGirl() {
        return new HNGirl();
    }
}
