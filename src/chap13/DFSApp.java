package chap13;

/**
 * Created by zhangzhibo on 17-3-3.
 */
public class DFSApp {
    public static void main(String[] args) {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
//        theGraph.addVertex('A');
//        theGraph.addVertex('A');
        theGraph.addEdge(0,1);
        theGraph.addEdge(1,2);
        theGraph.addEdge(0,3);
        theGraph.addEdge(3,4);
//        theGraph.addEdge(0,1);
        theGraph.dfs();
    }
}
