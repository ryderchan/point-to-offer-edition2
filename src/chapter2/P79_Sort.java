package chapter2;

/**
 * Created by ryder on 2017/6/25.
 * 数组排序算法
 */
public class P79_Sort {
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
            while(left<right && data[right]>=pivot)
                right--;
            if(left<right)
                data[left] = data[right];
            while(left<right && data[left]<pivot)
                left++;
            if(left<right)
                data[right] = data[left];
        }
        data[left] = pivot;
        return left;
    }
    public static void testQuickSort(){
        int[] data = {5,4,3,1,2};
        quickSort(data);
        System.out.print("数组快速排序：\t");
        for(int item: data){
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }

    //数组二路归并，时间o(nlogn)(最差n^2)，空间o(n),稳定
    public static int[] mergeSort(int[] data){
        if(data==null || data.length<=1)
            return data;
        mergeSortCore(data,0,data.length-1);
        return data;
    }
    //对data[start~mid]，data[mid+1~end]归并
    //典型的分治：结束条件+分+和
    public static void mergeSortCore(int[] data,int start,int end){
        if(start>=end)
            return;
        int mid = start + (end - start)/2;
        mergeSortCore(data,start,mid);
        mergeSortCore(data,mid+1,end);
        mergeSortMerge(data,start,mid,end);
    }
    public static void mergeSortMerge(int[] data,int start,int mid,int end){
        if(end==start)
            return;
        int[] temp = new int[end-start+1];
        int left = start,right = mid+1,tempIndex = 0;
        while(left<=mid && right<=end){
            if(data[left]<data[right])
                temp[tempIndex++] = data[left++];
            else
                temp[tempIndex++] = data[right++];
        }
        while(left<=mid)
            temp[tempIndex++] = data[left++];
        while(right<=end)
            temp[tempIndex++] = data[right++];
        for(int i=0;i<temp.length;i++)
            data[start+i] = temp[i];
    }
    public static void testMergeSort(){
        int[] data = {5,4,3,1,2};
        mergeSort(data);
        System.out.print("数组归并排序：\t");
        for(int item: data){
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }
    //数组堆排序，时间o(nlogn)，空间o(1),不稳定
    //建立最大堆，交换堆的第一个与最后一个元素，调整堆
    //注意，堆排序的0号元素不能使用，为了与其他排序统一接口，先把最小的元素放到0号元素上，再用堆排序
    public static void heapSort(int[] data){
        if(data==null || data.length<=1)
            return;
        int minIndex = 0;
        for(int i=1;i<data.length;i++){
            if(data[i]<data[minIndex])
                minIndex = i;
        }
        if(minIndex!=0){
            int temp = data[0];
            data[0] = data[minIndex];
            data[minIndex] = temp;
        }
        //正式开始堆排序
        buildMaxHeap(data);
        for(int indexBound = data.length-1;indexBound>1;){
            int temp = data[indexBound];
            data[indexBound] = data[1];
            data[1] = temp;
            indexBound--;
            adjustMaxHeap(data,1,indexBound);
        }
    }
    public static void buildMaxHeap(int[] data){
        for(int i = data.length/2;i>0;i--){
            adjustMaxHeap(data,i,data.length-1);
        }
    }
    //i表示待调整元素下标，end表示最大堆的最后一个元素的下标，end值会随着排序的进行而减小的1
    public static void adjustMaxHeap(int[] data,int i,int end){
        int left = 2*i;
        int right = 2*i+1;
        int max = i;
        if(left<=end && data[left]>data[max])
            max = left;
        if(right<=end && data[right]>data[max])
            max = right;
        if(max!=i){
            int temp = data[max];
            data[max] = data[i];
            data[i] = temp;
            adjustMaxHeap(data,max,end);
        }
    }
    public static void testHeapSort(){
        int[] data = {5,4,3,1,2};
        heapSort(data);
        System.out.print("数组堆排序：\t");
        for(int item: data){
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }

    //数组冒泡，时间o(n^2)，空间o(1)，稳定
    public static void bubbleSort(int[] data){
        if(data==null || data.length<=1)
            return;
        for(int i=0;i<data.length-1;i++){
            for(int j=1;j<data.length-i;j++){
                if(data[j-1]>data[j]){
                    int temp = data[j-1];
                    data[j-1] = data[j];
                    data[j] = temp;
                }
            }
        }
    }
    public static void testBubbleSort(){
        int[] data = {5,4,3,1,2};
        bubbleSort(data);
        System.out.print("数组冒泡排序：\t");
        for(int item: data){
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }

    //数组选择排序，时间o(n^2)，空间o(1)，不稳定
    public static void selectionSort(int[] data){
        if(data==null || data.length<=1)
            return;
        for(int i=0;i<data.length-1;i++){
            int minIndex = i;
            for(int j=i+1;j<data.length;j++){
                if(data[j]<data[minIndex])
                    minIndex = j;
            }
            if(i!=minIndex) {
                int temp = data[i];
                data[i] = data[minIndex];
                data[minIndex] = temp;
            }
        }
    }
    public static void testSelectionSort(){
        int[] data = {5,4,3,1,2};
        selectionSort(data);
        System.out.print("数组选择排序：\t");
        for(int item: data){
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }

    //数组插入排序，时间o(n^2)，空间o(1)，稳定
    public static void insertionSort(int[] data){
        if(data==null || data.length<=1)
            return;
        for(int i=1;i<data.length;i++){
            int j=i;
            int temp = data[i];
            while(j>0 && data[j-1]>temp) {
                data[j] = data[j-1];
                j--;
            }
            data[j] = temp;
        }
    }
    public static void testInsertionSort(){
        int[] data = {5,4,3,1,2};
        insertionSort(data);
        System.out.print("数组插入排序：\t");
        for(int item: data){
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }

    //数组希尔排序(插入排序缩小增量)，时间o(n^1.3)，空间o(1)，不稳定
    //有人在大量的实验后得出结论;当n在某个特定的范围后希尔排序的比较和移动次数减少至n^1.3
    public static void shellSort(int[] data){
        if(data==null || data.length<=1)
            return;
        for(int d=data.length/2; d>0; d=d/2){
            for(int i=d;i<data.length;i++){
                int cur = i;
                int temp = data[i];
                while(cur>=d && data[cur-d]>temp){
                    data[cur] = data[cur-d];
                    cur = cur - d;
                }
                data[cur] = temp;
            }
        }
    }
    public static void testShellSort(){
        int[] data = {5,4,3,1,2};
        shellSort(data);
        System.out.print("数组希尔排序：\t");
        for(int item: data){
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }

    public static void main(String[] args){
        testQuickSort();
        testMergeSort();
        testHeapSort();
        testBubbleSort();
        testSelectionSort();
        testInsertionSort();
        testShellSort();
    }
}
