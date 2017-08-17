package com.dsa.mydsa.chap04;

/**
 * Created by zhangzhibo on 17-3-3.
 */
class BrStackX {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public BrStackX(int s) {
        maxSize = s;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char value) {
        stackArray[++top] = value;
    }

    public char pop() {
        return stackArray[top--];
    }

    public char peek(char tmp) {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }
}
