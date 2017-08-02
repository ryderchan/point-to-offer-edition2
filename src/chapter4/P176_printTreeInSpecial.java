package chapter4;

import structure.TreeNode;

import java.util.Stack;

/**
 * Created by ryder on 2017/7/18.
 * 之字形打印二叉树
 */
public class P176_printTreeInSpecial {
    public static void printTreeInSpeical(TreeNode<Integer> root){
        if(root==null)
            return;
        Stack<TreeNode<Integer>> stack1 = new Stack<>();
        Stack<TreeNode<Integer>> stack2 = new Stack<>();
        TreeNode<Integer> temp;
        stack1.push(root);
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            if(!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    temp = stack1.pop();
                    System.out.print(temp.val);
                    System.out.print('\t');
                    if (temp.left != null)
                        stack2.push(temp.left);
                    if (temp.right != null)
                        stack2.push(temp.right);
                }
            }
            else {
                while (!stack2.isEmpty()) {
                    temp = stack2.pop();
                    System.out.print(temp.val);
                    System.out.print('\t');
                    if (temp.right != null)
                        stack1.push(temp.right);
                    if (temp.left != null)
                        stack1.push(temp.left);
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        //            1
        //          /   \
        //         2     3
        //       /  \   / \
        //      4    5 6   7
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.left = new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(3);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(5);
        root.right.left = new TreeNode<Integer>(6);
        root.right.right = new TreeNode<Integer>(7);
        printTreeInSpeical(root);
    }
}
