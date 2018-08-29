package com.vitoz.campus.qihutest;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int xMax = Integer.MIN_VALUE, xMin=Integer.MAX_VALUE;
        int yMax = Integer.MIN_VALUE, yMin=Integer.MAX_VALUE;
        int xi, yi, max;
        for (int i=0;i<n;i++){
            xi = sc.nextInt();
            yi = sc.nextInt();
            if (xi<xMin){
               xMin = xi;
            }
            if (xi>xMax){
                xMax = xi;
            }
            if (yi<yMin){
                yMin = yi;
            }
            if (yi>yMax){
                yMax = yi;
            }
        }
        max = Math.max(yMax-yMin, xMax-xMin);
        System.out.println(max*max);
    }
}
