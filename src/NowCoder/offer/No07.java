package NowCoder.offer;

import java.util.Stack;

/**
 * Created by zhangzhibo on 17-6-20.
 */
public class No07 {
    public static void main(String[] args) {
        Solution queue = new Solution();
        for (int i = 0; i < 6; i++) {
            queue.push(i);
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(queue.pop());
        }

    }
}

class Solution {
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

}
