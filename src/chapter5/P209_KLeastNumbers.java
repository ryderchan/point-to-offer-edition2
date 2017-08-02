package chapter5;

/**
 * Created with IntelliJ IDEA.
 * Author: ryder
 * Date  : 2017/7/31
 * Time  : 18:14
 * Description: 最小的k个数
 **/
public class P209_KLeastNumbers {
    //选择排序,时间复杂度o(N*k),适合k较小的情况
    public static int getLeastNumbers1(int[] data,int k){
        if(data==null||data.length==0||k>data.length)
            return 0;
        for(int i=0;i<k;i++){
            int minIndex = i;
            for(int j=i+1;j<data.length;j++){
                if(data[j]<data[minIndex])
                    minIndex = j;
            }
            if(minIndex!=i){
                int temp = data[minIndex];
                data[minIndex] = data[i];
                data[i] = temp;
            }
        }
        //第k小，也就是排序后下标为k-1的元素。
        return data[k-1];
    }

    //使用分区函数解决，时间复杂度o(n)(没懂),会修改原数组
    public static int getLeastNumbers2(int[] data,int k){
        if(data==null || data.length==0 || k>data.length)
            return 0;
        int left=0,right=data.length-1;
        int index = partition(data,left,right);
        while(index!=k-1){
            if(index<k-1)
                index = partition(data,index+1,right);
            else
                index = partition(data,left,index-1);
        }
        return data[k-1];
    }
    public static int partition(int[] data,int left,int right){
        int pivot = data[left];
        while(left<right){
            while (left<right && data[right]>=pivot)
                right--;
            if(left<right)
                data[left] = data[right];
            while (left<right && data[left]<pivot)
                left++;
            if(left<right)
                data[right] = data[left];
        }
        data[left] = pivot;
        return left;
    }

    //使用最大堆解决，不会修改原数组，适合处理海量数据
    //k个元素的最大堆调整时间复杂度为o(logk),所以总的时间复杂度为o(nlogk)
    public static int getLeastNumbers3(int[] data,int k){
        if(data==null || data.length==0 || k>data.length)
            return 0;
        //最大堆，0号元素不用，因此长度需k+1
        int[] heap = new int[k+1];
        int i = 0;
        while (i<k){
            heap[i+1] = data[i];
            i++;
        }
        //初始化最大堆
        buildMaxHeap(heap);
        //调整最大堆
        while (i<data.length){
            if(data[i]<heap[k]) {
                heap[1] = data[i];
                adjustMaxHeap(heap, 1);
            }
            i++;
        }
        //长度为k的最大堆中下标为1的元素就是data数组中第k小的数据值
        return heap[1];
    }
    //0号元素不用，创建一个长度为k+1的堆
    public static void buildMaxHeap(int[] heap){
        for(int i = heap.length>>>1;i>0;i--)
            adjustMaxHeap(heap,i);
    }
    //调整最大堆,i为待调整的下标
    public static void adjustMaxHeap(int[] heap,int i){
        int left = 2*i,right = left+1;
        int max  = i;
        if(left<heap.length && heap[left]>heap[max])
            max = left;
        if(right<heap.length && heap[right]>heap[max])
            max = right;
        if(max!=i){
            int temp = heap[i];
            heap[i] = heap[max];
            heap[max] = temp;
            adjustMaxHeap(heap,max);
        }
    }
    public static void main(String[] args){
        int[] data1 = {6,1,3,5,4,2};
        System.out.println(getLeastNumbers1(data1,5));
        int[] data2 = {6,1,3,5,4,2};
        System.out.println(getLeastNumbers2(data2,5));
        int[] data3 = {6,1,3,5,4,2};
        System.out.println(getLeastNumbers3(data3,5));

    }
}
