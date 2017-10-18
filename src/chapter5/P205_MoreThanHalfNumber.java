package chapter5;

/**
 * Created with IntelliJ IDEA.
 * Author: ryder
 * Date  : 2017/7/28
 * Time  : 17:51
 * Description: 数组中出现次数超过一半的数字
 **/
public class P205_MoreThanHalfNumber {
    //转化为topK问题（此处求第k小的值），使用快排的分区函数解决，求第targetIndex+1小的数字（下标为targetIndex）
    //书中说这种方法的时间复杂度为o(n)，但没懂为什么。网上也有人说为o(nlogk)
    public static int moreThanHalfNum1(int[] data){
        if(data==null || data.length==0)
            return 0;
        int left = 0,right=data.length-1;
        //获取执行分区后下标为k的数据值（即第k+1小的数字）
        int k = data.length>>>1;
        int index = partition(data,left,right);
        while(index!=k){
            if(index>k)
                index = partition(data,left,index-1);
            else
                index = partition(data,index+1,right);
        }
        return data[k];
    }
    //分区，[小，povot，大]
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

    //根据数组特点进行记录、查找，时间复杂度o(n)，思路有点缓存的意味。
    public static int moreThanHalfNum2(int[] data){
        if(data==null || data.length==0)
            return 0;
        int count = 1;
        int value = data[0];
        for(int i=1;i<data.length;i++){
            if(data[i]==value)
                count++;
            else if(data[i]!=value && count==1)
                value = data[i];
            else
                count--;
        }
        return value;
    }
    public static void main(String[] args){
        int[] data = {1,2,3,2,2,2,5,4,2};
        System.out.println(moreThanHalfNum2(data));
        System.out.println(moreThanHalfNum1(data));
    }
}
