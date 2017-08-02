package chapter4;

import java.util.Stack;

/**
 * Created by ryder on 2017/7/16.
 * 包含min函数的栈
 */
public class P165_StackWithMin {
    public static void main(String[] args){
        StackWithMin<Integer> stack = new StackWithMin<>();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(1);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
    }
}
class StackWithMin<T extends Comparable>{
    private Stack<T> stackData = new Stack<>();
    private Stack<T> stackMin = new Stack<>();
    public void push(T data){
        stackData.push(data);
        if(stackMin.isEmpty())
            stackMin.push(data);
        else{
            T temp = stackMin.peek();
            if(temp.compareTo(data)<0)
                stackMin.push(temp);
            else
                stackMin.push(data);
        }
    }
    public T pop(){
        if(stackData.isEmpty())
            return null;
        stackMin.pop();
        return stackData.pop();
    }
    public T min(){
        if(stackMin.isEmpty())
            return null;
        return stackMin.peek();
    }
}

