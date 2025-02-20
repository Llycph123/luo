package com.luo.study.base.collection;

import java.util.Comparator;

/**
 * @author luolingyan
 * @create 2025-02-20 10:29
 */
public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
