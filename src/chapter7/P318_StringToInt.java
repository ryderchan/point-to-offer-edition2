package chapter7;

/**
 * Created with IntelliJ IDEA
 * Author: ryder
 * Date  : 2017/8/22
 * Time  : 16:06
 * Description:把字符串转换成整数
 **/
public class P318_StringToInt {
//    atoi的需求是这样的：
//    如果前面有空格，需要剔除空格；
//    剔除空格后，第一个字符串如果是+号，认为是正数；如果是-号，认为是负数；
//    后面的字符如果不是数字，那么返回0，如果是数字，返回实际的数字。遇到不是数字的字符，转换结束。
//    此外，要考虑空串问题，数值溢出问题[2^(-31) ~ 2^31-1]。

    public static int strToInt(String str) throws Exception{
        if(str==null || str.length()==0)
            throw new Exception("待转换字符串为null或空串");
        String MAX_INT_PLUS_1 = Integer.toString(Integer.MIN_VALUE).substring(1);
        StringBuilder stringBuilder = new StringBuilder(str.trim());
        int flag = 0; //记录无符号的正（2）正（1），负（-1）,初始值（0）
        if(stringBuilder.charAt(0)=='-')
            flag = -1;
        else if(stringBuilder.charAt(0)=='+')
            flag = 1;
        else if(stringBuilder.charAt(0)>='0'&&stringBuilder.charAt(0)<='9')
            flag = 2;
        else
            return 0;
        int endIndex = 1;
        while (endIndex<stringBuilder.length()&&stringBuilder.charAt(endIndex)>='0'&&stringBuilder.charAt(endIndex)<='9')
            endIndex++;
        if(flag==2){
            if(stringBuilder.substring(0,endIndex).toString().compareTo(MAX_INT_PLUS_1)>=0)
                throw new Exception("数值上溢,待转换字符串为"+str);
            return Integer.parseInt(stringBuilder.substring(0,endIndex));
        }
        else{
            if(flag==1&&stringBuilder.substring(1,endIndex).compareTo(MAX_INT_PLUS_1)>=0)
                throw new Exception("数值上溢,待转换字符串为"+str);
            if(flag==-1&&stringBuilder.substring(1,endIndex).compareTo(MAX_INT_PLUS_1)>0)
                throw new Exception("数值下溢,待转换字符串为"+str);
            if(flag==-1&&stringBuilder.substring(1,endIndex).compareTo(MAX_INT_PLUS_1)==0)
                //此处注意，此种情况不能用绝对值*（-1），该绝对值已经超出正数的最大值
                return Integer.MIN_VALUE;
            return flag*Integer.parseInt(stringBuilder.substring(1,endIndex));
        }
    }

    public static void funcTest(){
        try {
        System.out.println(strToInt(" 100")); //100
        System.out.println(strToInt("-100")); //-100
        System.out.println(strToInt("0")); //0
        System.out.println(strToInt("-0"));//0
        System.out.println(strToInt("1.23"));  //1
        System.out.println(strToInt("-1.23")); //-1
        System.out.println(strToInt(".123"));  //0
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void edgeTest(){
        try {
            System.out.println(strToInt("2147483647"));  //2147483647
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(strToInt("-2147483647")); //-2147483647
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(strToInt("2147483647"));  //2147483647
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(strToInt("2147483648"));  //上溢
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(strToInt("-2147483648")); //-2147483648
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(strToInt("-2147483649")); //下溢
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(strToInt(null)); //待转换字符串为null或空串
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(strToInt(""));   //待转换字符串为null或空串
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args){
        funcTest();
        edgeTest();
    }
}
