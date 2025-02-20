package com.luo.study.base.mode.factory.simple;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author luolingyan
 * @description properties文件的读取类
 * @create 2025-02-18 9:29
 */
public class PropertiesReader {
    public Map<String, String> getProperties(){
        Properties props = new Properties();
        Map<String, String> map = new HashMap<String, String>();
        try {
            /**
             * getClass().getResourceAsStream()方法是用来获取某个资源文件的输入流。
             *
             *  对于类路径内的资源，例如放在src文件夹或者编译后的classes文件夹中，你应该使用斜杠/作为路径分隔符
             *  src/main/resources/example.txt
             *  InputStream inputStream = getClass().getResourceAsStream("/example.txt");
             *
             *  对于包内的资源，路径应该相对于类文件的位置
             *  com/example/resources/example.txt
             *  InputStream inputStream = getClass().getResourceAsStream("resources/example.txt");
             */
            InputStream in = getClass().getClassLoader().getResourceAsStream("type.properties");
            if (in == null) {
                System.out.println("Resource not found!");
            }else{
                props.load(in);
                Enumeration en = props.propertyNames();
                while(en.hasMoreElements()){
                    String key = (String)en.nextElement();
                    String property = props.getProperty(key);
                    map.put(key, property);
                    System.out.println(key + "" + property);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }
}
