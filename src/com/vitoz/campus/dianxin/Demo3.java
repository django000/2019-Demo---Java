package com.vitoz.campus.dianxin;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 22:00
 * @Description: 电信笔试题3
 */
public class Demo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        HashMap<String, String> itemMap = new HashMap<>(n);
        HashMap<String, Integer> timeMap = new HashMap<>(n);
        String[] input;
        for (int i=0;i<k;i++){
            input = sc.nextLine().trim().split(" ");
        }
    }
}

class LRUDemo{
    public int n;
    private int count = 0;
    private HashMap<String, String> itemMap;
    private HashMap<String, Integer> timeMap;
    public LRUDemo(int n){
        this.n = n;
        itemMap = new HashMap<>(n);
        timeMap = new HashMap<>(n);
    }

    public void put(String key, String value){
        if (itemMap.size() == this.n){
            Integer tmp, min = 0;
            String oldKey;
            for (Iterator iter = itemMap.entrySet().iterator();iter.hasNext();){
                Map.Entry entry = (Map.Entry)iter.next();
                tmp = (Integer)entry.getValue();
                if (tmp > min){
                    min = tmp;
                }
            }
        }

    }

    public String get(String key){
        String value = itemMap.get(key);
        return value == null?"-1":value;
    }
}