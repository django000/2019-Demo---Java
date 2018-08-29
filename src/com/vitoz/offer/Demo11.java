package com.vitoz.offer;

public class Demo11 {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,1};
        System.out.println(getMin(arr));
    }

    /**
     *@描述 二分查找确定旋转数组中的最小元素
     *@参数  [输入旋转数组]
     *@返回值  旋转数组的最小值
     *@创建人  vitoz
     *@创建时间  2018/8/30
     *@修改人和其它信息
     */
    public static int getMin(int[] arr){
        if (arr == null || arr.length == 0){
            throw new IllegalArgumentException("The Array is illegal. ");
        }
        int start = 0;
        int end = arr.length - 1;
        int result = start;
        while (arr[start] >= arr[end]){
            if (end-start == 1){
                result = end;
                break;
            }
            result = ((end - start)>>>1) + start;
            if (arr[start] == arr[end] && arr[result] == arr[end]){
                return getMinInorder(arr);
            }
            if (arr[result] >= arr[start]){
                start = result;
            }else if (arr[result] <= arr[end]){
                end = result;
            }
        }
        return arr[result];
    }

    /**
     *@描述 由于数组中元素相同的太多，所以只能用O(n)方式遍历判断
     *@参数  [输入旋转数组]
     *@返回值  旋转数组的最小值
     *@创建人  vitoz
     *@创建时间  2018/8/30
     *@修改人和其它信息
     */
    public static int getMinInorder(int[] arr){
        int result = arr[0], len = arr.length;
        for (int i=1; i<len; i++){
            if (arr[i] < result){
                result = arr[i];
            }
        }
        return result;
    }
}
