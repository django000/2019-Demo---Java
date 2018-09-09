package com.vitoz.campus.bytedance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Demo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        List<String> res = new ArrayList<>();
        generate(res,str,new StringBuilder(),0,0);
        System.out.println(res.size());

    }
    private static void generate(List<String> res,  String s, StringBuilder current, int pos, int periods){
        if(periods==4 && pos==s.length()){
            res.add(current.toString());
            return;
        }
        if(pos>=s.length()){
            return;
        }
        //the maximum length for a remaining ipv4 address is 3 characters * periods left
        if(s.length()-pos >(3*(4-periods))){
            return;
        }
        for(int i=pos+1;i<=pos+3 && i<=s.length();++i){
            String sub = s.substring(pos,i);
            int val = Integer.parseInt(sub);
            if(val<=255 && (sub.length()==1 || sub.charAt(0)!='0')){
                current.append(sub);
                if(periods!=3){
                    current.append(".");
                }
                generate(res, s, current,i,periods+1);
                if(periods!=3){
                    current.setLength(current.length()-1);
                }
                current.setLength(current.length()-sub.length());
            }
        }
    }
}