package chapter4;
import structure.TreeNode;

/**
 * Created by ryder on 2017/7/18.
 * 二叉搜索树与双向链表
 * 将二叉搜索树转换为双向链表，树的left指向prev节点，树的right指向post节点
 * 左右支转换完之后要与根节点组合，所以左右支要返回自己的最小点与最大点两个节点，返回值使用数组
 */
public class P191_ConvertBinarySearchTree {
    public static TreeNode<Integer> convert(TreeNode<Integer> root){
        if(root==null)
            return null;
        TreeNode<Integer>[] result = convertCore(root);
        return result[0];
    }
    public static TreeNode<Integer>[] convertCore(TreeNode<Integer> node){
        //java不支持泛型数组，所以声明为这种形式
        TreeNode[] result = new TreeNode[2];
        if(node.left==null&&node.right==null){
            result[0] = node;
            result[1] = node;
        }
        else if(node.right==null){
            result = convertCore(node.left);
            node.left = result[1];
            result[1].right = node;
            result[1] = node;
        }
        else if(node.left==null){
            result = convertCore(node.right);
            node.right = result[0];
            result[0].left = node;
            result[0] = node;
        }
        else{
            TreeNode[] resultLeft = convertCore(node.left);
            TreeNode[] resultRight = convertCore(node.right);
            resultLeft[1].right = node;
            node.left = resultLeft[1];
            resultRight[0].left = node;
            node.right = resultRight[0];
            result[0] = resultLeft[0];
            result[1] = resultRight[1];
        }
        return result;

    }
    public static void main(String[] args){
        //            10
        //          /   \
        //         6     14
        //       /  \   / \
        //      4    8 12  16
        TreeNode<Integer> root = new TreeNode<Integer>(10);
        root.left = new TreeNode<Integer>(6);
        root.right = new TreeNode<Integer>(14);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(8);
        root.right.left = new TreeNode<Integer>(12);
        root.right.right = new TreeNode<Integer>(16);
        TreeNode<Integer> result = convert(root);
        //转化后不可再使用二叉树的层序遍历显示结果，层序遍历会进入无限循环。
        System.out.println(result.leftToRight());

    }
}
