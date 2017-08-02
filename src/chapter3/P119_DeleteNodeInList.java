package chapter3;

import structure.ListNode;

/**
 * Created by ryder on 2017/7/7.
 * o(1)时间删除链表的节点
 */
public class P119_DeleteNodeInList {
    public static ListNode<Integer> deleteNode(ListNode<Integer> head,ListNode<Integer> node){
        if(node==head){
            return head.next;
        }
        else if(node.next!=null){
            node.val = node.next.val;
            node.next = node.next.next;
            return head;
        }
        else{
            ListNode<Integer> temp=head;
            while(temp.next!=node)
                temp = temp.next;
            temp.next = null;
            return head;
        }
    }
    public static void main(String[] args){
        ListNode<Integer> head = new ListNode<>(1);
        ListNode<Integer> node2 = new ListNode<>(2);
        ListNode<Integer> node3 = new ListNode<>(3);
        head.next = node2;
        node2.next = node3;
        System.out.println(head);
        head = deleteNode(head,node3);
        System.out.println(head);
        head = deleteNode(head,head);
        System.out.println(head);
    }
}
