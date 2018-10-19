package com.vitoz.offer.chapter5;

/**
 * @Auther: vitoz
 * @Date: 2018/10/19 16:27
 * @Description: 剑指offer面试题48——最长不含重复字符的子字符串
 */
public class Demo48 {
    public static void main(String[] args) {
        String str = "arabcacfr";
        System.out.println(getUnrepeatableSubstring2(str));
    }

    private static int getUnrepeatableSubstring(String str){
        if (str == null || str.length() == 0){
            return 0;
        }
        int[] position = new int[26];
        for (int i=0;i<26;i++){
            position[i] = -1;
        }
        int curLength = 0;
        int maxLength = 0;
        char[] chars = str.toCharArray();
        for (int i=0;i<chars.length;i++){
            int preIndex = position[chars[i]-'a'];
            if (preIndex < 0 || i - preIndex > curLength){
                curLength++;
            }else {
                if (curLength > maxLength){
                    maxLength = curLength;
                }
                curLength = i - preIndex;
            }
            position[chars[i]-'a'] = i;
        }
        if (curLength > maxLength){
            maxLength = curLength;
        }
        return maxLength;
    }
    private static int getUnrepeatableSubstring2(String str){
        if (str == null || str.length() == 0){
            return 0;
        }
        int[] position = new int[26];
        for (int i=0;i<26;i++){
            position[i] = -1;
        }
        char[] chars = str.toCharArray();
        int[] res = new int[chars.length+1];
        for (int i=1;i<=chars.length;i++){
            int preIndex = position[chars[i-1]-'a'];
            int step = i - preIndex -1;
            if (preIndex < 0 || step > res[i-1]){
                res[i] = res[i-1] + 1;
            }else {
                res[i] = step;
            }
            position[chars[i-1]-'a'] = i-1;
        }
        int maxLength = 1;
        for (int i=1;i<res.length;i++){
            if (res[i] > maxLength){
                maxLength = res[i];
            }
        }
        return maxLength;
    }
}
