package com.vitoz.offer.chapter3;

import com.vitoz.offer.dataobjects.ListNode;

/**
 * Created by zhengwentao on 2018/8/31.
 */
public class Demo18_1 {
    public static void main(String[] args) {
        ListNode[] list = new ListNode[6];
        for (int i=0;i<6;i++){
            list[i] = new ListNode(i);
            if (i>0){
                list[i-1].next = list[i];
            }
        }
        ListNode.printListNode(list[0]);
        deleteListNode(list[0], list[2]);
        ListNode.printListNode(list[0]);
    }

    /**
     * @Author vitoz
     * @Description 该方法对于给定输入链表头结点，根据待删除的节点的不同位置进行不同删除操作
     * @Date 2018/8/31 16:53
     * @Param [root, delete]
     * @return void
     **/
    private static void deleteListNode(ListNode root, ListNode delete){
        if (root == null || delete == null){
            return;
        }

        if (root.equals(delete)){
            root = root.next;
            delete.next = null;
            return;
        }

        ListNode tmp = delete.next;
        if (tmp == null){
            tmp = root;
            while (tmp.next != delete && tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = null;
        }else{
            delete.value = tmp.value;
            delete.next = tmp.next;
            tmp.next = null;
        }
    }
}
