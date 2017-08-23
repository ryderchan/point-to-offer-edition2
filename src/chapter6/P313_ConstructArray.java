package chapter6;

/**
 * Created with IntelliJ IDEA
 * Author: ryder
 * Date  : 2017/8/21
 * Time  : 8:45
 * Description:构建乘积数组
 **/
public class P313_ConstructArray {
    public static int[] multiply(int[] data){
        if(data==null||data.length<2)
            return null;
        int[] result = new int[data.length];
        //求得数组C，存于result中
        result[0] = 1;
        for(int i=1;i<result.length;i++)
            result[i] = result[i-1]*data[i-1];
        //先求得数组D中元素，再与C中元素相乘，存于result中
        int temp = 1;
        for(int i=data.length-2;i>=0;i--){
            //数组D中的元素值
            temp = temp * data[i+1];
            //计算B[i]=C[i]*D[i]
            result[i] = result[i] * temp;
        }
        return result;
    }
    public static void main(String[] args){
        int[] data = new int[]{1,2,3,4,5};
        int[] result = multiply(data);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]);
            System.out.print("  ");
        }
    }
}
