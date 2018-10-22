package com.vitoz.offer.dataobjects;

import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Auther: vitoz
 * @Date: 2018/9/1 20:58
 * @Description: 剑指offer面试题
 */
public class BinaryTreeNode{
    public int value;
    public BinaryTreeNode leftNode = null;
    public BinaryTreeNode rightNode = null;
    public BinaryTreeNode parentNode = null;
    public BinaryTreeNode(int value){
        this(value, null, null, null);
    }

    public BinaryTreeNode(int value, BinaryTreeNode leftNode, BinaryTreeNode rightNode){
        this(value, leftNode, rightNode, null);
    }
    public BinaryTreeNode(int value, BinaryTreeNode leftNode, BinaryTreeNode rightNode, BinaryTreeNode parentNode){
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.parentNode = parentNode;
    }

    public static void printPreorder(BinaryTreeNode node){
        if (node != null){
            System.out.print(node.value+" ");
            printPreorder(node.leftNode);
            printPreorder(node.rightNode);
        }
    }
    public static void printPreorder2(BinaryTreeNode root){
        if (root == null){
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        BinaryTreeNode node = root;
        while (node != null || !stack.isEmpty()){
            while (node != null){
                stack.push(node);
                sb.append(node.value + " ");
                node = node.leftNode;
            }
            if (!stack.isEmpty()){
                node = stack.pop();
                node = node.rightNode;
            }
        }
        System.out.println(sb.toString().trim());
    }
    public static void printInorder(BinaryTreeNode node){
        if (node != null){
            printInorder(node.leftNode);
            System.out.print(node.value+" ");
            printInorder(node.rightNode);
        }
    }
    public static void printInorder2(BinaryTreeNode root){
        if (root == null){
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        BinaryTreeNode node = root;
        while (node != null || !stack.isEmpty()){
            while (node != null){
                stack.push(node);
                node = node.leftNode;
            }
            if (!stack.isEmpty()){
                node = stack.pop();
                sb.append(node.value+" ");
                node = node.rightNode;
            }
        }
        System.out.println(sb.toString().trim());
    }
    public static void printPostorder(BinaryTreeNode node){
        if (node != null){
            printPostorder(node.leftNode);
            printPostorder(node.rightNode);
            System.out.print(node.value+" ");
        }
    }

    // 从上到下打印二叉树，各层分开
    public static void printVerorder(BinaryTreeNode root){
        if (root == null){
            return;
        }
        LinkedBlockingQueue<BinaryTreeNode> queue = new LinkedBlockingQueue<> ();
        queue.offer(root);
        int toBePrinted = 1;
        int nextLevel = 0;
        BinaryTreeNode tmpNode;
        while (!queue.isEmpty()){
            tmpNode = queue.poll();
            System.out.print(tmpNode.value+" ");
            toBePrinted--;
            if (tmpNode.leftNode != null){
                queue.offer(tmpNode.leftNode);
                nextLevel++;
            }
            if (tmpNode.rightNode != null){
                queue.offer(tmpNode.rightNode);
                nextLevel++;
            }
            if (toBePrinted == 0){
                System.out.println();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
    }

    // 从上到下之字形打印二叉树，各层分开
    public static void printVerorderZ(BinaryTreeNode root){
        if (root == null){
            return;
        }
        Stack[] stacks = {new Stack<BinaryTreeNode>(), new Stack<BinaryTreeNode>()};
        int flag = 0;
        BinaryTreeNode tmpNode;
        stacks[flag].push(root);
        while (!stacks[0].isEmpty() || !stacks[1].isEmpty()){
            tmpNode = (BinaryTreeNode) stacks[flag].pop();
            System.out.print(tmpNode.value+" ");
            if (flag == 0){
                if (tmpNode.leftNode != null){
                    stacks[flag^1].push(tmpNode.leftNode);
                }
                if (tmpNode.rightNode != null){
                    stacks[flag^1].push(tmpNode.rightNode);
                }
            }else {
                if (tmpNode.rightNode != null){
                    stacks[flag^1].push(tmpNode.rightNode);
                }
                if (tmpNode.leftNode != null){
                    stacks[flag^1].push(tmpNode.leftNode);
                }
            }

            if (stacks[flag].isEmpty()){
                System.out.println();
                flag ^= 1;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder()
                .append("{value=")
                .append(this.value)
                .append(", parent=")
                .append(parentNode!=null?parentNode.value:"null")
                .append(", left=")
                .append(leftNode!=null?leftNode.value:"null")
                .append(", right=")
                .append(rightNode!=null?rightNode.value:"null")
                .append("}");
        return builder.toString();
    }
}
