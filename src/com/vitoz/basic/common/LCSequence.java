package com.vitoz.basic.common;


public class LCSequence {
    public static void main(String[] args) {
        String str1 = "BDCABA";
        String str2 = "ABCBDAB";
        System.out.println(getLCSequence(str1, str2));
    }

    /**
     *@描述  动态规划法求最长公共子序列（Longest Common Sequence），时间复杂度O(n*n)
     *@参数  [str1, str2]
     *@返回值  int
     *@创建人  vitoz
     *@创建时间  2018/9/23
     *@修改人和其它信息
     */
    private static int getLCSequence(String str1, String str2){
        if (str1 == null || str2 == null){
            return 0;
        }
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] res = new int[len1+1][len2+1];
        for (int i=1;i<=len1;i++){
            for (int j=1;j<=len2;j++){
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    res[i][j] = res[i-1][j-1]+1;
                }else if (res[i][j-1] > res[i-1][j]){
                    res[i][j] = res[i][j-1];
                }else {
                    res[i][j] = res[i-1][j];
                }
            }
        }
        return res[len1][len2];
    }
}
