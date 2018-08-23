package com.vitoz.basic;

import java.util.HashMap;

public class StringUtilDemo {
    public static void main(String[] args) throws Exception {
        String str = "22334";
        System.out.println(firstCharWithMap(str));
        int[][] arr = {};
        String str1 = "java";
        String str2 = "dog";
        String str3 = "java"+str2;
        String str4 = "javadog";
        String str5 = str1+str2;
        System.out.println(str3 == "javadog");
        System.out.println(str4 == "javadog");
        System.out.println(str5 == "javadog");

    }

    public static char firstCharWithArr(String str) throws Exception{
        if (str == null || str.length()==0){
            throw new Exception("输入字符串不合理");
        }
        int[] arrInt = new int[256];
        for (int i=0;i<256;i++){
            arrInt[i] = 0;
        }
        char[] arr = str.toCharArray();
        for(int i=0;i<arr.length;i++){
            arrInt[(int)arr[i]] += 1;
        }
        for(int i=0;i<arr.length;i++){
            if (arrInt[(int)arr[i]] == 1){
                return arr[i];
            }
        }
        throw new Exception("输入字符串无只出现一次的字符");
    }

    public static char firstCharWithMap(String str) throws Exception{
        if (str == null || str.length()==0){
            throw new Exception("输入字符串不合理");
        }
        HashMap<Character, Integer> map = new HashMap<>(256);
        char[] arr = str.toCharArray();
        Integer count;
        for(int i=0;i<arr.length;i++){
            count = map.get(arr[i]);
            count = count != null?count+1:1;
            map.put(arr[i], count);
        }
        for(int i=0;i<arr.length;i++){
            if (map.get(arr[i]) == 1){
                return arr[i];
            }
        }
        throw new Exception("输入字符串无只出现一次的字符");
    }
}
