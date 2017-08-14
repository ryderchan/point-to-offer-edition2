package chapter5;

/**
 * Created with IntelliJ IDEA
 * Author: ryder
 * Date  : 2017/8/13
 * Time  : 16:41
 * Description:字符流中第一个只出现一次的字符
 **/
public class P247_FirstNotRepeatingCharInStream {
    public static class CharStatistics{
        private int[] times;
        private int index;
        public CharStatistics(){
            index = 0;
            times = new int[256];
            //-1表示未出现，>=0表示出现的位置且仅出现一次，-2表示出现两次及以上
            for(int i=0;i<256;i++)
                times[i] = -1;
        }
        public void insert(char ch){
            if(times[ch]==-1)
                times[ch] = index;
            else
                times[ch] = -2;
            index++;
        }
        public char find(){
            int minIndex = 256;
            char ret = '\77';
            for(int i=0;i<256;i++){
                if(times[i]>=0 && times[i]<minIndex) {
                    minIndex = times[i];
                    ret = (char)i;
                }
            }
            return ret;
        }
    }
    public static void main(String[] args){
        String str = "google";
        CharStatistics charStatistics = new CharStatistics();
        for(int i=0;i<str.length();i++){
            charStatistics.insert(str.charAt(i));
            System.out.print(charStatistics.find());
        }
    }
}
