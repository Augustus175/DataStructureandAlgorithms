package com.dsa.mydsa.chap13.BFS;

/**
 * Created by Gavin.Stevenson on 2017/4/14.
 */
class Queue {
    private int maxSize = 20;
    private int[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue() {

        queArray = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    //    insert和remove环形数组的实现
    public void insert(int j) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = j;

        nItems++;
    }

    public int remove() {
        int tmp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return tmp;
    }

    public int peekFront() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }
}
class Vertex{
    public char label;
    private boolean wasVisited;

    public Vertex(char label) {
        this.label = label;
        this.wasVisited = false;
    }

    public void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }

    public boolean isWasVisited() {
        return wasVisited;
    }
}

class Graph {
    final private int MAX_VERTS = 9;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private Queue theQueue;
    private int nVerts;

    public Graph() {
        this.vertexList = new Vertex[MAX_VERTS];
        this.adjMat = new int[MAX_VERTS][MAX_VERTS];
        this.theQueue = new Queue();
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
    public void bfs()
    {
        vertexList[0].setWasVisited(true);
        displayVertex(0);
        theQueue.insert(0);
        int v2 ;
        while (!theQueue.isEmpty())
        {
            int v1 = theQueue.remove();
            while((v2 = getAdjUnvisitedVertex(v1))!=-1)
            {
                vertexList[v2].setWasVisited(true);
                theQueue.insert(v2);
                displayVertex(v2);
            }


        }
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].setWasVisited(false);
        }
    }
    public int getAdjUnvisitedVertex(int v)
    {
        for (int i = 0; i < nVerts; i++) {
            if (adjMat[v][i]==1 && (!vertexList[i].isWasVisited()))
            {
                return i;
            }
        }
        return -1;
    }
    public void displayGraph(){
        for (int i = 0; i < adjMat.length; i++) {
            for (int j = 0; j < adjMat[i].length; j++) {
                System.out.print(adjMat[i][j]+ " ");
            }
            System.out.println();
        }
    }
}


public class BFSApp {
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
        theGraph.addVertex('I');

        theGraph.addEdge(0, 1);
        theGraph.addEdge(0, 2);
        theGraph.addEdge(0, 3);
        theGraph.addEdge(0, 4);
        theGraph.addEdge(1, 5);
        theGraph.addEdge(5, 7);
        theGraph.addEdge(3, 6);
        theGraph.addEdge(6, 8);
        theGraph.displayGraph();
        System.out.println("Visits : ");
        theGraph.bfs();
        System.out.println();
    }
}
