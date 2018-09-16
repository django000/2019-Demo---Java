package com.vitoz;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 22:00
 * @Description: 剑指offer面试题
 */
public class Test {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(3);
        set.add(2);
        set.add(0);
        set.add(4);
        set.add(5);
        set.add(-1);
        set.add(1);

        for (Integer integer: set){
            System.out.print(integer+" ");
        }
    }
}
