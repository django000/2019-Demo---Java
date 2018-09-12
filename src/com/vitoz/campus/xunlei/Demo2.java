package com.vitoz.campus.xunlei;

import java.util.Scanner;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 22:00
 * @Description: 迅雷2019校招后台开发笔试题2
 */
public class Demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i=1;i<=n;i++){
            for (int j=i;j<=n;j++){
                for (int k=j;k<=n;k++){
                    if (isGougu(i,j,k) && isThreePrime(i,j,k)){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static boolean isThreePrime(int a, int b, int c){
        return isTwoPrime(a, b) && isTwoPrime(b, c) && isTwoPrime(a, c);
    }
    private static boolean isTwoPrime(int a, int b){
        int tmp;
        while (b!=0){
            tmp = a%b;
            a = b;
            b = tmp;
        }
        return a == 1;
    }
    private static boolean isGougu(int a, int b, int c){
        return a*a+b*b==c*c;
    }
}
