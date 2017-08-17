package com.dsa.mydsa.chap13.DFS;

/**
 * Created by zhangzhibo on 17-3-3.
 */
class Graph {
    final private int MAX_VERTS = 20;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private StackX theStack;
    private int nVerts;

    public Graph() {
        this.vertexList = new Vertex[MAX_VERTS];
        this.adjMat = new int[MAX_VERTS][MAX_VERTS];
        this.theStack = new StackX();
        this.nVerts = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }
    public void addEdge(int start,int end)
    {
        adjMat[start][end]= 1;
        adjMat[end][start]= 1;
    }
    public void displayVertex(int v)
    {
        System.out.println(vertexList[v].label);
    }
    public void dfs()
    {
        vertexList[0].setWasVisited(true);
        displayVertex(0);
        theStack.push(0);
        while (!theStack.isEmpty())
        {
            int v = getAdjUnvisitedVertex(theStack.peek());
            if(v == -1)
            {
                theStack.pop();
            }else{

                vertexList[v].setWasVisited(true);
                displayVertex(v);
                theStack.push(v);
            }

        }
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].setWasVisited(false);
        }
    }
    public int getAdjUnvisitedVertex(int v)
    {
        for (int i = 0; i < nVerts; i++) {
            if (adjMat[v][i]==1 && (!vertexList[i].wasVisited))
            {
                return i;
            }


        }
        return -1;
    }
}
