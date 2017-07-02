package structure;
/**
 * Created by ryder on 2017/6/13.
 *
 */
public class ListNode<T> {
    public T val;
    public ListNode<T> next;
    public ListNode(T val){
        this.val = val;
        this.next = null;
    }
    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("[");
        for(ListNode cur = this;;cur=cur.next){
            if(cur==null){
                ret.deleteCharAt(ret.lastIndexOf(" "));
                ret.deleteCharAt(ret.lastIndexOf(","));
                break;
            }
            ret.append(cur.val);
            ret.append(", ");
        }
        ret.append("]");
        return ret.toString();
    }
}
