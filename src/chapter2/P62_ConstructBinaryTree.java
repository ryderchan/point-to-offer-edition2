package chapter2;

import structure.TreeNode;

import java.util.List;

/**
 * Created by ryder on 2017/6/20.
 * 重建二叉树:
 * 前序+中序，后续+中序可以完成重建，而前序+后序无法完成
 */
public class P62_ConstructBinaryTree {
    public static TreeNode construct(int[] preorder,int[] inorder){
        if(preorder==null || inorder==null || preorder.length==0 || preorder.length!=inorder.length)
            return null;
        return constructCore(preorder,0,inorder,0,preorder.length);
    }
    public static TreeNode constructCore(int[] preorder,int preorder_start,int[] inorder,int inorder_start,int length){
        if(length==0)
            return null;
        int inorder_index = -1;
        for(int i=inorder_start;i<inorder_start+length;i++){
            if(inorder[i]==preorder[preorder_start]){
                inorder_index = i;
                break;
            }
        }
        int left_length = inorder_index - inorder_start;
        TreeNode node = new TreeNode(preorder[preorder_start]);
        node.left = constructCore(preorder,preorder_start+1,inorder,inorder_start,left_length);
        node.right = constructCore(preorder,preorder_start+left_length+1,inorder,inorder_index+1,length-left_length-1);
        return node;
    }
    public static void main(String[] args){
        //            1
        //          /   \
        //         2     3
        //        / \
        //       4   5
        //pre->12453  in->42513   post->45231
        int[] pre={1,2,4,5,3};
        int[] in={4,2,5,1,3};
        TreeNode root = construct(pre,in);
        //对重建后的树,进行前中后序遍历，验证是否重建正确
        List<Integer> preorder = P60_TraversalOfBinaryTree.preorderIteratively(root);
        List<Integer> inorder = P60_TraversalOfBinaryTree.inorderIteratively(root);
        List<Integer> postorder = P60_TraversalOfBinaryTree.postorderIteratively(root);
        System.out.println(preorder);
        System.out.println(inorder);
        System.out.println(postorder);
    }
}
