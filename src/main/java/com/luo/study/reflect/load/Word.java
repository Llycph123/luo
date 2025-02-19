package com.luo.study.reflect.load;

/**
 * @author luolingyan
 * @create 2025-02-18 22:58
 */
public class Word implements OfficeAble {
    private String hello;
    public static final boolean started = true;

    @Override
    public void start() {
        System.out.print("word……start……");
    }

    public Word(){

    }

    public Word(String hello){
        this.hello = hello;
    }
}
