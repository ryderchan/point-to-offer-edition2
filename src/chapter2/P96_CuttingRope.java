package chapter2;

/**
 * Created by ryder on 2017/7/5.
 * 剪绳子
 */
public class P96_CuttingRope {
    public static int maxCutting(int length){
        if(length<2) return 0;
        if(length==2)return 1;
        if(length==3)return 2;
        int[] dp = new int[length+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        int max = 0;
        int temp = 0;
        for(int i=4;i<=length;i++){
            max = 0;
            for(int j=1;j<=i/2;j++){
                temp = dp[j]*dp[i-j];
                if(temp>max)
                    max = temp;
            }
            dp[i] = max;
        }
        return dp[length];
    }
    public static void main(String[] args){
        for(int i=2;i<10;i++){
            System.out.println("长度为"+i+"的最大值->"+maxCutting(i));
        }
    }
}
