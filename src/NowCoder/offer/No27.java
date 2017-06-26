package NowCoder.offer;

import java.util.ArrayList;

/**
 * Created by zhangzhibo on 17-6-26.
 */
public class No27 {
    public ArrayList<ArrayList<Integer>> pathAll = new ArrayList<ArrayList<Integer>>();
    public ArrayList<Integer> path = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root== null){
            return pathAll;
        }
        target = target-root.val;
        path.add(root.val);
        if(target==0&&root.left==null&&root.right==null){
            pathAll.add(new ArrayList<Integer>(path));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        path.remove(path.size()-1);
        return pathAll;
    }
}
