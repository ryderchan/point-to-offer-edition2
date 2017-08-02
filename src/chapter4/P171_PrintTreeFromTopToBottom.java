package chapter4;

import structure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ryder on 2017/7/17.
 * 从上到下打印二叉树(层序遍历)
 */
public class P171_PrintTreeFromTopToBottom {
    public static void printFromTopToBottom(TreeNode<Integer> root){
        if(root==null)
            return;
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode<Integer> temp;
        while(!queue.isEmpty()){
            temp = queue.poll();
            System.out.print(temp.val);
            System.out.print('\t');
            if(temp.left!=null)
                queue.offer(temp.left);
            if(temp.right!=null)
                queue.offer(temp.right);
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
        printFromTopToBottom(root);
    }
}
