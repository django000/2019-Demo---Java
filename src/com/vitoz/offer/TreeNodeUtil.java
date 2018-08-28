package com.vitoz.offer;

/**
 * Created by zhengwentao on 2018/8/28.
 */
public class TreeNodeUtil {
    public static void printPreorder(BinaryTreeNode root){
        if (root != null){
            System.out.println(root.value);
            printPreorder(root.leftNode);
            printPreorder(root.rightNode);
        }
    }

    public static void printInorder(BinaryTreeNode root){
        if (root != null){
            printInorder(root.leftNode);
            System.out.println(root.value);
            printInorder(root.rightNode);
        }
    }

    public static void printPostorder(BinaryTreeNode root){
        if (root != null){
            printPostorder(root.leftNode);
            printPostorder(root.rightNode);
            System.out.println(root.value);
        }
    }
}

class BinaryTreeNode{
    int value;
    BinaryTreeNode leftNode = null;
    BinaryTreeNode rightNode = null;
    public BinaryTreeNode(int value){
        this.value = value;
    }

    public BinaryTreeNode(int value, BinaryTreeNode leftNode, BinaryTreeNode rightNode){
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
}