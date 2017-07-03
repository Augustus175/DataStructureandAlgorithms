package NowCoder.offer;

/**
 * Created by Gavin.Stevenson on 2017/7/3.
 */
public class No41 {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int nleft = TreeDepth(root.left);
        int nright = TreeDepth(root.right);
        return (nleft > nright ? nleft + 1 : nright + 1);
    }
}
