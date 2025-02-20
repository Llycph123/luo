package com.luo.study.base.mode.adapter;

/**
 * @author luolingyan
 * @description
 * @create 2025-02-18 11:40
 */
public class Client {
    public static void main(String[] args) {
        GBTwoPlug two = new GBTwoPlug();
        ThreePlug three = new TwoPlugAdapter(two);
        NoteBook nb = new NoteBook(three);
        nb.charge();

        three = new TwoPlugAdapterExt();
        nb.charge();
    }
}
