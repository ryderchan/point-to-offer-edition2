package chapter2;

/**
 * Created by ryder on 2017/6/21.
 * 斐波那契数列
 * f(0)=0,f(1)=1,f(n)=f(n-1)+f(n-2) n>1
 */
public class P74_Fibonacci {
    // 依据原始概念的递归解法，时间复杂度o(n^2)
    public static int fibonacci1(int n){
        if(n<=0)
            return 0;
        if(n==1)
            return 1;
        return fibonacci1(n-1)+fibonacci1(n-2);
    }
    // 当前状态只与前两个状态有关。存储前两个值，计算后一个，迭代进行。时间复杂度o(n)
    public static int fibonacci2(int n){
        if(n<=0)
            return 0;
        if(n==1)
            return 1;
        int temp1 =0,temp2=1;
        int result = temp1 + temp2,i=3;
        while(i<=n){
            //也可用一个队列来完成下面三行的操作
            temp1 = temp2;
            temp2 = result;
            result = temp1+temp2;
            i++;
        }
        return result;
    }
    // 使用如下数学公式，矩阵乘法部分，可用递归解决，时间复杂度o(logn)
    // [ f(n)  f(n-1) ] = [ 1  1 ] ^ n-1   (当n>2)
    // [f(n-1) f(n-2) ]   [ 1  0 ]
    // 证明:
    // [ f(n)  f(n-1) ] = [ f(n-1)+f(n-2)  f(n-1)] = [ f(n-1)  f(n-2)] * [1 1]
    // [f(n-1) f(n-2) ]   [ f(n-2)+f(n-3)  f(n-2)]   [ f(n-2)  f(n-3)]   [1 0]
    // 得到如上递推式，所以
    // [ f(n)  f(n-1) ] = [ f(2)  f(1)] * [1 1]^n-2 = [1 1]^n-1
    // [f(n-1) f(n-2) ]   [ f(1)  f(0)]   [1 0]       [1 0]
    public static int fibonacci3(int n){
        int[][] start = {{1,1},{1,0}};
        return matrixPow(start,n-1)[0][0];
    }
    public static int[][] matrixPow(int[][] start,int n){
         if((n&1)==0){
             int[][] temp = matrixPow(start,n>>1);
             return matrixMultiply(temp,temp);
         }
         else if(n==1){
             return start;
         }
         else{
             return matrixMultiply(start,matrixPow(start,n-1));
         }
    }
    public static int[][] matrixMultiply(int[][] x,int[][] y){
        int[][] result = new int[x.length][y[0].length];
        for(int i=0;i<x.length;i++){
            for(int j=0;j<y[0].length;j++){
                int sum = 0;
                for(int k=0;k<x[0].length;k++){
                    sum += x[i][k]*y[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
    // 使用通项公式完成，时间复杂度o(1)
    // f(n) = (1/√5)*{[(1+√5)/2]^n - [(1-√5)/2]^n}
    // 推导过程可参考https://wenku.baidu.com/view/57333fe36bd97f192379e936.html
    public static int fibonacci4(int n){
        double gen5 = Math.sqrt(5);
        return (int)((1/gen5)*(Math.pow((1+gen5)/2,n)- Math.pow((1-gen5)/2,n)));
    }
    public static void main(String[] args){
        System.out.println(fibonacci1(13));
        System.out.println(fibonacci2(13));
        System.out.println(fibonacci3(13));
        System.out.println(fibonacci4(13));
    }
}
