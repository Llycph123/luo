package com.luo.study.collection;

import lombok.Data;

/**
 * @author luolingyan
 * @create 2025-02-20 10:01
 */
@Data
public class Student implements Comparable<Student> {
    private String id;
    private String name;

    public Student(String id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        return this.id.compareTo(o.id);
    }
}
