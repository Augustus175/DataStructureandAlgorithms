package chap14.PATH;

/**
 * Created by zhangzhibo on 17-4-24.
 */
class DistPar {
    public int distance;
    public int parentVert;

    public DistPar(int parentVert, int distance) {
        this.distance = distance;
        this.parentVert = parentVert;
    }
}

class Vertex {
    public char label;
    public boolean isInTree;

    public Vertex(char label) {
        this.label = label;
        isInTree = false;
    }
}

class Graph {
    private final int MAX_VERTS = 20;
    private final int INFINITY = 1000000;
    private Vertex[] vertexList;
    private int adjMat[][];
    private int nVerts;
    private int currentVert;
    private DistPar sPath[];
    private int nTree;
    public int startToCurrent;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = INFINITY;
            }
            sPath = new DistPar[MAX_VERTS];
        }
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end, int weight) {
        adjMat[start][end] = weight;
    }

    public void path() {
        int startTree = 0;
        vertexList[startTree].isInTree = true;
        nTree = 1;
        for (int j = 0; j < nVerts; j++) {
            int tempDist = adjMat[startTree][j];
            sPath[j] = new DistPar(startTree, tempDist);
        }
        while (nTree < nVerts) {
            int indexMin = getMin();
            int minDist = sPath[indexMin].distance;
            if (minDist == INFINITY) {
                System.out.println("There are unreachable vertices !");
            } else {
                currentVert = indexMin;
                startToCurrent = sPath[indexMin].distance;
            }
            vertexList[currentVert].isInTree = true;
            nTree++;
            adjust_sPath();
        }
        displayPaths();
        nTree = 0;
        for (int j = 0; j < nVerts; j++) {
            vertexList[j].isInTree = false;
        }
    }

    public void adjust_sPath() {
        int column = 1;
        while (column < nVerts) {
            if (vertexList[column].isInTree) {
                column++;
                continue;
            }
            int currentToFringe = adjMat[currentVert][column];
            int startToFringe = startToCurrent + currentToFringe;
            int sPathDist = sPath[column].distance;
            if (startToFringe < sPathDist) {
                sPath[column].parentVert = currentVert;
                sPath[column].distance = startToFringe;
            }
            column++;
        }
    }


    public int getMin() {
        int minDist = INFINITY;
        int indexMin = 0;
        for (int j = 0; j < nVerts; j++) {
            if (!vertexList[j].isInTree && sPath[j].distance < minDist) {
                minDist = sPath[j].distance;
                indexMin = j;
            }
        }
        return indexMin;
    }

    public void displayPaths() {
        for (int j = 0; j < nVerts; j++) {
            System.out.print(vertexList[j].label + " = ");
            if (sPath[j].distance == INFINITY) {
                System.out.print("inf");
            } else {
                System.out.print(sPath[j].distance);
            }
            char parent = vertexList[sPath[j].parentVert].label;
            System.out.print(" ( " + parent + " ) ");
        }
        System.out.println();
    }

    public void displayVertex(int v) {
        System.out.println(vertexList[v].label);
    }

}


public class PathApp {
    public static void main(String[] args) {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addEdge(0, 1, 50);
        theGraph.addEdge(0, 3, 80);
        theGraph.addEdge(1, 2, 60);
        theGraph.addEdge(1, 3, 90);
        theGraph.addEdge(2, 4, 40);
        theGraph.addEdge(3, 2, 20);
        theGraph.addEdge(3, 4, 70);
        theGraph.addEdge(4, 1, 50);
        System.out.println("Shortest paths : ");
        theGraph.path();
        System.out.println();
    }
}
