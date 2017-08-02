package chapter4;

import sun.plugin2.gluegen.runtime.CPU;

import java.util.HashMap;

/**
 * Created by ryder on 2017/7/18.
 * 复制复杂链表
 */
public class P187_CopyComplexList {
    public static class ComplexListNode{
        int val;
        ComplexListNode next;
        ComplexListNode random;

        public ComplexListNode(int val) {
            this.val = val;
        }
        @Override
        public String toString() {
            StringBuilder ret = new StringBuilder();
            ComplexListNode cur = this;
            while(cur!=null) {
                ret.append(cur.val);
                if(cur.random!=null)
                    ret.append("("+cur.random.val+")");
                else{
                    ret.append("(_)");
                }
                ret.append('\t');
                cur = cur.next;
            }
            return ret.toString();
        }
    }
    //time:o(n^2) space:o(1) 新链表使用的空间不算入
    //先复制val与next（时间o(n)），再复制random域（时间o(n^2)）
    public static ComplexListNode clone1(ComplexListNode head){
        if(head==null)
            return null;
        ComplexListNode newHead = new ComplexListNode(head.val);
        ComplexListNode cur = head.next;
        ComplexListNode newCur = null;
        ComplexListNode newCurPrev = newHead;
        while (cur!=null){
            newCur = new ComplexListNode(cur.val);
            newCurPrev.next = newCur;
            newCurPrev = newCurPrev.next;
            cur = cur.next;
        }
        cur = head;
        newCur = newHead;
        ComplexListNode temp = head;
        ComplexListNode newTemp = newHead;
        while(cur!=null){
            if(cur.random!=null){
                temp = head;
                newTemp = newHead;
                while (temp!=cur.random){
                    temp = temp.next;
                    newTemp = newTemp.next;
                }
                newCur.random = newTemp;
            }
            cur = cur.next;
            newCur = newCur.next;
        }
        return newHead;
    }
    //time:o(n) space:o(n)
    //使用o(n)的空间，换取了时间复杂度的降低
    public static ComplexListNode clone2(ComplexListNode head) {
        if(head==null)
            return null;
        HashMap<ComplexListNode,ComplexListNode> oldToNew = new HashMap<>();
        ComplexListNode newHead = new ComplexListNode(head.val);
        oldToNew.put(head,newHead);
        ComplexListNode cur = head.next;
        ComplexListNode newCur = null;
        ComplexListNode newCurPrev = newHead;
        while (cur!=null){
            newCur = new ComplexListNode(cur.val);
            oldToNew.put(cur,newCur);
            newCurPrev.next = newCur;
            newCurPrev = newCurPrev.next;
            cur = cur.next;
        }
        cur = head;
        newCur = newHead;
        while(cur!=null){
            if(cur.random!=null){
                newCur.random = oldToNew.get(cur.random);
            }
            cur = cur.next;
            newCur = newCur.next;
        }
        return newHead;
    }
    //time:o(n) space:o(1)
    public static ComplexListNode clone3(ComplexListNode head) {
        if(head==null)
            return null;
        cloneNodes(head);
        connectRandomNodes(head);
        return reconnectNodes(head);
    }
    public static void cloneNodes(ComplexListNode head){
        ComplexListNode cur = head;
        ComplexListNode temp = null;
        while (cur!=null){
            temp = new ComplexListNode(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }
    }
    public static void connectRandomNodes(ComplexListNode head){
        ComplexListNode cur = head;
        ComplexListNode curNext = head.next;
        while (true){
            if(cur.random!=null)
                curNext.random = cur.random.next;
            cur = cur.next.next;
            if(cur == null)
                break;
            curNext = curNext.next.next;
        }
    }
    public static ComplexListNode reconnectNodes(ComplexListNode head){
        ComplexListNode newHead = head.next;
        ComplexListNode cur = head;
        ComplexListNode newCur = newHead;
        while (true){
            cur.next = cur.next.next;
            cur = cur.next;
            if(cur==null){
                newCur.next = null;
                break;
            }
            newCur.next = newCur.next.next;
            newCur = newCur.next;
        }
        return newHead;
    }
    public static void main(String[] args){
        ComplexListNode head = new ComplexListNode(1);
        ComplexListNode c2 = new ComplexListNode(2);
        ComplexListNode c3 = new ComplexListNode(3);
        ComplexListNode c4 = new ComplexListNode(4);
        ComplexListNode c5 = new ComplexListNode(5);
        head.next = c2;
        head.random = c3;
        head.next.next = c3;
        head.next.random = c5;
        head.next.next.next = c4;
        head.next.next.next.next = c5;
        head.next.next.next.random = c2;
        System.out.println("original:"+'\t'+head);
        System.out.println("clone1:  "+'\t'+clone1(head));
        System.out.println("clone2:  "+'\t'+clone2(head));
        System.out.println("clone3:  "+'\t'+clone3(head));
    }
}
