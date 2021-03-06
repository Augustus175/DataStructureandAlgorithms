package com.dsa.mydsa.NowCoder.offer;

import java.util.Stack;

/**
 * Created by zhangzhibo on 17-6-24.
 */
public class No20 {
    public static void main(String[] args) {
        Stack<Integer>stack = new Stack<>();

    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = doesHasSubtree(root1, root2);
            }
            if (!result) {
                result = HasSubtree(root1.left, root2);
            }
            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    public boolean doesHasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return doesHasSubtree(root1.left, root2.left) && doesHasSubtree(root1.right, root2.right);
    }
}
