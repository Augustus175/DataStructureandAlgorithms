package NowCoder.offer;

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
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (pre[startPre] == in[i]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
            }

        }
        return root;

    }

    public static void posSearch(TreeNode root) {
        if (root != null) {
            posSearch(root.left);
            posSearch(root.right);
            System.out.print(root.val + " ");
        }

    }
}
