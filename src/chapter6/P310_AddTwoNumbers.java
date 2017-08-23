package chapter6;

/**
 * Created with IntelliJ IDEA
 * Author: ryder
 * Date  : 2017/8/20
 * Time  : 21:03
 * Description:不用加减乘除做加法
 **/
public class P310_AddTwoNumbers {
    public static int add(int a,int b){
        int sum = a^b;
        int carry = (a&b)<<1;
        int temp;
        while (carry!=0){
            temp = sum;
            sum = sum^carry;
            carry = (carry&temp)<<1;
        }
        return sum;
    }
    public static void main(String[] args){
        System.out.println(add(3,5)); //8
        System.out.println(add(3,-5)); //-2
        System.out.println(add(0,1));  //1
    }
}
