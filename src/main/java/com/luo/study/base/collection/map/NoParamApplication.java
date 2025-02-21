package com.luo.study.base.collection.map;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author luolingyan
 * @create 2025-02-20 16:38
 */
public class NoParamApplication implements TimePerformance {
    private static NoParamApplication instance = null;
    public static final long INITIAL_DATA_SIZE = 5000000;
    public static Map<String, Integer> BIG_MAP = new HashMap<>();
    public static final Map<String, String> METHOD_MAP = new HashMap<>();
    public static final Map<String, Long> RESULT_MAP = new HashMap<>();

    private NoParamApplication(){
        METHOD_MAP.put("showMap1", "keySet()");
        METHOD_MAP.put("showMap2", "values()");
        METHOD_MAP.put("showMap3", "entrySet()");
        METHOD_MAP.put("showMap4", "iterator()");
        this.BIG_MAP = inputBigMap();
    }

    public static NoParamApplication getInstance(){
        if(instance == null){
            instance = new NoParamApplication();
        }
        return instance;
    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        //map的遍历1
        TimePerformance performance = NoParamApplication.getInstance();
        for(String key:METHOD_MAP.keySet()){
            performance.run(key);
        }
        for(Map.Entry<String, Long> entry:RESULT_MAP.entrySet()){
            System.out.println(String.format("%s方法执行遍历时间为：%d毫秒", entry.getKey(), entry.getValue()));
        }

    }

    /**
     * 代码分析
     * HashMap的遍历方法中，哪种方法最好
     * which one is the best
     * keySet()
     * values()
     * entrySet()
     * iterator()
     * 建议
     * 如果是以MAP的Value输出为依据的话，建议使用values()或iterator()方法
     * 建议多使用iterator()方法，避免使用keyset()方法
     * 目前在工作里面用entrySet()来遍历的概率会更高一点，用Iterator()其次
     * @param method 遍历方法名
     */
    @Override
    public void run(String method) throws InvocationTargetException, IllegalAccessException {
        long starttime = 0;
        NoParamApplication application = NoParamApplication.getInstance();
        Class clazz = application.getClass();
        Method[] methods = clazz.getMethods();
        for(Method m:methods){
            if(m.getName().equals(method)){
                starttime = System.currentTimeMillis();
                m.invoke(application, BIG_MAP);
                break;
            }
        }
        long endtime = System.currentTimeMillis();
        RESULT_MAP.put(METHOD_MAP.get(method), endtime - starttime);
    }

    public static Map<String, Integer> inputMap(){
        Map<String, Integer> userMap = new HashMap<>();
        /**
         * 实际上我们有put每存进去一个键值映射其实都是增加了一个Entry这个对象
         * 如果userMap里面put了3个键值映射那就是3个Entry
         * 存的时候存的是Entry，取的时候取的也是Entry，只不过我们不用人工的去干预不用人工的去操作Entry，
         * 由系统自己取操作next和hash
         */
        userMap.put("zhangsan3", new Integer(120));
        userMap.put("lisi", new Integer(130));
        userMap.put("wangwu", new Integer(140));
        userMap.put("zhaosi", new Integer(150));
        userMap.put("qianliu", new Integer(150));
        return userMap;
    }

    public static Map<String, Integer> inputBigMap(){
        Map<String, Integer> userMap = new HashMap<>();
        String str[] = new String[]{"a","b","d","e","f","y","u","q","h","o"};
        String key;
        Integer value;
        for(int i = 0; i < INITIAL_DATA_SIZE; i++){
            int m = (int)Math.random() * 10;
            key = String.valueOf(str[m] + i*100);
            //value没有关系，因为我们在存的时候主要是以key做为存储的
            value = i;
            userMap.put(key, value);
        }
        return userMap;
    }

    /**
     * keySet()方法遍历
     * @param userMap
     */
    public static void showMap1(Map<String, Integer> userMap){
        Integer value = 0;
       for(String key: userMap.keySet()){
           //System.out.println(key + "****" + userMap.get(key));
           value = userMap.get(key);
       }
    }

    /**
     * Map.values()方法遍历
     * @param userMap
     */
    public static void showMap2(Map<String, Integer> userMap){
        Integer value = 0;
        for(Integer v: userMap.values()){
            //System.out.println(v);
            value = v;
        }
    }

    /**
     * entrySet()方法遍历
     * @param userMap
     */
    public static void showMap3(Map<String, Integer> userMap){
        Integer value = 0;
        for(Map.Entry<String, Integer> entry: userMap.entrySet()){
            //System.out.println(entry.getKey() + "****" + entry.getValue());
            value = entry.getValue();
        }
    }

    /**
     * iterator()方法遍历
     * @param userMap
     */
    public static void showMap4(Map<String, Integer> userMap){
        Integer value = 0;
        Iterator<Map.Entry<String, Integer>> it = userMap.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String, Integer> entry = it.next();
            //System.out.println(entry.getKey() + "****" + entry.getValue());
            value = entry.getValue();
        }
    }
}
