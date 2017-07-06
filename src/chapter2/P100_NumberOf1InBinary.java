package chapter2;

/**
 * Created by ryder on 2017/7/6.
 * 二进制中的1的个数
 */
public class P100_NumberOf1InBinary {
    public static int numberOfOne1(int n){
        int count=0;
        while(n!=0){
            if((n&1)!=0)
                count++;
            n>>>=1;
        }
        return count;
    }
    public static int numberOfOne2(int n){
        int count=0;
        int flag=1;
        while(flag!=0){
            if((n&flag)!=0)
                count++;
            flag<<=1;
        }
        return count;
    }
    public static int numberOfOne3(int n){
        int count=0;
        while(n!=0){
            n = n&(n-1);
            count++;
        }
        return count;
    }
    //使用一条语句判断一个正整数是不是2的整数次方
    public static boolean isPowerOfTwo(int n){
        return (n&(n-1))==0;
    }

    public static void main(String[] args){
        System.out.println(numberOfOne1(3));
        System.out.println(numberOfOne1(-3));
        System.out.println(numberOfOne2(3));
        System.out.println(numberOfOne2(-3));
        System.out.println(numberOfOne3(3));
        System.out.println(numberOfOne3(-3));
        System.out.println();
    }
}
