package com.luo.study.base.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luolingyan
 * @create 2025-02-21 11:06
 * 1、putIfAbsent put
 * 2、replace
 * 3、remove clear
 * 4、containsKey containsValue
 */
public class GeneralApplication {
    public static void main(String[] args) {
        Map<String, Integer> userMap = new HashMap<>();
        userMap.put("zhangsan3", new Integer(120));
        userMap.put("lisi", new Integer(130));
        userMap.put("wangwu", new Integer(140));
        userMap.put("zhaosi", new Integer(150));
        userMap.put("qianliu", new Integer(150));
        boolean isNull = userMap.isEmpty();
        System.out.println(isNull);
        userMap.remove("lisi");
        //userMap.remove("lisi", new Integer(130));
        //userMap.clear();
        System.out.println(userMap);
        System.out.println(userMap.containsKey("lisi"));
        /**
         * 替换 比较复杂
         * 纯粹更新建议使用replace
         * 如何避免本意是增加却做了更新
         */
        //userMap.replace("wangwu", 999);
        userMap.replace("wangwu", 222, 666);
        userMap.put("x", 999);
        /*if(!userMap.containsKey("x")){
            userMap.put("x", 888);
        }*/
        userMap.putIfAbsent("x", 666);//x不存在则进行put
        //System.out.println(userMap);
        //lambda表达式
        userMap.forEach((key, value)-> System.out.println(String.format("%s：%s", key, value))) ;
        userMap.forEach((key, value)-> {
            System.out.println(String.format("%s：%s", key, value));
        }) ;
        //getOrDefault(key, defaultvalue) 如果要找的key存在就输出，如果不存在则输出默认值
        System.out.println(userMap.getOrDefault("wangwu", 123));
    }
}
