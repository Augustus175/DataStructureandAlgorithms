package com.dsa.mydsa.chap13.DFS;

/**
 * Created by zhangzhibo on 17-3-3.
 */
class Vertex {
    public  char label;
    public  boolean wasVisited;

    public Vertex(char label) {
        this.label = label;
        wasVisited = false;
    }

    public void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }
}
