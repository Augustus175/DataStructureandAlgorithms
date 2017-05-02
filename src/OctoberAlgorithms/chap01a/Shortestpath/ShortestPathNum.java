package OctoberAlgorithms.chap01a.Shortestpath;

import java.util.*;

/**
 * Created by zhangzhibo on 2017/5/2.
 */


class Graph {
    //    List<Vertex> vertexList = new ArrayList<>();
    int[][] adjMat;
    int length;

//    public void insert(int lable) {
//        Vertex newVertex = new Vertex(lable);
//        vertexList.add(newVertex);
//    }

    public Graph(int length) {
        this.length = length;
        adjMat = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
    }
}

public class ShortestPathNum {
    public static void main(String[] args) {
        int length = 16;
        Graph thgraph = new Graph(length);
        thgraph.addEdge(0, 1);
        thgraph.addEdge(0, 4);
        thgraph.addEdge(1, 5);
        thgraph.addEdge(1, 0);
        thgraph.addEdge(1, 2);
        thgraph.addEdge(2, 1);
        thgraph.addEdge(2, 6);
        thgraph.addEdge(2, 3);
        thgraph.addEdge(3, 2);
        thgraph.addEdge(3, 7);
        thgraph.addEdge(4, 0);
        thgraph.addEdge(4, 5);
        thgraph.addEdge(5, 1);
        thgraph.addEdge(5, 4);
        thgraph.addEdge(5, 6);
        thgraph.addEdge(5, 9);
        thgraph.addEdge(6, 2);
        thgraph.addEdge(6, 5);
        thgraph.addEdge(6, 7);
        thgraph.addEdge(6, 10);
        thgraph.addEdge(7, 3);
        thgraph.addEdge(7, 6);
        thgraph.addEdge(8, 9);
        thgraph.addEdge(8, 12);
        thgraph.addEdge(9, 8);
        thgraph.addEdge(9, 13);
        thgraph.addEdge(9, 10);
        thgraph.addEdge(10, 9);
        thgraph.addEdge(10, 14);
        thgraph.addEdge(10, 11);
        thgraph.addEdge(11, 10);
        thgraph.addEdge(11, 15);
        thgraph.addEdge(12, 8);
        thgraph.addEdge(12, 13);
        thgraph.addEdge(13, 9);
        thgraph.addEdge(13, 12);
        thgraph.addEdge(13, 14);
        thgraph.addEdge(14, 10);
        thgraph.addEdge(14, 13);
        thgraph.addEdge(14, 15);
        thgraph.addEdge(15, 11);
        thgraph.addEdge(15, 14);
        int[] step = new int[length];
        int[] stepNumber = new int[length];
        stepNumber[0] = 1;
        Queue<Integer> thequeue = new LinkedList<Integer>();
        thequeue.offer(0);
        int from;
        int i;
        int s;
        while (!thequeue.isEmpty()) {
            from = thequeue.poll();
            s = step[from] + 1;
            for (i = 1; i < length; i++) {
                if (thgraph.adjMat[from][i] == 1) {
                    if ((step[i] == 0) || (step[i] > s)) {
                        step[i] = s;
                        stepNumber[i] = stepNumber[from] + 1;
                        thequeue.offer(i);
                    } else if(step[i]==s){
                        stepNumber[i]+=stepNumber[from];

                    }
                }
            }
        }
        System.out.println(stepNumber[length-1]);

    }
}