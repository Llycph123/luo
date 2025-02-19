package com.luo.study.mode.proxy.custom;
import java.lang.reflect.Method;
public class $Proxy0 implements com.luo.study.mode.proxy.custom.MoveAble{
    private InvocationHandler h;
    public $Proxy0(InvocationHandler h){
        this.h = h;
    }
    @Override
    public void move() {
        try{
        Method md = com.luo.study.mode.proxy.custom.MoveAble.class.getMethod("move");
        h.invoke(this, md);
        }catch(Exception e){e.printStackTrace();}
    }
}