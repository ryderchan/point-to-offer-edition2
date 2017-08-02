package chapter3;
import structure.TreeNode;
/**
 * Created by ryder on 2017/7/14.
 * 树的子结构
 */
public class P148_SubstructureInTree {
    public static boolean hasSubtree(TreeNode<Integer> root1, TreeNode<Integer> root2){
        if(root2==null)
            return true;
        if(root1==null)
            return false;
        if(root1.val.equals(root2.val)){
            if(tree1HasTree2FromRoot(root1,root2))
                return true;
        }
        return hasSubtree(root1.left,root2) || hasSubtree(root1.right,root2);
    }
    public static boolean tree1HasTree2FromRoot(TreeNode<Integer> root1, TreeNode<Integer> root2){
        if(root2==null)
            return true;
        if(root1==null)
            return false;
        if(root1.val.equals(root2.val) && tree1HasTree2FromRoot(root1.left,root2.left) && tree1HasTree2FromRoot(root1.right,root2.right))
            return true;
        else
            return false;

    }
    public static void main(String[] args){
        TreeNode<Integer> root1 = new TreeNode<>(8);
        root1.left = new TreeNode<>(8);
        root1.right = new TreeNode<>(7);
        root1.left.left = new TreeNode<>(9);
        root1.left.right = new TreeNode<>(2);
        root1.left.right.left = new TreeNode<>(4);
        root1.left.right.right = new TreeNode<>(7);
        TreeNode<Integer> root2 = new TreeNode<>(8);
        root2.left = new TreeNode<>(9);
        root2.right = new TreeNode<>(2);
        TreeNode<Integer> root3 = new TreeNode<>(2);
        root3.left = new TreeNode<>(4);
        root3.right = new TreeNode<>(3);
        System.out.println(hasSubtree(root1,root2));
        System.out.println(hasSubtree(root1,root3));
    }
}
