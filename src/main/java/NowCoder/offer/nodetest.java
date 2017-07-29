package NowCoder.offer;

import java.util.ArrayList;

/**
 * Created by zhangzhibo on 17-7-10.
 */
public class nodetest {
//    public static int index=-1;

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
        print(a);
        String[] str = "8,6,5,$,$,7,$,$,10,9,$,$,11,$,$".split(",");
        TreeNode node = reDeserialize(str,0);
        System.out.println("-------------------------");
        print(node);
    }
    public static TreeNode reDeserialize(String[] strs,Integer index) {
        if (index >= strs.length) {
            return null;
        }
        TreeNode newnode = null;
        if (!strs[index].equals("$")) {
            newnode = new TreeNode(Integer.parseInt(strs[index]));
            newnode.left = reDeserialize(strs,++index);
            newnode.right = reDeserialize(strs,++index);
        }
        return newnode;
    }

    public static void print(TreeNode node) {
        if (node != null) {
            System.out.println(node.val);
            print(node.left);
            print(node.right);
        }
    }
}
