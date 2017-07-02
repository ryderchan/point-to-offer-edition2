package chapter2;
import structure.ListNode;
import java.util.Stack;

/**
 * Created by ryder on 2017/6/13.
 * 从尾到头打印链表
 */
public class P58_PrintListInReversedOrder {
    //递归版
    public static void printReversinglyRecursively(ListNode<Integer> node){
        if(node==null)
            return;
        else{
            printReversinglyRecursively(node.next);
            System.out.println(node.val);
        }
    }
    //非递归版
    public static void printReversinglyIteratively(ListNode<Integer> node){
        Stack<Integer> stack = new Stack<>();
        for(ListNode<Integer> temp=node;temp!=null;temp=temp.next)
            stack.add(temp.val);
        while(!stack.isEmpty())
            System.out.println(stack.pop());
    }
    public static void main(String[] args){
        ListNode<Integer> head = new ListNode<Integer>(1);
        head.next = new ListNode<Integer>(2);
        head.next.next = new ListNode<Integer>(3);
        printReversinglyRecursively(head);
        System.out.println();
        printReversinglyIteratively(head);
    }
}
