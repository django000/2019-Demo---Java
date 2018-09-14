package com.vitoz.campus.zhaoyin;

import java.util.Random;

public class RandIntSortDemo {
    /**
     *@描述  主函数，程序入口
     *@参数  [args]
     *@返回值  void
     *@创建人  vitoz
     *@创建时间  2018/9/10
     *@修改人和其它信息
     */
    public static void main(String[] args) {
        int num = 10;
        int max = 1000;
        int[] randArr = new int[num];
        Random random = new Random();
        for (int i=0;i<num;i++){
            randArr[i] = random.nextInt(max);
        }
        printArr(randArr);
        int[] newArr = new int[num];
        for (int i=0;i<num;i++){
            newArr[i] = getReverse(randArr[i]);
        }
        printArr(newArr);
        quickSort(newArr);
        printArr(newArr);

    }

    /**
     *@描述  快速排序的程序
     *@参数  [arr]
     *@返回值  void
     *@创建人  vitoz
     *@创建时间  2018/9/10
     *@修改人和其它信息
     */
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

    /**
     *@描述  将数字n进行反转的函数，支持n<0
     *@参数  [n]
     *@返回值  int
     *@创建人  vitoz
     *@创建时间  2018/9/10
     *@修改人和其它信息
     */
    private static int getReverse(int n){
        String head = "";
        if (n < 0){
            head = "-";
            n = -n;
        }
        return Integer.parseInt(head + new StringBuilder(String.valueOf(n)).reverse().toString());
    }

    /**
     *@描述  打印数组的函数，从头到尾顺序打印
     *@参数  [arr]
     *@返回值  void
     *@创建人  vitoz
     *@创建时间  2018/9/10
     *@修改人和其它信息
     */
    private static void printArr(int[] arr){
        int len = arr.length;
        System.out.print("\n[");
        for (int i=0; i< len-1; i++){
            System.out.print(arr[i]+", ");
        }
        System.out.print(arr[len-1]+"]");
    }

    /**
     *@描述  给定元素索引，交换元素的函数
     *@参数  [i, j, arr]
     *@返回值  void
     *@创建人  vitoz
     *@创建时间  2018/9/10
     *@修改人和其它信息
     */
    private static void swapItem(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
