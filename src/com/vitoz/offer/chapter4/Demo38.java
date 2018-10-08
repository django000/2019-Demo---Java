package com.vitoz.offer.chapter4;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 15:04
 * @Description: 剑指offer面试题38——打印字符串的所有排列
 */
public class Demo38 {
    public static void main(String[] args) {
        String str = "abcd";
        permutation(str);
    }

    private static void permutation(String str){
        if (str == null || str.length() == 0){
            return;
        }
        permutation(str.toCharArray(), 0);
    }

    /**
     * @Author zhengwentao
     * @Description 递归调用，设置递归结束条件即可（注意每次调换后要恢复位置以便下一次调换）
     * @Date 2018/10/8 11:44
     * @Param [arr, pos, len]
     * @return void
     **/
    private static void permutation(char[] arr, int pos){
        if (pos == arr.length-1){
            System.out.println(new String(arr));
        }else {
            for (int i=pos;i<arr.length;i++){
                swap(arr, pos, i);
                permutation(arr, pos+1);
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
