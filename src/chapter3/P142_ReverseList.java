package chapter3;

import structure.ListNode;

/**
 * Created by ryder on 2017/7/14.
 * 反转链表
 */
public class P142_ReverseList {
    public static ListNode<Integer> reverseList(ListNode<Integer> head){
        if(head==null || head.next==null)
            return head;
        ListNode<Integer> pre = null;
        ListNode<Integer> cur = head;
        ListNode<Integer> post = head.next;
        while(true){
            cur.next = pre;
            pre = cur;
            cur = post;
            if(post!=null)
                post = post.next;
            else
                return pre;
        }
    }
    public static void main(String[] args){
        ListNode<Integer> head = new ListNode<>(1);
        head.next= new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        System.out.println(head);
        head = reverseList(head);
        System.out.println(head);
    }
}
