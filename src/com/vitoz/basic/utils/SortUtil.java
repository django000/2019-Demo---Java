package com.vitoz.basic.utils;

public class SortUtil {
    public static void main(String[] args) {
        int[] arr = new int[]{5,9,8,6,7,1,4};
        printArr(arr);
//        selectSort(arr);
//        selectSort1(arr);
//        selectSort2(arr);
//        bubbleSort(arr);
//        insertSort(arr);
//        quickSort(arr);
//        mergeSort(arr);
        printArr(arr);
    }

    public static int binarySearch(int[] arr, int key){
        if (arr==null|| arr.length==0){
            return -1;
        }
        int l = 0, r=arr.length-1;
        while (l<=r){
            int m = (l+r)/2;
            if (arr[m]<key){
                l = m+1;
            }else if (arr[m]>key){
                r = m-1;
            }else{
                return m;
            }
        }
        return -1;
    }
    public static void mergeSort(int[] arr){
        mergeSort(arr, 0, arr.length-1);
    }
    private static void mergeSort(int[] arr, int l, int r){
        if (l<r){
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }
    private static void merge(int[] arr, int l, int m, int r){
        int[] leftArr = new int[m-l+1];
        int[] rightArr = new int[r-m];
        for (int i=l;i<=m;i++){
            leftArr[i-l] = arr[i];
        }
        for (int j=m;j<r;j++){
            rightArr[j-m] = arr[j+1];
        }

        int i=0,j=0;
        int k=l;

        while (i<leftArr.length && j< rightArr.length){
            if (leftArr[i]<rightArr[j]){
                arr[k++] = leftArr[i++];
            }else{
                arr[k++] = rightArr[j++];
            }
        }
        while (i<leftArr.length){
            arr[k++] = leftArr[i++];
        }
        while (j<rightArr.length){
            arr[k++] = rightArr[j++];
        }
    }
    public static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }
    private static void quickSort(int[] arr, int l, int r){
        int i=l;
        int j=r;
        int m = arr[(l+r)/2];
        while (i<j){
            while (m>arr[i]){
                i++;
            }
            while (m<arr[j]){
                j--;
            }
            if (i<j){
                swapItem(i,j,arr);
                i++;
                j--;
            }
        }
        if (l<i){
            quickSort(arr, l, i-1);
        }
        if (r>j){
            quickSort(arr, j+1, r);
        }

    }
    public static void insertSort(int[] arr){
        int tmp,j;
        for (int i=1; i< arr.length; i++){
            tmp = arr[j=i];
            while (j>0 && arr[j-1]>tmp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = tmp;
        }
    }
    public static void bubbleSort(int[] arr){
        int len = arr.length;
        int pos;
        for (int i=0; i< len-1; i++){
            pos = len-i-1;
            for (int j=0; j<len-i-1; j++){
                if (arr[j]>arr[pos]){
                    pos = j;
                }
            }
            swapItem(pos, len-i-1, arr);
        }
    }
    public static void selectSort(int[] arr){
        int len = arr.length;
        for (int i=0; i< len-1; i++){
            for (int j = i+1; j< len; j++){
                if (arr[i] > arr[j]){
                    swapItem(i, j, arr);
                }
            }
        }
    }
    public static void selectSort1(int[] arr){
        int len = arr.length;
        Boolean flag = true;
        for (int i=0; i< len-1; i++){
            for (int j = i+1; j< len; j++){
                if (arr[i] > arr[j]){
                    swapItem(i, j, arr);
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }
    }
    public static void selectSort2(int[] arr){
        int len = arr.length;
        int pos;
        for (int i=0; i< len-1; i++){
            pos = i;
            for (int j = i+1; j< len; j++){
                if (arr[pos] > arr[j]){
                    pos = j;
                }
            }
            swapItem(i, pos, arr);
        }
    }
    public static void printArr(int[] arr){
        int len = arr.length;
        System.out.print("\n[");
        for (int i=0; i< len-1; i++){
            System.out.print(arr[i]+", ");
        }
        System.out.print(arr[len-1]+"]");
    }
    private static void swapItem(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
