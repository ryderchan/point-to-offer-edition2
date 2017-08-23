package chapter6;

/**
 * Created with IntelliJ IDEA
 * Author: ryder
 * Date  : 2017/8/17
 * Time  : 16:01
 * Description:翻转字符串
 **/
public class P284_ReverseWordsInSentence {
    public static String reverse(String str){
        StringBuilder stringBuilder = new StringBuilder(str);
        reverseSubString(stringBuilder,0,stringBuilder.length()-1);
        int start = 0,end = stringBuilder.indexOf(" ");
        while (start<stringBuilder.length()&&end!=-1){
            reverseSubString(stringBuilder,start,end-1);
            start = end+1;
            end = stringBuilder.indexOf(" ",start);
        }
        if(start<stringBuilder.length())
            reverseSubString(stringBuilder,start,stringBuilder.length()-1);
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
        System.out.println(reverse("I am a student."));
    }
}
