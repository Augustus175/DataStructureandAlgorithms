package NowCoder.offer;

import java.util.Stack;

/**
 * Created by zhangzhibo on 17-7-14.
 */
public class Solutino {
    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    public static void push(int node) {
        stack1.push(node);

    }

    public static int pop() {
        if(!stack2.empty()){
            return stack2.pop();
        }else{
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        pop();
        pop();
        push(4);
        pop();
        push(5);
        pop();
        pop();
    }
}
