package chap13.Topo;

/**
 * Created by zhangzhibo on 17-4-18.
 */
class Vertex {
    public char label;
    public boolean wasCheked;

    public Vertex(char label) {
        this.label = label;
        wasCheked = false;
    }
}

class Graph {
    private final int MAX_VERTS = 8;
    private Vertex[] vertexList;
    private int adjMat[][];
    private int nVerts;
    private char sortedArray[];
    int orig_nVerts;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
        sortedArray = new char[MAX_VERTS];
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
    }

    public void displayVertex(int v) {
        System.out.println(vertexList[v].label);
    }

    public void topo() {
        orig_nVerts = nVerts;
        while (nVerts > 0) {
            int currentVertex = noSuccessors();
            if (currentVertex == -1) {
                System.out.println("error ! ");
                return;
            }
            sortedArray[nVerts - 1] = vertexList[currentVertex].label;
            vertexList[currentVertex].wasCheked = true;
            nVerts--;
        }
        System.out.println("Topologically sorted order : ");
        for (int i = 0; i < orig_nVerts; i++) {
            System.out.print(sortedArray[i] + " ");
        }
        System.out.println();
    }

    public int noSuccessors() {
        boolean isEdge;
        for (int row = 0; row < orig_nVerts; row++) {
            isEdge = false;
            if (!vertexList[row].wasCheked) {
                for (int col = 0; col < orig_nVerts; col++) {
                    if (!vertexList[col].wasCheked)
                    {
                        if (adjMat[row][col] > 0) {
                            isEdge = true;
                            break;
                        }
                    }

                }
            }else{
                continue;
            }
            if (!isEdge)
            {
                return row;
            }
        }
        return -1;
    }
    public void displayGraph()
    {
        for (int i = 0; i < adjMat.length; i++) {
            for (int j = 0; j < adjMat[i].length; j++) {
                System.out.print(adjMat[i][j]+ " ");
            }
            System.out.println();
        }
    }


}

public class TopoApp {
    public static void main(String[] args) {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addVertex('F');
        theGraph.addVertex('G');
        theGraph.addVertex('H');
        theGraph.addEdge(0,3);
        theGraph.addEdge(0,4);
        theGraph.addEdge(1,4);
        theGraph.addEdge(2,5);
        theGraph.addEdge(3,6);
        theGraph.addEdge(4,6);
        theGraph.addEdge(5,7);
        theGraph.addEdge(6,7);
        theGraph.displayGraph();
        theGraph.topo();
    }
}
