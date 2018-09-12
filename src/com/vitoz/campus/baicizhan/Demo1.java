package com.vitoz.campus.baicizhan;

import java.util.Scanner;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 22:00
 * @Description: 百词斩2019年校招笔试题1
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isPrime(n));
    }
    private static boolean isPrime(int num){
        if(num<2){
            return false;
        }
        if(num == 2){
            return true;
        }
        if(num%2==0){
            return false;
        }
        for(int i = 3;i<num;i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
}
