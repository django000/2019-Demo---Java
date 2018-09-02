package com.vitoz.offer.chapter6;

/**
 * @Auther: vitoz
 * @Date: 2018/9/3 01:07
 * @Description: 剑指offer面试题63——获取股票最大利润
 */
public class Demo63 {
    public static void main(String[] args) {
        int[] arr = {9,11,8,5,7,12,16,14};
        System.out.println(getMaxProfit(arr));
    }

    private static int getMaxProfit(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int len = arr.length;
        int min = arr[0];
        int max = 0;
        int tmp;
        for (int i=1;i<len;i++){
            if (arr[i] < min){
                min = arr[i];
            }
            tmp = arr[i] - min;
            if (tmp > max){
                max = tmp;
            }
        }
        return max;
    }
}
