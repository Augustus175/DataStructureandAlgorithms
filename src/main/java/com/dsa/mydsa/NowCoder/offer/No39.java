package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by Gavin.Stevenson on 2017/7/3.
 */
public class No39 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int count1 = 0;
        int count2 = 0;
        ListNode current1 = pHead1;
        ListNode current2 = pHead2;
        while (current1 != null) {
            count1++;
            current1 = current1.next;
        }
        while (current2 != null) {
            count2++;
            current2 = current2.next;
        }
        current1 = pHead1;
        current2 = pHead2;
        if (count1 > count2) {
            for (int i = 0; i < count1 - count2; i++) {
                current1 = current1.next;
            }
        } else {
            for (int i = 0; i < count2 - count1; i++) {
                current2 = current2.next;
            }
        }
        while (current1 != null) {
            if (current1 == current2) {
                break;
            } else {
                current1 = current1.next;
                current2 = current2.next;
            }
        }
        return current1;

    }
}
