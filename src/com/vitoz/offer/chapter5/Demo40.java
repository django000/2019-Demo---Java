package com.vitoz.offer.chapter5;

import java.util.Random;
import java.util.TreeSet;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 20:12
 * @Description: 剑指offer面试题
 */
public class Demo40 {
    public static void main(String[] args) {
        int[] arr = new int[10000];
        Random random = new Random();
        for (int i=0;i<10000;i++){
            arr[i] = random.nextInt(1000);
        }
        int k = 10;
        TreeSet<Integer> res = getLeastNumbers(arr, k);
        if (res != null){
            for (Integer num: res){
                System.out.print(num+" ");
            }
        }
    }

    /**
     *@描述  采用TreeSet来保存最小的k个数，因为TreeSet增删改查的复杂度均为lgk，因此总的时间复杂度为O(nlgk)
     *@参数  [arr, k]
     *@返回值  java.util.TreeSet<java.lang.Integer>
     *@创建人  vitoz
     *@创建时间  2018/9/12
     *@修改人和其它信息
     */
    private static TreeSet<Integer> getLeastNumbers(int[] arr, int k){
        if (arr == null || arr.length == 0){
            return null;
        }
        int len = arr.length;
        if (k < 1 || k > len){
            return null;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i=0;i<k;i++){
            set.add(arr[i]);
        }
        for (int i=k;i<len;i++){
            if (set.last() > arr[i] && !set.contains(arr[i])){
                set.pollLast();
                set.add(arr[i]);
            }
        }
        return set;
    }
}
