package chapter2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ryder on 2017/6/21.
 * 用队列实现一个栈
 */

//用两个队列实现一个栈
class MyStack<T> {
    private Queue<T> queue1 = new LinkedList<>();
    private Queue<T> queue2 = new LinkedList<>();

    public void push(T data) {
        if (!queue2.isEmpty())
            queue2.offer(data);
        else
            queue1.offer(data);
    }

    public T pop() {
        if (!queue2.isEmpty()) {
            int size = queue2.size();
            for (int i = 0; i < size - 1; i++)
                queue1.offer(queue2.poll());
            return queue2.poll();
        } else if (!queue1.isEmpty()) {
            int size = queue1.size();
            for (int i = 0; i < size - 1; i++)
                queue2.offer(queue1.poll());
            return queue1.poll();
        } else
            return null;
    }
}

//用一个队列实现一个栈
class MyStack2<T> {
    private Queue<T> queue = new LinkedList<>();

    public void push(T data) {
        queue.offer(data);
    }
    public T pop() {
        if(queue.isEmpty())
            return null;
        else{
            int size = queue.size();
            for (int i = 0; i < size - 1; i++)
                queue.offer(queue.poll());
            return queue.poll();
        }
    }
}

public class P71_StackWithTwoQueues {
    public static void test1() {
        MyStack<Integer> myStack = new MyStack<>();
        System.out.println(myStack.pop());
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.push(4);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
    public static void test2() {
        MyStack2<Integer> myStack = new MyStack2<>();
        System.out.println(myStack.pop());
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.push(4);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
    public static void main(String[] args) {
        test1();
        test2();
    }
}
