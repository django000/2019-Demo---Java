package com.vitoz.campus.dianxin;

import java.util.Scanner;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 22:00
 * @Description: 电信笔试题2
 */
public class Demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] res = new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (i == 0 && j == 0){
                    res[i][j] = arr[i][j];
                }else if (i > 0 && j == 0){
                    res[i][j] = res[i-1][j]+arr[i][j];
                }else if (i == 0 && j > 0){
                    res[i][j] = res[i][j-1]+arr[i][j];
                }else {
                    res[i][j] = Math.min(res[i][j-1], res[i-1][j]) + arr[i][j];
                }
            }
        }
        System.out.println(res[m-1][n-1]);
    }
}
