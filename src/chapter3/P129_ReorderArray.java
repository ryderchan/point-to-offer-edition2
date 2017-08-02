package chapter3;

/**
 * Created by ryder on 2017/7/14.
 * 调整数组顺序使奇数位于偶数前面
 */
public class P129_ReorderArray {
    public static void reorder(int[] data){
        if(data==null||data.length<2)
            return;
        int left=0,right=data.length-1;
        while(left<right){
            while (left<right&&!isEven(data[left]))
                left++;
            while (left<right&&isEven(data[right]))
                right--;
            if(left<right){
                int temp=data[left];
                data[left]=data[right];
                data[right]=temp;
            }
        }
    }
    public static boolean isEven(int n){
        return (n&1)==0;
    }
    public static void main(String[] args){
        int[] data = {1,2,3,4,5,7,7};
        reorder(data);
        for(int i=0;i<data.length;i++) {
            System.out.print(data[i]);
            System.out.print('\t');
        }
        System.out.println();
    }
}
