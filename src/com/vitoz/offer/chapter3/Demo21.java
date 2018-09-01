package com.vitoz.offer.chapter3;

public class Demo21 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        printArr(arr);
        reorderOddEven(arr);
        printArr(arr);
    }

    private static void reorderOddEven(int[] arr){
        if (arr == null || arr.length == 0){
            return;
        }
        int tmp;
        int start = 0;
        int end = arr.length-1;
        while (start < end){
            while (start<end && getFlag(arr[start])){
                start++;
            }
            while (start<end && !getFlag(arr[end])){
                end--;
            }
            if (start < end){
                tmp = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp;
            }
        }
    }

    private static boolean getFlag(int num){
        return (num & 1) == 1;
    }

    public static void printArr(int[] arr){
        if (arr == null || arr.length == 0){
            return;
        }
        int len = arr.length;
        System.out.print("[");
        for (int i=0;i<len-1;i++){
            System.out.print(arr[i]+", ");
        }
        System.out.println(arr[len-1]+"]");
    }
}
