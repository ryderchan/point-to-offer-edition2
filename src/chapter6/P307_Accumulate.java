package chapter6;

/**
 * Created with IntelliJ IDEA
 * Author: ryder
 * Date  : 2017/8/20
 * Time  : 19:59
 * Description:不使用乘除、for、while、if、switch、？:求和
 * 省略if的一种方式：boolean b=判断条件&&待执行语句>0
 **/
public class P307_Accumulate {
    public static int getSum(int num){
        int t=0;
        boolean b = (num>0)&&((t=num+getSum(num-1))>0);
        return t;
    }
    public static void main(String[] args){
        System.out.println(getSum(10));
    }
}
