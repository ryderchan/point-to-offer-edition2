package chapter4;

import structure.TreeNode;

/**
 * Created by ryder on 2017/7/18.
 * 二叉搜索树的后序遍历序列
 */
public class P179_SequenceOfBST {
    public static boolean verifySquenceOfBST(int[] data){
        //空树
        if(data==null||data.length==0)
            return false;
        return verifySquenceOfBST(data,0,data.length-1);
    }
    public static boolean verifySquenceOfBST(int[] data,int start,int end){
        //数组长度为2，一定能够组成BST
        if(end-start<=1)
            return true;
        int root = data[end];
        int rightStart =0;
        for(int i=0;i<end;i++){
            if(data[i]>root){
                rightStart = i;
                break;
            }
        }
        for(int i=rightStart;i<end;i++){
            if(data[i]<root)
                return false;
        }
        return verifySquenceOfBST(data,start,rightStart-1)&&verifySquenceOfBST(data,rightStart,end-1);
    }
    public static void main(String[] args){
        //            8
        //          /   \
        //         6     10
        //       /  \   / \
        //      5    7 9   11
        int[] data = {5,7,6,9,4,10,8};
        int[] data1 = {5,7,6,9,11,10,8};
        System.out.println(verifySquenceOfBST(data));
        System.out.println(verifySquenceOfBST(data1));
    }
}
