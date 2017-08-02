package chapter3;

import structure.ListNode;

/**
 * Created by ryder on 2017/7/7.
 * 删除排序链表中的重复节点
 */
public class P122_deleteDuplicatedNode {
    public static ListNode<Integer> deleteDuplication(ListNode<Integer> head){
        if(head==null||head.next==null)
            return head;
        ListNode<Integer> pre = null;
        ListNode<Integer> cur = head;
        ListNode<Integer> post = head.next;
        boolean needDelete = false;
        while (post!=null){
            if(cur.val.equals(post.val)){
                needDelete = true;
                post=post.next;
            }
            else if(needDelete && !cur.val.equals(post.val)){
                if(pre==null)
                    head = post;
                else
                    pre.next=post;
                cur = post;
                post = post.next;
                needDelete = false;
            }
            else{
                pre = cur;
                cur = post;
                post = post.next;
            }
        }
        if(needDelete && pre!=null)
            pre.next = null;
        else if(needDelete && pre==null)
            head = null;
        return head;

    }
    public static void main(String[] args){
        ListNode<Integer> head = new ListNode<>(1);
        head.next= new ListNode<>(1);
        head.next.next = new ListNode<>(2);
        head.next.next.next = new ListNode<>(2);
        head.next.next.next.next = new ListNode<>(2);
        head.next.next.next.next.next = new ListNode<>(3);
        System.out.println(head);
        head = deleteDuplication(head);
        System.out.println(head);

    }
}
