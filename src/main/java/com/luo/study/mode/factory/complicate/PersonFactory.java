package com.luo.study.mode.factory.complicate;

/**
 * @author luolingyan
 * @description 人物的实现接口
 * @create 2025-02-18 10:17
 */
public interface PersonFactory {
    //男孩接口
    public Boy getBoy();
    //女孩接口
    public Girl getGirl();

}
