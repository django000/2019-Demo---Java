package com.vitoz.campus.bytedance;

import java.util.Scanner;

/**
 * @Auther: vitoz
 * @Date: 2018/10/8 20:19
 * @Description: 头条笔试题3
 */
public class Main3 {
    private static int count;
    private static char[] str;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] symbol;
        sc.nextLine();
        for (int i=0;i<n;i++){
            str = sc.nextLine().trim().toCharArray();
            System.out.println(str.length);
            symbol = new boolean[str.length];
            count = 0;
            getNumOfZero(symbol, 0);
            System.out.println(count);
        }
    }

    private static void getNumOfZero(boolean[] symbol, int pos){
        if (pos == symbol.length){
            if (checkValid(symbol)){
                count++;
            }
        }else {
            symbol[pos] = false;
            getNumOfZero(symbol, pos+1);
            symbol[pos] = true;
            getNumOfZero(symbol, pos+1);
        }
    }

    private static boolean checkValid(boolean[] symbol){
        int res = 0;
        for (int i=0;i<symbol.length;i++){
            if (symbol[i]){
                res += str[i] - '0';
            }else {
                res -= str[i] - '0';
            }
        }
        return res == 0;
    }
}
