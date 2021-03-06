package com.dsa.mydsa.NowCoder.offer;

import java.util.ArrayList;

/**
 * Created by zhangzhibo on 17-6-26.
 */
public class No27 {
    public ArrayList<ArrayList<Integer>> pathAll = new ArrayList<ArrayList<Integer>>();
    public ArrayList<Integer> path = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return pathAll;
        }
        target = target - root.val;
        path.add(root.val);
        if (target == 0 && root.left == null && root.right == null) {
            pathAll.add(new ArrayList<Integer>(path));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        path.remove(path.size() - 1);
        return pathAll;
    }
}

/**
 * 这是对上一个代码的进一步分离。将递归体单独拿出来这样结构更清新
 * 这道题本质上是前序遍历，在当前节点做文章
 */
class Another {
    public ArrayList<ArrayList<Integer>> pathAll = new ArrayList<>();
    public ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        docore(root, target);
        return pathAll;
    }

    public void docore(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target = target - root.val;
        if (target == 0 && root.left == null && root.right == null) {
            pathAll.add(new ArrayList<Integer>(path));
        }
//        从左节点进行判断
        docore(root.left, target);
//        从右节点进行判断
        docore(root.right, target);
//        移除当前节点表示这个节点走过了
        path.remove(path.size() - 1);
        return;
    }
}
