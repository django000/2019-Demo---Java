package com.vitoz.campus.tujia;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin=new Scanner(new BufferedInputStream(System.in));
        int n,k;
        int t;
        t=cin.nextInt();
        while(t-->0)
        {
            n=cin.nextInt();
            k=cin.nextInt();
            if(n%(k+1)==0){
                System.out.println("B");
            }else {
                System.out.println("A");
            }
        }
    }
}