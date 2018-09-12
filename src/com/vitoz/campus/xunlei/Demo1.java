package com.vitoz.campus.xunlei;

import java.util.Scanner;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 22:00
 * @Description: 迅雷2019校招后台开发笔试题1
 */
public class Demo1 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
        int n = 10;
        int m = -61;
        int mm = Math.abs(m);
        int x = 9;
        if (mm > 6*n){
            x = 15;
        }else {
            x = 9;
        }
        System.out.println(x*n+(17-x)*m);
    }


}
