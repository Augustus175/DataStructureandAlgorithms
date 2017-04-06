package chap08;

import java.util.Arrays;

/**
 * Created by Gavin.Stevenson on 2017/4/6.
 */
class Node {
    public int iData;
    public double fData;
    public Node leftChild;
    public Node rightChild;

    public Node(int iData, double fData) {
        this.iData = iData;
        this.fData = fData;
        leftChild = null;
        rightChild = null;
    }

    public void displayNode() {
//        System.out.print("( " + this.iData + " , " + this.fData + " ) ");
        System.out.print("( " + this.iData +  " ) ");
    }

}

class Tree {
    private Node root;

    public Node find(int key) {
        Node current = root;
        while (current.iData != key) {
            if (key < current.iData) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void insert(int id, double dd) {
        Node newNode = new Node(id, dd);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (id < current.iData) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void preOrder(Node localRoot) {
        if (localRoot != null) {
            localRoot.displayNode();
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    public void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            localRoot.displayNode();
            inOrder(localRoot.rightChild);
        }
    }

    public void posOrder(Node localRoot) {
        if (localRoot != null) {
            posOrder(localRoot.leftChild);
            posOrder(localRoot.rightChild);
            localRoot.displayNode();
        }
    }

    public void preOrder() {
        preOrder(this.root);
    }

    public void inOrder() {
        inOrder(this.root);
    }

    public void posOrder() {
        posOrder(this.root);
    }

    public Node minimum() {
        Node current = root;
        Node last = null;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public Node maxmum() {
        Node current = root;
        Node last = null;
        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last;
    }

    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (key != current.iData) {
            parent = current;
            if (key < current.iData) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }
//        current is the node which will be delete.
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {
//       current.leftChild != null
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {

//       current.rightChild != null
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    private Node getSuccessor(Node deletNode) {
        Node successorParent = deletNode;
        Node successor = deletNode;
        Node current = deletNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != deletNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = deletNode.rightChild;
        }
        return successor;
    }
}

public class TreeApp {
    public static void main(String[] args) {
        Tree tree = new Tree();
        int[] IData = new int[20];
        for (int i = 0; i < 20; i++) {
            int iData = (int) (Math.random() * 99)*i;
            IData[i] = iData;
            tree.insert(iData, 0.0);
//            System.out.print("(" + iData + ") ");
        }
        Arrays.sort(IData);
        for (int i = 0; i < IData.length; i++) {
            System.out.print(IData[i]+" ");
        }
        System.out.println();
        System.out.println("-----------------max---------------------------");
        tree.maxmum().displayNode();
        System.out.println();
        System.out.println("-----------------min---------------------------");
        tree.minimum().displayNode();
        System.out.println();
        System.out.println("-----------------pre---------------------------");
        tree.preOrder();
        System.out.println();
        System.out.println("-----------------in----------------------------");
        tree.inOrder();
        System.out.println();
        System.out.println("-----------------pos---------------------------");
        tree.posOrder();
        System.out.println();
        System.out.println("-----------------del1--------------------------");
        System.out.println(IData[5]);
        tree.delete(IData[5]);
        tree.inOrder();
        System.out.println();
        System.out.println("-----------------del2--------------------------");
        System.out.println(IData[6]);
        tree.delete(IData[6]);
        tree.inOrder();
        System.out.println();
        System.out.println("-----------------del3--------------------------");
        System.out.println(IData[10]);
        tree.delete(IData[10]);
        tree.inOrder();
        System.out.println();
        System.out.println("-----------------find--------------------------");
        System.out.println(IData[15]);
        tree.find(IData[0]).displayNode();

    }

}
