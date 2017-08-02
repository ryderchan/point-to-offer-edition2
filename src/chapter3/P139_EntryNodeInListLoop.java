package chapter3;

import structure.ListNode;

/**
 * Created by ryder on 2017/7/14.
 * 链表中环的入口节点
 */
public class P139_EntryNodeInListLoop {
    public static ListNode<Integer> meetingNode(ListNode<Integer> head){
        if(head==null)
            return null;
        ListNode<Integer> slow=head,fast=head;
        while(true){
            if(fast.next==null||fast.next.next==null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)
                break;
        }
        slow=head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public static void main(String[] args){
        //    1->2->3->4->5->6
        //          ↑_______↓
        ListNode<Integer> head = new ListNode<>(1);
        head.next= new ListNode<>(2);
        ListNode<Integer> node = new ListNode<>(3);
        head.next.next = node;
        node.next = new ListNode<>(4);
        node.next.next = new ListNode<>(5);
        node.next.next.next = new ListNode<>(6);
        node.next.next.next.next = node;
        ListNode<Integer> meet = meetingNode(head);
        if(meet==null)
            System.out.println("没有环");
        else
            System.out.println("环的入口值:"+meet.val);
    }
}
