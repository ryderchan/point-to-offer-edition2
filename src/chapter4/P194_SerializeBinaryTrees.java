package chapter4;

import structure.TreeNode;

/**
 * Created by ryder on 2017/7/19.
 * 序列化二叉树
 */
public class P194_SerializeBinaryTrees {
    public static String serialize(TreeNode<Integer> root){
        if(root==null)
            return "$,";
        StringBuilder result = new StringBuilder();
        result.append(root.val);
        result.append(",");
        result.append(serialize(root.left));
        result.append(serialize(root.right));
        return result.toString();
    }
    public static TreeNode<Integer> deserialize(String str){
        StringBuilder stringBuilder = new StringBuilder(str);
        return deserializeCore(stringBuilder);
    }
    public static TreeNode<Integer> deserializeCore(StringBuilder stringBuilder){
        if(stringBuilder.length()==0)
            return null;
        String num = stringBuilder.substring(0,stringBuilder.indexOf(","));
        stringBuilder.delete(0,stringBuilder.indexOf(","));
        stringBuilder.deleteCharAt(0);
        if(num.equals("$"))
            return null;
        TreeNode<Integer> node = new TreeNode<>(Integer.parseInt(num));
        node.left = deserializeCore(stringBuilder);
        node.right = deserializeCore(stringBuilder);
        return node;
    }
    public static void main(String[] args){
        //            1
        //          /   \
        //         2     3
        //       /      / \
        //      4      5   6
        //    1,2,4,$,$,$,3,5,$,$,6,$,$
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.left = new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(3);
        root.left.left = new TreeNode<Integer>(4);
        root.right.left = new TreeNode<Integer>(5);
        root.right.right = new TreeNode<Integer>(6);
        System.out.println("原始树："+root);
        String result = serialize(root);
        System.out.println("序列化结果："+result);
        TreeNode<Integer> deserializeRoot = deserialize(result);
        System.out.println("反序列后的树："+deserializeRoot);
    }
}
