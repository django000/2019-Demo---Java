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
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i=0;i<n;i++){
//            arr[i] = sc.nextInt();
//        }
//        int k = sc.nextInt();
//        Arrays.sort(arr);
//        System.out.println(isSumOfSubArr(arr, k));
        System.out.println(isSumOfSubArr(new int[]{1,2,4,8}, 16));
    }

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
//        for (int i=0;i<len;i++){
//            if (arr[i] == k){
//                return true;
//            }
//        }
//        int low = 0;
//        int high = len-1;
//        while (low < high){
//            long curSum = arr[low]+arr[high];
//            if (curSum == k){
//                return true;
//            }else if (curSum < k){
//                low++;
//            }else {
//                high--;
//            }
//        }
        int[] tmp = new int[len-1];
        for (int i=0;i<len-1;i++){
            tmp[i] = arr[i+1];
        }
        boolean b1 = isSumOfSubArr(tmp, k);
        boolean b2 = isSumOfSubArr(tmp, k-arr[0]);

        return b1 || b2;
    }
}
