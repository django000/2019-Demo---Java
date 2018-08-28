package com.vitoz.basic.perfecttest;

import java.util.Scanner;
/*
* 黄金圣斗士欧洛斯要去圣域救雅典娜，需要从左上角出发，每次只能向右或向下走，最后到右下角见到雅典娜。地图中每个位置代表圣斗士遭遇的事情，如果是负数，说明此处有狙击，要让盛都欧式损失血量，如果是非负数，说明此处有血瓶，能让圣斗士回血，圣斗士从左上角到右下角的过程中，走到任何一个位置是，血量都不能少于1，为了保证圣斗士能救出雅典娜，初始血量至少为多少？地图为一个二维数组map,如下矩阵，根据map返回初始血量。
-2   -3   3
-5   -10  1
0   30   -5
返回7
思路是这样的：
从左上角到右下角有n条路径，求每条路径上最大耗血量，这n个耗血量中的最小耗血量+1即为初始血量。
因为每一步都要求血量最少为1，设初始血量为-1，从map[0][0]到map[n][m]做加法，记录这个累加过程中的最小值（一定是负数，且最大为-1）。
到达map[n][m]的时候比较这条路径的累加最小值min和以前的最大的累加最小值max，二者取大值存入max
最后所求血量即为-1*max
* */

public class Demo2 {
    private static int max=-1;
    private static boolean flag=true;
    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int m = reader.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = reader.nextInt();
            }
        }
        minBlood(arr,n-1,m-1,-1,0,0,-1);
        int res = -1*max;
        System.out.println(res);
    }

    private static void minBlood(int[][] map,int n,int m,int curr,int midn,int midm,int min) {
        curr=curr+map[midn][midm];
        min=Math.min(min, curr);
        if(midn==n&&midm<m){
            minBlood(map,n,m,curr,midn,midm+1,min);
        }else if(midm==m&&midn<n){
            minBlood(map,n,m,curr,midn+1,midm,min);
        }else if(midn==n&&midm==m){
            if(flag){
                max=min;
                flag=false;
            }else{
                max=Math.max(min,max);
            }
        }else{
            minBlood(map,n,m,curr,midn+1,midm,min);
            minBlood(map,n,m,curr,midn,midm+1,min);
        }
    }
}