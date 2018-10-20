package com.vitoz.offer.chapter6;

/**
 * @Auther: vitoz
 * @Date: 2018/10/20 23:43
 * @Description: 剑指offer面试题57——和为s的数字
 */
public class Demo57 {
    public static void main(String[] args) {
        int[] arr = {1,2,4,7,11,15};
        int s = 15;
        findNumsWithSum(arr, s);
        findContinueSequence(s);
    }

    /**
     *@描述  求解和为s的两个数字
     *@参数  [arr, s]
     *@返回值  void
     *@创建人  vitoz
     *@创建时间  2018/10/20
     *@修改人和其它信息
     */
    private static void findNumsWithSum(int[] arr, int s){
        if (arr == null || arr.length == 0){
            return;
        }
        int low = 0;
        int high = arr.length-1;
        while (low < high){
            long sum = arr[low] + arr[high];
            if (sum == s){
                System.out.println("和为s的数字分别为: "+arr[low]+"、"+arr[high]);
                break;
            }else if (sum > s){
                high--;
            }else {
                low++;
            }
        }
    }

    private static void findContinueSequence(int s){
        if (s < 3){
            return;
        }
        int small = 1;
        int big = 2;
        long sum = small+big;
        int mid = (s+1)/2;
        while (small < mid){
            if (sum == s){
                printContinueSequence(small, big);
            }
            while (sum > s && small < mid){
                sum -= small;
                small++;
                if (sum == s){
                    printContinueSequence(small, big);
                }
            }
            big++;
            sum += big;
        }
    }

    private static void printContinueSequence(int small, int big){
        for (int i=small;i<big;i++){
            System.out.print(i+" ");
        }
        System.out.println(big);
    }
}
