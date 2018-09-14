package com.vitoz.campus.baicizhan;

import java.util.Scanner;

public class OldDemo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        String head = "";
        if (n < 0){
            head = "-";
            n = -n;
        }
        StringBuilder builder = new StringBuilder(String.valueOf(n));
        int res = Integer.parseInt(builder.reverse().toString());
        System.out.println(head+res);
    }
}


