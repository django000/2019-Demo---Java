package com.vitoz.campus.perfect;

import java.util.Scanner;
/*
* 公司年会设计了一个游戏，抽到号码的员工可以到舞台的桌子上带回总重量不超过固定重量的若干个奖品，桌子上的奖品数量是有限的，每个奖品上都标明了它的重量和价值，对于一个奖品它只能选择带走或者不带走，不能将它掰成几份带走部分，请设计实现一个算法计算当奖品数量、奖品价值、能带走的总重量取不同值时，员工能带走的最大价值是多少。
输入:
输入奖品数量，每个奖品的价值和重量，能够带走的奖品重量限度
输入第一行：奖品数量
输入第二行：每个奖品的价值，通过空格分割
输入第三行：每个奖品的重量，通过空格分割
输入第四行：能够带走的奖品总重量限度

输出:
员工能够带走的最大价值

样例输入
5
5000 4000 3000 500 200
5 4 6 3 1
10

样例输出
9200
* */
public class Demo1 {
    private static int num;
    private static int[] score;
    private static int[] time;

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        score = new int[num];
        time = new int[num];
        for (int i = 0; i < num; i++) {
            score[i] = scanner.nextInt();
        }
        for (int i = 0; i < num; i++) {
            time[i] = scanner.nextInt();
        }
        int totalTime = scanner.nextInt();
        System.out.print(getMaxScore(totalTime, 0));
    }

    private static int getMaxScore(int totalTime, int index){
        if(index < num){
            if(totalTime>=time[index]){
                int doIt = score[index] + getMaxScore(totalTime-time[index], index+1);
                int doNot = getMaxScore(totalTime, index+1);
                return doIt>doNot?doIt:doNot;
            }else{
                return getMaxScore(totalTime, index+1);
            }
        }
        return 0;
    }

}
