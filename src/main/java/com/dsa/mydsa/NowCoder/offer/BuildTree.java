package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-8-4.
 */
public class BuildTree {
    public static TreeNode buildTree(){
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        root.left = node1;
        TreeNode node2 = new TreeNode(2);
        root.right = node2;
        TreeNode node3 = new TreeNode(3);
        node1.left = node3;
        TreeNode node4 = new TreeNode(4);
        node1.right = node4;
        TreeNode node5 = new TreeNode(5);
        node2.left = node5;
        TreeNode node6 = new TreeNode(6);
        node2.right = node6;
        return  root;
    }
}
