package com.vitoz.campus.bytedance;

import java.util.Scanner;

/**
 * @Auther: vitoz
 * @Date: 2018/10/8 19:11
 * @Description: 头条笔试题1
 */
public class Main1 {
    private static int count = 0;
    private static int a, b;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        int k = sc.nextInt();
        int[] numArr = new int[k];
        getNumOfLucky(numArr, 0);
        System.out.println(count %((int)Math.pow(10, 9)+7));
    }

    private static void getNumOfLucky(int[] arr, int pos){
        if (pos == arr.length){
            if (checkValid(arr)){
                count++;
            }
        }else {
            arr[pos] = a;
            getNumOfLucky(arr, pos+1);
            arr[pos] = b;
            getNumOfLucky(arr, pos+1);
        }
    }

    private static  boolean checkValid(int[] arr){
        boolean flag = true;
        int res = 0;
        for (int i=0;i<arr.length;i++){
            res += arr[i];
        }
        char[] sumArr = String.valueOf(res).toCharArray();
        for (int i=0;i<sumArr.length;i++){
            if (sumArr[i] != (char)(a+48) && sumArr[i] != (char)(b+48)){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
