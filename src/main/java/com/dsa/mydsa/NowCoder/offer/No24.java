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

    /**
     *@param pushA 给定的压入序列
     * @param popA 给定的弹出序列
     * @return
     * @j 压入序列的索引值
     * 思路：遍历弹出序列美若当前的栈顶元素不等于弹出序列当前的值说明他不是当前弹出值可能要把要压入的值继续压到堆栈中
     * 如果此时j已经是数组边界了，没有可以再压的值了，那么说明不是弹出序列
     */
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
