package com.vitoz.offer.chapter4;

import com.vitoz.offer.dataobjects.BinaryTreeNode;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 02:48
 * @Description: 剑指offer面试题34——二叉树中和为某一值的路径
 */
public class Demo34 {
    public static void main(String[] args) {
        BinaryTreeNode[] nodes = new BinaryTreeNode[5];
        int[] arr = {10,5,12,4,7};
        for (int i=0;i<5;i++){
            nodes[i] = new BinaryTreeNode(arr[i]);
        }
        nodes[0].leftNode = nodes[1];
        nodes[0].rightNode = nodes[2];
        nodes[1].leftNode = nodes[3];
        nodes[1].rightNode = nodes[4];

        int expected = 22;
        findTreePath(nodes[0], expected);
    }

    private static void findTreePath(BinaryTreeNode root, int expected){
        if (root == null){
            return;
        }
        int current = 0;
        LinkedList<BinaryTreeNode> list = new LinkedList<>();
        findTreePath(root, list, current, expected);
    }

    /**
     *@描述  判断当前子树是否到达叶节点，如果到达则比较current与expected判断路径和是否满足，否则递归深入其左右子树继续判断
     *@参数  [当前二叉树根节点, 当前路径序列, 当前路径节点之和, 输入期望路径值]
     *@返回值  void
     *@创建人  vitoz
     *@创建时间  2018/9/2
     *@修改人和其它信息
     */
    private static void findTreePath(BinaryTreeNode root, LinkedList<BinaryTreeNode> list, int current, int expected){
        current += root.value;
        list.offerLast(root);

        if (root.leftNode == null && root.rightNode == null && current == expected){
            StringBuilder builder = new StringBuilder("A path is found: ");
            for (Iterator<BinaryTreeNode> iter = list.iterator(); iter.hasNext();){
                builder.append(iter.next().value+" ");
            }
            System.out.println(builder.toString().trim());
        }
        if (root.leftNode != null){
            findTreePath(root.leftNode, list, current, expected);
        }
        if (root.rightNode != null){
            findTreePath(root.rightNode, list, current, expected);
        }
        current -= root.value;
        list.pollLast();
    }
}
