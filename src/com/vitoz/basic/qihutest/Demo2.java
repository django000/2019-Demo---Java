package com.vitoz.basic.qihutest;

import java.util.HashSet;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        HashSet<Integer> set;
        int[][] res = new int[n][n];
        for (int i=0;i<n;i++){
            set = new HashSet<>(m);
            for (int j=i;j<n;j++){
                set.add(arr[j]);
                res[i][j] = set.size();
            }
        }

        int q = sc.nextInt();
        int l, r;
        for (int i=0;i<q;i++){
            l = sc.nextInt();
            r = sc.nextInt();
            if (r<l){
                System.out.println(0);
            }else if (r==l){
                System.out.println(1);
            }else{
                System.out.println(res[l-1][r-1]);
            }
        }

    }
}
