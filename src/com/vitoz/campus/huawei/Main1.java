package com.vitoz.campus.huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: vitoz
 * @Date: 2018/10/13 18:58
 * @Description:
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i=0;i<t;i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            printOutNum(n, m);
        }
    }

    public static void printOutNum(int totalNum, int countNum) {
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= totalNum; i++) {
            list.add(i);
        }
        int k = 0;
        while (list.size() >0) {
            k += countNum;
            k = k % (list.size()) - 1;
            if (k < 0) {
                sb.append(list.get(list.size()-1)+" ");
                list.remove(list.size() - 1);
                k = 0;
            } else {
                sb.append(list.get(k)+" ");
                list.remove(k);
            }
        }
        System.out.println(sb.toString().trim());
    }
}
