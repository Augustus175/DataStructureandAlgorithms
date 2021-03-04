package com.dsa.mydsa.leetcodehot;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode(0);
        ListNode current = result;
        ListNode lc1 = l1;
        ListNode lc2 = l2;
        int pro = 0;
        int tmp = 0;
        int val = 0;
        while (lc1 != null && lc2 != null) {
            tmp = lc1.val + lc2.val + pro;
            pro = tmp / 10;
            val = tmp % 10;
            current.next = new ListNode(val);
            current = current.next;
            lc1 = lc1.next;
            lc2 = lc2.next;
        }
        while (lc1 != null) {
            tmp = lc1.val + pro;
            pro = tmp / 10;
            val = tmp % 10;
            current.next = new ListNode(val);
            current = current.next;
            lc1 = lc1.next;
        }
        while (lc2 != null) {
            tmp = lc2.val + pro;
            pro = tmp / 10;
            val = tmp % 10;
            current.next = new ListNode(val);
            current = current.next;
            lc2 = lc2.next;
        }
        if (pro != 0) {
            current.next = new ListNode(pro);
        }
        current = result;
        result = result.next;
        current.next = null;
        current = null;
        return result;
    }

    public static void main(String[] args) {
        int[] l1 = new int[]{9, 9, 9, 9, 9, 9, 9};
//        int[] l1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] l2 = new int[]{9, 9, 9, 9};
//        int[] l2 = new int[]{0, 0, 0, 0};
        ListNode ln1 = new ListNode(l1[0]);
        ListNode lc1 = ln1;
        ListNode ln2 = new ListNode(l2[0]);
        ListNode lc2 = ln2;
        for (int i = 1; i < l1.length; i++) {
            ln1.next = new ListNode(l1[i]);
            ln1 = ln1.next;
        }
        for (int i = 1; i < l2.length; i++) {
            ln2.next = new ListNode(l2[i]);
            ln2 = ln2.next;
        }

        Solution02 solution02 = new Solution02();
        ListNode listNode = solution02.addTwoNumbers(lc1, lc2);
        System.out.println("--------------------");
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        /*
        while (lc1 != null) {
            System.out.println(lc1.val);
            lc1 = lc1.next;
        }
        System.out.println("------------------------------");
        while (lc2 != null) {
            System.out.println(lc2.val);
            lc2 = lc2.next;
        }
        * */
    }
}
