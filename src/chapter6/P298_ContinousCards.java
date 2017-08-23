package chapter6;

/**
 * Created with IntelliJ IDEA
 * Author: ryder
 * Date  : 2017/8/20
 * Time  : 14:59
 * Description:扑克牌中的顺子
 **/
public class P298_ContinousCards {
    public static boolean isContinous(int[] data){
        if(data==null || data.length!=5)
            return false;
        int[] table = new int[14];
        for(int i=0;i<data.length;i++){
            if(data[i]>13||data[i]<0)
                return false;
            table[data[i]]++;
        }
        int start = 1;
        while (table[start]==0)
            start++;
        int king = table[0];
        for(int i=start;i<start+5;i++){
            if(i>13)
                break;
            if(table[i]>1||table[i]<0)
                return false;
            else if(table[i]==0){
                if(king==0)
                    return false;
                else
                    king--;
            }
        }
        return true;
    }
    public static void main(String[] args){
        int[] data1 = new int[]{4,2,7,12,1}; //false
        int[] data2 = new int[]{0,5,6,12,0}; //false
        int[] data3 = new int[]{6,5,8,7,4};  //true
        int[] data4 = new int[]{0,5,6,9,8};  //true
        int[] data5 = new int[]{0,13,0,12,0}; //true
        System.out.println(isContinous(data1));
        System.out.println(isContinous(data2));
        System.out.println(isContinous(data3));
        System.out.println(isContinous(data4));
        System.out.println(isContinous(data5));
    }
}
