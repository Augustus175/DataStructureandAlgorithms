package com.dsa.mydsa.NowCoder.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by zhangzhibo on 17-7-9.
 */
public class No63 {
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
            for (Object i:
                    list) {
                System.out.println((Integer)i);
            }
        }
    }
    public static ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(pRoot ==null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int toBeprint = 1;
        int nextnodes = 0;
        queue.offer(pRoot);
        while(!queue.isEmpty()){
            TreeNode tmp = queue.peek();
            if(tmp.left!=null){
                queue.offer(tmp.left);
                nextnodes++;
            }
            if(tmp.right!=null){
                queue.offer(tmp.right);
                nextnodes++;
            }
            list.add(queue.poll().val);
            toBeprint--;
            if(toBeprint==0){
                result.add(new ArrayList<Integer>(list));
                list.clear();
                toBeprint = nextnodes;
                nextnodes = 0;
            }
        }
        return result;
    }
    public ArrayList<ArrayList<Integer> > Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot==null){
            return result;
        }
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(pRoot);
        while(!stack1.isEmpty()||!stack2.isEmpty()){

            if(!stack1.isEmpty()){
                ArrayList<Integer> re = new ArrayList<>();
                while(!stack1.isEmpty()){
                    TreeNode tmp = stack1.pop();
                    re.add(tmp.val);
                    if(tmp.left!=null){
                        stack2.push(tmp.left);
                    }
                    if(tmp.right!=null){
                        stack2.push(tmp.right);
                    }

                }
                result.add(re);
            }
            if(!stack2.isEmpty()){
                ArrayList<Integer> re = new ArrayList<>();
                while(!stack2.isEmpty()){
                    TreeNode tmp = stack2.pop();
                    re.add(tmp.val);
                    if(tmp.right!=null){
                        stack1.push(tmp.right);
                    }
                    if(tmp.left!=null){
                        stack1.push(tmp.left);
                    }

                }
                result.add(re);
            }
        }
        return result;
    }
}
