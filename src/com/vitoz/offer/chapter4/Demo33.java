package com.vitoz.offer.chapter4;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 02:11
 * @Description: 剑指offer面试题33——判断某序列是否是二叉搜索树的后序遍历序列
 */
public class Demo33 {
    public static void main(String[] args) {
        int[] arr = {7,4,6,5};
        System.out.println(isPostOfOrderedTree(arr));
    }

    // 判断某序列是否是二叉搜索树的后序遍历序列
    private static boolean isPostOfOrderedTree(int[] arr){
        if (arr == null || arr.length == 0){
            return false;
        }
        return isPostOfOrderedTree(arr, 0, arr.length-1);
    }

    /**
     *@描述  递归判断子序列是否是符合二叉搜索性质的序列
     *@参数  [输入序列, 起始索引, 结束索引]
     *@返回值  boolean
     *@创建人  vitoz
     *@创建时间  2018/9/2
     *@修改人和其它信息
     */
    private static boolean isPostOfOrderedTree(int[] arr, int start, int end){
        if (start == end){
            return true;
        }
        int pos = start;
        int root = arr[end];
        while (arr[pos] < root){
            pos++;
        }
        for (int i=pos+1;i<end;i++){
            if (arr[i] < arr[end]){
                return false;
            }
        }
        return isPostOfOrderedTree(arr, start, pos-1) && isPostOfOrderedTree(arr, pos, end-1);
    }
}
