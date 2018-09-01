package com.vitoz.offer.chapter3;

/**
 * Created by zhengwentao on 2018/8/30.
 */
public class Demo16 {
    public static void main(String[] args) {
        int exp = 10;
        double base = 2.45;
        System.out.println(myPow(base, exp));
    }

    /**
     * @Author vitoz
     * @Description 该方法对于给定输入基数和指数，计算对应的乘方结果（若指数为0，恒定返回1.0）
     * @Date 2018/8/30 17:29
     * @Param [base, exp]
     * @return double
     **/
    private static double myPow(double base, int exp){
        if (exp == 0){
            return 1.0;
        }
        if (exp < 0 ){
            return 1.0/(base * myPow(base, -exp-1));
        }
        double res = myPow(base, exp>>1);
        res *= res;
        if ((exp&1) == 1){
            res *= base;
        }
        return res;
    }
}
