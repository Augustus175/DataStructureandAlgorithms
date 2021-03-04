package com.dsa.mydsa.leetcodehot;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode after = head;
        ListNode front = head.next;
        ListNode tmp;
        head = head.next;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        while (front != null) {
            pre.next = front;
            tmp = front.next;
            front.next = after;
            after.next = tmp;
            pre = after;
            after = after.next;
            if (after == null) {
                break;
            }
            front = after.next;
        }
        return head;

    }

    public ListNode makeLink(int[] nums) {
        ListNode head = new ListNode(-1);
        ListNode result = head;
        for (int i :
                nums) {
            head.next = new ListNode(i);
            head = head.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        int[] nums = new int[]{1, 2, 3, 4};
        ListNode head = swapNodesInPairs.makeLink(nums);
        swapNodesInPairs.swapPairs(head);
    }
}
