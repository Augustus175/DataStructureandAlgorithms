package com.dsa.mydsa.NowCoder.offer;

import java.util.ArrayList;

/**
 * Created by zhangzhibo on 17-7-9.
 */
public class No64 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        TreeNode a = new TreeNode(8);
        TreeNode b = new TreeNode(6);
        TreeNode c = new TreeNode(10);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(7);
        TreeNode f = new TreeNode(9);
        TreeNode g = new TreeNode(11);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        System.out.println(Serialize(a));
        TreeNode renode = Deserialize(Serialize(a));
        ArrayList<ArrayList<Integer>> result = No63.Print(renode);
        for (ArrayList lists :
                result) {
            for (Object o :
                    lists) {
                System.out.println(o);
            }
        }
    }

    public static String Serialize(TreeNode root) {
        serialize(root);
        return sb.toString().substring(0, sb.length() - 1);
    }

    public static void serialize(TreeNode root) {
        if (root == null) {
            sb.append("$,");
            return;
        }
        sb.append(root.val);
        sb.append(',');
        serialize(root.left);
        serialize(root.right);
    }

    public static TreeNode Deserialize(String str) {
        String[] strs = str.split(",");
        return reDeserialize(strs);
    }

    public static int index = -1;

    public static TreeNode reDeserialize(String[] strs) {
        index++;
        if (index > strs.length) {
            return null;
        }
        TreeNode newnode = null;
        if (!strs[index].equals("$")) {
            newnode = new TreeNode(Integer.parseInt(strs[index]));
            newnode.left = reDeserialize(strs);
            newnode.right = reDeserialize(strs);
        }
        return newnode;

    }
}
