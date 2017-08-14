package chapter5;

/**
 * Created with IntelliJ IDEA
 * Author: ryder
 * Date  : 2017/8/13
 * Time  : 9:47
 * Description:丑数
 **/
public class P240_GetUglyNumber {
    public static int getUglyNumber(int num){
         if(num<=0)
             return 0;
         int number = 0,uglyFound = 0;
         while (uglyFound<num){
             number++;
             if(isUgly(number))
                 uglyFound++;
         }
         return number;
    }
    public static boolean isUgly(int number){
        while (number%2==0)
            number/=2;
        while (number%3==0)
            number/=3;
        while (number%5==0)
            number/=5;
        return number==1;
    }
    //获取从1开始的第num个丑数
    public static int getUglyNumber2(int num){
        int[] uglyNumber = new int[num];
        uglyNumber[0] = 1;
        int uglyIndex=0, multiply2=0, multiply3=0, multiply5=0;
        while (uglyIndex+1<num){
            uglyNumber[++uglyIndex] = min(uglyNumber[multiply2]*2,uglyNumber[multiply3]*3,uglyNumber[multiply5]*5);
            //2*3=6，3*2=6，会有重复值，因此下面需要使用if，而不能用if-else
            if(uglyNumber[multiply2]*2==uglyNumber[uglyIndex])
                multiply2++;
            if(uglyNumber[multiply3]*3==uglyNumber[uglyIndex])
                multiply3++;
            if(uglyNumber[multiply5]*5==uglyNumber[uglyIndex])
                multiply5++;
        }
        return uglyNumber[num-1];
    }
    public static int min(int x,int y,int z){
        int temp = x<y?x:y;
        return temp<z?temp:z;
    }
    public static void main(String[] args){
        System.out.println(getUglyNumber(10));
        System.out.println(getUglyNumber2(10));
    }
}
