package structure;
import java.util.LinkedList;
import java.util.Queue;
/**
 * Created by ryder on 2017/6/12.
 * 树节点
 */
public class TreeNode<T> {
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;
    public TreeNode(T val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

    //层序遍历
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(this);
        TreeNode<T> temp;
        while(!queue.isEmpty()){
            temp = queue.poll();
            stringBuilder.append(temp.val);
            stringBuilder.append(",");
            if(temp.left!=null)
                queue.offer(temp.left);
            if(temp.right!=null)
                queue.offer(temp.right);
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    //将二叉树转换为双向链表后，toString无限循环，需使用本函数打印
    public String leftToRight(){
        TreeNode cur = this;
        StringBuilder ret = new StringBuilder();
        while(cur!=null){
            ret.append(cur.val);
            ret.append("\t");
            cur = cur.right;
        }
        return ret.toString();
    }
}
