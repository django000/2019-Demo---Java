package com.vitoz.offer.chapter4;

import com.vitoz.offer.dataobjects.ComplexListNode;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 10:18
 * @Description: 剑指offer面试题35——复制复杂链表
 */
public class Demo35 {
    public static void main(String[] args) {
        ComplexListNode[] nodes = new ComplexListNode[5];
        int[] arr = {1,2,3,4,5};
        for (int i=0;i<5;i++){
            nodes[i] = new ComplexListNode(arr[i]);
            if (i>0){
                nodes[i-1].next = nodes[i];
            }
        }
        nodes[0].sibling = nodes[2];
        nodes[1].sibling = nodes[4];
        nodes[3].sibling = nodes[1];

        nodes[0].printListNode();
        ComplexListNode node = clone(nodes[0]);
        if (node != null){
            node.printListNode();
        }
    }

    private static ComplexListNode clone(ComplexListNode pHead){
        cloneNodes(pHead);
        connectSiblingNodes(pHead);
        return reconstructNodes(pHead);
    }

    private static void cloneNodes(ComplexListNode pHead){
        ComplexListNode tmp, pNode = pHead;
        while (pNode != null){
            tmp = new ComplexListNode(pNode.value);
            tmp.next = pNode.next;
            pNode.next = tmp;
            pNode = tmp.next;
        }
    }

    private static void connectSiblingNodes(ComplexListNode pHead){
        ComplexListNode tmp, pNode = pHead;
        while (pNode != null){
            tmp = pNode.next;
            if (pNode.sibling != null){
                tmp.sibling = pNode.sibling.next;
            }
            pNode = tmp.next;
        }
    }

    private static ComplexListNode reconstructNodes(ComplexListNode pHead){
        ComplexListNode tmp, pNode = pHead;
        ComplexListNode pNewHead = null;
        if (pNode != null){
            pNewHead = pNode.next;
        }
        while (pNode != null){
            tmp = pNode.next;
            pNode.next = tmp.next;
            pNode = pNode.next;
        }
        return pNewHead;
    }
}
