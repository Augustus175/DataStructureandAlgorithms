package NowCoder.offer;

import java.util.Stack;

/**
 * Created by zhangzhibo on 17-6-25.
 */
public class No23 {

}
class MinStack{
    Stack<Integer> stack1 = new Stack();
    Stack<Integer> stack2 = new Stack();
    public void push(int node) {
        stack1.push(node);
        if(stack2.empty()){
            stack2.push(node);
        }else{
            if(node>this.min()){
                stack2.push(this.min());
            }else{
                stack2.push(node);
            }
        }

    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
