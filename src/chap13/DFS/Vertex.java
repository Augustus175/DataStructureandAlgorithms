package chap13.DFS;

/**
 * Created by zhangzhibo on 17-3-3.
 */
class Vertex {
    public  char lable;
    public  boolean wasVisited;

    public Vertex(char lable) {
        this.lable = lable;
        wasVisited = false;
    }

    public void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }
}
