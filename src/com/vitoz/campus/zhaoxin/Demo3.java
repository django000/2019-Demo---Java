package com.vitoz.campus.zhaoxin;

import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split(" ");
        int k = sc.nextInt();
        int left = 0;
        int right = 0;
        int len = str.length;
        int tmp, mid;
        int[] arr = new int[len];
        for (int i=0;i<len;i++){
            tmp = Integer.parseInt(str[i]);
            arr[i] = tmp;
            if (tmp > right){
                right = tmp;
            }
        }
        while (left<right){
            mid = (right-left)>>1+left;
            if (getTime(arr, mid)>k){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        System.out.println(left);
    }

    private static int getTime(int[] arr, int speed){
        int res = 0;
        int len = arr.length;
        for (int i=0;i<len;i++){
            res += arr[i]/speed;
            if (arr[i]%speed>0){
                res += 1;
            }
        }
        return res;
    }
}
