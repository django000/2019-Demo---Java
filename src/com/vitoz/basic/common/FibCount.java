package com.vitoz.basic.common;

import java.util.ArrayList;

public class FibCount {
    public static void main(String[] args) {
        int n = 70;
        System.out.println(getFibCount(n));
    }
    /**
     *@描述  获取小于n的所有fib数
     *@参数  [n]
     *@返回值  java.util.ArrayList<java.lang.Integer>
     *@创建人  vitoz
     *@创建时间  2018/9/23
     *@修改人和其它信息
     */
    private static ArrayList<Integer> getFibs(int n){
        ArrayList<Integer> fibs = new ArrayList<Integer>();
        int fib1 = 1;
        int fib2 = 1;

        fibs.add(fib1);
        fibs.add(fib2);

        int fibn;
        while((fibn = fib1 + fib2) <= n)
        {
            fibs.add(fibn);
            fib1 = fib2;
            fib2 = fibn;
        }
        return fibs;
    }

    /**
     *@描述  贪心算法,每次贪心选择最靠近
     *@参数  [fibs, n]
     *@返回值  int
     *@创建人  vitoz
     *@创建时间  2018/9/23
     *@修改人和其它信息
     */
    private static int dp(ArrayList<Integer> fibs, int n){
        int currentSum = 0;
        int count = 0;
        for(int i = fibs.size()-1; i >= 0&&currentSum!=n; i--){
            while (currentSum<=n){
                currentSum += fibs.get(i);
                count++;
            }
            currentSum -= fibs.get(i);
            count--;//选择的fib数相加之后越过了n，因此不能选择它
        }
        return count;
    }

    /**
     *@描述  给定数字n，给出最少可以由多少个fib数字累加等于n
     *@参数  [n]
     *@返回值  int
     *@创建人  vitoz
     *@创建时间  2018/9/23
     *@修改人和其它信息
     */
    private static int getFibCount(int n){
        ArrayList<Integer> fibs = getFibs(n);
        return dp(fibs, n);
    }
}
