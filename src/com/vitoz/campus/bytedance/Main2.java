package com.vitoz.campus.bytedance;

import java.util.Scanner;

/**
 * @Auther: vitoz
 * @Date: 2018/10/8 19:41
 * @Description: 头条笔试题2
 */
public class Main2 {
    private static int[] money, level;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalMoney = sc.nextInt();
        int num = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        sc.nextLine();
        while (sc.hasNextLine()){
            sb.append(sc.nextLine()+"-");
        }
        String[] tmp = sb.toString().split("-");
        int len = tmp.length;
        money = new int[len];
        level = new int[len];
        for (int i=0;i<len;i++){
            String[] str = tmp[i].split(" ");
            money[i] = Integer.parseInt(str[0]);
            level[i] = Integer.parseInt(str[1]);
        }
        System.out.print(getMaxLevel(totalMoney, 0, num));
    }

    private static int getMaxLevel(int totalMoney, int pos, int num){
        if (pos < money.length && num >0){
            if (totalMoney >= money[pos]){
                int doIt = level[pos]+getMaxLevel(totalMoney-money[pos], pos+1, num-1);
                int doNot = getMaxLevel(totalMoney, pos+1, num);
                return doIt>doNot?doIt:doNot;
            }else {
                return getMaxLevel(totalMoney, pos+1, num);
            }
        }
        return 0;
    }
}
