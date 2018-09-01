package com.vitoz.offer.chapter3;

/**
 * Created by zhengwentao on 2018/8/31.
 */
public class Demo19 {
    public static void main(String[] args) {
        String str = "abdgff";
        String pat = "ab.gf*";
        System.out.println(strIsMatch(str.toCharArray(),pat.toCharArray()));
    }

    private static boolean strIsMatch(char[] str, char[] pat){
        if (str == null || str.length == 0 || pat == null || pat.length == 0){
            return false;
        }
        return strIsMatchCore(str, 0, pat, 0);
    }

    private static boolean strIsMatchCore(char[] str, int strInd, char[] pat, int patInd){
        int strLen = str.length;
        int patLen = pat.length;
        //字符串和模式都已操作完，返回true
        if (strInd >= strLen && patInd >= patLen){
            return true;
        }
        //字符串没有操作完，模式操作完，返回false
        if (strInd < strLen && patInd >= patLen){
            return false;
        }
        //字符串操作完，模式没有操作完
        if (strInd >= strLen && patInd < patLen){
            if (patInd+1 < patLen && pat[patInd+1] == '*'){
                return strIsMatchCore(str, strInd, pat, patInd+2);
            }else {
                return false;
            }
        }
        /**
         * 字符串没有操作完，模式没有操作完
         */
        //如果模式的下一个字符为*
        if (patInd+1 < patLen && pat[patInd+1] == '*'){
            //字符串和模式的当前字符能够匹配
            if (str[strInd] == pat[patInd]){
                return strIsMatchCore(str, strInd, pat, patInd+2)
                        || strIsMatchCore(str, strInd+1, pat, patInd+2)
                        || strIsMatchCore(str, strInd+1, pat, patInd);
            }else {
                return strIsMatchCore(str, strInd, pat, patInd+2);
            }
        }
        //如果模式的下一个字符不为*
        else if (str[strInd] == pat[patInd] || pat[patInd] == '.'){
            return strIsMatchCore(str, strInd+1, pat, patInd+1);
        }
        return false;
    }
}
