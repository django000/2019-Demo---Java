package com.vitoz.campus.netease;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n, k, m;
        for (int i=0;i<t;i++){
            m = 0;
            n = sc.nextInt();
            k = sc.nextInt();
            if (n < 2*k){
                m = n-k;
            }else if(k >= 1){
                m = k-1;
            }else {
                m = 0;
            }
            System.out.println("0 "+m);
        }
    }
}
