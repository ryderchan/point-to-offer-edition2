package chapter5;

/**
 * Created with IntelliJ IDEA
 * Author: ryder
 * Date  : 2017/8/3
 * Time  : 8:50
 * Description:数字序列中某一位的数字
 **/
public class P225_DigitsInSequence {
    public static int digitAtIndex(int index){
        if(index<0)
            return -1;
        if(index<10)
            return index;
        int curIndex = 10,length = 2;
        int boundNum = 10;
        while (curIndex+lengthSum(length)<index){
            curIndex+=lengthSum(length);
            boundNum*=10;
            length++;
        }
        int addNum = (index-curIndex)/length;
        int curNum = boundNum + addNum;
        return Integer.toString(curNum).charAt(index-curIndex-addNum*length)-'0';
    }
    public static int lengthSum(int length){
        int count = 9;
        for(int i=1;i<length;i++)
            count*=10;
        return count*length;
    }
    public static void main(String[] args){
        for(int i=9;i<16;i++)
            System.out.println(digitAtIndex(i));
        System.out.println(digitAtIndex(1001));

    }
}
