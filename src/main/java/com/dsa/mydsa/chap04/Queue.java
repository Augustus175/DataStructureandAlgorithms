package com.dsa.mydsa.chap04;

/**
 * Created by zhangzhibo on 17-3-6.
 */
class Queue {
    private int maxSize;
    private long[] queArray;
    private int front ;
    private int rear;
    private int nItems;
    public Queue(int s)
    {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
//    insert和remove环形数组的实现
    public void insert(long j)
    {
        if (rear == maxSize-1)
        {
            rear = -1;
        }
        queArray[++rear] = j;

        nItems++;
    }
    public long remove()
    {
        long tmp = queArray[front++];
        if (front == maxSize)
        {
            front =0;
        }
        nItems--;
        return tmp;
    }
    public long peekFront()
    {
        return queArray[front];
    }
    public  boolean isEmpty()
    {
        return (nItems == 0);
    }

    public  boolean isFull()
    {
        return (nItems == maxSize);
    }
}
