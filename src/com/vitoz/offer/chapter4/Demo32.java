package com.vitoz.offer.chapter4;

import com.vitoz.offer.dataobjects.BinaryTreeNode;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 01:03
 * @Description: 剑指offer面试题32——从上到下打印二叉树
 */
public class Demo32 {
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

        BinaryTreeNode.printInorder2(nodes[0]);
        // 分层打印该二叉树
        BinaryTreeNode.printVerorder(nodes[0]);
        // 分层且之字形打印该二叉树
        BinaryTreeNode.printVerorderZ(nodes[0]);
    }
}
