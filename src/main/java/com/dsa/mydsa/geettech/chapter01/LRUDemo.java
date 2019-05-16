package com.dsa.mydsa.geettech.chapter01;

import java.util.*;

public class LRUDemo {
    private Set set;
    private Deque<Integer> deque;
    private int length;
    private int CONTAINT;

    public LRUDemo(int contant) {
        set = new HashSet();
        deque = new LinkedList<>();
        CONTAINT = contant;
    }

    public void push(int node) {
        if (set.contains(node)) {
            set.remove(node);
            deque.remove(node);
            length--;
        }
        if (length >= CONTAINT) {
            int tmp = deque.getLast();
            deque.remove(tmp);
            set.remove(tmp);
            length--;
        }
        deque.addFirst(node);
        set.add(node);
        length++;
    }

    @Override
    public String toString() {
        return deque.toString();
    }

    public static void main(String[] args) {
        LRUDemo lruDemo = new LRUDemo(3);
        for (int i = 0; i < 10; i++) {
            lruDemo.push(i);
            System.out.println(lruDemo);
        }
        lruDemo.push(2);
        System.out.println(lruDemo);
        lruDemo.push(2);
        System.out.println(lruDemo);
        lruDemo.push(1);
        System.out.println(lruDemo);
    }
}
