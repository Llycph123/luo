package com.luo.study.base.collection.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author luolingyan
 * @create 2025-02-21 12:46
 * 模拟LRU缓存
 */
public class LRUMapApplication<K, V> extends LinkedHashMap<K, V> {
    private int maxSize;

    public LRUMapApplication(int maxSize){
        super(16, 0.75f, true);
        this.maxSize = maxSize;
    }

    /**
     * 删除最老的元素，即最近没有被使用的元素
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        //size()返回当前LinkedHashMap中的元素长度
        return size() > this.maxSize;
    }

    public static void main(String[] args) {
        Map lruMap = new LRUMapApplication(3);
        lruMap.put("x1", "00");
        lruMap.put("x2", "00");
        lruMap.put("x3", "00");
        lruMap.get("x1");
        lruMap.put("x4", "00");
        lruMap.put("x5", "00");
        System.out.println(lruMap);

    }
}
