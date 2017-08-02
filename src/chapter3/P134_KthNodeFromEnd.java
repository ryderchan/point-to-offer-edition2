package chapter3;

import structure.ListNode;

/**
 * Created by ryder on 2017/7/14.
 * 链表中倒数第k个节点
 */
public class P134_KthNodeFromEnd {
    public static ListNode<Integer> findKthToTail(ListNode<Integer> head,int k){
        if(head==null||k==0)
            return null;
        ListNode<Integer> slow=head,fast=head;
        for(int i=0;i<k;i++){
            //i==k-1,第三个测试例通不过
            if(fast.next!=null || i==k-1)
                fast = fast.next;
            else
                return null;
        }
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public static void main(String[] args){
        ListNode<Integer> head = new ListNode<>(1);
        head.next= new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        System.out.println(findKthToTail(head,1).val);
        System.out.println(findKthToTail(head,2).val);
        System.out.println(findKthToTail(head,3).val);
        System.out.println(findKthToTail(head,4));
    }
}
