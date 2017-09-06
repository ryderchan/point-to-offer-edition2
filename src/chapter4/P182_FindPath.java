package chapter4;

import structure.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryder on 2017/7/18.
 * 二叉树中和为某一值的路径
 */
public class P182_FindPath {
    //用类似于前序遍历的思路解决
    public static void findPath(TreeNode<Integer> root,int exceptedSum){
        if(root==null)
            return;
        List<Integer> path = new ArrayList<>();
        findPath(root,path,exceptedSum,0);
    }
    //curNode为将要被访问的节点，还未被加入到path中
    public static void findPath(TreeNode<Integer> curNode,List<Integer> path,int exceptedSum,int currentSum){
        path.add(curNode.val);
        currentSum+=curNode.val;
        if(curNode.left!=null)
            findPath(curNode.left,path,exceptedSum,currentSum);
        if(curNode.right!=null)
            findPath(curNode.right,path,exceptedSum,currentSum);
        if(curNode.left==null && curNode.right==null && currentSum==exceptedSum)
            System.out.println(path);
        path.remove(path.size()-1) ;
    }


    //如果所有节点值均大于0，可进行剪枝
    public static void findPath2(TreeNode<Integer> root,int exceptedSum){
        if(root==null)
            return;
        List<Integer> path = new ArrayList<>();
        findPath2(root,path,exceptedSum,0);
    }
    //curNode为将要被访问的节点，还未被加入到path中
    public static void findPath2(TreeNode<Integer> curNode,List<Integer> path,int exceptedSum,int currentSum){
        path.add(curNode.val);
        currentSum+=curNode.val;
        //只有当currentSum小于exceptedSum时需要继续当前节点的子节点的遍历
        if(currentSum<exceptedSum){
            if(curNode.left!=null)
                findPath2(curNode.left,path,exceptedSum,currentSum);
            if(curNode.right!=null)
                findPath2(curNode.right,path,exceptedSum,currentSum);
        }
        //currentSum大于等于exceptedSum时可以直接停止当前分支的遍历，因为当前分支下currentSum只会越来越大，不会再有符合要求的解
        else if(currentSum==exceptedSum && curNode.left==null && curNode.right==null)
            System.out.println(path);
        path.remove(path.size()-1) ;
    }
    public static void main(String[] args) {
        //            10
        //          /   \
        //         5     12
        //       /  \
        //      4    7
        TreeNode<Integer> root = new TreeNode<Integer>(10);
        root.left = new TreeNode<Integer>(5);
        root.right = new TreeNode<Integer>(12);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(7);
        findPath(root,22);
        findPath2(root,22);
    }
}
