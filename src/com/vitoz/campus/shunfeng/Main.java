package com.vitoz.campus.shunfeng;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 22:00
 * @Description: 顺丰笔试题2
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[] J = new int[N];
        int[] F = new int[N];
        HashMap<Double, Integer> map = new HashMap<>(N);
        TreeSet<Double> set = new TreeSet<Double>();
        Double tmp, profit = 0.0;
        for (int i=0;i<N;i++){
            J[i] = sc.nextInt();
            F[i] = sc.nextInt();
            tmp = 1.0*J[i]/F[i];
            map.put(tmp, i);
            set.add(tmp);
        }
        Integer index;
        while (M > 0){
            tmp = set.pollLast();
            if (tmp == null){
                break;
            }
            index = map.get(tmp);
            if (M > F[index]){
                profit += J[index];
                M -= F[index];
            }else {
                profit += tmp*M;
                M = 0;
            }
        }
        System.out.println(String.format("%.3f", profit));
    }
}
