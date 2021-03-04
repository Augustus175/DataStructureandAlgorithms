package com.dsa.mydsa.leetcodehot;

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode fast = head;
        ListNode last = head;
        int i = 0;
        while (i < n && fast != null) {
            fast = fast.next;
            i++;
        }
        while (fast != null) {
            pre = pre.next;
            fast = fast.next;
            last = last.next;
        }
        pre.next = last.next;
        head = dummy.next;
        dummy.next = null;
        return head;

    }
}
