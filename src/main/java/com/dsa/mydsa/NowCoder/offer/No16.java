package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-6-23.
 */
public class No16 {
    public ListNode FindKthToTail(ListNode head,int k) {
        int length = 0;
        ListNode current = head;
        while(current!=null)
        {
            length++;
            current = current.next;
        }
        if(k>length)
        {
            return null;
        }
        int index = length -k;
        current = head;
        while(index>0)
        {
            current = current.next;
            index--;
        }
        return current;
    }
}
