package NowCoder.offer;

import java.util.Stack;

/**
 * Created by zhangzhibo on 17-6-23.
 */
public class No15 {
    public static void main(String[] args) {

    }
    public static void reOrderArray(int[] array) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            if ((array[i]&1)==0)
            {
                stack2.push(array[i]);
            }else{
                stack1.push(array[i]);
            }
        }
        int k = array.length-1;
        while (!stack2.empty())
        {
           array[k] = stack2.pop();
           k--;
        }
        while (!stack1.empty())
        {
            array[k] = stack1.pop();
            k--;
        }
    }
}
