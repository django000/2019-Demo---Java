package com.vitoz.offer;

/**
 * Created by zhengwentao on 2018/8/30.
 */
public class Demo14 {
    public static void main(String[] args) {
        int len = 16;
        System.out.println(getMaxProductDP(len));
        System.out.println(getMaxProductTL(len));
    }

    /**
     * @Author vitoz
     * @Description 该方法对于给定输入，通过动态规划（DP）算法获取分段后的最大乘积
     * @Date 2018/8/30 15:21
     * @Param [len] 输入长度
     * @return int 最大乘积
     **/
    private static int getMaxProductDP(int len){
        if (len < 2){
            return 0;
        }else if (len == 2){
            return 1;
        }else if (len == 3){
            return 2;
        }

        int[] products = new int[len+1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max, tmp;
        for (int i=4;i<=len;i++){
            max = 0;
            for (int j=1;j<=(i>>1);j++){
                tmp = products[j]*products[i-j];
                if (max < tmp){
                    max = tmp;
                }
            }
            products[i] = max;
        }
        max = products[len];
        return max;
    }

    /**
     * @Author vitoz
     * @Description 该方法对于给定输入，使用贪婪（TL）算法获取分段后的最大乘积
     * @Date 2018/8/30 15:36
     * @Param [len] 输入长度
     * @return int 最大乘积
     **/
    private static int getMaxProductTL(int len){
        if (len < 2){
            return 0;
        }
        if (len == 2){
            return 1;
        }
        if (len == 3){
            return 2;
        }

        int timeOf3 = len / 3;
        if (len-timeOf3*3== 1){
            timeOf3 -= 1;
        }
        int timeOf2 = (len - timeOf3*3)>>1;
        return (int)Math.pow(2, timeOf2)*(int)Math.pow(3, timeOf3);
    }
}
