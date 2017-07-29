package OctoberAlgorithms.chap01a;

import java.util.*;

/**
 * Created by zhangzhibo on 17-5-1.
 */
//class Vertex {
//    public int lable;
//    private boolean wasPrined = false;
//
//    public Vertex(int lable) {
//        this.lable = lable;
//    }
//
//}

class Graph {
    //    List<Vertex> vertexList = new ArrayList<>();
    int[][] adjMat;
    int length;

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


    public List toposort() {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> indegreeMap = new HashMap<>();
        for (int j = 0; j < length; j++) {
            int tmp = 0;
            for (int i = 0; i < length; i++) {
                tmp += adjMat[i][j];
            }
            indegreeMap.put(j, tmp);
            if (tmp == 0) {
                queue.offer(j);
            }
        }
        while (!queue.isEmpty()) {
            int t = queue.poll();
            result.add(t);
            indegreeMap.put(t, -1);
            for (int j = 0; j < length; j++) {
                if (adjMat[t][j] != 0) {
                    indegreeMap.put(j, indegreeMap.get(j) - 1);
                }
            }
            for (int i = 0; i < indegreeMap.size(); i++) {
                if (indegreeMap.get(i) == 0) {
                    queue.offer(i);
                }
            }
        }
        return result;

    }
}

public class TopoSort {
    public static void main(String[] args) {
        Graph thegraph = new Graph(7);
        thegraph.addEdge(0, 1);
        thegraph.addEdge(0, 4);
        thegraph.addEdge(1, 4);
        thegraph.addEdge(1, 2);
        thegraph.addEdge(2, 3);
        thegraph.addEdge(4, 5);
        thegraph.addEdge(5, 2);
        thegraph.addEdge(6, 0);
        List<Integer> result = new ArrayList<>();
        result = thegraph.toposort();
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }


    }


}
