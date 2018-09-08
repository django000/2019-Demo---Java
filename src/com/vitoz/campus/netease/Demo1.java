package com.vitoz.campus.netease;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int len = getLen(str);
        System.out.println(len);
    }

    private static int getLen(String str){
        int maxLen = 0;
        char[] array = str.toCharArray();
        int len = 1;
        for (int i=1;i<array.length;i++){
            if (array[i] != array[i-1]){
                len++;
                maxLen = Math.max(len, maxLen);
            }else {
                len =1;
            }
        }
        return maxLen;
    }
}
