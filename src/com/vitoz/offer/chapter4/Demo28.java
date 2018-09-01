package com.vitoz.offer.chapter4;

import com.vitoz.offer.dataobjects.BinaryTreeNode;

/**
 * @Auther: vitoz
 * @Date: 2018/9/1 22:59
 * @Description: 剑指offer面试题28——判断某二叉树是否对称
 */
public class Demo28 {
    public static void main(String[] args) {
        BinaryTreeNode[] nodes = new BinaryTreeNode[7];
        int[] arr = {8,6,6,5,7,7,5};
        for (int i=0;i<7;i++){
            nodes[i] = new BinaryTreeNode(arr[i]);
        }
        nodes[0].leftNode = nodes[1];
        nodes[0].rightNode = nodes[2];
        nodes[1].leftNode = nodes[3];
        nodes[1].rightNode = nodes[4];
        nodes[2].leftNode = nodes[5];
        nodes[2].rightNode = nodes[6];

        nodes[0].printPreorder();
        System.out.println(isSymmetrical(nodes[0]));
    }

    private static boolean isSymmetrical(BinaryTreeNode root){
        return isSymmetrical(root, root);
    }

    /**
     *@描述  递归方法对于两个子树是否对称进行判断
     *@参数  [子树A的根节点, 子树B的根节点]
     *@返回值  两个子树是否对称
     *@创建人  vitoz
     *@创建时间  2018/9/1
     *@修改人和其它信息
     */
    private static boolean isSymmetrical(BinaryTreeNode rootA, BinaryTreeNode rootB){
        // 两者都为null则返回true
        if (rootA == rootB && rootA == null){
            return true;
        }
        // 有且仅有一个为null则返回false
        if (rootA == null || rootB == null){
            return false;
        }

        // 都不为null则根据value值以及左右子树递归判断
        return rootA.value == rootB.value && isSymmetrical(rootA.leftNode, rootB.rightNode) && isSymmetrical(rootA.rightNode, rootB.leftNode);
    }
}
