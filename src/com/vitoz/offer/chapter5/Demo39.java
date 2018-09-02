package com.vitoz.offer.chapter5;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 18:47
 * @Description: 剑指offer面试题39——查找数组中出现次数超过一半的数
 */
public class Demo39 {
    public static void main(String[] args) {
        int[] arr = {3, 3, 1, 1, 1, 1, 4, 4, 1};
        System.out.println(moreThanHalfNum(arr));
    }

    /**
     *@描述  对于给定的数组，求得其中出现次数超过二分之一的元素；如果不存在，则返回0
     *@参数  [输入数组]
     *@返回值  int
     *@创建人  vitoz
     *@创建时间  2018/9/2
     *@修改人和其它信息
     */
    private static int moreThanHalfNum(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int len = arr.length;
        int times = 1;
        int tmp = arr[0];
        for (int i=1;i<len;i++){
            if (times == 0){
                tmp = arr[i];
                times = 1;
            }else if (arr[i] == tmp){
                times++;
            }else {
                times--;
            }
        }
        if (checkMoreThanHalf(arr, tmp)){
            return tmp;
        }else {
            return 0;
        }
    }

    // 判断该元素出现次数是否真的超过二分之一
    private static boolean checkMoreThanHalf(int[] arr, int res){
        if (arr == null || arr.length == 0){
            return false;
        }
        int count = 0;
        int len = arr.length;
        for (int i=0;i<len;i++){
            if (arr[i] == res){
                count++;
            }
        }
        return 2*count > len;
    }
}
