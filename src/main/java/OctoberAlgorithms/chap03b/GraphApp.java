package OctoberAlgorithms.chap03b;

import java.util.Stack;

/**
 * Created by zhangzhibo on 17-6-3.
 */
class Node {
    private char name;
    private boolean isVisited;

    public Node(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public boolean isVisited() {

        return isVisited;
    }
}

class Graph {
    private Node[] nodes;
    private int[][] adjMat;
    private int rank = 0;

    public Graph(int num) {
        nodes = new Node[num];
        adjMat = new int[num][num];
        for (int i = 0; i < num; i++) {
            adjMat[i][i] = 1;
        }
    }

    public void addNodes(char c) {
        Node newNode = new Node(c);
        nodes[rank] = newNode;
        rank++;
    }

    public void addEdge(char start, char end) {
        int s = (int) (start - 65);
        int e = (int) (end - 65);
        adjMat[s][e] = 1;
        adjMat[e][s] = 1;
    }

    public void dsf() {
        Stack<Node> thestack = new Stack<>();
        thestack.push(nodes[0]);
        while (!thestack.isEmpty()) {
            int v = findadjonNode(thestack.peek());
            if (v == -1) {
                thestack.pop();
            } else {
                thestack.push(nodes[v]);
                System.out.print(nodes[v].getName());
                nodes[v].setVisited(true);
            }
        }
        for (int i = 0; i < nodes.length; i++) {
            nodes[i].setVisited(false);
        }
    }

    public int findadjonNode(Node node) {
        int row = (int) (node.getName() - 65);
        for (int i = row; i < nodes.length; i++) {
            if (adjMat[row][i] == 1 && (!nodes[i].isVisited())) {
                return i;
            }

        }
        return -1;
    }
}

public class GraphApp {
    public static void main(String[] args) {
        Graph graph = new Graph(9);
        graph.addNodes('A');
        graph.addNodes('B');
        graph.addNodes('C');
        graph.addNodes('D');
        graph.addNodes('E');
        graph.addNodes('F');
        graph.addNodes('G');
        graph.addNodes('H');
        graph.addNodes('I');
        graph.addEdge('A','B');
        graph.addEdge('A','C');
        graph.addEdge('D','E');
        graph.addEdge('C','D');
        graph.addEdge('D','F');
        graph.addEdge('F','G');
        graph.addEdge('B','H');
        graph.addEdge('A','I');
        graph.dsf();
    }

}
