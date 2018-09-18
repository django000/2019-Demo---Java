package com.vitoz.campus.didi;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        // len1+1, len2+1, because finally return dp[len1][len2]
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }


        List<Character> list1 = Arrays.asList('q','w','e','r','t','a','s','d','f','g','z','x','c','v');
        List<Character> list2 = Arrays.asList('y','u','i','o','p','h','j','k','l','b','n','m');
        //iterate though, and check last char
        for (int i = 0; i < len1; i++) {
            char c1 = word1.charAt(i);
            for (int j = 0; j < len2; j++) {
                char c2 = word2.charAt(j);

                //if last two chars equal
                if (c1 == c2) {
                    //update dp value for +1 length
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int replace=0;
                    if((list1.contains(c1)&&list1.contains(c2))||(list2.contains(c1)&&list2.contains(c2))) {
                        replace = dp[i][j] + 1;
                    } else {
                        replace = dp[i][j] + 2;
                    }
                    int insert = dp[i][j + 1] + 3;
                    int delete = dp[i + 1][j] + 3;

                    int min = replace > insert ? insert : replace;
                    min = delete > min ? min : delete;
                    dp[i + 1][j + 1] = min;
                }
            }
        }

        return dp[len1][len2];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        // String line = "aaa bbb ccc abcd adfc adf";
        line = line.toLowerCase();
        String[] strs = line.split(" ");
        String[] candidate = Arrays.copyOfRange(strs, 1, strs.length);

        int[] dis = new int[candidate.length];
        String target = strs[0];
        for (int i = 0; i < dis.length; i++) {
            dis[i]=minDistance(target, candidate[i]);
        }
        int[] tmp = Arrays.copyOf(dis, dis.length);
        Arrays.sort(tmp);
        String one=null;
        String two=null;
        String three=null;
        int[] visited = new int[2];
        Arrays.fill(visited,-1);
        for (int i = 0; i < dis.length; i++) {
            if(dis[i]==tmp[0]){
                one = candidate[i];
                visited[0]=i;
            }
        }
        //    System.out.println(one + " " + two + " " + three);
        for (int i = 0; i < dis.length; i++) {
            if(dis[i]==tmp[1]&&i!=visited[0]){
                two = candidate[i];
                visited[1]=i;
                break;
            }
        }
        for (int i = 0; i < dis.length; i++) {
            if(dis[i]==tmp[2]&&i!=visited[0]&&i!=visited[1]){
                three = candidate[i];
                break;
            }
        }

        System.out.println(one + " " + two + " " + three);

    }
}