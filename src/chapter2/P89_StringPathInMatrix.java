package chapter2;

/**
 * Created by ryder on 2017/7/2.
 * 矩阵中的路径
 */
public class P89_StringPathInMatrix {
    //回溯法解决
    public static boolean hasPath(char[][] data,String str){
        if(data==null || data.length==0 || str==null || str.length()==0)
            return false;
        int rowLen = data.length;
        int colLen = data[0].length;
        boolean[][] visitFlag = new boolean[rowLen][colLen];
        for(int row=0;row<rowLen;row++){
            for(int col=0;col<colLen;col++){
                visitFlag[row][col] = false;
            }
        }
        for(int row=0;row<rowLen;row++){
            for(int col=0;col<colLen;col++){
                if(hasPathCore(data,row,col,visitFlag,str,0))
                    return true;
            }
        }
        return false;
    }
    public static boolean hasPathCore(char[][] data,int rowIndex,int colIndex,boolean[][] visitFlag,String str,int strIndex){
        //结束条件
        if(strIndex>=str.length()) return true;
        if(rowIndex<0 || colIndex<0 || rowIndex>=data.length || colIndex>=data[0].length) return false;

        //递归
        if(!visitFlag[rowIndex][colIndex] && data[rowIndex][colIndex]==str.charAt(strIndex)){
            //如果未被访问，且匹配字符串，标记当前位置为已访问，分上下左右四个位置递归求解
            visitFlag[rowIndex][colIndex] = true;
            boolean result =  hasPathCore(data,rowIndex+1,colIndex,visitFlag,str,strIndex+1) ||
                    hasPathCore(data,rowIndex-1,colIndex,visitFlag,str,strIndex+1) ||
                    hasPathCore(data,rowIndex,colIndex+1,visitFlag,str,strIndex+1) ||
                    hasPathCore(data,rowIndex,colIndex-1,visitFlag,str,strIndex+1);
            //已经求的结果，无需修改标记了
            if(result)
                return true;
            //当前递归的路线求解失败，要把这条线路上的标记清除掉，因为其他起点的路径依旧可以访问本路径上的节点。
            else{
                visitFlag[rowIndex][colIndex] = false;
                return false;
            }
        }
        else
            return false;
    }
    public static void main(String[] args){
        char[][] data = {
                {'a','b','t','g'},
                {'c','f','c','s'},
                {'j','d','e','h'}};
        System.out.println(hasPath(data,"bfce")); //true
        System.out.println(hasPath(data,"abfb")); //false,访问过的位置不能再访问
    }
}
