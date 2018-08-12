package com.vitoz.bxd.test01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt(),pos,len=arr.length;
        long q;
        for (int i=0; i<m; i++){
            q = sc.nextLong();
            pos = 0;
            while (pos < len){
                q -= arr[pos++];
                if (q<=0){
                    break;
                }
            }
            System.out.println(pos);
        }
    }
}
