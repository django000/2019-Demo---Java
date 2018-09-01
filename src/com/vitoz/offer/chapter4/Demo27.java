package com.vitoz.offer.chapter4;

import com.vitoz.offer.dataobjects.BinaryTreeNode;

/**
 * @Auther: vitoz
 * @Date: 2018/9/1 22:15
 * @Description: 剑指offer面试题27——打印二叉树的镜像
 */
public class Demo27 {
    public static void main(String[] args) {
        BinaryTreeNode[] nodes = new BinaryTreeNode[7];
        int[] arr = {8,6,10,5,7,9,11};
        for (int i=0;i<7;i++){
            nodes[i] = new BinaryTreeNode(arr[i]);
        }
        nodes[0].leftNode = nodes[1];
        nodes[0].rightNode = nodes[2];
        nodes[1].leftNode = nodes[3];
        nodes[1].rightNode = nodes[4];
        nodes[2].leftNode = nodes[5];
        nodes[2].rightNode = nodes[6];

        nodes[0].printInorder();
        System.out.println();
        mirrorRecursion(nodes[0]);
        nodes[0].printInorder();
    }

    private static void mirrorRecursion(BinaryTreeNode root){
        if (root == null || (root.leftNode == null) && (root.rightNode == null)){
            return;
        }
        BinaryTreeNode tmp = root.leftNode;
        root.leftNode = root.rightNode;
        root.rightNode = tmp;
        if (root.leftNode != null){
            mirrorRecursion(root.leftNode);
        }
        if (root.rightNode != null){
            mirrorRecursion(root.rightNode);
        }
    }
}
