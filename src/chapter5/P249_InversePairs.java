package chapter5;

/**
 * Created with IntelliJ IDEA
 * Author: ryder
 * Date  : 2017/8/14
 * Time  : 19:36
 * Description:数组中的逆序对
 **/
public class P249_InversePairs {
    public static int inversePairs(int[] data){
        if(data==null || data.length<2)
            return 0;
        return mergeSortCore(data, 0, data.length - 1);
    }
    public static int mergeSortCore(int[] data,int start,int end){
        if(start>=end)
            return 0;
        int mid = start+(end-start)/2;
        int left = mergeSortCore(data,start,mid);
        int right = mergeSortCore(data,mid+1,end);
        int count = mergerSortMerge(data,start,mid,end);
        return left+right+count;
    }
    //start~mid, mid+1~end
    public static int mergerSortMerge(int[] data,int start,int mid,int end){
        int[] temp = new int[end-start+1];
        for(int i=0;i<=end-start;i++)
            temp[i] = data[i+start];
        int left = 0,right = mid+1-start,index = start,count = 0;
        while (left<=mid-start && right<=end-start){
            if(temp[left]<=temp[right])
                data[index++] = temp[left++];
            else{
                data[index++] = temp[right++];
                count += (mid-start)-left+1;
            }
        }
        while (left<=mid-start)
            data[index++] = temp[left++];
        while (right<=end-start)
            data[index++] = temp[right++];
        return count;
    }
    public static void main(String[] args){
        System.out.println(inversePairs(new int[]{7,5,6,4}));
    }
}
