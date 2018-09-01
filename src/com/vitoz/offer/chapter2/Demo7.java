package com.vitoz.offer.chapter2;

import com.vitoz.offer.dataobjects.BinaryTreeNode;

/**
 * Created by zhengwentao on 2018/8/28.
 */
public class Demo7 {
    public static void main(String[] args) {
        int[] preorder = { 1, 2, 4, 7, 3, 5, 6, 8 };
        int[] inorder = { 4, 7, 2, 1, 5, 3, 8, 6 };
        BinaryTreeNode root = construct(preorder, inorder);
        root.printPostorder();
    }

    public static BinaryTreeNode construct(int[] preorder, int[] inorder){
        return construct(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public static BinaryTreeNode construct(int[] preorder, int startPre, int endPre, int[] inorder, int startIn, int endIn){
        if (startPre > endPre || startIn > endIn){
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode(preorder[startPre]);
        for (int i=startIn;i<=endIn;i++){
            if (inorder[i] == root.value){
                root.leftNode = construct(preorder, startPre+1, startPre+i-startIn, inorder, startIn, i-1);
                root.rightNode = construct(preorder, startPre+i-startIn+1, endPre, inorder, i+1, endIn);
            }
        }
        return root;
    }
}


