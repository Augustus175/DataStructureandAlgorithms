package NowCoder.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangzhibo on 17-6-19.
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class No05 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode next1 = new ListNode(1);
        ListNode next2 = new ListNode(2);
        ListNode next3 = new ListNode(3);
        ListNode next4 = new ListNode(4);
        ListNode next5 = new ListNode(5);
        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        next3.next = next4;
        next4.next = next5;
        ArrayList<Integer> re = new ArrayList<>();
        re = printListFromTailToHead(head);
        for (int i :
                re) {
            System.out.println(i);
        }
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode current = listNode;
        ArrayList<Integer> tmp = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        while (!(current == null)) {
            tmp.add(current.val);
            current = current.next;
        }
        for (int i = tmp.size()-1; i >= 0; i--) {
            result.add(tmp.get(i));

        }
        return result;
    }
// the recursion
    public ArrayList<Integer> result = new ArrayList<>();
    public void reprintnode(ListNode listNode){
        if (listNode==null){
            return;
        }
        reprintnode(listNode.next);
        result.add(listNode.val);
    }
}

