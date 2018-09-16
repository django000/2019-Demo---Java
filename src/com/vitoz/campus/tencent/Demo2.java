package com.vitoz.campus.tencent;

import java.util.Scanner;

/**
 * @Auther: vitoz
 * @Date: 2018/9/16 11:30
 * @Description: 腾讯笔试题2
 */

public class Demo2{
    public static void main(String[] args)  {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        boolean[][] map=new boolean[n][n];
        for (int i = 0; i < n; i++) {
            map[i][i]=true;
        }
        for (int i = 0; i < m; i++) {
            int x=scanner.nextInt();
            int y=scanner.nextInt();
            map[x-1][y-1]=true;
        }

        int[] in=new int[n];
        int[] out=new int[n];

        for (int i = 0; i < n; i++) {
            //从每个城市出发
            boolean[] traveled=new boolean[n];
            dfs(map,n,i,i,in,out,traveled);

        }
        int result=0;
        for (int i = 0; i < n; i++) {
            if(in[i]>out[i]) {
                result++;
            }
        }
        System.out.println(result);
    }
    private static void dfs(boolean[][] map, int n,int origin, int cur, int[] in, int[] out, boolean[] traveled){
        boolean[] tmp=map[cur];
        for (int i = 0; i < n; i++) {
            if(tmp[i] && i!=cur && !traveled[i]){
                out[origin]++;
                in[i]++;
                traveled[i]=true;
                dfs(map,n,origin,i,in,out,traveled);
            }
        }
    }
}