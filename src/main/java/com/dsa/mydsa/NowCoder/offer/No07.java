package com.dsa.mydsa.NowCoder.offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by zhangzhibo on 17-6-20.
 */

public class No07 {
    public static void main(String[] args) {
        NcQueue queue = new NcQueue();
//        for (int i = 0; i < 6; i++) {
//            queue.push(i);
//        }
//        for (int i = 0; i < 6; i++) {
//            System.out.println(queue.pop());
//        }
        int t = 200000;
        NcStack ncstack = new NcStack();
        Stack<Integer> stack = new Stack<>();
        while (t > 0) {
            if (randaom1()) {
                if (!stack.empty()) {
                    int a = ncstack.pop();
                    int b = stack.pop();
//                    System.out.println(a+"------->  "+b);
                    if (a != b) {
                        System.out.println(233333);
                    }
                }
            } else {
                int tmp = (int) (Math.random() * 10);
                stack.push(tmp);
                ncstack.push(tmp);
            }
            t--;
        }

    }

    public static boolean randaom1() {
        int i = (int) (Math.random() * 10);
        if (i > 5) {
            return true;
        } else {
            return false;
        }
    }
}

class NcQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        if (stack1.empty()) {
            stack1.push(node);
        } else {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(node);
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
        }
    }

    public int pop() {
        return stack1.pop();
    }

    public void push2(int node) {
        stack1.push(node);

    }

    public int pop2() {
        if (!stack2.empty()) {
            return stack2.pop();
        } else {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}

class NcStack {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    //队列1主插入
    public void push(Integer node) {
        queue1.offer(node);
    }

    //队列2主弹出
    public int pop() {
//        如果队列1中只剩一个元素说明他是最新压入的元素
        if (queue1.size() == 1) {
            return queue1.poll();
        } else if (queue1.isEmpty()) {
//            如果队列1中为空，设队列2中有那个元素，那么将队列2中的n-1个元素移动到队列1中，队列2中最后一个元素就是要弹出的元素
            while (!queue2.isEmpty() && queue2.size() != 1) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        } else {
//            如果队列1中不为空，操作类似第二个if
            while (queue1.size() != 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }
    }
}
//    之所以用两个堆栈模拟队列与用两个队列模拟堆栈不具有对称性，原因是队列始终保持先进先出的特性，顺序是不会改变的
//    而堆栈的顺序是会改变的，每倒腾以此顺序就变了一次

