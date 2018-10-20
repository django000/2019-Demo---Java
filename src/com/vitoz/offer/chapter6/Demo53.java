package com.vitoz.offer.chapter6;

/**
 * @Auther: vitoz
 * @Date: 2018/9/3 01:41
 * @Description: 剑指offer面试题53——在排序数组中查找数字出现次数
 */
public class Demo53 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,3,4,5};
        int k = 3;
        System.out.println(getTimesOfK(arr, k));
    }

    /**
     *@描述  对于给定已排序的数组，求得数组中某关键字k出现的次数
     *@参数  [输入已排序数组, 关键字k]
     *@返回值  int
     *@创建人  vitoz
     *@创建时间  2018/9/3
     *@修改人和其它信息
     */
    private static int getTimesOfK(int[] arr, int k){
        int result = 0;
        if (arr != null && arr.length > 0){
            int first = getIndexOfK(arr, 0, arr.length-1, k, true);
            if (first != -1){
                int last = getIndexOfK(arr, 0, arr.length-1, k, false);
                return last-first+1;
            }
        }
        return result;
    }

    /**
     *@描述  对于给定已排序的数组，求得数组中某关键字k出现的首个位置
     *@参数  [输入已排序数组, 起始位置, 结束位置, 关键字k, 是否查找第一个k的索引]
     *@返回值  int
     *@创建人  vitoz
     *@创建时间  2018/9/3
     *@修改人和其它信息
     */
    private static int getIndexOfK(int[] arr, int start, int end, int k, boolean isFirst){
        if (start > end){
            return -1;
        }
        int mid = ((end-start)>>>1) + start;
        int middle = arr[mid];
        if (middle == k){
            if (isFirst){
                if ((mid > 0 && arr[mid-1] != k) || mid == 0){
                    return mid;
                }else {
                    end = mid - 1;
                }
            }else {
                if ((mid < arr.length-1 && arr[mid+1] != k) || mid == arr.length-1){
                    return mid;
                }else {
                    start = mid + 1;
                }
            }
        }else if (middle > k){
            end = mid - 1;
        }else {
            start = mid + 1;
        }
        return getIndexOfK(arr, start, end, k, isFirst);
    }

    /**
     *@描述  求0—n-1中缺失的数字
     *@参数  [arr]
     *@返回值  int
     *@创建人  vitoz
     *@创建时间  2018/10/20
     *@修改人和其它信息
     */
    private static int getMissingNumber(int[] arr){
        if (arr == null || arr.length == 0){
            return -1;
        }
        int low = 0;
        int high = arr.length-1;
        while (low <= high){
            int mid = (high + low) >>> 1;
            if (arr[mid] != mid){
                if (mid == 0 || arr[mid-1] == mid-1){
                    return mid;
                }else {
                    high = mid - 1;
                }
            }else {
                low = mid + 1;
            }
        }
        if (low == arr.length){
            return arr.length;
        }
        return -1;
    }

    /**
     *@描述  求单调递增数组中数值和下标相等的元素
     *@参数  [arr]
     *@返回值  int
     *@创建人  vitoz
     *@创建时间  2018/10/20
     *@修改人和其它信息
     */
    private static int getEqualsNumber(int[] arr){
        if (arr == null || arr.length == 0){
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            int mid = (low+high) >>> 1;
            if (arr[mid] == mid){
                return mid;
            }else if (arr[mid] > mid){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
