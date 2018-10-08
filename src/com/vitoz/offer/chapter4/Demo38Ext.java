package com.vitoz.offer.chapter4;

/**
 * @Auther: vitoz
 * @Date: 2018/10/8 11:37
 * @Description: 剑指offer面试题38扩展——打印字符串的所有组合
 */
public class Demo38Ext {
    public static void main(String[] args) {
        String str = "abcd";
        getSubString(str);
    }

    private static void getSubString(String str){
        if (str == null || str.length() == 0){
            return;
        }
        char[] arr = str.toCharArray();
        char[] desArr;
        for (int m=1;m<=arr.length;m++){
            desArr = new char[m];
            getSubStringCore(arr, 0, desArr, 0);
        }
    }

    /**
     * @Author zhengwentao
     * @Description 为求给定长度的子字符串，分两种情况递归调用——原字符串第一个字符在m子字符串中和原字符串第一个字符不在m子字符串中
     * @Date 2018/10/8 11:38
     * @Param [arr, arrInd, desArr, desInd]
     * @return void
     **/
    private static void getSubStringCore(char[] arr, int arrInd, char[] desArr, int desInd){
        if (desInd == desArr.length){
            System.out.print(new String(desArr)+" ");
        }else if (arr.length-arrInd == desArr.length-desInd){ // 提前剪枝
            for (int i=arrInd;i<arr.length;i++,desInd++){
                desArr[desInd] = arr[i];
            }
            System.out.print(new String(desArr)+" ");
        }else {
            // 原字符串中第一个字符在长度m的字符串中
            desArr[desInd] = arr[arrInd];
            getSubStringCore(arr, arrInd+1, desArr, desInd+1);
            // 原字符串中第一个字符不在长度为m的字符串中
            getSubStringCore(arr, arrInd+1, desArr, desInd);
        }
    }
}
