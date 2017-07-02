package chapter2;

import structure.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ryder on 2017/6/27.
 * 完成对数组、链表的快排
 */
public class P79_QuickSortThreeWayImpl {
    //数组快排，时间o(nlogn)(最差n^2)，空间o(logn)(最差n)，递归造成的栈空间的使用，不稳定
    public static void quickSort(int[] data){
        if(data==null || data.length<=1) return;
        quickSortCore(data,0,data.length-1);
    }
    public static void quickSortCore(int[] data,int start,int end){
        if(end-start<=0)
            return;
        int index = quickSortPartition(data,start,end);
        quickSortCore(data,start,index-1);
        quickSortCore(data,index+1,end);
    }
    public static int quickSortPartition(int[] data,int start,int end){
        //选择第一个值作为基准
        int pivot = data[start];
        int left = start,right = end;
        while(left<right){
            while(left<right && data[right]>=pivot) {
                right--;
            }
            if(left<right)
                data[left] = data[right];
            while(left<right && data[left]<pivot) {
                left++;
            }
            if(left<right)
                data[right] = data[left];
        }
        data[left] = pivot;
        return left;
    }
    public static void testQuickSort(){
        int[] data = {1,5,4,2,3};
        quickSort(data);
        System.out.print("数组快速排序：\t");
        for(int item: data){
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }

    //内置链表快排
    public static void quickSortList(List<Integer> data){
        if(data==null || data.size()<2)
            return;
        quickSortListCore(data,0,data.size()-1);
    }
    public static void quickSortListCore(List<Integer> data,int start,int end){
        if(start>=end)
            return;
        int index = quickSortListPartition(data,start,end);
        quickSortListCore(data,start,index-1);
        quickSortListCore(data,index+1,end);
    }
    public static int quickSortListPartition(List<Integer> data,int start,int end){
        int pivot = data.get(start);
        int left = start,right = end;
        while(left<right){
            while(left<right && data.get(right)>=pivot)
                right--;
            if(left<right)
                data.set(left,data.get(right));
            while(left<right && data.get(left)<pivot)
                left++;
            if(left<right)
                data.set(right,data.get(left));
        }
        data.set(left,pivot);
        return left;
    }
    public static void testQuickSortList(){
        List<Integer> data = new LinkedList<>();
        data.add(1);
        data.add(5);
        data.add(4);
        data.add(2);
        data.add(3);
        quickSortList(data);
        System.out.print("基于List快速排序:\t");
        System.out.println(data);
    }

    //自定义链表快排
    public static void quickSortList2(ListNode<Integer> data){
        if(data==null || data.next==null)
            return;
        quickSortListCore2(data,null);
    }
    //从start到end排序，不包括end
    public static void quickSortListCore2(ListNode<Integer> start,ListNode<Integer> end){
        if(start==end || start.next==end)
            return;
        ListNode<Integer> index = quickSortList2Partition(start,end);
        quickSortListCore2(start,index);
        quickSortListCore2(index.next,end);
    }
    //两个左起指针向右移动，right从start+1到end（不包括end）向右扫描值,[start,left]存储小于povot的值
    //最终left存储pivot，[start,left)小于pivot，（left+1，end）大于pivot
    public static ListNode<Integer> quickSortList2Partition(ListNode<Integer> start,ListNode<Integer> end){
        int pivot = start.val;
        ListNode<Integer> left = start;
        ListNode<Integer> right = start.next;
        while(right!=end){
            if(right.val>=pivot)
                right = right.next;
            else{
                left.val = right.val;
                left = left.next;
                right.val = left.val;
                right = right.next;
            }
        }
        left.val = pivot;
        return left;
    }
    public static void testQuickSortList2(){
        ListNode<Integer> data = new ListNode<>(1);
        data.next = new ListNode<>(5);
        data.next.next= new ListNode<>(4);
        data.next.next.next= new ListNode<>(2);
        data.next.next.next.next= new ListNode<>(3);
        quickSortList2(data);
        System.out.print("自定义链表快速排序:\t");
        System.out.println(data);
    }

    public static void main(String[] args){
        testQuickSort();
        testQuickSortList();
        testQuickSortList2();
    }
}
