package com.vitoz.campus.zhtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        int len = str.length();
        List<Integer> list = new ArrayList<>(len >> 1);
        for (int i=0;i<len;i++){
            if (str.charAt(i) == 'D'){
                list.add(i);
            }
        }
        len--;
        int res=0;
        for (Integer index: list){
            res += ((len--)-index);
        }
        System.out.println(res);
    }
}
