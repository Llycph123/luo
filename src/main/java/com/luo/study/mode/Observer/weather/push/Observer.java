package com.luo.study.mode.Observer.weather.push;

/**
 * @author luolingyan
 * @description 这是一个观察者接口，定义一个更新的接口给那些在目标发生改变的时候被通知的对象
 * @create 2025-02-17 14:50
 */
public interface Observer {

    /**
     * 更新的接口
     * @param content 传入目标对象，方便获取相应的目标对象的状态
     */
    void update(String content);
}
