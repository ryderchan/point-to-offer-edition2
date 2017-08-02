package chapter3;

/**
 * Created by ryder on 2017/7/13.
 * 表示数值的字符串
 */
public class P127_NumberStrings {
    public static boolean isNumeric(String str){
        //正确的形式：A[.[B]][e|EC] 或者 .B[e|EC];
        if(str==null||str.length()==0)
            return false;
        int index;
        if(str.charAt(0)!='.'){
            index = scanInteger(str,0);
            if(index==-1)
                return false;
            if(index==str.length())
                return true;
            if(str.charAt(index)=='.'){
                if(index==str.length()-1)
                    return true;
                index = scanInteger(str,index+1);
                if(index==str.length())
                    return true;
            }
            if(str.charAt(index)=='e'||str.charAt(index)=='E'){
                index = scanInteger(str,index+1);
                if(index==str.length())
                    return true;
                else
                    return false;
            }
            return false;
        }
        else{
            index = scanInteger(str,1);
            if(index==-1)
                return false;
            if(index==str.length())
                return true;
            if(str.charAt(index)=='e'||str.charAt(index)=='E'){
                index = scanInteger(str,index+1);
                if(index==str.length())
                    return true;
            }
            return false;

        }

    }
    public static int scanInteger(String str,Integer index){
        if(index>=str.length())
            return -1;
        if(str.charAt(index)=='+'||str.charAt(index)=='-')
            return scanUnsignedInteger(str,index+1);
        else
            return scanUnsignedInteger(str,index);
    }
    public static int scanUnsignedInteger(String str,Integer index){
        int origin = index;
        while(str.charAt(index)>='0'&&str.charAt(index)<='9'){
            index++;
            if(index==str.length())
                return index;
        }
        if(origin==index)
            index = -1;
        return index;
    }
    public static void main(String[] args){
        System.out.println(isNumeric("+100"));//true
        System.out.println(isNumeric("5e2")); //true
        System.out.println(isNumeric("-123"));//true
        System.out.println(isNumeric("3.1416"));//true
        System.out.println(isNumeric("-1E-16"));//true
        System.out.println(isNumeric(".6"));//true
        System.out.println(isNumeric("6."));//true
        System.out.println(isNumeric("12e"));//false
        System.out.println(isNumeric("1a3.14"));//false
        System.out.println(isNumeric("1.2.3"));//false
        System.out.println(isNumeric("+-5"));//false
        System.out.println(isNumeric("12e+5.4"));//false
    }
}
