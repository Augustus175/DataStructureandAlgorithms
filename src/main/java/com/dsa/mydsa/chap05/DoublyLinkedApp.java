package com.dsa.mydsa.chap05;

/**
 * Created by zhangzhibo on 17-3-20.
 */
class dLink {
    public long dData;
    public dLink next;
    public dLink previous;

    public dLink(long dData) {
        this.dData = dData;
    }

    public void displayLink() {
        System.out.print("{ " + dData + " }  ");
    }
}


class DoublyLinkList {
    private dLink first;
    private dLink last;

    public DoublyLinkList()


    {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(long dd) {
        dLink newLink = new dLink(dd);
        if (isEmpty()) {
            last = newLink;
        } else {
            first.previous = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(long dd) {
        dLink newLink = new dLink(dd);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
    }

    public dLink deleteFirst() {
        dLink tmp = first;
        if (first.next == null) {
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;
        return tmp;
    }

    public dLink deleteLast() {
        dLink tmp = last;
        if (first.next == null) {
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        return tmp;
    }

    public boolean insertAfter(long key, long dd) {
        dLink newLink = new dLink(dd);
        dLink current = first;
        while (current.dData != key) {
            current = current.next;
            if (current == null) {
                return false;
            }
        }
        if (current == last) {
            newLink.next = null;
            last.next = newLink;
        } else {
            newLink.next = current.next;
            current.next.previous = newLink;
        }
        newLink.previous = current;
        current.next = newLink;
        return true;
    }

    public dLink deleteKey(long key) {
        dLink current = first;
        while (current.dData != key) {
            current = current.next;
            if (current == null) {
                return null;
            }
        }
        if (current == first) {
            first = current.next;
        } else {
            current.previous.next = current.next;
        }
        return current;
    }

    public void displayForward() {
        dLink current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }

    public void displayBackward() {
        dLink current = last;
        while (current != null) {
            current.displayLink();
            current = current.previous;
        }
    }
}


public class DoublyLinkedApp {
    public static void main(String[] args) {
        DoublyLinkList theList = new DoublyLinkList();
        theList.insertFirst(22);
        theList.insertFirst(23);
        theList.insertFirst(24);
        theList.insertFirst(25);
        System.out.println("------------------------------------------------------------------");
        theList.displayForward();
        System.out.println();
        theList.insertLast(11);
        theList.insertLast(12);
        theList.insertLast(13);
        theList.insertLast(14);

        System.out.println("------------------------------------------------------------------");
        theList.displayForward();
        System.out.println();
        System.out.println("------------------------------------------------------------------");
        theList.displayBackward();
        System.out.println();
        theList.deleteFirst();
        System.out.println("------------------------------------------------------------------");
        theList.displayForward();
        System.out.println();
        theList.deleteLast();
        System.out.println("------------------------------------------------------------------");
        theList.displayForward();
        System.out.println();
        theList.deleteKey(11);
        System.out.println("------------------------------------------------------------------");
        theList.displayForward();
        System.out.println();
        System.out.println("------------------------------------------------------------------");
        theList.insertAfter(12,255);
        System.out.println();
        theList.displayForward();
    }
}
