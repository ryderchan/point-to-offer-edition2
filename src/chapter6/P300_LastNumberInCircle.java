package chapter6;
import structure.ListNode;

/**
 * Created with IntelliJ IDEA
 * Author: ryder
 * Date  : 2017/8/20
 * Time  : 16:20
 * Description:圆圈中最后剩下的数字
 * n=5,m=3,从0,1,2,3,4组成的圆中删除第3个数字
 * 依次删除3,0,4,1，最终剩下的是3
 **/
public class P300_LastNumberInCircle {
    public static int lastRemaining(int n,int m){
        if(n<1||m<1)
            return -1;
        ListNode<Integer> head = new ListNode<>(0);
        ListNode<Integer> cur = head;
        for(int i=1;i<n;i++){
            ListNode<Integer> node = new ListNode<>(i);
            cur.next = node;
            cur = cur.next;
        }
        cur.next = head;
        cur = head;
        while (true){
            //长度为1结束循环
            if(cur.next==cur)
                return cur.val;
            //向后移动
            for(int i=1;i<m;i++)
                cur=cur.next;
            //删除当前节点
            cur.val = cur.next.val;
            cur.next = cur.next.next;
            //删除后，cur停在被删节点的后一节点处
        }
    }
    //另一个思路分析过程较复杂，不强求了。可搜约瑟夫环进行了解。
    public static void main(String[] args){
        System.out.println(lastRemaining(5,3)); //3
        System.out.println(lastRemaining(6,7)); //4
        System.out.println(lastRemaining(0,7)); //-1
    }
}
