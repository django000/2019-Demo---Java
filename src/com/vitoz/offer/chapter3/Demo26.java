package com.vitoz.offer.chapter3;

import com.vitoz.offer.dataobjects.BinaryTreeNode;

/**
 * @Auther: vitoz
 * @Date: 2018/9/1 21:19
 * @Description: 剑指offer面试题26——判断A树是否包含B树（为了简便，本例中树节点值简化为整数）
 */
public class Demo26 {
    public static void main(String[] args) {
        BinaryTreeNode[] nodesA = new BinaryTreeNode[7];
        BinaryTreeNode[] nodesB = new BinaryTreeNode[3];
        int[] arrA = {8,8,7,9,2,4,7};
        int[] arrB = {8,9,2};
        for (int i=0;i<7;i++){
            nodesA[i] = new BinaryTreeNode(arrA[i]);
        }
        for (int i=0;i<3;i++){
            nodesB[i] = new BinaryTreeNode(arrB[i]);
        }
        nodesA[0].leftNode = nodesA[1];
        nodesA[0].rightNode = nodesA[2];
        nodesA[1].leftNode = nodesA[3];
        nodesA[1].rightNode = nodesA[4];
        nodesA[4].leftNode = nodesA[5];
        nodesA[4].rightNode = nodesA[6];
        nodesB[0].leftNode = nodesB[1];
        nodesB[0].rightNode = nodesB[2];

        System.out.println(isSubTree(nodesA[0], nodesB[0]));
    }

    /**
     *@描述  判断A树是否包含B树的主函数（递归判断A树及其子树是否包含B树）
     *@参数  [二叉树A, 二叉树B]
     *@返回值  二叉树A是否二叉树B
     *@创建人  vitoz
     *@创建时间  2018/9/1
     *@修改人和其它信息
     */
    private static boolean isSubTree(BinaryTreeNode rootA, BinaryTreeNode rootB){
        boolean result = false;
        if (rootA != null && rootB != null){
            result = isSubTreeCore(rootA, rootB)
                || isSubTree(rootA.leftNode, rootB)
                || isSubTree(rootA.rightNode, rootB);
        }
        return result;
    }

    /**
     *@描述  给定A树、B树的根节点，是否A树包含B树（递归判断子树是否包含）
     *@参数  [二叉树A, 二叉树B]
     *@返回值  boolean
     *@创建人  vitoz
     *@创建时间  2018/9/1
     *@修改人和其它信息
     */
    private static boolean isSubTreeCore(BinaryTreeNode rootA, BinaryTreeNode rootB){
        if (rootB == null){
            return true;
        }
        if (rootA == null){
            return false;
        }

        return rootA.value == rootB.value && isSubTreeCore(rootA.leftNode, rootB.leftNode)&&isSubTreeCore(rootA.rightNode, rootB.rightNode);
    }
}
