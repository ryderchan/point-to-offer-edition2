package chapter6;
import structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Author: ryder
 * Date  : 2017/8/15
 * Time  : 22:25
 * Description:二叉树的深度
 **/
public class P271_TreeDepth {
    //递归
    public static int treeDepth(TreeNode<Integer> root){
        if(root==null)
            return 0;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return left>right?(left+1):(right+1);
    }
    //非递归，广度优先/层序遍历
    public static int treeDepth2(TreeNode<Integer> root){
        if(root==null)
            return 0;
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            TreeNode<Integer> cur = null;
            for(int i=0;i<size;i++){
                cur = queue.poll();
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
            }
            depth++;
        }
        return depth;

    }
    public static void main(String[] args){
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.left.right.left = new TreeNode<>(7);
        root.right = new TreeNode<>(3);
        root.right.right = new TreeNode<>(6);
        System.out.println(treeDepth(root));
        System.out.println(treeDepth2(root));
    }
}
