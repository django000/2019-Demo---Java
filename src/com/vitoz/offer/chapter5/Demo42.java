package com.vitoz.offer.chapter5;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 22:00
 * @Description: 剑指offer面试题42——求连续子序列的最大值
 */
public class Demo42 {
    public static void main(String[] args) {
        int[] arr = {1,-2,3,10,-4,7,2,-5};
        System.out.println(getMaxSumOfSubArr(arr));
        System.out.println(getMaxSumOfSubArrDP(arr));
    }

    /**
     *@描述  以空间换时间，复杂度O(n)
     *@参数  [输入数组]
     *@返回值  int
     *@创建人  vitoz
     *@创建时间  2018/9/2
     *@修改人和其它信息
     */
    private static int getMaxSumOfSubArr(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int len = arr.length;
        int tmpSum = 0;
        int maxSum = 0;
        for (int i=0;i<len;i++){
            tmpSum += arr[i];
            if (tmpSum > maxSum){
                maxSum = tmpSum;
            }
            if (tmpSum < 0){
                tmpSum = 0;
            }
        }
        return maxSum;
    }

    /**
     *@描述  动态规划算法sum(j) = max(sum(j-1)+aj , aj)，同时设置变量记录总体最大子序列和，复杂度O(n)
     *@参数  [输入数组]
     *@返回值  int
     *@创建人  vitoz
     *@创建时间  2018/9/2
     *@修改人和其它信息
     */
    private static int getMaxSumOfSubArrDP(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int len = arr.length;
        int tmpSum = 0;
        int maxSum = 0;
        int begin = 0;
        int pos = 0;
        for (;pos<len;pos++){
            if (tmpSum > 0){
                tmpSum += arr[pos];
            }else {
                tmpSum = arr[pos];
                begin = pos;
            }
            if (tmpSum > maxSum){
                maxSum = tmpSum;
            }
        }
        System.out.println("the max sum of the sub-array is " + maxSum + " from index("+begin+") to ("+pos+")");
        return maxSum;
    }
}
