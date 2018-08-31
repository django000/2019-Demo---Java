package com.vitoz.offer;

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
        list[0].printListNode();
        deleteDuplication(list[0]);
        list[0].printListNode();
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
            if (pNext.value == pNode.value){
                int value = pNode.value;
//                ListNode delNode = pNode;
//                while (delNode != null && delNode.value == value){
//                    pNext = delNode.next;
//                    delNode = pNext;
//                }
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
