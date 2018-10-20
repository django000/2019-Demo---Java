package com.vitoz.offer.chapter5;

import com.vitoz.offer.dataobjects.ListNode;

/**
 * @Auther: vitoz
 * @Date: 2018/10/20 21:59
 * @Description: 剑指offer面试题52——两个链表的第一个公共节点
 */
public class Demo52 {
    public static void main(String[] args) {
        ListNode[] nodes = new ListNode[7];
        for (int i=0;i<7;i++){
            nodes[i] = new ListNode(i+1);
        }
        nodes[0].next = nodes[1];
        nodes[1].next = nodes[2];
        nodes[2].next = nodes[5];
        nodes[3].next = nodes[4];
        nodes[4].next = nodes[5];
        nodes[5].next = nodes[6];
        System.out.println(getFirstCommonNode(nodes[0], nodes[3]));
    }

    private static ListNode getFirstCommonNode(ListNode first, ListNode second){
        if (first == null || second == null){
            return null;
        }
        int firstLen = getNodeLength(first);
        int secondLen = getNodeLength(second);
        ListNode pLong = first;
        ListNode pShort = second;
        if (firstLen < secondLen){
            pLong = second;
            pShort = first;
        }
        for (int i=0;i<Math.abs(firstLen-secondLen);i++){
            pLong = pLong.next;
        }
        while (pLong != null && pShort != null && pLong != pShort){
            pLong = pLong.next;
            pShort = pShort.next;
        }
        return pLong;
    }

    private static int getNodeLength(ListNode root){
        int len = 0;
        ListNode node = root;
        while (node != null){
            len++;
            node = node.next;
        }
        return len;
    }
}
