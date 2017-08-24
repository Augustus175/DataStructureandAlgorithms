package com.dsa.mydsa.NowCoder.offer;

import java.util.Stack;

/**
 * Created by zhangzhibo on 17-6-20.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class No06 {
    public static void main(String[] args) {
        int[] pre = {7, 2, 1, 3, 10, 8, 11};
        int[] in = {1, 2, 3, 7, 8, 10, 11};
        TreeNode node = reConstructBinaryTree(pre, in);
        posSearch(node);
        System.out.println();
        posSearch2(node);
        System.out.println();
        preSearch2(node);
        System.out.println();
        preSearch1(node);
        System.out.println();
        minSearch(node);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    /**
     *
     * @param pre 前序数组
     * @param startPre 前序数组的起始位置
     * @param endPre 前序数组的终止位置
     * @param in 中序数组
     * @param startIn 中序数组的起始位置
     * @param endIn 中序数组的终止位置
     * @return 每次递归返回的都是头节点的指针，头节点并没有实际作用只是保持不丢
     */
    public static TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
//        在中序遍历中寻找跟节点，并以此为依据左右划分，左右分别进行递归
        for (int i = startIn; i <= endIn; i++) {
            if (pre[startPre] == in[i]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
            }

        }
        return root;
    }

    /**
     *  后续遍历
     * @param root
     */
    public static void posSearch(TreeNode root) {
        if (root != null) {
            posSearch(root.left);
            posSearch(root.right);
            System.out.print(root.val + " ");
        }

    }
    public static void preSearch1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                System.out.print(root.val + " ");
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    public static void preSearch2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            TreeNode p = null;
            stack.push(root);
            while (!stack.isEmpty()) {
                p = stack.pop();
                System.out.print(p.val + " ");
                if (p.right != null) {
                    stack.push(p.right);
                }
                if (p.left != null) {
                    stack.push(p.left);
                }
            }
        }
    }

    public static void minSearch(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                System.out.print(root.val+" ");
                root = root.right;
            }
        }
    }

    public static void posSearch2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = root;
        stack.push(cur);
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))) {
                System.out.print(cur.val+" ");
                stack.pop();
                pre = cur;
            }else{
                if (cur.right!=null){
                    stack.push(cur.right);
                }
                if (cur.left!=null){
                    stack.push(cur.left);
                }
            }
        }
    }
}
