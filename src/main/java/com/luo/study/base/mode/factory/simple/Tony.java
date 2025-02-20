package com.luo.study.base.mode.factory.simple;

/**
 * @author luolingyan
 * @description 模拟客户端实现
 * @create 2025-02-18 9:09
 */
public class Tony {
    public static void main(String[] args) {
      /*  //这样的代码是有缺陷的，我们每来一个新的发型就要new一个新的hair，而且我们要在客户端显示调用，这样的代码不利于维护和管理
        HairInterface left = new LeftHaire();
        left.draw();*/

       /* HairFactory factory = new HairFactory();
        HairInterface left = factory.getHair("left");
        left.draw();*/

        /*HairFactory factory = new HairFactory();
        HairInterface left = factory.getHairByClass("com.luo.study.base.mode.factory.simple.LeftHaire");
        left.draw();*/

        HairFactory factory = new HairFactory();
        HairInterface left = factory.getHairByClassKey("in");
        left.draw();
    }
}
