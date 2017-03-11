package chap05;

/**
 * Created by Gavin.Stevenson on 2017/3/11.
 */
public class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int iData, double dData) {
        Link newLink = new Link(iData, dData);
        newLink.next = first;
        first = newLink;
    }

    public Link find(int key) {
        Link current = first;
        while (current.iData != key) {
            if (current == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public Link delet(int key) {
        Link current = first;
        Link previous = first;
//      不执行循环两种状况，1、返回null；2、找到了符合条件的当前节点，就存在了current中
        while (current.iData != key) {
            if (current.next == null) {
                return null;
            } else {
//                因为判断条件在while循环上，也就是先判断当前节点是不是满足条件再进入while循环，因此这里表示当前节点不满足条件，记下这个节点，
//                这个节点在下一次while循环就为上一个节点了
                previous = current;
                current = current.next;
            }
        }
        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }

    public void displayList() {
        Link current = first;
        while (current != null) {
            current.disply();
            current = current.next;
        }
        System.out.print(" ");
    }
}
