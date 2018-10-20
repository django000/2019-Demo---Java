package com.vitoz.offer.chapter6;

/**
 * @Auther: vitoz
 * @Date: 2018/10/20 23:08
 * @Description: 剑指offer面试题56——数组中数字出现的次数
 */
public class Demo56 {
    public static void main(String[] args) {
        int[] arr = {2,4,3,6,3,2,5,5};
        getNumsAppearOnce(arr);
    }

    /**
     *@描述  数组中只出现一次的两个数字
     *@参数  [arr]
     *@返回值  void
     *@创建人  vitoz
     *@创建时间  2018/10/20
     *@修改人和其它信息
     */
    private static void getNumsAppearOnce(int[] arr){
        if (arr == null || arr.length <2){
            return;
        }
        int ExclusiveOr = arr[0];
        for (int i=1;i<arr.length;i++){
            ExclusiveOr ^= arr[i];
        }
        int ExclusiveNum = getExclusiveNum(ExclusiveOr);
        int num1 = 0, num2 = 0;
        for (int i=0;i<arr.length;i++){
            if ((arr[i]&ExclusiveNum) == 0){
                num1 ^= arr[i];
            }else {
                num2 ^= arr[i];
            }
        }
        System.out.println("两个只出现一次的数字分别为: "+num1+"、"+num2);
    }

    private static int getExclusiveNum(int num){
        int res = 1;
        while ((num & res) == 0){
            res = (res << 1);
        }
        return res;
    }

    /**
     *@描述  数组中唯一只出现一次的数字（其他数字出现了三次）
     *@参数  [arr]
     *@返回值  int
     *@创建人  vitoz
     *@创建时间  2018/10/20
     *@修改人和其它信息
     */
    private static int getNumberAppearOnce(int[] arr){
        int len;
        if (arr == null || (len = arr.length) == 0){
            throw new IllegalArgumentException("Invalid Input");
        }
        int[] bitSum = new int[32];
        for (int i=0;i<len;i++){
            int bitMask = 1;
            for (int j=31;j>=0;j--){
                int bit = arr[i]&bitMask;
                if (bit != 0){
                    bitSum[j] += 1;
                }
                bitMask = bitMask << 1;
            }
        }
        int res = 0;
        for (int i=0;i<32;i++){
            res = res << 1;
            res += bitSum[i]%3;
        }
        return res;
    }
}
