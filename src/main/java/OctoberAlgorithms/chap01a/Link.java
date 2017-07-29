package OctoberAlgorithms.chap01a;

/**
 * Created by zhangzhibo on 17-4-29.
 */
class Link {
    public Node root = null;

    public void insert(int iData) {
        Node newNode = new Node(iData);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node pre = root;
            while (current != null) {
                pre = current;
                current = current.nextNode;
            }
            pre.nextNode = newNode;
        }
    }

    public void display() {
        Node current = root;
        while (current != null) {
            System.out.print(current.iData + " ");
            current = current.nextNode;
        }
        System.out.println();
    }
    public int linkLength(){
        int count = 0;
        Node current =root;
        while(current!=null)
        {
            count++;
            current = current.nextNode;
        }
        return count;
    }
}
