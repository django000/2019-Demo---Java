package com.vitoz.offer.chapter3;

import com.vitoz.offer.dataobjects.ListNode;

/**
 * @Auther: vitoz
 * @Date: 2018/9/1 19:15
 * @Description: 剑指offer面试题23——得到链表中环的入口节点（没有环则返回null）
 */
public class Demo23 {
    public static void main(String[] args) {
        ListNode[] list = new ListNode[8];
        for (int i=0;i<8;i++){
            list[i] = new ListNode(i);
            if (i>0){
                list[i-1].next = list[i];
            }
        }
        list[7].next = list[3];
        System.out.println(getEntryNode(list[0]));
    }

    /**
     *@描述 根据给定链表，如果有环，判断其中环的入口点
     *@参数  [单向链表的起点]
     *@返回值  链表中若存在环，则返回环中入口点；否则返回null
     *@创建人  vitoz
     *@创建时间  2018/9/1
     *@修改人和其它信息
     */
    private static ListNode getEntryNode(ListNode root){
        ListNode mNode= getMeetingNode(root);
        if (mNode == null){
            return null;
        }

        int sizeOfLoop = 1;
        ListNode pNode = mNode.next;
        while (pNode != mNode){
            pNode = pNode.next;
            sizeOfLoop++;
        }

        pNode = root;
        for (int i=0;i<sizeOfLoop;i++){
            pNode = pNode.next;
        }
        ListNode pSlow = root;
        while (pSlow != pNode){
            pSlow = pSlow.next;
            pNode = pNode.next;
        }
        return pNode;
    }

    /**
     *@描述 根据给定链表，如果其中存在环，返回环中某个节点；否则返回null
     *@参数  [单向链表的起点]
     *@返回值  链表中若存在环，则返回环中某个节点
     *@创建人  vitoz
     *@创建时间  2018/9/1
     *@修改人和其它信息
     */
    private static ListNode getMeetingNode(ListNode root){
        ListNode pSlow = root;
        ListNode pFast = root;
        while (pSlow != null && pFast != null){
            pSlow = pSlow.next;
            pFast = pFast.next;
            if (pFast != null){
                pFast = pFast.next;
            }
            if (pFast == pSlow){
                return pFast;
            }
        }
        return null;
    }
}
