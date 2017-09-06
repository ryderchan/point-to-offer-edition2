package chapter5;

/**
 * Created with IntelliJ IDEA
 * Author: ryder
 * Date  : 2017/8/13
 * Time  : 15:32
 * Description:第一次只出现一次的字符
 **/
public class P243_FirstNotRepeatingChar {
    //暴力求解，时间复杂度o(n^2),空间复杂度o(1)
    public static char firstNotRepeatingChar(String str){
        //此处，\77表示ascii为77的字符(即?),此处用于表征没有只出现一次的字符
        if(str==null||str.length()==0)
            return '\77';
        for(int i=0;i<str.length()-1;i++){
            char temp = str.charAt(i);
            for(int j=0;j<=str.length();j++){
                if(j==i)
                    continue;
                if(j==str.length())
                    return temp;
                if(temp==str.charAt(j))
                    break;
            }
        }
        return '\77';
    }
    //引入哈希表，用空间换时间。时间复杂度o(n),空间占用1kB
    public static char firstNotRepeatingChar2(String str){
        //使用这个数组记录字符出现次数
        //改进：使用数组记录字符出现位置，见247页题目
        int[] times = new int[256];
        for(int i=0;i<str.length();i++)
            times[str.charAt(i)]++;
        for(int i=0;i<str.length();i++){
            if(times[str.charAt(i)]==1)
                return str.charAt(i);
        }
        return '\77';
    }
    public static void main(String[] args){
        System.out.println(firstNotRepeatingChar("abaccdeff"));
        System.out.println(firstNotRepeatingChar2("abaccdeff"));

    }
}
