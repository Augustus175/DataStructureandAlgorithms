package com.dsa.mydsa.geettech.chapter01;

public class Queue {
    private int length;
    private int[] array;
    private int head;
    private int tail;

    public Queue(int length) {
        this.length = length;
        array = new int[length];
        head = tail = 0;
    }

    public boolean push(int node) {
        if ((tail + 1) % this.length == head) {
            return false;
        }
        array[(tail++) % this.length] = node;
        return true;
    }

    public Integer pop() {
        if (head == tail) {
            return null;
        }
        return array[(head++) % this.length];
    }

    public static void main(String[] args) {
        Queue queue = new Queue(11);
        for (int i = 0; i < 10; i++) {
            queue.push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(queue.pop());
        }
    }
}
