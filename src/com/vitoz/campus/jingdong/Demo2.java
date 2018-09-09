package com.vitoz.campus.jingdong;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] tmp;
        int[][] arr = new int[n][3];
        for (int i=0;i<n;i++){
            tmp = sc.nextLine().trim().split(" ");
            arr[i][0] = Integer.parseInt(tmp[0]);
            arr[i][1] = Integer.parseInt(tmp[1]);
            arr[i][2] = Integer.parseInt(tmp[2]);
        }
        int count=0;
        p:for (int j=0;j<n;j++){
            q:for (int i=0;i<n;i++){
                if (arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1] && arr[i][2] > arr[j][2]){
                    count++;
                    break q;
                }
            }
        }
        System.out.println(count);
    }
}