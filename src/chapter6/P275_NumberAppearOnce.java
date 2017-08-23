package chapter6;

/**
 * Created with IntelliJ IDEA
 * Author: ryder
 * Date  : 2017/8/17
 * Time  : 10:58
 * Description:数组中数字出现的次数
 * 有两个数字分别出现一次，其他的都出现两次，找到这两个数字
 **/
public class P275_NumberAppearOnce {
    public static int[] findNumsAppearOnce(int[] data){
        int result = 0;
        for(int i=0;i<data.length;i++)
            result^=data[i];
        int indexOf1 = findFirstBit1(result);
        int ret[] = new int[]{0,0};
        if(indexOf1<0)
            return ret;
        for(int i=0;i<data.length;i++){
            if((data[i]&indexOf1)==0)
                ret[0]^=data[i];
            else
                ret[1]^=data[i];
        }
        return ret;
    }
    public static int findFirstBit1(int num){
        if(num<0)
            return -1;
        int indexOf1 = 1;
        while (num!=0){
            if((num&1)==1)
                return indexOf1;
            else{
                num = num>>1;
                indexOf1*=2;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] data = new int[]{2,4,3,6,3,2,5,5};
        int[] result = findNumsAppearOnce(data); // 4,6
        System.out.println(result[0]);
        System.out.println(result[1]);

    }
}
