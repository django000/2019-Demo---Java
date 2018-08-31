package com.vitoz.offer;

import java.util.Stack;

/**
 * Created by zhengwentao on 2018/8/27.
 */
public class Demo6 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

//        printListWithStack(node1);
        printListWithRecursion(node1);
    }

    public static void printListWithStack(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null){
            stack.push(node);
            node = node.next;
        }

        while (!stack.isEmpty()){
            node = stack.pop();
            System.out.print(node.value+", ");
        }
    }

    public static void printListWithRecursion(ListNode head){
        if (head != null){
            printListWithRecursion(head.next);
            System.out.print(head.value+", ");
        }
    }
}


