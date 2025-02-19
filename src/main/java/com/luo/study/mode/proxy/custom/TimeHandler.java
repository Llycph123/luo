package com.luo.study.mode.proxy.custom;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author luolingyan
 * @create 2025-02-19 17:53
 */
public class TimeHandler implements InvocationHandler{
    private Object target;

    public TimeHandler(Object target){
        super();
        this.target = target;
    }

    @Override
    public void invoke(Object o, Method m) throws InvocationTargetException, IllegalAccessException {
        long starttime = System.currentTimeMillis();
        System.out.println("汽车开始行驶");
        m.invoke(target);
        long endtime = System.currentTimeMillis();
        System.out.println("汽车结束行驶……，汽车行驶时间："+(endtime-starttime)+"毫秒");
    }
}
