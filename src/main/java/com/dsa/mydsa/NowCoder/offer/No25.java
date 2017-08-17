package com.dsa.mydsa.NowCoder.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhangzhibo on 17-6-25.
 */
public class No25 {
    public static void main(String[] args) {

    }

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        while (queue.size() != 0) {
            TreeNode tmp = queue.peek();
            if (tmp.left != null) {
                queue.offer(tmp.left);
            }
            if (tmp.right != null) {
                queue.offer(tmp.right);
            }
            queue.poll();
            result.add(tmp.val);
        }
        return result;
    }
}
