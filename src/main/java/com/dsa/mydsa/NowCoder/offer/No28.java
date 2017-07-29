package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-6-26.
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class No28 {
    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        RandomListNode current = head;
        for (int i = 2; i < 6; i++) {
            RandomListNode newNode = new RandomListNode(i);
           current.next = newNode;
           current = newNode;
        }
        current = head;
        while(current!=null){
            System.out.println(current.label);
            current= current.next;
        }
        RandomListNode newHead =Clone(head);
        while (newHead!=null){
            System.out.println(newHead.label);
            newHead= newHead.next;
        }

    }
    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead==null){
            return null;
        }
        RandomListNode current = pHead;
        RandomListNode next = null;
        while (current != null) {
            next = current.next;
            RandomListNode newNode = new RandomListNode(current.label);
            current.next = newNode;
            newNode.next = next;
            current = next;
        }

        current = pHead;
        RandomListNode current1 = null;
        while (current != null) {
            current1 = current.next;
            next = current1.next;
            if (current.random!=null) {
                current1.random = current.random.next;
            }else{
                current1.random=null;
            }
            current = next;
        }
        current = pHead;
        RandomListNode result = current.next;
        while (current != null) {
            current1 = current.next;
            next = current1.next;
            current.next = next;
            if (next == null) {
                current1.next = null;
            } else {
                current1.next = next.next;
            }
            current = next;
        }

        return result;
    }
}
