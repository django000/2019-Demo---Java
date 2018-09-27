package com.vitoz.offer.chapter3;

import com.vitoz.offer.dataobjects.ListNode;

import java.util.List;

/**
 * @Auther: vitoz
 * @Date: 2018/9/1 19:15
 * @Description: 剑指offer面试题24——反转链表，返回反转后的头结点
 */
public class Demo24 {
    public static void main(String[] args) {
        ListNode[] list = new ListNode[8];
        for (int i=0;i<8;i++){
            list[i] = new ListNode(i);
            if (i>0){
                list[i-1].next = list[i];
            }
        }
//        ListNode newRoot = getReverseList(list[0]);
//        newRoot.printListNode();
        ListNode newRoot2 = getReverseList2(list[0]);
        newRoot2.printListNode();
    }

    /**
     *@描述  给定链表的根节点，得到链表反转后的新根节点
     *@参数  [链表的根节点]
     *@返回值  反转后链表的根节点
     *@创建人  vitoz
     *@创建时间  2018/9/1
     *@修改人和其它信息
     */
    private static ListNode getReverseList(ListNode root){
        if (root == null){
            return null;
        }
        ListNode pPrev = null;
        ListNode pNode = root;
        ListNode pNext = root.next;

        while (pNext != null){
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
            pNext = pNext.next;
        }
        pNode.next = pPrev;
        return pNode;
    }

     private static ListNode getReverseList2(ListNode root){
        if (root == null){
            return null;
        }
        ListNode pPrev = null;
        ListNode pNode = root;
        ListNode pNext = null;
        while (pNode != null){
            pNext = pNode.next;
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        return pPrev;
     }
}
