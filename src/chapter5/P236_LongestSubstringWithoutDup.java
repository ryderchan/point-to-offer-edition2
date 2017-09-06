package chapter5;

/**
 * Created with IntelliJ IDEA
 * Author: ryder
 * Date  : 2017/8/12
 * Time  : 19:37
 * Description:最长不含重复字符的子字符串
 **/
public class P236_LongestSubstringWithoutDup {
    //动态规划
    //dp[i]表示以下标为i的字符结尾不包含重复字符的最长子字符串长度
    public static int longestSubstringWithoutDup(String str){
        if(str==null || str.length()==0)
            return 0;
        //dp数组可以省略，因为只需记录前一位置的dp值即可
        int[] dp = new int[str.length()];
        dp[0] = 1;
        int maxdp = 1;
        for(int dpIndex = 1;dpIndex<dp.length;dpIndex++){
            //i最终会停在重复字符或者-1的位置,要注意i的结束条件
            int i = dpIndex-1;
            for(;i>=dpIndex-dp[dpIndex-1];i--){
                if(str.charAt(dpIndex)==str.charAt(i))
                    break;
            }
            dp[dpIndex] =  dpIndex - i;
            if(dp[dpIndex]>maxdp)
                maxdp = dp[dpIndex];
        }
        return maxdp;
    }
    public static void main(String[] args){
        System.out.println(longestSubstringWithoutDup("arabcacfr"));
        System.out.println(longestSubstringWithoutDup("abcdefaaa"));

    }
}
