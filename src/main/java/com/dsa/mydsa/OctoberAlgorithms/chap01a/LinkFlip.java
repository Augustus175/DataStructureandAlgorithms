package com.dsa.mydsa.OctoberAlgorithms.chap01a;

/**
 * Created by zhangzhibo on 17-4-29.
 */
public class LinkFlip {
    public static void main(String[] args) {
        Link myLink = new Link();
        myLink.insert(0);
        myLink.insert(1);
        myLink.insert(2);
        myLink.insert(3);
        myLink.insert(4);
        myLink.insert(5);
        myLink.insert(6);
        myLink.insert(7);
        flip(myLink, 0, 7);
        myLink.display();
    }

    public static void flip(Link mylink, int m, int n) {
        Node pre = mylink.root;
        Node current = mylink.root;
        Node next = mylink.root;
        Node tmp = null;
        if (m == 0) {
            pre = new Node(-1);
            pre.nextNode = mylink.root;
        } else {
            for (int i = 0; i < m - 1; i++) {
                pre = pre.nextNode;
            }
        }

        current = pre.nextNode;
        tmp = current;
        pre.nextNode = null;
        for (int i = 0; i <= (n - m); i++) {
            next = current.nextNode;
            current.nextNode = pre.nextNode;
            System.out.println(current.iData);
            pre.nextNode = current;
            current = next;
        }
        if (m == 0) {
            mylink.root = pre.nextNode;
        }
        tmp.nextNode = next;

    }
}
