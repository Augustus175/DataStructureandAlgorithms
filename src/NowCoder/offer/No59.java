package NowCoder.offer;

/**
 * Created by zhangzhibo on 17-7-5.
 */
public class No59 {
    public static void main(String[] args) {

    }

    public static ListNode deleteDuplication(ListNode pHead) {
        ListNode pre = new ListNode(0);
        pre.next = pHead;
        ListNode result = pre;
        ListNode cur = pHead;

        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur = cur.next;
            }else{
               pre = cur;
               cur = cur.next;
            }

        }
        return result.next;
    }
}
