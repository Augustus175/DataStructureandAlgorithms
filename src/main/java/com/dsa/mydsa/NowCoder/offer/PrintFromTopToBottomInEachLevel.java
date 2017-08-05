package com.dsa.mydsa.NowCoder.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhangzhibo on 17-8-2.
 */
public class PrintFromTopToBottomInEachLevel {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        root.left = node1;
        TreeNode node2 = new TreeNode(2);
        root.right = node2;
        TreeNode node3 = new TreeNode(3);
        node1.left = node3;
        TreeNode node4 = new TreeNode(4);
        node1.right = node4;
        TreeNode node5 = new TreeNode(5);
        node2.left = node5;
        TreeNode node6 = new TreeNode(6);
        node2.right = node6;
        PrintFromTopToBottom(root);
    }

    public static void PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            System.out.println();
        }
        int currentNum = 1;
        int nextNum = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            System.out.print(tmp.val + " ");
            currentNum--;
            result.add(tmp.val);
            if (tmp.left != null) {
                queue.offer(tmp.left);
                nextNum++;
            }
            if (tmp.right != null) {
                queue.offer(tmp.right);
                nextNum++;
            }
            if (currentNum == 0) {
                System.out.println();
                currentNum = nextNum;
            }
        }
    }
}
