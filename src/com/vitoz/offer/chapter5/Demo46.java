package com.vitoz.offer.chapter5;

/**
 * @Auther: vitoz
 * @Date: 2018/10/19 16:03
 * @Description: 剑指offer面试题46——把数字翻译成字符串
 */
public class Demo46 {
    public static void main(String[] args) {
        int n = 12258;
        System.out.println(getTranslationCount(n));
    }

    private static int getTranslationCount(int n){
        if (n < 0){
            return 0;
        }
        char[] num = String.valueOf(n).toCharArray();
        int len = num.length;
        int[] count = new int[len];
        count[0] = 1;
        for (int i=1;i<len;i++){
            count[i] = count[i-1];
            int tmp = (num[len-1-i]-'0')*10+(num[len-i]-'0');
            if (tmp >= 10 && tmp <=25){
                if (i>1){
                    count[i] += count[i-2];
                }else {
                    count[i] += 1;
                }
            }
        }
        return count[len-1];
    }
}
