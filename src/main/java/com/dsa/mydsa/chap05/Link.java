package com.dsa.mydsa.chap05;

/**
 * Created by zhangzhibo on 17-3-19.
 * Page 141
 */
class Link {
    public int iData;
    public double dData;
    public Link next;

    public Link(int iData, double dData) {
        this.dData = dData;
        this.iData = iData;
    }

    public void displayLink() {
        System.out.print(" {" + iData + ": " + dData + "} ");
    }
}

class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst() {
        Link tmp = first;
        first = first.next;
        return tmp;
    }

    public void setFirst(Link first) {
        this.first = first;
    }

    public Link getFirst() {
        return first;
    }

    //    Page 143
    //   return the first be found  key
    public Link find(int key) {
        Link current = first;
        if (!isEmpty()) {
            while (current.iData != key) {
                if (current.next == null) {
                    return null;
                } else {
                    current = current.next;
                }

            }
        }
        return current;
    }

    public Link delete(int key) {
        Link current = first;
        Link previous = first;
        if (!isEmpty()) {
            while (current.iData != key) {
                if (current.next == null) {
                    return null;
                } else {
                    previous = current;
                    current = current.next;

                }
            }
        }
        if (previous == first) {
            deleteFirst();
        } else {
            previous.next = current.next;
        }
        return current;
    }


    public void displayList() {
        System.out.println("List (firt --> last) :");
        Link current = this.first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println(" ");
    }
    public  void ReversalLink()
    {
        Link current = first.next;
        Link previous = first;
        first.next = null;
        int i = 0;
        while (current != null)
        {
            Link tmp = new Link(current.iData,current.dData);
            tmp.next = previous;
            previous = tmp;
            current = current.next;
        }
        first = previous;
    }
}

class LinkListApp {
    public static void main(String[] args) {
        LinkList theList = new LinkList();
        Link f1 = theList.find(4);
        if (f1 != null) {
            System.out.print("Found the num is ");
            f1.displayLink();
            System.out.println();
        } else {
            System.out.println("can't find the link");
        }
        theList.insertFirst(1, 22.3);
        theList.insertFirst(2, 25.3);
        theList.insertFirst(3, 26.3);
        theList.insertFirst(4, 28.3);
        theList.insertFirst(5, 29.3);
        theList.displayList();
        Link f = theList.find(4);
        if (f != null) {
            System.out.print("Found the num is ");
            f.displayLink();
            System.out.println();
        } else {
            System.out.println("can't find the link");
        }
        Link d = theList.delete(5);
        if (d != null) {

            System.out.print("Delete the num is ");
            d.displayLink();
            System.out.println();
        } else {
            System.out.print("Can't found the num ");
        }
//        while (!theList.isEmpty()) {
//            Link aLinlk = theList.deleteFirst();
//            System.out.print("Deleted : ");
//            aLinlk.displayLink();
//        }
        System.out.println();
        System.out.println("*****************************");
        theList.displayList();
        System.out.println();
        theList.ReversalLink();
        theList.displayList();

    }
}
