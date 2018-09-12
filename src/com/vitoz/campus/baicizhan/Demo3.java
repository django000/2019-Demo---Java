package com.vitoz.campus.baicizhan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 22:00
 * @Description: 百词斩2019年校招笔试题3
 */
public class Demo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        int m;
        ArrayList<Integer> tmp;
        for (int i=0;i<n;i++){
            m = sc.nextInt();
            tmp = new ArrayList<>(m);
            for (int j=0;j<m;j++){
                tmp.add(sc.nextInt());
            }
            list.addAll(tmp);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        StringBuilder builder = new StringBuilder();
        for (Integer i: list){
            builder.append(i+" ");
        }
        System.out.println(builder.toString().trim());
    }
}
