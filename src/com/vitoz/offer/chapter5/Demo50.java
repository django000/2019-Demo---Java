package com.vitoz.offer.chapter5;

import java.util.HashMap;

/**
 * @Auther: vitoz
 * @Date: 2018/9/3 00:16
 * @Description: 剑指offer面试题50——第一个只出现一次的字符
 */
public class Demo50 {
    public static void main(String[] args) {
        String str = "aeaccbdff";
        System.out.println(getFirstNotRepeatingChar(str));
        System.out.println(getFirstNotRepeatingChar2(str));
    }

    /**
     *@描述  对于给定输入字符串，利用HashMap求出第一次只出现一次的字符，无则返回null
     *@参数  [输入字符串]
     *@返回值  java.lang.Character
     *@创建人  vitoz
     *@创建时间  2018/9/3
     *@修改人和其它信息
     */
    private static Character getFirstNotRepeatingChar(String str){
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

    /**
     *@描述  既然是字符，那么定义256长度的字符数组来作为简单的哈希表即可（只能存放ASCII码内的字符）
     *@参数  [str]
     *@返回值  char
     *@创建人  vitoz
     *@创建时间  2018/10/20
     *@修改人和其它信息
     */
    private static char getFirstNotRepeatingChar2(String str){
        if (str == null || str.length() == 0){
            return '\u0000';
        }
        char[] chars = str.toCharArray();
        int[] hashTable = new int[256];
        for (int i=0;i<chars.length;i++){
            hashTable[chars[i]]++;
        }
        for (int i=0;i<chars.length;i++){
            if (hashTable[chars[i]] == 1){
                return chars[i];
            }
        }
        return '\u0000';
    }
}
