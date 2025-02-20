package com.luo.study.practice.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author luolingyan
 * @create 2025-02-20 9:45
 * 生成10个长度在10以内的随机字符串，并进行排序
 */
public class SortApp {
    public static void main(String[] args) {
        List<String> elements = new ArrayList<>();
        /**
         * 最佳实践
         * 对于大多数情况，推荐使用ThreadLocalRandom，因为它既简单又高效，特别是在多线程环境中。如果你不需要考虑多线程的情况，那么使用Random类也是可以的。
         * 不过，请注意，在多线程环境中，最好避免使用全局的Random实例，而是为每个线程创建一个新的实例或者使用ThreadLocalRandom
         */
        Random random = new Random();
        for(int i = 0; i <= 10; i++){
            // 生成1到10的随机数（包含1和10）
            int length = ThreadLocalRandom.current().nextInt(1, 11);
            //int length = random.nextInt(10) + 1;
            String data = generateRandomString(length);
            if(!elements.contains(data)){
                elements.add(data);
                System.out.println("成功添加字符串：" + data);
            }
        }
        System.out.println("---------排序前---------");
        System.out.println(elements);
        Collections.sort(elements);
        System.out.println("---------排序后---------");
        System.out.println(elements);
    }

    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }
}
