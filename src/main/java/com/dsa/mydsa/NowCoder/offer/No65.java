package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-7-10.
 */
public class No65 {
    public static void main(String[] args) {

        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(7);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(8);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        midprint(a);
        System.out.println();
        System.out.println(KthNode(a, 4).val);
    }

    public static TreeNode KthNode(TreeNode pRoot, int t) {
        if (pRoot == null || k == 0) {
            return null;
        }
        k = t;
        return dok(pRoot);
    }

    public static int k = 3;

    public static TreeNode dok(TreeNode pRoot) {
        TreeNode target = null;
        if (pRoot.left != null) {
            target = dok(pRoot.left);
        }
        if (target == null) {
            if (k == 1) {
                target = pRoot;
            }
            k--;
        }
        if (target == null && pRoot.right != null) {
            target = dok(pRoot.right);
        }
        return target;
    }

    public static void midprint(TreeNode node) {
        if (node != null) {
            midprint(node.left);
            System.out.print(node.val + " ");
            midprint(node.right);
        }
    }
}
