package com.vitoz.offer.chapter5;

/**
 * @Auther: vitoz
 * @Date: 2018/10/20 16:57
 * @Description: 剑指offer面试题49——丑数
 */
public class Demo49 {
    public static void main(String[] args) {
        int index = 1500;
        System.out.println(getUglyNumber(index));
    }

    /**
     *@描述  定义存放丑数的数组，根据已有的丑数，生成新的丑数
     *@参数  [index]
     *@返回值  int
     *@创建人  vitoz
     *@创建时间  2018/10/20
     *@修改人和其它信息
     */
    private static int getUglyNumber(int index){
        if (index <= 0){
            return 0;
        }
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int pMultiply2 = 1;
        int pMultiply3 = 1;
        int pMultiply5 = 1;
        for (int i=1;i<index;i++){
            uglyNumbers[i] = getMinOfThree(pMultiply2*2, pMultiply3*3, pMultiply5*5);
            while (pMultiply2*2 <= uglyNumbers[i]){
                pMultiply2++;
            }
            while (pMultiply3*3 <= uglyNumbers[i]){
                pMultiply3++;
            }
            while (pMultiply5*5 <= uglyNumbers[i]){
                pMultiply5++;
            }
        }
        return uglyNumbers[index-1];
    }

    /**
     *@描述  三个数比较大小
     *@参数  [p2, p3, p5]
     *@返回值  int
     *@创建人  vitoz
     *@创建时间  2018/10/20
     *@修改人和其它信息
     */
    private static int getMinOfThree(int p2, int p3, int p5){
        int tmp = p2 < p3? p2 : p3;
        return tmp < p5? tmp : p5;
    }
}
