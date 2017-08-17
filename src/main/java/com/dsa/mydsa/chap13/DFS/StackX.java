package com.dsa.mydsa.chap13.DFS;

/**
 * Created by zhangzhibo on 17-3-3.
 */
class StackX {
//    private int maxSize;
    final private int MAXSIZE = 20;
    private int[] stackArray;
    private int top;

    public StackX() {
        stackArray = new int[MAXSIZE];
        top = -1;
    }

    public void push(int value) {
        stackArray[++top] = value;
    }

    public int pop() {
        return stackArray[top--];
    }

    public int peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == MAXSIZE - 1);
    }
}
