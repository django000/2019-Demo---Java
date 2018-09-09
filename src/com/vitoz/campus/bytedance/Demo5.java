package com.vitoz.campus.bytedance;

import java.util.Scanner;

public class Demo5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[][] known = new boolean[n][n];
        for (int i=0;i<n;i++){
            known[i][i] = true;
        }
        String[] ms = sc.nextLine().trim().split(" ");
        for (int i=0;i<m;i++){
            known[Integer.parseInt(ms[2*i])-1][Integer.parseInt(ms[2*i+1])-1] = true;
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                for (int k=0;k<n;k++){
                    known[j][k] = known[j][k] || (known[j][i] && known[i][k]);
                }
            }
        }
        int tmp, count = 0;
        for (int i=0;i<n;i++){
            tmp = 0;
            for (int j=0;j<n;j++){
                if (known[j][i] == false){
                    break;
                }else {
                    tmp++;
                }
            }
            if (tmp == n){
                count++;
            }
        }
        System.out.println(count);
    }
}
