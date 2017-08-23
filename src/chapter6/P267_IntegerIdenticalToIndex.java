package chapter6;

/**
 * Created with IntelliJ IDEA
 * Author: ryder
 * Date  : 2017/8/15
 * Time  : 17:24
 * Description:数组中数值和下标相等的元素
 **/
public class P267_IntegerIdenticalToIndex {
    public static int getNumberSameAsIndex(int[] data){
        if(data==null ||data.length==0)
            return -1;
        int left = 0,right = data.length-1;
        if(data[left]>0||data[right]<0)
            return -1;
        int mid;
        while (left<=right){
            mid = left+((right-left)>>1);
            if(data[mid]==mid)
                return mid;
            else if(data[mid]<mid)
                left = mid+1;
            else
                right = mid-1;
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println(getNumberSameAsIndex(new int[]{-3,-1,1,3,5})); //3
        System.out.println(getNumberSameAsIndex(new int[]{0,1,2,3,4}));   //0~4
        System.out.println(getNumberSameAsIndex(new int[]{4,5,6,7,8}));   //-1
    }
}
