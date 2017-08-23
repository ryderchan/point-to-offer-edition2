package chapter6;

/**
 * Created with IntelliJ IDEA
 * Author: ryder
 * Date  : 2017/8/17
 * Time  : 15:47
 * Description:和为s的连续正数序列
 **/
public class P282_ContinuousSequenceWithSum {
    public static void findContinuousSequence(int sum){
        if(sum<3)
            return;
        int small = 1,big = 2,middle = sum>>1;
        int curSum = small+big;
        while (small<=middle){
            if(curSum==sum){
                printContinousSequence(small,big);
                big++;
                curSum+=big;
            }
            else if(curSum<sum){
                big++;
                curSum+=big;
            }
            else{
                curSum-=small;
                small++;
            }
        }
    }
    public static void printContinousSequence(int small,int big){
        for(int i=small;i<=big;i++){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        findContinuousSequence(15);
    }
}
