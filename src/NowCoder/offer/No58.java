package NowCoder.offer;

/**
 * Created by zhangzhibo on 17-7-8.
 */
public class No58 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode fastp = pHead;
        ListNode slowp = pHead;
        while (fastp != null && slowp != null) {
            if (fastp.next != null) {
                fastp = fastp.next.next;
            }
            slowp = slowp.next;
            if (fastp == slowp) {
                break;
            }
        }
        if (fastp == null || slowp == null) {
            return null;
        }
        int count = 1;
        slowp = slowp.next;
        while (slowp != fastp) {
            slowp = slowp.next;
            count++;
        }

        slowp = pHead;
        fastp = pHead;
        while (count > 0) {
            count--;
            fastp = fastp.next;
        }
        while (fastp != slowp) {
            fastp = fastp.next;
            slowp = slowp.next;
        }
        return fastp;
    }
}
