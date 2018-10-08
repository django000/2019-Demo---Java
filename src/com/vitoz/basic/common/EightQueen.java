package com.vitoz.basic.common;


public class EightQueen {
    private static int count = 0;
    public static void main(String[] args) {
        int n = 8;
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = i;
        }
        permutation(arr, 0);
        System.out.println(count);
    }

    /**
     *@描述  深度遍历加回溯求解合法排放顺序
     *@参数  [arr, index]
     *@返回值  void
     *@创建人  vitoz
     *@创建时间  2018/9/23
     *@修改人和其它信息
     */
    private static void permutation(int[] arr, int index){
        if (arr == null || arr.length == 0){
            return;
        }
        if (index == arr.length-1){
            if (!checkConflict(arr, index)){
                count++;
            }
        }else {
            for (int i=index;i<arr.length;i++){
                swap(arr, i, index);
                if (!checkConflict(arr, index)){
                    permutation(arr, index+1);
                }
                swap(arr, i, index);
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     *@描述  判断当前索引处的index是否符合八皇后规则
     *@参数  [arr, index]
     *@返回值  boolean
     *@创建人  vitoz
     *@创建时间  2018/9/23
     *@修改人和其它信息
     */
    private static boolean checkConflict(int[] arr, int index){
        boolean flag = false;
        for (int i=0;i<index;i++){
            if (Math.abs(arr[i]-arr[index]) == Math.abs(i-index)){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
