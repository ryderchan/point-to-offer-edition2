package chapter5;

/**
 * Created with IntelliJ IDEA.
 * Author: ryder
 * Date  : 2017/8/1
 * Time  : 20:58
 * Description:连续子数组的最大和
 **/
public class P218_GreatestSumOfSubarrays {
    //动态规划，递归公式：dp[i] =  data[i]         i=0或dp[i-1]<=0
    //                             dp[i-1]+data[i] i!=0且dp[i-1]>0
    //由于只需知道前一个情况的dp值，因此可省去dp数组，申请个变量即可
    public static int findGreatestSumOfSumArrays(int[] data){
        if(data==null || data.length==0)
            return 0;
        //dp用于计算以data[i]为结尾元素的连续数组的最大和
        //maxdp用于记录在上述过程中的最大的dp值
        int dp = data[0],maxdp = dp;
        for(int i=1;i<data.length;i++){
            if(dp>0)
                dp += data[i];
            else
                dp = data[i];
            if(dp>maxdp)
                maxdp = dp;
        }
        return maxdp;
    }
    public static void main(String[] args){
        int[] data = {1,-2,3,10,-4,7,2,-5};
        System.out.println(findGreatestSumOfSumArrays(data));
    }
}
