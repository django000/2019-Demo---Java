package com.vitoz.basic.common;

/**
 * @Auther: vitoz
 * @Date: 2018/9/23 0:18
 * @Description:
 */
public class LISequence {
    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(getLISequence(arr));
    }

    /**
     *@描述  动态规划法求最长递增子序列（Longest Increment Sequence），时间复杂度O(n*n)
     *@参数  [arr]
     *@返回值  int
     *@创建人  vitoz
     *@创建时间  2018/9/23
     *@修改人和其它信息
     */
    private static int getLISequence(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int len = arr.length;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i=1;i<len;i++){
            for (int j=0;j<i;j++){
                if (arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }else {
                    dp[i] = dp[j];
                }
            }
        }
        return dp[len-1];
    }
}
