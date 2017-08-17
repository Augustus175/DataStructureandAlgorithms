package com.dsa.mydsa.chap01a;

/**
 * Created by zhangzhibo on 17-4-30.
 */
public class RemoveRepeatLink {
    public static void main(String[] args) {
        Link mylink = new Link();
        mylink.insert(0);
        mylink.insert(0);
        mylink.insert(3);
        mylink.insert(1);
        mylink.insert(1);
        mylink.insert(7);
        mylink.insert(8);
        mylink.insert(8);

        mylink.display();

        rempveRepeat02(mylink);
        mylink.display();

    }

    public static void rempveRepeat01(Link mylink) {
        Node pre = new Node(-1);
        pre.nextNode = mylink.root;
        Node current = mylink.root;
        Node next = mylink.root;
        while (current != null) {
            next = current.nextNode;
            while (next != null && next.iData == current.iData) {
                next = next.nextNode;
            }
            current.nextNode = next;
            current = next;
        }

    }

    public static void rempveRepeat02(Link mylink) {
        Node pre = new Node(-1);
        Node head = pre;
        pre.nextNode = mylink.root;
        Node current = mylink.root;
        Node next;

        while (current != null) {
            next = current.nextNode;
            if ((next == null) || (current.iData != next.iData)) {
                pre = current;
                current = next;

            } else {
                int tmp = current.iData;
                while ((next != null) && (tmp == next.iData)) {
                    next = next.nextNode;

                }
                pre.nextNode = next;
                current = next;
            }


        }

        if (head.nextNode != mylink.root) {
            mylink.root = head.nextNode;
        }
    }


}
