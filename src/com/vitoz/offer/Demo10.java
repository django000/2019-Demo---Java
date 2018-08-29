package com.vitoz.offer;

/**
 * Created by zhengwentao on 2018/8/29.
 */
public class Demo10 {
    public static void main(String[] args) {
        System.out.println(getFibonacci(10));
    }

    public static long getFibonacci(int n){
        if (n < 2){
            return n>0?n:0;
        }
        long fibFirst = 0;
        long fibSecond = 1;
        long fibResult = 0;
        for (int i=2; i<=n;i++){
            fibResult = fibFirst+fibSecond;
            fibFirst = fibSecond;
            fibSecond = fibResult;
        }
        return fibResult;
    }
}
