package com.vitoz.offer.chapter3;

import com.vitoz.offer.dataobjects.ListNode;

/**
 * @Auther: vitoz
 * @Date: 2018/9/1 20:30
 * @Description: 剑指offer面试题25——合并两个有序链表
 */
public class Demo25 {
    public static void main(String[] args) {
        ListNode[] list1 = new ListNode[4];
        ListNode[] list2 = new ListNode[4];
        for (int i=0;i<4;i++){
            list1[i] = new ListNode(2*i+1);
            list2[i] = new ListNode(2*i+2);
            if (i>0){
                list1[i-1].next = list1[i];
                list2[i-1].next = list2[i];
            }
        }
//        mergeOrderList(list1[0], list2[0]).printListNode();
        mergeOrderListRecursion(list1[0], list2[0]).printListNode();
    }

    /**
     *@描述  给定两个有序链表，采用非递归的方法合并，相对递归比较冗长
     *@参数  [有序链表1的根节点, 有序链表2的根节点]
     *@返回值  合并后有序链表的根节点
     *@创建人  vitoz
     *@创建时间  2018/9/1
     *@修改人和其它信息
     */
    private static ListNode mergeOrderList(ListNode node1, ListNode node2){
        if (node1 == null){
            return node2;
        }
        if (node2 == null){
            return node1;
        }

        ListNode mergeNode = null;
        ListNode mergeHead = null;
        boolean flag = false;
        while (node1 != null && node2 != null){
            if (node1.value < node2.value){
                if (mergeNode != null){
                    mergeNode.next = node1;
                }
                mergeNode = node1;
                node1 = node1.next;
            }else {
                if (mergeNode != null){
                    mergeNode.next = node2;
                }
                mergeNode = node2;
                node2 = node2.next;
            }
            if (!flag){
                mergeHead = mergeNode;
                flag = true;
            }
        }

        if (node1 != null){
            mergeNode.next = node1;
        }
        if (node2 != null){
            mergeNode.next = node2;
        }
        return mergeHead;
    }

    /**
     *@描述  给定两个有序链表，采用递归的方法合并，代码简洁但容易导致栈内存溢出
     *@参数  [有序链表1的根节点, 有序链表2的根节点]
     *@返回值  合并后有序链表的根节点
     *@创建人  vitoz
     *@创建时间  2018/9/1
     *@修改人和其它信息
     */
    private static ListNode mergeOrderListRecursion(ListNode node1, ListNode node2){
        if (node1 == null){
            return node2;
        }
        if (node2 == null){
            return node1;
        }
        ListNode mergeNode = null;
        if (node1.value < node2.value){
            mergeNode = node1;
            mergeNode.next = mergeOrderListRecursion(node1.next, node2);
        }else {
            mergeNode = node2;
            mergeNode.next = mergeOrderListRecursion(node1, node2.next);
        }
        return mergeNode;
    }
}
