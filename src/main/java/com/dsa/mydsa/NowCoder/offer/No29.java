package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-6-26.
 */
public class No29 {
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Convert(pRootOfTree.left);
        if (right == null) {
            left = pRootOfTree;
            right = pRootOfTree;
        } else {
            right.right = pRootOfTree;
            pRootOfTree.left = right;
            right = pRootOfTree;
        }

        Convert(pRootOfTree.right);
        return left;
    }
}
