package com.dsa.mydsa.other;

import com.dsa.mydsa.leetcodehot.BinarySearch;

class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }
}

public class BinarryTree {
    public void printTreeInMid(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root);
        printTreeInMid(root.getLeft());
        printTreeInMid(root.getRight());
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node00 = new TreeNode(0);
        TreeNode node01 = new TreeNode(1);
        TreeNode node02 = new TreeNode(2);
        TreeNode node03 = new TreeNode(3);
        TreeNode node04 = new TreeNode(4);
        TreeNode node05 = new TreeNode(6);
        TreeNode node06 = new TreeNode(6);
        node01.setLeft(node00);
        node01.setRight(node02);
        root.setLeft(node01);
        root.setRight(node05);
        node05.setLeft(node04);
        node05.setRight(node06);
        BinarryTree binarryTree = new BinarryTree();
        binarryTree.printTreeInMid(root);
    }
}
