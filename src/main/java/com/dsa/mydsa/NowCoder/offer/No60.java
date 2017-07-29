package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-7-8.
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class No60 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        TreeLinkNode pnext = null;
        if (pNode.right != null) {
            pnext = pNode.right;
            while (pnext.left != null) {
                pnext = pnext.left;
            }
        } else if (pNode.next != null) {
            TreeLinkNode pcurrent = pNode;
            TreeLinkNode pparent = pNode.next;
            while (pparent != null && pcurrent == pparent.right) {
                pcurrent = pparent;
                pparent = pcurrent.next;
            }
            pnext = pparent;
        }
        return pnext;
    }
}
