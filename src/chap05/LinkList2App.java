package chap05;

/**
 * Created by Gavin.Stevenson on 2017/3/11.
 */
public class LinkList2App {
    public static void main(String[] args) {
        LinkList theList = new LinkList();
        theList.insertFirst(1,1.0);
        theList.insertFirst(2,2.0);
        theList.insertFirst(3,3.0);
        theList.insertFirst(4,4.0);
        theList.insertFirst(5,5.0);
        theList.insertFirst(6,6.0);
        theList.insertFirst(7, 7.0);
        theList.displayList();
        System.out.println();
        theList.delet(5);
        theList.displayList();
        System.out.println();
        theList.insertFirst(0, 0.0);
        theList.displayList();


    }
}
