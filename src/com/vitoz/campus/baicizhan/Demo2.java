package com.vitoz.campus.baicizhan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 22:00
 * @Description: 百词斩2019年校招笔试题2
 */
public class Demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        Arrays.sort(arr);
        System.out.println(isSumOfSubArr(arr, k));
//        System.out.println(isSumOfSubArr(new int[]{1,2,4,8}, 15));
//        System.out.println(isSumOfSubArr(new int[]{1,2,4,8}, 6, 0));
    }

    /**
     *@描述  给定数组，判断其中任意多个元素之和是否等于给定k
     *@参数  [arr, k]
     *@返回值  boolean
     *@创建人  vitoz
     *@创建时间  2018/9/15
     *@修改人和其它信息
     */
    private static boolean isSumOfSubArr(int[] arr, int k){
        if (k == 0){
            return true;
        }else if (arr == null || arr.length == 0){
            return false;
        }
        int len = arr.length;
        if (len == 1){
            if (arr[0] == k){
                return true;
            }else {
                return false;
            }
        }
        int[] tmp = new int[len-1];
        for (int i=0;i<len-1;i++){
            tmp[i] = arr[i+1];
        }
        return isSumOfSubArr(tmp, k) || isSumOfSubArr(tmp, k-arr[0]);
    }

    /**
     *@描述  给定数组，判断其中任意三个元素之和是否等于给定k
     *@参数  [arr, k, ind]
     *@返回值  boolean
     *@创建人  vitoz
     *@创建时间  2018/9/15
     *@修改人和其它信息
     */
    private static boolean isSumOfSubArr(int[] arr, int k, int ind){
        if (ind == 3){
            if (k == 0){
                for (int i=0;i<arr.length;i++){
                    System.out.println();
                }
            }
            return k==0;
        }
        if (k == 0 || arr == null || arr.length ==0){
            return false;
        }
        int len = arr.length;
        if (len == 1){
            if (arr[0] == k && ind == 2){
                return true;
            }else {
                return false;
            }
        }
        int[] tmp = new int[len-1];
        for (int i=0;i<len-1;i++){
            tmp[i] = arr[i+1];
        }
        return isSumOfSubArr(tmp, k, ind) || isSumOfSubArr(tmp, k-arr[0], ind+1);
    }
}
