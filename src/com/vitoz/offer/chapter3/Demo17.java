package com.vitoz.offer.chapter3;

/**
 * Created by zhengwentao on 2018/8/31.
 */
public class Demo17 {
    public static void main(String[] args) {
        int n = 3;
        print1ToN(n);
    }

    /**
     * @Author vitoz
     * @Description 该方法对于给定输入长度的n，通过递归的方式去循环递增各个数位上的值，并打印出来
     * @Date 2018/8/31 16:30
     * @Param [n]
     * @return void
     **/
    private static void print1ToN(int n){
        if (n <= 0){
            return;
        }

        char[] nums = new char[n];
        for (int i=0;i<10;i++){
            nums[0] = (char)(i+'0');
            print1ToNCore(nums, 0);
        }
    }

    /**
     * @Author vitoz
     * @Description 该方法对于给定输入字符数组，以及当前递增数位，进行递归调用，如果是最后一位（最低位）则打印出来
     * @Date 2018/8/31 16:31
     * @Param [nums, index]
     * @return void
     **/
    private static void print1ToNCore(char[] nums, int index){
        index++;
        if (index == nums.length){
            printNum(nums);
            return;
        }

        for (int i=0;i<10;i++){
            nums[index] = (char)(i+'0');
            print1ToNCore(nums, index);
        }
    }

    /**
     * @Author vitoz
     * @Description 该方法对于给定输入字符数组，忽略掉高位的0并打印出来
     * @Date 2018/8/31 16:32
     * @Param [nums]
     * @return void
     **/
    private static void printNum(char[] nums){
        int pos = 0, len = nums.length;
        while (pos < len && nums[pos] == '0'){
            pos++;
        }
        if (pos<len){
            for (int i=pos;i<len;i++){
                System.out.print(nums[i]);
            }
        }
        System.out.println();
    }
}
