package chap05;

/**
 * Created by zhangzhibo on 17-3-19.
 */
class FirstLastList extends LinkList {
//    private Link first;
    private Link last;

    public FirstLastList() {
        super();
        this.last = null;
//        first = super.getFirst();
    }

    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
        if (isEmpty()) {
            last = newLink;
        }
//        newLink.next = first;
//        newLink.next = super.getFirst();
        newLink.next = super.getFirst();
//        first = newLink;
        super.setFirst(newLink);

    }

    public void insertLast(int id, double dd) {
        Link newLink = new Link(id, dd);
        if (isEmpty()) {
//            first = newLink;
            super.setFirst(newLink);
        } else {
            last.next = newLink;
        }
        last = newLink;
    }
}

class FirstLastApp {
    public static void main(String[] args) {
        FirstLastList theList = new FirstLastList();
        theList.insertFirst(1, 23.5);
        theList.insertFirst(2, 24.5);
        theList.insertFirst(3, 25.5);
        theList.insertFirst(4, 29.5);
        theList.insertFirst(5, 27.5);
        theList.displayList();
        Link f = theList.find(2);
        if (f != null) {
            System.out.println("found it : ");
            f.displayLink();
        } else {
            System.out.println("not found !");
        }
        Link d = theList.delete(2);
        if (d != null) {
            System.out.println("delete it :");
            f.displayLink();
        }
        theList.displayList();
        theList.deleteFirst();
        theList.displayList();
        theList.deleteFirst();
        theList.displayList();
        theList.insertLast(6, 29.6);
        theList.insertLast(7, 29.6);
        theList.displayList();
    }

}
