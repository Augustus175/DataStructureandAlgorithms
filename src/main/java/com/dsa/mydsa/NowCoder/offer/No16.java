package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-6-23.
 */
public class No16 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode phead = head;
        for (int i = 1; i < 5; i++) {
            head.next = new ListNode(i+1);
            head = head.next;
        }
//        while(phead!=null){
//            System.out.println(phead.val);
//            phead = phead.next;
//        }
        System.out.println(FindKthToTail(phead,1).val);
    }
    public static ListNode FindKthToTail(ListNode head,int k) {
        if(head==null||k==0){
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        int tmp = 1;
        while(first.next!=null){
            if(tmp==k){
                break;
            }
            first = first.next;
            tmp++;
        }
        if(tmp<k){
            return null;
        }
        while(first.next!=null){
            first = first.next;
            second = second.next;
        }
        return second;

    }
    public ListNode FindKthToTail2(ListNode head,int k) {
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
