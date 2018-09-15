package com.vitoz.campus.souhuC;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 22:00
 * @Description: 搜狐畅游笔试题1
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split(" ");
        int len = str.length;
        HashMap<String, Integer> map = new HashMap<>(len);
        Integer count;
        for (int i=0;i<len;i++){
            count = map.get(str[i]);
            if (count == null){
                map.put(str[i], 1);
            }else if (count == 1){
                break;
            }
        }
    }
}
