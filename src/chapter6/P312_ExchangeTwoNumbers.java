package chapter6;

/**
 * Created with IntelliJ IDEA
 * Author: ryder
 * Date  : 2017/8/20
 * Time  : 21:39
 * Description:不使用新的变量，交换两个原有变量的值
 **/
public class P312_ExchangeTwoNumbers {
    public static void main(String[] args){
        //基于加减法
        int a = 3;
        int b = 5;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a="+a+",b="+b);

        //基于异或法
        a = 3;
        b = 5;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a="+a+",b="+b);
    }
}
