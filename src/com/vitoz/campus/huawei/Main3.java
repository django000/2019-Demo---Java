package com.vitoz.campus.huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: vitoz
 * @Date: 2018/10/13 19:33
 * @Description:
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(getNumsToHuiWen(arr, n));
    }
    private static int getNumsToHuiWen(int[] arr, int n) {
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(arr[i]);
        }
        while(list.size() > 1){
            if(list.get(0) < list.get(list.size() - 1)){
                int a = list.get(0);
                int b = list.get(1);
                list.set(0, a+b);
                list.remove(1);
                count++;
            }else if(list.get(0) > list.get(list.size() - 1)){
                int a = list.get(list.size() - 1);
                int b = list.get(list.size() - 2);
                list.set(list.size() - 2, a+b);
                list.remove(list.size() - 1);
                count++;
            }else{
                list.remove(0);
                list.remove(list.size() - 1);
            }
        }
        return count;
    }
}
