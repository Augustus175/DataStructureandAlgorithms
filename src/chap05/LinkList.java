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
//      ��ִ��ѭ������״����1������null��2���ҵ��˷��������ĵ�ǰ�ڵ㣬�ʹ�����current��
        while (current.iData != key) {
            if (current.next == null) {
                return null;
            } else {
//                ��Ϊ�ж�������whileѭ���ϣ�Ҳ�������жϵ�ǰ�ڵ��ǲ������������ٽ���whileѭ������������ʾ��ǰ�ڵ㲻������������������ڵ㣬
//                ����ڵ�����һ��whileѭ����Ϊ��һ���ڵ���
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
