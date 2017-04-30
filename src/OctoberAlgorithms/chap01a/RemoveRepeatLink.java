package OctoberAlgorithms.chap01a;

/**
 * Created by zhangzhibo on 17-4-30.
 */
public class RemoveRepeatLink {
    public static void main(String[] args) {
        Link mylink = new Link();
//        mylink.insert(0);
        mylink.insert(0);
        mylink.insert(1);
        mylink.insert(1);
        mylink.insert(7);
        mylink.insert(8);
//        mylink.insert(9);
//        mylink.insert(9);
//        mylink.insert(9);
        mylink.display();
//        rempveRepeat01(mylink);
//        mylink.display();
        rempveRepeat02(mylink);
        mylink.display();

    }

    public static void rempveRepeat01(Link mylink) {
        Node pre = new Node(-1);
        pre.nextNode = mylink.root;
        Node current = mylink.root;
        Node next = mylink.root;
        while(current!=null)
        {
            next = current.nextNode;
            while(next!=null&&next.iData==current.iData)
            {
                next = next.nextNode;
            }
            current.nextNode = next;
            current = next;
        }

    }
    public static void rempveRepeat02(Link mylink) {
        Node pre = new Node(-1);
        pre.nextNode = mylink.root;
        Node current = mylink.root;
        Node next = mylink.root;
        boolean flag = false;
        while(current!=null)
        {
            next = current.nextNode;
            int tmp = current.iData;
            while((next!=null)&&(tmp==next.iData))
            {
                next = next.nextNode;
                flag = true;
            }
//            if((current!=null)&&(current.nextNode!=null)&&(current.iData ==current.nextNode.iData))
            if(!flag)
            {
                pre.nextNode = current;
                pre =current;
            }
            current = next;


        }
        System.out.println(mylink.root.iData);
//        System.out.println(pre.nextNode.iData);
        if (pre.nextNode!=mylink.root)
        {
            mylink.root = pre;
        }
    }


}
