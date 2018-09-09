package com.vitoz.campus.eastmoney;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        int half = sum / 2;
        int[][] arrDP = new int[n+1][half+1];
        for (int i=0;i<n+1;i++){
            arrDP[i] = new int[half+1];
        }
        for (int i=1;i<=n;i++){
            for (int j=1;j<=half;j++){
                if (j>=arr[i-1]){
                    arrDP[i][j] = Math.max(arrDP[i-1][j], arrDP[i-1][j-arr[i-1]]+arr[i-1]);
                }else {
                    arrDP[i][j] = arrDP[i-1][j];
                }
            }
        }
        if (sum == 2*arrDP[n][half]){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
}
