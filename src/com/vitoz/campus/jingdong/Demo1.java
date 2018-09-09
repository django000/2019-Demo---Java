package com.vitoz.campus.jingdong;

import java.util.Scanner;

public class Demo1
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-- > 0)
        {
            int nodeNum = sc.nextInt();
            int sideNum = sc.nextInt();
            boolean nodes[][] = new boolean[nodeNum][nodeNum];
            while(sideNum-- > 0)
            {
                int i = sc.nextInt() - 1;
                int j = sc.nextInt() - 1;
                nodes[i][j] = true;
                nodes[j][i] = true;
            }
            int result[] = new int[nodeNum];
            for(int i = 0; i < nodeNum; i++)
            {
                for(int j = 0; j < nodeNum; j++)
                {
                    if(nodes[i][j]) {
                        result[i]++;
                    }
                }
            }
            boolean flag = true;
            for(int i = 0; i < nodeNum; i++)
            {
                for(int j = i; j < nodeNum; j++)
                {
                    if(!nodes[i][j])
                    {
                        if(result[i] != result[j])
                        {
                            flag = false;
                            break;
                        }
                    }
                }
                if(!flag) {
                    break;
                }
            }
            if(!flag)
            {
                System.out.println("No");
            }
            else
            {
                System.out.println("Yes");
            }
        }
    }
}
