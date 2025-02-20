package com.luo.study.base.mode.factory.complicate;

/**
 * @author luolingyan
 * @description
 * @create 2025-02-18 10:23
 */
public class Tony {
    public static void main(String[] args) {
        PersonFactory factory = new HNFactory();
        Boy boy = factory.getBoy();
        boy.drawMan();
    }
}

