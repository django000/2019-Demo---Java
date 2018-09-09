package com.vitoz.campus.eastmoney;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        doTowers(n, "left", "mid", "right");
    }

    private static void doTowers(int topN, String from, String inter, String to){
        if (topN == 1){
            System.out.println("move from ["+from +"] to ["+to+"]");
        }else {
            doTowers(topN-1, from, to, inter);
            System.out.println("move from ["+from +"] to ["+to+"]");
            doTowers(topN-1, inter, from, to);
        }
    }
}
