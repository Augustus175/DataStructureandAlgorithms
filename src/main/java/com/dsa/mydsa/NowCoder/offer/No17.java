package com.dsa.mydsa.NowCoder.offer;

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
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
    ListNode result;

    public ListNode ReverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        recore(head);
        return result;

    }

    public ListNode recore(ListNode head) {
        if (head.next == null) {
            result = head;
            return head;
        }
        ListNode next = recore(head.next);
        next.next = head;
        head.next = null;
        return head;
    }
}

