package com.vitoz.offer.chapter5;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 22:00
 * @Description: 剑指offer面试题43——求1-n的整数中1出现的次数
 */
public class Demo43 {
    public static void main(String[] args) {
        int n = 21345;
        System.out.println(NumberOf1Between1AndN(n));
    }

    /**
     *@描述  输入整数n，获取1-n中整数出现1的次数
     *@参数  [n]
     *@返回值  int
     *@创建人  vitoz
     *@创建时间  2018/9/10
     *@修改人和其它信息
     */
    private static int NumberOf1Between1AndN(int n){
        if (n <=0){
            return 0;
        }
        return getNumberOf1(String.valueOf(n));
    }

    /**
     *@描述  递归实现求解对于n对应的str，求解其出现1的整数次数
     *@参数  [str]
     *@返回值  int
     *@创建人  vitoz
     *@创建时间  2018/9/10
     *@修改人和其它信息
     */
    private static int getNumberOf1(String str){
        if (str == null || str.length() == 0){
            return 0;
        }
        char first = str.charAt(0);
        int len = str.length();
        if (len == 1){
            return first>'1'?1:0;
        }
        int numberFirst = powerBase(len-1);
        if (first == '1'){
            numberFirst = Integer.parseInt(str.substring(1))+1;
        }
        int numberOthers = (first-'0')*(len-1)*powerBase(len-2);
        return numberFirst + numberOthers + getNumberOf1(str.substring(1));
    }

    /**
     *@描述  对于给定输入n，求解10**n
     *@参数  [n]
     *@返回值  int
     *@创建人  vitoz
     *@创建时间  2018/9/10
     *@修改人和其它信息
     */
    private static int powerBase(int n){
        int res = 1;
        for (int i=0;i<n;i++){
            res *= 10;
        }
        return res;
    }
}
