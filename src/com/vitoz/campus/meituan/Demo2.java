package com.vitoz.campus.meituan;

import java.util.HashMap;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        if (t > k || k > n){
            System.out.println(0);
            return;
        }
        int count = 0;
        for (int i=0;i<=n-k;i++){
            if (isRight(arr, i, k, t)){
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isRight(int[] arr, int i, int k, int t){
        boolean flag = false;
        Integer count = 0;
        HashMap<Integer, Integer> map = new HashMap<>(k);
        for (int j=i;j<i+k;j++){
            count = map.get(arr[j]);
            map.put(arr[j], count!=null?count+1:1);
        }
        for (int j=i;j<i+k;j++){
            count = map.get(arr[j]);
            if (count >= t){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
