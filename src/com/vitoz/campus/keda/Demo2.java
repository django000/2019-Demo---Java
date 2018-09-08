package com.vitoz.campus.keda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>(n);
        for (int i=0;i<n;i++){
            arr.add(sc.nextInt());
        }
        System.out.println(getPeaceNightCnt(arr));
    }

    private static int getPeaceNightCnt(ArrayList<Integer> nums){
        int cnt = 0;
        ArrayList<Integer> tmp = nums;
        ArrayList<Integer> cur = new ArrayList<>();
        Collections.sort(tmp);
        boolean flag = false;
        for (int i=0;i<nums.size();i++){
            if (!nums.get(i).equals(tmp.get(i))){
                flag = true;
                break;
            }
        }
        if (flag) {
            cur.add(nums.get(0));
            for (int i = 1; i < nums.size(); i++) {
                if (nums.get(i) > nums.get(i-1)){
                    cur.add(nums.get(i));
                }
            }
            cnt = 1 + getPeaceNightCnt(nums);
        }
        return cnt;
    }
}
