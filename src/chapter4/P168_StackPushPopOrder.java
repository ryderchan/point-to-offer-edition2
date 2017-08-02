package chapter4;

import java.util.Stack;

/**
 * Created by ryder on 2017/7/17.
 * 栈的压入弹出序列
 */
public class P168_StackPushPopOrder {
    public static boolean isPopOrder(int[] pushSeq,int[] popSeq){
        if(pushSeq==null||popSeq==null||pushSeq.length!=popSeq.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        int pushSeqIndex=0,popSeqIndex=0;
        while (popSeqIndex<popSeq.length){
            if(stack.isEmpty()||stack.peek()!=popSeq[popSeqIndex]) {
                if(pushSeqIndex<pushSeq.length)
                    stack.push(pushSeq[pushSeqIndex++]);
                else
                    return false;
            }
            else{
                stack.pop();
                popSeqIndex++;
            }
        }
        return true;
    }
    public static void main(String[] args){
        int[] push = {1,2,3,4,5};
        int[] pop1 = {4,5,3,2,1};
        int[] pop2 = {4,3,5,1,2};
        System.out.println(isPopOrder(push,pop1));
        System.out.println(isPopOrder(push,pop2));

    }
}
