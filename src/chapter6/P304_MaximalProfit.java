package chapter6;

/**
 * Created with IntelliJ IDEA
 * Author: ryder
 * Date  : 2017/8/20
 * Time  : 19:16
 * Description:股票的最大利润（仅能买卖一次）
 **/
public class P304_MaximalProfit {
    public static int maxDiff(int[] data){
        if(data==null||data.length<2)
            return 0;
        int min = data[0];
        int maxDiff = data[1] - min;
        if(data[1]<min)
            min = data[1];
        for(int i=2;i<data.length;i++){
            if(data[i]-min>maxDiff)
                maxDiff = data[i]-min;
            if(data[i]<min)
                min = data[i];
        }
        return maxDiff;
    }
    public static void main(String[] args){
        int[] data1 = new int[]{9,11,8,5,7,12,16,14};
        int[] data2 = new int[]{9,8,7,6,5,4,3,1};
        System.out.println(maxDiff(data1)); //11
        System.out.println(maxDiff(data2)); //-1
    }
}
