package com.dsa.mydsa.NowCoder.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by zhangzhibo on 17-7-9.
 */
public class No62 {

    public static void main(String[] args) {

        TreeNode a = new TreeNode(8);
        TreeNode b = new TreeNode(6);
        TreeNode c = new TreeNode(10);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(7);
        TreeNode f = new TreeNode(9);
        TreeNode g = new TreeNode(11);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        ArrayList<ArrayList<Integer>> lists = Print(a);
        for (ArrayList list :
                lists) {
            for (Object i :
                    list) {
                System.out.println((Integer) i);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        int toBeprint = 1;
        int nextnodes = 0;
        boolean flag = true;
        stack1.push(pRoot);
        while (!stack1.empty()|| !stack2.empty()) {
            if (flag) {
                TreeNode tmp = stack1.peek();
                if (tmp.left != null) {
                    stack2.push(tmp.left);
                    nextnodes++;
                }
                if (tmp.right != null) {
                    stack2.push(tmp.right);
                    nextnodes++;
                }
                toBeprint--;
                list.add(stack1.pop().val);
            } else {
                TreeNode tmp = stack2.peek();
                if (tmp.right != null) {
                    stack1.push(tmp.right);
                    nextnodes++;
                }
                if (tmp.left != null) {
                    stack1.push(tmp.left);
                    nextnodes++;
                }
                toBeprint--;
                list.add(stack2.pop().val);
            }
            if (toBeprint == 0) {
                result.add(new ArrayList(list));
                list.clear();
                toBeprint = nextnodes;
                nextnodes = 0;
                flag = !flag;
            }
        }
        return result;
    }
}
