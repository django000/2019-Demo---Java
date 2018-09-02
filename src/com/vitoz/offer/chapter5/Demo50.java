package com.vitoz.offer.chapter5;

import java.util.HashMap;

/**
 * @Auther: vitoz
 * @Date: 2018/9/3 00:16
 * @Description: 剑指offer面试题
 */
public class Demo50 {
    public static void main(String[] args) {
        String str = "abaccdeff";
        System.out.println(getFirstOneTimeChar(str));
    }

    /**
     *@描述  对于给定输入字符串，利用HashMap求出第一次只出现一次的字符，无则返回null
     *@参数  [输入字符串]
     *@返回值  java.lang.Character
     *@创建人  vitoz
     *@创建时间  2018/9/3
     *@修改人和其它信息
     */
    private static Character getFirstOneTimeChar(String str){
        if (str == null || str.length() == 0){
            return null;
        }
        Integer tmp;
        char[] arr = str.trim().toCharArray();
        int len = arr.length;
        HashMap<Character, Integer> map = new HashMap();
        for (int i=0;i<len;i++){
            tmp = map.get(arr[i]);
            map.put(arr[i], tmp == null? 1:tmp+1);
        }
        for (int i=0;i<len;i++){
            if (map.get(arr[i]) == 1){
                return arr[i];
            }
        }
        return null;
    }
}
