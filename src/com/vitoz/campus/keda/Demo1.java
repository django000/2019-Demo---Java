package com.vitoz.campus.keda;

import java.util.Arrays;
import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n, x;
        for(int i=0;i<t;i++){
            n = sc.nextInt();
            x = sc.nextInt();
            int[] arr = new int[n];
            for (int j=0;j<n;j++){
                arr[j] = sc.nextInt();
            }
            System.out.println(getMinNumber(arr, x));
        }
    }

    private static int getMinNumber(int[] arr, int x){
        int count = 0;
        int len = arr.length;
        Arrays.sort(arr);
        while (getSum(arr) < x*len){
            arr[count++] = 100;
        }
        return count;
    }

    private static long getSum(int[] arr){
        int len = arr.length;
        long sum = 0;
        for (int i=0;i<len;i++){
            sum += arr[i];
        }
        return sum;
    }
}
