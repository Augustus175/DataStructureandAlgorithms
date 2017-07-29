package NowCoder.offer;

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
        while(t>0){
            if (randaom1()){
                if (!stack.empty()){
                    int a = ncstack.pop();
                    int b = stack.pop();
//                    System.out.println(a+"------->  "+b);
                    if(a!=b){
                        System.out.println(233333);
                    }
                }
            }else{
                int tmp = (int)(Math.random()*10);
                stack.push(tmp);
                ncstack.push(tmp);
            }
            t--;
        }

    }
    public static boolean randaom1(){
        int i = (int) (Math.random()*10);
        if (i>5){
            return true;
        }else{
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

    public void push(Integer node) {
        queue1.offer(node);
    }

    public int pop() {
        if (queue1.size() == 1) {
            return queue1.poll();
        } else if (queue1.isEmpty()) {
            while (!queue2.isEmpty() && queue2.size() != 1) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        } else {
            while (queue1.size() != 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }

    }
}

