package chapter6;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA
 * Author: ryder
 * Date  : 2017/8/18
 * Time  : 17:58
 * Description:滑动窗口的最大值
 **/
public class P288_MaxInSlidingWindow {
    //把可能会成为最大值的下标存储下来，从而降低扫描次数
    public static int[] maxInWindows(int[] data,final int size){
        if(data==null ||data.length==0||data.length<size)
            return new int[0];
        int[] result = new int[data.length-size+1];
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=0;i<size-1;i++){
            while (!deque.isEmpty()&&data[i]>=data[deque.getLast()])
                deque.removeLast();
            deque.addLast(i);
        }
        for(int i=size-1;i<data.length;i++){
            while (!deque.isEmpty()&&i-deque.getFirst()+1>size)
                deque.removeFirst();
            while (!deque.isEmpty()&&data[deque.getLast()]<=data[i])
                deque.removeLast();
            deque.addLast(i);
            result[i-(size-1)] = data[deque.getFirst()];
        }
        return result;
    }
    public static void main(String[] args){
        int[] data = new int[]{2,3,4,2,6,2,5,1};
        int[] result = maxInWindows(data,3);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]);
            System.out.print("\t");
        }
    }
}
