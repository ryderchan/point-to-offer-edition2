package chapter4;

import java.util.*;

/**
 * Created by ryder on 2017/7/22.
 * 字符串的组合
 */
public class P199_StringCombination {
    //无重复字符：对于每一个字符，都由两种选择：被选中、不被选中；
    //有重复字符：整体需要先排序，对于重复n遍的某种字符，有如下选择：不被选中，选1个，选2个...选n个。
    public static List<char[]> combination(char[] strs) {
        if (strs == null || strs.length == 0)
            return null;
        Arrays.sort(strs);
        List<char[]> ret = new LinkedList<>();
        combinationCore(strs,ret,new StringBuilder(),0);
        return ret;
    }
    public static void combinationCore(char[] strs,List<char[]> ret,StringBuilder stringBuilder,int cur){
        if(cur==strs.length ) {
            if(stringBuilder.length()>0)
                ret.add(stringBuilder.toString().toCharArray());
        }
        else if(cur+1==strs.length||strs[cur]!=strs[cur+1]){
            combinationCore(strs,ret,stringBuilder.append(strs[cur]),cur+1);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            combinationCore(strs,ret,stringBuilder,cur+1);

        }
        else{
            //先计算出重复次数
            int dumplicateStart = cur;
            while(cur!=strs.length&&strs[dumplicateStart]==strs[cur]){
                stringBuilder.append(strs[cur]);
                cur++;
            }
            int newStart = cur;
            while (cur>=dumplicateStart) {
                combinationCore(strs, ret, stringBuilder, newStart);
                if(cur!=dumplicateStart)
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                cur--;
            }

        }
    }
    public static void main(String[] args) {
//        char[] strs = {'a', 'b', 'c'};
//        List<char[]> ret = combination(strs);
//        for (char[] item : ret) {
//            for (int i = 0; i < item.length; i++)
//                System.out.print(item[i]);
//            System.out.println();
//        }
//        System.out.println();
        char[] strs2 = {'a', 'a', 'b'};
        List<char[]> ret2 = combination(strs2);
        for (char[] item : ret2) {
            for (int i = 0; i < item.length; i++)
                System.out.print(item[i]);
            System.out.println();
        }
    }
}
