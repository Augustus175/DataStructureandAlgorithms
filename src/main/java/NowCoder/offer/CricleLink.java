package NowCoder.offer;

/**
 * Created by zhangzhibo on 17-7-8.
 */
public class CricleLink {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = c;
        System.out.println(findCricle(a));
    }

    public static int findCricle(ListNode phead) {
        ListNode fastp = phead;
        ListNode slowp = phead;
        while (fastp != null && slowp != null) {
            if (fastp.next != null) {
                fastp = fastp.next.next;
            }
            slowp = slowp.next;
            if (fastp == slowp) {
                break;
            }
        }
        int count = 1;
        slowp = slowp.next;
        while(slowp!=fastp){
            slowp = slowp.next;
            count++;
        }

        slowp = phead;
        fastp = phead;
        while(count>0){
            count--;
            fastp = fastp.next;
        }
        while (fastp!=slowp){
            fastp = fastp.next;
            slowp = slowp.next;
        }
        return fastp.val;
    }
}
