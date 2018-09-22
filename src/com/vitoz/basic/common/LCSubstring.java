package com.vitoz.basic.common;


public class LCSubstring {
    public static void main(String[] args) {
        String str1 = "abcdefg";
        String str2 = "adefgwgeweg";
        System.out.println(getLCSubstring(str1, str2));
    }

    /**
     *@描述  最长公共子字符串（Longest Common Substring），时间复杂度O(n*n)
     *@参数  [str1, str2]
     *@返回值  java.lang.String
     *@创建人  vitoz
     *@创建时间  2018/9/23
     *@修改人和其它信息
     */
    private static String getLCSubstring(String str1, String str2){
        if (str1 == null || str2 == null){
            return null;
        }
        if (str1.length() < str2.length()){
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        int len2 = str2.length();
        for (int i=0;i<len2;i++){
            for (int begin=0,end=len2-i;end<=len2;begin++,end++){
                if (str1.contains(str2.substring(begin, end))){
                    return str2.substring(begin, end);
                }
            }
        }
        return null;
    }
}
