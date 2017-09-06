package chapter5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA
 * Author: ryder
 * Date  : 2017/8/3
 * Time  : 10:13
 * Description:把数组排成最小的数
 **/
public class P227_SortArrayForMinNumber {
    public static void printMinNumber(int[] data){
        if(data==null||data.length==0)
            return;
        for(int i=0;i<data.length-1;i++){
            for(int j=0;j<data.length-1-i;j++){
                if(bigger(data[j],data[j+1])){
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
        for(int item:data){
            System.out.print(item);
            System.out.print(" ");
        }
        System.out.println();
    }
    //if a>=b return true
    public static boolean bigger(int a,int b){
        String temp1 = a+""+b;
        String temp2 = b+""+a;
        if(temp1.compareTo(temp2)>0)
            return true;
        else
            return false;
    }
    public static void main(String[] args){
        printMinNumber(new int[]{3,32,321});
    }
}
