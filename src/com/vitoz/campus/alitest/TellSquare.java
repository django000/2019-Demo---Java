package com.vitoz.campus.alitest;

import java.util.Arrays;
import java.util.Scanner;

public class TellSquare {
    private static int[][] p = new int[4][2];
    private static int[][] q = new int[4][2];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),step;
        for (int i=0; i<n; i++){
            for (int j=0; j<4;j++){
                q[j] = new int[]{sc.nextInt(), sc.nextInt()};
                p[j] = new int[]{sc.nextInt(), sc.nextInt()};
            }
            step = 0;
            while (!isSquare(p)){
//                进行某个旋转操作
                step+=1;
            }
            System.out.println(step);
        }
    }
    public static boolean isSquare (int[][] p){
        int cnt=0;
        int len[]=new int[6];
        for(int i=0;i<=3;i++){
            for(int j=i+1;j<=3;j++){
                // p[i][0]是第i个点的x坐标;p[j][1]是第j个点的y坐标
                len[cnt++]=(p[i][0]-p[j][0])*(p[i][0]-p[j][0])+(p[i][1]-p[j][1])*(p[i][1]-p[j][1]);
            }

        }
        //数组排序 最长的是对角线
        Arrays.sort(len);
        //相邻两边相等,对角线相等的四边形是正方形;
        return len[0]==len[1]&&len[4]==len[5]&&len[4]>len[1];
    }
}
