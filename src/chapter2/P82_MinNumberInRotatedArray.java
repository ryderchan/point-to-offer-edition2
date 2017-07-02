package chapter2;

/**
 * Created by ryder on 2017/6/28.
 * 旋转数组的最小数字
 */
public class P82_MinNumberInRotatedArray {
    public static int min(int[] data){
        if(data==null || data.length==0)
            return -1;
        int left = 0;
        int right = data.length-1;
        int mid;
        while(left<right){
            mid = left+(right-left)/2;
            //left < right
            if(data[left]<data[right])
                return data[left];
            //left > right
            else if(data[left]>data[right]){
                if(data[mid]>=data[left])
                    left = mid + 1;
                else
                    right = mid;
            }
            //left = right
            else{
                if(data[left]<data[mid])
                    left = mid + 1;
                else if(data[left]>data[mid])
                    right = mid;
                else{
                    left = left+1;
                    right = right-1;
                }
            }
        }
        return data[right];
    }
    public static void main(String[] args){
        int[] data1 = {3,4,5,1,2};
        int[] data2 = {1,0,1,1,1};
        int[] data3 = {1,1,1,0,1};
        System.out.println(min(data1));
        System.out.println(min(data2));
        System.out.println(min(data3));
    }
}
