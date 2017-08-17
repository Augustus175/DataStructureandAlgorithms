package com.dsa.mydsa.chap03b;

import java.util.Stack;

/**
 * Created by zhangzhibo on 17-6-5.
 */
class CutNode {
    private char name;
    private boolean isVisited;
    private int low = Integer.MAX_VALUE;
    private int timestam = Integer.MAX_VALUE;

    public CutNode(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public void setTimestam(int timestam) {
        this.timestam = timestam;
    }

    public int getLow() {
        return low;
    }

    public boolean isVisited() {

        return isVisited;
    }
}


class CutGraph {
    private CutNode[] nodes;
    private int[][] adjMat;
    private int rank = 0;

    public CutGraph(int num) {
        nodes = new CutNode[num];
        adjMat = new int[num][num];
        for (int i = 0; i < num; i++) {
            adjMat[i][i] = 1;
        }
    }

    public void addCutNodes(char c) {
        CutNode newCutNode = new CutNode(c);
        nodes[rank] = newCutNode;
        rank++;
    }

    public void addEdge(char start, char end) {
        int s = (int) (start - 65);
        int e = (int) (end - 65);
        adjMat[s][e] = 1;
        adjMat[e][s] = 1;
    }

    public void dsf() {
        Stack<CutNode> thestack = new Stack<>();
        thestack.push(nodes[0]);
        nodes[0].setLow(0);
        int findorder = 0;
        while (!thestack.isEmpty()) {
            int v = findadjonCutNode(thestack.peek());
            if (v == -1) {
                thestack.pop();
            } else {
                thestack.push(nodes[v]);
                nodes[v].setTimestam(findorder);
                findorder++;
                System.out.print(nodes[v].getName());
                nodes[v].setVisited(true);
                setLow(v);
            }
        }
        for (int i = 0; i < nodes.length; i++) {
            nodes[i].setVisited(false);
        }
    }
    public void setLow(int father)
    {
        for (int i = father+1; i <adjMat[father].length; i++) {
            if (adjMat[father][i] ==1&&nodes[i].isVisited())
            {
                for (int j = 0; j < i && j != father; j++) {
                    if (adjMat[i][j] ==1)
                    {
                        int tmp = Math.min(nodes[i].getLow(),nodes[j].getLow());
                        nodes[i].setLow(tmp);
                    }
                }
            }

        }
    }


    public int findadjonCutNode(CutNode node) {
        int row = (int) (node.getName() - 65);
        for (int i = 0; i < nodes.length; i++) {
//            for (int i = row; i < nodes.length; i++) {
            if (adjMat[row][i] == 1 && (!nodes[i].isVisited())) {
                return i;
            }

        }
        return -1;
    }
    public void display()
    {
        for (int i = 0; i < nodes.length; i++) {
            System.out.print(nodes[i].getLow()+" ");
        }
    }
}
public class CutPointApp {
    public static void main(String[] args) {
        CutGraph graph = new CutGraph(6);
        graph.addCutNodes('A');
        graph.addCutNodes('B');
        graph.addCutNodes('C');
        graph.addCutNodes('D');
        graph.addCutNodes('E');
        graph.addCutNodes('F');
        graph.addEdge('A','D');
        graph.addEdge('A','C');
        graph.addEdge('B','C');
        graph.addEdge('B','D');
        graph.addEdge('B','E');
        graph.addEdge('B','F');
        graph.addEdge('E','F');
        graph.dsf();
        graph.display();
    }

}
