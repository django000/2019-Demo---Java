package com.vitoz.campus.tencent;

import java.util.Scanner;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 22:00
 * @Description: 腾讯笔试题1
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int n = 4;
        long mul = 1;
        int res = n+1;
        long min = commonMultiple(n);
        long tmp;
        while (mul%min!=0){
            tmp = commonDivisor(min, (long)res);
            mul *= tmp;
            System.out.println(mul);
            res++;
        }
        System.out.println(--res);
    }

    private static long commonMultiple(int end){
        long res = 1;
        for (long i=2;i<=end;i++){
            res = commonMultiple(res, i);
        }
        return res;
    }

    private static long commonMultiple(long res, long num){
        return res*(num/commonDivisor(res, num));
    }

    private static long commonDivisor(long n, long m){
        long temp;
        while (n % m != 0) {
            temp = n % m;
            n = m;
            m = temp;
        }
        return m;
    }
}
