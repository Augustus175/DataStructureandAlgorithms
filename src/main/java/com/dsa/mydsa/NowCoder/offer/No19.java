package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-6-24.
 */

public class No19 {
    public static void main(String[] args) {


    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode pHead = null;
        if (list1.val <= list2.val) {
            pHead = list1;
            pHead.next = Merge(list1.next, list2);
        } else {
            pHead = list2;
            pHead.next = Merge(list1, list2.next);
        }
        return pHead;
    }

    //    merge sort thinking
    public ListNode Merge2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = null;
        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        ListNode result = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        if (list1 != null) {
            head.next = list1;
        }
        if (list2 != null) {
            head.next = list2;
        }
        return result;
    }
}
