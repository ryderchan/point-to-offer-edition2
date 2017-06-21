package chapter2;
import java.util.Stack;

/**
 * Created by ryder on 2017/6/20.
 * 用两个栈实现队列
 */
class MyQueue<T>{
    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();
    public void offer(T data){
        stack1.push(data);
    }
    public T poll(){
        if(!stack2.isEmpty()){
            return stack2.pop();
        }
        else if(!stack1.isEmpty()){
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
            return stack2.pop();
        }
        else
            return null;
    }
}

public class P68_QueueWithTwoStacks {
    public static void main(String[] args){
        MyQueue<Integer> myQueue = new MyQueue<>();
        System.out.println(myQueue.poll());
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        myQueue.offer(4);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
    }
}
