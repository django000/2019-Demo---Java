package com.vitoz.basic.utils;

public class SortUtil {
    public static void main(String[] args) {
        int[] arr = new int[]{5,9,8,6,7,1,4};
        printArr(arr);
//        selectSort(arr);
//        selectSort1(arr);
//        selectSort2(arr);
//        bubbleSort(arr);
//        bubbleSort2(arr);
//        insertSort(arr);
//        quickSort(arr);
        quickSort2(arr);
//        mergeSort(arr);
//        heapSort(arr);
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
    public static void quickSort2(int[] arr){
        quickSort2(arr, 0, arr.length-1);
    }
    private static void quickSort2(int[] arr, int start, int end){
        if (start >= end){
            return;
        }
        int index = partition(arr, start, end);
        if (index > start){
            quickSort2(arr, start, index-1);
        }
        if (index < end){
            quickSort2(arr, index+1, end);
        }
    }
    public static int partition(int[] arr, int low, int high){
        int base = arr[low];
        while (low < high){
            while (arr[high] >= base && low < high){
                high--;
            }
            if (low < high){
                arr[low] = arr[high];
                low++;
            }
            while (arr[low] <= base && low < high){
                low++;
            }
            if (low < high){
                arr[high] = arr[low];
                high--;
            }
        }
        arr[low] = base;
        return low;
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
        for (int i=0; i< len-1; i++){
            for (int j=0; j<len-i-1; j++){
                if (arr[j]>arr[j+1]){
                    swapItem(j, j+1, arr);
                }
            }
        }
    }
    public static void bubbleSort2(int[] arr){
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
    /**
     *@描述  初始化大根堆
     *@参数  [arr]
     *@返回值  void
     *@创建人  vitoz
     *@创建时间  2018/9/23
     *@修改人和其它信息
     */
    private static void buildMaxHeap(int[] arr){
        if (arr == null || arr.length == 0){
            return;
        }
        int len = arr.length;
        for (int i=len/2-1;i>=0;i--){
            adjustMaxHeap(arr, i, len);
        }
    }

    /**
     *@描述  给定元素索引，调整数组使得其重新满足大根堆性质
     *@参数  [arr, k, len]
     *@返回值  void
     *@创建人  vitoz
     *@创建时间  2018/9/23
     *@修改人和其它信息
     */
    private static void adjustMaxHeap(int[] arr, int k, int len){
        int tmp = arr[k];
        for (int i=2*k+1;i<len-1;i=2*i+1){
            if (i<len-1 && arr[i]<arr[i+1]){
                i++;
            }
            if (tmp > arr[i]){
                break;
            }else {
                arr[k] = arr[i];
                k = i;
            }
        }
        arr[k] = tmp;
    }

    /**
     *@描述  堆排序主函数
     *@参数  [arr]
     *@返回值  void
     *@创建人  vitoz
     *@创建时间  2018/9/23
     *@修改人和其它信息
     */
    public static void heapSort(int[] arr){
        if (arr == null || arr.length == 0){
            return;
        }
        int len = arr.length;
        buildMaxHeap(arr);
        int tmp;
        for (int i=len-1;i>0;i--){
            tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            adjustMaxHeap(arr, 0, i);
        }
    }

    public static void printArr(int[] arr){
        int len = arr.length;
        System.out.print("\n[");
        for (int i=0; i< len-1; i++){
            System.out.print(arr[i]+", ");
        }
        System.out.println(arr[len-1]+"]");
    }
    private static void swapItem(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
