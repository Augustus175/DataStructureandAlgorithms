package NowCoder.offer;

/**
 * Created by Gavin.Stevenson on 2017/7/3.
 */
public class No42 {
//    This is the best version;
    private boolean flag = true;
    public boolean IsBalanced_Solution2(TreeNode root) {
        if(root == null){
            return true;
        }
        getDepth(root);
        return flag;
    }
    public int getDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int nleft = getDepth(root.left);
        int nright = getDepth(root.right);
        int tmp = nleft-nright;
        if(tmp>1||tmp<-1){
            flag = false;
        }
        return (nleft>nright ? nleft+1:nright+1);
    }
//this is the first version.
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
            return true;
        }
        int nleft = TreeDepth(root.left);
        int nright = TreeDepth(root.right);
        int diff = nleft-nright;
        if(diff>1||diff<-1){
            return false;
        }
        return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
    }
    public int TreeDepth(TreeNode root){
        if(root ==  null){
            return 0;
        }
        int nleft = TreeDepth(root.left);
        int nright = TreeDepth(root.right);
        return (nleft> nright ? nleft+1:nright+1);
    }
}
