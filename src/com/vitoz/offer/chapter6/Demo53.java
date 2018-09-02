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
        System.out.println("数字k在该数组中共出现"+getTimesOfK(arr, k)+"次");
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
        int result = -1;
        if (arr != null && arr.length > 0){
            int len = arr.length-1;
            int first = getFirstK(arr, 0, len, k);
            int last = getLastK(arr, 0, len, k);
            result = (first > -1) && (last > -1)?(last-first+1):0;
        }
        return result;
    }

    /**
     *@描述  对于给定已排序的数组，求得数组中某关键字k出现的首个位置
     *@参数  [输入已排序数组, 起始位置, 结束位置, 关键字k]
     *@返回值  int
     *@创建人  vitoz
     *@创建时间  2018/9/3
     *@修改人和其它信息
     */
    private static int getFirstK(int[] arr, int start, int end, int k){
        if (start > end){
            return -1;
        }
        int mid = ((end-start)>>>1) + start;
        int middle = arr[mid];
        if (middle == k){
            if ((mid > 0 && arr[mid-1] != k) || mid == 0){
                return mid;
            }else {
                end = mid - 1;
            }
        }else if (middle > k){
            end = mid - 1;
        }else {
            start = mid + 1;
        }
        return getFirstK(arr, start, end, k);
    }

    /**
     *@描述  对于给定已排序的数组，求得数组中某关键字k出现的最后位置
     *@参数  [输入已排序数组, 起始位置, 结束位置, 关键字k]
     *@返回值  int
     *@创建人  vitoz
     *@创建时间  2018/9/3
     *@修改人和其它信息
     */
    private static int getLastK(int[] arr, int start, int end, int k){
        if (start > end){
            return -1;
        }
        int mid = ((end-start)>>>1) + start;
        int middle = arr[mid];
        if (middle == k){
            if ((mid < arr.length-1 && arr[mid+1] != k) || mid == arr.length-1){
                return mid;
            }else {
                start = mid + 1;
            }
        }else if (middle > k){
            end = mid - 1;
        }else {
            start = mid + 1;
        }
        return getLastK(arr, start, end, k);
    }
}
