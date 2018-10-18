package com.vitoz.offer.chapter2;

import static com.vitoz.offer.chapter2.Demo11.getMinInorder;

/**
 * @Auther: vitoz
 * @Date: 2018/10/12 14:51
 * @Description: 剑指offer面试题11——在旋转数组中查找元素
 */
public class Demo11Ext {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4;
        System.out.println(getNumIndex(arr, k));
    }

    private static int getNumIndex(int[] arr, int key){
        int res = -1;
        if (arr == null || arr.length == 0){
            return res;
        }
        int low = 0, high = arr.length-1;
        if (arr[low]<arr[high]){
            res = binarySearch(arr, low, high, key);
        }else {
            if (arr[low]<key){
                int maxInd = getArrIndex(arr, true);
                res = binarySearch(arr, low, maxInd, key);
            }else if (arr[low]>key){
                int minInd = getArrIndex(arr, false);
                res = binarySearch(arr, minInd, high, key);
            }else {
                res = low;
            }
        }
        return res;
    }

    private static int getArrIndex(int[] arr, boolean flag){
        int start = 0;
        int end = arr.length - 1;
        int result = start;
        while (arr[start] >= arr[end]){
            if (end-start == 1){
                result = flag?start:end;
                break;
            }
            result = ((end - start)>>>1) + start;
            if (arr[start] == arr[end] && arr[result] == arr[end]){
                return getMinInorder(arr, start, end);
            }
            if (arr[result] >= arr[start]){
                start = result;
            }else if (arr[result] <= arr[end]){
                end = result;
            }
        }
        return result;
    }

    private static int binarySearch(int[] arr, int low, int high, int key){
        int mid;
        while (low<=high){
            mid = low+((high-low)>>>1);
            if (arr[mid]<key){
                low = mid+1;
            }else if (arr[mid]>key){
                high = mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
