package com.vitoz.offer;

public class Demo5Ext {
    public static void main(String[] args) {
        int[] arr1 = {0,1,4,6,9,11};
        int[] arr2 = {2,5,7,9,12};
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] arr = new int[len1+len2];
        for (int i=0;i<len1;i++){
            arr[i] = arr1[i];
        }

        int index1 = len1 - 1;
        int index2 = len2 - 1;
        int index = len1+len2 - 1;

        while (index1>=0 && index2>=0){
            if (arr[index1] > arr2[index2]){
                arr[index] = arr[index1--];
            }else{
                arr[index] = arr2[index2--];
            }
            index--;
        }
        while (index1>=0){
            arr[index--] = arr[index1--];
        }
        while (index2>=0){
            arr[index--] = arr[index2--];
        }

        for (int i=0;i<len1+len2;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
