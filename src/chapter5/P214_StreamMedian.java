package chapter5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: ryder
 * Date  : 2017/8/1
 * Time  : 11:06
 * Description:数据流中的中位数
 **/
public class P214_StreamMedian {
    public static interface MedianFinder{
        //模拟读取数据流的过程
        void addNum(double num);
        double findMedian();
    }
    //使用未排序的链表存储数据，使用快排的分区函数求中位数；
    //也可以在插入时进行排序，这样中位数的获取会很容易，但插入费时。
    public static class MedianFinder1 implements MedianFinder{
        List<Double> list = null;
        public MedianFinder1() {
            list = new LinkedList<>();
        }
        @Override
        public void addNum(double num) {
            list.add(num);
        }
        @Override
        public double findMedian() {
            if(list.size()==0)
                return 0;
            //如果长度为奇数，求中间的那个数;如果为偶数，求中间两个数的均值
            if((list.size()&1)==1)
                return findKth(list.size()>>>1);
            else
                return (findKth(list.size()>>>1)+findKth((list.size()>>>1)-1))/2;
        }
        //得到从小到大排序后下标为k的数据值
        private double findKth(int k){
            int start=0,end=list.size()-1;
            int index = partition(start,end);
            while (index!=k){
                if(index<k)
                    index = partition(index+1,end);
                else
                    index = partition(start,index-1);
            }
            return list.get(index);
        }
        //分区，[小，pivot，大]
        private int partition(int start,int end){
            if(start>=end)
                return end;
            double pivot = list.get(start);
            //[start,bound)小于等于pivot,bound值为pivot，(bound，end]大于pivot
            int bound = start;
            for(int i=start+1;i<=end;i++){
                if(list.get(i)<=pivot){
                    list.set(bound,list.get(i));
                    bound++;
                    list.set(i,list.get(bound));
                }
            }
            list.set(bound,pivot);
            return bound;
        }
    }

    //思路二：使用堆存储
    //两个堆能够完成最大堆-最小堆这样的简单分区，两个堆的数字个数相同或heapMax比heapMin大1
    //中位数为最大堆的堆顶或者两个堆堆顶的均值
    public static class MedianFinder2 implements MedianFinder{
        List<Double> maxHeap = null;
        List<Double> minHeap = null;
        public MedianFinder2() {
            maxHeap = new ArrayList<>();
            minHeap = new ArrayList<>();
            maxHeap.add(0.0);
            minHeap.add(0.0);
        }
        @Override
        public void addNum(double num) {
            if(maxHeap.size()==minHeap.size()){
                if(minHeap.size()<=1||num<=minHeap.get(1))
                    addItemToMaxHeap(num);
                else{
                    addItemToMaxHeap(minHeap.get(1));
                    minHeap.set(1,num);
                    adjustMinHeap(1);
                }
            }
            else{
                if(num>=maxHeap.get(1))
                    addItemToMinHeap(num);
                else{
                    addItemToMinHeap(maxHeap.get(1));
                    maxHeap.set(1,num);
                    adjustMaxHeap(1);
                }

            }
        }
        private void addItemToMaxHeap(double value){
            maxHeap.add(value);
            int curIndex = maxHeap.size()-1;
            while (curIndex>1 && maxHeap.get(curIndex)>maxHeap.get(curIndex>>>1)){
                double temp = maxHeap.get(curIndex);
                maxHeap.set(curIndex,maxHeap.get(curIndex>>>1));
                maxHeap.set(curIndex>>>1,temp);
                curIndex = curIndex>>>1;
            }
        }
        private void adjustMaxHeap(int index){
            int left = index*2,right=left+1;
            int max = index;
            if(left<maxHeap.size()&&maxHeap.get(left)>maxHeap.get(max))
                max = left;
            if(right<maxHeap.size()&&maxHeap.get(right)>maxHeap.get(max))
                max = right;
            if(max!=index){
                double temp = maxHeap.get(index);
                maxHeap.set(index,maxHeap.get(max));
                maxHeap.set(max,temp);
                adjustMaxHeap(max);
            }
        }
        private void addItemToMinHeap(double value){
            minHeap.add(value);
            int curIndex = maxHeap.size()-1;
            while (curIndex>1 && minHeap.get(curIndex)<minHeap.get(curIndex>>>1)){
                double temp = minHeap.get(curIndex);
                minHeap.set(curIndex,minHeap.get(curIndex>>>1));
                minHeap.set(curIndex>>>1,temp);
                curIndex = curIndex>>>1;
            }
        }
        private void adjustMinHeap(int index){
            int left = index*2,right=left+1;
            int min = index;
            if(left<minHeap.size()&&minHeap.get(left)<minHeap.get(min))
                min = left;
            if(right<minHeap.size()&&minHeap.get(right)<minHeap.get(min))
                min = right;
            if(min!=index){
                double temp = minHeap.get(index);
                minHeap.set(index,minHeap.get(min));
                minHeap.set(min,temp);
                adjustMinHeap(min);
            }
        }
        @Override
        public double findMedian() {
            if(maxHeap.size()>minHeap.size())
                return maxHeap.get(1);
            else
                return (maxHeap.get(1)+minHeap.get(1))/2;
        }
    }

    //思路三：使用二叉搜索树存储，每个树节点添加一个表征子树节点数目的字段用于计算中位数。
    public static class TreeNodeWithNums<T> {
        public T val;
        public int nodes;
        public TreeNodeWithNums<T> left;
        public TreeNodeWithNums<T> right;
        public TreeNodeWithNums(T val){
            this.val = val;
            this.nodes = 1;
            this.left = null;
            this.right = null;
        }
    }
    public static class MedianFinder3 implements MedianFinder {
        //左孩子小于根节点，右孩子大于等于根节点
        TreeNodeWithNums<Double> root = null;
        public MedianFinder3() {
        }
        @Override
        public void addNum(double num) {
            if(root==null)
                root = new TreeNodeWithNums<>(num);
            else
                addNode(root,num);
        }
        public void addNode(TreeNodeWithNums<Double> node, double num){
            if(num<node.val){
                if(node.left==null){
                    node.left = new TreeNodeWithNums<>(num);
                    node.nodes++;
                }
                else
                    addNode(node.left,num);
            }
            else{
                if(node.right==null){
                    node.right = new TreeNodeWithNums<>(num);
                    node.nodes++;
                }
                else
                    addNode(node.right,num);
            }
        }
        @Override
        public double findMedian() {
            if(root==null)
                return 0;
            if((root.nodes&1)==1)
                return findMedian(root,root.nodes/2+1);
            else
                return (findMedian(root,root.nodes/2)+findMedian(root,root.nodes/2+1))/2;
        }
        private double findMedian(TreeNodeWithNums<Double> node,int index){
            if(node.left!=null){
                if(index==node.left.nodes+1)
                    return node.val;
                else if(index<=node.left.nodes)
                    return findMedian(node.left,index);
                else
                    return findMedian(node.right,index-node.left.nodes-1);
            }
            else if(node.right!=null){
                return findMedian(node.right,index-1);
            }
            else
                return node.val;
        }
    }
    public static void main(String[] args){
        MedianFinder medianFinder1 = new MedianFinder1();
        medianFinder1.addNum(2);
        medianFinder1.addNum(1);
        System.out.println(medianFinder1.findMedian());
        MedianFinder medianFinder2 = new MedianFinder2();
        medianFinder2.addNum(2);
        medianFinder2.addNum(1);
        System.out.println(medianFinder2.findMedian());
        MedianFinder medianFinder3 = new MedianFinder3();
        medianFinder3.addNum(2);
        medianFinder3.addNum(1);
        System.out.println(medianFinder3.findMedian());

        medianFinder1.addNum(4);
        medianFinder2.addNum(4);
        medianFinder3.addNum(4);
        System.out.println(medianFinder1.findMedian());
        System.out.println(medianFinder2.findMedian());
        System.out.println(medianFinder3.findMedian());

    }
}
