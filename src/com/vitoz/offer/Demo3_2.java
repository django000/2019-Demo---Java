package com.vitoz.offer;

public class Demo3_2 {
    public static void main(String[] args) {
        int[] arr = {2,3,5,4,3,2,6,7};
        System.out.println(duplicateWithBin(arr));
    }

    public static int duplicateWithBin(int[] arr){
        int len;
        if (arr == null || (len = arr.length) == 0){
            return -1;
        }

        int start = 1;
        int end = len-1;
        int mid, count;
        while (start<=end){
            mid = ((end-start)>>>1)+start;
            count = countRange(arr, len, start, mid);
            if (end==start){
                if (count>1){
                    return start;
                }else{
                    break;
                }
            }
            if (count>(mid-start+1)){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }

    public static int countRange(int[] arr, int len, int start, int mid){
        if (arr == null){
            return 0;
        }
        int count=0;
        for (int i=0;i<len;i++){
            if (arr[i]>=start && arr[i]<=mid){
                count++;
            }
        }
        return count;
    }
}
