package com.vitoz.offer.chapter5;

/**
 * @Auther: vitoz
 * @Date: 2018/10/18 19:52
 * @Description: 剑指offer面试题45——把数组排成最小的数
 */
public class Demo45 {
    public static void main(String[] args) {
        int[] arr = {3,32,321};
        sortWithString(arr);
        StringBuilder sb= new StringBuilder();
        for (int i: arr){
            sb.append(i);
        }
        System.out.println(sb.toString());
    }

    /**
     * @Author zhengwentao
     * @Description 该方法对于给定输入arr，按照字符串拼接的大小进行快排
     * @Date 2018/10/18 20:02
     * @Param [arr]
     * @return void
     **/
    public static void sortWithString(int[] arr){
        if (arr == null || arr.length == 0){
            return;
        }
        sortWithString(arr, 0, arr.length-1);
    }

    /**
     * @Author zhengwentao
     * @Description 该方法对于给定输入数组和首尾索引，递归进行排序，排序规则为字符串拼接的大小顺序
     * @Date 2018/10/18 20:03
     * @Param [arr, start, end]
     * @return void
     **/
    private static void sortWithString(int[] arr, int start, int end){
        if (start >= end){
            return;
        }
        int index = partition(arr, start, end);
        if (index > start){
            sortWithString(arr, start, index-1);
        }
        if (index < end){
            sortWithString(arr, index+1, end);
        }
    }

    /**
     * @Author zhengwentao
     * @Description 该方法对于给定输入数组和首尾索引，进行单次排序partition
     * @Date 2018/10/18 20:04
     * @Param [arr, low, high]
     * @return int
     **/
    public static int partition(int[] arr, int low, int high){
        int base = arr[low];
        while (low < high){
            while (isBigEquals(arr[high], base) && low < high){
                high--;
            }
            if (low < high){
                arr[low] = arr[high];
                low++;
            }
            while (isBigEquals(base, arr[low]) && low < high){
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

    /**
     * @Author zhengwentao
     * @Description 自定义字符串排序规则函数
     * @Date 2018/10/18 20:06
     * @Param [x, y]
     * @return boolean
     **/
    private static boolean isBigEquals(int x, int y){
        return (x+""+y).compareTo(y+""+x)>=0;
    }
}
