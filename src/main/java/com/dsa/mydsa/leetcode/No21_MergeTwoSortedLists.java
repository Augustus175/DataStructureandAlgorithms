package com.dsa.mydsa.leetcode;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class No21_MergeTwoSortedLists {
    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode current = null;
        ListNode head = null;
        if (l1.val > l2.val) {
            current = l2;
            l2 = l2.next;
        } else {
            current = l1;
            l1 = l1.next;
        }
        head = current;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                current = current.next;
                l1 = l1.next;
            } else {
                current.next = l2;
                current = current.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            current.next = l2;
        }
        if (l2 == null) {
            current.next = l1;
        }
        return head;
    }

    public ListNode remergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = remergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = remergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

