package com.luo.study.base.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author luolingyan
 * @create 2025-02-20 9:38
 * sort的前提是对象实现了Comparable接口
 */
public class Sort {
    public static void main(String[] args) {
        List<Integer> datas = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i <= 10; i++){
            int data = random.nextInt(100);
            if(!datas.contains(data)){
                datas.add(data);
                System.out.println("成功添加整数：" + data);
            }
        }
        System.out.println("---------排序前---------");
        System.out.println(datas);
        Collections.sort(datas);
        System.out.println("---------排序后---------");
        System.out.println(datas);

        List<Student> students = new ArrayList<>();
        students.add(new Student(String.valueOf(11), "小明"));
        students.add(new Student(String.valueOf(9),"小蓝"));
        students.add(new Student(String.valueOf(6), "小红"));
        students.add(new Student(String.valueOf(3), "小光"));

       /* System.out.println("---------按学生id默认排序---------");
        System.out.println("---------排序前---------");
        System.out.println(students);
        Collections.sort(students);
        System.out.println("---------排序后---------");
        System.out.println(students);*/

        System.out.println("---------按学生姓名排序---------");
        System.out.println("---------排序前---------");
        System.out.println(students);
        Collections.sort(students, new StudentComparator());
        System.out.println("---------排序后---------");
        System.out.println(students);

    }
}
