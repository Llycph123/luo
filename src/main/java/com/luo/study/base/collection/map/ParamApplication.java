package com.luo.study.base.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luolingyan
 * @create 2025-02-21 10:25
 * 1、创建10个HashMap，每个HashMap含有10万条记录
 * 2、传递不同的构造方法的参数，比较速度
 * 3、实验参数：构造方法传参(16.0.75)和(100000,0.75)即(16384,0.75)
 */
public class ParamApplication {
    public static void main(String[] args) {
        long sum = 0l;
        for(int i = 0; i < 10; i++){
            //sum += inputMap1(16, 0.75f);//1999020 第一次执行时间比较长，后面接近平均。因为java虚拟机第一次运行需要进行内存分配，以后的执行不需要分配可以直接使用
            sum += inputMap1(16384, 0.75f);//1115200
        }
        System.out.println(sum/10);//平均值计算
    }

    public static long inputMap1(int initialCapacity, float loadFactor){
        String key, value;
        Map<String, String> map = new HashMap<>(initialCapacity, loadFactor);
        long start = System.nanoTime();//纳秒
        for(int i = 0; i <10000; i++){
            key = String.valueOf(i);
            value = "value";
            map.put(key, value);
        }
        long end = System.nanoTime();
        long time = end - start;
        System.out.println(String.format("time=%d", time));
        return time;
    }
}
