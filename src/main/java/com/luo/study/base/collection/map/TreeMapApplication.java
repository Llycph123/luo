package com.luo.study.base.collection.map;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author luolingyan
 * @create 2025-02-21 13:00
 * 默认是按key升序排序，如果要按照降序，需要自定义比较器Comparator
 * 在compare方法中进行定义
 */
public class TreeMapApplication {
    public static void main(String[] args) {
        Map<String, String> treeMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //降序排序
                return o2.compareTo(o1);
            }
        });
        treeMap.put("tx", "88");
        treeMap.put("ax", "88");
        treeMap.put("bx", "88");
        treeMap.put("yx", "88");
        treeMap.put("cx", "88");
        treeMap.put("abx", "88");
        treeMap.put("ox", "88");
        treeMap.put("rs", "88");
        System.out.println(treeMap);
    }

}
