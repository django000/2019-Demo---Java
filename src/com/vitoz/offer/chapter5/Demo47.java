package com.vitoz.offer.chapter5;

/**
 * @Auther: vitoz
 * @Date: 2018/10/19 16:27
 * @Description: 剑指offer面试题47——礼物的最大价值
 */
public class Demo47 {
    public static void main(String[] args) {
        int[][] arr = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        System.out.println(getMaxGift(arr));
    }

    private static int getMaxGift(int[][] arr){
        if (arr == null || arr.length == 0 || (arr.length == 1 && arr[0].length == 0)){
            return 0;
        }
        int rows = arr.length;
        int cols = arr[0].length;
        int[][] res = new int[rows+1][cols+1];
        for (int i=1;i<=rows;i++){
            for (int j=1;j<=cols;j++){
                res[i][j] = Math.max(res[i-1][j], res[i][j-1])+arr[i-1][j-1];
            }
        }
        return res[rows][cols];
    }
}
