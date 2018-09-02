package com.vitoz.offer.chapter4;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 15:04
 * @Description: 剑指offer面试题38——打印字符串的所有排列
 */
public class Demo38 {
    public static void main(String[] args) {
        String str = "abc";
        permutation(str);
    }

    private static void permutation(String str){
        if (str == null || str.length() == 0){
            return;
        }
        char[] arr = str.toCharArray();
        permutation(arr, 0, arr.length);
    }

    // 递归调用，设置递归结束条件即可（注意每次调换后要恢复位置以便下一次调换）
    private static void permutation(char[] arr, int pos, int len){
        if (arr == null || pos < 0 || pos >= arr.length || len != arr.length){
            return;
        }
        if (pos == len-1){
            System.out.println(new String(arr));
        }else {
            for (int i=pos;i<len;i++){
                swap(arr, pos, i);
                permutation(arr, pos+1, len);
                swap(arr, pos, i);
            }
        }
    }

    private static void swap(char[] arr, int i, int j){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
