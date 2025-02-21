package com.luo.study.base.collection.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author luolingyan
 * @create 2025-02-21 12:37
 */
public class LinkedHashApplication {
    public static void main(String[] args) {
        //按录入顺序输出 双向链表
        //Map<String, String> linkedMap = new LinkedHashMap<>();
        //按使用顺序
        Map<String, String> linkedMap = new LinkedHashMap<String, String>(16,0.75f,true);
        linkedMap.put("y1","xx");
        linkedMap.put("m1","xx");
        linkedMap.put("k1","xx");
        linkedMap.put("n1","xx");
        System.out.println(linkedMap);

        //已经使用过的排到了后面
        linkedMap.get("m1");
        linkedMap.get("y1");
        System.out.println(linkedMap);
    }
}
