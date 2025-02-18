package com.luo.study.mode.adapter;

/**
 * @author luolingyan
 * @description 采用继承方式的插座适配器
 * @create 2025-02-18 11:54
 */
public class TwoPlugAdapterExt extends GBTwoPlug implements ThreePlug{

    @Override
    public void powerWithThree() {
        System.out.print("借助继承适配器");
        super.powerWithTwo();
    }
}
