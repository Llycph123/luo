package com.luo.study.mode.factory.simple;

import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author luolingyan
 * @description 发型工厂，帮我们统一管理发型的生成
 * @create 2025-02-18 9:12
 */
public class HairFactory {
    /**
     * 根据类型来创建对象
     * @return
     */
    public HairInterface getHair(String key){
        /**
         * 不能智能根据发型的类型自动帮我们创建
         * 在java里面有一种机制叫做反射
         * 类的反射可以根据类的名称来创建实例（对象），我们spring里面的beanfactory其实就是根据类的反射原理来的
         */
        if("left".equals(key)){
            return new LeftHair();
        }else if("right".equals(key)){
            return new RightHair();
        }
        return null;
    }

    public HairInterface getHairByClass(String className){
        try {
            /**
             * 这样实现的好处：如果我们再增加发型，只要新建类就好，不需要改代码
             */
            HairInterface hair = (HairInterface) Class.forName(className).newInstance();
            return hair;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HairInterface getHairByClassKey(String key){
        try {
            Map<String, String> map = new PropertiesReader().getProperties();
            String className = map.get(key);
            if(!StringUtils.isEmpty(className)){
                /**
                 * 这样实现的好处：如果我们再增加发型，只要新建类就好，不需要改代码
                 */
                HairInterface hair = (HairInterface) Class.forName(className).newInstance();
                return hair;
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
