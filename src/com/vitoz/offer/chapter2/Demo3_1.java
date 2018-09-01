package com.vitoz.offer.chapter2;

import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;

import java.util.HashSet;

public class Demo3_1 {
    public static void main(String[] args) {
        int[] arr = {2,3,1,0,2,5,3};
        System.out.println(duplicateWithHash(arr));
        System.out.println(duplicateWithFind(arr));
    }

    public static int duplicateWithHash(int[] arr){
        int len;
        if (arr == null || (len = arr.length) == 0){
            return -1;
        }
        HashSet<Integer> set = new HashSet<>(len);
        for (int i=0;i<len;i++){
            if (arr[i]<0||arr[i]>=len){
                return -1;
            }
            if (set.contains(arr[i])){
                return arr[i];
            }else{
                set.add(arr[i]);
            }
        }
        return -1;
    }

    public static int duplicateWithFind(int[] arr){
        int len;
        if (arr == null || (len = arr.length) == 0){
            return -1;
        }
        for (int i=0;i<len;i++) {
            if (arr[i] < 0 || arr[i] >= len) {
                return -1;
            }
        }
        int temp;
        for (int i=0;i<len;i++) {
            while (arr[i] != i){
                if (arr[arr[i]] == arr[i]) {
                    return arr[i];
                }
                temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
            }
        }
        return -1;
    }
}
