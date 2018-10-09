package com.vitoz.campus.future;

import java.util.Scanner;

/**
 * @Author: vitoz
 * @Date: 2018/10/9 19:38
 * @Description:
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        int t = sc.nextInt();
        int count = 0;
        long sum = 1;
        while (sum <= t){
            count++;
            sum = k*sum+b;
        }
        System.out.println(n-count+1);
    }
}
