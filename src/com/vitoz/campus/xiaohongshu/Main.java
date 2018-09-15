package com.vitoz.campus.xiaohongshu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 22:00
 * @Description: 小红书笔试题1
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][n];
        int tmpa, tmpb;
        int result = 1;
        for (int i=0;i<m;i++){
            tmpa = sc.nextInt()-1;
            tmpb = sc.nextInt()-1;
            arr[tmpa][tmpb] = 1;
            arr[tmpb][tmpa] = 1;
        }
        ArrayList<Integer> list;
        for (int i=0;i<n;i++){
            list = new ArrayList<>(n);
            for (int j=0;j<n;j++){
                if (arr[i][j] == 1){
                    list.add(j);
                }
            }
            int len = list.size();
            for (int j=0;j<len-1;j++){
                for (int k=j+1;k<len;k++){
                    if (arr[list.get(j)][list.get(k)] == 1){
                        result = 0;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
