package chapter6;

import structure.TreeNode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Author: ryder
 * Date  : 2017/8/15
 * Time  : 19:17
 * Description:二叉搜索树的第k大节点
 **/
public class P269_KthNodeInBST {
    public static TreeNode<Integer> kthNode(TreeNode<Integer> root,int k){
        //栈顶元素保证一直是cur的父节点
        if(root==null || k<0)
            return null;
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> cur = root;
        int count = 0;
        while (!stack.isEmpty()||cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            else{
                cur = stack.pop();
                count++;
                if(count==k)
                    return cur;
                cur = cur.right;
            }
        }
        return null;
    }
    public static void main(String[] args){
        TreeNode<Integer> root = new TreeNode<>(5);
        root.left = new TreeNode<>(3);
        root.left.left = new TreeNode<>(2);
        root.left.right = new TreeNode<>(4);
        root.right = new TreeNode<>(7);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(8);
        System.out.println(kthNode(root,3).val);//4
        System.out.println(kthNode(root,6).val);//7
        System.out.println(kthNode(root,8));//null
    }
}
