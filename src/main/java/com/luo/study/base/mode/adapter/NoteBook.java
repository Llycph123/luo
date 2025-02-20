package com.luo.study.base.mode.adapter;

/**
 * @author luolingyan
 * @description 笔记本
 * @create 2025-02-18 11:39
 */
public class NoteBook {
    private ThreePlug plug;

    public NoteBook(ThreePlug plug){
        this.plug = plug;
    }

    /**
     * 使用插座充电
     */
    public void charge(){
        plug.powerWithThree();
    }
}
