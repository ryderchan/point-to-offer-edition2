package chapter3;

import structure.ListNode;

/**
 * Created by ryder on 2017/7/14.
 * 合并两个排序的链表
 */
public class P145_MergeSortedLists {
    public static ListNode<Integer> merge(ListNode<Integer> head1,ListNode<Integer> head2){
        if(head1==null)
            return head2;
        if(head2==null)
            return head1;
       ListNode<Integer> index1 = head1;
       ListNode<Integer> index2 = head2;
       ListNode<Integer> index = null;
       if(index1.val<index2.val) {
           index = index1;
           index1 = index1.next;
       }
       else {
           index = index2;
           index2 = index2.next;
       }
       while(index1!=null && index2!=null){
           if(index1.val<index2.val) {
               index.next = index1;
               index = index.next;
               index1 = index1.next;
           }
           else {
               index.next = index2;
               index = index.next;
               index2 = index2.next;
           }
       }
       if(index1!=null)
           index.next = index1;
       else
           index.next = index2;
       return head1.val<head2.val?head1:head2;
    }
    public static void main(String[] args){
        ListNode<Integer> head1 = new ListNode<>(1);
        head1.next= new ListNode<>(3);
        head1.next.next = new ListNode<>(5);
        head1.next.next.next = new ListNode<>(7);
        ListNode<Integer> head2 = new ListNode<>(2);
        head2.next= new ListNode<>(4);
        head2.next.next = new ListNode<>(6);
        head2.next.next.next = new ListNode<>(8);
        System.out.println(head1);
        System.out.println(head2);
        ListNode<Integer> head =merge(head1,head2);
        System.out.println(head);
    }
}
