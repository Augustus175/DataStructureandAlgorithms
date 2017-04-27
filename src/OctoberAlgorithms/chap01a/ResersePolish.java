package OctoberAlgorithms.chap01a;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhangzhibo on 2017/4/27.
 */
class Node {
    private String iData;
    private Node leftChild = null;
    private Node rightChild = null;

    public Node(int String) {
        this.iData = iData;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public String getiData() {
        return this.iData;
    }
    public void displayNode()
    {
        System.out.print(iData+" ");
    }
}

class Tree {
    Node root;

    public void insert(int iData) {
        Node node = new Node(iData);
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node paraent = root;
            while (true) {
                paraent = current;
                if (iData < current.getiData()) {
                    current = current.getLeftChild();
                    if (current == null) {
                        paraent.setLeftChild(node);
                        return;
                    }
                } else {
                    current = current.getRightChild();
                    if (current == null) {
                        paraent.setRightChild(node);
                        return;
                    }
                }
            }
        }

    }

    public void preOrder(Node node) {
        if (node!=null)
        {
            node.displayNode();
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }
    public void midOrder(Node node)
    {
        if (node!=null)
        {
            midOrder(node.getLeftChild());
            node.displayNode();
            midOrder(node.getRightChild());
        }
    }
    public void posOrder(Node node) {
        if (node!=null)
        {
            posOrder(node.getLeftChild());
            posOrder(node.getRightChild());
            node.displayNode();

        }
    }
    public void preOrder()
    {
        this.preOrder(this.root);
    }
    public void midOrder()
    {
        this.midOrder(this.root);
    }
    public void posOrder()
    {
        this.posOrder(this.root);
    }
}

public class ResersePolish {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String tmpstr = new String(str);
        String regex = "\\d*";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        while (m.find()) {
            if (!"".equals(m.group()))

                System.out.println("come here:" + m.group());
        }
    }
}
