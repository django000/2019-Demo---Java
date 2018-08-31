package com.vitoz.offer;

/**
 * Created by zhengwentao on 2018/8/31.
 */
public class Demo20 {
    private static int pos = 0;
    public static void main(String[] args) {
        String str = "-1e-16";
        System.out.println(strIsInteger(str.toCharArray()));
    }

    private static boolean strIsInteger(char[] str){
        if (str == null || str.length == 0){
            return false;
        }
        boolean numeric = scanInteger(str);
        if (str[pos] == '.'){
            numeric |= scanUnsignedInteger(str);
        }
        if (str[pos] == 'e' || str[pos] == 'E'){
            pos++;
            numeric &= scanInteger(str);
        }
        return numeric;
    }

    private static boolean scanInteger(char[] str){
        if (str[pos] == '+' || str[pos] == '-'){
            pos++;
        }
        return scanUnsignedInteger(str);
    }

    private static boolean scanUnsignedInteger(char[] str){
        int head = pos;
        int len = str.length;
        while (pos < len && str[pos] >= '0' && str[pos] <= '9'){
            pos++;
        }
        return pos > head;
    }
}
