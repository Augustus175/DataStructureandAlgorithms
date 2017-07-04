package NowCoder.offer;

/**
 * Created by Gavin.Stevenson on 2017/7/4.
 */
public class No49 {
    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(5,3));
    }
//    best answer !!
    public static int LastRemaining_Solution(int n, int m) {
        if(n<1||m<1){
            return -1;
        }
        int last = 0;
        for(int i = 2;i<=n;i++){
            last = (last+m)%i;
        }
        return last;
    }
    public static int LastRemaining_Solution2(int n, int m) {
//        n==0 is a trap in nowcoder net;
        if(n==0){
            return -1;
        }
        ListNode head = new ListNode(0);
        ListNode current = head;
        for (int i = 1; i < n; i++) {
            ListNode newnode = new ListNode(i);
            current.next = newnode;
            current = newnode;
        }
        current.next = head;
        int count = n;
        current = head;
        while (n > 1) {
            for (int i = 1; i < m - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            current = current.next;
            n--;
        }
        return current.val;
    }
}
