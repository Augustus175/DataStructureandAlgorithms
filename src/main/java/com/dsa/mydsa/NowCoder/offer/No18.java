package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-6-23.
 */
public class No18 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode pHead = null;
        if (list1.val < list2.val) {
            pHead = list1;
            pHead.next = Merge(list1.next, list2);
        } else {
            pHead = list2;
            pHead.next = Merge(list1, list2.next);
        }
        return pHead;
    }
}
