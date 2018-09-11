package com.vitoz.campus.tujia;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        Max_Min(a,b);
    }
    public static void Max_Min(int a,int b){
        int i = a;
        int j = b;
        int x =0,y =0;
        if(a < b){
            x = b;
            b = a;
            a = x;
        }
        while(b != 0){
            y = a % b;
            a = b;
            b = y;
        }
        //最小公倍数
        long t = i * (j / a);
        System.out.println(a);
        System.out.println(t);
    }
}
