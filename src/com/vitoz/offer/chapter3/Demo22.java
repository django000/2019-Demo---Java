package com.vitoz.offer.chapter3;

import com.vitoz.offer.dataobjects.ListNode;

public class Demo22 {
    public static void main(String[] args) {
        ListNode[] list = new ListNode[8];
        for (int i=0;i<8;i++){
            list[i] = new ListNode(i);
            if (i>0){
                list[i-1].next = list[i];
            }
        }
        ListNode.printListNode(list[0]);
        System.out.println(findKthToTail(list[0], 3));
    }

    private static ListNode findKthToTail(ListNode root, int k){
        if (root == null || k <=0){
            return null;
        }
        ListNode pHead = root;
        ListNode pBehind = root;
        for (int i=0;i<k-1;i++){
            if (pHead.next == null){
                return null;
            }
            pHead = pHead.next;
        }
        while (pHead.next != null){
            pHead = pHead.next;
            pBehind = pBehind.next;
        }
        return pBehind;
    }
}
