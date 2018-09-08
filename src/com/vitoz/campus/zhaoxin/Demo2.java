package com.vitoz.campus.zhaoxin;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min, max;
        max = min = Integer.MAX_VALUE;
        int tmp;
        while (sc.hasNextInt()){
            tmp = sc.nextInt();
            if (min > tmp){
                min = tmp;
                max = min;
            }
            if (max < tmp){
                max = tmp;
            }
        }
        System.out.println(max-min);
    }
}
