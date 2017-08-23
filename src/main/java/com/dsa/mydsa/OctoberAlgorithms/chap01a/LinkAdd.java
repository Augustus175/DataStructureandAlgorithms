package com.dsa.mydsa.OctoberAlgorithms.chap01a;

/**
 * Created by zhangzhibo on 2017/4/28.
 */


public class LinkAdd {
    public static void main(String[] args) {
        Link myLink1 = new Link();
        Link myLink2 = new Link();
        myLink1.insert(1);
        myLink1.insert(2);
        myLink1.insert(3);
        myLink2.insert(4);
        myLink2.insert(5);
        myLink2.insert(9);
//        myLink2.insert(7);
        Link resault = linkAdd(myLink1, myLink2);
        resault.display();
    }

    public static Link linkAdd(Link link1, Link link2) {
        Node current1 = link1.root;
        Node pre1 = link1.root;
        Node current2 = link2.root;
        Node pre2 = link2.root;
        Link result = new Link();
        int c = 0;
        while ((current1 != null) && (current2 != null)) {
            int tmp = current1.iData + current2.iData + c;
            result.insert(tmp % 10);
            c = tmp / 10;
            pre1 = current1;
            pre2 = current2;
            current1 = current1.nextNode;
            current2 = current2.nextNode;
        }
        if (current1 == null && current2 == null && c != 0) {
            result.insert(c);
        }
        while (current1 != null) {
            result.insert(current1.iData + c);
            current1 = current1.nextNode;
        }
        while (current2 != null) {
            result.insert(current2.iData + c);
            current2 = current2.nextNode;

        }
        return result;
    }
}



