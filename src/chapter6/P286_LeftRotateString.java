package chapter6;

/**
 * Created with IntelliJ IDEA
 * Author: ryder
 * Date  : 2017/8/18
 * Time  : 16:05
 * Description:左旋转字符串
 * abcdeftg 2 => cdefgab
 **/
public class P286_LeftRotateString {
    public static String leftRotateString(String str,int i){
        if(str==null||str.length()==0||i<=0||i>=str.length())
            return str;
        StringBuilder stringBuilder = new StringBuilder(str);
        reverseSubString(stringBuilder,0,stringBuilder.length()-1);
        reverseSubString(stringBuilder,0,stringBuilder.length()-i-1);
        reverseSubString(stringBuilder,stringBuilder.length()-i,stringBuilder.length()-1);
        return stringBuilder.toString();
    }
    //翻转stringBuilder[start,end]
    public static void reverseSubString(StringBuilder stringBuilder,int start,int end){
        for(int i=start;i<=start+(end-start)/2;i++){
            char temp = stringBuilder.charAt(i);
            stringBuilder.setCharAt(i,stringBuilder.charAt(end-i+start));
            stringBuilder.setCharAt(end-i+start,temp);
        }
    }
    public static void main(String[] args){
        String str = "abcdefg";
        System.out.println(leftRotateString(str,2));
    }
}
