package NowCoder.offer;

/**
 * Created by zhangzhibo on 17-6-23.
 */
public class No18 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode current1 = list1;
        ListNode next1 = current1.next;

        ListNode current2 = list2;
        ListNode next2 = current2.next;
        while ((next1 != null) && (next2 != null)) {
            if ((current1.val <= current2.val) && (next1.val >= current2.val)) {
                current1.next = current2;
                current2.next = next1;
                current1 = current2;
                next1 = current1.next;
                current2 = next2;
                next2 = current2.next;
            }
        }
        return null;
    }
}
