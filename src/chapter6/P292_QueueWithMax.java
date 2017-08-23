package chapter6;

import java.util.*;

/**
 * Created with IntelliJ IDEA
 * Author: ryder
 * Date  : 2017/8/19
 * Time  : 13:46
 * Description: 队列的最大值
 **/
public class P292_QueueWithMax {
    public static class QueueWithMax<T extends Comparable> {
        private Deque<InternalData<T>> queueData;
        private Deque<InternalData<T>> queueMax;
        private int currentIndex;
        public QueueWithMax() {
            this.queueData = new ArrayDeque<>();
            this.queueMax = new ArrayDeque<>();
            this.currentIndex = 0;
        }
        public T max(){
            if(queueMax.isEmpty())
                return null;
            return queueMax.getFirst().value;
        }
        public void pushBack(T value){
            while (!queueMax.isEmpty()&&value.compareTo(queueMax.getLast().value)>=0)
                queueMax.removeLast();
            InternalData<T> addData = new InternalData<>(value,currentIndex);
            queueMax.addLast(addData);
            queueData.addLast(addData);
            currentIndex++;
        }
        public T popFront(){
            if(queueData.isEmpty())
                return null;
            InternalData<T> delData = queueData.removeFirst();
            if(delData.index==queueMax.getFirst().index)
                queueMax.removeFirst();
            return delData.value;
        }
        private static class InternalData<M extends Comparable> {
            public M value;
            public int index;
            public InternalData(M value,int index){
                this.value = value;
                this.index = index;
            }
        }
    }
    public static void main(String[] args) {
        QueueWithMax<Integer> queue = new QueueWithMax<>();
        queue.pushBack(3);
        System.out.println(queue.max());
        queue.pushBack(5);
        System.out.println(queue.max());
        queue.pushBack(1);
        System.out.println(queue.max());
        System.out.println("开始出队后，调用max");
        System.out.println(queue.max());
        queue.popFront();
        System.out.println(queue.max());
        queue.popFront();
        System.out.println(queue.max());
        queue.popFront();
        System.out.println(queue.max());


    }
}
