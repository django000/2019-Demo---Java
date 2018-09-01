package com.vitoz.offer.chapter3;

/**
 * Created by zhengwentao on 2018/8/31.
 */
public class Demo20 {
    private static int pos = 0;
    public static void main(String[] args) {
        String str = "-1.234e-16";
        System.out.println(strIsInteger(str.toCharArray()));
    }

    private static boolean strIsInteger(char[] str){
        if (str == null || str.length == 0){
            return false;
        }
        boolean numeric = scanInteger(str);
        System.out.println(pos);
        if (str[pos] == '.'){
            pos++;
            numeric |= scanUnsignedInteger(str);
        }
        System.out.println(pos);
        if (str[pos] == 'e' || str[pos] == 'E'){
            pos++;
            numeric &= scanInteger(str);
        }
        System.out.println(pos);
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
