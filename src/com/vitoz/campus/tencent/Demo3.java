package com.vitoz.campus.tencent;

import java.util.Scanner;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 22:00
 * @Description: 腾讯笔试题3
 */
public class Demo3 {
    private static int x0, y0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int a, b, c, d;
        for (int i=0;i<t;i++){
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            d = gcd(a,b);
            if(c%d!=0){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }

        }
    }
    public static int gcd(int a, int b) {
        int t, d;
        if (b == 0) {
            x0 = 1;
            y0 = 0;
            return a;
        }
        d = gcd(b, a % b);
        t = x0;
        x0 = y0;
        y0 = t - a / b * y0;
        return d;
    }
}
