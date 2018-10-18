package com.vitoz.offer.chapter5;

/**
 * @Auther: vitoz
 * @Date: 2018/10/18 18:03
 * @Description: 剑指offer面试题44——数字序列中某一位的数字
 */
public class Demo44 {
    public static void main(String[] args) {
        int n = 1001;
        System.out.println(getNumberOfN(n));
    }

    /**
     * @Author zhengwentao
     * @Description 该方法对于给定输入n，求出按照01234567891011121314...规律的第n(从0算起)个数字
     * @Date 2018/10/18 20:00
     * @Param [n]
     * @return int
     **/
    private static int getNumberOfN(int n){
        if (n < 0){
            return -1;
        }else if (n == 0 || n == 1){
            // n==1的情况下，下面程序会出现除数为0的情况，因此在这里处理
            return n;
        }
        int sum = 1;
        int digit = 1;
        while (sum < n){
            sum += digit*countOfIntegers(digit++);
        }
        int index = n+(--digit)*countOfIntegers(digit)-sum;
        int number = beginNumber(digit)+index/digit;
        for (int i=1;i<digit-index%digit;i++){
            number /= 10;
        }
        return number%10;
    }

    /**
     * @Author zhengwentao
     * @Description 该方法对于给定输入位数，求出该位数对应的数字个数
     * @Date 2018/10/18 19:59
     * @Param [digit]
     * @return int
     **/
    private static int countOfIntegers(int digit){
        return 9*beginNumber(digit);
    }

    /**
     * @Author zhengwentao
     * @Description 该方法对于给定输入位数，求出该位数下的第一个数字
     * @Date 2018/10/18 20:00
     * @Param [digit]
     * @return int
     **/
    private static int beginNumber(int digit){
        int res = 1;
        for (int i=1;i<digit;i++){
            res *= 10;
        }
        return res;
    }
}
