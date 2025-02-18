package com.luo.study.mode.adapter;

/**
 * @author luolingyan
 * @description 二相转三相的插座适配器
 * @create 2025-02-18 11:42
 */
public class TwoPlugAdapter implements ThreePlug{
    private GBTwoPlug plug;

    public TwoPlugAdapter(GBTwoPlug plug){
        this.plug = plug;
    }

    @Override
    public void powerWithThree() {
        System.out.print("通过转化");
        plug.powerWithTwo();
    }
}
