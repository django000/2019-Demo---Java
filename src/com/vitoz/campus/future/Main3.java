package com.vitoz.campus.future;

import java.util.Scanner;

/**
 * @Author: vitoz
 * @Date: 2018/10/9 20:42
 * @Description:
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        if (n<3){
            System.out.println(n);
            return;
        }
        int result = 2;
        int current = 2;
        int index = 0;
        if (arr[1]<=arr[0]){
            index = 1;
        }
        for (int i=2;i<n;i++){
            if ((arr[i]>arr[i-1] && arr[i]>arr[i-2]+1) || (i-index>=current)){
                result++;
            }else {
                index = i;
                if (current > result){
                    result = current;
                }
            }
        }
        System.out.println(result);
    }
}
