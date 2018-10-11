package com.vitoz.offer.chapter4;

import com.vitoz.offer.dataobjects.BinaryTreeNode;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 11:17
 * @Description: 剑指offer面试题36——二叉搜索树转双向链表（！没跑通）
 */
public class Demo36 {
    public static void main(String[] args) {
        BinaryTreeNode[] nodes = new BinaryTreeNode[7];
        int[] arr = {10,6,14,4,8,12,16};
        for (int i=0;i<7;i++){
            nodes[i] = new BinaryTreeNode(arr[i]);
        }
        nodes[0].leftNode = nodes[1];
        nodes[0].rightNode = nodes[2];
        nodes[1].leftNode = nodes[3];
        nodes[1].rightNode = nodes[4];
        nodes[2].leftNode = nodes[5];
        nodes[2].rightNode = nodes[6];
        BinaryTreeNode.printPreorder(nodes[0]);
        System.out.println(convert(nodes[0]));
    }

    private static BinaryTreeNode convert(BinaryTreeNode root){
        BinaryTreeNode pLast = null;
        convertCore(root, pLast);
        BinaryTreeNode pHead = pLast;
        while (pHead != null && pHead.leftNode != null){
            pHead = pHead.leftNode;
        }
        return pHead;
    }

    private static void convertCore(BinaryTreeNode pRoot, BinaryTreeNode pLast){
        if (pRoot == null){
            return;
        }
        BinaryTreeNode pCur = pRoot;
        if (pCur.leftNode != null){
            convertCore(pCur.leftNode, pLast);
        }
        pCur.leftNode = pLast;
        if (pLast != null){
            pLast.rightNode = pCur;
        }
        pLast = pCur;
        if (pCur.rightNode != null){
            convertCore(pCur.rightNode, pLast);
        }
    }

    public static void convertNode(BinaryTreeNode node, BinaryTreeNode lastNodeInList) {
        if(node == null){
            return ;
        }

        BinaryTreeNode currentNode = node;
        if(currentNode.leftNode != null){
            convertNode(currentNode.leftNode, lastNodeInList);
        }
        currentNode.leftNode = lastNodeInList;
        if(lastNodeInList != null){
            lastNodeInList.rightNode = currentNode;
        }
        lastNodeInList = currentNode;
        if(currentNode.rightNode != null){
            convertNode(currentNode.rightNode, lastNodeInList);
        }
    }
}
