package com.vitoz.campus.hulu;

import java.util.Arrays;
import java.util.Scanner;

public class Demo2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n=scanner.nextInt();
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i]=scanner.nextInt() ;
            }
            int res = solution(n, numbers);
            System.out.println(res);
        }
    }

    private static int solution(int n, int[] numbers){
        int tmp;
        int res=0;
        int i;
        Arrays.sort(numbers);
        for (i = 0; i < n && numbers[i] < 18000; i++) {
            int num=0;
            tmp = numbers[i] + 18000;
            for (int j = i+1; j < n; j++) {
                if (numbers[j] < tmp) {
                    num++;
                }
            }
            res+=num*(num-1)/2;
        }
        for (; i < n && numbers[i] >18000 ; i++) {
            int num=0;
            tmp = numbers[i] -18000 ;

            for (int j = 0; j < n ; j++) {
                if (numbers[j] <tmp||numbers[j]>numbers[i]) {
                    num++;
                }
            }
            res += num*(num-1)/2;
        }
        return res;
    }
}

