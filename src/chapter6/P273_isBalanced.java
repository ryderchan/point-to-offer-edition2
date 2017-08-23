package chapter6;

import structure.TreeNode;

/**
 * Created with IntelliJ IDEA
 * Author: ryder
 * Date  : 2017/8/17
 * Time  : 10:03
 * Description:平衡二叉树
 **/
public class P273_isBalanced {
    //借助于深度，判断是否是平衡二叉树
    public static boolean isBalanced(TreeNode<Integer> node){
        if(node==null)
            return true;
        int left = treeDepth(node.left);
        int right = treeDepth(node.right);
        int diff = left - right;
        if(diff<-1||diff>1)
            return false;
        return isBalanced(node.left)&&isBalanced(node.right);
    }
    public static int treeDepth(TreeNode<Integer> root){
        if(root==null)
            return 0;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return left>right?(left+1):(right+1);
    }
    public static boolean isBalanced2(TreeNode<Integer> node,int[] depth){
        if(node==null){
            depth[0] = 0;
            return true;
        }
        int[] left = new int[]{0};
        int[] right = new int[]{0};
        if(isBalanced2(node.left,left)&&isBalanced2(node.right,right)){
            int diff = left[0]-right[0];
            if(diff<=1&&diff>=-1){
                depth[0] = 1+(left[0]>right[0]?left[0]:right[0]);
                return true;
            }
            else
                return false;
        }
        return false;
    }
    public static void main(String[] args){
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.left.right.left = new TreeNode<>(7);
        root.right = new TreeNode<>(3);
        root.right.right = new TreeNode<>(6);
        System.out.println(isBalanced(root));
        System.out.println(isBalanced2(root,new int[]{0}));
    }
}
