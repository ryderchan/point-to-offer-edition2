package chapter3;

/**
 * Created by ryder on 2017/7/6.
 * 熟知的整数次方
 */
public class P113_Power {
    static boolean invalidInput = false;
    public static double power(double base,int exponent){
        //0的0次方在数学上没有意义，为了方便也返回1
        if(exponent==0)
            return 1;
        if(exponent<0){
            if(equal(base,0)){
                invalidInput = true;
                return 0;
            }
            else
                return 1.0/powerWithPositiveExponent(base,-1*exponent);
        }
        else
            return powerWithPositiveExponent(base,exponent);
    }
    public static boolean equal(double x,double y){
       return -0.00001<x-y && x-y<0.00001;
    }
    public static double powerWithPositiveExponent(double base,int exponent){
        if(exponent==0)
            return 1;
        else if((exponent&1)==0){
            double temp = powerWithPositiveExponent(base,exponent>>1);
            return temp*temp;
        }
        else{
            double temp = powerWithPositiveExponent(base,exponent>>1);
            return base*temp*temp;
        }
    }
    public static void main(String[] args){
        System.out.println("2^3="+power(2,3)+"\t是否报错:"+invalidInput);
        System.out.println("2^-3="+power(2,-3)+"\t是否报错:"+invalidInput);
        System.out.println("0^3="+power(0,3)+"\t是否报错:"+invalidInput);
        System.out.println("0^-3="+power(0,-3)+"\t是否报错:"+invalidInput);
    }
}
