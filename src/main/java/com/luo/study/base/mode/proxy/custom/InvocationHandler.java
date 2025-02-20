package com.luo.study.base.mode.proxy.custom;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author luolingyan
 * @create 2025-02-19 17:52
 */
public interface InvocationHandler {
    public void invoke(Object o, Method m) throws InvocationTargetException, IllegalAccessException;
}
