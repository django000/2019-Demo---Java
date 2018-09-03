package com.vitoz.campus.keeptest;

public class Demo3 {
    public static void main(String[] args) {
        String str = "1234";
        int k = 4;
        System.out.println(getDivisionNum(str, k));
    }

    private static int getDivisionNum(String str, int k){
        if (str == null || str.length() == 0){
            return 0;
        }
        int count = 0;
        int len = str.length();
        int num = (int)Math.pow(2, len);
        for (int i=1;i<num;i++){
            if ((Integer.parseInt(getSubStr(str, i, len)) & (k-1)) == 0){
                count++;
            }
        }
        return count;
    }

    private static String getSubStr(String str, int num, int len){
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<len;i++){
            int flag = num & 1;
            if (flag == 1){
                builder.append(str.charAt(len-1-i));
            }
            num >>>= 1;
        }
        return builder.reverse().toString();
    }
}
