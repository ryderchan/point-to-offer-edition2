package chapter5;

/**
 * Created with IntelliJ IDEA.
 * Author: ryder
 * Date  : 2017/8/1
 * Time  : 21:21
 * Description:1~n整数中1出现的次数
 **/
public class P221_NumberOf1 {
    public static int numberOf1Between1AndN(int n){
        int count = 0;
        if(n<=0)
            return count;
        for(int i=1;i<=n;i++)
            count+=numberOf1(i);
        return count;
    }
    private static int numberOf1(int i){
        int count = 0;
        while (i!=0){
            if(i%10==1)
                count++;
            i/=10;
        }
        return count;
    }
    public static int numberOf1Between1AndN2(int n){
        if(n<=0)
            return 0;
        if(n<10)
            return 1;
        String nString = Integer.toString(n);
        char firstChar = nString.charAt(0);
        String apartFirstString = nString.substring(1);
        //计算other~n中1出现的次数，递归计算apartFirstString
        int countFirst1 = 0;
        if(firstChar>'1')
            countFirst1 = power10(nString.length()-1);
        else
            countFirst1 = Integer.parseInt(apartFirstString)+1;
        int countOhters1 = (firstChar-'0')*power10(nString.length()-2)*(nString.length()-1);
        return countFirst1+countOhters1+numberOf1Between1AndN(Integer.parseInt(apartFirstString));
    }
    public static int power10(int n){
        int result = 1;
        for(int i=0;i<n;i++)
            result*=10;
        return result;
    }
    public static void main(String[] args){
        System.out.println(numberOf1Between1AndN(121));
        System.out.println(numberOf1Between1AndN2(121));
        System.out.println(numberOf1Between1AndN(789));
        System.out.println(numberOf1Between1AndN2(789));

    }
}
