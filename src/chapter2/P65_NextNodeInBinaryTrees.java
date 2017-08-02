package chapter2;

/**
 * Created by ryder on 2017/6/20.
 * 二叉树的下一个节点
 * (此二叉树节点不仅有两个孩子节点指针，还包括一个父节点指针)
 */
public class P65_NextNodeInBinaryTrees {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode father;
        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
            this.father = null;
        }
    }
    public static TreeNode getNext(TreeNode node){
        if(node==null)
            return null;
        else if(node.right!=null)
            return node.right;
        else{
            TreeNode curnode = node;
            while (true){
                if(curnode.father==null)
                    return null;
                else if(curnode.father.left==curnode)
                    return curnode.father;
                else
                    curnode = curnode.father;
            }

        }
    }
    public static void main(String[] args){
        //            1
        //          // \\
        //         2     3
        //       // \\
        //      4     5
        //    inorder->42513
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.father = root;
        root.right = new TreeNode(3);
        root.right.father = root;
        root.left.left = new TreeNode(4);
        root.left.left.father = root.left;
        root.left.right = new TreeNode(5);
        root.left.right.father = root.left;

        System.out.println(getNext(root.left.left).val);
        System.out.println(getNext(root.left).val);
        System.out.println(getNext(root.left.right).val);
        System.out.println(getNext(root).val);
        System.out.println(getNext(root.right));

    }
}
