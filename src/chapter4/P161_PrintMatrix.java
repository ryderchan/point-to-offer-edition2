package chapter4;

/**
 * Created by ryder on 2017/7/16.
 *
 */
public class P161_PrintMatrix {
    public static void printMatrix(int[][] data){
        if(data==null)
            return ;
        if(data.length==0||data[0].length==0)
            return ;
        int rowMax = data.length-1,rowLen = data.length;
        int colMax =data[0].length-1,colLen = data[0].length;
        int row=0,col=0,round=0;
        while(rowLen-2*row>1 && colLen-2*col>1){
            for(;col<=colMax-round;col++){
                System.out.print(data[row][col]);
                System.out.print("\t");
            }
            for(col=col-1,row=row+1;row<rowMax-round;row++){
                System.out.print(data[row][col]);
                System.out.print("\t");
            }
            for(;col>=round;col--){
                System.out.print(data[row][col]);
                System.out.print("\t");
            }
            for(col=col+1,row=row-1;row>round;row--){
                System.out.print(data[row][col]);
                System.out.print("\t");
            }
            row=row+1;
            col=col+1;
            round++;
        }
        //如果行数与列数中较小的那个是偶数，则能组成完整的环，在while中就完成了遍历
        if(rowLen-2*row==0 || colLen-2*col==0){
            System.out.println();
        }
        //如果行数与列数中较小的是行数，且是奇数，则还需补充访问一行
        if(rowLen-2*row==1){
            for(;col<=colMax-round;col++){
                System.out.print(data[row][col]);
                System.out.print("\t");
            }
            System.out.println();
        }
        //如果行数与列数中较小的是列数，且是奇数，则还需补充访问一列
        if(colLen-2*col==1){
            for(;row<=rowMax-round;row++){
                System.out.print(data[row][col]);
                System.out.print("\t");
            }
            System.out.println();
        }

    }
    public static void main(String[] args){
        int[][] data1={
                {1,2,3,4},
                {12,13,14,5},
                {11,16,15,6},
                {10,9,8,7},
        };
        int[][] data2={
                {1,2,3,4},
                {10,11,12,5},
                {9,8,7,6},
        };
        int[][] data3={
                {1,2,3},
                {10,11,4},
                {9,12,5},
                {8,7,6},
        };
        int[][] data4={
                {1,2,3},
                {8,9,4},
                {7,6,5},
        };
        printMatrix(data1);
        printMatrix(data2);
        printMatrix(data3);
        printMatrix(data4);
    }
}
