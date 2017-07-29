package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-6-24.
 */
public class No21 {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;

        Mirror(root.left);


        Mirror(root.right);

    }
}
