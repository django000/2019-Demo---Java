package com.vitoz.offer.chapter2;

import com.vitoz.offer.dataobjects.BinaryTreeNode;

/**
 * Created by zhengwentao on 2018/8/29.
 */
public class Demo8 {
    public static void main(String[] args) {
        BinaryTreeNode[] nodes = new BinaryTreeNode[9];
        int[] vals = {1,2,3,4,5,6,7,8,9};
        for (int i=0;i<vals.length;i++){
            nodes[i] = new BinaryTreeNode(vals[i]);
        }
        /*
         *        1
         *      /   \
         *     2     3
         *    / \   / \
         *   4   5  6  7
         *      / \
         *     8   9
         */

        // 左右节点关系
        nodes[0].leftNode = nodes[1];
        nodes[0].rightNode = nodes[2];
        nodes[1].leftNode = nodes[3];
        nodes[1].rightNode = nodes[4];
        nodes[2].leftNode = nodes[5];
        nodes[2].rightNode = nodes[6];
        nodes[4].leftNode = nodes[7];
        nodes[4].rightNode = nodes[8];
        // 父节点关系
        nodes[1].parentNode = nodes[0];
        nodes[2].parentNode = nodes[0];
        nodes[3].parentNode = nodes[1];
        nodes[4].parentNode = nodes[1];
        nodes[5].parentNode = nodes[2];
        nodes[6].parentNode = nodes[2];
        nodes[7].parentNode = nodes[4];
        nodes[8].parentNode = nodes[4];

        getNextNode(nodes[8]).printInorder();
    }

    private static BinaryTreeNode getNextNode(BinaryTreeNode pNode){
        if (pNode == null){
            return null;
        }
        BinaryTreeNode pNext;
        if (pNode.rightNode != null){
            pNext = pNode.rightNode;
            while (pNext.leftNode != null){
                pNext = pNext.leftNode;
            }
        }else{
            assert pNode.parentNode != null;
            BinaryTreeNode pParent = pNode.parentNode;
            while (pParent != null && pParent.rightNode == pNode){
                pNode = pParent;
                pParent = pParent.parentNode;
            }
            pNext = pParent;
        }
        return pNext;
    }
}
