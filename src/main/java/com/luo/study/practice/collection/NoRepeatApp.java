package com.luo.study.practice.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author luolingyan
 * @create 2025-02-20 10:20
 * 生成3个不重复的1000以内的随机正整数做为学生ID
 */
public class NoRepeatApp {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>();
        while(numbers.size() < 3){
            int randomNumber = ThreadLocalRandom.current().nextInt(1,1001);
            numbers.add(randomNumber);
        }
        //将Set转换为数组或直接输出
        Integer[] result = numbers.toArray(new Integer[0]);
        System.out.println("generated unique random numbers:" + java.util.Arrays.toString(result));
    }
}
