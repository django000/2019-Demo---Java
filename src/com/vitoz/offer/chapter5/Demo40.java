package com.vitoz.offer.chapter5;

import com.vitoz.basic.utils.SortUtil;

import java.util.Random;
import java.util.TreeSet;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 20:12
 * @Description: 剑指offer面试题40——最小的k个数
 */
public class Demo40 {
    public static void main(String[] args) {
        int n = 10000;
        int[] arr = new int[n];
        Random random = new Random();
        for (int i=0;i<n;i++){
            arr[i] = random.nextInt(n);
        }
        int k = 10;
        int[] out = new int[k];
        getLeastNumbers(arr, k, out);
        SortUtil.printArr(out);

        TreeSet<Integer> res = getLeastNumbers2(arr, k);
        if (res != null){
            for (Integer num: res){
                System.out.print(num+" ");
            }
        }
    }
    
    /**
     *@描述  利用快排中的partition函数实现排序，确保最小的k个数在前k位，因此总的时间复杂度为O(n)
     *@参数  [arr, k, out]
     *@返回值  void
     *@创建人  vitoz
     *@创建时间  2018/9/25
     *@修改人和其它信息
     */
    private static void getLeastNumbers(int[] arr, int k, int[] out){
        if (arr == null || arr.length == 0 || k > arr.length){
            return;
        }
        int low = 0, high = arr.length-1;
        int index = SortUtil.partition(arr, low, high);
        while (index != k-1){
            if (index > k-1){
                high = index - 1;
                index = SortUtil.partition(arr, low, high);
            }else {
                low = index + 1;
                index = SortUtil.partition(arr, low, high);
            }
        }
        for (int i=0;i<k;i++){
            out[i] = arr[i];
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
    private static TreeSet<Integer> getLeastNumbers2(int[] arr, int k){
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
