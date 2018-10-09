package com.vitoz.campus.future;

import java.util.Scanner;

/**
 * @Author: vitoz
 * @Date: 2018/10/9 19:58
 * @Description:
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long l = sc.nextLong();
        long r = sc.nextLong();
        int count = 0;
        for (long i=l;i<=r;i++){
            String str = String.valueOf(i);
            if (str.charAt(0) == str.charAt(str.length()-1)){
                count++;
            }
        }
        System.out.println(count);
    }
}
