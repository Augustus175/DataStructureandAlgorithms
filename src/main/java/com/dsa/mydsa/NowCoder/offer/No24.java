package com.dsa.mydsa.NowCoder.offer;

import java.util.Stack;

/**
 * Created by zhangzhibo on 17-6-25.
 */
public class No24 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {4, 3, 5, 1, 2};
        System.out.println(IsPopOrder(a, b));
    }


    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        int i = 0;
        int j = 0;
        int tmp = 0;
        Stack<Integer> stack = new Stack();
        for (; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (j < popA.length && popA[j] == stack.peek()) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }
    public static boolean IsPopOrder2(int [] pushA,int [] popA) {
        if(pushA==null||popA==null||pushA.length==0||popA.length==0){
            return false;
        }
        int j = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0;i<popA.length;i++){
            while(stack.isEmpty()||stack.peek()!=popA[i]){
                if(j==pushA.length){
                    return false;
                }
                stack.push(pushA[j]);
                j++;
            }
            stack.pop();
        }
        return true;

    }
}
