package com.vitoz.campus.bytedance;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(getLongestStr(str));
    }
    public static int getLongestStr(String str){
        HashMap<Character,Integer> map=new HashMap<>();
        if(str==null || str.length()==0){
            System.out.println(0);
        }
        int res = 0;
        int r=0,l=0;
        HashSet<Character> set=new HashSet<>();
        while(l<str.length() && r<str.length()){
            if(set.contains(str.charAt(r))){
                set.remove(str.charAt(l++));
            }else{
                set.add(str.charAt(r++));
                res=Math.max(res,r-l);
            }

        }
        return res;
    }
}