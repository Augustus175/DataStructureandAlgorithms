package NowCoder.offer;

/**
 * Created by zhangzhibo on 17-6-23.
 */
public class No17 {
    public static void main(String[] args) {

    }
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        ListNode next = null;
        while(current!=null){
            next = current.next;
            current.next = pre;
            pre= current;
            current = next;
        }
        return pre;
    }
}
