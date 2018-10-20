package com.vitoz.offer.chapter5;

/**
 * @Auther: vitoz
 * @Date: 2018/10/20 21:14
 * @Description: 剑指offer面试题51——数组中的逆序对
 */
public class Demo51 {
    public static void main(String[] args) {
        int[] arr = {7,5,6,4};
        System.out.println(getInversePairs(arr));
    }

    private static int getInversePairs(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int[] copy = new int[arr.length];
        for (int i=0;i<copy.length;i++){
            copy[i] = arr[i];
        }
        return getInversePairsCore(copy,0, copy.length-1);
    }

    private static int getInversePairsCore(int[] copy, int low, int high){
        if (low == high){
            return 0;
        }
        int mid = ((high - low) >>> 1) + low;
        int left = getInversePairsCore(copy, low, mid);
        int right = getInversePairsCore(copy,mid+1, high);
        int count = 0;
        int leftLen = mid-low+1;
        int rightLen = high-mid;
        int[] leftArr = new int[leftLen];
        for (int i=0;i<leftLen;i++){
            leftArr[i] = copy[i+low];
        }
        int[] rightArr = new int[high-mid];
        for (int i=0;i<rightLen;i++){
            rightArr[i] = copy[i+mid+1];
        }
        int i = 0, j = 0, k = low;
        while (i<leftLen && j<rightLen){
            if (leftArr[i] > rightArr[j]){
                copy[k++] = rightArr[j++];
                count += leftLen - i;
            }else {
                copy[k++] = leftArr[i++];
            }
        }
        while (i<leftLen){
            copy[k++] = leftArr[i++];
        }
        while (j<rightLen){
            copy[k++] = rightArr[j++];
        }
        return left+right+count;
    }
}
