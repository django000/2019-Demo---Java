package com.vitoz.offer;

/**
 * Created by zhengwentao on 2018/8/30.
 */
public class Demo15 {
    public static void main(String[] args) {
        int num = 0x80000000;
        System.out.println(getNumOf1(num));
        System.out.println(getNumOf11(num));
    }

    /**
     * @Author vitoz
     * @Description 该方法对于给定输入，通过数字无符号循环右移得到1的位数
     * @Date 2018/8/30 16:06
     * @Param [num]
     * @return int
     **/
    private static int getNumOf1(int num){
        int count = 0;
        while (num!=0){
            count += num&1;
            num >>>= 1;
        }
        return count;
    }

    /**
     * @Author vitoz
     * @Description 该方法对于给定输入，通过n&(n-1)不断消除1位进行计数，得到1的位数
     * @Date 2018/8/30 16:07
     * @Param [num]
     * @return int
     **/
    private static int getNumOf11(int num){
        int count = 0;
        while (num !=0){
            count++;
            num &= (num-1);
        }
        return count;
    }
}
