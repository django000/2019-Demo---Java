package com.vitoz.offer.chapter6;

import com.vitoz.offer.dataobjects.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: vitoz
 * @Date: 2018/10/21 0:27
 * @Description: 剑指offer面试题68——树中两个节点的最低公共祖先
 */
public class Demo68 {
    public static void main(String[] args) {
        BinaryTreeNode[] nodes = new BinaryTreeNode[9];
        for (int i=0;i<9;i++){
            nodes[i] = new BinaryTreeNode(i+1);
        }
        nodes[0].leftNode = nodes[1];
        nodes[0].rightNode = nodes[2];
        nodes[1].leftNode = nodes[3];
        nodes[1].rightNode = nodes[4];
        nodes[3].leftNode = nodes[5];
        nodes[3].rightNode = nodes[6];
        nodes[4].leftNode = nodes[7];
        nodes[4].rightNode = nodes[8];
        BinaryTreeNode node = getLastCommonParent(nodes[0], nodes[5], nodes[7]);
        System.out.println(node);
    }

    private static BinaryTreeNode getLastCommonParent(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2){
        if (root == null || node1 == null || node2 == null){
            return null;
        }
        LinkedList<BinaryTreeNode> path1 = new LinkedList<>();
        LinkedList<BinaryTreeNode> path2 = new LinkedList<>();
        getNodePath(root, node1, path1);
        getNodePath(root, node2, path2);
        BinaryTreeNode node = null;
        Iterator<BinaryTreeNode> iter1 = path1.iterator();
        Iterator<BinaryTreeNode> iter2 = path2.iterator();
        while (iter1.hasNext() && iter2.hasNext()){
            BinaryTreeNode tmp1 = iter1.next();
            BinaryTreeNode tmp2 = iter2.next();
            if (tmp1 == tmp2){
                node = tmp1;
            }
        }
        return node;
    }

    private static boolean getNodePath(BinaryTreeNode root, BinaryTreeNode node, LinkedList<BinaryTreeNode> path){
        if (root == node){
            return true;
        }
        path.offerLast(root);
        boolean found = false;
        if (!found && root != null && root.leftNode != null){
            found = getNodePath(root.leftNode, node, path);
        }
        if (!found && root != null && root.rightNode != null){
            found = getNodePath(root.rightNode, node, path);
        }
        if (!found){
            path.pollLast();
        }
        return found;
    }
}
