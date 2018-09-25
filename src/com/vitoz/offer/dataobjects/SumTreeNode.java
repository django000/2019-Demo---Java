package com.vitoz.offer.dataobjects;


import java.util.Scanner;

/**
 * @Auther: vitoz
 * @Date: 2018/9/25 19:54
 * @Description:
 */
public class SumTreeNode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strPre = sc.nextLine().trim().split(" ");
        String[] strIn = sc.nextLine().trim().split(" ");
        int len = strPre.length;
        int[] pre = new int[len];
        int[] in = new int[len];
        for (int i=0;i<len;i++){
            pre[i] = Integer.parseInt(strPre[i]);
            in[i] = Integer.parseInt(strIn[i]);
        }
        TreeNode root = constructTree(pre, in);
        TreeNode newRoot = constructSumTree(root);
        StringBuilder builder = new StringBuilder();
        printInorder(newRoot, builder);
        System.out.println(builder.toString().trim());
    }

    private static void printInorder(TreeNode root, StringBuilder builder){
        if (root == null){
            return;
        }else {
            printInorder(root.leftNode, builder);
            builder.append(root.value+" ");
            printInorder(root.rightNode, builder);
        }
    }
    private static TreeNode constructSumTree(TreeNode root){
        if (root != null && root.leftNode != null && root.rightNode != null){
            TreeNode left = constructSumTree(root.leftNode);
            TreeNode right = constructSumTree(root.rightNode);
            TreeNode newRoot = new TreeNode(root.leftNode.value+root.rightNode.value+left.value+right.value);
            newRoot.leftNode = left;
            newRoot.rightNode = right;
            return newRoot;
        }else {
            return new TreeNode(0);
        }

    }
    private static TreeNode constructTree(int[] preorder, int[] inorder){
        return constructTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private static TreeNode constructTree(int[] preorder, int startPre, int endPre, int[] inorder, int startIn, int endIn){
        if (startPre > endPre || startIn > endIn){
            return null;
        }
        TreeNode root = new TreeNode(preorder[startPre]);
        for (int i=startIn;i<=endIn;i++){
            if (inorder[i] == root.value){
                root.leftNode = constructTree(preorder, startPre+1, startPre+i-startIn, inorder, startIn, i-1);
                root.rightNode = constructTree(preorder, startPre+i-startIn+1, endPre, inorder, i+1, endIn);
            }
        }
        return root;
    }

}

class TreeNode{
    public int value;
    public TreeNode leftNode = null;
    public TreeNode rightNode = null;
    public TreeNode(int value){
        this.value = value;
    }
}
