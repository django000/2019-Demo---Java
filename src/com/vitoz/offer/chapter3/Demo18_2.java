package com.vitoz.offer.chapter3;

import com.vitoz.offer.dataobjects.ListNode;

/**
 * Created by zhengwentao on 2018/8/31.
 */
public class Demo18_2 {
    public static void main(String[] args) {
        ListNode[] list = new ListNode[8];
        list[0] = new ListNode(1);
        list[1] = new ListNode(2);
        list[2] = new ListNode(2);
        list[3] = new ListNode(3);
        list[4] = new ListNode(4);
        list[5] = new ListNode(5);
        list[6] = new ListNode(5);
        list[7] = new ListNode(5);
        for (int i=0;i<7;i++){
            list[i].next = list[i+1];
        }
        ListNode.printListNode(list[0]);
        deleteDuplication(list[0]);
        ListNode.printListNode(list[0]);
    }

    private static void deleteDuplication(ListNode root){
        if (root == null || root.next == null){
            return;
        }

        ListNode preNode = null;
        ListNode pNode = root;
        ListNode pNext;
        while (pNode != null){
            pNext = pNode.next;
            if (pNext != null && pNext.value == pNode.value){
                int value = pNode.value;
                while (pNode != null && pNode.value == value){
                    pNode = pNode.next;
                }
                if (preNode == null){
                    root = pNode;
                }else {
                    preNode.next = pNode;
                }
            }else {
                preNode = pNode;
                pNode = pNode.next;
            }
        }
    }
}
